package Jeu;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import Géométrie.Coordonnees;
import Géométrie.Direction;
import Humain.Humain;
import Humain.MobsInRangeMortier;
import Humain.MobsInRangeTourelle;
import Humain.Mortier;
import Humain.Tourelle;
import Map.Map;
import Mobs.Mobs;

public class MajMap {
    private Map mapBase;
    //private final String name;
    private Coordonnees arrivee = new Coordonnees(6, 7);
    
    public MajMap (Map mapBase, String name){
        this.mapBase = mapBase; 
        //this.name = name;
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
        //System.out.print(mob.estAuMilieu()+" ");
        if (mob.estAuMilieu()){
            //System.out.println("pos: "+mob.getPos());
            //System.out.println("nextpos: "+nextPos);
            if (!mob.isSandInFront(mob.getDirection(), m)){
                ArrayList<Direction> dirPossible = new ArrayList<>();
                for (Direction dir : List.of(Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST)){
                    dirPossible.add(dir);
                }
                dirPossible.remove(mob.getDirection());
                dirPossible.remove(dirInverse(mob.getDirection()));
                System.out.println(dirPossible);
                mob.setDirection(Direction.NONE);
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
            if (mob.getPos().getX() == arrivee.getX() && mob.getPos().getY() == arrivee.getY()){
                TimerTask timerTask = new TimerTask(){
                        @Override
                        public void run(){
                            MobsSurLaMap.getInstance().getMobsSurLaMap().remove(mob);
                            System.out.println("did it!");
                            System.out.println(MobsSurLaMap.getInstance().getMobsSurLaMap());
                            Game.setVieBase(Game.getVieBase()-1);
                        }
                    };
                Timer timer = new Timer();
                timer.schedule(timerTask, 0);
            }
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
                        //mapBase.getMap()[i][j] = new Cellule(Cellule.Contenu.MOB,false); 
                        mobsDansCase.clear();
                    }
                    if (mobsDansCase.size() > 1){ 
                        //mapBase.getMap()[i][j] = new Cellule(Cellule.Contenu.NOMBRE,false); 
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
