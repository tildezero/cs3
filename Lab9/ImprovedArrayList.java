public class ImprovedArrayList implements MyList
{
    private int size;
    private Object[] data;

    public ImprovedArrayList()
    {
        // Let the other constructor do the work!
        this(0);
    }

    public ImprovedArrayList(int x)
    {
        size = 0;
        data = new Object[x];
    }

    private boolean outOfBounds(int idx) {
        return idx < 0 || idx >= size;
    }

    /**
     *  Add obj to the end of the list.
     *  This method always returns true
     */
    public boolean add(Object obj)
    {
        if (size == 0) {
            Object[] newArr = new Object[1];
            newArr[0] = obj;
            data = newArr;
            size++;
            return true;
        }
        if (size == data.length) {
            Object[] newArr = new Object[data.length * 2];
            for (int i = 0; i < size; i++) {
                newArr[i] = data[i];
            }
            data = newArr;
        }

        data[size] = obj;
        size++;
        return true;
    }

    /**
     *  Add obj to the specified index of the list.
     *  If index is too big, then add obj to the end of the list
     *  If index is too small, then add obj to the start of the list
     */
    public void add(int index, Object obj)
    {
        if (index == size) { add(obj); return; }
        if (size == 0) {
            Object[] newArr = new Object[1];
            newArr[0] = obj;
            data = newArr;
            size++;
            return;
        }

        if (size == data.length) {
            Object[] newArr = new Object[data.length * 2];
            for (int i = 0; i < size; i++) {
                newArr[i] = data[i];
            }
            data = newArr;
            for (int i = size; i > index; i--) {
                data[i] = data[i-1];
            }            
        }
        data[index] = obj;
        size++;
        return;

    }

    /**
     *  Return true is this list contains something that is .equals() to obj
     */
    public boolean contains(Object obj)
    {
        for (Object o: data) {
            if (o != null && o.equals(obj)) {
                return true;
            }
        }
        return false;
    }

    /**
     *  Return the Object located at the specified index
     *  If index is too big or too small, return null
     */
    public Object get(int index)
    {
        if (outOfBounds(index)) return null;
        return data[index];
    }

    /**
     *  Return true if there are no elements in the list
     */
    public boolean isEmpty()
    {
        return data.length == 0 || size == 0;
    }

    /**
     *  Remove the Object at the specified index from the list
     *  Return the Object that was removed
     *  If index is too big or to small, do not remove anything from the list and return null
     */
    public Object remove(int index)
    {
        if (outOfBounds(index)) return null;
        Object old = data[index];
        if (index == 0) {
            data[0] = null;
            for (int i = 1; i < data.length; i++) {
                data[i-1] = data[i];
            }
            size--;
            return old;
        }
        for (int i = index; i < data.length; i++) {
            
            data[i-1] = data[i];
        }
        size--;
        return old;
    }

    /**
     *  Remove the first Object that is .equals() to obj
     *  Return true if an object was removed
     */
    public boolean remove(Object obj)
    {
        int idx = -1;
        for (int i = 0; i < size; i++) {
            if (data[i].equals(obj)) {
                idx = i;
                break;
            }
        }
        
        if (idx == -1) { return false; }
        return (remove(idx) != null);
    }

    /**
     *  Change the value stored at index to obj
     *  Return the value that was replaced
     *  If index is too big or too smalll, do not change and values and return null
     */
    public Object set(int index, Object obj)
    {
        if (outOfBounds(index)) return null;
        Object old = null;
        old = data[index];
        data[index] = obj;
        return old;
    }

    /**
     *  Return the number of elements that are in the list
     */
    public int size()
    {
        // HINT:  Do you have a variable that holds the size?
        return size;
    }
}