public class Tireur extends Mobs  {
    private MobsSurLaMap MobsSurLaMap;

    Tireur(MobsSurLaMap MobsSurLaMap){ super(new Coordonnees(1,6),40,40,3,8,2,"tireur", MobsSurLaMap);}


    @Override
    public void attaque(Humain m){
        /* m.perdPv(this.getDegats());*/
    }


    
}
