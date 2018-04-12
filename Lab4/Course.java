import java.util.ArrayList;

public class Course {
	
	private String id;
	private String dept;
	private ArrayList<Student> roll = new ArrayList<>();

	public Course(String id, String dept) {
		this.id = id;
		this.dept = dept;
	}

	public static void main(String[] args) {
		Course c1 = new Course("cs2110", "CS");
		System.out.println(c1);
		Student s1 = new Student("bob");
		c1.enroll(s1);
		c1.enroll( new Student("ali") );
		c1.enroll( new Student("cat") );
		c1.enroll( new Student("don") );
		c1.enroll( new Student("tom") );
		
		
		// Example: testing findStudent()
//		Student result = c1.findStudent("don");
//		if ( result == null ) 
//			System.out.println("not found");
//		else
//			System.out.println("found: " + result);
		System.out.println(c1);
		// Example: testing inClass(). Note we're passing a Student object
		Student target = new Student("tom");
		if ( c1.inClass(target) )
			System.out.println("inClass() found: " + target);
		else
			System.out.println("inClass() did not find: " + target);			
	}
	
	private boolean inClass(Student target) {
//		for ( Student item : this.roll ) {
//			System.out.println("* in inClass(): " + item); 
//			if ( item.equals(target) ) // depends on Student.equals()
//				return true;
//		}
//		return false;
		// you know what?  This can be even easier!  Just use contains() on the list!
		return this.roll.contains(target);
	}

	private Student findStudent(String studName) {
//		for (int i=0; i < this.roll.size(); ++i) {
//			if ( studName.equals(this.roll.get(i).getName()) )
//				return this.roll.get(i);
//		}
		for ( Student item : this.roll ) {
			if ( studName.equals(item.getName()) )
				return item;
		}
		return null;
	}

	private void enroll(Student newStudent) {
		this.roll.add(newStudent);
	}

	@Override
	public String toString() {
		return "<" + id + "," + dept + "," + roll + ">";
	}

}
