package Mobs;
import Géométrie.Coordonnees;
import Humain.Humain;

public class Robot extends Mobs {

    public Robot(){ 
        super(new Coordonnees(6,1),50,50,1,6,1,"R");
    }

    @Override
    public void attaque(Humain m){
        /*m.perdPv(this.getDegats());*/
    }



}
