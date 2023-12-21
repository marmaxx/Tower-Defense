import Géométrie.Coordonnees;
import Humain.Mortier;
import Humain.MobsInRangeMortier;
import Jeu.MajMap;
import Map.Map;
import Mobs.Robot;

public class Test {

    public static void main(String [] args){
        Map m = new Map();
        System.out.println("map2 ");
        m.map2();
        //m.afficher();

        MajMap maj = new MajMap(m,"map2");
        //Tourelle t = new Tourelle(10, 25, 0, 3, new Coordonnees(4, 3));
        Mortier mo = new Mortier(10,20,0,2,new Coordonnees(4, 3));
        maj.poseTower(4, 3, mo);

        Robot r = new Robot();
        //System.out.println("Premier affichage:");
        //maj.update(0);
        //m.afficher();
        //Robot rr = new Robot(mslm);
        maj.update(0);
        m.afficher();
        maj.update(1000000000);
        m.afficher();
        maj.update(1000000000);
        m.afficher();
        maj.update(1000000000);
        m.afficher();
        maj.update(1000000000);
        m.afficher();
        maj.update(1000000000);
        m.afficher();
        maj.update(1000000000);
        m.afficher();
        maj.update(1000000000);
        m.afficher();
        maj.update(1000000000);
        m.afficher();
        maj.update(1000000000);
        m.afficher();
        maj.update(1000000000);
        m.afficher();
        maj.update(1000000000);
        m.afficher();
        maj.update(1000000000);
        m.afficher();
        maj.update(1000000000);
        m.afficher();
        maj.update(1000000000);
        m.afficher();
        maj.update(1000000000);
        m.afficher();
        maj.update(1000000000);
        m.afficher();
        //m.afficher();
        // maj.update(2000000);
        // m.afficher();
        // maj.update(2000000);
        // m.afficher();
        Robot rr = new Robot();
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
