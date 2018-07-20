import java.util.*;

public class MarkSheet {
	private double max;
	private double min = 999999999;
	private double grades[];
	private double avg;
	private double avgPass;

	/**
	 * constructor with parameter
	 * 
	 * @param requires
	 *            height and width
	 * @return area of the triangle
	 */
	public MarkSheet(int no_of_students) {
		grades = new double[no_of_students];
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the grades of students");
		for (int i = 0; i < no_of_students; i++) {
			System.out.println(" grades of student " + (i + 1));
			grades[i] = sc.nextDouble();
		}
		sc.close();
	}

	/**
	 * Find a maximum grade among all grades
	 * 
	 * @param requires
	 *            grades and no. of students
	 * @return maximum grade
	 */
	public double maxGrade(int no_of_students) {
		for (int i = 0; i < no_of_students; i++) {
			if (grades[i] > max)
				max = grades[i];
		}
		return max;
	}

	/**
	 * Find a minimum grade among all grades
	 * 
	 * @param requires
	 *            grades and no. of students
	 * @return minimum grade
	 */
	public double minGrade(int no_of_students) {
		for (int i = 0; i < no_of_students; i++) {
			if (grades[i] < min)
				min = grades[i];
		}
		return min;
	}

	/**
	 * Find a average grade
	 * 
	 * @param requires
	 *            grades and no. of students
	 * @return average grade
	 */
	public double avgGrade(int no_of_students) {
		for (int i = 0; i < no_of_students; i++) {
			avg = grades[i] + avg;
		}
		avg = avg / no_of_students;
		return avg;
	}

	/**
	 * Find a average passed students
	 * 
	 * @param requires
	 *            grades and no. of students and condition of passing
	 * @return percentage of passes students
	 */
	public double avgPassed(int no_of_students) {
		for (int i = 0; i < no_of_students; i++) {
			if (grades[i] >= 40) {
				avgPass++;
			}
		}
		avgPass = (avgPass / no_of_students) * 100;
		return avgPass;
	}
}
