import Geometrie.Coordonne;

public class Cellule {
    public enum Contenu { SABLE, EAU, TERRE, ARBRE, BASE_IA, BASE_HUMAIN};

    private static boolean mobs; 
    private boolean disponible;
    private static boolean humain;
    private Contenu contenu;
    private Coordonne coordonne;

    public boolean getDispo(){ return disponible;}
    public Contenu getContenu(){ return this.contenu;}
    public void setDisponible(boolean dispo){ disponible = dispo;}
    public void setMobs(boolean mob){ mobs = mob;}
    public void setHumain(boolean humains){ humain = humains;}

    Cellule (Contenu c, int x, int y, boolean dispo){
        this.contenu = c; 
        this.coordonne = new Coordonne(x, y);
        this.disponible = dispo;
    } 
}