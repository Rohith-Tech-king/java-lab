package shapes;
/**
* Circle class implements Shape interface
*/
public class Circle implements Shape {
/** Radius of the circle */
protected double radius;
/**
* Constructor
* @param r radius
*/
public Circle(double r) {
radius = r;
}
/**
* Calculate area of the circle
* @return PI * r^2
*/
public double area() {
return Math.PI * radius * radius;
}
// ----------------------------
// Static overloaded method
// ----------------------------
/**
* Calculate area for a given radius
* @param r radius
* @return area
*/
public static double area(double r) {
return Math.PI * r * r;
}
/**
* Circle has no volume
* @return 0
*/
public double volume() {
return 0;
}
}
