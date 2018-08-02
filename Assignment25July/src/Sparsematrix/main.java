package Sparsematrix;

public class main {
    public static void main(String args[]) {

        int input1[][] = { { 1, 3, 1 }, { 3, 1, 0 }, { 1, 2, 0 } };
        int input2[][] = { { 1, 2, 1 }, { 3, 1, 0 }, { 1, 2, 0 } };
        Sparse sp = new Sparse(input1);
        Sparse sp2 = new Sparse(input2);
        sp.display();
        System.out.println();
        sp2.display();
        System.out.println();
        sp.transpose();

        System.out.println(sp.isSymmetrical());
        Sparse add = Sparse.addMatirx(sp, sp2);

        Sparse multiply = Sparse.multiplyMatirx(sp, sp2);
        System.out.println();
        add.display();
        System.out.println();
        multiply.display();

    }

}
