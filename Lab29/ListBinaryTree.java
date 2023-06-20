import java.util.List;
import java.util.ArrayList;

public class ListBinaryTree <E>
{
    protected List<E> list;

    public ListBinaryTree() 
    {
        list = new ArrayList<E>();
    }

    //add data to this Complete Binary Tree
    public void add(E data)
    {
        list.add(data);
    }

    //Add all the elements from the provided list to this Complete Binary Tree
    public void addAll(List<E> data)
    {
        for (E e: data) {
            list.add(e);
        }
    }

    //Return the size of this tree
    public int size()
    {
        return list.size();
    }

    public String preorder()
    {
        String re = preorderHelper(0, "");
        re = re.substring(0, re.length()-2);
        return "[" + re + "]";
    }

    private String preorderHelper(int index, String ret)
    {
        ret += getValueAt(index) + ", ";
        if (getLeftIndex(index) > -1) {
            ret = preorderHelper(getLeftIndex(index), ret);
        }
        if (getRightIndex(index) > -1) {
            ret = preorderHelper(getRightIndex(index), ret);
        }

        return ret;
    }

    public String inorder()
    {
        String re = inorderHelper(0, "");
        re = re.substring(0, re.length()-2);
        return "[" + re + "]";
    }

    private String inorderHelper(int index, String ret)
    {
        if (getLeftIndex(index) > -1) {
            ret = inorderHelper(getLeftIndex(index), ret);
        }
        ret += getValueAt(index) + ", ";

        if (getRightIndex(index) > -1) {
            ret = inorderHelper(getRightIndex(index), ret);
        }

        return ret;
    }

    public String postorder()
    {
        String re = postorderHelper(0, "");
        re = re.substring(0, re.length()-2);
        return "[" + re + "]";
    }

    private String postorderHelper(int index, String ret)
    {
        if (getLeftIndex(index) > -1) {
            ret = postorderHelper(getLeftIndex(index), ret);
        }

        if (getRightIndex(index) > -1) {
            ret = postorderHelper(getRightIndex(index), ret);
        }

        ret += getValueAt(index) + ", ";

        return ret;
    }

    //return the value stored at the specified index
    //or null if the index is out of bounds
    public E getValueAt(int index)
    {
        if (index < 0 || index >= list.size()) return null;
        return list.get(index);
    }

    //return the index of the parent of the node located at the specified index
    //if index is out of bounds, return -1
    //if the node at the specified index does not have a parent, return -1
    public int getParentIndex(int index)
    {
        if (index <= 0 || index >= list.size()) return -1;
        int dydx = ( (index-1) / 2 );
        if (dydx < 0 || dydx >= list.size()) return -1;
        return dydx;
    }

    //return the index of the left child of the node at the specified index
    //if there is no left child, return -1
    public int getLeftIndex(int index)
    {
        if (index < 0 || index >= list.size()) return -1;
        int dydx = ( (index*2) + 1 );
        if (dydx < 0 || dydx >= list.size()) return -1;
        return dydx;
    }

    //return the index of the right child of the node at the specified index
    //if there is no right child, return -1
    public int getRightIndex(int index)
    {
        if (index < 0 || index >= list.size()) return -1;
        int dydx = ( (index*2) + 2 );
        if (dydx < 0 || dydx >= list.size()) return -1;
        return dydx;
    }

    //a useful utility function to swap two nodes in the tree
    //swap the values located at indexA and indexB
    public void swap(int indexA, int indexB)
    {
        E temp = list.get(indexB);
        list.set(indexB, list.get(indexA));
        list.set(indexA, temp);
    }

}