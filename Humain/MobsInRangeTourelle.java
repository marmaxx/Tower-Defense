package Humain;
import Mobs.Mobs;
import Jeu.MobsSurLaMap;

import java.util.ArrayList;
import java.util.Random;

public class MobsInRangeTourelle implements MobsInRange{

    private Tourelle tourelle;

    public MobsInRangeTourelle(Tourelle tower){
        this.tourelle = tower;
    }

    public ArrayList<Mobs> mobsInrange(){
        ArrayList<Mobs> inRange = new ArrayList<>();
        ArrayList<Mobs> MobsInMaps = MobsSurLaMap.getInstance().getMobsSurLaMap();

        for(Mobs m : MobsInMaps){
            double distance = Math.sqrt(Math.pow(Math.abs(m.getPos().getX()-tourelle.getPos().getX()),2)
            + Math.pow(Math.abs(m.getPos().getY()-tourelle.getPos().getY()),2));
            //System.out.println("distance:" + distance);
            if (distance <= tourelle.getRange()){
            //System.out.println("true");
                inRange.add(m);
            }
        }

        return inRange;
    }

    public void attaque(){
        ArrayList<Mobs> inRange = mobsInrange();
        int nb = inRange.size();
        // System.out.println(nb);
        if (nb != 0 ){
            Random rand = new Random();
            int posInListe = rand.nextInt(nb);
            tourelle.attaque(inRange.get(posInListe));
        }
    }

}
