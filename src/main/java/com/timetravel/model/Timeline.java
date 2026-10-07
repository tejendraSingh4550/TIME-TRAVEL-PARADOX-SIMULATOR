package com.timetravel.model;
import java.io.Serializable;
import java.util.*;
public final class Timeline implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String id, parentId; private final int creationYear; private int currentYear;
    private double stability; private int paradox; private TimelineStatus status;
    private final List<Event> events; private final List<TimelineChange> changes; private final List<Consequence> consequences;
    private final Map<String,Integer> metrics;
    public Timeline(String id,String parentId,int creationYear,int currentYear,double stability,int paradox,TimelineStatus status,List<Event> events,List<TimelineChange> changes,List<Consequence> consequences,Map<String,Integer> metrics){this.id=id;this.parentId=parentId;this.creationYear=creationYear;this.currentYear=currentYear;this.stability=stability;this.paradox=paradox;this.status=status;this.events=new ArrayList<>(events);this.changes=new ArrayList<>(changes);this.consequences=new ArrayList<>(consequences);this.metrics=new LinkedHashMap<>(metrics);}
    public Timeline copy(String newId,String parent){return new Timeline(newId,parent,creationYear,currentYear,stability,paradox,TimelineStatus.ALTERED,events,changes,consequences,metrics);}
    public String id(){return id;} public String parentId(){return parentId;} public int creationYear(){return creationYear;} public int currentYear(){return currentYear;} public void currentYear(int y){currentYear=y;}
    public double stability(){return stability;} public void stability(double s){stability=Math.max(0,Math.min(100,s));} public int paradox(){return paradox;} public void paradox(int p){paradox=Math.max(0,Math.min(100,p));} public TimelineStatus status(){return status;} public void status(TimelineStatus s){status=s;}
    public List<Event> events(){return events;} public List<TimelineChange> changes(){return changes;} public List<Consequence> consequences(){return consequences;} public Map<String,Integer> metrics(){return metrics;}
    public Event event(String id){return events.stream().filter(e->e.id().equalsIgnoreCase(id)).findFirst().orElse(null);}
}
