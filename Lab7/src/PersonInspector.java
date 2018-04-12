import java.util.ArrayList;

public class PersonInspector {
	public static ArrayList<String> classNames(ArrayList<Person> list){
		ArrayList<String> result = new ArrayList<String>();
		for(Person p: list){
			String str;
			str = p.getClass().toString();
			result.add(str);
		}
		return result;
	}
	public static void main(String[] args) {
		Person p1 = new Person("Mai", "3156 Grove Rd, Somewhere");
		Employee p2 = new Employee("Don", "6562 Trask Way, Elsewhere", "Front Desk", 2110);
		Student p3 = new Student("Dana Wahoo", "21 Wahoo Ave, NOVA", "1 JPA, CVille, VA");
		ArrayList<Person> list = new ArrayList<Person>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		ArrayList<String> result = classNames(list);
		System.out.println(result);
		// TODO Auto-generated method stub

	}

}
