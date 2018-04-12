//Pat Wongwiset (nw9ca) HW3
import java.util.ArrayList;
import java.util.GregorianCalendar;


public class Library {
	//Field
	private ArrayList<Book> libraryBooks;
	private ArrayList<Person> patrons;
	private String name;
	private int numBooks;
	private int numPeople;
	private String currentDate;

	//Constructor
	public Library(String name){
		this.name = name;
		this.patrons = new ArrayList<Person>();
		this.libraryBooks = new ArrayList<Book>();
		this.numPeople = this.patrons.size();
		this.currentDate = "00 00 0000";

		int i = 0;
		for(Book b : libraryBooks){
			if(!b.isCheckedOut()){
				i += 1;
			}
		}

		this.numBooks = i;
	}

	//Accessors
	public ArrayList<Book> getLibraryBooks(){
		return libraryBooks;
	}

	public ArrayList<Person> getPatrons(){
		return patrons;
	}

	public String getName(){
		return name;
	}

	public int getNumBooks(){
		int i = 0;
		for(Book b : this.libraryBooks){
			if(!b.isCheckedOut()){
				i += 1;
			}
		}
		this.numBooks = i;
		return this.numBooks;
	}

	public int getNumPeople(){
		this.numPeople = this.getPatrons().size();
		return this.numPeople;
	}

	public String getCurrentDate(){
		return this.currentDate;
	}

	//Mutators
	public ArrayList<Book> setLibraryBooks(ArrayList<Book> l){
		return this.libraryBooks = l;
	}

	public ArrayList<Person> setPatrons(ArrayList<Person> p){
		return this.patrons = p;
	}

	public String setName(String n){
		return this.name = n;
	}

	public String setCurrentDate(String d){
		return this.currentDate = d;
	}

	//checkNumCopies
	public int checkNumCopies(String title, String author){
		int num = 0;
		for(Book b: this.libraryBooks){
			if(b.getTitle() == title && b.getAuthor() == author){
				num += 1;
			}
		}
		return num;
	}

	// totalNumBooks
	public int totalNumBooks(){
		return libraryBooks.size();
	}

	//checkOut
	public boolean checkOut(Person p, Book b, String dueDate){
		if(patrons.contains(p)){

			for(Book a : libraryBooks){

				if( b.equals(a) && (!a.isCheckedOut())){
					a.setCheckedOut(true);
					a.setDueDate(dueDate);
					p.addBook(a);
					return true;
				}

			}

		}
		return false;

	}

	//booksDueOnDate
	public ArrayList<Book> booksDueOnDate(String date){
		ArrayList<Book> bookDue = new ArrayList<Book>();
		for(Book b : this.libraryBooks){
			if(b.getDueDate() == date){
				bookDue.add(b);
			}
		}
		return bookDue;
	}

	//lateFee
	public double lateFee(Person p){
		double fee = 0.0;
		int currentYear = Integer.parseInt(this.getCurrentDate().substring(6));
		int currentMonth = Integer.parseInt(this.getCurrentDate().substring(3,5));
		int currentDay = Integer.parseInt(this.getCurrentDate().substring(0,2));
		GregorianCalendar d2 = new GregorianCalendar(currentYear, currentMonth-1, currentDay);
		if(this.getPatrons().contains(p)){
			for(Book b : p.getCheckedOut()){
				int daysOver = 0;
				int year = Integer.parseInt(b.getDueDate().substring(6));
				int month = Integer.parseInt(b.getDueDate().substring(3,5));
				int day = Integer.parseInt(b.getDueDate().substring(0,2));
				GregorianCalendar d1 = new GregorianCalendar(year, month-1, day);
				long diff = (d2.getTimeInMillis() - d1.getTimeInMillis()) / (1000*60*60*24);

				if(diff > 0){


					daysOver = (int) diff;

					fee += b.getBookValue()*0.01*daysOver; //Find the fee for this b (book)
				}
			}

		}
		return fee;

	}



	//	public static void main(String[] args) {
	//		Library l = new Library("A");
	//		Person K = new Person( "Ken", "101 Main St.", 1111);
	//		Book b1 = new Book ("Long", "Line",123, 24.0 );
	//		Book b2 = new Book ("Short", "Line", 321, 22.0);
	//		b1.setDueDate("01 03 2017");
	//		b2.setDueDate("01 03 2017");
	//		ArrayList<Book> listBook = new ArrayList<Book>();
	//		listBook.add(b1);
	//		listBook.add(b2);
	//		l.setLibraryBooks(listBook);
	//		l.setCurrentDate("01 04 2017");	
	//		l.getPatrons().add(K);
	//		K.addBook(b1);
	//		K.addBook(b2);
	//		System.out.println(l.lateFee(K));
	//	}
}

