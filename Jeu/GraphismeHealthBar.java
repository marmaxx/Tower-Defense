package Jeu;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import Mobs.HealthBar;

public class GraphismeHealthBar extends JPanel{
    private HealthBar healthBar;

    public GraphismeHealthBar(HealthBar hb){
        this.healthBar=hb;
    }

    public void paintComponent (Graphics g) {
        int x = (int) healthBar.getPos().getX();
        int y = (int) healthBar.getPos().getY();
        int width = healthBar.getWidth();
        int height = healthBar.getHeight();
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
        g.setColor(Color.GREEN);
        g.fillRect(x, y, (int)(width*(healthBar.getPercent()/100.0)), height);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, width, height);
    }
}