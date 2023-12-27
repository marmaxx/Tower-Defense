package Jeu;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class GraphismeBaseHumain extends JPanel{
    private int numero;

    public GraphismeBaseHumain (int n){ this.numero=n;}

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
        //System.out.println("HP: "+Game.getVieBase());
        //System.out.println(Game.getVieBase() <=2);
        switch(this.numero){
            case 1: if (Game.getVieBase() <= 2){
                        url = "ressources/base_feu.png"; break;
                    }
                    else{url = "ressources/base_clean.png"; break;}
            case 2: if (Game.getVieBase() <= 1){
                        url = "ressources/base_feu.png"; break;
                    }
                    else{url = "ressources/base_clean.png"; break;}
            case 3: if (Game.getVieBase() == 0){
                        url = "ressources/base_feu.png"; break;
                    }
                    else{url = "ressources/base_clean.png"; break;}
        }
        
        return url;
    }
}
