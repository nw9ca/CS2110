/*
Name: Pat Wongwiset
Computing ID: nw9ca

Answers to reading questions:

*/
// size = 0 when index of h=t

public class Queue {

	final int INITIAL_SIZE = 10;
	String[] elements;
	int currentSize, head, tail;
	
	public Queue(){
		this.elements = new String[this.INITIAL_SIZE];
		this.currentSize = this.head = this.tail = 0;
	}
	
	public void add(String s){
		this.growIfNecessary();
		elements[tail] = s;
		tail = (tail + 1 ) % elements.length;
		currentSize = tail - head; //tail is further than the actual object that is waiting, so it imply that this include the first (head) object.
		 if(head == tail-1){
	        	currentSize = 0;
	        }
		// TODO: Complete this method to implement the add() method for a Queue
        
        
	}
	
	public String remove(){
		this.growIfNecessary();
		String removed = elements[head];
		head = (head + 1) % elements.length;
		currentSize = tail - head;
		// TODO: Complete this method to implement the remove() method for a Queue
        if(head == tail-1){
        	currentSize = 0;
        	return null; //in case that queue is empty.
        }
        return removed;
	}
	
	private void growIfNecessary(){
		if(currentSize == elements.length){
			String[] newElements = new String[2*elements.length];
			for(int i = 0; i < elements.length; i++){
				newElements[i] = elements[(head+i)%elements.length];
			}
			elements = newElements;
			head = 0;
			tail = currentSize;
		}
	}
	
	public static void main(String[] args) {
		
		Queue myQ = new Queue();
		myQ.add("a");
		myQ.add("b");
		myQ.add("c");
		myQ.add("d");
		String[] arr = myQ.elements;
		
		//check add
		System.out.println(arr[0]); //a
		System.out.println(arr[3]); //d
		System.out.println(arr[myQ.head]); //a
		System.out.println(arr[myQ.tail - 1]); //d 
		//I minus one because the tail pointer is still uninitialize
		//the final object is before the tail
		
		//check remove
		myQ.remove();
		System.out.println(arr[myQ.head]); //b
		System.out.println(myQ.currentSize); //3
		
		//check when the size is 0
		Queue myQ2 = new Queue();
		myQ2.add("a");
		String[] arr2 = myQ2.elements;
		System.out.println(arr2[myQ2.head]);//a
		System.out.println(arr2[myQ2.tail - 1]); //a
		System.out.println(myQ2.currentSize); //0

		
        // TODO: Use main-method testing to test your code!
        // Optional suggestion: Write a print method to show the contents of the queue and maybe even your pointers
        

	}

}
