package graphicsLibrary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShapeMainClass {

    public static void main(String[] args) throws Exception {
        System.out.println("enter the shape to be created");

        Screen screenObject = new Screen(new Point(100, 100));
        Shape shape1 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(2, 3),
                new ArrayList<Integer>(Arrays.asList(7, 3)));

        screenObject.addShape(shape1);

        Shape shape2 = ShapeFactory.createShape(ShapeType.SQUARE, new Point(3, 3),
                new ArrayList<Integer>(Arrays.asList(3)));

        screenObject.addShape(shape2);

        Shape shape3 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(4, 3),
                new ArrayList<Integer>(Arrays.asList(2, 4)));

        screenObject.addShape(shape3);
        
        Shape shape4 = ShapeFactory.createShape(ShapeType.CIRCLE, new Point(4, 3),
                new ArrayList<Integer>(Arrays.asList(2)));

        screenObject.addShape(shape4);
        
        Shape shape5 = ShapeFactory.createShape(ShapeType.CIRCLE, new Point(4, 3),
                new ArrayList<Integer>(Arrays.asList(6)));

        screenObject.addShape(shape5);
        
        Shape shape6 = ShapeFactory.createShape(ShapeType.SQUARE, new Point(4, 3),
                new ArrayList<Integer>(Arrays.asList(5)));

        screenObject.addShape(shape6);
        System.out.println("SHAPE TYPE\tAREA\tPERIMETER\tGET ORIGIN\tGET TIMESTAMP");
        for (Shape s : screenObject.ShapesOnScreen) {
            System.out.println(s.getShapeType() + "\t" + s.getArea() + "\t" + s.getPerimeter() + "\t("
                    + s.getOrigin().getXLocation() + " " + s.getOrigin().getYLocation() + ")\t" + s.getTimestamp());
        }

        System.out.println();

        System.out.println("SORTED BY AREA");
        List<Shape> list = screenObject.sortByArea();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getShapeType() + "\t" + list.get(i).getArea() + "\t"
                    + list.get(i).getPerimeter() + "\t(" + list.get(i).getOrigin().getXLocation() + " "
                    + list.get(i).getOrigin().getYLocation() + ")\t" + list.get(i).getTimestamp());
        }

        System.out.println();
        System.out.println("SORTED BY PERIMETER");
        List<Shape> list1 = screenObject.sortByPerimeter();
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i).getShapeType() + "\t" + list1.get(i).getArea() + "\t"
                    + list1.get(i).getPerimeter() + "\t(" + list1.get(i).getOrigin().getXLocation() + " "
                    + list1.get(i).getOrigin().getYLocation() + ")\t" + list1.get(i).getTimestamp());
        }

        System.out.println();
        System.out.println("SORTED BY TIMESTAMP");
        List<Shape> list2 = screenObject.sortByTimestamp();
        for (int i = 0; i < list2.size(); i++) {
            System.out.println(list2.get(i).getShapeType() + "\t" + list2.get(i).getArea() + "\t"
                    + list2.get(i).getPerimeter() + "\t(" + list2.get(i).getOrigin().getXLocation() + " "
                    + list2.get(i).getOrigin().getYLocation() + ")\t" + list2.get(i).getTimestamp());
        }
        screenObject.deleteShape(shape2);
        screenObject.display();
        screenObject.deleteAll(ShapeType.RECTANGLE);
        screenObject.display();

    }

}
