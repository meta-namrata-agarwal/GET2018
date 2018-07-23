import org.junit.Assert;
import org.junit.Test;

public class MarkSheetTest {

	MarkSheet ms = new MarkSheet();
	double arr[] = { 50, 60, 43, 56, 78, 30, 23, 56 };

	@Test
	public void maxGradeTest() {
		double max = ms.maxGrade(arr, arr.length);
		System.out.println(max);
		Assert.assertEquals(max, 78, 3);

	}

	@Test
	public void minGradeTest() {

		double max = ms.minGrade(arr, arr.length);
		System.out.println(max);
		Assert.assertEquals(max, 23, 2);
	}

	@Test
	public void avgGradeTest() {
		double max = ms.avgGrade(arr, arr.length);
		Assert.assertEquals(max, 49.5, 2);
	}

	@Test
	public void avgpassedTest() {
		double max = ms.avgPassed(arr, arr.length);
		Assert.assertEquals(max, 75, 2);
	}

}
