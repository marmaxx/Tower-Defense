package Mobs;
import Géométrie.Coordonnees;
import Humain.Humain;
import Jeu.MobsSurLaMap;

public class Tank extends Mobs {
    private MobsSurLaMap MobsSurLaMap;

    Tank(MobsSurLaMap MobsSurLaMap){ super(new Coordonnees(1,6),100, 100, 1,9,3,"Ta");}

    @Override
    public void attaque(Humain m){
        /* m.perdPv(this.getDegats());*/
    }
}
