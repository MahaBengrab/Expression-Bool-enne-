/**
 * @author Halmi ilias
 * @author Maha Bengrab
 * @version Avril 2024
 */
public class Noeud {
    //Les attributs
    protected char element;
    protected Noeud filsGauche;
    protected Noeud filsDroit;

    //Constructeurs

    public Noeud(char _element) {
        filsGauche = null;
        filsDroit = null;
        element = _element;
    }

    public Noeud(Noeud g, Noeud d, char c) {
        filsGauche = g;
        filsDroit = d;
        element = c;
    }

    // Accesseurs
    public Noeud getFilsGauche() {
        return filsGauche;
    }

    public Noeud getFilsDroit() {
        return filsDroit;
    }

    public char getElement() {
        return element;
    }
    //Modificateurs

    public void setFilsGauche(Noeud _fils_Gauche) {
        filsGauche = _fils_Gauche;
    }

    public void setFilsDroit(Noeud _fils_Droit) {
        filsDroit = _fils_Droit;
    }

    public void setElement(char a) {
        element = a;
    }

    public String toString() {
        String res = "";
        res += element;
        return res;
    }
}