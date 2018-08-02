package graphicsLibrary;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    List<Shape> ShapesOnScreen = new ArrayList<Shape>();
    private int XMAX;
    private int YMAX;
    Point endCoordinates;
    Point startCoordinates;

    Screen(Point point) {
        startCoordinates = new Point(0, 0);
        XMAX = (int) point.getXLocation();
        YMAX = (int) point.getYLocation();
        endCoordinates = new Point(XMAX, YMAX);
    }

    /*
     * method to add shape to the virtual screen
     */
    public void addShape(Shape shape) {
        ShapesOnScreen.add(shape);
    }

    /*
     * method to delete shape of particular object
     * 
     * @param object of shape
     * 
     */
    public void deleteShape(Shape shape) {
        if (ShapesOnScreen.contains(shape))
            ShapesOnScreen.remove(shape);
        else
            throw new AssertionError("ABSENT");
    }

    /*
     * method to delete of particular type
     * 
     * @param type of shape to be deleted
     */
    public void deleteAll(ShapeType TYPE) {
        for (int i = 0; i < ShapesOnScreen.size(); i++) {
            if (ShapesOnScreen.get(i).getShapeType() == TYPE) {
                ShapesOnScreen.remove(i);
                i--;
            }
        }
    }

    /*
     * method to sort area of shapes
     * 
     * @returns list of sorted areas of shapes
     */
    public List<Shape> sortByArea() {
        for (int i = 0; i < ShapesOnScreen.size() - 1; i++) {
            for (int j = 0; j < ShapesOnScreen.size() - i - 1; j++) {
                if (ShapesOnScreen.get(j).getArea() < ShapesOnScreen.get(j + 1).getArea()) {
                    Shape temp = ShapesOnScreen.get(j);
                    ShapesOnScreen.set(j, ShapesOnScreen.get(j + 1));
                    ShapesOnScreen.set(j + 1, temp);
                }
            }
        }
        return ShapesOnScreen;
    }

    public void display() {
        for (int i = 0; i < ShapesOnScreen.size(); i++) {
            System.out.println(ShapesOnScreen.get(i));
        }
    }

    /*
     * method to sort perimeter of shapes
     * 
     * @returns list of sorted perimeter of shapes
     */
    public List<Shape> sortByPerimeter() {
        for (int i = 0; i < ShapesOnScreen.size() - 1; i++) {
            for (int j = 0; j < ShapesOnScreen.size() - i - 1; j++) {
                if (ShapesOnScreen.get(j).getPerimeter() < ShapesOnScreen.get(j + 1).getPerimeter()) {
                    Shape temp = ShapesOnScreen.get(j);
                    ShapesOnScreen.set(j, ShapesOnScreen.get(j + 1));
                    ShapesOnScreen.set(j + 1, temp);
                }
            }
        }
        return ShapesOnScreen;
    }

    /*
     * method to sort timestamp of shapes
     * 
     * @returns list of sorted timestamp of shapes
     */
    public List<Shape> sortByTimestamp() {
        for (int i = 0; i < ShapesOnScreen.size() - 1; i++) {
            for (int j = 0; j < ShapesOnScreen.size() - i - 1; j++) {
                if (ShapesOnScreen.get(j).getTimestamp().before(ShapesOnScreen.get(j + 1).getTimestamp())) {
                    Shape temp = ShapesOnScreen.get(j);
                    ShapesOnScreen.set(j, ShapesOnScreen.get(j + 1));
                    ShapesOnScreen.set(j + 1, temp);
                }
            }
        }
        return ShapesOnScreen;
    }
}