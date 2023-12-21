package Humain;
import Géométrie.Coordonnees;
import Mobs.Mobs;

public class Mortier extends Humain{
    private MobsInRangeMortier cible = new MobsInRangeMortier(this);
    public Mortier (Coordonnees c ){
        super(20, "M", 2,10,10,c);
    }
    @Override
    void attaque(Mobs m) { m.perdPv(this.getDegats());}

    public void attaqueZone(Mobs m) { m.perdPv(getDegats()/2);}

    public MobsInRangeMortier getCible(){
        return this.cible;
    }
    public void setCible(MobsInRangeMortier m){
        this.cible = m;
    }
    
}
