/*
 * circle class with circle operations
 */
package graphicsLibrary;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Circle implements Shape {
    final double PI = 3.14;
    private Point origin;
    private int radius;
    private Timestamp timestamp;

    /*
     * constructor with arguments
     */
    public Circle(Point origin, ArrayList<Integer> parameter, Timestamp timestamp) {
        this.origin = origin;
        radius = parameter.get(0);
        this.timestamp = timestamp;
    }

    /*
     * returns the centre of circle
     */
    public Point getCentre() {
        return origin;
    }
    /*
     * (non-Javadoc)
     * 
     * @see graphicsLibrary.Shape#getArea()
     * 
     * @return area of circle
     */

    @Override
    public double getArea() {
        return PI * radius * radius;
    }

    /*
     * (non-Javadoc)
     * 
     * @see graphicsLibrary.Shape#getPerimeter()
     * 
     * @return perimeter of circle
     */
    @Override
    public double getPerimeter() {
        return 2 * PI * radius;
    }

    /*
     * (non-Javadoc)
     * 
     * @see graphicsLibrary.Shape#getOrigin()
     * 
     * @returns the origin of circle with respect to screen origin<0,0>
     */
    @Override
    public Point getOrigin() {
        double x2 = origin.getXLocation();
        double y2 = origin.getYLocation();
        double distance = Math.sqrt(x2 * x2 + y2 * y2);
        int n = radius;
        double m = distance - n;
        double x = m * x2 / (m + n);
        double y = m * y2 / (m + n);
        return new Point(x, y);
    }

    /*
     * (non-Javadoc)
     * 
     * @see graphicsLibrary.Shape#isPointEnclosed(graphicsLibrary.Point)s enclosed
     * in circle or not
     * 
     * @return boolean whether point p i
     */
    @Override
    public boolean isPointEnclosed(Point enclose) {
        double xp = enclose.getXLocation();
        double yp = enclose.getYLocation();
        double xc = origin.getXLocation();
        double yc = origin.getYLocation();
        double X = Math.abs(xp - xc);
        double Y = Math.abs(yp - yc);
        double distance = Math.sqrt(X * X) + Math.sqrt(Y * Y);
        return distance < radius;
    }

    /*
     * (non-Javadoc)
     * 
     * @see graphicsLibrary.Shape#getShapeType()
     * 
     * @returns the type of shape
     */
    @Override
    public ShapeType getShapeType() {

        return ShapeType.CIRCLE;
    }

    /*
     * (non-Javadoc)
     * 
     * @see graphicsLibrary.Shape#getOriginDistance()
     * 
     * @returns the distance from origin
     */
    @Override
    public double getOriginDistance() {
        return 0;
    }

    /*
     * (non-Javadoc)
     * 
     * @see graphicsLibrary.Shape#getTimestamp()
     * 
     * @returns timestamp of shape added
     */
    @Override
    public Timestamp getTimestamp() {
        // TODO Auto-generated method stub
        return timestamp;
    }

}
