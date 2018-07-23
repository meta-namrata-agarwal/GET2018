interface interHexCalc
{
	public String add(String str1,String str2,int base);
	public String subtract(String str1,String str2,int base);
	public String multiplication(String str1,String str2,int base);
	public String division(String str1,String str2,int base);
	public boolean isGreater(String str1,String str2);
	public boolean isLess(String str1,String str2);
	public boolean equal(String str1,String str2);
	
}
public class HexCalc extends Conversion implements interHexCalc
{
	private int sum;
	private int difference;
	private int multiply;
	private int divide;
	private int length;
	int count;
	Conversion con=new Conversion();
	public String add(String num1,String num2,int base)
	{	
		int number1=con.baseXtoDeci(num1,base);
		int number2=con.baseXtoDeci(num2,base);
		sum=number1+number2;
		String summation=super.deciToBaseX(sum,base);
		return summation;
	}
	
	public String subtract(String num1,String num2,int base)
	{
		int number1=con.baseXtoDeci(num1,base);
		int number2=con.baseXtoDeci(num2,base);
		difference=number1-number2;
		String DIFFERENCE=super.deciToBaseX(difference,base);
		return DIFFERENCE;
	}
	
	public String multiplication(String num1,String num2,int base)
	{
		int number1=con.baseXtoDeci(num1,base);
		int number2=con.baseXtoDeci(num2,base);
		multiply=number1*number2;
		String multiplication=super.deciToBaseX(multiply,base);
		return multiplication;
	}
	
	public String division(String num1,String num2,int base)
	{
		int number1=con.baseXtoDeci(num1,base);
		int number2=con.baseXtoDeci(num2,base);
		divide=number1/number2;
		String division=super.deciToBaseX(divide,base);
		return division;
		
	}
	
	public boolean isGreater(String num1, String num2) 
	{
		int i=0;
		if (num1.length() > num2.length())
			return true;
		else if (num1.length() < num2.length())
			return false;
		else {
			for(count=0;count<(num1.length())/2;count++)
			{
				if (num1.charAt(count) >num2.charAt(count)) 
				{
					i++;	
					System.out.println("count"+count);
				}
			}
			if (i == num1.length()/2)
				return true;
			else
				return false;
		}

	}
	
	public boolean isLess(String num1,String num2)
	{
		int i=0;
		if(num1.length()<num2.length())
			return true;
		else if(num1.length()<num2.length())
			return false;
		else {
			for(count=0;count<(num1.length())/2;count++)
			{
				if (num1.charAt(count) >num2.charAt(count)) 
				{
					i++;	
					System.out.println("count"+count);
				}
			}
			if (i == num1.length()/2)
				return false;
			else 
				return true;
		}
			
	}
	
	public boolean equal(String num1, String num2)
	{
			if (num1.length() == num2.length()) {
				for (int i = 0; i < num1.length(); i++) {
					if (num1.charAt(i) == num2.charAt(i)) {
						length++;
					}

				}
				if (length == num1.length())
					return true;
				else
					return false;
			} else
				return false;
		}
}
