import java.util.ArrayList;
import java.util.List;

public class HashMap<K, V> implements Map<K, V>
{
    private List<Map.Node<K, V>>[] list;

    public HashMap()
    {
        this(10);
    }

    @SuppressWarnings("unchecked")
    public HashMap(int n)
    {
        list = (ArrayList<Map.Node<K, V>>[])new ArrayList[n];

        //populate the array with Lists
        for(int i = 0; i < list.length; i++)
            list[i] = new ArrayList<Map.Node<K, V>>();
    }

    /*
     *  Helper Method: Calculate the index that an object will be stored in an array using its hashCode
     *
     *  Returns the index where key belongs in the instance variable array using the key's hashCode
     *  Becareful about objects that have a negative hashCode! Remember, you can't have a negative index!
     */
    private int getIndex(Object key)
    {
        return Math.abs(key.hashCode() % list.length);
    }

    /*
     *  Return true if this map contains the specified key
     *  Precondition: key != null
     */
    public boolean containsKey(Object key) {
        for (List<Map.Node<K, V>> al: list) {
            for (Map.Node<K, V> m: al) {
                if (m.getKey().equals(key)) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
     *  Return true if this map contins the specified value
     *  Precondition: value != null
     */
    public boolean containsValue(Object value)
    {
        for (List<Map.Node<K, V>> al: list) {
            for (Map.Node<K, V> m: al) {
                if (m.getValue().equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
     *  Return true is this map contains no Nodes
     */
    public boolean isEmpty()
    {
        for (List<Map.Node<K,V>> al: list) {
            if (!al.isEmpty()) return false;
        }
        return true;
    }

    /*
     *  Return the number of Nodes this map contains
     */
    public int size()
    {
        int c = 0;
        for (List<Map.Node<K,V>> al: list) {
            c += al.size();
        }
        return c;
    }

    /*
     *  Return the value of the Node that has the specified key
     *  If there is no Node with the specified key, then return null
     */
    public V get(Object key)
    {
        int idx = getIndex(key);
        for (Map.Node<K, V> m: list[idx]) {
            if (m.getKey().equals(key)) {
                return m.getValue();
            }
        }
        return null;
    }

    /*
     *  Associate the specified value with the specified key
     *  If the map already contains the specified key, the replace 
     *  the value of that key and return the original value.
     *  Otherwise add a new Node to the map and return null.
     *  Precondition: key != null && value != null
     */
    public V put(K key, V value)
    {
        int idx = getIndex(key);
        for (Map.Node<K, V> m: list[idx]) {
            if (m.getKey().equals(key)) {
                V old = m.getValue();
                m.setValue(value);
                return old;
            }
        }
        
        list[idx].add(new Map.Node<K, V>(key, value));
        return null;
        
    }

    /*
     *  Remove the association for the specified key from this map.
     *  Return the value that was associated with the specified key
     *  Or return null if no value was associated with the key.
     *  Precondition: key != null
     */
    public V remove(Object key)
    {
        int idx = getIndex(key);
        for (Map.Node<K, V> m: list[idx]) {
            if (m.getKey().equals(key)) {
                V old = m.getValue();
                list[idx].remove(m);
                return old;
            }
        }
        return null;
    }

    /*
     *  Return a List<V> of the values that are stored in this map
     */
    public List<V> values()
    {
        ArrayList<V> vs = new ArrayList<V>();
        for (List<Map.Node<K, V>> al: list) {
            for (Map.Node<K, V> m: al) {
                vs.add(m.getValue());
            }
        }
        return vs;
    }
    

    /*
     *  Return a Set<E> of the keys that have associations in this map
     */
    public Set<K> keySet()
    {
        Set<K> ks = new ListSet<K>();
        for (List<Map.Node<K, V>> al: list) {
            for (Map.Node<K, V> m: al) {
                ks.add(m.getKey());
            }
        }
        return ks;
    }
}