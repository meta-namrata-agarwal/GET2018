import org.junit.Assert;
import org.junit.Test;

public class AreaOfShapesTest {
	AreaOfShapes as = new AreaOfShapes();
	double height = 12;
	double radius = 5;
	double width = 10;

	@Test
	public void areaOfTrianglePositive() {
		double output = as.areaOfTriangle(12, 10);
		Assert.assertEquals(output, 60, 0);
	}

	@Test
	public void areaOfTriangleNegative() {
		double output = as.areaOfTriangle(height, width);
		Assert.assertEquals(output, 63, 0);
	}

	@Test
	public void areaOfCircePositive() {
		double output = as.areaOfCircle(radius);
		Assert.assertEquals(output, 78.5, 0);
	}

	@Test
	public void areaOfCircleNegative() {
		double output = as.areaOfCircle(radius);
		Assert.assertEquals(output, 8.5, 0);
	}

	@Test
	public void areaOfSquarePositive() {
		double output = as.areaOfSquare(width);
		Assert.assertEquals(100, output, 0);
	}

	@Test
	public void areaOfSquareNegative() {
		double output = as.areaOfSquare(width);
		Assert.assertEquals(10, output, 0);
	}

	@Test
	public void areaOfRectanglePositive() {
		double output = as.areaOfRectangle(height, width);
		Assert.assertEquals(120, output, 0);
	}

	@Test
	public void areaOfRectangleNegative() {
		double output = as.areaOfRectangle(height, width);
		Assert.assertEquals(128, output, 0);
	}

}
