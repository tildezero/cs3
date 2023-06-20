import java.util.List;
import java.util.ArrayList;

public class ListSet<E> implements Set<E>
{
	List<E> list = new ArrayList<E>();
	
	/**
	 *	Return true if the Set is empty
	 */
	public boolean isEmpty()
	{
		return list.isEmpty();
	}
	
	/**
	 *	Return the number of elements in the Set
	 */
	public int size()
	{
		return list.size();
	}
	
	
	/**
	 *	Return true if this Set contains obj
	 */
	public boolean contains(Object obj)
	{
		for(E e : list)
			if(e.equals(obj))
				return true;
		return false;
	}
	
	/**
	 *	Remove obj from this set.
	 *	Return true if obj was removed from the set
	 */
	public boolean remove(Object obj)
	{
		if(!contains(obj))
			return false;
		list.remove(obj);
		return true;
	}
	
	/**
	 *	If the set does not alreay contain item:
	 *		add item to the Set
	 *		return true
	 *	Otherwise, return false
	 */
	public boolean add(E item)
	{
		if(contains(item))
			return false;
		list.add(item);
		return true;
	}
}