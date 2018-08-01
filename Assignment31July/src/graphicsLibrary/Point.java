package graphicsLibrary;

public class Point {
    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getXLocation() {
        return x;
    }

    public double getYLocation() {
        return y;
    }
}
