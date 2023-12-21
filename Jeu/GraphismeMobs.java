package Jeu;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import Mobs.Mobs;
public class GraphismeMobs extends JPanel{
    private Mobs mob;

    public GraphismeMobs(Mobs mob){
        this.mob=mob;
    }

    public void paintComponent(Graphics g){
        try{
            Image image = ImageIO.read(new File(getUrl(mob)));
            g.drawImage(image,1, 6, 60, 60, this);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public String getUrl (Mobs mob){
        String url = "";
        switch(mob.getType()){
            case "R": url = "ressources/Robot.png"; break;
            case "S": url = "ressources/Sprinteur.png"; break;
            case "Ta": url = "ressources/Tank.png"; break;
            case "Ti": url = "ressources/Tireur.png"; break;
        }
        return url;
    }
}
