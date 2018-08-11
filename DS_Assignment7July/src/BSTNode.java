

/**
 * custom BSTNode class with getter setter methods
 * @author Admin
 *
 */
public class BSTNode {
    String Key;
    String Value;
    BSTNode Parent;
    BSTNode leftChild;
    BSTNode rightChild;

    public BSTNode(String Key, String Value, BSTNode parent) {
        this.Key = Key;
        this.Value = Value;
        leftChild = rightChild = null;
        this.Parent = parent;
    }

    public BSTNode(String Key, String Value) {
        this.Key = Key;
        this.Value = Value;

    }

    /**
     * @return the key
     */
    public String getKey() {
        return Key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(String key) {
        Key = key;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return Value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        Value = value;
    }

    /**
     * @return the leftChild
     */
    public BSTNode getLeftChild() {
        return leftChild;
    }

    /**
     * @param leftChild the leftChild to set
     */
    public void setLeftChild(BSTNode leftChild) {
        this.leftChild = leftChild;
    }

    /**
     * @return the rightChild
     */
    public BSTNode getRightChild() {
        return rightChild;
    }

    /**
     * @param rightChild the rightChild to set
     */
    public void setRightChild(BSTNode rightChild) {
        this.rightChild = rightChild;
    }
}
