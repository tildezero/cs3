public interface IntegerList
{
	/**
	 *	Return the Integer located at the specified index of the list
	 *	Return null if the index is out of bounds.
	 */
	public Integer getInt(int index);
	
	/**
	 *	Remove the Integer located at the specified index and return it
	 *	Return null if the index is out of bounds
	 */
	public Integer removeInt(int index);
	
	/**
	 *	Set the value at the specified index to the specified str
	 *	Return the Integer that was replaced.
	 *	Return null if the index is out of bounds.
	 */
	public Integer setInt(int index, Integer str);
}