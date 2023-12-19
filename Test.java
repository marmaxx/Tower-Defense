import Humain.Tourelle;
import Jeu.MajMap;
import Jeu.MobsSurLaMap;
import Map.Map;
import Mobs.Robot;

public class Test {

    public static void main(String [] args){
        MobsSurLaMap mslm = new MobsSurLaMap();
        Map m = new Map(mslm);
        System.out.println("map2 ");
        m.map2();
        //m.afficher();

        MajMap maj = new MajMap(m,"map2", mslm);
        maj.pauseTower(5, 5, new Tourelle(10, 2, 0, 3));

        maj.getMapBase().afficher();
        
        Robot r = new Robot(mslm);
        m.miseAJourMap();
        m.afficher();
        //Robot rr = new Robot(mslm);
        maj.update(2000000000);
        m.miseAJourMap();
        m.afficher();
        maj.update(2000000000);
        m.miseAJourMap();
        m.afficher();
    }
    
}
