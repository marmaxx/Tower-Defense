package Map;
import java.util.LinkedList;

import Humain.Humain;
import Mobs.Mobs;

public class Cellule {
    public enum Contenu { SABLE, EAU, TERRE, ARBRE, BASE_IA, BASE_HUMAIN, NOMBRE, MOB};

    private  Mobs  mobs = null; 
    private boolean disponible;
    private  Humain humain = null;
    private Contenu contenu;

    private LinkedList<Cellule> inRange;

    public boolean getDispo(){ return disponible;}
    public Contenu getContenu(){ return this.contenu;}
    public void setDisponible(boolean dispo){ disponible = dispo;}
    public void setMobs(Mobs mob){ mobs = mob;}
    public Mobs getMobs(){ return this.mobs;}
    public void setHumain(Humain humains){ humain = humains;}
    public Humain getHumain(){ return this.humain;}
    

    public Cellule (Contenu c, boolean dispo){
        this.contenu = c; 
        this.disponible = dispo;
    } 


    public void add(Cellule c){
        this.inRange.add(c);
    }

    public boolean isTerre(){
        return this.contenu == Cellule.Contenu.TERRE;
    }

}