package Jeu;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Géométrie.Direction;
import Humain.Humain;
import Humain.MobsInRangeMortier;
import Humain.MobsInRangeTourelle;
import Humain.Mortier;
import Humain.Tourelle;
import Map.Cellule;
import Map.Map;
import Mobs.Mobs;

public class MajMap {
    private Map mapBase;
    private final int hauteur;
    private final int largeur;
    private final String name;
    
    public MajMap (Map mapBase, String name){
        this.mapBase = mapBase; 
        this.hauteur = mapBase.getHauteur();
        this.largeur = mapBase.getLargeur();
        this.name = name;
    }

    public Map getMapBase(){
        return mapBase;
    }

    public void poseTower(Humain tower){
        int x = (int) tower.getPos().getX();
        int y = (int) tower.getPos().getY();
        try {
            mapBase.getMap()[x][y].getDispo();
        }
        catch (Exception e){
            System.out.println("Index hors du tableau de jeu");
        }
        finally {
            if (mapBase.getMap()[x][y].getDispo()){
            mapBase.getMap()[x][y].setDisponible(false);
            TourSurLaMap.getInstance().getTourSurLaMap().add(tower);
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
        LinkedList<Humain> deleteTour = new LinkedList<>();
        LinkedList<Mobs> deleteMobs = new LinkedList<>();

        for(Humain h : TourSurLaMap.getInstance().getTourSurLaMap()){
            if(h.estMort()){ deleteTour.add(h);}
            attaqueLesMobs(h);
        }
        TourSurLaMap.getInstance().getTourSurLaMap().removeAll(deleteTour);

        for (Mobs mob : MobsSurLaMap.getInstance().getMobsSurLaMap()){
            if(mob.estMort()){deleteMobs.add(mob);}
            mouvement(mapBase, mob, deltaT);
        }
        MobsSurLaMap.getInstance().getMobsSurLaMap().removeAll(deleteMobs);
        miseAJourMap();
    }

    public void miseAJourMap(){
        if (MobsSurLaMap.getInstance().getMobsSurLaMap().size() > 0){
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

    public void attaqueLesMobs(Humain h){
        if(h instanceof Tourelle){
            MobsInRangeTourelle range = new MobsInRangeTourelle((Tourelle) h);
            range.attaque();
        } else if(h instanceof Mortier){
            MobsInRangeMortier range = new MobsInRangeMortier((Mortier) h);
            range.attaque();
        }
    }
}
