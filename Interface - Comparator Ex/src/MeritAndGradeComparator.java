import java.util.Comparator;

// implements Comparator<Student>
public class MeritAndGradeComparator implements Comparator<Student> {

	// Method used is "compare", and takes TWO parameters
	@Override
	public int compare(Student a, Student b) {

		if(a.isMeritStudent() == true && b.isMeritStudent() == false) {
			return -1;
		}
		else if (a.isMeritStudent() == false && b.isMeritStudent() == true) {
			return +1;
		}
		else { // merit is equal, now look at student grade
		// descending order: e.g. 19, 16, 12
		// (ascending order would be: a.getGrade() - b.getGrade()
		// e.g. 12, 16, 19)
		return b.getGrade() - a.getGrade();
		}
	}

}