import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * class character count to count the number of unique character in the string
 * conditions- if same string is passed again it should not traverse again and
 * return the stored value for unique character
 * 
 * @author Namrata Agarwal
 *
 */

public class CharacterCount {
    String string;
    HashMap<Character, Integer> map;
    List<Data> cache;

    /**
     * constructor
     */
    public CharacterCount() {
        map = new LinkedHashMap<>();
        cache = new ArrayList<>();
    }

    /**
     * getUniquesCount method to count the number of character of each type
     * 
     * @param string
     * @return count of unique character
     */
    public int getUniqueCount(String string) {
        int count = 0;
        for (Data data : cache) {
            if (string.equals(data.getString())) {
                System.out.println("string already exists");
                count = data.getcount();
                System.out.println(count);
                throw new AssertionError();
            }
        }
        getCountOfcharacters(string);
        for (int i : map.values()) {
            count++;
        }
        map.clear();
        Data newData = new Data(string, count);
        System.out.println();
        System.out.println(count);
        cache.add(newData);
        return count;
    }

    /**
     * method to check if string present else add string and get character count
     * 
     * @param string
     */
    private void getCountOfcharacters(String string) {
        for (Character character : string.toCharArray()) {
            if (map.containsKey(character))
                map.put(character, map.get(character) + 1);
            else
                map.put(character, 1);
        }
        System.out.println(map);
    }

}