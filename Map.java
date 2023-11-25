public class Map {
    public void contourMap(Cellule[][] cell){
        for (int i = 0; i < cell.length; i++){
            for (int j = 0; j < cell[0].length; j++){
                if (i==0){ cell[i][j] = Cellule.sol(Cellule.Contenu.ARBRE);}
                if (i < cell.length-1 && j == 0 || i < cell.length-1 && j == cell[0].length-1){ cell[i][j] =  Cellule.sol(Cellule.Contenu.ARBRE);}
                if (i == cell.length-1 && j < 3){ cell[i][j] =  Cellule.sol(Cellule.Contenu.BASE_IA);}
                if (i == cell.length-1 && j > cell[0].length-4){ cell[i][j] =  Cellule.sol(Cellule.Contenu.BASE_HUMAIN);}
                if (i == cell.length-1 && j >= 3 && j<= cell[0].length-4){ cell[i][j] =  Cellule.sol(Cellule.Contenu.ARBRE);}
            }
        }
    }

    public void map1 (){
        Cellule [][] cell = new Cellule[8][9];
        contourMap(cell);
        for (int i = 1; i < cell[1].length-1; i++){
            cell[1][i] =  Cellule.sol(Cellule.Contenu.SABLE);
        }
        cell[1][4] =  Cellule.sol(Cellule.Contenu.TERRE);
        for (int i = 1; i < cell.length-1; i++){
            cell[i][1] =  Cellule.sol(Cellule.Contenu.SABLE);
        }
        for (int i = 1; i < cell.length-1; i++){
            cell[i][3] =  Cellule.sol(Cellule.Contenu.SABLE);
        }
        for (int i = 1; i < cell.length-1; i++){
            cell[i][7] = Cellule.sol(Cellule.Contenu.SABLE);
        }
        for (int i = 1; i < cell.length-1; i++){
            cell[i][5] =  Cellule.sol(Cellule.Contenu.SABLE);
        }
        for (int i = 2; i < cell.length-1; i++){
            if (i%2==0){ cell[i][2] =  Cellule.sol(Cellule.Contenu.TERRE);}
            else{ cell[i][2] =  Cellule.sol(Cellule.Contenu.EAU);}
        }
        for (int i = 2; i < cell.length-1; i++){
            if (i%2==0){ cell[i][6] =  Cellule.sol(Cellule.Contenu.TERRE);}
            else{ cell[i][6] =  Cellule.sol(Cellule.Contenu.EAU);}
        }
        for (int i = 1; i < cell.length-2; i++){
            if (i%2!=0){ cell[i][4] =  Cellule.sol(Cellule.Contenu.TERRE);}
            else{ cell[i][4] =  Cellule.sol(Cellule.Contenu.EAU);}
        }
        cell[6][4] = Cellule.sol(Cellule.Contenu.SABLE);
        afficher(cell);
    }


    public void map2(){
        Cellule [][] cell = new Cellule[8][9];
    }

    public static void printColoredSymbole(char symbole, String s) {
        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_BLUE = "\u001B[34m";
        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_GREY = "\u001B[90m";
        String ANSI_WHITE = "\u001B[97m";

        String couleur = "";
        switch (s) {
            case "rouge": couleur = ANSI_RED; break;
            case "vert": couleur = ANSI_GREEN; break;
            case "bleu": couleur = ANSI_BLUE; break;
            case "jaune": couleur = ANSI_YELLOW; break;
            case "gris": couleur = ANSI_GREY; break;
            case "blanc": couleur = ANSI_WHITE; break;
            default: couleur = ANSI_RESET;
        }
        System.out.print(couleur + symbole+" " + ANSI_RESET);
    }
    

    public void afficher(Cellule [][] c){
        for (int i = 0; i < c.length; i++){
            for (int j = 0; j < c[0].length; j++){
                if (c[i][j] != null){
                    Cellule.Contenu contenu =  c[i][j].getContenu();
                    switch (contenu) {
                        case ARBRE: printColoredSymbole('x',"vert"); break;
                        case SABLE: printColoredSymbole(' ', "jaune"); break;
                        case TERRE: printColoredSymbole('_',"blanc");; break;
                        case EAU: printColoredSymbole('~',"bleu");; break;
                        case BASE_IA: printColoredSymbole('|', "rouge"); break;
                        case BASE_HUMAIN: printColoredSymbole('|', "gris");; break;
                        default: break;
                    }
                }
                else { System.out.print("N ");}
            }
            System.out.println();
        }
    }

    public static void main (String [] args){
        Cellule [][] cell = new Cellule[7][9];
        Map m = new Map();
        m.contourMap(cell);
        m.map1();
    }
}
