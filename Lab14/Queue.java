public interface Queue<E>
{
	/**
	 *	Return the Object at the beginning of this Queue
	 *	If the Queue is empty, return null
	 */
	public E peek();
	
	/**
	 *	Add obj to the end of this Queue
	 */
	public boolean add(E obj);
	
	/**
	 *	Remove the Object from the front of this Queue and return it.
	 *	If the Queue is empty, return null
	 */
	public E remove();
	
	/**
	 *	Return true if this Queue is empty
	 */
	public boolean isEmpty();
	
	/**
	 *	Return the number of Objects in this Queue
	 */
	public int size();
}