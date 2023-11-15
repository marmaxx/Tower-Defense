public record Cellule (Cellule.Contenu c){
    public enum Contenu { SABLE, EAU, HERBE}

    public static Cellule sol(Contenu c){
        return new Cellule(c);
    }
}
