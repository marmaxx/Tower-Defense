import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.*;


public class GameVue extends JFrame{
    private MobsSurLaMap mslm;
    private Game game;
    private Map map = new Map(mslm);
    private JPanel ZoneJeux = new JPanel();
    private JPanel magasin = new JPanel();

    private JPanel[][] grille;
    private JPanel plateau = new JPanel();
    Border border = new LineBorder(Color.BLUE, 1);
    

    GameVue(Game game ){

        this.game = game; 
        this.map.map2();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension tailleMoniteur = Toolkit.getDefaultToolkit().getScreenSize();
        this.setTitle("Human vs AI");
        this.setSize((int)tailleMoniteur.getWidth(), (int)tailleMoniteur.getHeight());

        //affichage de la partie jeux



        plateau.setPreferredSize(new Dimension((int)((tailleMoniteur.getWidth())/2) ,(int)(tailleMoniteur.getHeight() - 200 )) );
        plateau.setLayout(new GridLayout(8,9));
        
        grille = new JPanel[this.map.getMap().length][this.map.getMap()[0].length];
        for(int i = 0; i< grille.length; i++){
            for(int j = 0; j<grille[0].length; j++){
                grille[i][j] = new JPanel();
                grille[i][j].setPreferredSize(new Dimension((int)(plateau.getWidth()/8), (int)(plateau.getHeight()/9)));
                switch(this.map.getMap()[i][j].getContenu()){
                    case TERRE : grille[i][j].setBackground(new Color(197,197,197)); break;
                    case EAU : grille[i][j].setBackground(new Color(18,101,189)); break;
                    case SABLE : grille[i][j].setBackground(new Color(247,208,118)); break;
                    case ARBRE : grille[i][j].setBackground(new Color(10,84,13)); break;
                    default : break;
                }
                plateau.add(grille[i][j]);
            }   
        }

        ZoneJeux.setLayout(new BorderLayout());
        ZoneJeux.add(plateau, BorderLayout.SOUTH);

        //affichage de la partie utilitaire
        //magasin.setPreferredSize(new Dimension((int) tailleMoniteur.getWidth() / 2, (int) tailleMoniteur.getHeight()));
        magasin.setBackground(new Color(78,66,78));
    
        this.getContentPane().setLayout(new GridLayout());
        this.add(ZoneJeux);
        this.add(magasin);

        this.setVisible(true);
    }
}