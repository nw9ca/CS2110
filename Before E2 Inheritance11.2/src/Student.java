
public class Student extends Person{
	protected String status;
	public Student(String n, String a, String ph, String m, String st){
		super(n,a,ph,m);
		this.status = st;
	}
	
	@Override
	public String toString(){
		return this.name +" " + this.getClass().getName();
	}

}
