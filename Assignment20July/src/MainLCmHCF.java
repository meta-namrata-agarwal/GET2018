import java.util.Scanner;

public class MainLCmHCF {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		RecursionLcmHcf rlm = new RecursionLcmHcf();

		System.out.println("ENTER FIRST NUMBER");
		int num1 = userInput.nextInt();

		System.out.println("ENTER SECOND NUMBER");
		int num2 = userInput.nextInt();

		int lcmValue = rlm.findLcm(num1, num2);
		System.out.println("LCM OF " + num1 + " and " + num2 + " is " + lcmValue);

		int hcfValue = rlm.findHcf(num1, num2);
		System.out.println("HCF OF " + num1 + " and " + num2 + " is " + hcfValue);

		int size = userInput.nextInt();
		int array[] = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = userInput.nextInt();
		}

		Search sc = new Search();
		int element_searched = userInput.nextInt();
		int linearIndex = sc.searchElementByLinear(array, 0, size - 1, element_searched);
		if (linearIndex == -1)
			System.out.println("element to be searched is not present in the array ");
		else
			System.out.println("element to be searched is at index " + linearIndex);

		int binary_index = sc.searchElementByBinary(array, 0, size-1, element_searched);
		if (binary_index == -1)
			System.out.println(" binary element to be searched is not present in the array ");
		else
			System.out.println("binary element to be searched is at index " + binary_index);

		userInput.close();

	}

}
