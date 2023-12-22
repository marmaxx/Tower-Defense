package Mobs;
import Géométrie.Coordonnees;
import Humain.Humain;

public class Tank extends Mobs {

    public Tank(){ super(new Coordonnees(6,1),100, 100, 1,9,3,"Ta");}

    @Override
    public void attaque(Humain m){
        /* m.perdPv(this.getDegats());*/
    }
}
