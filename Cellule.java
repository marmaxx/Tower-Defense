public record Cellule (Contenu c , boolean dispo){
    public enum Contenu { SABLE, EAU, TERRE, ARBRE, BASE_IA, BASE_HUMAIN, NOMBRE, MOB};


    private static boolean mobs; 
    private static boolean disponible;

    public boolean getDispo(){ return disponible;}
    public Contenu getContenu(){ return this.c;}
    public void setDisponible(boolean dispo){ disponible = dispo;}
    public void setMobs(boolean mob){ mobs = mob;}
    
    public static Cellule sol (Contenu c){ return new Cellule(c,false);}

}