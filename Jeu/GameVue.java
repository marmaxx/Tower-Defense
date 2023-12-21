package Jeu;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import Humain.Tourelle;
import Map.Map;
import Mobs.Mobs;
import Mobs.Robot;
import java.awt.*;

public class GameVue extends JFrame {
    private MobsSurLaMap mslm;
    private Game game;
    private Map map = new Map(mslm);
    private JPanel ZoneJeux = new JPanel();
    private JPanel magasin = new JPanel();

    private JPanel[][] grille;
    private static JPanel plateau = new JPanel();

    public static JPanel getPlateau() {
        return plateau;
    }

    Border border = new LineBorder(Color.BLUE, 1);

    GameVue(Game game) {

        this.game = game;
        this.map.map1();
        MobsSurLaMap mslm = new MobsSurLaMap();
        Map m = new Map(mslm);
        System.out.println("map2 ");
        m.map2();
        // m.afficher();

        MajMap maj = new MajMap(m, "map2");
        maj.poseTower(5, 5, new Tourelle(10, 2, 0, 3));

        Robot r = new Robot();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension tailleMoniteur = Toolkit.getDefaultToolkit().getScreenSize();
        this.setTitle("Human vs AI");
        this.setSize((int) tailleMoniteur.getWidth(), (int) tailleMoniteur.getHeight());

        // affichage de la partie jeux

        plateau.setPreferredSize(
                new Dimension((int) ((tailleMoniteur.getWidth()) / 2), (int) (tailleMoniteur.getHeight() - 200)));
        plateau.setLayout(new GridLayout(8, 9));

        grille = new JPanel[this.map.getMap().length][this.map.getMap()[0].length];
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[0].length; j++) {
                grille[i][j] = new JPanel();
                grille[i][j].setPreferredSize(
                        new Dimension((int) (plateau.getWidth() / 8), (int) (plateau.getHeight() / 9)));
                switch (this.map.getMap()[i][j].getContenu()) {
                    case TERRE:
                        grille[i][j].setBackground(new Color(197, 197, 197));
                        break;
                    case EAU:
                        grille[i][j].setBackground(new Color(18, 101, 189));
                        break;
                    case SABLE:
                        grille[i][j].setBackground(new Color(247, 208, 118));
                        break;
                    case ARBRE:
                        grille[i][j].setBackground(new Color(10, 84, 13));
                        break;
                    default:
                        break;
                }
                plateau.add(grille[i][j]);
            }
        }

        ZoneJeux.setLayout(new BorderLayout());
        OverlayLayout overlayout = new OverlayLayout(ZoneJeux);
        ZoneJeux.setLayout(overlayout);
        for (Mobs mob : MobsSurLaMap.getInstance().getMobsSurLaMap()) {
            JPanel panel = new GraphismeMobs(mob);
            //panel.setPreferredSize(new Dimension(60, 60));
            panel.setBounds((int) mob.getPos().getX(), (int) mob.getPos().getY(), 60, 60);
            panel.setLayout(null);
            ZoneJeux.add(panel);
        }
        ZoneJeux.add(plateau, BorderLayout.SOUTH);

        // affichage de la partie utilitaire
        // magasin.setPreferredSize(new Dimension((int) tailleMoniteur.getWidth() / 2,
        // (int) tailleMoniteur.getHeight()));
        magasin.setBackground(new Color(78, 66, 78));

        this.getContentPane().setLayout(new GridLayout());
        this.add(ZoneJeux);
        this.add(magasin);

        this.setVisible(true);
    }
}