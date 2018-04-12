
public class Staff extends Employee {
	
	protected String title;
	public Staff(String n, String a, String ph, String m, String o, String sf){
		super(n,a,ph,m,o);
		this.title = sf;
	}
	
	@Override
	public String toString(){
		return this.name +" " + this.getClass().getName();
	}

	public static void main(String[] args) {
		Person a = new  Person("Rid", "22 Page", "0", "rid");
		Student b = new Student("Kelly", "101 Ecchos", "1", "kell", "1st");
		Person c = new Employee("Meggie", "Charlottes", "2", "meg", "Alder");
		Employee d = new Staff("Neil", "UVA", "3", "nlei","Page", "Maintenance");

		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(d.getPhone());
		// TODO Auto-generated method stub

	}

}
