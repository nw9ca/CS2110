//nw9ca InClass5
import static org.junit.Assert.*;

import org.junit.Test;

public class MySetTest {

	@Test
	public void addTest() {
		// set up
		MySet tester = new MySet();
		tester.add("a");
		//test
		assertTrue( tester.add("b") );
		assertFalse( tester.add("a"));
	}
	
	@Test
	public void unionTest(){
		//set up
		//create 2 sets
		MySet tester = new MySet();
		tester.add("a");
		tester.add("b");
		tester.add("c");
		
		MySet s = new MySet();
		s.add("b");
		s.add("c");
		s.add("d");
		
		MySet result = new MySet();
		result.add("a");
		result.add("b");
		result.add("c");
		result.add("d");
		
		
		//test
		assertEquals(tester.union(s).toString(),result.toString());
		//If no toString, it will include location comparison. (Two sets have different locations, so it return not equals)
		
	}

}
