package graphicsLibrary;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ShapeTest {

    Screen screen = new Screen(new Point(100, 100));

    @Test
    public void testAreaRectangle() throws Exception {
        Shape rectangle = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(4, 5),
                new ArrayList<Integer>(Arrays.asList(4, 6)));
        assertEquals(24, rectangle.getArea(), 0.001);
    }

    @Test
    public void testAreaSquare() throws Exception {
        Shape square = ShapeFactory.createShape(ShapeType.SQUARE, new Point(3, 7),
                new ArrayList<Integer>(Arrays.asList(2)));
        assertEquals(4, square.getArea(), 0.001);
    }

    @Test
    public void testAreaCircle() throws Exception {
        Shape circle = ShapeFactory.createShape(ShapeType.CIRCLE, new Point(8, 8),
                new ArrayList<Integer>(Arrays.asList(7)));
        assertEquals(153.86, circle.getArea(), 0.001);
    }

    @Test
    public void testPerimeterCircle() throws Exception {
        Shape circle = ShapeFactory.createShape(ShapeType.CIRCLE, new Point(8, 8),
                new ArrayList<Integer>(Arrays.asList(7)));

        assertEquals(43.96, circle.getPerimeter(), 0.001);
    }

    @Test
    public void testPerimeterSquare() throws Exception {
        Shape square = ShapeFactory.createShape(ShapeType.SQUARE, new Point(3, 7),
                new ArrayList<Integer>(Arrays.asList(2)));
        assertEquals(8, square.getPerimeter(), 0.001);
    }

    @Test
    public void testPerimeterRectangle() throws Exception {
        Shape rectangle = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(4, 5),
                new ArrayList<Integer>(Arrays.asList(4, 6)));
        assertEquals(20, rectangle.getPerimeter(), 0.001);
    }

    @Test
    public void testPointRectangle() throws Exception {
        Shape rectangle = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(4, 5),
                new ArrayList<Integer>(Arrays.asList(4, 6)));
        assertEquals(false, rectangle.isPointEnclosed(new Point(4, 5)));
    }

    @Test
    public void testPointSquare() throws Exception {
        Shape square = ShapeFactory.createShape(ShapeType.SQUARE, new Point(3, 7),
                new ArrayList<Integer>(Arrays.asList(2)));
        assertEquals(false, square.isPointEnclosed(new Point(4, 5)));
    }

    @Test
    public void testPointCircle() throws Exception {
        Shape circle = ShapeFactory.createShape(ShapeType.CIRCLE, new Point(7, 7),
                new ArrayList<Integer>(Arrays.asList(7)));
        assertEquals(true, circle.isPointEnclosed(new Point(11, 5)));
    }

    @Test
    public void testSortByArea() throws Exception {
        Shape circle = ShapeFactory.createShape(ShapeType.CIRCLE, new Point(8, 8),
                new ArrayList<Integer>(Arrays.asList(7)));
        Shape square = ShapeFactory.createShape(ShapeType.SQUARE, new Point(3, 7),
                new ArrayList<Integer>(Arrays.asList(2)));
        Shape rectangle = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(4, 5),
                new ArrayList<Integer>(Arrays.asList(4, 6)));
        screen.addShape(rectangle);
        screen.addShape(square);
        screen.addShape(circle);
        List<Shape> expected = new ArrayList<>();
        expected.add(circle);
        expected.add(rectangle);
        expected.add(square);

        List<Shape> result = new ArrayList<>();
        result = screen.sortByArea();
        assertEquals(expected, result);
    }

    @Test
    public void testSortByPerimeter() throws Exception {
        Shape circle = ShapeFactory.createShape(ShapeType.CIRCLE, new Point(8, 8),
                new ArrayList<Integer>(Arrays.asList(7)));
        Shape square = ShapeFactory.createShape(ShapeType.SQUARE, new Point(3, 7),
                new ArrayList<Integer>(Arrays.asList(2)));
        Shape rectangle = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(4, 5),
                new ArrayList<Integer>(Arrays.asList(4, 6)));
        screen.addShape(rectangle);
        screen.addShape(square);
        screen.addShape(circle);
        List<Shape> expected = new ArrayList<>();
        expected.add(circle);
        expected.add(rectangle);
        expected.add(square);

        List<Shape> result = new ArrayList<>();
        result = screen.sortByPerimeter();
        assertEquals(expected, result);
    }

    @Test
    public void testSortBytimeStamp() throws Exception {
        Shape circle = ShapeFactory.createShape(ShapeType.CIRCLE, new Point(8, 8),
                new ArrayList<Integer>(Arrays.asList(7)));
        Shape square = ShapeFactory.createShape(ShapeType.SQUARE, new Point(3, 7),
                new ArrayList<Integer>(Arrays.asList(2)));
        Shape rectangle = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(4, 5),
                new ArrayList<Integer>(Arrays.asList(4, 6)));
        screen.addShape(rectangle);
        screen.addShape(square);
        screen.addShape(circle);
        List<Shape> expected = new ArrayList<>();

        expected.add(rectangle);
        expected.add(square);
        expected.add(circle);
        List<Shape> result = new ArrayList<>();
        result = screen.sortByTimestamp();
        assertEquals(expected, result);
    }

//    @Test
//    public void testDelete() throws Exception {
//        Shape circle = ShapeFactory.createShape(ShapeType.CIRCLE, new Point(8, 8),
//                new ArrayList<Integer>(Arrays.asList(7)));
//        Shape square = ShapeFactory.createShape(ShapeType.SQUARE, new Point(3, 7),
//                new ArrayList<Integer>(Arrays.asList(2)));
//        Shape rectangle = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(4, 5),
//                new ArrayList<Integer>(Arrays.asList(4, 6)));
//        screen.addShape(rectangle);
//        screen.addShape(square);
//        screen.addShape(circle);
//        screen.deleteShape(circle);
//       Screen screenExpected=new Screen(new Point(100,100));
//        Shape square1 = ShapeFactory.createShape(ShapeType.SQUARE, new Point(3, 7),
//                new ArrayList<Integer>(Arrays.asList(2)));
//        Shape rectangle1 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(4, 5),
//                new ArrayList<Integer>(Arrays.asList(4, 6)));
//screenExpected.addShape(rectangle1);
//screenExpected.addShape(square1);
//        // Shapes[] expected = { square, triangle, rectangle };
//        assertSame(screenExpected,screen );
 //   }

}
