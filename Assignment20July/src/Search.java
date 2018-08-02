/**
 * this class finds the index of element in array using linear and binary search
 * 
 */
public class Search {

	/**
	 * Finds the presence of an element in array
	 * 
	 * @param requires
	 *            a array and the element to be searched
	 * 
	 * @return index of the searched element if present
	 */
	public int searchElementByLinear(int[] array, int initial_index, int size,
			int element_searched) {
		if (size < initial_index)
			return -1;
		if (array[initial_index] == element_searched)
			return initial_index;
		return searchElementByLinear(array, initial_index + 1, size,
				element_searched);
	}

	/**
	 * Finds the presence of an element in array
	 * 
	 * @param requires
	 *            a sorted array and the element to be searched
	 * 
	 * @return index of the searched element if present
	 */

	public int searchElementByBinary(int[] array, int initial_index, int size,
			int element_searched) {
		int mid;
		if (initial_index > size)
			return -1;
		mid = (initial_index + size) / 2;
		if (array[mid] == element_searched)
			return mid;
		else if (array[mid] > element_searched)
			return searchElementByBinary(array, initial_index, mid - 1,
					element_searched);
		else
			return searchElementByBinary(array, mid + 1, size, element_searched);

	}

}
