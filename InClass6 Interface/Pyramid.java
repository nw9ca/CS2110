
public class Pyramid implements Solids {

	private double length, width, height;

	
	public Pyramid(double length, double width, double height) {
		this.length = length;
		this.width = width;
		this.height = height;
	}
	
	//Volume = length*width*height/3
	public double getVolume(){
		return length*width*height/3;
	}
		
}
