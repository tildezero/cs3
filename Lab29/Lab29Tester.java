import junit.framework.*; 
import java.util.*;

public class Lab29Tester extends TestCase
{
	public void testAddPreOrder()
	{
		ListBinaryTree tree = new ListBinaryTree();
		
		tree.add(5);
		tree.add(3);
		tree.add(7);
		tree.add(1);
		tree.add(4);
		tree.add(6);
		tree.add(8);
		
		assertEquals("[5, 3, 1, 4, 7, 6, 8]", tree.preorder());

	}
	
	public void testAddInOrder()
	{
		ListBinaryTree tree = new ListBinaryTree();
		
		tree.add(5);
		tree.add(3);
		tree.add(7);
		tree.add(1);
		tree.add(4);
		tree.add(6);
		tree.add(8);
		
		assertEquals("[1, 3, 4, 5, 6, 7, 8]", tree.inorder());
	}
	
	public void testAddPostOrder()
	{
		ListBinaryTree tree = new ListBinaryTree();
		
		tree.add(5);
		tree.add(3);
		tree.add(7);
		tree.add(1);
		tree.add(4);
		tree.add(6);
		tree.add(8);
		
		assertEquals("[1, 4, 3, 6, 8, 7, 5]", tree.postorder());
	}
	
	public void testAddAll()
	{
		List<Integer> numbers = new LinkedList<Integer>();
		numbers.add(5);
		numbers.add(3);
		numbers.add(7);
		numbers.add(1);
		numbers.add(4);
		numbers.add(6);
		numbers.add(8);
		
		ListBinaryTree tree = new ListBinaryTree();
		tree.addAll(numbers);
		
		assertEquals("[5, 3, 1, 4, 7, 6, 8]", tree.preorder());
		assertEquals("[1, 3, 4, 5, 6, 7, 8]", tree.inorder());
		assertEquals("[1, 4, 3, 6, 8, 7, 5]", tree.postorder());
	}
	
	public void testSize()
	{
		ListBinaryTree tree = new ListBinaryTree();
		
		tree.add(5);
		tree.add(3);
		tree.add(7);
		tree.add(1);
		tree.add(4);
		tree.add(6);
		tree.add(8);
		
		assertEquals(7, tree.size());
	}
	
	public void testValueAt()
	{
		ListBinaryTree tree = new ListBinaryTree();
		
		tree.add(5);
		tree.add(3);
		tree.add(7);
		tree.add(1);
		tree.add(4);
		tree.add(6);
		tree.add(8);
		
		assertEquals("getValueAt index 0", 5, tree.getValueAt(0));
		assertEquals("getValueAt index 1", 3, tree.getValueAt(1));
		assertEquals("getValueAt index 2", 7, tree.getValueAt(2));
		assertEquals("getValueAt index 3", 1, tree.getValueAt(3));
		assertEquals("getValueAt index 4", 4, tree.getValueAt(4));
		assertEquals("getValueAt index 5", 6, tree.getValueAt(5));
		assertEquals("getValueAt index 6", 8, tree.getValueAt(6));
		
		assertEquals("getValueAt index -1", null, tree.getValueAt(-1));
		assertEquals("getValueAt index -2", null, tree.getValueAt(-2));
		assertEquals("getValueAt index 7", null, tree.getValueAt(7));
		assertEquals("getValueAt index 8", null, tree.getValueAt(8));
	}
	
	public void testGetParent()
	{
		ListBinaryTree tree = new ListBinaryTree();
		
		tree.add(5);
		tree.add(3);
		tree.add(7);
		tree.add(1);
		tree.add(4);
		tree.add(6);
		tree.add(8);
		
		assertEquals("parent of index 1", 0, tree.getParentIndex(1));
		assertEquals("parent of index 2", 0, tree.getParentIndex(2));
		
		assertEquals("parent of index 3", 1, tree.getParentIndex(3));
		assertEquals("parent of index 4", 1, tree.getParentIndex(4));
		
		assertEquals("parent of index 0", -1, tree.getParentIndex(0));
		assertEquals("parent of index 99", -1, tree.getParentIndex(99));
	}
	
	public void testLeftRightChild()
	{
		ListBinaryTree tree = new ListBinaryTree();
		
		tree.add(5);
		tree.add(3);
		tree.add(7);
		tree.add(1);
		tree.add(4);
		tree.add(6);
		tree.add(8);
		
		assertEquals("left child of index 0", 1, tree.getLeftIndex(0));
		assertEquals("right child of index 0", 2, tree.getRightIndex(0));
		
		assertEquals("left child of index 1", 3, tree.getLeftIndex(1));
		assertEquals("right child of index 1", 4, tree.getRightIndex(1));
		
		assertEquals("left child of index 2", 5, tree.getLeftIndex(2));
		assertEquals("right child of index 2", 6, tree.getRightIndex(2));
		
		assertEquals("left child of index 3", -1, tree.getLeftIndex(3));
		assertEquals("right child of index 3", -1, tree.getRightIndex(3));
		
		assertEquals("left child of index -1", -1, tree.getLeftIndex(-1));
		assertEquals("right child of index -1", -1, tree.getRightIndex(-1));
		
		assertEquals("left child of index -2", -1, tree.getLeftIndex(-2));
		assertEquals("right child of index -2", -1, tree.getRightIndex(-2));
	}
	
	public void testSwap()
	{
		ListBinaryTree tree = new ListBinaryTree();
		
		tree.add(5);
		tree.add(3);
		tree.add(7);
		tree.add(1);
		tree.add(4);
		tree.add(6);
		tree.add(8);
		
		tree.swap(2, 0);
		
		assertEquals("preorder is incorrect", "[7, 3, 1, 4, 5, 6, 8]", tree.preorder());
	}
	

	
}