public class StringOperations {
	int count = 0;
	int length = 0;
	String rev = "";
	String word = "";
	String max1 = "";

	/**
	 * compare two strings which are case sensitive
	 * 
	 * @param string1
	 *            and string2
	 * @return true if equal else false
	 */

	public int isEqual(String str1, String str2) {
		if (str1.length() == str2.length()) {
			for (int i = 0; i < str1.length(); i++) {
				if (str1.charAt(i) == str2.charAt(i)) {
					length++;
				}

			}
			if (length == str1.length())
				return 1;
			else
				return 0;
		} else
			return 0;
	}

	/**
	 * reveses the string
	 * 
	 * @param takes
	 *            input as string
	 * @return returns a reversed string
	 */
	public String reverseString(String str1) {

		for (int i = str1.length() - 1; i > 0; i--) {
			rev = rev + str1.charAt(i);
		}
		rev = rev + str1.charAt(0);
		return rev;
	}

	/**
	 * cases the string
	 * 
	 * @param takes
	 *            input as string
	 * @return returns a reversed string
	 */

	public String toggleCase(String str1) {
		char[] charArray = str1.toCharArray();

		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] >= 'A' && charArray[i] <= 'Z') {
				charArray[i] = (char) (charArray[i] + 32);
			} else if (charArray[i] >= 'a' && charArray[i] <= 'z')
				charArray[i] = (char) (charArray[i] - 32);

		}
		str1 = new String(charArray);
		return str1;
	}

	/**
	 * cases the string
	 * 
	 * @param takes
	 *            input as string
	 * @return returns a longest wors in string
	 */
	public String largestWord(String str1) {
		str1 = str1 + " ";
		for (int i = 0; i < str1.length(); i++) {
			char c = str1.charAt(i);
			if (c != ' ') {
				word = word + c;
				count++;
			} else {
				if (word.length() > max1.length()) {
					max1 = word;
					word = "";
				}
			}
		}
		return max1;
	}

}
