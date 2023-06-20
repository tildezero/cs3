public class MyLinkedList<E> implements GenericList<E> {
    
    private Node<E> head;
    private int size;
    
    public MyLinkedList() {
        head = new Node<E>(null);
        
       
    }
    
    private int indexOf(E obj) {
        Node<E> n = head.getNext();
        int spot = 0;
        while (n != null && !n.getValue().equals(obj)) {
            spot++;
            n = n.getNext(); 
            
        }
        if (n == null) return -1;
        return spot;
    }
    
    public Node<E> getNode(int index) {
        if (index >= size() || index < 0) return null;

        Node<E> n = head.getNext();
        
        int i = 0;

        while (n != null && i < index) {
            i++;
            n = n.getNext();
        }
        return n;
    }
    
    public boolean add(E obj) { 
        
        Node<E> n = head;
        
        while (n.getNext() != null) {
            n = n.getNext();
        }
        
        n.setNext(new Node<E>(obj));
        return true;
        
        
    }
    
    public void add(int index, E obj) {
        
        if (index == 0) { 

            Node<E> n = new Node<E>(obj);
            Node<E> before = head;
            Node<E> after = before.getNext();
            
            before.setNext(n);
            n.setNext(after);
            return; 
        }
        Node<E> n = new Node<E>(obj);
        Node<E> before = getNode(index - 1);
        Node<E> after = before.getNext();
        
        
        before.setNext(n);
        n.setNext(after);
    }
    
    public boolean contains(E obj) {
        return indexOf(obj) != -1;
    }
    
    public E get(int index) {
        if (index >= size() || index < 0) return null;
        Node<E> n = getNode(index);
        
        return n.getValue();
    }
    
    public boolean isEmpty() { return head.getNext() == null; }
    
    public E remove(int index) {
        if (index >= size() || index < 0) return null;
        
        if (index == 0) {
            Node<E> before = head;
            Node<E> after = getNode(index + 1);
            
            Node<E> old = getNode(index);
            before.setNext(after);
            
            return old.getValue();
            
        }
    
        Node<E> before = getNode(index - 1);
        Node<E> after = getNode(index + 1);
        
        Node<E> old = getNode(index);
        
        before.setNext(after);
        
        return old.getValue();
    }
    
    public boolean remove(E obj) { 
    
        int idx = indexOf(obj);
        if (idx == -1) return false;
        return (remove(idx) != null);
        
    }
    
    public E set(int index, E obj) {
        if (index >= size() || index < 0) return null;
        Node<E> x = getNode(index);
        E old = x.getValue();
        x.setValue(obj);
        return old;
    }
    
    public int size() { 

	if (isEmpty()) return 0;
        Node<E> n = head.getNext();
        int count = 0;
        while (n != null) {
            count++;
            n = n.getNext();
        }
        
        return count;
    }
        
    class Node<E> {
        private E value;
        private Node<E> next;
        
        public Node(E v) {
            value = v;
        }
        
        public E getValue() {
            return value;
        }
        
        public E setValue(E data) {
            E old = value;
            value = data;
            return old;
        }
        
        public Node<E> getNext() {
            return next;
        }
        
        public Node<E> setNext(Node<E> node) {
            Node<E> old = next;
            next = node;
            return old;
        }
        
    }
    
    
}