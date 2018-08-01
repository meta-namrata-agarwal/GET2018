package graphicsLibrary;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Square implements Shape {

    private int width;
    private Point origin;
    private Timestamp timestamp;

    public Square(Point origin, ArrayList<Integer> parameter, Timestamp timestamp) {

        this.origin = origin;
        width = parameter.get(0);
        this.timestamp=timestamp;
    }

    @Override
    public double getArea() {

        return width * width;
    }

    @Override
    public double getPerimeter() {

        return 4 * width;
    }

    @Override
    public Point getOrigin() {

        return origin;
    }

    @Override
    public boolean isPointEnclosed(Point p) {
        if (origin.getXLocation() > p.getXLocation()
                && origin.getXLocation() < p.getXLocation() + width
                && origin.getYLocation() > p.getYLocation()
                && origin.getYLocation() < p.getYLocation() + width)
            return true;
        else
            return false;
    }

    @Override
    public ShapeType getShapeType() {

        return ShapeType.SQUARE;
    }

    @Override
    public double getOriginDistance() {

        return (Math.sqrt(Math.pow(origin.getXLocation(), 2)
                + Math.pow(origin.getYLocation(), 2)));
    }

    @Override
    public Timestamp getTimestamp() {
        // TODO Auto-generated method stub
        return timestamp;
    }

}
