public class AreaOfShapes {
	final double pi = 3.14;

	/**
	 * Find a area of triangle
	 * 
	 * @param requires
	 *            height and width
	 * @return area of the triangle
	 */
	public double areaOfTriangle(double height, double width)
			throws ArithmeticException {
		double area = 0.5 * (width * height);
		return area;
	}

	/**
	 * Find a area of circle
	 * 
	 * @param requires
	 *            radius
	 * @return area of the circle
	 */
	public double areaOfCircle(double radius) throws ArithmeticException {
		double area = pi * radius * radius;
		return area;
	}

	/**
	 * Find a area of square
	 * 
	 * @param requires
	 *            width
	 * @return area of the square
	 */
	public double areaOfSquare(double width) throws ArithmeticException {
		double area = width * width;
		return area;
	}

	/**
	 * Find a area of rectangle
	 * 
	 * @param requires
	 *            height and width
	 * @return area of the rectangle
	 */

	public double areaOfRectangle(double height, double width)
			throws ArithmeticException {
		double area = width * height;
		return area;
	}
}
