import java.util.LinkedList;

public class MajMap {
    private Map mapBase;
    private final int hauteur;
    private final int largeur;
    private final String name;
    private LinkedList<Cellule> towerList;
    


    MajMap (Map mapBase, String name ){
        this.mapBase = mapBase; 
        this.hauteur = mapBase.getHauteur();
        this.largeur = mapBase.getLargeur();
        this.name = name;
        this.towerList = new LinkedList<>();
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
            mapBase.getMap()[x][y].setHumain(tower);
            towerList.add(mapBase.getMap()[x][y]);
            } else { System.out.println("Case non disponible");}
        }
    }


    public void update(){

        LinkedList<Cellule> delete = new LinkedList<>();
        for(Cellule c : towerList){
            if(c.getHumain().estMort()){
                delete.add(c);
                c.setHumain(null);
            }
        }
        towerList.removeAll(delete);
    }
}
