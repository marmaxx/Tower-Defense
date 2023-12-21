package Mobs;

import Géométrie.Coordonnees;
import Géométrie.Direction;
import Humain.Humain;
import Jeu.MobsSurLaMap;
import Map.Cellule;
import Map.Map;

public abstract class Mobs {
    private Coordonnees pos;
    private int pv, pvActuel, vitesse, degats, vitesseAttaque;
    private Direction dir;
    private String type;
    private final Coordonnees positionInitiale = new Coordonnees(1, 6);

    Mobs(Coordonnees pos, int pv, int pvActuel, int vitesse, int degats, int vitesseAttaque, String type){
        this.pos = pos;
        this.pv = pv; 
        this.pvActuel=pvActuel;
        this.vitesse = vitesse; 
        this.degats = degats;
        this.vitesseAttaque = vitesseAttaque;
        this.type = type;
        this.dir = Direction.NORTH;
        try{
            MobsSurLaMap.getInstance().getMobsSurLaMap().add(this);
        }
        catch (Exception e){
            System.out.println("MobsSurLaMap null");
        }
    }

    public Coordonnees getPos(){ return this.pos;}

    public void setPos(Coordonnees newPos){
        this.pos = newPos;
    }

    public Coordonnees getPositionInitiale(){ return this.positionInitiale;}

    public Direction getDirection(){ return this.dir;}

    public void setDirection(Direction dir){ this.dir = dir;}

    public int getPv(){ return this.pv;}
    public void setPv(int i){ this.pv -= i;};

    public int getVitesse(){return this.vitesse;}

    public int getDegats(){return this.degats;}

    public String getType(){ return this.type;}

    public int getVitesseAttaque(){return this.vitesseAttaque;}

    abstract void attaque(Humain m);

    public void perdPv(int i){
        if (this.pv <= i ){ this.pv = 0;} 
        else { this.setPv(i);}
    }
    public boolean estMort(){
        return this.pv == 0; 
    }

    public Coordonnees nextPos(long deltaTNanoSeconds) {
        return this.getPos().plus((switch (getDirection()) {
            case NONE -> Coordonnees.ZERO;
            case NORTH -> Coordonnees.HAUT;
            case EAST -> Coordonnees.DROITE;
            case SOUTH -> Coordonnees.BAS;
            case WEST -> Coordonnees.GAUCHE;
        }).fois(getVitesse() * deltaTNanoSeconds * 1E-9));
    }

    public boolean isSandInFront(Direction dir, Map m){
        boolean b = false;
        int x = (int)Math.abs(getPos().getX());
        int y = (int)Math.abs(getPos().getY());
        //System.out.println("x = "+x+" y = "+y);
        switch(dir){
            case NORTH: if(m.getMap()[x-1][y].getContenu()==Cellule.Contenu.SABLE){ b = true;} break;
            case EAST: if(m.getMap()[x][y+1].getContenu()==Cellule.Contenu.SABLE){ b = true;} break;
            case SOUTH: if(m.getMap()[x+1][y].getContenu()==Cellule.Contenu.SABLE){ b = true;} break; 
            case WEST: if(m.getMap()[x][y-1].getContenu()==Cellule.Contenu.SABLE){ b = true;} break;
            default: b = false;
        }
        return b;
    }

    public boolean estDansCase(int i, int j) {
        return ((getPos().getX() == (i+i+1)/2 && getPos().getY() < j+1 && getPos().getY() >= j) || (getPos().getX() < i+1 && getPos().getX() >= i && getPos().getY() == (j+j+1)/2));
    }

    public boolean estAuMilieu(){
        if (getPos().getX() <= getPos().round().x() + 0.1 && getPos().getX() >= getPos().round().x() - 0.1
                && getPos().getY() <= getPos().round().y() + 0.1 && getPos().getY() >= getPos().round().y() - 0.1) {
            return true;
        } else {
            return false;
        }
    }
}
