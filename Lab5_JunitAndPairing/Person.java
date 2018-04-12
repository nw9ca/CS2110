// Pat Wongwiset (nw9ca); Homework 2
import java.util.ArrayList;

public class Person {

	// fields
	private String name;
	private int id;
	private ArrayList<Book> read;


	// constructor
	public Person( String name, int identification){
		this.name = name;
		this.id = identification;
		this.read = new ArrayList<Book>();
	}

	// accessory 
	public int getId(){
		return id;
	}

	public String getName(){
		return name;
	}

	public ArrayList<Book> getRead(){
		return read;
	}

	//Mutator (for name)
	public String setName(String name){
		return this.name = name;
	}

	// addBook
	public boolean addBook (Book b){
		if( this.read.contains(b)){ // check whether the read contains that book b.
			return false; // Yes -> return false
		}
		else
			this.read.add(b); // No -> return true and add the book in read
			return true;
		
	}

	//hasRead
	public boolean hasRead(Book b){ // Check whether the book has been read
		if(this.read.contains(b)){
			return true; // Yes -> return true
		}
		return false; // No -> return false
	}
	
	
	//forgetBook
	public boolean forgetBook(Book b){
		if( this.read.contains(b)){ // check whether b is in read.
			this.read.remove(b);
			return true; // Yes -> return true and remove the book from read
		}
			return false; // No -> return false
		

	}

	//numBookRead
	public int numBooksRead(){
		return this.read.size(); //number of read books = the size of read Array List
	}

	// equals
	//Check whether the person is the same from their ids
	public boolean equals(Object o){
		if(o instanceof Person){
			Person p2 = (Person) o;
			return (this.id == p2.id);
		}
		return false;
	}
	
	//toString
	public String toString(){
		return "Name: " + this.name + ", " + "ID: "+ this.id + ", " + "Read book(s): " + this.read;
	}

	//commonBooks -> return new arraylist that contains books that both a and b read
	public static ArrayList<Book> commonBooks(Person a, Person b){
		int i;
		int j;
		ArrayList<Book> readA = a.read;
		ArrayList<Book> readB = b.read;
		ArrayList<Book> result = new ArrayList<Book>(0); //initiate for the return result
		
		for( i = 0; i < readA.size(); i++){ //nested loop and use equals() to check and find commonBook
			for(j = 0; j < readB.size(); j ++){
				if((readA.get(i)).equals(readB.get(j))){
					result.add(readA.get(i));
				}
			}
		}
	
		return result;
	}


	//similarity -> return how relatively much both a and b read the same book
	public static double similarity(Person a, Person b){
		if(a.read.size() == 0 || b.read.size() == 0){
			return 0.0; // in case that 0/0 -> return 0
		}
		else{
			int numCommonBook = commonBooks(a,b).size();  //find the number of commonBook and then divided by smaller size (a or b)
			if(a.read.size() < b.read.size()){
				return numCommonBook/(double) a.read.size();
			}
			return numCommonBook/(double) b.read.size();
		}

	}


	//Testing
	public static void main(String[] args) {
	Person K = new Person( "Ken", 1234);
	Person L = new Person("Liam", 5678);
	
	Book b1 = new Book("I Know What You Did Last Winter", "D.J. Rolling");
	Book b2 = new Book("How to?", "Dr. M. Mozart");
	Book b3 = new Book("Conan", "Fujishima");
	Book b4 = new Book("New World", "Unknown");
	
	// addBook() test
	K.addBook(b1);
	System.out.println(K.addBook(b1)); // 'false' because just added it in the previous line
	
	// hasRead() test
	System.out.println(K.hasRead(b1));// 'true' because it's in the read
	System.out.println(K.hasRead(b2));// 'false' because not in the read yet
	
	// forgetBook() test 
	K.addBook(b2);
	System.out.println(K.read); // [(I Know What You Did Last Winter,D.J. Rolling), (How to?,Dr. M. Mozart)]
	K.forgetBook(b2);
	System.out.println(K.read); // [(I Know What You Did Last Winter,D.J. Rolling)]
	
	// numsBookRead() test
	System.out.println(K.numBooksRead()); // 1
	
	// commonBook() test
	L.addBook(b1);
	L.addBook(b2);
	L.addBook(b3);
	System.out.println(commonBooks(K, L)); // [(I Know What You Did Last Winter,D.J. Rolling)]
	
	// Similarity() test
	System.out.println(similarity(K,L)); // 1.0
	
	K.addBook(b2);
	K.addBook(b4);
	System.out.println(similarity(K,L)); // 0.666666666
	
	//Every outputs are as their expected values.
		

	}

}
