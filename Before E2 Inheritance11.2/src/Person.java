
public class Person {
	protected String name;
	protected String address;
	protected String phone;
	protected String mail;
	
	public Person(String n, String a, String ph, String m){
		this.name = n;
		this.address = a;
		this.phone = ph;
		this.mail = m;
	}
	public String getPhone(){
		return "Phone: " + this.phone;
	}
	
	
	@Override
	public String toString(){
		return this.name +" " + this.getClass().getName();
	}

}
