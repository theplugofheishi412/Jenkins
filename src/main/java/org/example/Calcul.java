package org.example;

public class Calcul {


    //mettre en place les autres methodes

    /**
     *
     * @param a entier
     * @param b entier
     * @return a + b
     */

    public static int Sum(int a, int b){
        return a + b ;
    }

    /**
     *
     * @param a entier
     * @param b entier
     * @return a / b
     *
     */

    public int division(int a , int b){
        if(b == 0){
            throw new IllegalArgumentException("Division par zero");
        }
        return a / b ;
    }

    /**
     *
     * @param a entier
     * @param b entier
     * @return a - b
     *
     */

    public int soustraction(int a, int b){
        return a - b;
    }

    /**
     *Cette methode retounre le resultat du produits de deux nbres
     * @param a entier
     * @param b entier
     * @return a * b
     *
     */
    public  int multiply(int a, int b){
        return a * b;
    }
}
