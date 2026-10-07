package com.timetravel.model;
import java.io.Serializable;
import java.util.*;
public final class SimulationState implements Serializable {
    private static final long serialVersionUID=1L; private final Map<String,Timeline> timelines=new LinkedHashMap<>(); private String currentTimelineId; private int temporalEnergy=100; private final long seed; private final PlayerStats stats=new PlayerStats(); private final Set<String> achievements=new LinkedHashSet<>();
    public SimulationState(long seed){this.seed=seed;} public Map<String,Timeline> timelines(){return timelines;} public Timeline current(){return timelines.get(currentTimelineId);} public String currentTimelineId(){return currentTimelineId;} public void currentTimelineId(String id){if(!timelines.containsKey(id))throw new IllegalArgumentException("Unknown timeline: "+id);currentTimelineId=id;} public int temporalEnergy(){return temporalEnergy;} public void temporalEnergy(int e){temporalEnergy=Math.max(0,Math.min(100,e));} public long seed(){return seed;} public PlayerStats stats(){return stats;} public Set<String> achievements(){return achievements;}
}
