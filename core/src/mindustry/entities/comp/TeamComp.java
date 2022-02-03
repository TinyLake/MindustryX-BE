package mindustry.entities.comp;

import arc.util.*;
import mindustry.annotations.Annotations.*;
import mindustry.game.*;
import mindustry.gen.*;
import mindustry.world.blocks.storage.CoreBlock.*;

import static mindustry.Vars.state;

@Component
abstract class TeamComp implements Posc{
    @Import float x, y;

    Team team = Team.derelict;

    public boolean cheating(){
        return team.rules().cheat;
    }

    @Nullable
    public CoreBuild core(){
        //noinspection RedundantCast
        if(((Teamc)this) instanceof Unitc u && u.isPlayer())
            return u.getPlayer().core();
        return team.core();
    }

    @Nullable
    public CoreBuild closestCore(){
        return state.teams.closestCore(x, y, team);
    }

    @Nullable
    public CoreBuild closestEnemyCore(){
        return state.teams.closestEnemyCore(x, y, team);
    }
}
