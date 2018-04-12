
public class ComparableCircle extends Circle implements Comparable<Circle>{
	
	public int result;
	
	
	public ComparableCircle(int r,Circle c){
		super(r);
		this.result = this.compareTo(c);
	}
	
	@Override
	public int compareTo(Circle c){
		if( this.area() > c.area() ){
			return 1;
		}
		if(this.area() < c.area()){
			return -1;
		}
		return 0;
	}
	

	public static void main(String[] args) {
		Circle c2 = new Circle(0);
		ComparableCircle c1 = new ComparableCircle(1, c2);
		
		System.out.println(c1.result);
		// TODO Auto-generated method stub

	}

}
