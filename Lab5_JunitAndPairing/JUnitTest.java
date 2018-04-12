//nw9ca fr4wa
// Lab 5
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class JUnitTest {

	// 1. Add one Book to a newly created Person. Does this return true? Is the Book stored in the Person?
	@Test
	public void testAddBook1() {
		Person p = new Person("Pat", 000);
		Book b = new Book("Love and Smile", "J. Justin");

		assertTrue(p.addBook(b)); // Expected: true, output: true
		//Therefore, the book is added.

	}

	@Test
	public void testAddBook2(){
		Person p = new Person("Pat", 000);
		Book b = new Book("Love and Smile", "J. Justin");
		p.addBook(b);
		ArrayList<Book> list = p.getRead();

		assertTrue(list.contains(b)); 
		/*Expected: true, output: true
		 * Therefore, the book is added and actually contained in the read of p
		 */
	}

	// 2. Add a two different books to a Person. Does each call return true? Are two books stored?

	@Test
	public void testAddBook3(){
		Person p = new Person("Pat", 000);
		Book b1 = new Book("Love and Smile", "J. Justin");
		Book b2 = new Book("Hate but Smile", "L. Luke");

		assertTrue(p.addBook(b1) && p.addBook(b2));
		/*Expected: true, output: true
		 * Therefore, both book are added.
		 */
	}

	@Test
	public void testAddBook4(){
		Person p = new Person("Pat", 000);
		Book b1 = new Book("Love and Smile", "J. Justin");
		Book b2 = new Book("Hate but Smile", "L. Luke");
		p.addBook(b1);
		p.addBook(b2);
		ArrayList<Book> list = p.getRead();

		assertTrue(list.contains(b1) && list.contains(b2));

		/*Expected: true, output: true
		 * Therefore, both book are added and stored in the read of p.
		 */
	}

	// 3. Add one Book and then try to add a second Book that is equals() to the first. Does the second call return false? Is just one book stored?
	@Test
	public void testAddBook5(){
		Person p = new Person("Pat", 000);
		Book b1 = new Book("Love and Smile", "J. Justin");
		Book b2 = new Book("Love and Smile", "J. Justin");
		p.addBook(b1);

		assertFalse(p.addBook(b2));
		/*Expected: false, output: false
		 * Therefore, added the book that is equals() to b1 is not successful.
		 */
	}
	@Test
	public void testAddBook6(){
		Person p = new Person("Pat", 000);
		Book b1 = new Book("Love and Smile", "J. Justin");
		Book b2 = new Book("Love and Smile", "J. Justin");
		p.addBook(b1);
		p.addBook(b2);
		ArrayList<Book> list = p.getRead();

		assertEquals(list.size(), 1);

		/*Expected: 2, output: 2
		 * Therefore, added the book that is equals() to b1 is not successful.
		 * There is only one book stored in the read.
		 */
	}
	//all tests confirmed that addBook() worked properly.
	
	//PART 2 (forgetBook())
	// 1. Remove a book that is stored in the read of created Person.
	// check it return true after remove
	@Test
	public void testForgetBook1(){
		Person p = new Person("Pat", 000);
		Book b1 = new Book("Love and Smile", "J. Justin");
		p.addBook(b1);
		
		assertTrue(p.forgetBook(b1));
		/*Expected: true, output: true
		 * Therefore, forgetBook() removed b1.
		 */
	}
	
	//check it removed from the read
	@Test
	public void testForgetBook2(){
		Person p = new Person("Pat", 000);
		Book b1 = new Book("Love and Smile", "J. Justin");
		p.addBook(b1);
		p.forgetBook(b1);
		ArrayList<Book> list = p.getRead();
		
		assertFalse(list.contains(b1));
		/*Expected:false, output: false
		 * Therefore, forgetBook() removed b1 and deleted it from the read.
		 */
	}
	
	// 2.Remove two different books to a Person. Does each call return true? Are two books deleted?
	@Test 
	public void testForgetBook3(){
		Person p = new Person("Pat", 000);
		Book b1 = new Book("Love and Smile", "J. Justin");
		Book b2 = new Book("Hate but Smile", "L. Luke");
		p.addBook(b1);
		p.addBook(b2);

		assertTrue(p.forgetBook(b1) && p.forgetBook(b2));
		/*Expected: true, output: true
		 * Therefore, both book are removed.
		 */
	}
	
	@Test
	public void testForgetBook4(){
		Person p = new Person("Pat", 000);
		Book b1 = new Book("Love and Smile", "J. Justin");
		Book b2 = new Book("Hate but Smile", "L. Luke");
		p.addBook(b1);
		p.addBook(b2);
		p.forgetBook(b1);
		p.forgetBook(b2);
		ArrayList<Book> list = p.getRead();

		assertFalse(list.contains(b1) || list.contains(b2));
		/*Expected: false, output: false|| false = false
		 * Therefore, both book are removed from the read.
		 */
	}
	
	// 3. Remove one Book and then try to forget a second Book that is equals() to the first. Does the second call return false? Is just one book stored?
	@Test
	public void testForgetBook5(){
		Person p = new Person("Pat", 000);
		Book b1 = new Book("Love and Smile", "J. Justin");
		Book b2 = new Book("Love and Smile", "J. Justin");
		p.forgetBook(b1);

		assertFalse(p.forgetBook(b2));
		/*Expected: false, output: false
		 * Therefore, remove the book that is equals() to b1 is not successful.
		 */
	}
	
	@Test
	public void testForgetBook6(){
		Person p = new Person("Pat", 000);
		Book b1 = new Book("Love and Smile", "J. Justin");
		Book b2 = new Book("Love and Smile", "J. Justin");
		p.forgetBook(b1);
		p.forgetBook(b2);
		ArrayList<Book> list = p.getRead();

		assertEquals(list.size(), 0);

		/*Expected: 0, output: 0
		 * Therefore, removed the book that is equals() to b1 is not successful.
		 * There is only one book removed in the read.
		 */
	}
}

