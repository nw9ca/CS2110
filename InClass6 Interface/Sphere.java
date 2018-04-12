
public class Sphere implements Solids {
	
	private double radius;
	
	public Sphere(double radius){
		this.radius = radius;
		
	}
	
	//Volume = 4/3*pi*r^3
	public double getVolume(){
		return 4.0/3.0*Math.PI*Math.pow(radius, 3); 
	}
	
}
