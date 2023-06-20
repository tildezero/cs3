import junit.framework.*; 
import java.util.*;

public class Lab28Tester extends TestCase
{
    public void testAddPreOrder()
    {
        BST tree = new BST();
        
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(1);
        tree.add(4);
        tree.add(6);
        tree.add(8);
        
        assertEquals("[5, 3, 1, 4, 7, 6, 8]", tree.preorder());
        
        tree = new BST();
        
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(5);

        assertEquals("When adding two values that are equal, add the new value to the right", "[5, 3, 7, 5]", tree.preorder());
    }
    
    public void testAddInOrder()
    {
        BST tree = new BST();
        
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
        BST tree = new BST();
        
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
        
        BST tree = new BST();
        tree.addAll(numbers);
        
        assertEquals("[5, 3, 1, 4, 7, 6, 8]", tree.preorder());
        assertEquals("[1, 3, 4, 5, 6, 7, 8]", tree.inorder());
        assertEquals("[1, 4, 3, 6, 8, 7, 5]", tree.postorder());
    }
    
    public void testSize()
    {
        BST tree = new BST();
        
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(1);
        tree.add(4);
        tree.add(6);
        tree.add(8);
        
        assertEquals(7, tree.size());
    }
    
    public void testContains()
    {
        BST tree = new BST();
        
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(1);
        tree.add(4);
        tree.add(6);
        tree.add(8);
        
        assertEquals("checking the root node", true, tree.contains(5));
        assertEquals("checking a leaf node", true, tree.contains(1));
        assertEquals("checking an inner node", true, tree.contains(7));
        assertEquals("checking a small node that hasn't been added", false, tree.contains(2));
        assertEquals("checking a big node that hasn't been added", false, tree.contains(9));
    }
    
    public void testRemoveLeaf()
    {
        //smallest is leaf
        BST tree = new BST();
        
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(1);
        tree.add(4);
        tree.add(6);
        tree.add(8);
        
        boolean removed = tree.remove(1);
        
        assertEquals(true, removed);
        assertEquals("Removing a (small) leaf node", "[5, 3, 4, 7, 6, 8]", tree.preorder());
    }
    
    public void testRemoveOneChild()
    {
        //smallest is leaf
        BST tree = new BST();
                
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(1);
        tree.add(4);
        tree.add(6);
        tree.add(8);
        
        boolean removed = tree.remove(8);
        
        assertEquals(true, removed);
        assertEquals("Removing a (large) leaf node", "[5, 3, 1, 4, 7, 6]", tree.preorder());
    }
    
    public void testRemoveRequiresCombine()
    {
        BST tree = new BST();
        boolean removed = false;
        
        //require combine
        tree = new BST();
        
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(1);
        tree.add(4);
        tree.add(6);
        tree.add(8);
        
        removed = tree.remove(3);
        
        assertEquals(true, removed);
        assertEquals("The node being removed has 2 children. Both are leaf nodes", "[5, 4, 1, 7, 6, 8]", tree.preorder());
    }
    
    
    public void testRemoveNodeWithOneRightChild()
    {
        BST tree = new BST();
        boolean removed = false;
        
        //smallest has right
        tree = new BST();
        
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(1);
        tree.add(4);
        tree.add(6);
        tree.add(8);
        tree.add(9);
        
        removed = tree.remove(8);
        
        assertEquals(true, removed);
        assertEquals("The smallest child of removed node has a right child", "[5, 3, 1, 4, 7, 6, 9]", tree.preorder());
    }

    public void testRemoveNodeThatDoesNotExist1()
    {
        BST tree = new BST();
        boolean removed = false;
        
        //nothing should be removed (small)
        tree = new BST();
        
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(1);
        tree.add(4);
        tree.add(6);
        tree.add(8);
        
        removed = tree.remove(2);
        
        assertEquals(false, removed);
        assertEquals("Removing a (small) value that does not exist in the tree", "[5, 3, 1, 4, 7, 6, 8]", tree.preorder());
        
    }

    public void testRemoveNodeThatDoesNotExist2()
    {
        BST tree = new BST();
        boolean removed = false;
        
        //nothing should be removed (large)
        tree = new BST();
        
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(1);
        tree.add(4);
        tree.add(6);
        tree.add(8);
        
        removed = tree.remove(9);
        
        assertEquals(false, removed);
        assertEquals("Removing a (large) value that does not exist in the tree", "[5, 3, 1, 4, 7, 6, 8]", tree.preorder());
        
        //smallest is root
        tree = new BST();
        
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(1);
        tree.add(4);
        tree.add(6);
        tree.add(8);
        tree.add(9);
        
        removed = tree.remove(5);
        
        assertEquals(true, removed);
        assertEquals("Removing the root node of the tree!", "[6, 3, 1, 4, 7, 8, 9]", tree.preorder());
    }
    
    
    public void testRemoveRoot()
    {
        BST tree = new BST();
        boolean removed = false;
        
        //smallest is root
        tree = new BST();
        
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(1);
        tree.add(4);
        tree.add(6);
        tree.add(8);
        tree.add(9);
        
        removed = tree.remove(5);
        
        assertEquals(true, removed);
        assertEquals("Removing the root node of the tree!", "[6, 3, 1, 4, 7, 8, 9]", tree.preorder());
    }
    
}