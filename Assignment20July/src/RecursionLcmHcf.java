/**
 * this class finds the LCM and HCF of two numbers
 *
 */
public class RecursionLcmHcf {
	/**
	 * Finds the lowest common multiple of two numbers
	 * 
	 * @param requires
	 *            two positive numbers as input
	 * 
	 * @return lcm of the numbers
	 */
	private int factor = 1;

	public int findLcm(int num1, int num2) throws ArithmeticException {

		if (factor % num1 == 0 && factor % num2 == 0) {
			return factor;
		}
		factor++;
		findLcm(num1, num2);
		return factor;
	}

	/**
	 * Finds the greatest common multiple of two numbers
	 * 
	 * @param requires
	 *            two positive numbers as input
	 * 
	 * @return HCF of the numbers
	 */
	public int findHcf(int num1, int num2) throws ArithmeticException {

		if (num2 == 0)
			return num1;
		return findHcf(num2, num1 % num2);
	}

}
