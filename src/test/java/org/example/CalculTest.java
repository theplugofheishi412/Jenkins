package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculTest {

    // test pour la methode somme
    @Test
    void sum() {

        assertEquals(5,Calcul.Sum(2, 3));
    }

    // test pour la methode division
    @Test
    void div(){
        int a = 2;
        int b = 2;
        int c ;
        Calcul calcul = new Calcul();
        c = calcul.division(a,b);
        assertEquals(1,c);
    }

    // test pour la methode division par zero
    @Test
    void divParZero(){

        Calcul calcul = new Calcul();
        assertThrows(IllegalArgumentException.class, () -> {
            calcul.division(0, 0);
        });
    }

    // test pour la methode difference
    @Test
    void dif(){
        int a = 3;
        int b = 3;
        int c;
        Calcul calcul = new Calcul();
        c = calcul.soustraction(a,b);
        assertEquals(0,c);
    }

    // test pour la methode produit
    @Test
    void prod(){
        int a = 3;
        int b = 3;
        int c;

        Calcul calcul = new Calcul();

        c = calcul.multiply(a,b);
        assertEquals(9,c);
    }

}