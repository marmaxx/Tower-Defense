package Jeu;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import Humain.Balle;

public class GraphismeBalle extends JPanel{
    private Balle balle;

    public GraphismeBalle (Balle b){
        this.balle=b;
    }

    public void paintComponent (Graphics g){
        g.setColor(Color.gray);
        g.drawLine(positionX(), positionY(), positionX()+5, positionY());
    }

    public int positionX(){
        double hauteur = GameVue.getZoneJouable().getHeight();
        double sizecase = hauteur/8;
        return (int)Math.floor(balle.getPos().getX() * sizecase);
    }

    public int positionY(){
        double largeur = GameVue.getZoneJouable().getWidth();
        double sizecase = largeur/9;
        return (int)Math.floor(balle.getPos().getY() * sizecase);
    }
}
