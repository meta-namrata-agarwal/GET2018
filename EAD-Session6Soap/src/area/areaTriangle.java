package area;

public class areaTriangle {

	public double area(int side1,int side2,int side3)
	{
		double s=(side1+side2+side3)/2;
		double areaTri=Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
		return areaTri;
	}
}
