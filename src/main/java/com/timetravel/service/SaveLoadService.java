package com.timetravel.service;
import com.timetravel.model.SimulationState; import com.timetravel.repository.SimulationRepository; import java.io.*; import java.nio.file.*; import java.util.*;
public final class SaveLoadService implements SimulationRepository {
    private final Path directory;
    public SaveLoadService(){this(Path.of("saves"));} public SaveLoadService(Path directory){this.directory=directory;}
    private Path savePath(String name)throws IOException{String file=Path.of(name).getFileName().toString();if(!file.matches("[A-Za-z0-9_-]+(?:\\.ser)?"))throw new IOException("Invalid save name.");if(!file.endsWith(".ser"))file+=".ser";Path base=directory.toAbsolutePath().normalize();Path path=base.resolve(file).normalize();if(!path.startsWith(base))throw new IOException("Invalid save name.");return path;}
    @Override public Path save(SimulationState state,String name)throws IOException{Path path=savePath(name);Files.createDirectories(directory);try(ObjectOutputStream out=new ObjectOutputStream(Files.newOutputStream(path))){out.writeObject(state);}return path;}
    @Override public SimulationState load(String name)throws IOException,ClassNotFoundException{Path path=savePath(name);try(ObjectInputStream in=new ObjectInputStream(Files.newInputStream(path))){in.setObjectInputFilter(info->info.depth()>80||info.references()>100000?ObjectInputFilter.Status.REJECTED:ObjectInputFilter.Status.UNDECIDED);Object value=in.readObject();if(!(value instanceof SimulationState s))throw new IOException("Save file has an unsupported format.");return s;}}
    @Override public List<String> list()throws IOException{if(!Files.exists(directory))return List.of();try(var paths=Files.list(directory)){return paths.filter(p->p.getFileName().toString().endsWith(".ser")).map(p->p.getFileName().toString()).sorted().toList();}}
    @Override public boolean delete(String name)throws IOException{return Files.deleteIfExists(savePath(name));}
}
