import junit.framework.*; 
import java.util.*;

public class Lab10Tester2 extends TestCase
{
	
	public void testAddNonInteger()
	{
		IntegerArrayList list = new IntegerArrayList();
		
		boolean b = list.add("not an Integers");
		
		assertFalse("add should return false if a non Integer is added", b);
		assertEquals("not empty after adding a non-Integer object", 0, list.size());
	}
	
	public void testAddAndSize()
	{
		IntegerArrayList list = new IntegerArrayList();
		
		assertEquals("new list is not empty", 0, list.size());
		
		list.add(new Integer(1));
		assertEquals("size does not increase when object is added", 1, list.size());
		
		list.add(new Integer(2));
		list.add(new Integer(3));
		assertEquals("size does not increase correctly when multiple objects are added", 3, list.size());
	}
	
	public void testGet()
	{
		IntegerArrayList list = new IntegerArrayList();
		
		list.add(new Integer(1));		
		list.add(new Integer(2));
		list.add(new Integer(3));
		
		Integer obj = list.getInt(0);
		assertNotNull("get(first index) returned value is null", obj);
		assertEquals("Incorrect value returned from get(first index)", new Integer(1), obj);
		assertEquals("size should not change when get(first index) is called", 3, list.size());
		
		obj = list.getInt(2);
		assertNotNull("get(last index) returned value is null", obj);
		assertEquals("Incorrect value returned from get(last index)", new Integer(3), obj);
		assertEquals("size should not change when get(last index) is called", 3, list.size());
		
		obj = list.getInt(1);
		assertNotNull("get(middle index) returned value is null", obj);
		assertEquals("Incorrect value returned from get(middle index)", new Integer(2), obj);
		assertEquals("size should not change when get(middle index) is called", 3, list.size());
		
		obj = list.getInt(-1);
		assertNull("get(negative index) returned value is not null", obj);
		assertEquals("size should not change when get(negative index) is called", 3, list.size());
		
		obj = list.getInt(3);
		assertNull("get(too big index) returned value is not null", obj);
		assertEquals("size should not change when get(too big index) is called", 3, list.size());
	}
	
	public void testInsertFirst()
	{
		IntegerArrayList list = new IntegerArrayList();
		
		list.add(new Integer(1));		
		list.add(new Integer(2));
		list.add(new Integer(3));
		
		list.add(0, new Integer(4));
		
		assertEquals("size does not increase when inserting an object", 4, list.size());
		
		Object obj = list.get(0);
		assertNotNull("Value at index 0 is null", obj);
		assertEquals("Incorrect value inserted at index 0", new Integer(4), obj);
	}
	
	public void testRemoveFirst()
	{
		IntegerArrayList list = new IntegerArrayList();		
		list.add(new Integer(1));		
		list.add(new Integer(2));
		list.add(new Integer(3));
		
		Integer obj = list.removeInt(0);
	
		assertNotNull("remove(0) returned null, but should have returned an object", obj);
		assertEquals("The size of list did not change after calling remove()", 2, list.size());
		assertEquals("remove(0) did not return the correct value", new Integer(1), obj);
	}
	
	public void testRemoveLast()
	{
		IntegerArrayList list = new IntegerArrayList();		
		list.add(new Integer(1));		
		list.add(new Integer(2));
		list.add(new Integer(3));
		
		Integer obj = list.removeInt(2);
	
		assertNotNull("remove(last index) returned null, but should have returned an object", obj);
		assertEquals("The size of list did not change after calling remove()", 2, list.size());
		assertEquals("remove(last index) did not return the correct value", new Integer(3), obj);
	}
	
	public void testRemoveMiddle()
	{
		IntegerArrayList list = new IntegerArrayList();		
		list.add(new Integer(1));		
		list.add(new Integer(2));
		list.add(new Integer(3));
		
		Integer obj = list.removeInt(1);
	
		assertNotNull("remove(middle index) returned null, but should have returned an object", obj);
		assertEquals("The size of list did not change after calling remove()", 2, list.size());
		assertEquals("remove(middle index) did not return the correct value", new Integer(2), obj);
	}
	
	public void testRemoveNegative()
	{
		IntegerArrayList list = new IntegerArrayList();		
		list.add(new Integer(1));		
		list.add(new Integer(2));
		list.add(new Integer(3));
		
		Object obj = list.remove(-1);
	
		assertNull("remove(index < 0) did not return null", obj);
		assertEquals("The size of list changed after calling remove(index < 0)", 3, list.size());
	}
	
	public void testRemoveTooBig()
	{
		IntegerArrayList list = new IntegerArrayList();		
		list.add(new Integer(1));		
		list.add(new Integer(2));
		list.add(new Integer(3));
		
		Object obj = list.remove(3);
	
		assertNull("remove(index > size) did not return null", obj);
		assertEquals("The size of list changed after calling remove(index > size)", 3, list.size());
	}
	
	public void testIsEmpty()
	{
		IntegerArrayList list = new IntegerArrayList();		
			
		assertTrue("new list should be empty before adding any elements", list.isEmpty());
		
		list.add(new Integer(1));		
		assertFalse("list should not be empty after adding an object to it", list.isEmpty());
		
		list.add(new Integer(2));
		list.add(new Integer(3));
		assertFalse("list should not be empty after adding an object to it", list.isEmpty());
		
		list.remove(0);
		list.remove(0);
		list.remove(0);
		assertTrue("new list should be empty after removing all elements", list.isEmpty());
	}
	
	public void testContains()
	{
		IntegerArrayList list = new IntegerArrayList();		
			
		list.add(new Integer(1));		
		list.add(new Integer(2));
		list.add(new Integer(3));
		
		assertTrue("Did not detect first element", list.contains(new Integer(1)));
		assertTrue("Did not detect middle element", list.contains(new Integer(2)));
		assertTrue("Did not detect last element", list.contains(new Integer(3)));
		assertFalse("Did not correctly detect element that isn't in list", list.contains("first one"));
		
		list.add(new Integer(3));
		assertTrue("Did not detect duplicated element", list.contains(new Integer(3)));
	}
	
	public void testSet()
	{
		IntegerArrayList list = new IntegerArrayList();		
			
		list.add(new Integer(1));		
		list.add(new Integer(2));
		list.add(new Integer(3));
		
		Integer obj = list.setInt(0, new Integer(4));
		assertEquals("List size changed after call to set(0)", 3, list.size());
		assertEquals("value not changed after call to set(0)", new Integer(4), list.get(0));
		assertEquals("incorrect value returned from set(0) method", new Integer(1), obj);
		
		obj = list.setInt(1, new Integer(5));
		assertEquals("List size changed after call to set(middle index)", 3, list.size());
		assertEquals("value not changed after call to set(middle index)", new Integer(5), list.get(1));
		assertEquals("incorrect value returned from set(middle index) method", new Integer(2), obj);
		
		obj = list.setInt(2, new Integer(6));
		assertEquals("List size changed after call to set(last index)", 3, list.size());
		assertEquals("value not changed after call to set(last index)", new Integer(6), list.get(2));
		assertEquals("incorrect value returned from set(last index) method", new Integer(3), obj);
		
		obj = list.setInt(-1, new Integer(-1));
		assertEquals("List size changed after call to set(negative index)", 3, list.size());
		assertNull("set(negative index) did not return null", obj);
		assertEquals("set(negative index) should not change any values", new Integer(4), list.get(0));
		assertEquals("set(negative index) should not change any values", new Integer(5), list.get(1));
		assertEquals("set(negative index) should not change any values", new Integer(6), list.get(2));
		
		obj = list.setInt(3, new Integer(1000));
		assertEquals("List size changed after call to set(too big index)", 3, list.size());
		assertNull("set(too big index) did not return null", obj);
		assertEquals("set(too big index) should not change any values", new Integer(4), list.get(0));
		assertEquals("set(too big index) should not change any values", new Integer(5), list.get(1));
		assertEquals("set(too big index) should not change any values", new Integer(6), list.get(2));
	}
}