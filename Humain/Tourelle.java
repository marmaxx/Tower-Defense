package Humain;
import Mobs.Mobs;

public class Tourelle extends Humain{
    public Tourelle(int pv, int degats, int vitesse, int vitesseAttaque){
        super(pv, vitesse, degats, "tourelle", vitesseAttaque,10);
    }

    @Override
    void attaque(Mobs m) { m.perdPv(this.getDegats());}

    
}
