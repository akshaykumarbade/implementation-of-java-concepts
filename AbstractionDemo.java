package implementationofconcetps;

//Abstraction is a process of hiding the implementation details from the user, only the functionality 
// will be provided to the end user.

// In other words, the user will have the information on what the object does instead of how it does it. 
// So, Abstraction means hiding complexities or hiding implementation details from the end user.

// Abstraction can be achieved using abstract class or interface.

// There are situations in which we will want to define a superclass that declares the structure of a given abstraction 
// without providing a complete implementation of every method. i.e only provide declaration.
// In other words, sometimes we will want to create a superclass that only defines a generalization form that will be shared by 
// all of its subclasses, leaving it to each subclass to fill in the blanks.

// In good design, you should always use an interface.

// Interface is a programming structure where you declare your functionalities/ methods that you want to expose to public or 
// other modules/ classes. but you hide the implementation so that different classes implementing that interface can have their 
// own implementation of respective functionalities/ methods. In interface you can not add non-final fields.

// If you are creating a functionality that will be useful across wide range of objects, then you should use an interface.
// If you want abstraction as well as partial implementation for closely related objects, then you can go with an abstract class.

public class AbstractionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape rectangle = new Rectangle("Red", 3, 4);
		Shape circle = new Circle("Blue", 6);

		System.out.println(rectangle.area());
		System.out.println(circle.area());
		System.out.println(rectangle.toString());
		System.out.println(circle.toString());

		System.out.println();

		Vehicle defender = new DefenderCar(120);
		Vehicle ktm = new KTMBike(100);

		defender.running();
		ktm.running();
		System.out.println(defender.speed());
		System.out.println(ktm.speed());

	}

}

//using abstract class
abstract class Shape {
	String color;
	int id;

	Shape(String color) {
		this.color = color;
	}

	// abstract methods
	abstract double area();

	public abstract String toString();

	String getColor() {
		return color;
	}
}

class Rectangle extends Shape {
	double length;
	double breadth;

	Rectangle(String color, double length, double breadth) {
		super(color);// Shape class constructor is called
		this.length = length;
		this.breadth = breadth;
	}

	double area() {
		return length * breadth;
	}

	public String toString() {
		return "Rectangle is " + super.getColor() + " with area " + this.area();
	}
}

class Circle extends Shape {
	double radius;

	Circle(String color, double radius) {
		super(color);// Shape class constructor is called
		this.radius = radius;
	}

	double area() {
		return Math.PI * (radius * radius);
	}

	public String toString() {
		return "Circle is " + super.getColor() + " with area " + this.area();
	}
}

//using interface

interface Vehicle {

	// abstract methods of interface with implementation
	void running();

	int speed();
}

class DefenderCar implements Vehicle {
	int speed;

	DefenderCar(int speed) {
		this.speed = speed;
	}

	public void running() {
		System.out.println("Defender Car is running");
	}

	public int speed() {
		return speed;
	}

}

class KTMBike implements Vehicle {
	int speed;

	KTMBike(int speed) {
		this.speed = speed;
	}

	public void running() {
		System.out.println("KTM Bike is running");
	}

	public int speed() {
		return speed;
	}
}