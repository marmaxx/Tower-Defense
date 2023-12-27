package Jeu;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ChoixJeuVue extends JFrame{
    private Game game;
    private JButton retour = new JButton();
    public ChoixJeuVue(Game game) throws IOException{
        this.game=game;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension tailleMoniteur = Toolkit.getDefaultToolkit().getScreenSize();
        this.setTitle("Choix du jeu");
        this.setSize((int) tailleMoniteur.getWidth(), (int) tailleMoniteur.getHeight());

        retour.setText("Retour");
        retour.addActionListener((event) -> {
            this.setVisible(false);
            this.game.setVisible(true);
        });
        this.add(retour);

        this.setVisible(true);
    }
}
