import java.io.*;
import java.text.ParseException;
import java.util.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * BinarySearchDictionary class implementing the Dictionary Interface
 * 
 * @author Namrata Agarwal
 *
 */
public class BinarySearchDictionary implements DictionaryInter {

    private BSTNode root;
    List<BSTNode> sortedListOfDictionary  ;

   

    public BinarySearchDictionary(File f) throws FileNotFoundException,IOException, ParseException, org.json.simple.parser.ParseException {     
        root = null;
        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(new FileReader(f));
        for (Object Key : obj.keySet()) {
            addKeyValue(Key.toString(), obj.get(Key).toString());
        }
    }

    /**
     * addKeyValue method to add key and value to the dictionary using a helper
     * recursive function
     * 
     * @param String
     *            Key
     * @param String
     *            value
     * @return String value
     */
    @Override
    public String addKeyValue(String Key, String Value) {
        if (root == null) {
            root = new BSTNode(Key, Value, null);
            return null;
        } else {
                return addKeyHelperRecursive(Key, Value, root);
        }
    }

    /**
     * helper recursive method to add data to the dictionary using BST
     * 
     * @param Key
     * @param Value
     * @param root
     * @return Value
     */
    private String addKeyHelperRecursive(String Key, String Value, BSTNode root) {
        if (Key.toUpperCase().compareTo(root.getKey().toUpperCase()) == 0) {
         ///  /System.out.println(root.getValue());
            String oldValue = root.getValue();
            root.setValue(Value);
            return oldValue;
        } else if (Key.toUpperCase().compareTo(root.getKey().toUpperCase()) > 0) {
            if (root.getRightChild() == null) {
                root.setRightChild(new BSTNode(Key, Value, root));
                return null;
            } else
                addKeyHelperRecursive(Key, Value, root.rightChild);
        } else if (Key.toUpperCase().compareTo(root.getKey().toUpperCase()) < 0) {
            if (root.getLeftChild() == null) {
                root.setLeftChild(new BSTNode(Key, Value, root));
                return null;
            } else
                addKeyHelperRecursive(Key, Value, root.leftChild);
        } else
            System.out.println("something went wrong");
        return null;
    }

    /**
     * Delete key method to delete key value pair
     * 
     * @param key
     * @return value
     */
    @Override
    public String deleteKeyValue(String Key) {
       // System.out.println(root.getKey());
        deleteRecursive(root, Key);
        return null;
    }

    /**
     * helper recursive method to delete data to the dictionary using BST
     * 
     * @param root
     * @param Key
     * @return
     */
    private BSTNode deleteRecursive(BSTNode root, String Key) {
        //System.out.println(root.getKey());
        /* Base Case: If the tree is empty */
        if (root == null)  return root;
 
        /* Otherwise, recur down the tree */
        if (Key.compareTo(root.getKey())<0)
        {
           // System.out.print("loop1");
            //System.out.println(root.leftChild.Key);
            root.leftChild = deleteRecursive(root.leftChild, Key);
            
        }
        else if (Key.compareTo(root.getKey())>0)
        {
            root.rightChild = deleteRecursive(root.rightChild, Key);
        }
 
        
        else
        {
            
            if (root.leftChild == null)
            {
                return root.rightChild;
            }
            else if (root.rightChild == null)
            {
                return root.leftChild;
            }            
            root.Key = minValue(root.rightChild);
            root.rightChild = deleteRecursive(root.rightChild, root.Key);
        }
       
        return root;
    }
 
    String minValue(BSTNode root)
    {
        String minv = root.Key;
        while (root.leftChild != null)
        {
            minv = root.leftChild.Key;
            root = root.leftChild;
        }
        return minv;
    }
    
    

    /**
     * list of BSTNode in sorting way
     */
    @Override
    public List<BSTNode> sortedList() {
        sortedListOfDictionary  = new ArrayList<BSTNode>();
        return  SortedRecursive(root);
    }

    /**
     * helper recursive method to data to the dictionary using BST in sorted
     * order
     * 
     * @param root
     * @return list of BSTNode
     */
    private List<BSTNode> SortedRecursive(BSTNode root) {
      
        if (root != null) {
            SortedRecursive(root.leftChild);
            if (!sortedListOfDictionary.contains(root))
            sortedListOfDictionary.add(root);
            SortedRecursive(root.rightChild);
        }
        // System.out.println(sortedListOfDictionary.size());
        //sortedListOfDictionary=sorted;
        return sortedListOfDictionary;
    }

    /**
     * GEtVAlue method to get value using Key
     * 
     * @param Key
     * @return value
     */
    @Override
    public String getValueFromKey(String Key) {
        return getvalueRecursiveMethod(root, Key).getValue();
    }

    /**
     * helper recursive method to search Key from the dictionary using BST
     * 
     * @param root
     * @param Key
     * @return
     */
    private BSTNode getvalueRecursiveMethod(BSTNode root, String Key) {
        if (root == null)
            return null;
        else if (Key.equals(root.getKey())) {
            return root;
        } else if (Key.compareTo(root.getKey()) < 0) {
            return getvalueRecursiveMethod(root.leftChild, Key);
        } else if (Key.compareTo(root.getKey()) > 0) {
            return getvalueRecursiveMethod(root.rightChild, Key);
        } else
            System.out.println("not found");
        return null;

    }

    /**
     * list of BSTNode in sorting way between two specified keys
     */
    @Override
    public List<BSTNode> sortedListBetweenKeys(String Key1, String Key2) {
        BSTNode nodeForKey1 = getvalueRecursiveMethod(root, Key1);

        BSTNode nodeForKey2 = getvalueRecursiveMethod(root, Key2);
        
        if (nodeForKey1 == null || nodeForKey2 == null)
            throw new AssertionError();
        List<BSTNode> listOfHelper = new ArrayList<BSTNode>();
        listOfHelper.add(nodeForKey1);
        for (BSTNode node : sortedListOfDictionary) {
            if (node.getKey().compareTo(Key1) > 0
                    && node.getKey().compareTo(Key2) < 0) {
                listOfHelper.add(node);
            }
        }
        listOfHelper.add(nodeForKey2);
        return listOfHelper;
    }
}
