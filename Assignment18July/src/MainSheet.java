import java.util.*;

public class MainSheet {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter number of students");
		int no_of_students = sc.nextInt();
		MarkSheet ms = new MarkSheet(no_of_students);

		System.out.println("maximum of all grades is ");
		double max = ms.maxGrade(no_of_students);
		System.out.println(max);

		System.out.println("minimum of all grades is ");
		double min = ms.minGrade(no_of_students);
		System.out.println(min);

		System.out.println("avg grade is ");
		double avg1 = ms.avgGrade(no_of_students);
		System.out.println(avg1);

		System.out.println("avg of passed students is ");
		double avg = ms.avgPassed(no_of_students);
		System.out.println(avg);
		sc.close();
	}

}
