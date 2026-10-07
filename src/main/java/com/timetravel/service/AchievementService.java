package com.timetravel.service;
import com.timetravel.model.*; import java.util.*;
public final class AchievementService {
    private static final Map<String,String> ALL=Map.of("FIRST JUMP","Travel through time for the first time.","BUTTERFLY EFFECT","Create a consequence chain of 5+ events.","TIMELINE ARCHITECT","Create 10 timelines.","PARADOX MASTER","Reach 80+ paradox score and survive.","STABLE FUTURE","Maintain a timeline above 90% stability.","TIME LORD","Complete 15+ time travels.");
    public List<String> update(SimulationState s){Set<String> a=s.achievements();if(s.stats().timeTravels()>0)a.add("FIRST JUMP");if(s.current()!=null&&s.current().consequences().size()>=5)a.add("BUTTERFLY EFFECT");if(s.timelines().size()>=10)a.add("TIMELINE ARCHITECT");if(s.current()!=null&&s.current().paradox()>=80&&s.current().status()!=TimelineStatus.COLLAPSED)a.add("PARADOX MASTER");if(s.current()!=null&&s.current().stability()>=90)a.add("STABLE FUTURE");if(s.stats().timeTravels()>=15)a.add("TIME LORD");return List.copyOf(a);}
    public Map<String,String> all(){return ALL;}
}
