import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MainForJason {
    public static void main(String[] args) {

        JSONParser jsonParser = new JSONParser();
        Object object;

        try {

            object = jsonParser.parse(
                    new FileReader("C:\\Users\\Admin\\eclipse-workspace\\DS_Assignment2ques5\\src\\input.json.txt"));
            JSONObject jsonObject = (JSONObject) object;
            List<List<Long>> nestedList = new ArrayList<List<Long>>();
            for (int count = 0; count < 5; count++) {
                @SuppressWarnings("unchecked")
                List<Long> list = (List<Long>) jsonObject.get(String.valueOf(count));
                nestedList.add(list);
            }
            NestedList listAdd = new NestedList(nestedList);
            System.out.println(nestedList);
            System.out.println(listAdd.searchValue(12));
            System.out.println(listAdd.largestValue());
            System.out.println(listAdd.sumOfIntegerInList());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
