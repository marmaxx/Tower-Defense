package Humain;
import Mobs.Mobs;
import Géométrie.Coordonnees;


public abstract class Humain{
    private int pv, vitesse, degats, vitesseAttaque, cout;
    private String type;
    private int range;
    private Coordonnees pos;


    Humain(int pv, int vitesse, int degats, String type,int vitesseAttaque, int cout, int range,Coordonnees c){
        this.pv = pv; 
        this.vitesse = vitesse; 
        this.degats = degats;
        this.type = type;
        this.vitesseAttaque = vitesseAttaque;
        this.cout = cout;
        this.range = range;
        this.pos = c;
    }

    public int getPv(){ return this.pv;}
    
    public int getVitesse(){ return this.vitesse;}
    
    public int getDegats(){ return this.degats;}
    
    public int getVitesseAttaque(){ return this.vitesseAttaque;}
    
    public void setPv (int i){ this.pv-=i;}

    public int getCout(){ return this.cout;}

    abstract void attaque(Mobs m);

    public void perdPv(int i){
        if (this.pv <= i ){ this.pv = 0;} 
        else { this.setPv(i);}
    }

    public boolean estMort(){ return this.pv ==0;}

    public Coordonnees getPos(){
        return this.pos; 
    }

    public int getRange(){
        return this.range;
    }


}