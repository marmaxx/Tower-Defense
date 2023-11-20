public class Tourelle extends Humain{
    Tourelle(int pv, int degats, int vitesse, int vitesseAttaque){
        super(pv, vitesse, degats, "tourelle", vitesseAttaque);
    }

    @Override
    void attaque(Mobs m) { m.perdPv(this.getDegats());}

    
}
