public class LinkedListTester {
    
    public static void main(String[] args) {
        MyLinkedList<String> ll = new MyLinkedList<String>();
        ll.add("hi");
        ll.add("ok dum");
        System.out.println(ll.getNode(0));
        System.out.println(ll.size());
        
    }
}
