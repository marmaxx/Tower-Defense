abstract class Mobs {
    private int pv; 
    private int vitesse; 
    private int dega; 
    private int vitesseAttaque;
    private String type;

    Mobs(int pv, int vitesse, int dega, String type,int vitesseAttaque){
        this.pv = pv; 
        this.vitesse = vitesse; 
        this.dega = dega;
        this.type = type;
        this.vitesseAttaque = vitesseAttaque;
    }

    public int getPv(){
        return this.pv;
    }
    public int getVitesse(){
        return this.vitesse;
    }
    public int getDega(){
        return this.dega;
    }
    public int getVitesseAttaque(){
        return this.vitesseAttaque;
    }

    abstract void attaque(Humain m);

    public void perdPv(int i){
        if (this.pv <= i ){
            this.pv = 0;
        } else {
            this.pv -= i;
        }
    }

    public boolean estMort(){
        return this.pv ==0; 
    }
     

    


}
