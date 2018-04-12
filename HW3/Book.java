// Pat Wongwiset (nw9ca); HW 3
public class Book {

	//Create fields
	private String title;
	private String author;

	//added for HW3
	private String dueDate;
	private boolean checkedOut;
	private int bookId;
	private double bookValue;



	// Constructor
	public Book(String title, String author, int bookId, double bookValue){
		this.title = title;
		this.author = author;

		//added for HW3
		this.bookId = bookId;
		this.bookValue = bookValue;
		this.dueDate = "00 00 0000";
		this.checkedOut = false;

		// Accessory - getters
		// No mutator (setters) for bookId because bookId is fixed.
	}

	public String getTitle(){
		return title;
	}

	public String getAuthor(){
		return author;
	}

	//added for HW3
	// Getter
	public String getDueDate(){
		return dueDate;
	}

	public boolean isCheckedOut(){
		return checkedOut;
	}

	public int getBookId(){
		return bookId;
	}

	public double getBookValue(){
		return bookValue;
	}

	//Setter
	public String setDueDate(String newDueDate){
		return this.dueDate = newDueDate;
	}

	public boolean setCheckedOut(boolean newCheckedOut){
		return this.checkedOut = newCheckedOut;
	}

	public double setBookValue(double newBookValue){
		return this.bookValue = newBookValue;
	}


	// Updated equals(); 
	public boolean equals(Object o){
		if(o instanceof Book){
			Book b2 = (Book) o;
			return (this.bookId == b2.bookId);
		}
		return false;
	}


	// toString
	public String toString(){
		return "("+ this.bookId  +"," + this.title + "," + this.author + "," + this.dueDate +"," + this.checkedOut + "," + "$" + this.bookValue +  ")";
	}


		// Main method to test whether this contructor and all codes in this class work.
		public static void main(String[] args) {
			//create books
			Book b1 = new Book ("Long", "Line",123, 24.0 );
			Book b2 = new Book ("Short", "Line", 321, 22.0);
			Book b3 = new Book ("Long", "Line", 121, 22.5);
	
			//print to see book
			System.out.println(b1);
			//Output: (123,Long,Line,null,false,$24.0)
	
			//check whether "equals" works
	
			//different books - output: false
			System.out.println(Boolean.toString(b1.equals(b2)));
	
			//same books: output: false
			System.out.println(Boolean.toString(b1.equals(b3)));
			
			System.out.println(b1.getAuthor());
		}

}
