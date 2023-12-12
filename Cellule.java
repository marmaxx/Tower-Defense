import Geometrie.Position;

public class Cellule {
    public enum Contenu { SABLE, EAU, TERRE, ARBRE, BASE_IA, BASE_HUMAIN, NOMBRE, MOB};

    private  Mobs  mobs = null; 
    private boolean disponible;
    private  Humain humain = null;
    private Contenu contenu;
    private Position coordonne;

    public boolean getDispo(){ return disponible;}
    public Contenu getContenu(){ return this.contenu;}
    public void setDisponible(boolean dispo){ disponible = dispo;}
    public void setMobs(Mobs mob){ mobs = mob;}
    public Mobs getMobs(){ return this.mobs;}
    public void setHumain(Humain humains){ humain = humains;}
    public Humain getHumain(){ return this.humain;}
    

    Cellule (Contenu c, boolean dispo){
        this.contenu = c; 
        this.disponible = dispo;
    } 
}