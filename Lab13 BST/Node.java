
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

	public void addNode(Node<T> newNode){
		if(this == null){
			this.setData(newNode.getData());

		}
		else{
			int val = this.getData().compareTo(newNode.getData());
			if(val <= 0){
				if(this.left == null){
					this.setLeft(newNode);
				}
				if(this.left != null){
					this.left.addNode(newNode);
					//					Node oldLeft = this.getLeft();
					//					oldLeft.addNode(newNode);
					//this.left = oldLeft;
				}
			}
			else{
				if(this.right == null){
					this.setRight(newNode);
				}
				if(this.right != null){
					this.right.addNode(newNode);
					//					Node oldRight = this.getRight();
					//					oldRight.addNode(newNode);
					//this.right = oldRight;
				}
			}
		}
	}

	@Override
	public String toString(){
		if(this.getData() == null){
			return "";
		}

		else{
			String str = "";
			if(data == null){
				str += "";
			}
			if(left != null){
				str +=left.toString();
			}

			if(data != null){
				str += "(" + data +")";
			}

			if(right != null){
				str += right.toString();
			}


			return str;
		}

	}
}
