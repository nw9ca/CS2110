import java.util.ArrayList;
import java.util.Collections;


public class Point implements Comparable<Point> {

	private double x;
	private double y;

	/* Constructor for the Point Class */
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
		// the following is not correct:
		//x = x;
		//x = this.x; //wrong way around! Nothing to assign!
	}
	
	/* distance method */
	public double distance(Point p2) {
		return Math.sqrt((this.x-p2.x)*(this.x-p2.x) + (this.y-p2.y)*(this.y-p2.y));
	}

	public static void main(String[] args) {
		
		Point p1 = new Point(0.0, 0.0);
		Point p2 = new Point(0.0, 0.0);

		// Can we use Collections.sort() on an ArrayList of Strings??
		ArrayList<String> slist = new ArrayList<String>();
		// Add Strings in some random order:
		slist.add("xyz"); slist.add("abs"); slist.add("abcXYZ");
		System.out.println(slist);
		Collections.sort(slist); // sorts Comparable items!!
		System.out.println(slist);
		// Yes we can, because the String type is Comparable!
		
		// Can we use Collections.sort() on an ArrayList of Points??
		Point p3 = new Point(1.0, 1.0);
		Point p4 = new Point(-1.0, 0.0);
		ArrayList<Point> plist = new ArrayList<Point>();
		// Add points in some random order:
		plist.add(p4); plist.add(p1); plist.add(p3); plist.add(p2);
		System.out.println(plist);
		Collections.sort(plist); // CALLS OUR compareTo() method!
		System.out.println(plist);
		// Yes we can, since we've:
		//  (1) Made the Point class implement Comparable 
		//      -->  public class Point implements Comparable<Point>
		//  (2) Wrote a compareTo() method in the Point class
		
	}

	
	// The "@Override" is a special kind of comment called an annotation
	// It is optional, but a good idea to keep it. 
	// Program will compile with or without it
	
	/* toString() method */
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}

	/* compareTo method */
	
	@Override
	// Notice, parameter of compareTo method is a Point
	public int compareTo(Point p2) { // sorting points: dist from origin
		System.out.println("hello from compareTo()!!!");
		Point orig = new Point(0.0, 0.0); // our origin
		double thisDist = this.distance(orig); // dist of first point
		double otherDist = p2.distance(orig); // dist of second point
		if (thisDist == otherDist)
			return 0; //equal!
		else if (thisDist < otherDist)
			return -1; //this point is less than other point
		else
			return +1; // this point is greater than other point
	}
	
	
	/* equals method */
	@Override
	public boolean equals(Object o) {
		System.out.println("Hello from equals method!!");
		if (o instanceof Point) { // Are you a Point?
			Point p2 = (Point) o;
			return (this.x == p2.x) && (this.y == p2.y); // True or False
		}
		else
			return false;		
	}	
	
	/* Getters and Setters */
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}	

}