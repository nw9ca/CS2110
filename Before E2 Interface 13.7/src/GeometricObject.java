import java.util.ArrayList;
import java.util.Collections;

public abstract class GeometricObject {
	public abstract double area();
	
	public String toString(){
		return this.getClass().getName() +" : " + this.area();
	}

	public static void main(String[] args) {
		ArrayList<GeometricObject> arrP = new ArrayList<GeometricObject>();
		GeometricObject o1 = new Octagon(1);
		GeometricObject s1 = new Square(2);
		GeometricObject o2 = new Octagon(3);
		GeometricObject s2 = new Square(3);
		arrP.add(o1);
		arrP.add(s1);
		arrP.add(o2);
		arrP.add(s2);
		Collections.sort(arrP, new CmpArea());
		System.out.println(arrP);
	}
}
