abstract class Mobs {
    private int pv, vitesse, degats, vitesseAttaque;
    String type;

    Mobs(int pv, int vitesse, int degats, String type,int vitesseAttaque){
        this.pv = pv; 
        this.vitesse = vitesse; 
        this.degats = degats;
        this.type = type;
        this.vitesseAttaque = vitesseAttaque;
    }

    public int getPv(){ return this.pv;}
    public int getVitesse(){return this.vitesse;}
    public int getDegats(){return this.degats;}
    public int getVitesseAttaque(){return this.vitesseAttaque;}
    public void setPv(int i){ this.pv -= i;};

    abstract void attaque(Humain m);

    public void perdPv(int i){
        if (this.pv <= i ){ this.pv = 0;} 
        else {this.setPv(i);}
    }

    public boolean estMort(){
        return this.pv ==0; 
    }
     

    


}
