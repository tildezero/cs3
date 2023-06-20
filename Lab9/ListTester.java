/**
 *	Use the main method of this class to test your MyArrayList methods
 *	as you write them.
 *
 *	You should implement the add(Object) and size() methods first. Below is a quick test
 *	to make sure that add(Object) and size() work properly.
 *
 *	As you implement more methods, write some code in this main method to make sure
 *	it works correctly. Be sure to test edge cases like 
 *		- "what if the list is empty"
 *		- "what if the list is not empty"
 *		- "does it work on the first element" 
 *		- "does it work on the last element"
 *		- "does it work on an element in the middle"
 */
public class ListTester
{
	public static void main(String[] args)
	{
		//Create a MyArrayList to test
		MyList list = new ImprovedArrayList();
		
		//Test that a new list starts at size 0
		System.out.println("size() returns "+ list.size() + ", should be 0");
		
		//Add an object to the list
		list.add("first");
		
		//Test that the size() method works after a single object has been added
		System.out.println("size() returns "+ list.size() + ", should be 1");
		
		//Add a few more objects
		list.add("second");
		list.add("third");
		
		//Test that that size() method works correctly after more than 1 object have been added
		System.out.println("size() returns "+ list.size() + ", should be 3");
	}
}