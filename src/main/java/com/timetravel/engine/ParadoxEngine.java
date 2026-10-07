package com.timetravel.engine;
import com.timetravel.model.*;
public final class ParadoxEngine {
    public record Analysis(int score,int stability,int causalityRisk,String butterfly,TimelineStatus status,int energy){}
    public Analysis analyze(Timeline t,int energy){int score=t.paradox();int stability=(int)Math.round(t.stability());int risk=Math.min(100,score+(100-stability)/2);String butterfly=score>=60?"HIGH":score>=30?"MODERATE":"LOW";TimelineStatus status=score>=90?TimelineStatus.COLLAPSED:score>=70?TimelineStatus.UNSTABLE:t.changes().isEmpty()?TimelineStatus.STABLE:TimelineStatus.ALTERED;return new Analysis(score,stability,risk,butterfly,status,energy);}
    public void applyChange(Timeline t,int impact){t.paradox(Math.min(100,t.paradox()+impact));t.stability(Math.max(0,100-t.paradox()*.65));Analysis a=analyze(t,100);t.status(a.status());}
}
