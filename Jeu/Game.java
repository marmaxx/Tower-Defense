package Jeu;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import Map.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
//import javax.swing.JPanel;

public class Game extends JFrame implements KeyListener{

    Map map;
    MajMap maj;
    private int score;
    private static int argent = 150;
    private static int vieBase = 3;
    //private JPanel nomJeu = new JPanel();
    private JMenuBar menu = new JMenuBar();
    private JButton bouttonJouer = new JButton();
    private JButton bouttonParametres = new JButton();
    private JButton bouttonQuitter = new JButton();
    
    public static void main (String [] args) throws IOException{
        new Game("map1");
    }

    private GameVue gameVue;
    private ParametreVue parametreVue = new ParametreVue(this);
    private ChoixJeuVue choixJeuVue = new ChoixJeuVue(this);

    public GameVue getGameVue(){ return this.gameVue;}
    
    public Game(String nameMape) throws IOException{

        this.map = new Map(nameMape);
        this.maj = new MajMap(map, nameMape);

        this.parametreVue.setVisible(false);
        this.choixJeuVue.setVisible(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension tailleMoniteur = Toolkit.getDefaultToolkit().getScreenSize();
        this.setTitle("Human vs AI");
        this.setSize((int) tailleMoniteur.getWidth(), (int) tailleMoniteur.getHeight());

        menu.setLayout(new GridLayout(3,1));
        menu.setBackground(Color.BLACK);
        menu.add(new JLabel("IA vs HUMAIN"), BorderLayout.CENTER);

        bouttonJouer.setText("JOUER");
        bouttonJouer.addActionListener((event) -> {
            try{
                this.gameVue= new GameVue(this);
                //this.add(gameVue);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //new ChoixJeuVue();
            this.setVisible(false);
        });
        menu.add(bouttonJouer);
        
        bouttonParametres.setText("PARAMETRES");
        bouttonParametres.addActionListener((event) -> {
            this.parametreVue.setVisible(true);
            this.setVisible(false);
        });
        menu.add(bouttonParametres);

        bouttonQuitter.setText("QUITTER");
        bouttonQuitter.addActionListener((event) -> {
            System.exit(0);
        });
        menu.add(bouttonQuitter);

        //this.add(nomJeu);
        this.add(menu,BorderLayout.CENTER);
        this.setVisible(true);
    }

    public void start(){
        score = 0;
        argent = 150;
        vieBase = 3;
        setScore(score);
        setArgent(argent);
        setVieBase(vieBase);
        MobsSurLaMap.getInstance().reset();
    }

    public void setScore(int s){
       score = s; 
    } 

    public static void setArgent(int argents){
        argent -= argents;
    }
    public static int getargent(){
        return argent;
    }

    public static int getVieBase(){ return vieBase;}

    public static void setVieBase(int v){
        vieBase = v;
    }
    
    public static boolean haveMoney(int i){
           //System.out.println("true");
        if(argent >= i){
            return true;
        }
        return false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }
    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
    }
    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }
}
