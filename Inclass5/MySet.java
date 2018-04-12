//nw9ca InClass5
import java.util.ArrayList;

public class MySet {

	private ArrayList<String> set;

	public MySet(){
		set = new ArrayList<String>();
	}

	public ArrayList<String> getSet(){
		return this.set;
	}

	public boolean add(String str){
		if( this.set.contains(str)){ 
			return false; // Yes -> return false
		}
		else
			this.set.add(str); // No -> return true and add the book in read
		return true;
	}


	public MySet union(MySet s){
		MySet newSet = new MySet();
		for(String ele : this.set){
			newSet.add(ele);
		}
		for(String e2 : s.set){
			if(!this.set.contains(e2)){
				newSet.add(e2);
			}
		}


		return newSet;
	}

	public String toString(){
		return this.set.toString();
	}


	public static void main(String[] args){
		//trying to test
		MySet tester1 = new MySet();
		tester1.add("a");

		System.out.println(tester1);

		MySet tester = new MySet();
		tester.add("a");
		tester.add("b");
		tester.add("c");

		MySet s = new MySet();
		s.add("b");
		s.add("c");
		s.add("d");

		MySet result = new MySet();
		result.add("a");
		result.add("b");
		result.add("c");
		result.add("d");

		System.out.println(tester.union(s));


	}
}


