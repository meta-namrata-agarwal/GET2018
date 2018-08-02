package Polynomial;

public class MainPoly {

    public static void main(String[] args) {
        int arr[][] = { { 1, 2 }, { 2, 1 }, { 2, 3 }, { 3, 1 } };
        int arr2[][] = { { 2, 2 }, { 3, 3 }, { 1, 2 } };

        Poly p1 = new Poly(arr);
        p1.print();
        System.out.println(p1.evaluate(2));
        System.out.println(p1.degree());
        System.out.println();
        
        Poly p2 = new Poly(arr2);
        p2.print();
        System.out.println(p2.evaluate(2));
        System.out.println(p2.degree());
        System.out.println();
        
        Poly p3;
        Poly p4;
        p3 = p2.addPoly(p1, p2);
        System.out.println("addition of polynomials are");
        p3.print();
        p4 = p1.multiplyPoly(p1, p2);
        System.out.println("------------------------");
        System.out.println("multiply of polynomials are");
        p4.print();

       

        

    }

}
