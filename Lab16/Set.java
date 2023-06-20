public interface Set<E>
{
	/**
	 *	Return true if the Set is empty
	 */
	public boolean isEmpty();
	
	/**
	 *	Return the number of elements in the Set
	 */
	public int size();
	
	/**
	 *	Return true if this Set contains obj
	 */
	public boolean contains(Object obj);
	
	/**
	 *	Remove obj from this set.
	 *	Return true if obj was removed from the set
	 */
	public boolean remove(Object obj);
	
	/**
	 *	If the set does not alreay contain item:
	 *		add item to the Set
	 *		return true
	 *	Otherwise, return false
	 */
	public boolean add(E item);	
}