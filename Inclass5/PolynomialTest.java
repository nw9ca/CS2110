import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PolynomialTest {

	private Polynomial p;

	@Before
	public void SetUp(){
		p = new Polynomial();
		p.addTerm(2,(double) 3);
		p.addTerm(1,
				(double) 2);
	}

	@Test
	public void test() {
		//set up
		Polynomial r = new Polynomial();
		r.addTerm(1, (double) 1);


		//test
		Polynomial a = p.multiply(r); 
		assertNotNull(a.getTerms().get(2));
	}
	
	@Test
	public void test2(){
		//set up
		Polynomial r = new Polynomial();
		r.addTerm(1, (double) 1);
		
		//test
		Polynomial a = p.multiply(r); 
		assertNull(a.getTerms().get(1));
	}

	@Test
	public void test3(){
		//set up
		Polynomial r = new Polynomial();
		r.addTerm(1, (double) 1);
		
		//test
		Polynomial a = p.multiply(r); 
		assertEquals( (double) a.getTerms().get(2), 2.0, 0.00);
	}
}
