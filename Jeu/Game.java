package Jeu;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class Game implements KeyListener{
    private static int score, argent;
    private static int vieBase = 3;

    public Game (int s, int a, int v){
        score=s; argent=a; vieBase=v;
    }

    public static void main (String [] args) throws IOException{
        new Game();
    }

    private GameVue gameVue;

    public GameVue getGameVue(){ return this.gameVue;}
    
    public Game() throws IOException{
        this.gameVue = new GameVue(this);
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
        argent = argents;
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
