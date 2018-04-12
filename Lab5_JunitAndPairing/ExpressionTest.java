//fr4wa, nw9ca
// 2/20/17 (Lab 5)

import static org.junit.Assert.*;

import org.junit.Test;

public class ExpressionTest {

	@Test
	public void test() {
		int whichVersion = 18; // a number such that 0 <= whichVersion < 37
		String anExpression = "1+*3"; // a String that may or may not be an expression
		boolean valid = Expression.isValid(whichVersion, anExpression);
		assertTrue(valid);
	}

	@Test //parenthesis
	public void testModule() {
		int whichVersion = 0;
		for(whichVersion = 0; whichVersion < 37; whichVersion ++){ 
			String anExpression = "-(3)";
			boolean valid = Expression.isValid(whichVersion, anExpression);
			if(!valid){
				System.out.println(whichVersion);
			}
		}
	}

	@Test //hanging operator
	public void tes3() {
		int whichVersion = 0;
		for(whichVersion = 0; whichVersion < 37; whichVersion ++){
			String anExpression = "(1*3)/2*";
			boolean valid = Expression.isValid(whichVersion, anExpression);
			if(valid){
				//System.out.println(whichVersion);
			}
		}
	}

	@Test //double subtraction
	public void test4() {
		int whichVersion = 0;
		for(whichVersion = 0; whichVersion < 37; whichVersion ++){ 
			String anExpression = "1--5";
			boolean valid = Expression.isValid(whichVersion, anExpression);
			if(valid){
				//System.out.println(whichVersion);
			}
		}
	}

	@Test //divide by 0
	public void test5() {
		int whichVersion = 0;
		for(whichVersion = 0; whichVersion < 37; whichVersion ++){
			String anExpression = "5/0";
			boolean valid = Expression.isValid(whichVersion, anExpression);
			if(valid){
				//System.out.println(whichVersion);
			}
		}

	}

	@Test //char addition with number
	public void test6() {
		int whichVersion = 0;
		for(whichVersion = 0; whichVersion < 37; whichVersion ++){
			String anExpression = "'b' + 10";
			boolean valid = Expression.isValid(whichVersion, anExpression);
			if(!valid){
				//System.out.println(whichVersion);
			}
		}


	}



}
