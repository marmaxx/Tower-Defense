package Mobs;
import Géométrie.Coordonnees;
import Humain.Humain;

public class Sprinteur extends Mobs {

    public Sprinteur(){ super(new Coordonnees(6,1),30,30,5,0,0,"S");}
    

    @Override
    public void attaque(Humain m){
        /*m.perdPv(this.getDegats());*/
    }

}
