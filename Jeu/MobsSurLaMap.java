package Jeu;
import java.util.ArrayList;

import Mobs.Mobs;

public class MobsSurLaMap {
    private static ArrayList<Mobs> mobsSurLaMap;

    public MobsSurLaMap (){ mobsSurLaMap = new ArrayList<Mobs>();}

    public static ArrayList<Mobs> getMobsSurLaMap(){ return mobsSurLaMap;}


    public void ajoutMob (Mobs mob){ mobsSurLaMap.add(mob);}
}
