public class Tank extends Mobs implements EstAttaque {

    Tank(){ super(100,1,9,"Tank",3);}
    
    public void attaque(Humain m){
        /* m.estAttaque(this.getDega());*/
    }

    public void estAttaque(int dega){
        this.PerdPv(dega);
    }
}
