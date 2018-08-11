

import java.util.List;

/**
 * Dictionary interface with the methods to be implemented
 * 
 * @author Namrata Agarwal
 *
 * 
 */
public interface DictionaryInter {

    public String deleteKeyValue(String key);

    public String getValueFromKey(String key);

    public String addKeyValue(String key, String value);

    public List<BSTNode> sortedList();

    public List<BSTNode> sortedListBetweenKeys(String key1, String key2);

}
