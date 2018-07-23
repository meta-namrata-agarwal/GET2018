public class ArrOperation {
	/**
	 * swaps the element y with the other element to attain its position next to
	 * element x
	 * 
	 * @param requires
	 *            elements x and elements y from the array and the array input
	 *            index of element x needs not to be changed
	 * 
	 * @return array
	 */
	public int[] fixXYArray(int arr[], int x, int y, int size) {
		if (arr.length == 0) {
			throw new AssertionError("array of method clumpArray is empty");
		} else {

			int countX = 0;
			int countY = 0;
			for (int k = 0; k < size; k++) {
				if (arr[k] == x)
					countX++;
				if (arr[k] == y)
					countY++;
			}
			if (countX != countY)
				throw new AssertionError("unequal number of  an dy presnt");
			
			for (int k = 1; k < size; k++) {
				if (arr[k - 1] == x && arr[k] == x)
					throw new AssertionError("present at consecutie place");
			}
			if(arr[size-1]==x)
					throw new AssertionError("element x at last index");
			
			{
				int requiredArray[] = new int[size];

				int dumyArray[] = new int[size];

				int dumyArray1[] = new int[size];

				int i = 0;
				for (int j = 0; j < size; j++) {
					if (arr[j] != y) {
						dumyArray[i] = arr[j];
						i++;
					}
				}
				int loop = 0;
				for (int j = 0; j < i; j++) {
					if (dumyArray[j] != x) {
						dumyArray1[loop] = dumyArray[j];
						loop++;
					}
				}
				for (int counter = 0; counter < size; counter++) {
					if (arr[counter] == x) {
						requiredArray[counter] = x;
						requiredArray[counter + 1] = y;
					}
				}

				int k = 0;
				for (int counter = 0; counter < size; counter++) {
					if (requiredArray[counter] == 0) {
						requiredArray[counter] = dumyArray1[k];
						k++;
					}
				}
				return requiredArray;
			}
		}
	}

	/**
	 * Finds count of consecutive repeated elements
	 * 
	 * @param requires
	 *            an array
	 * 
	 * @return count of repeated elements
	 */
	public int clumpArray(int arr[], int size) {

		if (arr.length == 0) {
			throw new AssertionError("array of method clumpArray is empty");
		} else {
			int clumpcnt = 0;
			boolean inclump = false;
			for (int i = 1; i < size; i++) {
				if (arr[i] == arr[i - 1]) {
					if (!inclump) {
						inclump = true;
						clumpcnt++;
					}

				} else
					inclump = false;
			}
			return clumpcnt;
		}

	}

	/**
	 * Finds the index of the array where array sum elements are equal
	 * 
	 * @param requires
	 *            an array
	 * 
	 * @return index of array
	 */
	public int splitIndex(int arr[], int size) {
		if (arr.length == 0) {
			throw new AssertionError("array of method splitIndex is empty");
		} else {
			int left = 0;
			for (int i = 0; i < size; i++) {
				left += arr[i];
				int right = 0;
				for (int j = i + 1; j < size; j++) {
					right += arr[j];
				}
				if (left == right) {
					return i + 1;
				}

			}
			return -1;
		}
	}

	/**
	 * Finds the length of elements that forms a mirror image
	 * 
	 * @param requires
	 *            an array
	 * 
	 * @return an integer value
	 */
	public int maxMirror(int[] nums, int len) {
		if (nums.length == 0) {
			throw new AssertionError("array empty");
		} else {
			int count = 0;
			int max = 0;

			for (int i = 0; i < len; i++) {
				count = 0;

				for (int j = len - 1; j >= 0 && (i + count < len); j--) {
					if (nums[i + count] == nums[j]) {
						count++;
					} else {
						if (count > 0) {
							max = Math.max(count, max);
							count = 0;
						}

					}
				}
				max = Math.max(count, max);
			}
			return max;
		}
	}
}
