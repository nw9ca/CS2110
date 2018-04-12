import java.util.ArrayList;

// Employee is the subclass of Person
// Person is the supperclass of Employee
public class Employee extends Person {
	
	// fields
	private String workAddress;
	private int employeeId;

	//constructor
	public Employee(String n, String ha, String wa, int id){
		super(n, ha); //**Always be the first line (Avoid duplicated; both have same fields)
		this.workAddress = wa;
		this.employeeId = id;
	}
	
	@Override
	public String getMailingAddress(){
		return workAddress;
	}
	
	@Override
	public String toString(){
		String str = super.toString();
		str +=  " work address: " + this.workAddress + " emp id: " + this.employeeId;
		return str;
	}
	
	/*0. Run -- observe error message
	 * 1. Start with Person fields as private - code has errors
	 * 2. Change this.name to this.getName() -> add getters -> code works
	 * 3. Undo change, keep this.name
	 * 4. Change private to protected in Person -> code works
	 */
	
	public String printing(){
		return this.name + ", " + this.homeAddress; 
	}
	public static void main(String[] args) {
		Employee e = new Employee("Jim", "101 Apple", "200 Rice", 445);
		
		System.out.println(e);
		
		System.out.println(e.printing());
		
		Employee p = new Employee("Abby", "20 Pine", "202 Pine", 222);
		Employee ge = new Employee("Carl", "10 Bryant", "101 Bryant", 111);
		
		ArrayList<Employee> list = new ArrayList<Employee>();
		
		list.add(p);
		list.add(e);
		list.add(ge);
		
		Person pe = ge; //this works
		System.out.println(list.get(2) instanceof Person); //true
		
		//Run time Polymorphism
		for(Person o: list){
			System.out.println(o);
		}

	}

}
