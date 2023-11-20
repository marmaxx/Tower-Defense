public class Sprinteur extends Mobs implements EstAttaque{

    Sprinteur(){ super(30,10,0,"sprinteur",0);}
    
    public void attaque(Humain m){
        /* m.estAttaque(this.getDega());*/
    }

    public void estAttaque(int dega){
        this.PerdPv(dega);
    }
}
