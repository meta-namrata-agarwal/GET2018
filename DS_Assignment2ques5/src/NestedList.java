import java.util.ArrayList;
import java.util.List;

public class NestedList implements NestedListInterface {

    private List<List<Long>> nestedList;

    public NestedList(List<List<Long>> nestedList2) {
        this.nestedList = nestedList2;
    }

    @Override
    public Long  sumOfIntegerInList() {
        if (nestedList.isEmpty())
            throw new AssertionError();
       
        Long sum =  (long) 0;
        for (int i = 0; i < nestedList.size(); i++) {
            for (int j = 0; j < nestedList.get(i).size(); j++) {
                sum=sum+nestedList.get(i).get(j);
               // System.out.println(nestedList.get(i).get(j));
            }
            
        }
        

        return sum;
    }

    @Override
    public Long largestValue() {
        if(nestedList.isEmpty())
            throw new AssertionError();
        Long max=(long) 0;
        for (int i = 0; i < nestedList.size(); i++) {
            for (int j = 0; j < nestedList.get(i).size(); j++) {
                if(nestedList.get(i).get(j)>max)
                {
                    max=nestedList.get(i).get(j);
                }
            }
        }
        System.out.println(max);
        return max;
    }

    @Override
    public boolean searchValue(int value) {
        if(nestedList.isEmpty())
            throw new AssertionError();
       
        for (int i = 0; i < nestedList.size(); i++) {
            for (int j = 0; j < nestedList.get(i).size(); j++) {
                if(value==nestedList.get(i).get(j))
                {
                  return true;
                }
            }
        }
        return false;
    }

}
