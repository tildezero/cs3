public interface StringList
{
	/**
	 *	Return the String located at the specified index of the list
	 *	Return null if the index is out of bounds.
	 */
	public String getStr(int index);
	
	/**
	 *	Remove the String located at the specified index and return it
	 *	Return null if the index is out of bounds
	 */
	public String removeStr(int index);
	
	/**
	 *	Set the value at the specified index to the specified str
	 *	Return the String that was replaced.
	 *	Return null if the index is out of bounds.
	 */
	public String setStr(int index, String str);
}