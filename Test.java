import Géométrie.Coordonnees;
import Humain.MobsInRangeTourelle;
import Humain.MobsInRangeMortier;
import Humain.Tourelle;
import Humain.Mortier;
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
        //Tourelle t = new Tourelle(10, 25, 0, 3, new Coordonnees(4, 3));
        Mortier mo = new Mortier(10,20,0,2,new Coordonnees(4, 3));
        maj.pauseTower(4, 3, mo);

        maj.getMapBase().afficher();
        
        Robot r = new Robot(mslm);
        m.afficher();
        maj.update(2000000000);
        m.afficher();
        Robot rr = new Robot(mslm);
        maj.update(2000000000);

        //t.setcible(new MobsInRangeTourelle(t));
        // System.out.println("pv: " +r.getPv());
        // t.getCible().attaque();
        // System.out.println("pv: " +r.getPv());


        mo.setCible(new MobsInRangeMortier(mo));
        System.out.println("pv de r: " +r.getPv());
        System.out.println("pv de rr: " +rr.getPv());
        mo.getCible().attaque();
        System.out.println("pv de r: " +r.getPv());
        System.out.println("pv de rr: " +rr.getPv());




    }
    
}
