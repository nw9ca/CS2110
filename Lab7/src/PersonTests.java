import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;


public class PersonTests {

	@Test
	public void testPersonOnly() {
		Person p1 = new Person("Jane", "100 Main St, Somewhere");
		Person p2 = new Person("Raul", "27 Elm St, Elsewhere");
		
		assertEquals("toString", "{Person: name=Jane, homeAddress=100 Main St, Somewhere|", p1.toString());
		assertEquals("toString", "{Person: name=Raul, homeAddress=27 Elm St, Elsewhere|", p2.toString());
	}
	@Test
	public void testPersonEmployee() {
		ArrayList<Person> list = new ArrayList<Person>();
		Person p = new Person("Mai", "3156 Grove Rd, Somewhere");
		list.add(p);
		p = new Employee("Don", "6562 Trask Way, Elsewhere", "Front Desk", 2110);
		list.add(p);
		
		assertEquals("toString", "{Person: name=Mai, homeAddress=3156 Grove Rd, Somewhere|", list.get(0).toString());
		assertEquals("toString", "{Empl: n=Don, ha=6562 Trask Way, Elsewhere, wa=Front Desk, id=2110}", list.get(1).toString());
	}
	@Test
	public void testPersonEmployeeStudent() {
		ArrayList<Person> list = new ArrayList<Person>();
		Person p = new Person("Mai", "3156 Grove Rd, Somewhere");
		list.add(p);
		p = new Employee("Don", "6562 Trask Way, Elsewhere", "Front Desk", 2110);
		list.add(p);
		// TODO: uncomment the following
		 p = new Student("Dana Wahoo", "21 Wahoo Ave, NOVA", "1 JPA, CVille, VA");
		 list.add(p);
		
		assertEquals("toString", "{Person: name=Mai, homeAddress=3156 Grove Rd, Somewhere|", list.get(0).toString());
		assertEquals("toString", "{Empl: n=Don, ha=6562 Trask Way, Elsewhere, wa=Front Desk, id=2110}", list.get(1).toString());
		//fail("Implement student and fix the junit to test it.");
		 assertEquals("toString", "{}", list.get(2).toString()); // TODO: finish this
		 
		 for(Object o: list){
			 assertTrue(o instanceof Person);
		 }
	}
	
	@Test
	public void testSortByName(){
		Person p1 = new Person("Mai", "3156 Grove Rd, Somewhere");
		Person p2 = new Person("Ann", "212 Alder Rd, VA");
		Person p3 = new Person("Bow", "101 Peter Rd, MA");
		ArrayList<Person> list = new ArrayList<Person>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		Collections.sort(list);
		assertEquals(list.get(0), p2);
		assertEquals(list.get(1), p3);
		assertEquals(list.get(2), p1);
	}
	
	@Test
	public void testSortByAddress(){
		Person p1 = new Person("Mai", "3156 Grove Rd, Somewhere");
		Person p2 = new Person("Ann", "212 Alder Rd, VA");
		Person p3 = new Person("Bow", "101 Peter Rd, MA");
		ArrayList<Person> list = new ArrayList<Person>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		Collections.sort(list, new CmpByAddress());
		assertEquals(list.get(0), p3);
		assertEquals(list.get(1), p2);
		assertEquals(list.get(2), p1);
	}
	
	

}
