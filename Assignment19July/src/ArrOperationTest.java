import org.junit.Assert;
import org.junit.Test;

public class ArrOperationTest {
	ArrOperation ao = new ArrOperation();

	@Test
	public void fixXYArraytest() {

		int arr[] = { 5, 5, 4, 3, 4, 3 };
		int clump[] = ao.fixXYArray(arr, 4, 5, arr.length);
		int result[] = { 3, 3, 4, 5, 4, 5 };
		Assert.assertArrayEquals(result, clump);
	}

	@Test
	public void clumpArrayTest() {
		int arr[] = { 1, 2, 2, 3, 4, 4 };
		int clump = ao.clumpArray(arr, arr.length);
		Assert.assertEquals(2, clump);
	}

	@Test
	public void splitIndexTest() {
		int arr[] = { 1, 1, 2 };
		int index = ao.splitIndex(arr, arr.length);
		Assert.assertEquals(2, index);
	}
	@Test
	public void maxMirrorTest() {
		int arr[] = { 1, 1, 2, 4 };
		int index = ao.maxMirror(arr, arr.length);
		Assert.assertEquals(2, index);
	}
	

}
