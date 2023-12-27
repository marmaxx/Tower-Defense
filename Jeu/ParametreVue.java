package Jeu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ParametreVue extends JFrame{
    private Game game;
    private JPanel vue = new JPanel();
    private JButton retour = new JButton();

    public ParametreVue(Game game) throws IOException{
        this.game=game;
        this.game.setVisible(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension tailleMoniteur = Toolkit.getDefaultToolkit().getScreenSize();
        this.setTitle("Paramètres");
        this.setSize((int) tailleMoniteur.getWidth(), (int) tailleMoniteur.getHeight());

        vue.setBackground(Color.BLACK);
        vue.setVisible(true);

        retour.setText("Retour");
        retour.addActionListener((event) -> {
            this.game.setVisible(true);this.setVisible(false);
            
        });
        vue.add(retour);
        this.add(vue);
        this.setVisible(true);
    }
}
