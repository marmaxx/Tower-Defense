public class Robot extends Mobs {
    private MobsSurLaMap MobsSurLaMap;

    Robot(MobsSurLaMap MobsSurLaMap){ 
        super(new Coordonnees(6,1),50,50,1,6,1,"R",MobsSurLaMap);
    }

    @Override
    public void attaque(Humain m){
        /*m.perdPv(this.getDegats());*/
    }



}
