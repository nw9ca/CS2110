import java.util.ArrayList;

public class BinarySearchTree<T extends Comparable<T>> {
	
	private Node<T> root;
	
	public void add(T t){
		Node<T> newNode = new Node<T>(t);
		if(root == null){
			root = newNode;
		}
		else{
			root.addNode(newNode);
		}
		
	}
	
	public boolean find(T data){
		Node<T> current = root;
		while(current != null){
			int d = current.getData().compareTo(data);
			if(d == 0){
				return true;
			}
			else if(d < 0){
				current = current.getLeft();
			}
			else{
				current = current.getRight();
			}
		}
		return false;
	}
	
	public void removeRight(T t){
		Node<T> toBeRemoved = root;
		Node<T> parent = null;
		boolean found = false;
		while(!found && toBeRemoved != null){
			int d = toBeRemoved.getData().compareTo(t);
			if(d == 0){
				found = true;
			}
			else{
				parent = toBeRemoved;
				if(d > 0){
					toBeRemoved = toBeRemoved.getLeft();
				}
				else{
					toBeRemoved = toBeRemoved.getRight();
				}
			}
		}
		
		if(!found){
			return;
		}
		
		if(toBeRemoved.getLeft() == null || toBeRemoved.getRight() == null){
			Node<T> newChild;
			if(toBeRemoved.getLeft() == null){
				newChild = toBeRemoved.getRight();
			}else{
				newChild = toBeRemoved.getLeft();
			}
			if(parent == null){
				root = newChild;
			}
			else if(parent.getLeft() == toBeRemoved){
				parent.setLeft(newChild);
			}
			else{
				parent.setRight(newChild);
			}
			return;
		}
		
		Node<T> smallestParent = toBeRemoved;
		Node<T> smallest = toBeRemoved.getRight();
		while(smallest.getLeft() != null){
			smallestParent = smallest;
			smallest = smallest.getLeft();
		}
		
		toBeRemoved.setData(smallest.getData());
		if(smallestParent == toBeRemoved){
			smallestParent.setRight(smallest.getRight());
		}else{
			smallestParent.setLeft(smallest.getRight());
		}
	}

	public void removeLeft(T t){
		Node<T> toBeRemoved = root;
		Node<T> parent = null;
		boolean found = false;
		while(!found && toBeRemoved != null){
			int d = toBeRemoved.getData().compareTo(t);
			if(d == 0){
				found = true;
			}
			else{
				parent = toBeRemoved;
				if(d > 0){
					toBeRemoved = toBeRemoved.getLeft();
				}
				else{
					toBeRemoved = toBeRemoved.getRight();
				}
			}
		}
		
		if(!found){
			return;
		}
		
		if(toBeRemoved.getLeft() == null || toBeRemoved.getRight() == null){
			Node<T> newChild;
			if(toBeRemoved.getLeft() == null){
				newChild = toBeRemoved.getRight();
			}else{
				newChild = toBeRemoved.getLeft();
			}
			if(parent == null){
				root = newChild;
			}
			else if(parent.getLeft() == toBeRemoved){
				parent.setLeft(newChild);
			}
			else{
				parent.setRight(newChild);
			}
			return;
		}
		
		Node<T> smallestParent = toBeRemoved;
		Node<T> smallest = toBeRemoved.getLeft();
		while(smallest.getRight() != null){
			smallestParent = smallest;
			smallest = smallest.getRight();
		}
		
		toBeRemoved.setData(smallest.getData());
		if(smallestParent == toBeRemoved){
			smallestParent.setLeft(smallest.getLeft());
		}else{
			smallestParent.setRight(smallest.getLeft());
		}
	}

	public static <E extends Comparable<E>> ArrayList<E> sort(ArrayList<E> list){
		BinarySearchTree<E> tree = new BinarySearchTree<E>();
		for(E e: list){
			tree.add(e);
		}
		ArrayList<E> newList = new ArrayList<E>();
		inOrderSort(newList, tree.root);
		
		return newList;
		
	}
	
	public static <E extends Comparable<E>> void inOrderSort(ArrayList<E> list, Node<E> node){
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
		return root.toString();
	}
	
	public static void main(String[] args){
//		BinarySearchTree<String> tree = new BinarySearchTree<String>();
//		tree.add("Leo");
//		tree.add("Hester");
//		tree.add("Ressie");
//		tree.add("Keira");
//		tree.add("Damian");
//		tree.add("Victor");
//		tree.add("Collin");
//		tree.add("Marci");
//		tree.add("Ashlie");
//		tree.add("Willis");
//		tree.add("Eric");
//		tree.add("Mya");
//		tree.add("Elizabeth");
//		tree.add("Ralph");
//		System.out.println(tree);
//		tree.removeLeft("Hester");
//		tree.removeLeft("Mya");
//		System.out.println(tree);
		
		ArrayList<String> str = new ArrayList<String>();
		str.add("Yesterday");
		str.add("Hello");
		str.add("Good");
		str.add("Hey");
		str.add("Today");
		
		
		ArrayList<String> newList = sort(str);
		
		System.out.println(newList);
		System.out.println(str);
	}
}
