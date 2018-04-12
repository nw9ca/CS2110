import java.util.Comparator;

public class CmpArea implements Comparator<GeometricObject> {
	public int compare(GeometricObject g1, GeometricObject g2){
		if(g1.area() < g2.area()){
			return -1;
		}
		if(g1.area() > g2.area()){
			return 1;
		}
		return 0;
	}

}
