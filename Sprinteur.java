public class Sprinteur extends Mobs {
    private MobsSurLaMap MobsSurLaMap;

    Sprinteur(MobsSurLaMap MobsSurLaMap){ super(new Coordonnees(1,6),30,30,10,0,0,"sprinteur", MobsSurLaMap);}
    

    @Override
    public void attaque(Humain m){
        /*m.perdPv(this.getDegats());*/
    }

}
