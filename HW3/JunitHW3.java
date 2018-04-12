/*late fee (Include the saving day?) + /getNumPeople + / CheckOut + /getNumBook
 * 
 */

//Pat Wongwiset (nw9ca) Junit for hw3
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class JunitHW3 {
	private Library tester;
	private ArrayList<Book> listBookDueDate;
	private Book b4;
	private Book b3;
	private Person p1;
	private Person p2;

	@Before
	public void setUp(){
		//for checkNumCopies
		Book b1 = new Book ("Long", "Line",123, 24.0 );
		Book b2 = new Book ("Short", "Line", 321, 22.0);
		b3 = new Book ("Long", "Line", 121, 22.5);
		b4 = new Book ("abc", "easy", 120, 10.0);
		b1.setDueDate("02 02 2017");
		b2.setDueDate("02 02 2017");
		b3.setDueDate("01 03 2017");
		b4.setDueDate("02 03 2017");
		ArrayList<Book> listBook = new ArrayList<Book>();
		listBook.add(b1);
		listBook.add(b2);
		listBook.add(b3);
		listBook.add(b4);
		tester = new Library("Alder");
		tester.setLibraryBooks(listBook);
		tester.setCurrentDate("03 02 2017");

		//for check out + late fee

		p1 = new Person( "Ken", "101 Main St.", 1111);
		p1.addBook(b1);
		p2 = new Person("Liam", "123 McCormick Rd.", 8888);
		p2.addBook(b3);

		ArrayList<Person> patrion = new ArrayList<Person>();
		patrion.add(p1);
		patrion.add(p2);
		tester.setPatrons(patrion);

		//for duedate
		listBookDueDate = new ArrayList<Book>();
		listBookDueDate.add(b1);
		listBookDueDate.add(b2);


	}

	//testCheckNumCopies
	//have book(s)
	@Test
	public void testCheckNumCopies1() {
		assertEquals(tester.checkNumCopies("Long", "Line"), 2);


	}

	//Not have book in the array list
	@Test
	public void testCheckNumCopies2() {
		assertEquals(tester.checkNumCopies("Short", "L"), 0);

	}

	//have one book in the array list
	@Test
	public void testCheckNumCopies3() {
		assertEquals(tester.checkNumCopies("Short", "Line"), 1); 
	}


	//testCheckOut
	//check if the book is checked out (from others)
	@Test
	public void testCheckOut1(){
		assertFalse(tester.checkOut(p1,b3,"03 02 2017")); 
	}

	//check if the book can be checked out
	@Test
	public void testCheckOut2(){

		assertTrue(tester.checkOut(p2,b4,"03 02 2017"));
	}

	//test BookDueDate
	//Given due date is earlier than all of them
	@Test
	public void testBookDueOnDate1(){
		//set up
		ArrayList<Book> blank = new ArrayList<Book>();
		//test
		assertEquals(tester.booksDueOnDate("01 01 2017"), blank);
	}

	//have book due date on the given date
	@Test
	public void 
	testBooksDueOnDate2(){

		assertEquals(tester.booksDueOnDate("02 02 2017"), listBookDueDate);

	}

	//no book on the given due date
	@Test
	public void testBooksDueOnDate3(){
		//set up
		ArrayList<Book> blank = new ArrayList<Book>();
		//test
		assertEquals(tester.booksDueOnDate("01 12 2017"), blank);
	}

	//test late fee
	//p1 has late fee.
	@Test
	public void testLateFee1(){
		assertEquals(0.24,tester.lateFee(p1), 0.01);
	}

	//p2 does not have late fee
	@Test
	public void testLateFee2(){
		assertEquals(0.00, tester.lateFee(p2), 0.00);
	}

	//when member has more than one books that are late
	@Test
	public void testLateFee3(){
		//set up
		Book b = new Book("Little", "Star", 100, 25.0);
		tester.getLibraryBooks().add(b);
		b.setDueDate("01 02 2017");
		p1.addBook(b);
		//test
		assertEquals(0.74, tester.lateFee(p1), 0.00);
	}

	//Test equals() in Book Class
	//when 2 books have the same name and author
	@Test
	public void testEquals(){
		//set up
		Book b = new Book("Long", "Line", 200, 2.00);
		tester.getLibraryBooks().add(b);
		b.setDueDate("01 02 2017");
		//test
		assertFalse(b3.equals(b));
	}

	//When 2 books does not have the same name and author
	@Test
	public void testEquals2(){
		assertFalse(b3.equals(b4));
	}

	//Test addBook in Person Class
	//When having the book in the checkedOutList
	@Test
	public void testAddBook(){
		assertFalse(p2.addBook(b3));
	}

	//When don't have the book in checkedOut
	@Test
	public void testAddBook2(){
		//set up
		Book b = new Book("Alice in Wonderland", "Lewis Carroll", 111, 242.00);
		tester.getLibraryBooks().add(b);
		assertTrue(p1.addBook(b));
	}

	//Test toString in Book
	@Test
	public void testToString(){
		assertNotNull(b3.toString());
	}

	//Test totalNumBook
	@Test
	public void testTotalNumBooks(){
		assertEquals(tester.totalNumBooks(),4);
	}

	//Test getName in Person
	@Test
	public void testGetName(){
		assertNotNull(p1.getName());
	}

	//Test getAddress in Person
	@Test
	public void testGetAddress(){
		assertNotNull(p1.getAddress());
	}

	//Test getCheckedOut in Person
	@Test
	public void testGetCheckedOut(){
		assertNotNull(p1.getCheckedOut());
	}

	//Test getLibraryCardNum
	@Test
	public void testLibraryCardNum(){
		assertNotNull(p1.getLibraryCardNum());
	}

	//Test getTitle in Book
	@Test
	public void testGetTitle(){
		assertNotNull(b3.getTitle());
	}

	//Test getTitle in Book
	@Test
	public void testGetAuthor(){
		assertNotNull(b3.getAuthor());
	}

	//Test getTitle in Book
	@Test
	public void testGetBookId(){
		assertNotNull(b3.getBookId());
	}

	//Test getTitle in Book
	@Test
	public void testGetBookValue(){
		assertNotNull(b3.getBookValue());
	}

	//Test getDuedate in Book
	@Test
	public void testGetDueDate(){
		assertNotNull(b3.getDueDate());
	}

	//Test setCheckedOut in Book
	@Test
	public void testSetCheckedOut(){
		assertFalse(b3.setCheckedOut(false));
	}

	//Test getName in Library
	@Test
	public void testGetNameL(){
		assertEquals(tester.getName(), "Alder");
	}

	//Test getCurrentDate in Library
	@Test
	public void testGetCurrentDate(){
		assertEquals(tester.getCurrentDate(), "03 02 2017");
	}

	//Test setCurrentDate in Library
	@Test
	public void testSetCurrentDate(){
		assertEquals(tester.setCurrentDate("04 02 2017"), "04 02 2017");
	}





}
//REALLY IMPORTANT! = Don't forget to initialize

