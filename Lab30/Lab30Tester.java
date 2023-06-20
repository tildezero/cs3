import junit.framework.*; 
import java.util.*;

public class Lab30Tester extends TestCase
{
	public void testAdd()
	{
		Heap<Integer> h = new Heap<Integer>();

		h.add(1);
		h.add(2);
		h.add(3);
		h.add(4);
		h.add(5);
		h.add(6);
		h.add(7);
		h.add(8);
		h.add(9);
		
		assertEquals("[1, 2, 4, 8, 9, 5, 3, 6, 7]", h.preorder());
		assertEquals("[8, 9, 4, 5, 2, 6, 7, 3, 1]", h.postorder());
	}
	
	public void testRemoveRoot()
	{
		Heap<Integer> h = new Heap<Integer>();

		h.add(1);
		h.add(2);
		h.add(3);
		h.add(4);
		h.add(5);
		h.add(6);
		h.add(7);
		h.add(8);
		h.add(9);
		
		h.removeRoot();
		
		assertEquals("[2, 4, 8, 9, 5, 3, 6, 7]", h.preorder());
		assertEquals("[9, 8, 5, 4, 6, 7, 3, 2]", h.postorder());
	}
	
	public void testHeapify()
	{
		Heap<Integer> h = new Heap<Integer>();
		
		h.add(1);
		h.add(2);
		h.add(3);
		h.add(4);
		h.add(5);
		h.add(6);
		h.add(7);
		h.add(8);
		h.add(9);

		h.swap(0, 3);
    	h.swap(1, 7);
    	h.swap(2, 8);
    	h.swap(3, 4);
    	h.swap(4, 7);
    	h.swap(5, 6);
    	h.swap(6, 8);
    	h.swap(7, 8);
		
    	h.heapify();
		
		assertEquals("[1, 2, 5, 6, 8, 4, 3, 7, 9]", h.preorder());
		assertEquals("[6, 8, 5, 4, 2, 7, 9, 3, 1]", h.postorder());
	}
	
}