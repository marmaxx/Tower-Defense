public record Cellule (Contenu c , boolean dispo){
    public enum Contenu { SABLE, EAU, TERRE, ARBRE, BASE_IA, BASE_HUMAIN};

    private static boolean mobs; 
    private static boolean disponible;

    public Contenu getContenu(){ return this.c;}
    public boolean getDispo(){ return disponible;}

    public void setDisponible(boolean dispo){ this.disponible = dispo;}
    public void setMobs(boolean mobs){ this.mobs = mobs;}

}