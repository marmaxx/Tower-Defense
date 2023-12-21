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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameVue extends JFrame implements ActionListener, MouseListener{
    private Game game;
    private Map map = new Map();
    private JPanel ZoneJeux = new JPanel();
    private static JPanel ZoneJouable = new JPanel();
    private JPanel magasin = new JPanel();
    private MajMap maj;
    private Timer timer;

    private static JPanel plateau = new JPanel(new GridLayout(8,9));

    public static JPanel getPlateau() {
        return plateau;
    }

    public static JPanel getZoneJouable(){
        return ZoneJouable;
    }

    Border border = new LineBorder(Color.BLUE, 1);

    GameVue(Game game) {

        this.game = game;
        map.map2();
        maj = new MajMap(map, "map2 ");
        // m.afficher();
        maj.poseTower(5, 5, new Tourelle(10, 2, 0, 3, new Coordonnees(5, 5)));

        new Robot();


        // frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension tailleMoniteur = Toolkit.getDefaultToolkit().getScreenSize();
        this.setTitle("Human vs AI");
        this.setSize((int) tailleMoniteur.getWidth(), (int) tailleMoniteur.getHeight());

        //plateau
        plateau.setPreferredSize(
                new Dimension((int) ((tailleMoniteur.getWidth()) / 2), (int) (tailleMoniteur.getHeight() - 200)));
        //plateau.setLayout(new GridLayout(8, 9));

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

        //zone jouable 
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
        timer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update();
            }
        });
        timer.start();
    }

    public void startGame(){
        game.start();
        timer.start();
    }

    public void start (){

    }

    public void update (){
        maj.update(20);
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}