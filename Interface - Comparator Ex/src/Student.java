import java.util.ArrayList;
import java.util.Collections;

public class Student  {

	private String name;
	private int age;
	private String lesson;
	private int grade;
	private boolean meritStudent;

	/* Default Constructor */
	public Student() {
	}

	/* Constructor */
	public Student(String name, int age, String lesson, int grade, boolean meritStudent) {
		this.name = name;
		this.age = age;
		this.lesson = lesson;
		this.grade = grade;
		this.meritStudent = meritStudent;
	}
	
	/* toString() method */
	@Override
	public String toString() {
		return this.name + "  " + this.grade + "  " + this.meritStudent + ";  ";
	}
	
	public static void main(String[] args) {
		
		// Create an ArrayList of Students:
		ArrayList<Student> student = new ArrayList<Student>();
				
		// Create some Students:
		Student s1 = new Student();
		s1.setName("Nick");
		s1.setGrade(19);
		s1.setAge(10);
		s1.setLesson("Arithmetic");
		s1.setMeritStudent(false);
		
		Student s2 = new Student("Helen", 11, "Arithmetic", 12, false);
		Student s3 = new Student("Ross", 11, "Arithmetic", 16, false);
		Student s4 = new Student("Clayton", 12, "Arithmetic", 19, true);

		// Add students to ArrayList
		student.add(s1); student.add(s2); student.add(s3); student.add(s4);

		System.out.println("Order of students before sorting is: ");
		// Printing
		for (int i = 0; i < student.size(); i++) {
			System.out.print(student.get(i));
		}
		System.out.println("\n");

		// *** Sort by Merit then by Grade:
		Collections.sort(student, new MeritAndGradeComparator());
		System.out
				.println("Order of students after sorting by merit then by student grade is:");

		for (int i = 0; i < student.size(); i++) {
			System.out.print(student.get(i));
		}
		System.out.println("\n");

		// *** Sort by Name:
		Collections.sort(student, new NameComparator());
		System.out
				.println("Order of students after sorting by student name is:");

		for (int i = 0; i < student.size(); i++) {
			System.out.print(student.get(i));
		}
		System.out.println("\n");

	} // END main
	
	/* Getters and Setters */
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getLesson() {
		return this.lesson;
	}

	public void setLesson(String lesson) {
		this.lesson = lesson;
	}

	public int getGrade() {
		return this.grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public boolean isMeritStudent() {
		return meritStudent;
	}

	public void setMeritStudent(boolean meritStudent) {
		this.meritStudent = meritStudent;
	}

}
