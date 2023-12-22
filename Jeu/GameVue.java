package Jeu;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import Géométrie.Coordonnees;
import Humain.Tourelle;
import Map.Map;
import Mobs.Mobs;
import Mobs.Robot;
import Mobs.Sprinteur;
import Mobs.Tank;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import Géométrie.Coordonnees;
import Humain.Humain;
import Humain.Tourelle;
import Map.Map;
import Mobs.Mobs;
import Mobs.Robot;


public class GameVue extends JFrame implements ActionListener, MouseListener{
    private Game game;
    private Map map = new Map();
    private JPanel ZoneJeux = new JPanel();
    private static JPanel ZoneJouable = new JPanel();
    private JPanel magasin = new JPanel();
    private JPanel panel;
    private MajMap maj;
    private Timer timer;
    private static JPanel plateau = new JPanel(new GridLayout(8,9));
    private ArrayList<JPanel> panels = new ArrayList<>();

    public static JPanel getPlateau() {
        return plateau;
    }

    public static JPanel getZoneJouable(){
        return ZoneJouable;
    }


    GameVue(Game game) throws IOException {

        this.game = game;
        map.map1();
        maj = new MajMap(map, "map2");
        maj.poseTower(new Tourelle(10, 0, 0, 3, new Coordonnees(5, 5)));

        new Robot();
        new Tank();
        new Sprinteur();

        // frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension tailleMoniteur = Toolkit.getDefaultToolkit().getScreenSize();
        this.setTitle("Human vs AI");
        this.setSize((int) tailleMoniteur.getWidth(), (int) tailleMoniteur.getHeight());

        //plateau
        plateau.setPreferredSize(
                new Dimension((int) ((tailleMoniteur.getWidth()) / 2), (int) (tailleMoniteur.getHeight())));

        for (int i = 0; i < this.map.getMap().length; i++) {
            for (int j = 0; j < this.map.getMap()[0].length; j++) {
                JPanel p = new JPanel();
                p.setPreferredSize(new Dimension((int) (plateau.getWidth() / 8), (int) (plateau.getHeight() / 9)));
                switch (this.map.getMap()[i][j].getContenu()) {
                    case TERRE: p.setBackground(new Color(197, 197, 197)); break;
                    case EAU: p.setBackground(new Color(18, 101, 189)); break;
                    case SABLE: p.setBackground(new Color(247, 208, 118)); break;
                    case ARBRE: p.setBackground(new Color(10, 84, 13)); break;
                    case BASE_HUMAIN1: p = new GraphismeBase(1); break;
                    case BASE_HUMAIN2: p = new GraphismeBase(2); break;
                    case BASE_HUMAIN3: p = new GraphismeBase(3); break;
                    case BASE_IA1: p = new GraphismeBaseIA(1); break;
                    case BASE_IA2: p = new GraphismeBaseIA(2); break;
                    case BASE_IA3: p = new GraphismeBaseIA(3); break;
                    default: break;
                }
                plateau.add(p);
            }
        }

        //zone jouable 
        ZoneJouable.setPreferredSize(new Dimension((int) ((tailleMoniteur.getWidth()) / 2), (int) (tailleMoniteur.getHeight()-200)));
        OverlayLayout overlayout = new OverlayLayout(ZoneJouable);
        ZoneJouable.setLayout(overlayout);
        for (Mobs mob : MobsSurLaMap.getInstance().getMobsSurLaMap()) {
            JPanel panel = new GraphismeMobs(mob);
            String nom = mob.toString();
            panel.setName(nom);
            panels.add(panel);
            ZoneJouable.add(panel);
        }

        for (Humain tower : TourSurLaMap.getInstance().getTourSurLaMap()) {
            JPanel panel = new GraphismeTour(tower);
            ZoneJouable.add(panel);
        }
        for (Humain tower : TourSurLaMap.getInstance().getTourSurLaMap()) {
            JPanel panel = new GraphismeTour(tower);
            ZoneJouable.add(panel);
        }

        ZoneJouable.add(plateau);

        //zone de jeu
        ZoneJeux.setLayout(new BorderLayout());
        ZoneJeux.add(ZoneJouable, BorderLayout.SOUTH);

        //zone magasin

        this.magasin = new ShopPanel();

        //fenetre
        this.getContentPane().setLayout(new GridLayout());
        this.add(ZoneJeux);
        this.add(magasin);
        this.setVisible(true);
        timer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updatePane();
                update();
                repaint();
                ZoneJeux.remove(rootPane);
            }
        });
        timer.start();
    }

    public void startGame(){
        System.out.println("ICI");
        game.start();
        //timer.start();
    }

    public void update (){
        maj.update(1);
    }

    public void updatePane(){
        for (JPanel panel : panels){
            boolean b = false;
            String nom = panel.getName();
            for (Mobs mob : MobsSurLaMap.getInstance().getMobsSurLaMap()){
                String nomMob = mob.toString();
                if (nomMob.equals(nom)) b=true;
            }
            if (!b) ZoneJouable.remove(panel);
        }
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

    public JPanel paintComponent(Graphics g){
        JPanel p = new JPanel();
        try{
            Image image = ImageIO.read(new File("ressources/base_clean.png"));
            g.drawImage(image, GameVue.getZoneJouable().getWidth()/9, GameVue.getZoneJouable().getHeight()/8,this);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        p.paint(g);
        return p;
    }
}