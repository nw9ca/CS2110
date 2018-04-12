//fr4wa (Fazlah Rahaman) 
//nw9ca (Niphattha Wongwiset)

import java.util.ArrayList;

public class Course {
	
	private static final Exception IllegalArguementException = null;
	private String id;
//	private String dept;
	private String name;
	private ArrayList<Student> roll = new ArrayList<Student>();

	public Course(String id, String name) throws Exception  {

//		this.dept = dept;
		this.name = name;
		this.roll = roll;
		if (id.length() > 10) {
			throw IllegalArguementException;
		}
		else {
			this.id = id;
		}
		
	}
	
	//GETTERS and SETTERS
	public String getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public ArrayList<Student> getRoll() {
		return roll;
	}


	public static void main(String[] args) throws Exception {
		Course c1 = new Course("cs2110", "CS");
		System.out.println(c1);
		Student s1 = new Student("bob",4.0);
		c1.enroll(s1);
		c1.enroll( new Student("ali", 2.3) );
		c1.enroll( new Student("cat",1.0) );
		c1.enroll( new Student("don",3.2) );
		c1.enroll( new Student("tom",3.7) );
		c1.add(new Student("Pat", 4.0));
		c1.add(new Student("Faz", 2.0));
		System.out.println(c1);
		c1.drop(new Student("Faz", 2.0));
		System.out.println("The average GPA is " + c1.averageGPA());
		//c1.cancel();
		//System.out.println(c1); //WORKS
		
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

	//ADDing a student
	public boolean add(Student aStudent){
		if (this.roll.contains(aStudent)) {
			return false;
		}
		else {
			this.roll.add(aStudent);
			return true;
		}
	}
	
	//DROPing a student
	public boolean drop (Student aStudent) {
		if (this.roll.contains(aStudent)) {
			this.roll.remove(aStudent);
			return true;
		}
		else {
			return false;
		}
	}
	
	//DROP ALL STUDENTS
	public void cancel() {
		this.roll.clear();
	}
	
	//AverageGPA
	public double averageGPA() {
		if (this.roll.size() > 0) {
			int x;
			double average = 0.0;
			for (x = 0; x < this.roll.size(); x++) {
			average = average + this.roll.get(x).getGpa();}
			return average/(double) this.roll.size();
		}
		else {
		return -1.0;
		}
	}
	
	
	@Override
	public String toString() {
		return "<" + id + "," + name + "," + roll + ">";
	}

}