package com.timetravel.engine;
import com.timetravel.model.*;
public final class TimeTravelEngine {
    private final ParadoxEngine paradox;
    public TimeTravelEngine(ParadoxEngine p){paradox=p;}
    public String travel(SimulationState s,int year){if(year<2000||year>2050)throw new IllegalArgumentException("Year must be between 2000 and 2050.");Timeline t=s.current();int delta=year-t.currentYear();if(delta==0)return "You are already in "+year+".";int cost=Math.max(1,Math.abs(delta)/2);if(cost>s.temporalEnergy())throw new IllegalStateException("Not enough temporal energy (need "+cost+", have "+s.temporalEnergy()+").");s.temporalEnergy(s.temporalEnergy()-cost);t.currentYear(year);s.stats().traveled();int paradoxGain=delta<0?Math.min(12,Math.max(1,Math.abs(delta)/3)):1;TimelineStatus previous=t.status();paradox.applyChange(t,paradoxGain);s.stats().recordParadox(t.paradox());if(t.status()==TimelineStatus.COLLAPSED&&previous!=TimelineStatus.COLLAPSED)s.stats().collapsed();return (delta<0?"Backward":"Forward")+" jump to "+year+"; temporal energy -"+cost+", paradox +"+paradoxGain+".";}
}
