import java.util.ArrayList;

public class MobsSurLaMap {
    private ArrayList<Mobs> mobsSurLaMap;

    public MobsSurLaMap (){ mobsSurLaMap = new ArrayList<Mobs>();}

    public ArrayList<Mobs> getMobsSurLaMap(){ return mobsSurLaMap;}

    public void ajoutMob (Mobs mob){ mobsSurLaMap.add(mob);}
}
