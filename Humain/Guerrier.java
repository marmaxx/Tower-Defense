package Humain;
import Mobs.Mobs;

public class Guerrier extends Humain{
    Guerrier (int pv, int degats, int vitesse, int vitesseAttaque){
        super(pv, vitesse, degats, "guerrier", vitesseAttaque,10);
    }

    @Override
    void attaque(Mobs m) { m.perdPv(this.getDegats());}
    
}
