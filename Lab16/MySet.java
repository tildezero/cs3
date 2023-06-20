import java.util.LinkedList;

public class MySet<E> implements Set<E> {
    LinkedList<E> list = new LinkedList<E>();
    
    public MySet() {
        list = new LinkedList<E>();
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    public int size() {
        return list.size();
    }
    
    public boolean contains(Object obj) {
        return list.contains(obj);
    }
    
    public boolean remove(Object obj) {
        return (list.remove(obj));
    }
    
    public boolean add(E item) {
        if (contains(item)) {
            return false;
        }
        list.add(item);
        return true;
    }
    
}
