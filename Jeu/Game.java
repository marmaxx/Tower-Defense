package Jeu;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game implements KeyListener{
    private int score, argent, vieBase;
    public static void main (String [] args){
        new Game();
    }

    private GameVue gameVue;

    public GameVue getGameVue(){ return this.gameVue;}
    
    public Game(){
        this.gameVue = new GameVue(this);
        //gameVue.startGame();
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

    public void setScore(int score){
       this.score = score; 
    } 

    public void setArgent(int argent){
        this.argent = argent;
    }

    public void setVieBase(int vieBase){
        this.vieBase = vieBase;
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
