package graphicsLibrary;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/***
 * Triangle class contains methods to: 1. return area 2. return perimeter 3.
 * check if point is enclosed 4. find origin
 * 
 *
 */
public class Triangle implements Shape {
    Point point1, point2, point3, origin;
    int base, height;
    double area, primeter;
    Timestamp timeStamp;

    /**
     * Constructor will initialize parameters
     * 
     * @param id
     * @param origin
     * @param height
     * @param base
     */
    public Triangle(Point p, ArrayList<Integer> parameter, Timestamp timestamp) {

        this.origin = origin;
        height = parameter.get(0);
        base = parameter.get(1);
        this.timeStamp = timestamp;
    }

    /**
     * return area of triangle
     */
    @Override
    public double getArea() {
        return 0.5 * base * height;
    }

    /**
     * return perimeter of triangle
     */
    @Override
    public double getPerimeter() {
        return( height + base
                + Math.sqrt(Math.pow(height, 2) + Math.pow(base, 2)));
    }

    /**
     * check if point is enclosed in triangle
     */
    @Override
    public boolean isPointEnclosed(Point point) {
        point1 = origin;
        point2 = new Point(origin.getXLocation() + base, origin.getXLocation());
        point3 = new Point(origin.getXLocation(), origin.getXLocation()
                + height);
        float subArea1, subArea2, subArea3;
        subArea1 = subArea(point1.getXLocation(), point2.getXLocation(),
                point.getXLocation(), point1.getXLocation(),
                point2.getXLocation(), point.getXLocation());
        subArea2 = subArea(point2.getXLocation(), point3.getXLocation(),
                point.getXLocation(), point2.getXLocation(),
                point3.getXLocation(), point.getXLocation());
        subArea3 = subArea(point1.getXLocation(), point3.getXLocation(),
                point.getXLocation(), point1.getXLocation(),
                point3.getXLocation(), point.getXLocation());
        return (float) (getArea()) == subArea1 + subArea2 + subArea3;
    }

    /**
     * utility method to calculate area of triangle
     * 
     * @param d
     * @param e
     * @param f
     * @param g
     * @param h
     * @param i
     * @return area of triangle
     */
    public float subArea(double d, double e, double f, double g, double h,
            double i) {
        return (float) ((d * (h - i) + e * (i - g) + f * (g - h)) / 2.0);
    }

    /**
     * return origin
     */
    @Override
    public Point getOrigin() {
        return origin;
    }

    /**
     * return type of shape
     */
    @Override
    public ShapeType getShapeType() {
        // TODO Auto-generated method stub
        return ShapeType.TRIANGLE;
    }

    /**
     * return timestamp
     */
    public Timestamp getTimestamp() {
        // TODO Auto-generated method stub
        return timeStamp;
    }

    @Override
    public double getOriginDistance() {
        // TODO Auto-generated method stub
        return 0;
    }

}
