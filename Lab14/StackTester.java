import junit.framework.*; 
import java.util.*;

public class StackTester extends TestCase
{
	
	public void testPushSizeEmpty()
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
	
	public void testPeek()
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
	
	public void testPop()
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
	
	public void testPopAndPush()
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