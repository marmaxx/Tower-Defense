package Humain;

import java.util.ArrayList;

import Jeu.MobsSurLaMap;
import Mobs.Mobs;

public class MobsInRangeMortier {

    private Mortier mortier;

    public MobsInRangeMortier(Mortier mortier){
        this.mortier = mortier;
    }

    public ArrayList<Mobs> mobsInrangeMortier(){
        ArrayList<Mobs> inRange = new ArrayList<>();
        ArrayList<Mobs> MobsInMaps = MobsSurLaMap.getMobsSurLaMap();

        for(Mobs m : MobsInMaps){
            double distance = Math.sqrt(Math.pow(Math.abs(m.getPos().getX()-mortier.getPos().getX()),2)
            + Math.pow(Math.abs(m.getPos().getY()-mortier.getPos().getY()),2));

            if (distance <= mortier.getRange()){
                inRange.add(m);
            }
        }
        return inRange;
    }

    public ArrayList<Mobs> mobsInRangeMobsAttaque(Mobs mob){
        ArrayList<Mobs> inRange = new ArrayList<>();
        ArrayList<Mobs> MobsInRangeMortier = this.mobsInrangeMortier();

        for(Mobs m : MobsInRangeMortier){
            double distance = Math.sqrt(Math.pow(Math.abs(mob.getPos().getX()-m.getPos().getX()),2)
            + Math.pow(Math.abs(mob.getPos().getY()-m.getPos().getY()),2));

            if(distance < 1.5){
                inRange.add(m);
            }
        }
        return inRange;
    }


    public void attaque(){
        ArrayList<Mobs> inRange = this.mobsInrangeMortier();
        int pv = 0; 
        Mobs aAttaquer = null;
        //recherche le mob qui a le plus de pv dans la range du mortier
        for (Mobs m : inRange){
            if (m.getPv() > pv ){
                pv = m.getPv(); 
                aAttaquer = m;
            }
        }

        //recuperation des mobs qui sont autour du mob qui va être attaqué
        ArrayList<Mobs> inAttaqueZone = mobsInRangeMobsAttaque(aAttaquer);
        //attaque le mob avec le plus de pv
        mortier.attaque(aAttaquer);
        //attaque les mobs qui sont autour pour reproduire les degats de zone du mortier
        for(Mobs m : inAttaqueZone){
            if (!m.equals(aAttaquer)){
                mortier.attaqueZone(m);
            }
        }
    }


}