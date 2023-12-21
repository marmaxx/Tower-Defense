package Humain;
import Géométrie.Coordonnees;
import Mobs.Mobs;

public class Tourelle extends Humain{
    private MobsInRangeTourelle cible = new MobsInRangeTourelle(this);

    public Tourelle(Coordonnees c){
        super(5, "T", 3,10,3,c);
    }

    @Override
    void attaque(Mobs m) { m.perdPv(this.getDegats());}

    public void setCible(MobsInRangeTourelle m){
        this.cible = m;
    }

    public MobsInRangeTourelle getCible(){
        return this.cible;
    }
}
