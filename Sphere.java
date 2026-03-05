package shapes;

public class Sphere extends Circle {

    public Sphere(double r) {
        super(r);
    }

    public double area() {
        double tmp = super.area();
        return 4 * tmp;
    }

    public double volume() {
        return (4.0/3.0) * PI * radius * radius * radius;
    }
}