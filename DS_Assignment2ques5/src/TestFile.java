import static org.junit.Assert.*;

import org.junit.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


 public class TestFile {

    @Test
    public void testSum() {
    
    }
    
    @Test
    public void testLargest() {
      List<Integer> list1=new ArrayList<>(Arrays.asList(11, 4, 6)); 
      List<Integer> list2=new ArrayList<>(Arrays.asList(1, 3, 8));
      List<Integer> list3=new ArrayList<>(Arrays.asList(7, 2, 9));
      List<List<Integer>> testList=new ArrayList<>();
      testList.add(list1);
      testList.add(list2);
      testList.add(list3);
      int expected=11;
      NestedList nestedList=new NestedList(testList);
      assertEquals(expected, nestedList.largestValue());
    }
    
    @Test
    public void testSearchSuccessful() {
      List<Integer> list1=new ArrayList<>(Arrays.asList(11, 4, 6)); 
      List<Integer> list2=new ArrayList<>(Arrays.asList(1, 3, 8));
      List<Integer> list3=new ArrayList<>(Arrays.asList(7, 2, 9));
      List<List<Integer>> testList=new ArrayList<>();
      testList.add(list1);
      testList.add(list2);
      testList.add(list3);
      NestedList nestedList=new NestedList(testList);
      assertEquals(true,nestedList.searchValue(4));
    }
    
    @Test
    public void testSearchUnsuccessful() {
      List<Integer> list1=new ArrayList<>(Arrays.asList(11, 4, 6)); 
      List<Integer> list2=new ArrayList<>(Arrays.asList(1, 3, 8));
      List<Integer> list3=new ArrayList<>(Arrays.asList(7, 2, 9));
      List<List<Integer>> testList=new ArrayList<>();
      testList.add(list1);
      testList.add(list2);
      testList.add(list3);
      NestedList nestedList=new NestedList(testList);
      assertEquals(false,nestedList.searchValue(10));
    }

    @Test
    public void testSumUnsuccessful() {
      List<Integer> list1=new ArrayList<>(Arrays.asList(11, 4, 6)); 
      List<Integer> list2=new ArrayList<>(Arrays.asList(1, 3, 8));
      List<Integer> list3=new ArrayList<>(Arrays.asList(7, 2, 9));
      List<List<Integer>> testList=new ArrayList<>();
      testList.add(list1);
      testList.add(list2);
      testList.add(list3);
      NestedList nestedList=new NestedList(testList);
      int expected=51;
      assertEquals(expected,nestedList.sumOfIntegerInList());
    }
}

