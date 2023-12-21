import Géométrie.Coordonnees;
import Humain.Mortier;
import Jeu.MajMap;
import Map.Map;
import Mobs.Robot;

public class Test {

    public static void main(String [] args){
        Map m = new Map();
        System.out.println("map2 ");
        m.map2();

        MajMap maj = new MajMap(m,"map2");
        //Tourelle t = new Tourelle(10, 25, 0, 3, new Coordonnees(5, 5));
        Mortier mo = new Mortier(10,5,0,2,new Coordonnees(5, 5));
        maj.poseTower(mo);

        Robot r = new Robot();
        //System.out.println("Premier affichage:");
        //maj.update(0);
        //m.afficher();
        //Robot rr = new Robot(mslm);
        maj.update(0);
        m.afficher();
        maj.update(1000000000);
        m.afficher();
        System.out.println("pv de r: " +r.getPv());
        maj.update(1000000000);
        m.afficher();
        System.out.println("pv de r: " +r.getPv());
        maj.update(1000000000);
        m.afficher();
        System.out.println("pv de r: " +r.getPv());
        maj.update(1000000000);
        m.afficher();
        System.out.println("pv de r: " +r.getPv());
        maj.update(1000000000);
        m.afficher();
        System.out.println("pv de r: " +r.getPv());
        maj.update(1000000000);
        m.afficher();
        System.out.println("pv de r: " +r.getPv());
        maj.update(1000000000);
        m.afficher();
        System.out.println("pv de r: " +r.getPv());
        maj.update(1000000000);
        m.afficher();
        System.out.println("pv de r: " +r.getPv());
        maj.update(1000000000);
        m.afficher();
        System.out.println("pv de r: " +r.getPv());
        maj.update(1000000000);
        m.afficher();
        System.out.println("pv de r: " +r.getPv());
        maj.update(1000000000);
        m.afficher();
        System.out.println("pv de r: " +r.getPv());
        maj.update(1000000000);
        m.afficher();
        System.out.println("pv de r: " +r.getPv());
        maj.update(1000000000);
        m.afficher();
        System.out.println("pv de r: " +r.getPv());
        maj.update(1000000000);
        m.afficher();
        System.out.println("pv de r: " +r.getPv());
        maj.update(1000000000);
        m.afficher();
        System.out.println("pv de r: " +r.getPv());
        maj.update(1000000000);
        m.afficher();
        System.out.println("pv de r: " +r.getPv());




    }
    
}
