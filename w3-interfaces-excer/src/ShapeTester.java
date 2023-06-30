
public class ShapeTester {

	public static void main(String[] args) {
		
		Triangle shape1 = new Triangle(9.5,2.5);
		Rectangle shape2 = new Rectangle(25.5,11.5);
		Circle shape3 = new Circle(15.9);
		
		System.out.println(shape1.getArea());
		System.out.println(shape2.getArea());
		System.out.println(shape3.getArea());

	}

}
