package com.timetravel.model;
import java.io.Serializable;
public final class PlayerStats implements Serializable {
    private static final long serialVersionUID=1L; private int timeTravels,eventsModified,paradoxesCreated,timelinesCollapsed,highestParadox;
    public int timeTravels(){return timeTravels;} public void traveled(){timeTravels++;} public int eventsModified(){return eventsModified;} public void modified(){eventsModified++;} public int paradoxesCreated(){return paradoxesCreated;} public void paradoxCreated(){paradoxesCreated++;} public int timelinesCollapsed(){return timelinesCollapsed;} public void collapsed(){timelinesCollapsed++;} public int highestParadox(){return highestParadox;} public void recordParadox(int p){highestParadox=Math.max(highestParadox,p);}
}
