abstract class Mobs {
    private double x, y;
    private int pv, vitesse, degats, vitesseAttaque;
    private String type;

    Mobs(double x, double y, int pv, int vitesse, int degats, String type,int vitesseAttaque){
        this.x = x;
        this.y = y;
        this.pv = pv; 
        this.vitesse = vitesse; 
        this.degats = degats;
        this.type = type;
        this.vitesseAttaque = vitesseAttaque;
    }

    public double getX(){ return this.x;}
    public void setX(double x){ this.x=x;}

    public double getY(){ return this.y;}
    public void setY(double y){ this.y=y;}

    public int getPv(){ return this.pv;}
    public void setPv(int i){ this.pv -= i;};

    public int getVitesse(){return this.vitesse;}

    public int getDegats(){return this.degats;}

    public int getVitesseAttaque(){return this.vitesseAttaque;}
    

    abstract void attaque(Humain m);

    public void perdPv(int i){
        if (this.pv <= i ){ this.pv = 0;} 
        else {this.setPv(i);}
    }
    public boolean estMort(){
        return this.pv ==0; 
    }

    public void mouvement (char direction, Map m){
        switch (direction) {
            case 'g': m.bougerVers(this, this.getX()-1, this.getY(), this.getVitesse()); break;
            case 'h': m.bougerVers(this, this.getX(), this.getY()-1, this.getVitesse()); break;
            case 'd': m.bougerVers(this, this.getX()+1, this.getY(), this.getVitesse()); break;
            default: break;
        }
    }
    


}
