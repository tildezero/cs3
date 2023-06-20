public class BSTTester 
{

    public static void main(String[] args) 
    {
        BST<String> tree = new BST<String>();
        tree.add("C");
        tree.add("A");
        tree.add("B");
        tree.add("D");
        tree.add("F");
        tree.add("G");
        
        System.out.println("Pre Order:\t" + tree.preorder());
        System.out.println("In Order:\t" + tree.inorder());
        System.out.println("Post Order:\t" + tree.postorder());
        
        tree.remove("A");
        tree.remove("D");
        System.out.println(tree.inorder());
    }
    
    
}