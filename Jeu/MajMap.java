package Jeu;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Géométrie.Direction;
import Humain.Humain;
import Map.Cellule;
import Map.Map;
import Mobs.Mobs;

public class MajMap {
    private Map mapBase;
    private final int hauteur;
    private final int largeur;
    private final String name;
    private LinkedList<Cellule> towerList;
    
    public MajMap (Map mapBase, String name){
        this.mapBase = mapBase; 
        this.hauteur = mapBase.getHauteur();
        this.largeur = mapBase.getLargeur();
        this.name = name;
        this.towerList = new LinkedList<>();
    }

    public Map getMapBase(){
        return mapBase;
    }

    public void poseTower(int x ,int y, Humain tower){

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

    public void mouvement(Map m, Mobs mob, long deltaT){
        if (mob.estAuMilieu()){
            
            //System.out.println("pos: "+mob.getPos());
            //System.out.println("nextpos: "+nextPos);
            if (!mob.isSandInFront(mob.getDirection(), m)){
                mob.setDirection(Direction.NONE);
                ArrayList<Direction> dirPossible = new ArrayList<>();
                for (Direction dir : List.of(Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST)){
                    dirPossible.add(dir);
                }
                dirPossible.remove(mob.getDirection());
                for (Direction dir : dirPossible){
                    switch(dir){
                        case NORTH: if (mob.isSandInFront(dir,m)){ mob.setDirection(dir);} break;
                        case EAST: if (mob.isSandInFront(dir,m)){ mob.setDirection(dir);} break;
                        case SOUTH: if (mob.isSandInFront(dir,m)){ mob.setDirection(dir);} break; 
                        case WEST: if (mob.isSandInFront(dir,m)){ mob.setDirection(dir);} break;
                        default: mob.setDirection(Direction.NONE); break;
                    }
                }
            }
            var nextPos = mob.nextPos(deltaT);
            mob.setPos(nextPos.warp(largeur,hauteur));
            //System.out.println(mob.getDirection());
            //System.out.println("pos: "+mob.getPos());
        }
    }

    public void update(long deltaT){
        LinkedList<Cellule> delete = new LinkedList<>();
        for(Cellule c : towerList){
            if(c.getHumain().estMort()){
                delete.add(c);
                c.setHumain(null);
            }
        }
        towerList.removeAll(delete);
        //System.out.println(MobsSurLaMap.getMobsSurLaMap());
        for (Mobs mob : MobsSurLaMap.getInstance().getMobsSurLaMap()){
            mouvement(mapBase, mob, deltaT);
        }
        miseAJourMap();
    }

    public void miseAJourMap(){
        if (MobsSurLaMap..getInstance().getMobsSurLaMap().size() > 0){
            ArrayList<Mobs> mobsDansCase = new ArrayList<>();
            for (int i = 0; i < mapBase.getHauteur(); i++){
                for (int j = 0; j < mapBase.getLargeur(); j++){
                    for (Mobs mob : MobsSurLaMap.getInstance().getMobsSurLaMap()){
                        
                        if (mob.estDansCase(i,j)){
                            mobsDansCase.add(mob);
                        }
                    }
                    if (mobsDansCase.size() == 1){ 
                        mapBase.getMap()[i][j] = new Cellule(Cellule.Contenu.MOB,false); 
                        mobsDansCase.clear();
                    }
                    if (mobsDansCase.size() > 1){ 
                        mapBase.getMap()[i][j] = new Cellule(Cellule.Contenu.NOMBRE,false); 
                        mobsDansCase.clear();
                    }
                }
            }
        }
    }
}
