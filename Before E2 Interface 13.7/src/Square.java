
public class Square extends GeometricObject implements Colorable{
	
	double side;
	
	public Square(double x){
		this.side = x;
	}
	
	@Override
	public void howTocolor() {
		System.out.println("Color all 4 sides");
	}
	
	
	public double area(){
		return this.side*this.side;
	}
	
	public static void main(String[] args) {
		Square s = new Square(2);
		s.howTocolor();
	}
}
