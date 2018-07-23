interface interConversion
{
	public int baseXtoDeci(String str, int base);
	public String deciToBaseX(int num, int base);
}
public class Conversion implements interConversion
{	
	char hex[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'}; 
	public int baseXtoDeci(String num1, int base)
	 
	{	
		int val=0;
		int d=0;
         num1 = num1.toUpperCase();   
         for (int i = 0; i < num1.length(); i++)  
         {  
        	 char c = num1.charAt(i); 
             for(int j=0;j<hex.length;j++)
             {
            	 if (hex[j]==c)
            		 	d=j;
             }
             val = base*val + d;
             
         }   
         return val; 
	}
		
	public String deciToBaseX(int num1, int base)
	{	
		String  hexString="";
		int rem=0;
		while(num1>0)
			{
				rem=num1%base; 
				hexString=hex[rem]+hexString; 
				num1=num1/base;
			}
		return hexString;
	}
	
		
}
