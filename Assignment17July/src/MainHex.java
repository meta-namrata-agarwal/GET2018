import java.util.*;

public class MainHex {

	public static void main(String[] args)

	{
		Scanner sc = new Scanner(System.in);
		HexCalc hc = new HexCalc();
		System.out.println("enter base for conversion");
		int base = sc.nextInt();
		System.out.println("enter first  String-");
		String String1 = sc.next();
		System.out.println("enter second  String-");
		String String2 = sc.next();
		System.out.println("enter decimal no. for conversion");
		int integerNo = sc.nextInt();

		int deci = hc.baseXtoDeci(String1, base);
		String hexi = hc.deciToBaseX(integerNo, base);
		String sum = hc.add(String1, String2, base);
		String differ = hc.subtract(String1, String2, base);
		String multiply = hc.multiplication(String1, String2, base);
		String divide = hc.division(String1, String2, base);
		boolean isGreat = hc.isGreater(String1, String2);
		boolean isLess = hc.isLess(String1, String2);
		boolean equal = hc.equal(String1, String2);

		System.out.println("String one is " + String1 + "\nSecond string is "
				+ String2 + "\nDifference is " + differ + "\nMultiply= "
				+ multiply + "\nAdd= " + sum + "\nDivide= " + divide
				+ "\nisGreat= " + isGreat+"\nisLess= "+isLess+"\nequal= "+equal);
		sc.close();
	}

}
