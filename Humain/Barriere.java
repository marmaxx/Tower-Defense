package Humain;
import Géométrie.Coordonnees;
import Mobs.Mobs;
public class Barriere extends Humain{

    Barriere(int pv,Coordonnees c) {
        super(pv, 0, 0, "Barrière",0,10,0,c);
    }
    
    @Override
    void attaque(Mobs m) {
        throw new UnsupportedOperationException("Unimplemented method 'attaque'");
    }
    
}
