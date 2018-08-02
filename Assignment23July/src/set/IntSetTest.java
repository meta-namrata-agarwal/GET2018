package set;
import static org.junit.Assert.*;

import org.junit.Test;

public class IntSetTest {

    @Test
    public void memberTestPositive() {
        IntSet object = new IntSet(new int[] { 2, 5, 9, -1, 10, 13 });
        boolean test = object.isMember(5);
        assertEquals(true, test);
    }

    @Test
    public void MemberTestNegative() {
        IntSet object = new IntSet(new int[] { 2, 5, 9, -1, 10, 13 });
        boolean test = object.isMember(4);
        assertNotEquals(true, test);
    }

    @Test
    public void testSize() {
        IntSet object = new IntSet(new int[] { 9, 5, 9, -1, 13, 13 });
        int size = object.Size();
        assertEquals(3, size);
    }

    @Test
    public void testSizeNegative() {
        IntSet object = new IntSet(new int[] { 9, 5, 9, -1, 13, 13 });
        int size = object.Size();
        assertNotEquals(6, size);
    }

    @Test
    public void SubSetTestPositive() {
        IntSet object = new IntSet(new int[] { 9, 5, 9, -1, 13, 13 });
        IntSet object2 = new IntSet(new int[] { 9, 5 });
        boolean isSubset = object.isSubSet(object2);
        assertEquals(true, isSubset);
    }

    @Test
    public void SubSetNegative() {
        IntSet object = new IntSet(new int[] { 9, 5, 9, -1, 13, 13 });
        IntSet object2 = new IntSet(new int[] { 9, 5, 2, 4 });
        boolean isSubset = object.isSubSet(object2);
        assertNotEquals(true, isSubset);
    }

    @Test
    public void testComplement() {
        IntSet object = new IntSet(new int[] { 2, 5, 8, 11 });
        IntSet object2;
        object2 = object.complement();
        int[] array = new int[1000];
        for (int i = 1; i <= 1000; i++) {
            if (i == 2 || i == 5 || i == 8 || i == 11) {
                array[i - 1] = 0;
            } else {
                array[i - 1] = i;
            }
        }
        int[] result = object2.getArray();
        assertArrayEquals(array, result);
    }

    @Test
    public void testUnion() {
        IntSet object, object2, result;
        object = new IntSet(new int[] { 2, 3, 8, 9 });
        object2 = new IntSet(new int[] { 2, 4, 7, 10 });
        result = object.unionSet(object2, object);
        IntSet checkUnion = new IntSet(new int[] { 2, 3, 4, 7, 8, 9, 10 });
        assertArrayEquals(checkUnion.getArray(), result.getArray());
    }
}
