
public class Node<T extends Comparable<T>> {
	private T data;
    private Node<T> left;
    private Node<T> right;

    public Node(){
    	data = null;
    	left = null;
    	right = null;
    }
    
    public Node(T t){
    	data = t;
    	left = null;
    	right = null;
    }
    
    public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getLeft() {
		return left;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public Node<T> getRight() {
		return right;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}

	public void addNode(Node<T> newNode)
    {
       int comp = newNode.data.compareTo(data);
       if (comp < 0)
       {
          if (left == null) { left = newNode; }
          else { left.addNode(newNode); }
       }
       else if (comp > 0)
       {
          if (right == null) { right = newNode; }
          else { right.addNode(newNode); }
       }
    }
	
//	public void insert(Node<T> newnode){
//		if(this.data == null){
//			this.setData(newnode.data);
//		}
//		if(data.compareTo(this.data) > 0){
//			this.right.insert(newnode);
//		}
//		if(data.compareTo(this.data) < 0){
//			this.left.insert(newnode);
//		}
//	}
	
	@Override
	public String toString(){
		String str = "";
		if(left != null){
			str += left.toString();
		}
		str += " " + data.toString() + " ";
		if(right != null){
			str += right.toString();
		}
		return str;
	}
	
	public int oneChildAndLeaves(){
//		if(this == null){
//			return 0;
//		}
		
		int count = 0;
		if(this.left == null && this.right != null){
			
			count += 1;
			
		}
		
		if(this.right == null && this.left != null){
			
			count += 1;
			
		}
		if(this.right == null && this.left == null){
			
			count += 1;
		}
		
		if(this.left != null){
		count += this.left.oneChildAndLeaves();
		}
		
		if(this.right != null){
		count += this.right.oneChildAndLeaves();
		}
		
		return count;
	}
	
	public static void main(String[] args){
		Node<Integer> n = new Node<Integer>(4);
		n.setLeft(new Node<Integer>(3));
		n.setRight(new Node<Integer>(5));
		n.left.setLeft(new Node<Integer>(2));
		n.addNode(new Node<Integer>(6));
		System.out.println(n.toString());
		
		Node<String> n2 = new Node<String>("a");
		n2.setLeft(new Node<String>("b"));
		n2.setRight(new Node<String>("c"));
		n2.left.setLeft(new Node<String>("d"));
		n2.right.setRight(new Node<String>("e"));
		n2.right.setLeft(new Node<String>("f"));
		
		System.out.println(n2.oneChildAndLeaves());
	}
}
