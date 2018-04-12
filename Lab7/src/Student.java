
public class Student extends Person {
	String campusAddress;
	double gpa;
	
	public Student(String name, String address, String campusAddress){
		super(name, address);
		this.campusAddress = campusAddress;
		this.gpa = 0.0;
	}
	
	public String toString(){
		return "{}";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

}
