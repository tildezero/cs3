import junit.framework.*; 
import java.util.*;

public class Lab14Tester extends TestCase
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
	
	//000
	
	public void testStackPushSizeEmpty()
	{
		Stack<String> s = new MyStack<String>();
		
		assertEquals("Size should be 0 when Stack is first created", 0, s.size());
		assertEquals("Stack should be empty when first created", true, s.isEmpty());
		
		s.push("first");
		
		assertEquals("Size should be 1 after first element is added", 1, s.size());
		assertEquals("Stack should not be empty after first element is added", false, s.isEmpty());
		
		s.push("second");
		s.push("third");
		
		assertEquals("Size should be 3 when three elements are added", 3, s.size());
		assertEquals("Stack should not be empty after 3 elements are added", false, s.isEmpty());
	}
	
	public void testStackPeek()
	{
		Stack<String> s = new MyStack<String>();
		
		assertEquals("peek() should return null is nothing is in Stack", null, s.peek());
		
		s.push("first");
		assertEquals("peek() should return an Object when there is only one Object in Stack", "first", s.peek());
		
		s.push("second");
		assertEquals("peek() should return the top of the Stack when there are two Objects in the Stack", "second", s.peek());
		
		s.push("third");
		assertEquals("peek() should return the top of the Stack when there are three Objects in the Stack", "third", s.peek());
	}
	
	public void testStackPop()
	{
		Stack<String> s = new MyStack<String>();
		
		s.push("first");		
		s.push("second");		
		s.push("third");
		
		String obj = s.pop();
		assertEquals("pop() should return the last Object added to the Stack", "third", obj);
		assertEquals("pop() should reduce the size of the Stack from 3 to 2", 2, s.size());
		assertEquals("peek() should return the next Object in the Stack after pop() removes the top", "second", s.peek());
		
		obj = s.pop();
		assertEquals("pop() should return the new top of the Stack the second time it is called", "second", obj);
		assertEquals("pop() should reduce the size of the Stack from 2 to 1 the second time it is called", 1, s.size());
		assertEquals("peek() should return the next Object in the Stack after pop() is called twice", "first", s.peek());
		
		obj = s.pop();
		assertEquals("pop() should return the new top of the Stack the third time it is called", "first", obj);
		assertEquals("pop() should reduce the size of the Sk from 1 to 0 the third time it is called", 0, s.size());
		assertEquals("peek() should return null when the Stack is empty after repeated calls to pop()", null, s.peek());
		
		obj = s.pop();
		assertEquals("pop() should return null if the Stack is empty", null, obj);
		assertEquals("The size should remain 0 after calling pop() on an empty Stack", 0, s.size());
		assertEquals("peek() should return null is the Stack is empty", null, s.peek());
	}
	
	public void testStackPopAndPush()
	{
		Stack<String> s = new MyStack<String>();
		
		s.push("first");		
		s.push("second");		
		s.push("third");
		
		String obj = s.pop();		
		s.push("fourth");
		
		assertEquals("size() should be 3 after popping and then pushing an Object", 3, s.size());
		assertEquals("peek() should return the last Object that was added to the Stack", "fourth", s.peek());
		
		obj = s.pop();
		assertEquals("pop() should return the last Object that was pushed on the Stack", "fourth", obj);
		assertEquals("size() should be 2 after calling pop() on a Stack with 3 elements", 2, s.size());
		assertEquals("peek() should return the new top of the stack after calling pop(), remove(), pop()", "second", s.peek());
	}
}