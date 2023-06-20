import java.util.ArrayList;
import java.util.List;

public class TNode<E>
{
  private E data;
  private List<TNode<E>> children;
  private TNode<E> parent;
  
  public TNode(E data)
  {
    this.data = data;
    this.children = new ArrayList<TNode<E>>();
    this.parent = null;
  }
  
  public TNode<E> setParent(TNode<E> node)
  {
    TNode<E> old = this.parent;
    
    this.parent = node;
    
    return old;
  }
  
  public TNode<E> getParent()
  {
    return this.parent;
  }
  
  public boolean addChild(TNode<E> child)
  {
    if (null == child) {
      return false;
    }
    if (this.children.contains(child)) {
      return false;
    }
    this.children.add(child);
    
    child.setParent(this);
    
    return true;
  }
  
  public List<TNode<E>> getChildren()
  {
    List<TNode<E>> copy = new ArrayList<TNode<E>>();
    copy.addAll(this.children);
    
    return copy;
  }
  
  public List<E> getChildrenData()
  {
    List<E> ret = new ArrayList<E>();
    for (TNode<E> child : this.children) {
      ret.add(child.getData());
    }
    return ret;
  }
  
  public E getData()
  {
    return (E)this.data;
  }
  
  public String toString()
  {
    String ret = "";
    if (this.data == null)
    {
      ret = "null";
    }
    else
    {
      ret = this.data.toString();
      for (TNode<E> child : this.children) {
        ret = ret + "\n" + child.toIndentedString(1);
      }
    }
    return ret;
  }
  
  public String toIndentedString(int indentation)
  {
    String ret = "";
    for (int i = 0; i < indentation; i++) {
      ret = ret + "-";
    }
    ret = ret + "> " + this.data.toString();
    
    return ret;
  }
}
