
public class Octagon extends GeometricObject implements Comparable<Octagon>, Cloneable {
	
	protected double side;
	
	public Octagon(double s){
		this.side = s;
	}

	public static void main(String[] args) {
		Octagon a = new Octagon(5);
		Octagon b = a.clone();
		System.out.println(a.equals(b));
		
		System.out.println(a.area());
		System.out.println(a.perimeter());
		// TODO Auto-generated method stub

	}
	
	public double area(){
		return (2+4/Math.pow(2, 0.5))*this.side*this.side;
	}
	
	public double perimeter(){
		return 8*this.side;
	}
	
	@Override
	public Octagon clone(){
		Octagon o = new Octagon(this.side);
		return o;
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof Octagon){
			Octagon o2 = (Octagon) o;
			if(this.side == o2.side){
				return true;
			}
		}
		return false;
	}

	@Override
	public int compareTo(Octagon o) {
		if(this.side < o.side){
			return -1;
		}
		else if(this.side > o.side){
			return 1;
		}
		return 0;
		
	}
	
	

}
