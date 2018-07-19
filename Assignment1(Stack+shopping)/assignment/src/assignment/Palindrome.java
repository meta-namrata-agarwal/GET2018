package assignment;
import java.util.*;
public class Palindrome {

	Stack<Character> stack = new Stack<Character>();
	int top = -1;

	public boolean isPalindrome(String s) {
	    for (int i = 0; i < s.length(); i++) {
	        stack.push(s.charAt(i));
	        top++;
	    }

	    System.out.println("value of top is " + top);
	    String returnString = "";

	    while (!stack.isEmpty()) {
	        returnString += stack.pop();
	    }
	    System.out.println(returnString);

	    return returnString.equals(s);
	}
	
	
	public static void main(String[] args) 
	{
		 Palindrome palin = new Palindrome();
		 Scanner sc=new Scanner(System.in);
		 String input= sc.next();
		    if (palin.isPalindrome(input)) {
		        System.out.println("is palindrome");
				} else {
		        System.out.println("not a palindrome");
		    }
		    sc.close();
		
	}

}
