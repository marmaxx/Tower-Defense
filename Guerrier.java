public class Guerrier extends Humain{
    Guerrier (int pv, int degats, int vitesse, int vitesseAttaque){
        super(pv, vitesse, degats, "guerrier", vitesseAttaque);
    }

    @Override
    void attaque(Mobs m) { m.perdPv(this.getDegats());}
    
}
