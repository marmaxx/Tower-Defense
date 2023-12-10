public class MajMap {
    private Map mapBase;
    private final int hauteur;
    private final int largeur;
    private String name;
    


    MajMap (Map mapBase, String name ){
        this.mapBase = mapBase; 
        this.hauteur = Map.getHauteur();
        this.largeur = Map.getLargeur();
        this.name = name;
    }

    public Map getMapBase(){
        return mapBase;
    }

    public void pauseTower(int x ,int y, Humain tower){

        try {
            mapBase.getMap()[x][y].getDispo();
        }
        catch (Exception e){
            System.out.println("Index hors du tableau de jeu");
        }
        finally {
            if (mapBase.getMap()[x][y].getDispo()){
            mapBase.getMap()[x][y].setDisponible(false);
            mapBase.getMap()[x][y].setHumain(true);
            } else { System.out.println("Case non disponible");}
        }
    
}
}
