package Jeu;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import Géométrie.Coordonnees;
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
    private static JPanel plateau = new JPanel();
    private static JPanel ZoneJouable = new JPanel();
    private JPanel magasin = new JPanel();

    public static JPanel getPlateau() {
        return plateau;
    }

    public static JPanel getZoneJouable(){
        return ZoneJouable;
    }

    Border border = new LineBorder(Color.BLUE, 1);

    GameVue(Game game) {

        this.game = game;
        this.map.map1();
        MobsSurLaMap mslm = new MobsSurLaMap();
        Map m = new Map(mslm);
        System.out.println("map2 ");
        m.map2();
        MajMap maj = new MajMap(m, "map2");
        maj.poseTower(5, 5, new Tourelle(10, 2, 0, 3, new Coordonnees(5, 5)));
        Robot r = new Robot();


        // frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension tailleMoniteur = Toolkit.getDefaultToolkit().getScreenSize();
        this.setTitle("Human vs AI");
        this.setSize((int) tailleMoniteur.getWidth(), (int) tailleMoniteur.getHeight());

        //plateau
        plateau.setPreferredSize(
                new Dimension((int) ((tailleMoniteur.getWidth()) / 2), (int) (tailleMoniteur.getHeight() - 200)));
        plateau.setLayout(new GridLayout(8, 9));

        for (int i = 0; i < this.map.getMap().length; i++) {
            for (int j = 0; j < this.map.getMap()[0].length; j++) {
                JPanel p = new JPanel();
                p.setPreferredSize(new Dimension((int) (plateau.getWidth() / 8), (int) (plateau.getHeight() / 9)));
                switch (this.map.getMap()[i][j].getContenu()) {
                    case TERRE: p.setBackground(new Color(197, 197, 197)); break;
                    case EAU: p.setBackground(new Color(18, 101, 189)); break;
                    case SABLE: p.setBackground(new Color(247, 208, 118)); break;
                    case ARBRE: p.setBackground(new Color(10, 84, 13)); break;
                    default: break;
                }
                plateau.add(p);
            }
        }

        //zone de jouable 
        ZoneJouable.setPreferredSize(new Dimension((int) ((tailleMoniteur.getWidth()) / 2), (int) (tailleMoniteur.getHeight() -200)));
        OverlayLayout overlayout = new OverlayLayout(ZoneJouable);
        ZoneJouable.setLayout(overlayout);
        for (Mobs mob : MobsSurLaMap.getInstance().getMobsSurLaMap()) {
            JPanel panel = new GraphismeMobs(mob);
            ZoneJouable.add(panel);
        }
        ZoneJouable.add(plateau);

        //zone de jeu
        ZoneJeux.setLayout(new BorderLayout());
        ZoneJeux.add(ZoneJouable, BorderLayout.SOUTH);

        //zone magasin
        magasin.setBackground(new Color(78, 66, 78));


        //fenetre
        this.getContentPane().setLayout(new GridLayout());
        this.add(ZoneJeux);
        this.add(magasin);
        this.setVisible(true);
    }

    public Component getComponentAt(int row, int col) {
        LayoutManager layoutManager = plateau.getLayout();
    
        if (layoutManager instanceof GridLayout) {
            GridLayout gridLayout = (GridLayout) layoutManager;
            int columns = gridLayout.getColumns();
            int index = row * columns + col;
            return plateau.getComponent(index);
        }
    
        // Gérer le cas où le gestionnaire de disposition n'est pas GridLayout
        return null;
    }
}