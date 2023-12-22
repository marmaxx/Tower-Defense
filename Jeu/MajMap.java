package Jeu;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import Géométrie.Coordonnees;
import Géométrie.Direction;
import Humain.Humain;
import Map.Cellule;
import Map.Map;
import Mobs.Mobs;
import Mobs.Robot;

public class MajMap {
    private Map mapBase;
    private final int hauteur;
    private final int largeur;
    private final String name;
    private LinkedList<Cellule> towerList;
    private Coordonnees arrivee = new Coordonnees(6, 7);
    
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
        //System.out.print(mob.estAuMilieu()+" ");
        if (mob.estAuMilieu()){
            //System.out.println("pos: "+mob.getPos());
            //System.out.println("nextpos: "+nextPos);
            if (!mob.isSandInFront(mob.getDirection(), m)){
                System.out.println(mob.getType()+" ICI");
                // if (mob instanceof Robot){ 
                //     int x = (int)Math.floor(mob.getPos().getX());
                //     int y = (int)Math.floor(mob.getPos().getY());
                //     System.out.println("x = "+x+" y = "+y);
                // }
                mob.setDirection(Direction.NONE);
                ArrayList<Direction> dirPossible = new ArrayList<>();
                for (Direction dir : List.of(Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST)){
                    dirPossible.add(dir);
                }
                dirPossible.remove(mob.getDirection());
                dirPossible.remove(dirInverse(mob.getDirection()));
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
            //mob.setPos(nextPos.warp(largeur,hauteur));
        }
        mob.setDirection(mob.getDirection());
        //System.out.println(mob.getDirection()); 
        // System.out.println("pos: "+mob.getPos());
        Coordonnees nextPos = mob.nextPos(deltaT);
        // System.out.println("nextpos: "+nextPos);

        BigDecimal x = new BigDecimal(nextPos.getX());
        BigDecimal y = new BigDecimal(nextPos.getY());
        BigDecimal xArrondi1 = x.setScale(2, RoundingMode.HALF_UP);
        BigDecimal yArrondi1 = y.setScale(2, RoundingMode.HALF_UP);
        double xArrondi2 = xArrondi1.doubleValue();
        double yArrondi2 = yArrondi1.doubleValue();

        mob.setPos(new Coordonnees(xArrondi2,yArrondi2));
        // switch (mob.getType()) {
        //     case "R": System.out.println("ROBOT: "+mob.getPos()+" --> "+nextPos); break;
        //     case "Ta": System.out.println("TANK: "+mob.getPos()+" --> "+nextPos); break;
        //     case "S": System.out.println("SPRINT: "+mob.getPos()+" --> "+nextPos); break;
        //     default:
        //         break;
        // }
        // System.out.println("x="+((mob.getPos().getX())*1000)%10);
        // System.out.println("y="+mob.getPos().getY() *1000%10);
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
        for (Mobs mob : MobsSurLaMap.getInstance().getMobsSurLaMap()){
            mouvement(mapBase, mob, deltaT);
            if (mob.getPos().getX() == arrivee.getX() && mob.getPos().getY() == arrivee.getY()){
                TimerTask timerTask = new TimerTask(){
                        @Override
                        public void run(){
                            MobsSurLaMap.getInstance().getMobsSurLaMap().remove(mob);
                            System.out.println("did it!");
                            System.out.println(MobsSurLaMap.getInstance().getMobsSurLaMap());
                        }
                    };
                Timer timer = new Timer();
                timer.schedule(timerTask, 1000);
            }
        }
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

    public Direction dirInverse (Direction dir){
        Direction d = Direction.NONE;
        switch(dir){
            case NORTH: d = Direction.SOUTH; break;
            case EAST: d = Direction.WEST; break;
            case SOUTH: d = Direction.NORTH; break;
            case WEST: d = Direction.EAST; break;
            default: break;
        }
        return d;
    }
}
