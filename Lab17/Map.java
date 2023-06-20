import java.util.List;
import java.util.ArrayList;

public interface Map<K, V>
{
	/*
	 *	Return true if this map contains the specified key
	 *	Precondition: key != null
	 */
	public boolean containsKey(Object key);
	
	/*
	 *	Return true if this map contins the specified value
	 *	Precondition: value != null
	 */
	public boolean containsValue(Object value);
	
	/*
	 *	Return true is this map contains no Nodes
	 */
	public boolean isEmpty();
	
	/*
	 *	Return the number of Nodes this map contains
	 */
	public int size();
	
	/*
	 *	Return the value of the Node that has the specified key
	 *	If there is no Node with the specified key, then return null
	 */
	public V get(Object key);
	
	/*
	 *	Associate the specified value with the specified key
	 *	If the map already contains the specified key, the replace 
	 *	the value of that key and return the original value.
	 *	Otherwise add a new Node to the map and return null.
	 *	Precondition: key != null && value != null
	 */
	public V put(K key, V value);
	
	/*
	 *	Remove the association for the specified key from this map.
	 *	Return the value that was associated with the specified key
	 *	Or return null if no value was associated with the key.
	 *	Precondition: key != null
	 */
	public V remove(Object key);
	
	/*
	 *	Return a List<V> of the values that are stored in this map
	 */
	public List<V> values();
	
	/*
	 *	Return a Set<E> of the keys that have associations in this map
	 */
	public Set<K> keySet();

	
	/*
	 *	Helper class to associate Keys and Values into a single object
	 *	This methods should *NOT* be reimplemented in your ListMap class
	 *	But you will use the Map.Node class to store the keys and values of your map.
	 */
	class Node<K, V>
	{
		private K key;
		private V value;
		
		/*
		 *	Initialize this Node with the specified key and value
		 */
		protected Node(K key, V value)
		{
			this.key = key;
			this.value = value;
		}
		
		/*
		 *	Return the key stored in this Node
		 */
		public K getKey()
		{
			return key;
		}
		
		/*
		 *	Return the value stored in this Node
		 */
		public V getValue()
		{
			return value;
		}
		
		/*
		 *	Replace the value in this Node with the specified value
		 *	Return the original value that was replaced.
		 */
		public V setValue(V value)
		{
			V old = this.value;
			this.value = value;
			return old;
		}
		
		/*	
		 *	Return true if other has the same key and value as this
		 */
		public boolean equals(Object other)
		{
			//Check if other is null
			if(other == null) return false;
			
			//Check if other is an instance of Map.Entry
			if(!(other instanceof Map.Node)) return false;
			
			//Cast other into a Map.Entry object so that Map.Entry methods can be called on it
			Map.Node o = (Map.Node)other;
			
			boolean keysMatch = false;
			boolean valsMatch = false;
			
			//check if keys match
			if(o.getKey() == null)
				keysMatch = key == null;
			else
				keysMatch = o.getKey().equals(key);
			
			//check if values match
			if(o.getValue() == null)
				valsMatch = value == null;
			else
				valsMatch = o.getValue().equals(value);

			//return true iff key and value of other matches this			
			return keysMatch && valsMatch;
		}
	}
}