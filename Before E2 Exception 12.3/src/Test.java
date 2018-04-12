import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class Test {

	public static void main(String[] args) {
		Queue q = new LinkedList<Integer>();
		q.add(3);
		q.add(2);
		q.add(1);
		while(q.size() != 0){
			System.out.println(q.remove());
		}
		// TODO Auto-generated method stub

	}
	

}
