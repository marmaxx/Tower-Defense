package Humain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import Géométrie.Coordonnees;
import Jeu.GameVue;
import Jeu.GraphismeBalle;

public class Balle extends JPanel{
    private Coordonnees position, cible;
    private int vitesse;
    private JPanel panel = new JPanel();

    public Balle(Coordonnees pos, Coordonnees cible, int vit){ 
        this.position=pos; 
        this.vitesse=vit;
        this.cible=cible;
        panel = new GraphismeBalle(this);
        GameVue.getZoneJouable().add(panel);
    }

    public Coordonnees getPos (){ return this.position;}
    public void setPos (Coordonnees nextPos){ this.position=nextPos;}

    public Coordonnees getPosCible (){ return this.cible;}

    public int getVitesse (){ return this.vitesse;}
    public void setVitesse (int nouvelleVitesse){ this.vitesse=nouvelleVitesse;}

    public Coordonnees nextPos (Coordonnees ajout){
        //System.out.println("POS  "+getPos());
        //System.out.println("AJOUT  "+ajout);
        return this.getPos().plus(ajout).fois(getVitesse()*10E-2);
    }

    public void mouvement (Coordonnees posCible){
        while (!(getPos().egal(posCible))){
            Timer t = new Timer(500, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Coordonnees nextPos = nextPos(posPlusProche(posCible));
                    setPos(nextPos);
                }
            });
            t.start();
        }
        System.out.println("TOUCHE!");
    }

    public Coordonnees posPlusProche (Coordonnees posCible){
        double nb = 100;
        int a = 0;
        int b = 0;
        for (int i = -1; i <= 1; i++){
            for (int j = -1; j <= 1; j++){
                Coordonnees cord1 = getPos().plus(new Coordonnees(i, j));
                double k = cord1.distanceFrom(posCible);
                if (k < nb){
                    nb = k;
                    a = i;
                    b = j;
                }
            }
        }
        return new Coordonnees(a, b);
    }
}
