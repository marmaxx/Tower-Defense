import java.util.ArrayList;

public class Map {
    private Cellule [][] map;
    public Cellule[][] getMap(){ return this.map;}

    Map(Cellule[][] map){this.map=map;}

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

    /*public static Cellule[][] mapTest (){
        Cellule [][] cell = new Cellule[3][3];
        for (int i = 0; i < cell.length; i++){
            for (int j = 0; j < cell[0].length; j++){
                cell[i][j] = Cellule.sol(Cellule.Contenu.SABLE);
            }
        }
        return cell;
    }*/

    public Cellule[][] map1 (){
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
        return cell;
    }


    public Cellule[][] map2(){
        Cellule [][] cell = new Cellule[8][9]; 
        contourMap(cell);
        for (int i = 1; i < cell[1].length-2; i++){ cell[1][i] = Cellule.sol(Cellule.Contenu.SABLE);}
        for (int i = 1; i < cell[1].length-2; i++){cell[i][1] = Cellule.sol(Cellule.Contenu.SABLE); cell[i][cell[1].length-2] = Cellule.sol(Cellule.Contenu.SABLE);}
        for (int i = 2; i < cell[1].length-3; i++){ cell[2][i] = Cellule.sol(Cellule.Contenu.EAU); cell[cell[1].length-3][i] = Cellule.sol(Cellule.Contenu.EAU);}
        for (int i = 2; i < cell[1].length-2; i++){cell[i][2] = Cellule.sol(Cellule.Contenu.EAU); cell[i][cell[1].length-3] = Cellule.sol(Cellule.Contenu.EAU);}
        for (int i =3; i< cell[1].length-3; i++){
            for (int j=3; j<cell[1].length-3; j++){
                cell[i][j] = Cellule.sol(Cellule.Contenu.TERRE);
            }
        }
        return cell;
    }

    public static void printColored(Cellule.Contenu c) {
        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_BLUE = "\u001B[34m";
        String ANSI_GREY = "\u001B[90m";
        String ANSI_WHITE = "\u001B[97m";

        switch (c) {
            case ARBRE:  System.out.print(ANSI_GREEN + " x " + ANSI_RESET); break;
            case SABLE:  System.out.print("   "); break;
            case TERRE:  System.out.print(ANSI_WHITE + " ? " + ANSI_RESET);; break;
            case EAU :  System.out.print(ANSI_BLUE + " ≈ " + ANSI_RESET);; break;
            case BASE_IA:  System.out.print(ANSI_RED + " - " + ANSI_RESET);; break;    
            case BASE_HUMAIN:  System.out.print(ANSI_GREY + " - " + ANSI_RESET);; break;
            default:break; 
        }
    }
    

    public void afficher(Cellule [][] c){
        for (int i = 0; i < c.length; i++){
            for (int j = 0; j < c[0].length; j++){
                if (c[i][j] != null){
                    Cellule.Contenu contenu =  c[i][j].getContenu();
                    switch (contenu) {
                        case ARBRE: printColored(Cellule.Contenu.ARBRE); break;
                        case SABLE: printColored(Cellule.Contenu.SABLE); break;
                        case TERRE: printColored(Cellule.Contenu.TERRE); break;
                        case EAU: printColored(Cellule.Contenu.EAU); break;
                        case BASE_IA: printColored(Cellule.Contenu.BASE_IA); break;
                        case BASE_HUMAIN: printColored(Cellule.Contenu.BASE_HUMAIN); break;
                        case NOMBRE: System.out.print(mobsDansCase(i,j)); break;
                        case MOB: System.out.print(afficheMob(i,j)); break;
                        default: break;
                    }
                }
                else { System.out.print("N ");}
            }
            System.out.println();
        }
    }

    private String afficheMob(int i, int j) {
        String type = "";
        for (Mobs mob : MobsSurLaMap.getMobsSurLaMap()){
            if (mob.estDansCase(i, j)) type = mob.getType();
        }
        char c = type.toUpperCase().charAt(0);
        return " "+c+" ";
    }

    private int mobsDansCase(int i, int j) {
        int nombre = 0;
        for (Mobs mob : MobsSurLaMap.getMobsSurLaMap()){
            if (mob.estDansCase(i, j)) nombre++;
        }
        return nombre;
    }

    public void miseAJourMap(){
        if (MobsSurLaMap.getMobsSurLaMap().size() > 0){
            ArrayList<Mobs> mobsDansCase = new ArrayList<>();
            for (int i = 0; i < map.length; i++){
                for (int j = 0; j < map[0].length; j++){
                    for (Mobs mob : MobsSurLaMap.getMobsSurLaMap()){
                        if (mob.estDansCase(i,j)){
                            mobsDansCase.add(mob);
                        }
                    }
                    if (mobsDansCase.size() == 1){ map[i][j] = Cellule.sol(Cellule.Contenu.MOB);}
                    if (mobsDansCase.size() > 1){ map[i][j] = Cellule.sol(Cellule.Contenu.NOMBRE);
                    }
                }
            }
        }
    }

    public static void main (String [] args){
        Cellule [][] cell = new Cellule[7][9];
        Map m = new Map(cell);
        m.contourMap(cell);
        System.out.println("map 2");
        m.map2();
        System.out.println();
        System.out.println("map1 ");
        m.map1();
    }
}
