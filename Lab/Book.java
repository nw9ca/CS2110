// Pat Wongwiset (nw9ca); Homework 2
public class Book {

	//Create fields
	private String title;
	private String author;

	// Constructor
	public Book( String title_name, String author_name){
		this.title = title_name;
		this.author = author_name;

		// Accessory - getters
		// No mutator (setters) because the book's title and author are fixed.
	}

	public String getTitle(){
		return title;
	}

	public String getAuthor(){
		return author;
	}

	// equals(); 
	public boolean equals(Object o){
		if(o instanceof Book){
			Book b2 = (Book) o;
			return (this.title == b2.title) && (this.author == b2.author);
		}
		return false;
	}


	// toString
	public String toString(){
		return "(" + this.title + "," + this.author + ")";
	}


	// Main method to test whether this contructor and all codes in this class work.
	public static void main(String[] args) {
		//create books
		Book b1 = new Book ("Long", "Line");
		Book b2 = new Book ("Short", "Line");
		Book b3 = new Book ("Long", "Line");

		//print to see book
		System.out.println(b1);
		//Output: (Long,Line)

		//check whether "equals" works

		//different books - output: false
		System.out.println(Boolean.toString(b1.equals(b2)));

		//same books: output: true
		System.out.println(Boolean.toString(b1.equals(b3)));
	}

}
