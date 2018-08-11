import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.json.JSONException;
import org.json.simple.parser.ParseException;

public class Main {

    public static void main(String[] args)
            throws FileNotFoundException, IOException, ParseException, JSONException, java.text.ParseException {

        BinarySearchDictionary c = new BinarySearchDictionary(
                new File("C:\\Users\\Admin\\eclipse-workspace\\DS_Assignment7July\\src\\check.jason"));

        List<BSTNode> list = c.sortedList();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getKey() + " " + list.get(i).getValue());
        }
        System.out.println();
        c.deleteKeyValue("dog");

        List<BSTNode> list1 = c.sortedList();
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i).getKey() + " " + list1.get(i).getValue());
        }

        System.out.println();
        List<BSTNode> list2 = c.sortedListBetweenKeys("bat", "fruit");
        for (int i = 0; i < list2.size(); i++) {
            System.out.println(list2.get(i).getKey() + " " + list2.get(i).getValue());
        }

    }

}
