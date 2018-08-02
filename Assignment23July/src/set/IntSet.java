package set;

/*
 * this class finds the operations performed on set 
 */
public final class IntSet implements setInter {

    private int array[];
    private int size;

    /*
     * Constructor to take the input value
     */
    public IntSet(int[] arr) {
        this.array = new int[1000];
        for (int i : arr) {
            if (i > 0 && i < 1001) {
                if (this.array[i - 1] != i) {
                    this.array[i - 1] = i;
                    size++;
                }
            }
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see setInter#isMember(int) this method finds the member of the set
     * 
     * @param requires an integer value
     * 
     * @return the a boolean value
     */
    @Override
    public boolean isMember(int x) {
        for (int i = 0; i < size; i++) {
            if (array[x - 1] == x)
                return true;
        }
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see setInter#Size() finds the size of the set
     * 
     * @param
     * 
     * @return the size of set
     */
    @Override
    public int Size() {
        return size;
    }

    /*
     * (non-Javadoc)
     * 
     * @see setInter#isSubSet(IntSet) finds the subset of the set
     * 
     * @param requies a input set of type set
     * 
     * @return boolean value
     */
    @Override
    public boolean isSubSet(IntSet inputSet) {
        int inputSize = inputSet.size;
        if (inputSize > size) {
            return false;
        } else {
            for (int i = 0; i < 1000; i++) {
                if (inputSet.array[i] == 0) {
                    continue;
                } else {
                    if (inputSet.array[i] == this.array[i])
                        continue;
                    else
                        return false;
                }
            }
            return true;
        }
    }

    /*
     * print the elements of the set
     */
    public void printElements() {
        for (int i = 0; i < 1000; i++) {
            if (array[i] != 0)
                System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    /*
     * (non-Javadoc)
     * 
     * @see setInter#unionSet(IntSet, IntSet) find the union of two set
     * 
     * @param takes two set of type set
     * 
     * @returns the union of type set
     */
    @Override
    public IntSet unionSet(IntSet set1, IntSet set2) {
        IntSet instance;
        int j = 0;
        int union[] = new int[set1.size + set2.size];
        for (int i = 0; i < 1000; i++) {
            if (set1.isMember(i + 1) || set2.isMember(i + 1)) {
                union[j] = i + 1;
                j++;
            } else
                continue;
        }
        instance = new IntSet(union);
        return instance;
    }

    /*
     * (non-Javadoc)
     * 
     * @see setInter#complement() find the complement
     * 
     * @param
     * 
     * @return a set
     */
    @Override
    public IntSet complement() {
        IntSet instance;
        int[] testArray = new int[1000 - size];
        int count = 0;
        for (int i = 0; i < 1000; i++) {
            if (array[i] == 0) {
                testArray[count] = i + 1;
                count++;
            }
        }
        instance = new IntSet(testArray);
        return instance;
    }

    /*
     * used to get array for unit test cases
     */
    public int[] getArray() {
        return array;
    }

}