// Pat Wongwiset (nw9ca); HW 6
public class BinaryTree<T> {

	private BinaryTreeNode<T> root;

	public BinaryTree() {
		this(null);
	}

	public BinaryTree(BinaryTreeNode<T> newRoot) {
		this.root = newRoot;
	}

	public BinaryTreeNode<T> getRoot() {
		return root;
	}

	public void setRoot(BinaryTreeNode<T> root) {
		this.root = root;
	}

	/**
	 * equals()
	 * check the identity (shape and data) is similar
	 * @return boolean
	 */
	@Override
	public boolean equals(Object o) {
		if(o instanceof BinaryTree){
			BinaryTree<T> t = (BinaryTree<T>) o;
			if(this == null && t == null){
				return true;
			}
			if(this == null || t == null){
				return false;
			}
			return t.getRoot().equals(this.getRoot());
		}
		return false;
	}

	/**
	 * deepcopy()
	 * create new BinaryTree from current root
	 * @return BinaryTree<T>
	 */
	public BinaryTree<T> deepCopy() {
		BinaryTree<T> t= new BinaryTree<T>(this.getRoot());
		return t;
	}

	/**
	 * combine()
	 * @param newRoot
	 * @param t
	 * @param left
	 * @return BinaryTree
	 */
	public BinaryTree<T> combine(BinaryTreeNode<T> newRoot, BinaryTree<T> t, boolean left) {
		BinaryTreeNode<T> deepNewRoot = newRoot.deepCopy();
		if(left){ //in case that wants the calling tree on left side and passing tree on the right
			BinaryTreeNode<T> tLeft= this.deepCopy().getRoot();
			BinaryTreeNode<T> tRight = t.deepCopy().getRoot();
			deepNewRoot.setLeft(tLeft);
			deepNewRoot.setRight(tRight);

			BinaryTree<T> result = new BinaryTree<T>(deepNewRoot);
			return result;
		}
		else{ //in case that wants the calling tree on right side and passing tree on the left

			BinaryTreeNode<T> tRight= this.deepCopy().getRoot();
			BinaryTreeNode<T> tLeft = t.deepCopy().getRoot();
			deepNewRoot.setLeft(tLeft);
			deepNewRoot.setRight(tRight);

			BinaryTree<T> result = new BinaryTree<T>(deepNewRoot);
			return result;
		}
	}

	/**
	 * size()
	 * finding the size of the tree
	 * @return int
	 */
	public int size(){
		if(this.getRoot() == null){
			return 0;
		}
		return this.getRoot().size();
	}

	/**
	 * height()
	 * level of the tree
	 * @return int
	 */
	public int height(){
		if(this.root != null){
			return this.getRoot().height();
		}
		else{
			return 0;
		}
	}

	/**
	 * full()
	 * the full tree has the pattern that 2^(height) - 1 = size
	 * @return boolean
	 */
	public boolean full(){
		return this.getRoot().full();
	}

	/**
	 * mirror()
	 * reflecting (switching left to right and right to left)
	 */
	public void mirror(){
		if(this.getRoot() != null){
			this.getRoot().mirror();
		}

	}

	public String inOrder(){
		if(this.getRoot() == null){
			return "";
		}

		return this.getRoot().inOrder();
	}
}
