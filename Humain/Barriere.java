package Humain;
import Géométrie.Coordonnees;
import Mobs.Mobs;
public class Barriere extends Humain{

    public Barriere(Coordonnees c) {
        super(0,"B",0,10,0,c);
    }
    
    @Override
    void attaque(Mobs m) {
        throw new UnsupportedOperationException("Unimplemented method 'attaque'");
    }
    
}
