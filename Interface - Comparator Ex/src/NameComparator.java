import java.util.Comparator;

// implements Comparator<Student>
public class NameComparator implements Comparator<Student> {

	// Method used is "compare", and takes TWO parameters	
	@Override
	public int compare(Student a, Student b) {
		String name1 = a.getName();
		String name2 = b.getName();

		// ascending order (descending order would be: name2.compareTo(name1))
		return name1.compareTo(name2);
	}


}