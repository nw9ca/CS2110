//fr4wa (Fazlah Rahaman) 
//nw9ca (Niphattha Wongwiset)

import java.util.ArrayList;

public class Student {

	private static final Exception IllegalArguementException = null;
	private String name;
	private double gpa;
//	private double gradePoints;
//	private double creditsAttempted;
	private ArrayList<Course> courses = new ArrayList<Course>();
	

	public Student(String aName, double gpa) throws Exception {
		//studentName = name;
		name = aName;
//		gradePoints = 0.0;
//		creditsAttempted = 0.0;
		if (gpa > 4.0 || gpa < 0.0) {
			throw IllegalArguementException;
		}
		else {
		this.gpa = gpa;
		}

	}
	public Student(String aName) {
		name = aName;
		this.gpa = 0.0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}
	
	public double getGpa() {
		return gpa;
//		return gradePoints  / creditsAttempted;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public static void main(String[] args) throws Exception {
		Student s1 = new Student("bob", 2.0);
		s1.addCourseCredit(6.0, 4.0);
		System.out.println(s1 + " " + s1.getGpa());	
		Student s1Twin = new Student("bob", 2.0);
		s1Twin.addCourseCredit(6.0, 4.0);
		Student notS1 = new Student("joe", 2.3);
		System.out.println(s1.equals(s1Twin)); 
		System.out.println(s1.equals(notS1));
		System.out.println(s1.equals(s1));
		System.out.println(s1.equals("hello"));
		//Test 2 where GPA is invalid
		// Student wrongGPA = new Student("Fazlah", -2.3);
		// System.out.println(wrongGPA); //Exception in thread "main" java.lang.NullPointerException
		Course c1 = new Course("CS2190", "Java");
		Course c2 = new Course("CS3210", "Python");
		s1.add(c1);
		System.out.println(s1);
		s1.add(c1);
		System.out.println(s1);
		s1.add(c2);
		System.out.println(s1);
		s1.dropAll();
		System.out.println(s1);
		System.out.println(notS1);
		
		
		
	}
	

	// Without this method written correctly, Course.inClass() won't work!
	// Pages 153-154 in the MSD book says a bit about writing equals().
	public boolean equals(Object s2) {
		//System.out.println("hi from Student.equals()");
		if ( s2 instanceof Student ) {
			Student s = (Student) s2;
			return s.getName().equals( this.name );
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
		//this.creditsAttempted += credits;
		//this.gradePoints += gradePoints;
}

	public boolean add (Course aCourse) {
		if (this.courses.contains(aCourse)){
			return false;
		}
		else {
			this.courses.add(aCourse); 
				return true;
		}
	}
	
	public boolean drop (Course aCourse) {
		if (this.courses.contains(aCourse)) {
			this.courses.remove(aCourse);
			return true;
		}
		else {
			return false;
		}
	}
	
	public void dropAll() {
		this.courses.clear();
	}
	

	@Override
	public String toString() {
		return "(" + name + "," + getGpa() + " "  + getCourses()+ ")";
	}

}