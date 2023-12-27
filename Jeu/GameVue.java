package Jeu;

import javax.swing.*;
import Géométrie.Coordonnees;
import Map.Map;
import Mobs.Mobs;
import Mobs.Robot;
import Mobs.Sprinteur;
import Mobs.Tank;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import Humain.Humain;
import Humain.Tourelle;

public class GameVue extends JFrame implements ActionListener, MouseListener{

    private Game game;
    private Map map = new Map("map1");
    private JPanel ZoneJeux = new JPanel();
    private static JPanel ZoneJouable = new JPanel();
    private ShopPanel magasin = new ShopPanel();
    private static MajMap maj;
    private Timer timer;
    private int Xclicked;
    private int Yclicked;

    private static JPanel plateau = new JPanel(new GridLayout(8,9));
    private ArrayList<JPanel> panels = new ArrayList<>();

    public static JPanel getPlateau() {
        return plateau;
    }

    public static JPanel getZoneJouable(){
        return ZoneJouable;
    }

    public static MajMap getmaj(){
        return maj;
    }

    public GameVue(Game game) throws IOException {

        this.game = game;
        maj = new MajMap(map, "map2");
        // Humain h = new Tourelle(new Coordonnees(5, 4));
        // maj.poseTower(h);

        new Robot();
        new Tank();
        new Sprinteur();
        // Timer t = new Timer(2000,  new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //     }
        // });
        // t.start();
        // frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension tailleMoniteur = Toolkit.getDefaultToolkit().getScreenSize();
        //this.setTitle("Human vs AI");
        this.setSize((int) tailleMoniteur.getWidth(), (int) tailleMoniteur.getHeight());

        //plateau
        plateau.setPreferredSize(
                new Dimension((int) ((tailleMoniteur.getWidth()) / 2), (int) (tailleMoniteur.getHeight())));

        for (int i = 0; i < this.map.getMap().length; i++) {
            for (int j = 0; j < this.map.getMap()[0].length; j++) {
                JPanel p = new JPanel();
                p.setPreferredSize(new Dimension((int) (plateau.getWidth() / 8), (int) (plateau.getHeight() / 9)));
                switch (this.map.getMap()[i][j].getContenu()) {
                    case TERRE: p.setBackground(new Color(197, 197, 197)); 
                    p.setBorder(BorderFactory.createLineBorder(Color.black));
                    break;
                    case EAU: p.setBackground(new Color(18, 101, 189)); break;
                    case SABLE: p.setBackground(new Color(247, 208, 118)); break;
                    case ARBRE: p.setBackground(new Color(10, 84, 13)); break;
                    case BASE_HUMAIN1: p = new GraphismeBaseHumain(1); break;
                    case BASE_HUMAIN2: p = new GraphismeBaseHumain(2); break;
                    case BASE_HUMAIN3: p = new GraphismeBaseHumain(3); break;
                    case BASE_IA1: p = new GraphismeBaseIA(1); break;
                    case BASE_IA2: p = new GraphismeBaseIA(2); break;
                    case BASE_IA3: p = new GraphismeBaseIA(3); break;
                    default: break;
                }
                plateau.add(p);
            }
        }

        plateau.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                Yclicked = x/(int) (plateau.getWidth() / 9);
                //System.out.println("y" + Yclicked);
                int y = e.getY();
                Xclicked = y/(int) (plateau.getHeight() / 8);
                System.out.println("X" + Xclicked);
                magasin.updateButton(Map.getMapS()[Xclicked][Yclicked], Xclicked, Yclicked);
            }
        });

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
        ZoneJouable.add(plateau);
        

        //zone de jeu
        ZoneJeux.setLayout(new BorderLayout());
        ZoneJeux.add(new JLabel("IA vs Humain"),BorderLayout.NORTH);
        ZoneJeux.add(ZoneJouable, BorderLayout.SOUTH);


        //fenetre
        this.getContentPane().setLayout(new GridLayout());
        this.add(ZoneJeux);
        this.add(magasin);
        this.setVisible(true);
        timer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updatePane();
                update();
                repaint();
                //ZoneJeux.remove(rootPane);
            }
        });
        timer.start();
        //game.add(this);
    }

    public static void poseTower (Humain h){
        maj.poseTower(h);
        for (Humain tower : TourSurLaMap.getInstance().getTourSurLaMap()) {
            JPanel panel = new GraphismeTour(tower);
            ZoneJouable.add(panel);
        }
        ZoneJouable.add(plateau);
    }

    public void startGame(){
        System.out.println("ICI");
        game.start();
        //timer.start();
    }

    public void update (){
        maj.update(1000000);
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

    // public JPanel paintComponent(Graphics g){
    //     JPanel p = new JPanel();
    //     try{
    //         Image image = ImageIO.read(new File("ressources/base_clean.png"));
    //         g.drawImage(image, GameVue.getZoneJouable().getWidth()/9, GameVue.getZoneJouable().getHeight()/8,this);
    //     }
    //     catch (IOException e){
    //         e.printStackTrace();
    //     }
    //     p.paint(g);
    //     return p;
    // }
}