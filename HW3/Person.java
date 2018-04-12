// Pat Wongwiset (nw9ca); HW3

//Do we still need field id?
//Can I delete the unused other method
import java.util.ArrayList;

public class Person {

	// fields
	private String name;
	private ArrayList<Book> checkedOut;

	//added HW3
	private String address;
	private int libraryCardNum;


	// constructor
	public Person(String name, String address, int libraryCardNum){
		this.name = name;
		this.address = address;
		this.libraryCardNum = libraryCardNum;
		this.checkedOut = new ArrayList<Book>();
	}

	// accessory 

	public String getName(){
		return name;
	}

	public ArrayList<Book> getCheckedOut(){
		return checkedOut;
	}

	//added HW3

	public String getAddress(){
		return address;
	}

	public int getLibraryCardNum(){
		return libraryCardNum;
	}


	//Mutator (for name)
	public String setName(String name){
		return this.name = name;
	}

	//added HW3
	public String setAddress(String newAddress){
		return this.address = newAddress;
	}


	// addBook
	public boolean addBook (Book b){
		if( checkedOut.contains(b)){ // check whether the read contains that book b.

			return false; // Yes -> return false
		}
		else{
			checkedOut.add(b); // No -> return true and add the book in read
			b.setCheckedOut(true);
			return true;
		}

	}

	//	//hasRead
	//	public boolean hasRead(Book b){ // Check whether the book has been read
	//		if(this.checkedOut.contains(b)){
	//			return true; // Yes -> return true
	//		}
	//		return false; // No -> return false
	//	}
	//	
	//	
	//	//forgetBook
	//	public boolean forgetBook(Book b){
	//		if( this.checkedOut.contains(b)){ // check whether b is in read.
	//			this.checkedOut.remove(b);
	//			return true; // Yes -> return true and remove the book from read
	//		}
	//			return false; // No -> return false
	//		
	//
	//	}
	//
	//	//numBookRead
	//	public int numBooksRead(){
	//		return this.checkedOut.size(); //number of read books = the size of read Array List
	//	}
	//
	//	//Updated equals
	//	//Check whether the person is the same from their ids
	//	public boolean equals(Object o){
	//		if(o instanceof Person){
	//			Person p2 = (Person) o;
	//			return (this.libraryCardNum == p2.libraryCardNum);
	//		}
	//		return false;
	//	}
	//	
	//	//toString
	//	public String toString(){
	//		return "Name: " + this.name + ", " + "Library Card Number: " + this.libraryCardNum +"," +  ", " + "Checked out book(s): " + this.checkedOut;
	//	}
	//
	//	//commonBooks -> return new arraylist that contains books that both a and b read
	//	public static ArrayList<Book> commonBooks(Person a, Person b){
	//		int i;
	//		int j;
	//		ArrayList<Book> readA = a.checkedOut;
	//		ArrayList<Book> readB = b.checkedOut;
	//		ArrayList<Book> result = new ArrayList<Book>(0); //initiate for the return result
	//		
	//		for( i = 0; i < readA.size(); i++){ //nested loop and use equals() to check and find commonBook
	//			for(j = 0; j < readB.size(); j ++){
	//				if((readA.get(i)).equals(readB.get(j))){
	//					result.add(readA.get(i));
	//				}
	//			}
	//		}
	//	
	//		return result;
	//	}
	//
	//
	//	//similarity -> return how relatively much both a and b read the same book
	//	public static double similarity(Person a, Person b){
	//		if(a.read.size() == 0 || b.read.size() == 0){
	//			return 0.0; // in case that 0/0 -> return 0
	//		}
	//		else{
	//			int numCommonBook = commonBooks(a,b).size();  //find the number of commonBook and then divided by smaller size (a or b)
	//			if(a.read.size() < b.read.size()){
	//				return numCommonBook/(double) a.read.size();
	//			}
	//			return numCommonBook/(double) b.read.size();
	//		}
	//
	//	}


	//Testing
	//	public static void main(String[] args) {
	//		Person K = new Person( "Ken", "101 Main St.", 1111);
	//		Person L = new Person("Liam", "123 McCormick Rd.", 8888);
	//
	//		Book b1 = new Book ("Long", "Line",123, 24.0 );
	//		Book b2 = new Book ("Short", "Line", 321, 22.0);
	//		Book b3 = new Book ("Long", "Line", 121, 22.5);
	//
	//
	//		// addBook() test
	//		K.addBook(b1);
	//		System.out.println(K.addBook(b1)); // 'false' because just added it in the previous line

	//	// hasRead() test
	//	System.out.println(K.hasRead(b1));// 'true' because it's in the read
	//	System.out.println(K.hasRead(b2));// 'false' because not in the read yet
	//	
	//	// forgetBook() test 
	//	K.addBook(b2);
	//	System.out.println(K.read); // [(I Know What You Did Last Winter,D.J. Rolling), (How to?,Dr. M. Mozart)]
	//	K.forgetBook(b2);
	//	System.out.println(K.read); // [(I Know What You Did Last Winter,D.J. Rolling)]
	//	
	//	// numsBookRead() test
	//	System.out.println(K.numBooksRead()); // 1
	//	
	//	// commonBook() test
	//	L.addBook(b1);
	//	L.addBook(b2);
	//	L.addBook(b3);
	//	System.out.println(commonBooks(K, L)); // [(I Know What You Did Last Winter,D.J. Rolling)]
	//	
	//	// Similarity() test
	//	System.out.println(similarity(K,L)); // 1.0
	//	
	//	K.addBook(b2);
	//	K.addBook(b4);
	//	System.out.println(similarity(K,L)); // 0.666666666

	//Every outputs are as their expected values.


}


