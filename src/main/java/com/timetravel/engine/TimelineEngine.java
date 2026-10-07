package com.timetravel.engine;
import com.timetravel.model.*; import java.util.*;
public final class TimelineEngine {
    public SimulationState create(long seed){SimulationState s=new SimulationState(seed);Timeline root=new Timeline("T-001",null,2026,2026,100,0,TimelineStatus.STABLE,EventCatalog.defaultEvents(),List.of(),List.of(),new LinkedHashMap<>(Map.of("Population",100,"Economy",72,"Technology",65,"Employment",70,"Energy",60)));s.timelines().put(root.id(),root);s.currentTimelineId(root.id());return s;}
    public Timeline branch(SimulationState s){String id=String.format("T-%03d",s.timelines().size()+1);Timeline child=s.current().copy(id,s.current().id());s.timelines().put(id,child);s.currentTimelineId(id);return child;}
    public List<Timeline> children(SimulationState s,String id){return s.timelines().values().stream().filter(t->Objects.equals(t.parentId(),id)).toList();}
}
