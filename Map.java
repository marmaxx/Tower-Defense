import java.util.ArrayList;

public class Map {
    private Cellule [][] map;
    public Cellule[][] getMap(){ return this.map;}

    Map(){}


    public static int getHauteur(){
        return map.length;
    }
    
    public static int getLargeur(){
        return map[1].length;
    }

    public Cellule[][] getMap(){
        return map;
    }



    public void contourMap(Cellule[][] cell){
        for (int i = 0; i < cell.length; i++){
            for (int j = 0; j < cell[0].length; j++){
                if (i==0){ cell[i][j] = new Cellule(Cellule.Contenu.ARBRE,i,j,false);}
                if (i < cell.length-1 && j == 0 || i < cell.length-1 && j == cell[0].length-1){ cell[i][j] =  new Cellule(Cellule.Contenu.ARBRE,i,j,false);}
                if (i == cell.length-1 && j < 3){ cell[i][j] =  new Cellule(Cellule.Contenu.BASE_IA,i,j,false);}
                if (i == cell.length-1 && j > cell[0].length-4){ cell[i][j] =  new Cellule(Cellule.Contenu.BASE_HUMAIN,i,j,false);}
                if (i == cell.length-1 && j >= 3 && j<= cell[0].length-4){ cell[i][j] =  new Cellule(Cellule.Contenu.ARBRE,i,j,false);}
            }
        }
    }

    /*public static Cellule[][] mapTest (){
        Cellule [][] cell = new Cellule[3][3];
        for (int i = 0; i < cell.length; i++){
            for (int j = 0; j < cell[0].length; j++){
                cell[i][j] = new Cellule(Cellule.Contenu.SABLE,i,j,false);
            }
        }
        return cell;
    }*/

    public Cellule[][] map1 (){
        Cellule [][] cell = new Cellule[8][9];
        contourMap(cell);
        for (int i = 1; i < cell[1].length-1; i++){cell[1][i] =  new Cellule(Cellule.Contenu.SABLE,1,i,false);}
        cell[1][4] =  new Cellule(Cellule.Contenu.TERRE, 1, 4, true);
        for (int i = 1; i < cell.length-1; i++){cell[i][1] =  new Cellule(Cellule.Contenu.SABLE,i,4,false);}
        for (int i = 1; i < cell.length-1; i++){cell[i][3] =  new Cellule(Cellule.Contenu.SABLE,i,3,false);}
        for (int i = 1; i < cell.length-1; i++){cell[i][7] = new Cellule(Cellule.Contenu.SABLE,i,7,false);}
        for (int i = 1; i < cell.length-1; i++){cell[i][5] =  new Cellule(Cellule.Contenu.SABLE,i,5,false);}
        for (int i = 2; i < cell.length-1; i++){
            if (i%2==0){ cell[i][2] =  new Cellule(Cellule.Contenu.TERRE, i, 2, true);}
            else{ cell[i][2] =  new Cellule(Cellule.Contenu.EAU,i,2,false);}
        }
        for (int i = 2; i < cell.length-1; i++){
            if (i%2==0){ cell[i][6] =  new Cellule(Cellule.Contenu.TERRE, i, 6, true);}
            else{ cell[i][6] =  new Cellule(Cellule.Contenu.EAU,i,6,false);}
        }
        for (int i = 1; i < cell.length-2; i++){
            if (i%2!=0){ cell[i][4] =  new Cellule(Cellule.Contenu.TERRE, i, 4, true);}
            else{ cell[i][4] =  new Cellule(Cellule.Contenu.EAU,i,4,false);}
        }
        cell[6][4] = Cellule.sol(Cellule.Contenu.SABLE);
        return cell;
    }


    public Cellule[][] map2(){
        Cellule [][] cell = new Cellule[8][9]; 
        contourMap(cell);
        for (int i = 1; i < cell[1].length-2; i++){ cell[1][i] =  new Cellule(Cellule.Contenu.SABLE,1,i,false);}
        for (int i = 1; i < cell[1].length-2; i++){cell[i][1] = new Cellule(Cellule.Contenu.SABLE,i,1,false); cell[i][cell[1].length-2] = new Cellule(Cellule.Contenu.SABLE,i,cell[1].length-2,false);}
        for (int i = 2; i < cell[1].length-3; i++){ cell[2][i] = new Cellule(Cellule.Contenu.EAU,2,i,false); cell[cell[1].length-3][i] = new Cellule(Cellule.Contenu.EAU,cell[1].length-3,i,false);}
        for (int i = 2; i < cell[1].length-2; i++){cell[i][2] = new Cellule(Cellule.Contenu.EAU,i,2,false); cell[i][cell[1].length-3] = new Cellule(Cellule.Contenu.EAU,i,cell[1].length-3,false);}
        for (int i =3; i< cell[1].length-3; i++){
            for (int j=3; j<cell[1].length-3; j++){
                cell[i][j] = new Cellule(Cellule.Contenu.TERRE, i, j, true);
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
    

    public void afficher(){
        System.out.println("    0  1  2  3  4  5  6  7  8 ");
        for (int i = 0; i < getMap().length; i++){
            System.out.print(" " + i + " ");
            for (int j = 0; j < getMap()[0].length; j++){
                if (getMap()[i][j] != null){
                    Cellule.Contenu contenu =  getMap()[i][j].getContenu();
                    switch (contenu) {
                        case ARBRE: printColored(Cellule.Contenu.ARBRE); break;
                        case SABLE: printColored(Cellule.Contenu.SABLE); break;
                        case TERRE: if (getMap()[i][j].getDispo()){
                            printColored(Cellule.Contenu.TERRE);; 
                        } else { 
                            System.out.print(" T ");
                        } break;
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
}
