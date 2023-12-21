package Jeu;

public class ActionTimer {
    private int tempsDebut;
    private int tempsRestant;
    private boolean termine;

    public ActionTimer(int time) {
        this.tempsDebut = time;
        reset();
    }

    public void update(int deltaT) {
        tempsRestant -= deltaT;
        if(tempsRestant <= 0) {
            termine = true;
        }
    }

    public boolean estTermine() {
        return termine;
    }

    public void setTimer(int time) {
        tempsDebut = time;
        reset();
    }

    public void reset() {
        tempsRestant = tempsDebut;
        termine = false;
    }
}
