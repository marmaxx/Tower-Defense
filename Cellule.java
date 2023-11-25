public record Cellule (Contenu c){
    public enum Contenu { SABLE, EAU, TERRE, ARBRE, BASE_IA, BASE_HUMAIN};

    public Contenu getContenu(){ return this.c;}

    public static Cellule sol (Contenu c){ return new Cellule(c);}
}