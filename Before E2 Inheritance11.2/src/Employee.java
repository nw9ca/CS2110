
public class Employee extends Person{
	protected String office;
	public Employee(String n, String a, String ph, String m, String o){
		super(n,a,ph,m);
		this.office = o;
	}
	
	@Override
	public String toString(){
		return this.name +" " + this.getClass().getName();
	}

}
