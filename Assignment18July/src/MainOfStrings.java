import java.util.*;

public class MainOfStrings {

	public static void main(String[] args)

	{
		StringOperations so = new StringOperations();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter first string");
		String str1 = sc.nextLine();

		System.out.println("enter second string");
		String str2 = sc.nextLine();

		int result = so.isEqual(str1, str2);
		System.out.println("result is- " + result);

		String reverse = so.reverseString(str1);
		System.out.println("reversed string is- " + reverse);

		String Case = so.toggleCase(str1);
		System.out.println("cased string is-" + Case);

		String word = so.largestWord(str1);
		System.out.println("largest word string is-" + word);
		sc.close();
	}

}
