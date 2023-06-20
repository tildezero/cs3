public class HeapTester 
{
    public static void main(String[] args) 
    {
    	Heap<Integer> h = new Heap<Integer>();
    	
    	h.add(10);
    	h.add(8);
    	h.add(6);
    	h.add(4);
    	h.add(2);
    	h.add(0);
    	
    	System.out.println("Pre:\t" + h.preorder());
    	System.out.println("In:\t" + h.inorder());
    	System.out.println("Post:\t" + h.postorder());
    	
    	System.out.println("Testing removeRoot");
    	Integer removed = h.removeRoot();
    	System.out.println("Removed:\t" + removed);
    	System.out.println("Pre:\t" + h.preorder());
    	System.out.println("In:\t" + h.inorder());
    	System.out.println("Post:\t" + h.postorder());
    	
    	System.out.println("Testing heapify");
    	h.shuffle();
    	h.heapify();
    	System.out.println("Pre:\t" + h.preorder());
    	System.out.println("In:\t" + h.inorder());
    	System.out.println("Post:\t" + h.postorder());
    }
    
}