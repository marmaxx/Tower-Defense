public class Tireur extends Mobs implements EstAttaque {

    Tireur(){ super(40,3,8,"tireur",2);}

    public void attaque(Humain m){
        /* m.estAttaque(this.getDega());*/
    }

    public void estAttaque(int dega){
        this.PerdPv(dega);
    }

    
}
