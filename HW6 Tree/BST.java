
@SuppressWarnings("hiding")
public class BST<Integer> {
	private BST<Integer> left;
	private BST<Integer> right;
	private Integer data;

//	public BTS(){
//		this(null,null,null);
//	}

	public BST(Integer theData){
		this(theData,null,null);
	}

	public BST(Integer theData, BST<Integer> leftChild, BST<Integer> rightChild){
		data = theData;
		left = leftChild;
		right = rightChild;
	}
	
	public boolean findBST(Integer data){
	if(this == null){
		return false;
	}
	if(this.data == data){
		return true;
	}
	if(this.left != null && this.left.equals(data)){
		return true;
	}
	
	if(this.right != null && this.right.equals(data)){
		return true;
	}
	
	if(this.data > data){
		return this.left.findBST(data);
	}
	
	return this.right.findBST(data);
	
}
	
	public BST<Integer> getLeft() {
		return left;
	}

	public void setLeft(BST<Integer> left) {
		this.left = left;
	}

	public BST<Integer> getRight() {
		return right;
	}

	public void setRight(BST<Integer> right) {
		this.right = right;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public void insert(int data){
		if(this == null){
			this.setData(data);
		}
		
		if(this.data < data){
			this.right.insert(data);
		}
		
		if(this.data > data){
			this.left.insert(data);
		}
		
	}
	
	public static void main(String[] args) {
		BST<Integer> s = new BST<Integer>(37);
		
	}
	

}
