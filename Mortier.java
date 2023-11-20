public class Mortier extends Humain{
    Mortier (int pv, int degats, int vitesse, int vitesseAttaque){
        super(pv, vitesse, degats, "mortier", vitesseAttaque);
    }
    @Override
    void attaque(Mobs m) { m.perdPv(this.getDegats());}
    
}
