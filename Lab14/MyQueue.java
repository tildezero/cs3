public class MyQueue<E> implements Queue<E> {
    private MyLinkedList<E> list;
    
    public MyQueue() {
        list = new MyLinkedList<E>();
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    public int size() {
        return list.size();
    }
    
    public E peek() {
        return list.get(0);
    }
    
    public E remove() {
        return list.remove(0);
    }
    
    public boolean add(E item) {
        return list.add(item);
    }
}