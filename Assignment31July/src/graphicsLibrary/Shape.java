package graphicsLibrary;

import java.sql.Timestamp;

/*
 * interface with certain common funtions  for shapes on mathematical background
 */
public interface Shape {

    double getArea();

    double getPerimeter();

    Point getOrigin();

    boolean isPointEnclosed(Point point);

    ShapeType getShapeType();

    public double getOriginDistance();

    Timestamp getTimestamp();

}
