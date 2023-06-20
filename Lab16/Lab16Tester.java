import junit.framework.*; 
import java.util.*;

public class Lab16Tester extends TestCase
{
	public void testEmptySet()
	{
		Set<String> s = new MySet<String>();
		
		assertEquals("isEmpty does not return true for a newly created Set", true, s.isEmpty());
		assertEquals("size does not return 0 for a newly created Set", 0, s.size());
	}
	
	public void testAddAndSize()
	{
		Set<String> s = new MySet<String>();
		boolean x;
		
		x = s.add("a");
		
		assertEquals("isEmpty does not return false for a Set with 1 element added to it", false, s.isEmpty());
		assertEquals("size does not return 1 for a Set with 1 element added to it", 1, s.size());
		assertEquals("add should return true when object is added to Set", true, x);
		
		x = s.add("b");
		x = s.add("c");
		
		assertEquals("isEmpty does not return false for a Set with 3 elements added to it", false, s.isEmpty());
		assertEquals("size does not return 1 for a Set with 3 elements added to it", 3, s.size());
		
		x = s.add("a");
		assertEquals("size should not change when a duplicated value is added (first value)", 3, s.size());
		assertEquals("add should return false when object is not added to set", false, x);
		
		x = s.add("b");
		assertEquals("size should not change when a duplicated value is added (middle value)", 3, s.size());
		assertEquals("add should return false when object is not added to set", false, x);
		
		x = s.add("c");
		assertEquals("size should not change when a duplicated value is added (last value)", 3, s.size());
		assertEquals("add should return false when object is not added to set", false, x);
	}
	
	public void testContains()
	{
		Set<String> s = new MySet<String>();
		
		s.add("a");
		s.add("b");
		s.add("c");
		
		assertEquals("contains does not recognize first value added", true, s.contains(new String("a")));
		assertEquals("contains does not recognize second value added", true, s.contains(new String("b")));
		assertEquals("contains does not recognize third value added", true, s.contains(new String("c")));
		
		assertEquals("contains incorrectly returns true when value does not exist", false, s.contains(new String("x")));
	}
	
	public void testAddDuplicates()
	{
		Set<String> s = new MySet<String>();
		
		s.add("a");
		s.add("b");
		s.add("c");
		
		s.add("a");
		assertEquals("size should not change when a duplicated value is added (first value)", 3, s.size());
		
		s.add("b");
		assertEquals("size should not change when a duplicated value is added (middle value)", 3, s.size());
		
		s.add("c");
		assertEquals("size should not change when a duplicated value is added (last value)", 3, s.size());
	}
	
	public void testRemove()
	{
		Set<String> s = new MySet<String>();
		
		String a = new String("a");
		String b = new String("b");
		String c = new String("c");
		String d = new String("d");
		String e = new String("e");
		
		s.add(a);
		s.add(b);
		s.add(c);
		s.add(d);
		s.add(e);
		
		assertEquals("size does not return 5 for set with 5 elements", 5, s.size());
		
		boolean x;
		
		x = s.remove(new String(a));
		assertEquals("remove() does not return true when first value is removed", true, x);
		assertEquals("incorrect size returned after first remove (first value)", 4, s.size());
		assertEquals("incorrect value removed: a (first remove)", false, s.contains(a));
		assertEquals("incorrect value removed: b (first remove)", true, s.contains(b));
		assertEquals("incorrect value removed: c (first remove)", true, s.contains(c));
		assertEquals("incorrect value removed: d (first remove)", true, s.contains(d));
		assertEquals("incorrect value removed: e (first remove)", true, s.contains(e));
		
		x = s.remove(new String(e));
		assertEquals("remove() does not return true when last value is removed", true, x);
		assertEquals("incorrect size returned after second remove (last value)", 3, s.size());
		assertEquals("incorrect value removed: b (second remove)", true, s.contains(b));
		assertEquals("incorrect value removed: c (second remove)", true, s.contains(c));
		assertEquals("incorrect value removed: d (second remove)", true, s.contains(d));
		assertEquals("incorrect value removed: e (second remove)", false, s.contains(e));
		
		x = s.remove(new String(c));
		assertEquals("remove() does not return true when the middle value is removed",true, x);
		assertEquals("incorrect size returned after third remove (middle value)", 2, s.size());
		assertEquals("incorrect value removed: b (third remove)", true, s.contains(b));
		assertEquals("incorrect value removed: c (third remove)", false, s.contains(c));
		assertEquals("incorrect value removed: d (third remove)", true, s.contains(d));
		
		Double notAStringObject = new Double(3.14);
		x = s.remove(notAStringObject);
		assertEquals("remove should return false when obj is not type E", false, x);
		
		x = s.remove(new String(b));
		x = s.remove(new String(d));
		
		assertEquals("incorrect size returned after removing all values", 0, s.size());
		assertEquals("isEmpty is incorrect after removing all elements from set", true, s.isEmpty());
		assertEquals("incorrect value removed: b (fourth/fifth remove)", false, s.contains(b));
		assertEquals("incorrect value removed: d (fourth/fifth remove)", false, s.contains(d));
	}
	
	public void testRemoveAndAdd()
	{
		Set<String> s = new MySet<String>();
		
		String a = new String("a");
		String b = new String("b");
		String c = new String("c");
		String d = new String("d");
		String e = new String("e");
		
		s.add(a);
		s.add(b);
		s.add(c);
		s.add(d);
		s.add(e);
		
		s.remove(b);
		
		boolean x = s.add(b);
		
		assertEquals("Should be able to add B after removing B from Set", true, x);
		assertEquals("Size is not correct after removing then adding the same value", 5, s.size());
		
		s.remove(a);
		s.remove(b);
		s.remove(c);
		s.remove(d);
		s.remove(e);
		
		x = s.add(d);
		
		assertEquals("Should be able to add D after removing ALL VALUES from Set", true, x);
		assertEquals("Size is not correct after removing ALL VALUES then adding one of the original values back again", 1, s.size());
	}
}