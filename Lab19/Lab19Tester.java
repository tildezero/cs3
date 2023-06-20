import junit.framework.*; 
import java.util.*;

public class Lab19Tester extends TestCase
{
	public void testSecondConstructor()
	{
		Map<String, String> map = new HashMap<String, String>(100);
	}
	
	public void testPutSizeEmpty()
	{
		Map<String, String> map = new HashMap<String, String>();
		
		assertEquals("isEmpty should return true when Map is first initilized", true, map.isEmpty());
		assertEquals("size should return 0 when Map is first initialized", 0, map.size());
		
		String key1 = randomString();
		String key2 = randomString();
		String key3 = randomString();
		
		String val1 = randomString();
		String val2 = randomString();
		String val3 = randomString();
		
		String replaced = map.put(key1, val1);
		
		assertEquals("isEmpty should return false after first association is added to it", false, map.isEmpty());
		assertEquals("size should return 1 after first association is added to it", 1, map.size());
		assertEquals("put should return null when adding a non-duplicated key", null, replaced);
		
		replaced = map.put(key2, val2);
		map.put(key3, val3);
		
		assertEquals("isEmpty should return false after several associations have been added", false, map.isEmpty());
		assertEquals("size should return 3 after 3 associations have been added to it", 3, map.size());
		assertEquals("put should return null when adding a non-duplicated key (for all non-duplicated keys)", null, replaced);
	}
	
	
	public void testGet()
	{
		Map<String, String> map = new HashMap<String, String>();
		
		String key1 = randomString();
		String key2 = randomString();
		String key3 = randomString();
		
		String val1 = randomString();
		String val2 = randomString();
		String val3 = randomString();
		
		String z = map.get(key1);
		
		assertEquals("get should always return null if the map is empty", null, z);
		
		map.put(key1, val1);
		map.put(key2, val2);
		map.put(key3, val3);
		
		String a = map.get(key1);
		String b = map.get(key2);
		String c = map.get(key3);
		String x = map.get(val2);
		String y = map.get(new Integer(7));
		
		assertEquals("get should return the value associated with the speficied key", val1, a);
		assertEquals("get should return the value associated with the speficied key (2)", val2, b);
		assertEquals("get should return the value associated with the speficied key (3)", val3, c);
		assertEquals("get should not match values, only keys", null, x);
		assertEquals("get should not match keys of the wrong type", null, y);
	}
	
	public void testPutDuplicateKeys()
	{
		Map<String, String> map = new HashMap<String, String>();
		
		String key1 = randomString();
		String key2 = randomString();
		String key3 = randomString();
		
		String val1 = randomString();
		String val2 = randomString();
		String val3 = randomString();
		String val4 = randomString();
		
		map.put(key1, val1);
		map.put(key2, val2);
		map.put(key3, val3);
		
		//duplicate key2
		String replaced = map.put(key2, val4);
		
		assertEquals("size should not change when a duplicate key is added to the map", 3, map.size());
		
		String val = map.get(key2);
		
		assertEquals("put should return the value that was replaced when replacing a duplicate key", val2, replaced);
		assertEquals("Value should be replaced when a duplicate key is added", val4, val);
	}
	
	public void testContainsKey()
	{
		Map<String, String> map = new HashMap<String, String>();
		
		String key1 = randomString();
		String key2 = randomString();
		String key3 = randomString();
		String key4 = randomString();
		
		String val1 = randomString();
		String val2 = randomString();
		String val3 = randomString();
		
		boolean check = map.containsKey(key1);
		
		assertEquals("containsKey should always return false when map is empty", false, check);
		
		map.put(key1, val1);
		map.put(key2, val2);
		map.put(key3, val3);
		
		check = map.containsKey(key1);
		assertEquals("containsKey does not return true for first key added", true, check);
		
		check = map.containsKey(key2);
		assertEquals("containsKey does not return true for middle key added", true, check);
		
		check = map.containsKey(key3);
		assertEquals("containsKey does not return true for last key added", true, check);
		
		check = map.containsKey(key4);
		assertEquals("containsKey does not return false for key that does not exist", false, check);
		
		check = map.containsKey(val2);
		assertEquals("containsKey should not match values, only keys", false, check);
	}
	
	public void testContainsValue()
	{
		Map<String, String> map = new HashMap<String, String>();
		
		String key1 = randomString();
		String key2 = randomString();
		String key3 = randomString();
		
		String val1 = randomString();
		String val2 = randomString();
		String val3 = randomString();
		String val4 = randomString();
		
		boolean check = map.containsValue(key1);
		
		assertEquals("containsValue should always return false when map is empty", false, check);
		
		map.put(key1, val1);
		map.put(key2, val2);
		map.put(key3, val3);
		
		check = map.containsValue(val1);
		assertEquals("containsValue does not return true for first value added", true, check);
		
		check = map.containsValue(val2);
		assertEquals("containsValue does not return true for middle value added", true, check);
		
		check = map.containsValue(val3);
		assertEquals("containsValue does not return true for last value added", true, check);
		
		check = map.containsValue(val4);
		assertEquals("containsValue does not return false for value that does not exist", false, check);
		
		check = map.containsValue(key2);
		assertEquals("containsValue should not match keys, only values", false, check);
	}
	
	public void testValues()
	{
		Map<String, String> map = new HashMap<String, String>();
		
		List<String> values = map.values();
		assertNotNull("values() should never return null. If map is empty, it should return an empty List<V>", values);
		assertEquals("values() should return an empty list when map is empty", 0, values.size());
		
		String key1 = randomString();
		String key2 = randomString();
		String key3 = randomString();
		String key4 = randomString();
		
		String val1 = randomString();
		String val2 = randomString();
		String val3 = randomString();
		
		map.put(key1, val1);
		map.put(key2, val2);
		map.put(key3, val3);
		
		values = map.values();
		
		assertEquals("values() should return a list with the same size as the map", 3, values.size());
		
		assertEquals("missing first value added to map", true, values.contains(val1));
		assertEquals("missing middle value added to map", true, values.contains(val2));
		assertEquals("missing last value added to map", true, values.contains(val3));
		
		map.put(key4, val2);
		values = map.values();
		
		assertEquals("values() should return a list with the same size as the map even if there are duplicate values!", 4, values.size());
		
		int count = 0;
		for(String val : values)
			if(val2.equals(val))
				count++;
		
		assertEquals("if there are duplicate values in a map, values() should return a List<V> with duplicate values!", 2, count);
	}
	
	public void testKeySet()
	{
		Map<String, String> map = new HashMap<String, String>();
		
		Set<String> keys = map.keySet();
		assertNotNull("keySet() should never return null. If map is empty, it should return an empty SetK>", keys);
		assertEquals("keySet() should return an empty Set<K> when map is empty", 0, keys.size());
		
		String key1 = randomString();
		String key2 = randomString();
		String key3 = randomString();
		
		String val1 = randomString();
		String val2 = randomString();
		String val3 = randomString();
		String val4 = randomString();
		
		map.put(key1, val1);
		map.put(key2, val2);
		map.put(key2, val4);
		map.put(key3, val3);
		
		keys = map.keySet();
		
		assertEquals("keySet() should return a Set<K> with the same size as the map.", 3, keys.size());
		
		assertEquals("missing first key added to map", true, keys.contains(key1));
		assertEquals("missing middle key added to map", true, keys.contains(key2));
		assertEquals("missing last key added to map", true, keys.contains(key3));
	}
	
	public void testRemove()
	{
		Map<String, String> map = new HashMap<String, String>();

		String key1 = randomString();
		String key2 = randomString();
		String key3 = randomString();
		String key4 = randomString();
		String key5 = randomString();
		String key6 = randomString();
		
		String val1 = randomString();
		String val2 = randomString();
		String val3 = randomString();
		String val4 = randomString();
		String val5 = randomString();
		String val6 = randomString();
		
		map.put(key1, val1);
		map.put(key2, val2);
		map.put(key3, val3);
		map.put(key4, val4);
		map.put(key5, val5);
		
		String removed = map.remove(key6);
		assertEquals("remove() should return null if specified key does not have an association", null, removed);
		assertEquals("remove() should not change size of map if speficifed key does not have an association", 5, map.size());
		
		removed = map.remove(val2);
		assertEquals("remove() should only look at the key when removing, do not look at the values!", null, removed);
		assertEquals("remove() should not change the size of map if attempting to remove a value instead of a key", 5, map.size());
		
		removed = map.remove(key1);
		assertEquals("remove() shoud return the value associated to the specified key (first key added)", val1, removed);
		assertEquals("remove() should change the size of the map (first key added)", 4, map.size());
		
		removed = map.remove(key5);
		assertEquals("remove() shoud return the value associated to the specified key (last key added)", val5, removed);
		assertEquals("remove() should change the size of the map (last key added)", 3, map.size());
		
		removed = map.remove(key3);
		assertEquals("remove() shoud return the value associated to the specified key (middle key added)", val3, removed);
		assertEquals("remove() should change the size of the map (middle key added)", 2, map.size());
		
		removed = map.remove(key3);
		assertEquals("remove() shoud return null if the key has previously been removed", null, removed);
		assertEquals("remove() should not change the size of the map if the key has previously been removed", 2, map.size());
		
		List<String> values = map.values();
		assertEquals("values() should not return values that have been removed from the map", 2, values.size());
		assertEquals("values() should contain all values that were not removed from the map (1)", true, values.contains(val2));
		assertEquals("values() should contain all values that were not removed from the map (2)", true, values.contains(val4));
		
		Set<String> keys = map.keySet();
		assertEquals("keySet() should not return keys that have been removed from the map", 2, keys.size());
		assertEquals("keySet() should contain all keys that were not removed from the map (1)", true, keys.contains(key2));
		assertEquals("keySet() should contain all keys that were not removed from the map (2)", true, keys.contains(key4));
		
		String replaced = map.put(key3, val3);
		
		assertEquals("You should be able to add a key that has been previously removed", 3, map.size());
		assertEquals("Adding a key that was previously removed is like adding a key for the first time. It should not *replace* any values", null, replaced);
		
		map.remove(key3);
		map.remove(key2);
		map.remove(key4);
		
		assertEquals("isEmpty should be true if all keys have been removed", true, map.isEmpty());
		assertEquals("size should be 0 if all keys have been removed", 0, map.size());
	}
	
	//helper method that generates random strings to use as keys and values
	private String randomString()
	{
		int size = 256;
		String letters = " qwertyuioplkjhgfdsazxcvbnm,./;'[]1234567890-=+_)(*&^%$#@!|}{\":?><\\QWERTYUIOPLKJHGFDSAZXCVBNM";
		
		String ret = "";
		
		for(int i=0; i<size; i++)
		{
			int r = (int)(Math.random() * letters.length());
			String letter = letters.substring(r, r+1);
			ret += letter;
		}
		
		return ret;
	}
}