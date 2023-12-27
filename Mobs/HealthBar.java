package Mobs;

import javax.swing.JPanel;
import Géométrie.Coordonnees;
import Jeu.GameVue;
import Jeu.GraphismeHealthBar;

public class HealthBar{
    private int percent, width, height;
    private Coordonnees pos;

    public HealthBar(Coordonnees p, int w, int h) {
        this.width=w;
        this.height=h;
        this.pos=p;
        percent = 100;
        JPanel panel = new GraphismeHealthBar(this);
        GameVue.getZoneJouable().add(panel);
    }

    public Coordonnees getPos (){ return this.pos;}

    public int getWidth (){ return this.width;}
    public int getHeight (){ return this.height;}

    public int getPercent (){ return this.percent;}

    public void setPercent(int p) {
        this.percent = p;
    }
}