import java.util.ArrayList;

public class MobsSurLaMap {
    private static ArrayList<Mobs> mobsSurLaMap;

    public MobsSurLaMap (){ mobsSurLaMap = new ArrayList<Mobs>();}

    public static ArrayList<Mobs> getMobsSurLaMap(){ return mobsSurLaMap;}

    public static void ajoutMob (Mobs mob){ mobsSurLaMap.add(mob);}
}
