/**
 * Created by Quentin on 06/12/2014.
 */
public class Figure {

    private int hauteur;
    private int largeur;
    private int x;
    private int y;


    public Figure(int hauteur, int largeur, int x, int y) {
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.x = x;
        this.y = y;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
