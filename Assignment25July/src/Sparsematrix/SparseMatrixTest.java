package Sparsematrix;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SparseMatrixTest {

    @Test
    public void transposeTest1() {
        Sparse matrix = new Sparse(new int[][] { { 0, 0, 0, 4 }, { 5, 0, 0, 0 }, { 0, 0, 0, 0 } });
        Sparse transpose = matrix.transpose();
        assertArrayEquals(new int[][] { { 0, 5, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 4, 0, 0 } }, transpose.getMatrix());

    }

    /**
     * Positive test case for isSymmetrical()
     */
    @Test
    public void isSymmetricalTest1() {
        Sparse matrix = new Sparse(new int[][] { { 4, 0, 0 }, { 0, 5, 0 }, { 0, 0, 2 } });
        boolean isSymmetrical = matrix.isSymmetrical();
        assertTrue(isSymmetrical);

    }

    /**
     * Negative test case for isSymmetrical()
     */
    @Test
    public void isSymmetricalTest2() {
        Sparse matrix = new Sparse(new int[][] { { 4, 3, 0 }, { 1, 5, 0 }, { 0, 0, 2 } });
        boolean isSymmetrical = matrix.isSymmetrical();
        assertFalse(isSymmetrical);
    }

    /**
     * Test case for addMatrices when matrices have same dimensions
     */
    @Test
    public void addMatricesTest1() {
        Sparse matrix1 = new Sparse(new int[][] { { 4, 0, 0 }, { 0, 5, 0 }, { 0, 0, 2 } });
        Sparse matrix2 = new Sparse(new int[][] { { 4, 0, 0 }, { 0, 5, 0 }, { 0, 0, 2 } });

        Sparse addition = Sparse.addMatirx(matrix1, matrix2);
        assertArrayEquals(new int[][] { { 8, 0, 0 }, { 0, 10, 0 }, { 0, 0, 4 } }, addition.getMatrix());
    }

    /**
     * Test case for multiplyMatrices when matrices have multiplication compatible
     * dimensions
     */
    @Test
    public void multiplyMatricesTest1() {
        Sparse matrix1 = new Sparse(new int[][] { { 0, 0 }, { 5, 0 }, { 0, 2 } });
        Sparse matrix2 = new Sparse(new int[][] { { 4, 0, 0 }, { 0, 5, 0 } });

        Sparse multiplication = Sparse.multiplyMatirx(matrix1, matrix2);
        assertArrayEquals(new int[][] { { 0, 0, 0 }, { 20, 0, 0 }, { 0, 10, 0 } }, multiplication.getMatrix());
    }

    /**
     * Test case for multiplyMatrices when matrices do'nt have multiplication
     * compatible dimensions
     */
    // @Test(expected = AssertionError.class)
    public void multiplyMatricesTest2() {
        Sparse matrix1 = new Sparse(new int[][] { { 0 }, { 5 }, { 0 } });
        Sparse matrix2 = new Sparse(new int[][] { { 4, 0, 0 }, { 0, 5, 0 } });

        Sparse.multiplyMatirx(matrix1, matrix2);
    }

}
