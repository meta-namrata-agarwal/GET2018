package set;

public interface setInter {
    public boolean isMember(int x);

    public int Size();

    public boolean isSubSet(IntSet set1);

    public IntSet unionSet(IntSet set1, IntSet set2);

    public IntSet complement();

}
