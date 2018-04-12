
public class Circle{
	protected double radius;
	public Circle(double r){
		this.radius = r;
	}
	
	public double area(){
		return Math.PI*Math.pow(this.radius, 2);
	}
}
