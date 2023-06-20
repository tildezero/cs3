import java.util.List;
import java.util.ArrayList;

public class TNode<E> 
{
	//INSTANCE VARIABLES
	private E data;
	private List<TNode<E>> children;
	private TNode<E> parent;
	
	//CONSTRUCTOR
	public TNode(E data)
	{
		//initilize instance variables
		this.data = data;
		children = new ArrayList<TNode<E>>();
		parent = null;	//the root node has a null parent
	}
	
	//METHODS
	/**
	 *	Sets this Node's parent node
	 *	@return the original parent node
	 */
	public TNode<E> setParent(TNode<E> node)
	{
		//get the original parent
		TNode<E> old = parent;
		
		//change parent
		parent = node;
		
		//return original parent
		return old;
	}
	
	/**
	 *	@return this node's parent node
	 */
	public TNode<E> getParent()
	{
		return parent;
	}
	
	/**
	 *	Add child as a child of this node. Sets this node as the parent of child
	 *	@return true if child is successfully added
	 */	
	public boolean addChild(TNode<E> child)
	{
		//do not add a null node as a child
		if(null == child)
			return false;
			
		//do not add child if it is already a child
		if(children.contains(child))
			return false;
			
		//add the child to children list!
		children.add(child);
		
		//set the child's parent
		child.setParent(this);
		
		//success!
		return true;
	}
	
	/**
	 *	@return array that contains all children TNodes
	 */
	public List<TNode<E>> getChildren()
	{
		//make a copy of children list
		//(so that outside code cannot modify the private children instance variable)
		List<TNode<E>> copy = new ArrayList<TNode<E>>();
		copy.addAll(children);

		//return copy of children list		
		return copy;
	}
	
	/**
	 *	@return the data stored in this node
	 */
	public E getData()
	{
		return data;		
	}
	
	/**
	 *	You may find it useful to override the toString method to help with debugging...
	 */
	@Override
	public String toString()
	{
		return super.toString();
	}
	

}
