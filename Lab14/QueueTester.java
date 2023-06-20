import junit.framework.*; 
import java.util.*;

public class QueueTester extends TestCase
{
	
	public void testAddSizeEmpty()
	{
		Queue<String> s = new MyQueue<String>();
		
		assertEquals("size() should be 0 for a newly created Queue", 0, s.size());
		assertEquals("A newly created Queue should be empty", true, s.isEmpty());
		
		s.add("first");
		
		assertEquals("size() should be 1 after adding the first Object", 1, s.size());
		assertEquals("isEmpty() should be false after adding the first Object", false, s.isEmpty());
		
		s.add("second");
		s.add("third");
		
		assertEquals("size() should be 3 after adding 3 Objects", 3, s.size());
		assertEquals("isEmpty() should be false after adding 3 Objects", false, s.isEmpty());
	}
	
	public void testPeek()
	{
		Queue<String> s = new MyQueue<String>();
		
		s.add("first");
		assertEquals("peek() should return the first Object in the Queue after adding 1 Object", "first", s.peek());
		assertEquals("peek() should not change the size of the Queue", 1, s.size());
		
		s.add("second");
		assertEquals("peek() should return the first Object in the Queue after adding 2 Objects", "first", s.peek());
		assertEquals("peek() should not change the size of the Queue", 2, s.size());
		
		s.add("third");
		assertEquals("peek() should return the first Object in the Queue after adding 3 Objects", "first", s.peek());
		assertEquals("peek() should not change the size of the Queue", 3, s.size());
	}
	
	public void testRemove()
	{
		Queue<String> s = new MyQueue<String>();
		
		s.add("first");		
		s.add("second");		
		s.add("third");
		
		String obj = s.remove();
		assertEquals("remove() should return the first Object in the queue", "first", obj);
		assertEquals("remove() should reduce the size of the queue by 1", 2, s.size());
		assertEquals("peek() should return the new first Object in the queue after calling remove()", "second", s.peek());
		
		obj = s.remove();
		assertEquals("remove() should return the first Object in the queue the second time it is called", "second", obj);
		assertEquals("remove() should reduce the size of the queue by 1 the second time it is called", 1, s.size());
		assertEquals("peek() should return the new first Object in the queue after calling remove() twice", "third", s.peek());
		
		obj = s.remove();
		assertEquals("remove() should return the first Object in the queue the third time it is called", "third", obj);
		assertEquals("remove() should reduce the size of the queue by 1 the third time it is called", 0, s.size());
		assertEquals("peek() should return null when the list is empty after calling remove() repeatedly", null, s.peek());
		
		obj = s.remove();
		assertEquals("remove() should return null if the Queue is empty", null, obj);
		assertEquals("remove() should not change the size of the Queue when it is empty", 0, s.size());
		assertEquals("peek() should return null when the list is empty after calling remove() on an empty Queue", null, s.peek());
	}
	
	public void testRemoveAndAdd()
	{
		Queue<String> s = new MyQueue<String>();
		
		s.add("first");		
		s.add("second");		
		s.add("third");
		
		String obj = s.remove();		
		s.add("fourth");
		
		assertEquals("size() should be 3 after add(), add(), add(), remove(), add()", 3, s.size());
		assertEquals("peek() should return the first Object in the Queue", "second", s.peek());
		
		obj = s.remove();
		assertEquals("remove() should return the first Object in the Queue the second time it is called", "second", obj);
		assertEquals("remove() should reduce the size of the Queue by 1", 2, s.size());
		assertEquals("peek() should return the first Object in the Queue", "third", s.peek());
		
		obj = s.remove();
		assertEquals("remove() should return the first Object in the Queue the third time it is called", "third", obj);
		assertEquals("remove() should reduce the size of the Queue by 1 the third time it is called", 1, s.size());
		assertEquals("peek() should return the first Object in the Queue the third time it is called", "fourth", s.peek());
		
		obj = s.remove();
		assertEquals("remove() should return the first Object in the Queue the fourth time it is called", "fourth", obj);
		assertEquals("remove() should reduce the size of the Queue to 0 when it removes the last Object", 0, s.size());
		assertEquals("peek() should return null when the Queue is empty", null, s.peek());
	}
}