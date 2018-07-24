import java.util.Scanner;


public class mainArrOperation {

	public static void main(String[] args) 
	{
	
		Scanner sc=new Scanner(System.in);
		int size=sc.nextInt();
		int arr[]=new int[size];
		for(int i=0;i<size;i++)
		{
			arr[i]=sc.nextInt();
		}
		

		int x=sc.nextInt();
		int y=sc.nextInt();
		sc.close();
		ArrOperation ao=new ArrOperation();
		
		int arry[] =ao.fixXYArray(arr, x, y, size);

		for(int i=0;i<size;i++)
			System.out.println("arry"+arry[i]);
			
		int index=ao.clumpArray(arr, size);
		System.out.println("indez ix"+index);
		int index1=ao.splitIndex(arr, size);
		System.out.println("indez ix"+index1);
		
	}

}

