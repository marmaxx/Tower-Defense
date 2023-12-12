public class Tank extends Mobs {

    Tank(){ super(new Coordonnees(1,6),100, 100, 1,9,3,"Tank");}
    

    @Override
    public void attaque(Humain m){
        /* m.perdPv(this.getDegats());*/
    }
}
