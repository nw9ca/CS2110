
import java.util.ArrayList;
import java.util.Collections;

public class Point implements Comparable<Point> {
	public double x;
	public double y;

	Point(double x2,double y2){
		this.x = x2;
		this.y = y2;
	}

	public int compareTo(Point p){
		if(this.x != p.x){
			if(this.x > p.x){
				return 1;
			}
			if(this.x < p.x){
				return -1;
			}	
		}
		if(this.y > p.y){
			return 1;
		}
		if(this.y < p.y){
			return -1;
		}

		return 0;
	}
	
	public String toString(){
		return "( " + this.x +"," + this.y +" )";
	}
	
	public static void main(String[] args) {
		ArrayList<Point> arrP = new ArrayList<Point>();
		int i;
		for(i = 0; i < 5; i ++){
			Point p = new Point(1-i, i+1);
			arrP.add(p);
		}
//		int i;
//		for(i = 0; i < 100; i ++){
//			double x = Math.random();
//			double y = Math.random();
//			Point p = new Point(x,y);
//			arrP.add(p);
//	}
		Collections.sort(arrP);
		System.out.println(arrP);
		Collections.sort(arrP, new CompareY());
		System.out.println(arrP);
	}

}
