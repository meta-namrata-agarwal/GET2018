package graphicsLibrary;

import java.sql.Timestamp;
import java.util.ArrayList;

public class ShapeFactory {
    static Shape shape;

    public static Shape createShape(ShapeType shapeType, Point p, ArrayList<Integer> parameter) throws Exception {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        switch (shapeType) {
        case CIRCLE:
            shape = new Circle(p, parameter,timestamp);
            break;
        case POLYGON:
            shape = new Polygon(p, parameter,timestamp);
            break;
        case RECTANGLE:
            shape = new Rectangle(p, parameter,timestamp);
            break;
        case SQUARE:
            shape = new Square(p, parameter,timestamp);
            break;
        case TRIANGLE:
            shape = new Triangle(p, parameter,timestamp);
            break;
        default:
            throw new Exception("shape unavailble");
          
        }

        return shape;
    }
}
