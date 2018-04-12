
public class Student {

	private String name;
//	private double gpa;
	private double gradePoints;
	private double creditsAttempted;

	public Student(String aName) {
		//studentName = name;
		name = aName;
		gradePoints = 0.0;
		creditsAttempted = 0.0;
//		this.gpa = gpa;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getGpa() {
//		return gpa;
		return gradePoints  / creditsAttempted;
	}

//	public void setGpa(double gpa) {
//		this.gpa = gpa;
//	}

	public static void main(String[] args) {
		Student s1 = new Student("bob");
		s1.addCourseCredit(6.0, 4.0);
		System.out.println(s1 + " " + s1.getGpa());	
		Student s1Twin = new Student("bob");
		s1Twin.addCourseCredit(6.0, 4.0);
		Student notS1 = new Student("joe");
		
		System.out.println(s1.equals(s1Twin));
		System.out.println(s1.equals(notS1));
		System.out.println(s1.equals(s1));
		System.out.println(s1.equals("hello"));
	}
	
	// Without this method written correctly, Course.inClass() won't work!
	// Pages 153-154 in the MSD book says a bit about writing equals().
	public boolean equals(Object obj) {
		System.out.println("hi from Student.equals()");
		if ( obj instanceof Student ) {
			Student s = (Student) obj;
			return s.getName().equals( this.name ) &&
					s.creditsAttempted == this.creditsAttempted &&
					s.gradePoints == this.gradePoints;
		}
		else {
			return false;
		}
	}

	// The following is a version of equals() that works
	//   sometimes but not always. It's NOT the correct way
	//   to do it!
//	public boolean equals(Student s) {
//		System.out.println("hi from Student.equals()");
//		return s.getName().equals( this.name );
//	}
	

	private void addCourseCredit(double gradePoints, double credits) {
		this.creditsAttempted += credits;
		this.gradePoints += gradePoints;
}

	@Override
	public String toString() {
		return "(" + name + "," + getGpa() + ")";
	}

}
