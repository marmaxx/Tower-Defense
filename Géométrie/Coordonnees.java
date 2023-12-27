package Géométrie;
//import java.text.DecimalFormat;

public record Coordonnees (double x, double y) {
    public static final Coordonnees ZERO = new Coordonnees(0, 0);
    public static final Coordonnees HAUT = new Coordonnees(-1, 0);
    public static final Coordonnees DROITE = new Coordonnees(0, 1);
    public static final Coordonnees BAS = new Coordonnees(1, 0);
    public static final Coordonnees GAUCHE = new Coordonnees(0, -1);

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public Coordonnees plus(Coordonnees other) {
        return new Coordonnees(x + other.x, y + other.y);
    }

    public Coordonnees moins(Coordonnees other) {
        return new Coordonnees(x - other.x, y - other.y);
    }

    public Coordonnees fois(double multiplier) {
        return new Coordonnees(x * multiplier, y * multiplier);
    }

    public boolean egal(Coordonnees other) {
        return (this.x == other.x && this.y == other.y);
    }

    public Coordonnees round() {
        return new Coordonnees((int) Math.round(x), (int) Math.round(y));
    }
    
    public Coordonnees warp(int width, int height) {
        var rx = x;
        var ry = y;
        while (Math.round(rx) < 0)
            rx += width;
        while (Math.round(ry) < 0)
            ry += height;
        while (Math.round(rx) >= width)
            rx -= width;
        while (Math.round(ry) >= height)
            ry -= height;
        return new Coordonnees(rx, ry);
    }

    public double distanceFrom (Coordonnees other){
        double d = Math.sqrt(Math.pow(other.x - x, 2)+Math.pow(other.y - y, 2)); 
        return Math.abs(d);
    }
}
