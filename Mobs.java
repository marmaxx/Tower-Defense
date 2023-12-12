import java.util.List;

abstract class Mobs {
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
        MobsSurLaMap.ajoutMob(this);
    }

    public Coordonnees getPos(){ return this.pos;}

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
        return getPos().plus((switch (getDirection()) {
            case NONE -> Coordonnees.ZERO;
            case NORTH -> Coordonnees.HAUT;
            case EAST -> Coordonnees.DROITE;
            case SOUTH -> Coordonnees.BAS;
            case WEST -> Coordonnees.GAUCHE;
        }).fois(getVitesse() * deltaTNanoSeconds * 1E-9));
    }

    public void mouvement(Map m){
        for (Direction dir : List.of(Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST)){
            switch(dir){
                case NORTH: if (isSandInFront(dir,m)){ setDirection(dir);}
                case EAST: if (isSandInFront(dir,m)){ setDirection(dir);}
                case SOUTH: if (isSandInFront(dir,m)){ setDirection(dir);}
                case WEST: if (isSandInFront(dir,m)){ setDirection(dir);}
                default: setDirection(Direction.NONE);
            }
        }
    }

    public boolean isSandInFront(Direction dir, Map m){
        int x = (int)Math.round(getPos().getX());
        int y = (int)Math.round(getPos().getY());
        switch(dir){
            case NORTH: if(m.getMap()[x][y-1].getContenu()==Cellule.Contenu.SABLE){ return true;}
            case EAST: if(m.getMap()[x+1][y].getContenu()==Cellule.Contenu.SABLE){ return true;}
            case SOUTH: if(m.getMap()[x][y+1].getContenu()==Cellule.Contenu.SABLE){ return true;}
            case WEST: if(m.getMap()[x-1][y].getContenu()==Cellule.Contenu.SABLE){ return true;}
            default: return false;
        }
    }

    public void miseAJour(Map m){
        mouvement(m);
    }

    public boolean estDansCase(int i, int j) {
        return ((getPos().getX() == (j+i)/2 && getPos().getY() < i+1) || (getPos().getX() < j+1 && getPos().getY() == (i+j)/2));
    }

     
    // public static void main (String [] args){
    //     Cellule[][] map = Map.mapTest();
    //     Map m = new Map(map);
    //     Mobs rob = new Robot();
    //     rob.mouvement('d', m);
    //     m.afficher(Map.mapTest());
    // }
    


}
