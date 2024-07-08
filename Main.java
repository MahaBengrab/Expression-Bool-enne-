
public class Main {

    public static void main(String[] args) {
        boolean[] vect1 = {true,true,false,true,true};
        boolean[] vect2 = {false,true,false,true,false};
        //Tester la méthode singleton
        ExpressionB ex0 = new ExpressionB();
        ExpressionB exa = ex0.singleton('A');
        System.out.println("Expression : " + exa.affichage());
        //Déclaration des variables du vecteur booleen
        ExpressionB a = new ExpressionB(new Noeud('a'));
        ExpressionB b = new ExpressionB(new Noeud('b'));
        ExpressionB c = new ExpressionB(new Noeud('c'));
        ExpressionB d = new ExpressionB(new Noeud('d'));
        System.out.println("Les valeurs booleennes selon le 1er vecteur");
        //Affectation des éléments du vecteur à chaque variable
        int j = 0;
        for(char i = 'a'; i <= 'e' && j < 5; i++, j++){
            System.out.println("La valeur de " + i + " est : " + vect1[j]);
        }
        /**
         * Disjonction => (v)
         * Conjonction => (∧)
         * Négation   => (¬)
         */
        System.out.println("----------------------------------------Expression Boolenne N°1----------------------------------------------------------------");
        // Etudions l'expression : (( ¬a ∧ (c ∨ a))
        ExpressionB expression1 = a.negation();
        ExpressionB expression2 = a.disjonction(c);
        ExpressionB expression3 = expression2.conjonction(expression1);
        // Etudions l'expression : ¬(b ∧  d))
        ExpressionB expression5 = d.conjonction(b);
        ExpressionB expression6f = expression5.negation();
        //L'expression finale : ¬(( ¬a ∧ (c ∨ a)) ∨¬(b ∧  d))
        ExpressionB ex = expression6f.disjonction(expression3);
        ExpressionB expressionFinal = ex.negation();
        //Affichage de l'expression
        System.out.println(expressionFinal.affichage());
        System.out.println("\n");
        //Evaluation de l'expression n°1
        System.out.println("Evaluation avec le vecteur n°1 : ");
        System.out.println("f = " + expressionFinal.evaluer(vect1));
        System.out.println("\n");
        System.out.println("Les valeurs booleennes selon le 2eme vecteur");
        int k = 0;
        for(char i = 'a'; i <= 'e' && k < 5; i++, k++){
            System.out.println("La valeur de " + i + " est : " + vect2[k]);
        }
        System.out.println("Evaluation avec le vecteur n°2 : ");
        System.out.println("f = " + expressionFinal.evaluer(vect2));
        System.out.println("----------------------------------------Expression Boolenne N°2----------------------------------------------------------------");
        // Etudions l'expression : ( ¬a ∨ (b ∧ c))
        ExpressionB e1 = a.negation();
        ExpressionB e2 = c.conjonction(b);
        ExpressionB e3 = e2.disjonction(e1);
        //Etudions l'expression ¬c
        ExpressionB e4 = c.negation();
        //L'expression finale : e = ( ¬a ∨ (b ∧ c)) ∧ ¬c
        ExpressionB expFinal = e4.conjonction(e3);
        //Affichage de l'expression
        System.out.println(expFinal.affichage());
        System.out.println("\n");
        //Evaluation de l'expression n°2
        System.out.println("Evaluation avec le vecteur n°1 : ");
        System.out.println("e = " + expFinal.evaluer(vect1));
        System.out.println("\n");
        System.out.println("Evaluation avec le vecteur n°2 : ");
        System.out.println("e = " + expFinal.evaluer(vect2));
        System.out.println("--------------------------------------------------------------------------------------------------------");


    }

}