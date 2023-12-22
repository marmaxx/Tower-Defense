package Jeu;
import java.util.ArrayList;
import Humain.Humain;

public class TourSurLaMap {
    private ArrayList<Humain> TourSurLaMap;
    private static final TourSurLaMap INSTANCE = new TourSurLaMap();

    public static TourSurLaMap getInstance(){ return INSTANCE;}

    public TourSurLaMap (){ TourSurLaMap = new ArrayList<Humain>();}

    public ArrayList<Humain> getTourSurLaMap(){ return this.TourSurLaMap;}

    public void reset(){
        MobsSurLaMap.getInstance().getMobsSurLaMap().clear();
    }
}
