/**
 * @author Halmi ilias
 * @author Maha Bengrab
 * @version Avril 2024
 */
public class ExpressionB {

    private Noeud racine;

    /**
     * Constructeur qui met la racine à null
     */
    public ExpressionB(){
        racine = null;
    }

    /**
     * Constructeur avec un noeud en parametre
     * @param racine
     */
    public ExpressionB(Noeud racine){
        this.racine = racine;
    }

    public Noeud getRacine(){
        return racine;
    }

    public void setRacine(Noeud e){
        racine = e;
    }

    public boolean estVide(){
        return racine == null;
    }

    public ExpressionB singleton(char e){
        ExpressionB ex = new ExpressionB();
        ex.racine = new Noeud(e);
        return ex;
    }

    /**
     * @param ex1 est utilisé comme un fils gauche
     * @return l'expression boolenne avec deux fils gauche et droit et l'operateur comme racine
     */
    public ExpressionB conjonction(ExpressionB ex1){
        ExpressionB ex = new ExpressionB();
        ex.racine = new Noeud('∧');
        ex.racine.setFilsDroit(this.getRacine());
        ex.racine.setFilsGauche(ex1.getRacine());

        return ex;
    }

    /**
     * La méthode Négation
     * @return elle retourne une expression boolenne avec une racine représentée par l'opérateur ¬
     */
    public ExpressionB negation(){
        ExpressionB ex = new ExpressionB();
        ex.racine = new Noeud('¬');
        ex.racine.setFilsDroit(this.getRacine());
        return ex;
    }

    /**
     * La méthode disjonction
     * @param ex1 est une expression boolenne qui utilisé comme un fils gauche
     * @return Le retour est une expression boolenne qui a une racine présentée par l'opérateur v et deux fils gauche et droit
     */
    public ExpressionB disjonction(ExpressionB ex1){
        ExpressionB ex = new ExpressionB();
        ex.racine = new Noeud('v');
        ex.racine.setFilsDroit(this.getRacine());
        ex.racine.setFilsGauche(ex1.getRacine());
        return ex;
    }

    /**
     * La méthode d'affichage qui utilise une notation infixée
     * Notation infixée (Gauche,Racine,Droit)
     * @return
     */
    public String affichage(){
        return affichage(racine);
    }

    private String affichage(Noeud a) {
        if (a == null) {
            return "";
        }

        String expB = "";

        // Si on a une opération de conjonction ou de disjonction on les entoure par des parenthèses
        if (a.getElement() == '∧' || a.getElement() == 'v') {
            expB += "(";
        }

        // Affichage du fils gauche
        if (a.getFilsGauche() != null) {
            expB += affichage(a.getFilsGauche());
        }

        // Affichage de l'opérateur
        expB += " " + a.getElement() + " ";

        // Affichage du fils droit
        if (a.getFilsDroit() != null) {
            expB += affichage(a.getFilsDroit());
        }

        // On ferme les parenthèses
        if (a.getElement() == '∧' || a.getElement() == 'v') {
            expB += ")";
        }

        return expB;
    }

    /**
     * La méthode evaluer permet l'evaluation d'une expression boolenne
     * @param vect
     * @return
     */
    public boolean evaluer(boolean [] vect){
        return evaluerRec(racine,vect);
    }

    private boolean evaluerRec(Noeud a, boolean[] vect){
        if(a.getElement()=='v'){
            return evaluerRec(a.getFilsGauche(),vect) || evaluerRec(a.getFilsDroit(),vect);
        } else if (a.getElement() == '∧') {
            return evaluerRec(a.getFilsGauche(),vect) && evaluerRec(a.getFilsDroit(),vect);
        } else if (a.getElement() == '¬') {
            return !(evaluerRec(a.getFilsDroit(),vect));
        }
        for (int i = 0; i < 26;i++){
            if(a.getElement() == (char)('a'+ i)){
                return vect[i];
            }
        }
        return false;
    }

    public String toString(){
        return " ";
    }
}
