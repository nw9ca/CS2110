import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.Test;


public class TestMyClass {

	@Test
	public void testAdd() {
		//set up
		int x =5;
		int y = 2;
		MyClass tester = new MyClass();
		//test
		assertEquals("5 + 2 should be 7", tester.add(x,y),7);
	}

	@Test
	public void testMultiply(){
		//set up
		int x = 5;
		int y = 2;
		MyClass tester = new MyClass();
		//test
		assertEquals("5*2 should be 10", tester.multiply(x,y),10 );
		
	}
}
