public class Robot extends Mobs implements EstAttaque{

    Robot(){ super(50,5,6,"robot",1);}

    public void attaque(Humain m){
        /*m.estAttaque(this.getDega());*/
    }

    public void estAttaque(int dega){
        this.PerdPv(dega);
    }


}
