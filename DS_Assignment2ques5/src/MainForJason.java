import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * 
 * @author User20
 *
 */
public class MainForJason {
    public static void main(String[] args) {

        JSONParser jsonParser = new JSONParser();
        Object object;
        List<List<Integer>> nestedList = new ArrayList<List<Integer>>();

        try {

            object = jsonParser
                    .parse(new FileReader(
                            "C:/Users/User20/workspace/DS_Assignment2ques5/jason.json.txt"));
            JSONObject jsonObject = (JSONObject) object;

            for (Object jsonKey : jsonObject.keySet()) {

                JSONArray jsonArray = (JSONArray) jsonObject.get(jsonKey);
                List<Integer> list = new ArrayList<>();
                for (Object value : jsonArray) {

                    list.add(Integer.parseInt(value.toString()));

                }
                nestedList.add(list);
            }
            NestedList listAdd = new NestedList(nestedList);
            System.out.println(nestedList);
            System.out.println(listAdd.searchValue(2));
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
