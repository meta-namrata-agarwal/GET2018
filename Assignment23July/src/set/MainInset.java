package set;

public class MainInset {

    public static void main(String[] args) {
        int set1[] = { 5, -1, 3, 13, 40, 13, 6, 7, 4, 4 };
        IntSet object1 = new IntSet(set1);
        System.out.print("Members of set 1 are: ");
        object1.printElements();
        System.out.println("Size of set1 elements are " + object1.Size());
        System.out.println("is it memeber - " + object1.isMember(5));
        System.out.println("is it memeber - " + object1.isMember(83));

        int set2[] = { 3, 4, 5, 6, 8, 3, 9, 122, 1, 2 };
        IntSet object2 = new IntSet(set2);
        System.out.print("Members of set 2 are: ");
        object2.printElements();
        IntSet object3;
        IntSet object4;

        object3 = object1.complement();
        System.out.println("complement of set1 is:");
        object3.printElements();

        object4 = object1.unionSet(object1, object2);
        System.out.println("Members of union set1 and set2 are: ");
        object4.printElements();
        boolean subset = object1.isSubSet(object2);
        System.out.println("is it subset: " + subset);

    }
}