package Jeu;
import java.util.ArrayList;

import Mobs.Mobs;

public class MobsSurLaMap {
    private ArrayList<Mobs> mobsSurLaMap;
    private static final MobsSurLaMap INSTANCE = new MobsSurLaMap();

    public static MobsSurLaMap getInstance(){ return INSTANCE;}

    public MobsSurLaMap (){ mobsSurLaMap = new ArrayList<Mobs>();}

    public ArrayList<Mobs> getMobsSurLaMap(){ return this.mobsSurLaMap;}


    public void ajoutMob (Mobs mob){ mobsSurLaMap.add(mob);}
}
