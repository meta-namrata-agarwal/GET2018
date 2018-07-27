package Polynomial;

import static org.junit.Assert.*;

import org.junit.Test;

public class PolyTest {

    @Test
    public void evaluateTestPositive() {
        int[][] arrTest = { { 1, 2 }, { 3, 3 }, { 5, 1 } };
        Poly p = new Poly(arrTest);
        assertEquals("passes", 38, p.evaluate(2), 2);
    }

    @Test
    public void evaluateTestNegative() {
        int[][] arrTest = { { 1, 2 }, { 3, 3 }, { 5, 1 } };
        Poly p = new Poly(arrTest);
        assertNotEquals("fails", 0, p.evaluate(2), 2);
    }

    @Test
    public void degreeTestPositive() {
        int[][] arrTest = { { 1, 2 }, { 3, 3 }, { 5, 1 } };
        Poly p = new Poly(arrTest);
        assertEquals("passes", 3, p.degree());
    }

    @Test
    public void degreeTestNegative() {
        int[][] arrTest = { { 1, 2 }, { 3, 3 }, { 5, 1 } };
        Poly p = new Poly(arrTest);
        assertNotEquals("fails", 0, p.degree());
    }

    @Test
    public void addPolyTestPositive() {

        int arr[][] = { { 1, 2 }, { 2, 1 }, { 2, 3 }, { 3, 1 } };
        int arr2[][] = { { 2, 2 }, { 3, 3 }, { 1, 2 } };

        int[][] addTest = { { 5, 3 }, { 4, 2 }, { 5, 1 } };
        Poly p1 = new Poly(arr);
        Poly p2 = new Poly(arr2);
        Poly p3 = p1.addPoly(p1, p2);
        p3.print();
        
        assertArrayEquals("passes", p3.getPoly(), addTest);
    }

    @Test
    public void multiplyPolyTestPositive() {

        int arr[][] = { { 1, 2 }, { 2, 1 }, { 2, 3 }, { 3, 1 } };
        int arr2[][] = { { 2, 2 }, { 3, 3 }, { 1, 2 } };

        int[][] addTest = { { 6, 6 }, { 9, 5 }, { 18, 4 }, { 15, 3 } };
        Poly p1 = new Poly(arr);
        Poly p2 = new Poly(arr2);
        Poly p3 = p1.multiplyPoly(p1, p2);
        p3.print();
        
        assertArrayEquals("passes", p3.getPoly(), addTest);
    }

}
