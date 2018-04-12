
public class Octahedron implements Solids{
	
	private double edge;
	
	public Octahedron(double edge){
		this.edge = edge;
	}
	
	//Volume sqrt(2)/3 times edge^3
	public double getVolume(){
		return Math.pow(2, 0.5)/3 * Math.pow(edge,3);
	}
	
}
