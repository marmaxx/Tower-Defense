package Jeu;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import Humain.Humain;

public class GraphismeTour extends JPanel{

    private Humain tower;

    public GraphismeTour(Humain h){
        this.tower = h;
    }

    public void paintComponent(Graphics g){
        try{
            Image image = ImageIO.read(new File(getUrl(tower)));
            g.drawImage(image,(int)positionY(), (int)positionX(), GameVue.getZoneJouable().getWidth()/9, GameVue.getZoneJouable().getHeight()/8,this);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public String getUrl (Humain h){
        String url = "";
        switch(h.getType()){
            case "T": url = "ressources/tourelle.png"; break;
            case "M": url = "ressources/mortier.png"; break;
            case "B": url = "ressources/barriere.png"; break;
            default : break;
        }
        return url;
    }

    public double positionX(){
        double hauteur = GameVue.getZoneJouable().getHeight();
        double sizecase = hauteur/8;
        return Math.floor(tower.getPos().getX() * sizecase);
    }

     public double positionY(){
        double largeur = GameVue.getZoneJouable().getWidth();
        double sizecase = largeur/9;
        return Math.floor(tower.getPos().getY() * sizecase);
    }
    
}
