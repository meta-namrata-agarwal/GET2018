import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class TestFile {

    @Test
    public void testSum() {
      List<Integer> list1=(Arrays.asList(3, 4, 6)); 
      List<Integer> list2=new ArrayList<>(Arrays.asList(1, 6, 8));
      List<Integer> list3=new ArrayList<>(Arrays.asList(3, 2, 9));
      List<List<Long>> testList=new ArrayList<>();
      testList.add(list1);
      testList.add(list2);
      testList.add(list3);
      int expected=42;
      NestedList nestedList=new NestedList(testList);
      assertEquals(expected,nestedList.sumOfIntegerInList());
    }
    
    @Test
    public void testLargest() {
      List<Integer> list1=new ArrayList<>(Arrays.asList(3, 4, 6)); 
      List<Integer> list2=new ArrayList<>(Arrays.asList(1, 6, 8));
      List<Integer> list3=new ArrayList<>(Arrays.asList(3, 2, 9));
      List<List<Integer>> testList=new ArrayList<>();
      testList.add(list1);
      testList.add(list2);
      testList.add(list3);
      int expected=9;
      NestedList nestedList=new NestedList(testList);
      assertEquals(expected, nestedList.largestValue());
    }
    
    @Test
    public void testSearchSuccessful() {
      List<Integer> list1=new ArrayList<>(Arrays.asList(3, 4, 6)); 
      List<Integer> list2=new ArrayList<>(Arrays.asList(1, 6, 8));
      List<Integer> list3=new ArrayList<>(Arrays.asList(3, 2, 9));
      List<List<Integer>> testList=new ArrayList<>();
      testList.add(list1);
      testList.add(list2);
      testList.add(list3);
      NestedList nestedList=new NestedList(testList);
      assertEquals(true,nestedList.searchValue(4));
    }
    
    @Test
    public void testSearchUnsuccessful() {
      List<Integer> list1=new ArrayList<>(Arrays.asList(3, 4, 6)); 
      List<Integer> list2=new ArrayList<>(Arrays.asList(1, 6, 8));
      List<Integer> list3=new ArrayList<>(Arrays.asList(3, 2, 9));
      List<List<Integer>> testList=new ArrayList<>();
      testList.add(list1);
      testList.add(list2);
      testList.add(list3);
      NestedList nestedList=new NestedList(testList);
      assertEquals(false,nestedList.searchValue(10));
    }

}
