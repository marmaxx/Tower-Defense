import javax.swing.*;
public class GraphismeMobs {
    private final double scale;
    private Mobs mob;

    public GraphismeMobs (double scale){
        this.scale=scale;
    }

    public GraphismeMaj makeGraphics (Mobs mob){
        if (mob instanceof Robot){
            ImageIcon imageRobot = new ImageIcon("Robot.png");
            RobotPanel robotPanel = new RobotPanel(imageRobot);
        }
        else if (mob instanceof Sprinteur){
            ImageIcon imageSprinteur = new ImageIcon("Sprinteur.png");
        }
        else if (mob instanceof Tank){
            ImageIcon imageTank = new ImageIcon("Tank.png");
        }
        else if (mob instanceof Tireur){
            ImageIcon imageTireur = new ImageIcon("");
        }
        
    }
}
