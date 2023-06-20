public interface GenericList<E>
{
	/**
	 *	Add obj to the end of the list.
	 *	This method always returns true
	 */
	public boolean add(E obj);
	
	/**
	 *	Add obj to the specified index of the list.
	 *	If index is too big, then add obj to the end of the list
	 *	If index is too small, then add obj to the start of the list
	 */
	public void add(int index, E obj);
	
	/**
	 *	Return true is this list contains something that is .equals() to obj
	 */
	public boolean contains(E obj);
	
	/**
	 *	Return the Object located at the specified index
	 *	If index is too big or too small, return null
	 */
	public E get(int index);
	
	/**
	 *	Return true if there are no elements in the list
	 */
	public boolean isEmpty();
	
	/**
	 *	Remove the Object at the specified index from the list
	 *	Return the Object that was removed
	 *	If index is too big or to small, do not remove anything from the list and return null
	 *  If the list is empty, return null
	 */
	public E remove(int index);
	
	
	/**
	 *	Remove the first Object that is .equals() to obj
	 *	Return true if an object was removed
	 */
	public boolean remove(E obj);
	
	/**
	 *	Change the value stored at index to obj
	 *	Return the value that was replaced
	 *	If index is too big or too smalll, do not change and values and return null
	 */
	public E set(int index, E obj);
	
	/**
	 *	Return the number of elements that are in the list
	 */
	public int size();
}