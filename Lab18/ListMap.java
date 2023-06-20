import java.util.ArrayList;
import java.util.List;

public class ListMap<K, V> implements Map<K, V> {
    private List<Map.Node<K,V>> list;
    
    public ListMap() {
        list = new ArrayList<Map.Node<K, V>>();
    }
    
    public int size() {
        return list.size();
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    public V put(K key, V value) {
        if (key == null && value == null) return null;
        for (Map.Node<K, V> m: list) {
            if (m.getKey().equals(key)) {
                V old = m.getValue();
                m.setValue(value);
                return old;
            }
        }
        
        list.add(new Map.Node<K, V>(key, value));
        return null;
    }
    
    public V get(Object key) {
        for (Map.Node<K, V> m: list) {
            if (m.getKey().equals(key)) {
                V val = m.getValue();
                return val;
            }
        }
        return null;
    }
    
    public List<V> values() {
        List<V> li = new ArrayList<V>();
        for (Map.Node<K, V> m: list) {
            li.add(m.getValue());
        }
        return li;
    }
    
    public Set<K> keySet() {
        Set<K> li = new ListSet<K>();
        for (Map.Node<K, V> m: list) {
            li.add(m.getKey());
        }
        return li;
    }
    
    public boolean containsKey(Object key) {
        for (Map.Node<K, V> m: list) {
            if (m.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean containsValue(Object value) {
        for (Map.Node<K, V> m: list) {
            if (m.getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }
    
    public V remove(Object key) {
        if (key == null) return null;
        for (Map.Node<K, V> m: list) {
            if (m.getKey().equals(key)) {
                V val = m.getValue();
                list.remove(m);
                return val;
            }
        }
        return null;
    }
}