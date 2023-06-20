public interface Stack<E>
{
	/**
	 *	Return the Object on the top of the Stack
	 *	If the Stack is empty, return null
	 */
	public E peek();
	
	/**
	 *	Add item to the top of the Stack
	 */
	public void push(E item);
	
	/**
	 *	Remove the Object from the top of the Stack and return it
	 *	If the Stack is empty, return null
	 */
	public E pop();
	
	/**
	 *	Return true is this Stack is empty
	 */
	public  boolean isEmpty();
	
	/**
	 *	Return the number of Objects that are in this Stack
	 */
	public int size();
}