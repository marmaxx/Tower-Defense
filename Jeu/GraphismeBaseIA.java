package Jeu;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class GraphismeBaseIA extends JPanel{
    private int numero;

    public GraphismeBaseIA (int n){ this.numero=n;}

    public void paintComponent(Graphics g){
        try{
            Image image = ImageIO.read(new File(getUrl()));
            g.drawImage(image,0,0, GameVue.getZoneJouable().getWidth()/9, GameVue.getZoneJouable().getHeight()/8,this);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public String getUrl (){
        String url = "";
        switch(this.numero){
            case 1: url = "ressources/base_ia1.png"; break;
            case 2: url = "ressources/base_ia2.png"; break;
            case 3: url = "ressources/base_ia3.png"; break;
        }
        return url;
    }
}
