import java.util.List;

public class BST<E extends Comparable>
{
    private BNode<E> root;

    public BST() 
    {
        root = null;
    }

    //add data to this BST
    public void add(E data)
    {
        if (root == null) {
            root = new BNode<E>(data);
            return;
        }
        addHelper(root, new BNode(data));
    }

    //Recursive helper method for add
    private void addHelper(BNode<E> node, BNode<E> addMe)
    {
        if (addMe.getData().compareTo(node.getData()) < 0) {
            if (!node.hasLeftChild()) {
                node.setLeft(addMe);
            } else {
                addHelper(node.getLeft(), addMe);
            }
        } else {
            if (!node.hasRightChild()) {
                node.setRight(addMe);
            } else {
                addHelper(node.getRight(), addMe);
            }
        }
    }

    public void addAll(List<E> data)
    {
        for (E e: data) {
            add(e);
        }
    }

    //reutrn the size of this tree (how many nodes are in it?)
    public int size()
    {
        return sizeHelper(root);
    }

    //recursive helper method for size
    public int sizeHelper(BNode<E> node)
    {
        int size = 1;
        while (node.getLeft() != null) {
            size += sizeHelper(node.getLeft());
        }
        while (node.getRight() != null) {
            size += sizeHelper(node.getRight());
        }
        return size;
    }

    //Return a string with the data of this BST in pre order
    public String preorder()
    {
        String re = preorderHelper(root, "");
        re = re.substring(0, re.length()-2);

        return "[" + re + "]";
    }

    //Recursive helper method for preorder
    private String preorderHelper(BNode<E> node, String ret)
    {
        ret += node.getData() + ", ";
        if (node.hasLeftChild()) {
            ret = preorderHelper(node.getLeft(), ret);
        }
        if (node.hasRightChild()) {
            ret = preorderHelper(node.getRight(), ret);
        }

        return ret;
    }

    //Return a string with the data of this BST in order
    public String inorder()
    {
        String re = inorderHelper(root, "");
        String re2 = re.substring(0, re.length()-2);

        return "[" + re2 + "]"; 
    }

    //Recursive helper method for inorder
    private String inorderHelper(BNode<E> node, String ret)
    {

        if (node.hasLeftChild()) {
            ret = inorderHelper(node.getLeft(), ret);
        }
        ret += node.getData() + ", ";
        if (node.hasRightChild()) {
            ret = inorderHelper(node.getRight(), ret);
        }

        return ret;
    }

    //Return a string with the data of this BST in post order
    public String postorder()
    {
        String re = postorderHelper(root, "");
        re = re.substring(0, re.length()-2);

        return "[" + re + "]"; 
    }

    //Recursive helper method for postorder
    private String postorderHelper(BNode<E> node, String ret)
    {
        if (node.hasLeftChild()) {
            ret = ( postorderHelper(node.getLeft(), ret));
        }

        if (node.hasRightChild()) {
            ret = ( postorderHelper(node.getRight(), ret));
        }

        ret += node.getData() + ", ";

        return ret;
    }

    //Check if this BST contains the specified data
    public boolean contains(E data)
    {
        return containsHelper(root, data);
    }

    //Recursive helper method for contains
    private boolean containsHelper(BNode<E> node, E data)
    {
        if (node.getData().equals(data)) return true;
        if (node.hasLeftChild() && containsHelper(node.getLeft(), data)) return true;
        if (node.hasRightChild() && containsHelper(node.getRight(), data)) return true;

        return false;
    }
    
    

    //Remove the first occurance of data from this BST tree.
    //If data is successfully removed return true, otherwise return false.    
    public boolean remove(E data)
    {
        if (!contains(data)) return false;
        BNode<E> node = root;
        BNode<E> parent = null;
        boolean isLeft = false;
        while (node != null && !node.getData().equals(data)) {
            parent = node;
            if (data.compareTo(node.getData()) < 0) {
                isLeft = true;
                node = node.getLeft();
            } else {
                isLeft = false;
                node = node.getRight();
            }
        }

        // 0 child

        if (!node.hasLeftChild() && !node.hasRightChild()) {
            if (isLeft) parent.setLeft(null);
            else parent.setRight(null);
        }

        // 1 child
        if (isLeft) {
            parent.setRight(node.getLeft());
        } else {
            parent.setRight(node.getRight());
        }

        // 2 children ?????
        BNode<E> n = combine(node.getLeft(), node.getRight());
        if (isLeft) {
            parent.setLeft(n);
        } else {
            parent.setRight(n);
        }
        
        return true;
    }

    //Recursive helper method for remove. Removes the smallest descendant from the specified node.
    public BNode<E> removeSmallestChild(BNode<E> node)
    {
        if (node == null) return null;
        if (!node.hasChildren() || node.onlyRight()) {
            return node;
        }
        if (node.hasLeftChild()) {
            BNode<E> ret = removeSmallestChild(node.getLeft());
            if (ret == node.getLeft()) {
                node.setLeft(ret.getRight());
            }
            return ret;
        
        }
        return null;
    }

    //Helper method for remove. Reforms the left and right subtrees into a single
    //BST and returns its root node.
    public BNode<E> combine(BNode<E> left, BNode<E> right)
    {
        BNode<E> X = removeSmallestChild(right);
        if (X == right) {
            right = X.getRight();
        }
        X.setLeft(left);
        X.setRight(right);
        return X;
    }

    ///////////////////
    //  Helper Class //
    ///////////////////
    class BNode<E extends Comparable>
    {
        private E data;
        private BNode<E> left, right;

        public BNode(E data)
        {this.data = data;}

        public E getData()
        {return data;}

        public BNode<E> getLeft()
        {return left;}

        public BNode<E> getRight()
        {return right;}

        public void setLeft(BNode<E> left)
        {this.left = left;}

        public void setRight(BNode<E> right)
        {this.right = right;}

        public boolean hasLeftChild()
        {return null != left;}

        public boolean hasRightChild()
        {return null != right;}

        public boolean hasChildren()
        {return getNumChildren() > 0;}
        
        public boolean onlyRight() {
            return (null != right && null == left);
        }

        public int getNumChildren()
        {
            int ret = 0;
            if(hasLeftChild())  ret++;
            if(hasRightChild()) ret++;
            return ret;
        }
    }
}