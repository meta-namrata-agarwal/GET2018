package graphicsLibrary;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Rectangle implements Shape {

    private int height;
    private int length;
    private Point p;

    private Timestamp timestamp;

    /*
     * constructor with arguments
     */
    public Rectangle(Point p, ArrayList<Integer> parameter, Timestamp timestamp) {
        this.p = p;
        height = parameter.get(0);
        length = parameter.get(1);
        this.timestamp = timestamp;
    }

    /*
     * (non-Javadoc)
     * 
     * @see graphicsLibrary.Shape#getArea()
     * 
     * @returns the area of rectangle
     */
    @Override
    public double getArea() {

        return (height * length);
    }

    /*
     * (non-Javadoc)
     * 
     * @see graphicsLibrary.Shape#getPerimeter()
     * 
     * @returns the perimeter of rectangle
     */
    @Override
    public double getPerimeter() {

        return 2 * (length + height);
    }

    /*
     * (non-Javadoc)
     * 
     * @see graphicsLibrary.Shape#getOrigin()
     * 
     * @returns the point where shape started
     */
    @Override
    public Point getOrigin() {

        return p;
    }

    /*
     * (non-Javadoc)
     * 
     * @see graphicsLibrary.Shape#isPointEnclosed(graphicsLibrary.Point)
     * 
     * @param point p to check
     * 
     * @returns boolean value for point p whether it is enclosed or not
     */
    @Override
    public boolean isPointEnclosed(Point point) {
        if (point.getXLocation() > p.getXLocation() && point.getXLocation() < p.getXLocation() + length
                && point.getYLocation() > p.getYLocation() && point.getYLocation() < p.getYLocation() + height)

            return true;
        else
            return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see graphicsLibrary.Shape#getShapeType()
     * 
     * @returns shape
     */
    @Override
    public ShapeType getShapeType() {
        return ShapeType.RECTANGLE;
    }

    @Override
    public double getOriginDistance() {
        return (Math.sqrt(Math.pow(p.getXLocation(), 2) + Math.pow(p.getYLocation(), 2)));
    }

    @Override
    public Timestamp getTimestamp() {
        // TODO Auto-generated method stub
        return timestamp;
    }

}
