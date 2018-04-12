// 3.3.2017
public class Person {
	
	// fields
	protected String name;
	protected String homeAddress;
	
	// constructor
	public Person(String n, String ha){
		this.name = n;
		this.homeAddress = ha;
	}

	// from source => generate toString()
	// @Override; -add as a reminder that you are overriding the method existing in the class
	//            -means that it has to be identical to what I am writting
	//            -if we change to 'toSting' the red line will pop up because the method is 
	//			  not existing in the class
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", homeAddress=" + homeAddress + "]";
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getHomeAddress() {
		return homeAddress;
	}


	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	
	
	public String getMailingAddress() {
		return homeAddress;
	}


	public static void main(String[] args) {
		Person p = new Person("Sophia", "101 York");
		System.out.println(p);
		System.out.println(p.getHomeAddress());
		

	}

}
