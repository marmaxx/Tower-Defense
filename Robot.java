public class Robot extends Mobs {

    Robot(){ 
        super(new Coordonnees(6,1),50,50,1,6,1,"robot");
    }

    @Override
    public void attaque(Humain m){
        /*m.perdPv(this.getDegats());*/
    }



}
