package Jeu;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageConsumer;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ShopPanel extends JPanel implements MouseListener{

    private JPanel info = new JPanel(); 
    private JPanel shop = new JPanel();
    private JPanel settings = new JPanel();
    private JButton tower1 = new JButton("100$"); 
    private JButton tower2 = new JButton("300$");
    private JButton tower3 = new JButton("150$"); 
    private JButton buy = new JButton("Buy"); 
    private JButton menu = new JButton();

    public ShopPanel() throws IOException{
        Dimension tailleMoniteur = Toolkit.getDefaultToolkit().getScreenSize();
        setPreferredSize( new Dimension((int) ((tailleMoniteur.getWidth()) / 2), (int) (tailleMoniteur.getHeight())));

        //Info 
        info.setPreferredSize(new Dimension((int) ((tailleMoniteur.getWidth()) / 2), (int) (tailleMoniteur.getHeight()/8)));
        info.setBackground(new Color(122,122,122));

        //shop
        shop.setPreferredSize(new Dimension((int) ((tailleMoniteur.getWidth()) / 2), (int) (5*(tailleMoniteur.getHeight()/8))));
        shop.setBackground(new Color(25,25,25));
        shop.setLayout(new GridLayout(2,2));

            //case pour la tourelle
            JPanel towerPanel1 = new JPanel();
            JLabel label1 = new JLabel();
            ImageIcon image1 = resizeImageIcon(new ImageIcon("ressources/tourelle.png"),200,200);
            label1.setIcon(image1);
            towerPanel1.setLayout(new BorderLayout());
            towerPanel1.add(label1, BorderLayout.CENTER);
            towerPanel1.add(tower1,BorderLayout.SOUTH);

            // Case pour le mortier
            JPanel towerPanel2 = new JPanel();
            JLabel label2 = new JLabel();
            ImageIcon image2 = resizeImageIcon(new ImageIcon("ressources/mortier.png"), 200, 200);
            label2.setIcon(image2);
            towerPanel2.setLayout(new BorderLayout());
            towerPanel2.add(label2, BorderLayout.CENTER);
            towerPanel2.add(tower2, BorderLayout.SOUTH);

            // Case pour la barrière
            JPanel towerPanel3 = new JPanel();
            JLabel label3 = new JLabel();
            ImageIcon image3 = resizeImageIcon(new ImageIcon("ressources/barriere.png"), 200, 200);
            label3.setIcon(image3);
            towerPanel3.setLayout(new BorderLayout());
            towerPanel3.add(label3, BorderLayout.CENTER);
            towerPanel3.add(tower3, BorderLayout.SOUTH);

        
        // shop.add(tower1);
        shop.add(towerPanel1);
        shop.add(towerPanel2);
        shop.add(towerPanel3);
        shop.add(buy);
        

        //setting 
        settings.setPreferredSize(new Dimension((int) ((tailleMoniteur.getWidth()) / 2), (int) (2*(tailleMoniteur.getHeight()/8))));
        settings.setBackground(new Color(66,66,66));

        this.add(info);
        this.add(shop);
        this.add(settings); 
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
    }

    private static ImageIcon resizeImageIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image resizedImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImg);
    }
}
