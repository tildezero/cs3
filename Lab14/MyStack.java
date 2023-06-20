public class MyStack<E> implements Stack<E> {
    private MyLinkedList<E> list;
    
    public MyStack() {
        list = new MyLinkedList<E>();
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    public E peek() {
        if (isEmpty()) return null;
        return list.get(list.size() - 1);
    }
    
    public E pop() {
        if (isEmpty()) return null;
        return list.remove(list.size() - 1);
    }
    
    public void push(E item) {
        list.add(item);
    }
    
    public int size() {
        return list.size();
    }
    
}