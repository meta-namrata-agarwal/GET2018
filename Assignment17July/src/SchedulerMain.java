import java.util.Scanner;


public class SchedulerMain
 {

	public static void main(String[] args) 
	
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter no. of process");
		int numberOfProcess=sc.nextInt();
		new JobScheduler(numberOfProcess);		
		sc.close();
	}
	
}

