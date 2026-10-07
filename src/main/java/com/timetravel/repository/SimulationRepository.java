package com.timetravel.repository;

import com.timetravel.model.SimulationState;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface SimulationRepository {
    Path save(SimulationState state, String name) throws IOException;
    SimulationState load(String name) throws IOException, ClassNotFoundException;
    List<String> list() throws IOException;
    boolean delete(String name) throws IOException;
}
