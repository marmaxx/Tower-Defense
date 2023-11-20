public class Map {
    public void contourMap(Cellule[][] cell){
        for (int i = 0; i < cell.length; i++){
            for (int j = 0; j < cell[0].length; j++){
                if (i==0){ cell[i][j] = new Cellule("ARBRE");}
                if (i < cell.length-1 && j == 0 || i < cell.length-1 && j == cell[0].length-1){ cell[i][j] = new Cellule("ARBRE");}
                if (i == cell.length-1 && j < 3){ cell[i][j] = new Cellule("BASE_IA");}
                if (i == cell.length-1 && j > cell[0].length-4){ cell[i][j] = new Cellule("BASE_HUMAIN");}
                if (i == cell.length-1 && j >= 3 && j<= cell[0].length-4){ cell[i][j] = new Cellule("ARBRE");}
            }
        }
    }

    public void map1 (){
        Cellule [][] cell = new Cellule[8][9];
        contourMap(cell);
        for (int i = 1; i < cell[1].length-1; i++){
            cell[1][i] = new Cellule("SABLE");
        }
        cell[1][4] = new Cellule("TERRE");
        for (int i = 1; i < cell.length-1; i++){
            cell[i][1] = new Cellule("SABLE");
        }
        for (int i = 1; i < cell.length-1; i++){
            cell[i][3] = new Cellule("SABLE");
        }
        for (int i = 1; i < cell.length-1; i++){
            cell[i][7] = new Cellule("SABLE");
        }
        for (int i = 1; i < cell.length-1; i++){
            cell[i][5] = new Cellule("SABLE");
        }
        for (int i = 2; i < cell.length-1; i++){
            if (i%2==0){ cell[i][2] = new Cellule("TERRE");}
            else{ cell[i][2] = new Cellule("EAU");}
        }
        for (int i = 2; i < cell.length-1; i++){
            if (i%2==0){ cell[i][6] = new Cellule("TERRE");}
            else{ cell[i][6] = new Cellule("EAU");}
        }
        for (int i = 1; i < cell.length-2; i++){
            if (i%2!=0){ cell[i][4] = new Cellule("TERRE");}
            else{ cell[i][4] = new Cellule("EAU");}
        }
        cell[6][4] = new Cellule("SABLE");
        afficher(cell);
    }

    public void map2(){
        Cellule [][] cell = new Cellule[8][9];
    }

    public static void printColoredUnderscore(String s) {
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
        System.out.print(couleur + "_ " + ANSI_RESET);
    }
    

    public void afficher(Cellule [][] c){
        for (int i = 0; i < c.length; i++){
            for (int j = 0; j < c[0].length; j++){
                if (c[i][j] != null){
                    switch (c[i][j].getContenu()) {
                        case "ARBRE": printColoredUnderscore("vert"); break;
                        case "SABLE": printColoredUnderscore("jaune"); break;
                        case "TERRE": printColoredUnderscore("blanc");; break;
                        case "EAU": printColoredUnderscore("bleu");; break;
                        case "BASE_IA": printColoredUnderscore("rouge");; break;
                        case "BASE_HUMAIN": printColoredUnderscore("gris");; break;
                        default: printColoredUnderscore("null");; break;
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
        //m.afficher(cell);
        m.map1();
    }
}
