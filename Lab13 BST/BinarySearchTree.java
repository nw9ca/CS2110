import java.util.ArrayList;
import java.util.Collections;
//remove method + inOrderSort
public class BinarySearchTree<T extends Comparable<T>> {

	private Node<T> root;

	public void add(T t){
		if(root == null){
			this.setRoot(new Node(t));
		}
		if(root != null){
			Node newNode = new Node(t);
			this.root.addNode(newNode);
		}


	}
	public void setRoot(Node<T> root) {
		this.root = root;
	}

	public boolean find(T data){
		Node next = null;
		if(this.root.getData().compareTo(data) == 0){
			return true;
		}
		else if(this.root.getData().compareTo(data) < 0){
			next = this.root.getLeft();
		}
		else if(this.root.getData().compareTo(data) > 0){
			next = this.root.getRight();
		}
		if(next == null){
			return false;
		}
		else{
			BinarySearchTree<T> nextTree = new BinarySearchTree<T>();
			nextTree.setRoot(next);
			return nextTree.find(data);
		}

	}


	public void removeRight(T t){
		if(this.find(t)){
			if(t.compareTo(this.root.getData()) == 0){

			}
		}
	}

	public void removeLeft(T t){
	}

	public static <E extends Comparable<E>> ArrayList<E> sort(ArrayList<E> list){
		BinarySearchTree<E> tree = new BinarySearchTree<E>();
		ArrayList<E> arr = new ArrayList<E>();
		int i;
		for(i = 0; i<list.size(); i++){
			tree.add(list.get(i));
		}
		inOrderSort(arr, tree.root);
		return arr;
	}

	public static <E extends Comparable<E>> void inOrderSort(ArrayList<E> list, Node<E> node){
		//		BinarySearchTree<E> tree = new BinarySearchTree<E>();
		//		ArrayList<E> newList = new ArrayList<E>();
		//		int i;
		//		for(i = 0; i<list.size(); i++){
		//			tree.add(list.get(i));
		//		}
		if(node.getLeft() != null){
			inOrderSort(list, node.getLeft());
		}
		list.add(node.getData());

		if(node.getRight() != null){
			inOrderSort(list, node.getRight());
		}







	}

	@Override
	public String toString(){
		return this.root.toString();
	}

	public static void main(String[] args){
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(2);
		arr.add(3);
		arr.add(1);
		arr.add(4);
		sort(arr);
		System.out.println(arr);
	}
}
