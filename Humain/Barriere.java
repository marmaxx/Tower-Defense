package Humain;
import Mobs.Mobs;
public class Barriere extends Humain{

    Barriere(int pv) {
        super(pv, 0, 0, "Barrière",0,10);
    }
    
    @Override
    void attaque(Mobs m) {
        throw new UnsupportedOperationException("Unimplemented method 'attaque'");
    }
    
}
