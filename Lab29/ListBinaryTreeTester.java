
public class ListBinaryTreeTester 
{

    public static void main(String[] args) 
    {
    	ListBinaryTree<String> tree = new ListBinaryTree<String>();
    	
    	tree.add("A");
    	tree.add("B");
    	tree.add("C");
    	tree.add("D");
    	tree.add("E");
    	tree.add("F");
    	
    	System.out.println("Pre Order:\t" + tree.preorder());
    	System.out.println("In Order:\t" + tree.inorder());
    	System.out.println("Post Order:\t" + tree.postorder());
    }
    
    
}