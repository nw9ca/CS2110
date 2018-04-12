// Pat Wongwiset (nw9ca); HW 6 
public class BinaryTreeNode<T> {

	private BinaryTreeNode<T> left;
	private BinaryTreeNode<T> right;
	private T data;

	public BinaryTreeNode(){
		this(null,null,null);
	}

	public BinaryTreeNode(T theData){
		this(theData,null,null);
	}

	public BinaryTreeNode(T theData, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild){
		data = theData;
		left = leftChild;
		right = rightChild;
	}

	public int size(){
		int size = 0; //the size of the tree

		//The size of the tree rooted at this node is one more than the
		//sum of the sizes of its children.
		if(left != null){
			size = size + left.size();
		}
		if(right != null){
			size = size + right.size();
		}
		return size + 1; //add one to account for the current node
	}
	
	public int oneChild(){
		int num = 0;
		if(this.left == null && this.right != null){
			num += 1;
		}
		if(this.right == null && this.left != null){
			num += 1;
		}
		if(this.left != null){
			num += this.left.oneChild();
		}
		if(this.right != null){
			num += this.right.oneChild();
		}
		return num;
	}
	
	public boolean findBT(T data){
		if(this.data == null){
			return false;
		}
		
		if(this.data.equals(data)){
			return true;
		}
		if(this.left != null && this.left.equals(data)){
			return true;
		}
		
		if(this.right != null && this.right.equals(data)){
			return true;
		}
		
		if(this.left != null && this.left.findBT(data)){
			return true;
		}
		
		if(this.right != null && this.right.findBT(data)){
			return true;
		}
		
		return false;
	}
	
//	public boolean findBST(T data){
//		if(this.data == null){
//			return false;
//		}
//		if(this.data.equals(data)){
//			return true;
//		}
//		if(this.left != null && this.left.equals(data)){
//			return true;
//		}
//		
//		if(this.right != null && this.right.equals(data)){
//			return true;
//		}
//		
//		if(this.data > data){
//			return this.left.findBST(data);
//		}
//		
//		return this.right.findBST(data);
//		
//	}

	public BinaryTreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}

	public BinaryTreeNode<T> getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}


	public BinaryTreeNode<T> deepCopy(){
		BinaryTreeNode<T> copy = new BinaryTreeNode<T>(this.data);
		BinaryTreeNode<T> newLeft = null;
		BinaryTreeNode<T> newRight = null;
		if (this.left != null) {
			newLeft = this.left.deepCopy();
			copy.setLeft(newLeft);
		}
		if (this.right != null) {
			newRight = this.right.deepCopy();
			copy.setRight(newRight);
		}
		return copy;		
	}

	@Override
	public boolean equals(Object o){
		if(o instanceof BinaryTreeNode){
			BinaryTreeNode<T> t = (BinaryTreeNode<T>) o;
					if(this == null && t == null){
						return true;
					}
					
					if(this == null || t == null){
						return false;
					}

					if(this.getData() == null && t.getData() == null){
						return true; //both null
					}
					if(this.getData() == null || t.getData() == null){
						return false;	
					}
					if(!this.getData().equals(t.getData())){
						return false;
					}
					
					//check on the left
					if(this.getLeft() == null && t.getLeft() == null){
						return true;
					}
					if(this.getLeft() == null || t.getLeft() == null){
						return false;
					}
					if(this.getLeft().getData() == null && t.getLeft().getData() == null){
						return true; //both null
					}
					if(this.getLeft().getData() == null || t.getLeft().getData() == null){
						return false;	
					}
					if(!this.getLeft().getData().equals(t.getLeft().getData())){
						return false;
					}
					
					//check on the right
					if(this.getRight() == null && t.getRight() == null){
						return true;
					}
					if(this.getRight() == null || t.getRight() == null){
						return false;
					}
					if(this.getRight().getData() == null && t.getRight().getData() == null){
						return true; //both null
					}
					if(this.getRight().getData() == null || t.getRight().getData() == null){
						return false;	
					}
					if(!this.getRight().getData().equals(t.getRight().getData())){
						return false;
					}
					
					else if(this.getData().equals(t.getData())){
						return this.getLeft().equals(t.getLeft()) && this.getRight().equals(t.getRight());
					}
				}
		
				return false;



	}

	/**
	 * height()
	 * level of tree
	 * @return int
	 */
	public int height(){
		int lHeight = 0; //create lHeight and rHeight in order to count the number of nodes on both branches
		int rHeight = 0;
		if(left != null){
			lHeight = lHeight + left.height();
		}
		if(right != null){
			rHeight = rHeight + right.height();
		}
		if(lHeight > rHeight){ //compare to choose the highest number
			return lHeight + 1; //+ 1 because of root
		}
		else{
			return rHeight + 1;
		}
	}


	/**
	 * full()
	 * the full tree has the pattern that 2^(height) - 1 = size
	 * @return boolean
	 */
	public boolean full(){
		if(Math.pow(2, this.height()) -1 == this.size()){
			return true;
		}
		return false;
	}

	/**
	 * mirror()
	 * reflecting (switching left to right and right to left)
	 */
	public void mirror(){
		if(this != null){
			BinaryTreeNode<T> oldRight = this.getRight();
			BinaryTreeNode<T> oldLeft = this.getLeft();
			this.setLeft(oldRight);
			if(left != null){
				
				left.mirror();
			}
			this.setRight(oldLeft);
			if(right != null){
					
				right.mirror();
			}
		}
	}

	/**
	 * inOrder()
	 * initialize String to return
	 * check the left size and recurse method from the bottom
	 * print from the bottom
	 * @return String
	 */
	public String inOrder(){
		String str = "";
		if(data == null){
			str += "";
		}
		if(left != null){
			str +=left.inOrder();
		}

		if(data != null){
			str += "(" + data +")";
		}

		if(right != null){
			str += right.inOrder();
		}


		return str;


	}
	
	public void preOrder(){
		System.out.println("(" + this.data + ")");
		if(this.left != null){
			this.left.preOrder();
		}
		if(this.right != null){
			this.right.preOrder();
		}
		
	}
	
	public String postOrder(){
		String str = "";
		if(this.left != null){
			str += this.left.postOrder();
		}
		if(this.right != null){
			str += this.right.postOrder();
		}
		str += "(" + this.data + ")";
		
		return str;
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> t = new BinaryTreeNode<Integer>(4);
		t.setLeft(new BinaryTreeNode<Integer>(2));
		t.left.setLeft(new BinaryTreeNode<Integer>(5));
		t.setRight(new BinaryTreeNode<Integer>(3));
		BinaryTreeNode<Integer> s = t.deepCopy();
		s.setLeft(new BinaryTreeNode<Integer>(1));
		System.out.println(t.oneChild());
		System.out.println(t.inOrder());
		System.out.println(t.findBT(3));
		
		System.out.println("****BST on BT****");
		BinaryTreeNode<Integer> bst = new BinaryTreeNode<Integer>(37);
		bst.setLeft(new BinaryTreeNode<Integer>(24));
		bst.left.setLeft(new BinaryTreeNode<Integer>(23));
		bst.left.setRight(new BinaryTreeNode<Integer>(25));
		bst.left.left.setLeft(new BinaryTreeNode<Integer>(20));
		bst.setRight(new BinaryTreeNode<Integer>(42));
		bst.right.setRight(new BinaryTreeNode<Integer>(45));
		bst.right.right.setRight(new BinaryTreeNode<Integer>(60));
		
		System.out.println(bst.findBT(45));
		
		System.out.println("***pre-order***");
		bst.preOrder();
		
		System.out.println("***post-order***");
		System.out.println(bst.postOrder());

	}

}
