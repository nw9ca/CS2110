import java.util.Comparator;

public class CmpByAddress implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		String add1 = o1.getAddress();
		String add2 = o2.getAddress();
		return add1.compareTo(add2);
	}
	
}
