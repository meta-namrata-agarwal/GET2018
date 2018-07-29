package Sparsematrix;

import java.util.HashMap;
import java.util.Iterator;

import javax.swing.Spring;

public class Sparse {
    private final int row;
    private final int column;
    private final HashMap<Integer, Integer> SparseMatrix = new HashMap<>();

    public Sparse(int[][] matrix) {
        int position = 0;
        if (matrix == null)
        throw new AssertionError("Invalid input");

        row = matrix.length;
        column = matrix[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] != 0) {
                    SparseMatrix.put(position, matrix[i][j]);
                }
                position++;
            }
        }
    }

    public int[][] getMatrix() {
        int matrix[][] = MapToMatrix();
        return matrix;
    }

    public int[][] display() {
        int matrix[][] = MapToMatrix();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        return matrix;
    }

    public Sparse transpose() {
        int matrix[][] = MapToMatrix();
        int transpose[][] = new int[column][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        return new Sparse(transpose);
    }

    public boolean isSymmetrical() {
        boolean symmetrical = false;

        Sparse transpose = transpose();
        if (SparseMatrix.equals(transpose.SparseMatrix)) {
            symmetrical = true;
        }
        return symmetrical;
    }

    public static Sparse addMatirx(Sparse matrix1, Sparse matrix2) {
        int input1[][] = matrix1.getMatrix();
        int input2[][] = matrix2.getMatrix();
        int addmatrix[][] = new int[matrix1.row][matrix1.column];
        if (matrix1.row != matrix2.row || matrix1.column != matrix2.column)
            throw new AssertionError("Dimensions not same! Cannot add!");
        for (int i = 0; i < matrix1.row; i++) {
            for (int j = 0; j < matrix2.column; j++) {
                addmatrix[i][j] = input1[i][j] + input2[i][j];
            }
        }
        return new Sparse(addmatrix);
    }

    public static Sparse multiplyMatirx(Sparse matrix1, Sparse matrix2) {
        int input1[][] = matrix1.getMatrix();
        int input2[][] = matrix2.getMatrix();
        int multiplyMatrix[][] = new int[matrix1.row][matrix2.column];
        if (matrix1.row != matrix2.column)
            throw new AssertionError("Dimensions not same! Cannot add!");

        for (int i = 0; i < matrix1.row; i++)
            for (int j = 0; j < matrix2.column; j++)
                for (int k = 0; k < matrix1.column; k++)
                    multiplyMatrix[i][j] += input1[i][k] * input2[k][j];
        return new Sparse(multiplyMatrix);
    }

    private int[][] MapToMatrix() {
        int position = 0;
        int matrix[][] = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (SparseMatrix.containsKey(position))
                    matrix[i][j] = SparseMatrix.get(position);
                position++;
            }
        }

        return matrix;
    }
}
