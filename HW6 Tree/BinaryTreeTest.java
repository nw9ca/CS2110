// Pat Wongwiset (nw9ca); HW 6
//**inOrder (not sure why not including 1)
//*equals() method
import static org.junit.Assert.*;

import org.junit.Test;

public class BinaryTreeTest {

	//BinaryTreeNode
	//equals() false case
	@Test
	public void equalsTest1() {
		BinaryTreeNode<Integer> t = new BinaryTreeNode<Integer>(1, new BinaryTreeNode<Integer>(2),new BinaryTreeNode<Integer>(3));
		BinaryTreeNode<Integer> s = new BinaryTreeNode<Integer>(1);
		assertFalse(t.equals(s));
	}

	@Test
	//equals() true case
	public void equalsTest2() {
		BinaryTreeNode<Integer> t = new BinaryTreeNode<Integer>(1, new BinaryTreeNode<Integer>(2),new BinaryTreeNode<Integer>(3));
		BinaryTreeNode<Integer> s = new BinaryTreeNode<Integer>(1);
		s.setLeft(new BinaryTreeNode<Integer>(2));
		s.setRight(new BinaryTreeNode<Integer>(3));
		assertTrue(t.equals(s));
	}

	//size() null case
	@Test
	public void sizeTest1(){
		BinaryTreeNode<Integer> t = new BinaryTreeNode<Integer>();
		assertEquals(t.size(),1);
	}

	//size() not null
	@Test
	public void sizeTest2(){
		BinaryTreeNode<Integer> t = new BinaryTreeNode<Integer>(1);
		t.setLeft(new BinaryTreeNode<Integer>(2));
		t.setRight(new BinaryTreeNode<Integer>(3));
		assertEquals(t.size(),3);
	}

	//height() null case
	@Test
	public void heightTest1(){
		BinaryTreeNode<Integer> t = new BinaryTreeNode<Integer>();
		assertEquals(t.height(),1);
	}

	//height() not null 
	@Test
	public void heightTest2(){
		BinaryTreeNode<Integer> t = new BinaryTreeNode<Integer>(1);
		t.setLeft(new BinaryTreeNode<Integer>(2));
		t.setRight(new BinaryTreeNode<Integer>(3));
		assertEquals(t.height(),2);
	}

	//full() true case
	@Test
	public void fullTest1(){
		BinaryTreeNode<Integer> t = new BinaryTreeNode<Integer>(1);
		t.setLeft(new BinaryTreeNode<Integer>(2));
		t.setRight(new BinaryTreeNode<Integer>(3));
		assertTrue(t.full());
	}

	//full() false case
	@Test
	public void fullTest2(){
		BinaryTreeNode<Integer> t = new BinaryTreeNode<Integer>(1);
		t.setLeft(new BinaryTreeNode<Integer>(2));
		assertFalse(t.full());
	}

	//mirror() false case
	@Test
	public void mirrorTest1(){
		BinaryTreeNode<Integer> t = new BinaryTreeNode<Integer>(1);
		t.setLeft(new BinaryTreeNode<Integer>(2));
		t.setRight(new BinaryTreeNode<Integer>(3));
		t.mirror();
		assertFalse(t.getRight().equals(new BinaryTreeNode<Integer>(3)));
	}

	//mirror() true case
	@Test
	public void mirrorTest2(){
		BinaryTreeNode<Integer> t = new BinaryTreeNode<Integer>(1);
		t.setLeft(new BinaryTreeNode<Integer>(2));
		t.setRight(new BinaryTreeNode<Integer>(3));
		t.mirror();
		assertTrue(t.getRight().equals(new BinaryTreeNode<Integer>(2)));
	}
	
	@Test
	//mirror() null case
	public void mirrorTest5(){
		BinaryTreeNode<Integer> t = new BinaryTreeNode<Integer>();
		t.mirror();
		assertNull(t.getData());
	}
	
	//mirror()
	@Test
	public void mirrorTest6(){
		BinaryTreeNode<Integer> t = new BinaryTreeNode<Integer>(1);
		t.mirror();
		assertEquals(t,new BinaryTreeNode<Integer>(1));
	}

	//deepCopy() true case
	@Test
	public void deepCopyTest1(){
		BinaryTreeNode<Integer> t = new BinaryTreeNode<Integer>(1);
		t.setLeft(new BinaryTreeNode<Integer>(2));
		t.setRight(new BinaryTreeNode<Integer>(3));
		BinaryTreeNode<Integer> s = t.deepCopy();
		assertTrue(t.equals(s));
	}

	//deepCopy() false case
	@Test
	public void deepCopyTest2(){
		BinaryTreeNode<Integer> t = new BinaryTreeNode<Integer>(1);
		t.setLeft(new BinaryTreeNode<Integer>(2));
		t.setRight(new BinaryTreeNode<Integer>(3));
		BinaryTreeNode<Integer> s = t.deepCopy();
		s.setLeft(new BinaryTreeNode<Integer>(1));
		assertFalse(t.equals(s));
	}

		//inOrder() not null (1,2)
		@Test
		public void inOrderTest1(){
			BinaryTreeNode<Integer> t = new BinaryTreeNode<Integer>(1);
			t.setLeft(new BinaryTreeNode<Integer>(2));
			t.setRight(new BinaryTreeNode<Integer>(3));
			t.getLeft().setLeft(new BinaryTreeNode<Integer>(4));
			t.getRight().setRight(new BinaryTreeNode<Integer>(5));
			assertEquals(t.inOrder(), "(4)(2)(1)(3)(5)");
		}
		
		@Test
		public void inOrderTest2(){
			BinaryTreeNode<Integer> t = new BinaryTreeNode<Integer>();
			assertEquals(t.inOrder(), "");
		}

	//BinaryTree
	//equals() false case
	@Test
	public void equalsTest3(){
		BinaryTree<Integer> t = new BinaryTree<Integer>(new BinaryTreeNode<Integer>(2) );
		t.getRoot().setLeft(new BinaryTreeNode<Integer>(2));
		BinaryTree<Integer> t2 = new BinaryTree<Integer>(new BinaryTreeNode<Integer>(2) );
		t.getRoot().setRight(new BinaryTreeNode<Integer>(2));
		assertFalse(t.equals(t2));
	}

	//equals() true case
	@Test
	public void equalsTest4(){
		BinaryTree<Integer> t = new BinaryTree<Integer>(new BinaryTreeNode<Integer>(2) );
		t.getRoot().setLeft(new BinaryTreeNode<Integer>(2));
		BinaryTree<Integer> t2 = new BinaryTree<Integer>(new BinaryTreeNode<Integer>(2) );
		t2.getRoot().setLeft(new BinaryTreeNode<Integer>(2));
		assertTrue(t.equals(t2));
	}

	//deepCopy() not null
	@Test
	public void deepCopyTest3(){
		BinaryTree<Integer> t = new BinaryTree<Integer>(new BinaryTreeNode<Integer>(1) );
		t.getRoot().setLeft(new BinaryTreeNode<Integer>(2));
		t.getRoot().setRight(new BinaryTreeNode<Integer>(3));
		BinaryTree<Integer> t2 = t.deepCopy();
		assertNotNull(t2);
	}

	//deepCopy() true case 
	@Test
	public void deepCopyTest4(){
		BinaryTree<Integer> t = new BinaryTree<Integer>(new BinaryTreeNode<Integer>(1) );
		t.getRoot().setLeft(new BinaryTreeNode<Integer>(2));
		t.getRoot().setRight(new BinaryTreeNode<Integer>(3));
		BinaryTree<Integer> t2 = t.deepCopy();
		assertTrue(t.equals(t2));
	}

		@Test 
		public void combineTest1(){
			BinaryTree<Integer> t = new BinaryTree<Integer>(new BinaryTreeNode<Integer>(1));
			t.getRoot().setLeft(new BinaryTreeNode<Integer>(3));
			BinaryTree<Integer> t2 = new BinaryTree<Integer>(new BinaryTreeNode<Integer>(11));
			BinaryTree<Integer> t3 =t.combine(new BinaryTreeNode<Integer>(2), t2, true);
			assertTrue(t3.getRoot().getData().equals(2));
			//System.out.println(t3.getRoot().getData());
		}
		
		@Test //on the right side
		
		public void combineTest2(){			
			BinaryTree<Integer> t = new BinaryTree<Integer>(new BinaryTreeNode<Integer>(1));
			t.getRoot().setLeft(new BinaryTreeNode<Integer>(3));
			BinaryTree<Integer> t2 = new BinaryTree<Integer>(new BinaryTreeNode<Integer>(11));
			BinaryTree<Integer> t3 =t.combine(new BinaryTreeNode<Integer>(2), t2, false);
			assertTrue(t3.getRoot().getRight().getLeft().equals(new BinaryTreeNode<Integer>(3)));
		}
		
		
	//size 
	@Test
	public void sizeTest3(){
		BinaryTree<Integer> t = new BinaryTree<Integer>(new BinaryTreeNode<Integer>(1) );
		t.getRoot().setLeft(new BinaryTreeNode<Integer>(2));
		t.getRoot().setRight(new BinaryTreeNode<Integer>(3));
		assertEquals(t.size(), 3);
	}

	@Test
	public void sizeTest4(){
		BinaryTree<Integer> t = new BinaryTree<Integer>(new BinaryTreeNode<Integer>(1) );
		t.getRoot().setLeft(new BinaryTreeNode<Integer>(2));
		t.getRoot().getLeft().setLeft(new BinaryTreeNode<Integer>(3));
		assertEquals(t.size(), 3);

	}

	//height
	@Test
	public void heightTest3(){
		BinaryTree<Integer> t = new BinaryTree<Integer>(new BinaryTreeNode<Integer>(1) );
		t.getRoot().setLeft(new BinaryTreeNode<Integer>(2));
		t.getRoot().setRight(new BinaryTreeNode<Integer>(3));
		t.getRoot().getLeft().setLeft(new BinaryTreeNode<Integer>(3));
		assertEquals(t.height(), 3);
	}

	@Test // null case
	public void heightTest4(){
		BinaryTree<Integer> t = new BinaryTree<Integer>();
		assertEquals(t.height(), 0);
	}

	//full
	@Test //true case
	public void fullTest3(){
		BinaryTreeNode<Integer> t = new BinaryTreeNode<Integer>(1);
		t.setLeft(new BinaryTreeNode<Integer>(2));
		t.setRight(new BinaryTreeNode<Integer>(3));
		BinaryTree<Integer> t2 = new BinaryTree<Integer>(t);
		assertTrue(t2.full());
	}
	
	@Test //false case
	public void fullTest4(){
		BinaryTreeNode<Integer> t = new BinaryTreeNode<Integer>(1);
		t.setLeft(new BinaryTreeNode<Integer>(2));
		t.setRight(new BinaryTreeNode<Integer>(3));
		t.getLeft().setLeft(new BinaryTreeNode<Integer>(4));
		BinaryTree<Integer> t2 = new BinaryTree<Integer>(t);
		assertFalse(t2.full());
	}
	
	//mirror
	@Test
	public void mirrorTest3(){
		BinaryTreeNode<Integer> t = new BinaryTreeNode<Integer>(1);
		t.setLeft(new BinaryTreeNode<Integer>(2));
		t.setRight(new BinaryTreeNode<Integer>(3));
		t.getLeft().setLeft(new BinaryTreeNode<Integer>(4));
		t.getLeft().setRight(new BinaryTreeNode<Integer>(5));
		t.getLeft().getRight().setRight(new BinaryTreeNode<Integer>(6));
		BinaryTree<Integer> t2 = new BinaryTree<Integer>(t);
		t2.mirror();
		System.out.println(t2.getRoot().getRight().getData());
		assertTrue(t2.getRoot().getRight().getLeft().getLeft().equals(new BinaryTreeNode<Integer>(6)));
	}
	
	@Test
	public void mirrorTest4(){
		BinaryTreeNode<Integer> t = new BinaryTreeNode<Integer>(1);
		t.setLeft(new BinaryTreeNode<Integer>(2));
		t.setRight(new BinaryTreeNode<Integer>(3));
		t.getLeft().setLeft(new BinaryTreeNode<Integer>(4));
		t.getLeft().setRight(new BinaryTreeNode<Integer>(5));
		BinaryTree<Integer> t2 = new BinaryTree<Integer>(t);
		t2.mirror();
		assertFalse(t2.getRoot().getRight().equals(new BinaryTreeNode<Integer>(2)));
	}
	
	@Test	
	public void mirrorTest7(){
		BinaryTree<Integer> t2 = new BinaryTree<Integer>();
		t2.mirror();
		assertNull(t2.getRoot()
				);
	}
	
		
	//inOrder (3,4)
	@Test
	public void inOrderTest3(){
		BinaryTreeNode<Integer> t = new BinaryTreeNode<Integer>(1);
		t.setLeft(new BinaryTreeNode<Integer>(2));
		t.setRight(new BinaryTreeNode<Integer>(3));
		t.getLeft().setLeft(new BinaryTreeNode<Integer>(4));
		t.getLeft().setRight(new BinaryTreeNode<Integer>(5));
		BinaryTree<Integer> t2 = new BinaryTree<Integer>(t);
		assertEquals(t2.inOrder(), "(4)(2)(5)(1)(3)");
	}
	
	
	@Test
	public void inOrderTest4(){
		BinaryTree<Integer> t2 = new BinaryTree<Integer>();
		assertEquals(t2.inOrder(), "");
	}

	@Test
	public void sampleTest(){
		BinaryTreeNode<Integer> t2 = new BinaryTreeNode<Integer>();
		assertNotNull(t2);
	}


}

