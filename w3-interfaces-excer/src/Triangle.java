
public class Triangle implements Shape {
	private double height;
	private double base;
	
	public Triangle(double height, double base) {
		this.height = height;
		this.base = base;
	}

	@Override
	public double getArea() {
		return .5 * base * height;
	}
	
	
}


