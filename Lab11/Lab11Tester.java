import junit.framework.*; 
import java.util.*;

public class Lab11Tester extends TestCase
{

    public void testIsEmpty()
    {
        JavaLinkedList list = new JavaLinkedList();
        assertEquals("new list sums to zero", 0.0, list.getSum());        
    }

    public void testOne()
    {
        JavaLinkedList list = new JavaLinkedList();
        list = new JavaLinkedList(new int[]{4,5,6,7,8,9,10,11,12,13});
        assertEquals("list sums to 85.0", 85.0, list.getSum());
        assertEquals("mean is 8.5", 8.5, list.getMean());
        assertEquals("smallest is 4", 4, list.getSmallest());
        assertEquals("largest is 13", 13, list.getLargest());      
    }

    public void testTwo()
    {
        JavaLinkedList list = new JavaLinkedList();
        list = new JavaLinkedList(new int[]{24,75,86,37,82,94,111,82,43});
        assertEquals("list sums to 634.0", 634.0, list.getSum());
        assertEquals("mean is 70.44444444444444", 70.44444444444444, list.getMean());
        assertEquals("smallest is 24", 24, list.getSmallest());
        assertEquals("largest is 111", 111, list.getLargest());         
    }

    public void testThree()
    {
        JavaLinkedList list = new JavaLinkedList();
        list = new JavaLinkedList(new int[]{0,4,5,2,1,4,6});
        assertEquals("list sums to 22.0", 22.0, list.getSum());
        assertEquals("mean is 3.142857142857143", 3.142857142857143, list.getMean());
        assertEquals("smallest is 0", 0, list.getSmallest());
        assertEquals("largest is 6", 6, list.getLargest());      
    }
    
    public void testFour()
    {
        JavaLinkedList list = new JavaLinkedList();
        list = new JavaLinkedList(new int[]{-2, -3, -4, -6, 2, 4, 3, 6});
        assertEquals("list sums to 0.0", 0.0, list.getSum());
        assertEquals("mean is 0.0", 0.0, list.getMean());
        assertEquals("smallest is -6", -6, list.getSmallest());
        assertEquals("largest is 6", 6, list.getLargest());      
    }
}