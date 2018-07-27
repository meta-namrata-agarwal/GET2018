package Polynomial;

/*
 * this class performs operations on polynomial 
 * such as addition multiplication 
 * finding the degree and size
 */
public final class Poly implements PolyInter {

    private int[][] array;
    private int size;

    public Poly(int[][] arr) {
        size = arr.length;

        array = new int[size][2];
        array = arr;

        individualSum();
        polySort();
    }

    /*
     * method prints the polynomial expression
     */
    public void print() {
        System.out.print("Polynomial is: ");
        for (int i = 0; i < size; i++) {
            System.out.print("" + array[i][0] + "X^" + array[i][1]);
            if (i != size - 1) {
                System.out.print("+");
            }
        }
        System.out.println();
    }

    /*
     * @returns the array of Poly
     */
    int[][] getPoly() {

        int finalArray[][] = new int[size][2];
        for (int i = 0; i < size; i++) {
            if (array[i][1] != 0) {
                finalArray[i][0] = array[i][0];
                finalArray[i][1] = array[i][1];
            }
        }
        return finalArray;
    }

    /*
     * private method sorts the polynomial according to the degree
     */

    private void polySort() {
        int len = array.length;
        int temp = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (array[i][1] < array[j][1]) {
                    for (int k = 0; k < 2; k++) {
                        temp = array[j][k];
                        array[j][k] = array[i][k];
                        array[i][k] = temp;

                    }
                }
            }
        }
    }

    /*
     * private method use to add the coefficients of same degree value
     */
    private void individualSum() {
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (array[i][1] == array[j][1]) {
                    array[i][0] = array[i][0] + array[j][0];
                    remove(j);
                }
            }
        }
    }

    /*
     * private method to remove the elements which have been added with their
     * same coefficients
     */
    private void remove(int i) {
        for (int j = i; j < size - 1; j++) {
            array[j][0] = array[j + 1][0];
            array[j][1] = array[j + 1][1];
        }
        size--;
    }

    /*
     * (non-Javadoc)
     * 
     * @see Polynomial.PolyInter#evaluate(int) evaluates the value of Polynomial
     * 
     * @param requires an integer value x
     * 
     * @returns the float value
     */
    @Override
    public float evaluate(int x) {
        float evaluated_value = 0;
        for (int i = 0; i < size; i++) {
            evaluated_value = (float) (evaluated_value + (Math.pow(x,
                    array[i][1]) * array[i][0]));
        }
        return evaluated_value;
    }

    /*
     * (non-Javadoc)
     * 
     * @see Polynomial.PolyInter#degree() finds the degree of the polynomial
     * 
     * @param
     * 
     * @returns the integer value
     */
    @Override
    public int degree() {
        return array[0][1];
    }

    /*
     * (non-Javadoc)
     * 
     * @see Polynomial.PolyInter#addPoly(Polynomial.Poly, Polynomial.Poly)
     * method adds two polynomial
     * 
     * @param takes two Polynomial of type Poly
     * 
     * @retuns the polynomial of type Poly
     */
    @Override
    public Poly addPoly(Poly P1, Poly P2) {
        Poly P;
        int[][] poly1 = P1.getPoly();
        int[][] poly2 = P2.getPoly();
        int[][] addPoly = new int[P1.size + P2.size][2];
        int count = 0, count1 = 0;
        int i = 0;
        while (count < P1.size && count1 < P2.size) {
            if (poly1[count][1] == poly2[count1][1]) {
                addPoly[i][1] = poly1[count][1];
                addPoly[i][0] = poly1[count][0] + poly2[count1][0];
                i++;
                count++;
                count1++;
            } else if (poly1[count][1] < poly2[count1][1]) {
                addPoly[i][1] = poly2[count1][1];
                addPoly[i][0] = poly2[count1][0];
                count1++;
                i++;
            } else {
                addPoly[i][1] = poly1[count][1];
                addPoly[i][0] = poly1[count][0];
                count++;
                i++;
            }
        }
        while (count < P1.size) {
            addPoly[i][1] = poly1[count][1];
            addPoly[i][0] = poly1[count][0];
            count++;
            i++;
        }
        while (count1 < P2.size) {
            addPoly[i][1] = poly2[count1][1];
            addPoly[i][0] = poly2[count1][0];
            count1++;
            i++;
        }
        P = new Poly(addPoly);
        P.size = i;
        return P;
    }

    /*
     * (non-Javadoc)
     * 
     * @see Polynomial.PolyInter#multiplyPoly(Polynomial.Poly, Polynomial.Poly)
     * method adds two polynomial
     * 
     * @param takes two Polynomial of type Poly
     * 
     * @retuns the polynomial of type Poly
     */
    @Override
    public Poly multiplyPoly(Poly P1, Poly P2) {
        Poly P;
        int[][] poly1 = P1.getPoly();
        int[][] poly2 = P2.getPoly();
        int[][] multiPoly = new int[P1.size * P2.size][2];
        int count = 0;

        for (int i = 0; i < P1.size; i++) {
            for (int j = 0; j < P2.size; j++) {
                multiPoly[count][1] = poly1[i][1] + poly2[j][1];
                multiPoly[count][0] = poly1[i][0] * poly2[j][0];
                count++;
            }
        }
        P = new Poly(multiPoly);
        return P;
    }
}
