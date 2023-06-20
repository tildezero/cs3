import java.util.*;
public class GenericArrayList<E> implements GenericList<E>
{
    private List<E> list;
    private E[] test;
    public GenericArrayList()
    {
        list = new ArrayList<E>();
        //test = new E[0];
        test = (E[]) new Object[0]; 
    }
    
    public boolean add(E obj) {
       E[] newArr = (E[]) new Object[test.length + 1];
       for (int i = 0; i < test.length; i++) {
           newArr[i] = test[i];
       
      }
      newArr[newArr.length-1] = obj;
      test = newArr;
      return true;
   }
   
   public void add(int index, E obj) {
       int indexToAdd = index;
       if (index < 0) indexToAdd = 0;
       if (index > test.length) indexToAdd = test.length;
       E[] newArr = (E[]) new Object[test.length + 1];
       
       for (int i = 0; i < newArr.length; i++) {
           if (i < index) newArr[i] = test[i];
           if (i == index) newArr[i] = obj;
           if (i > index) newArr[i] = test[i-1];
       }
       test = newArr;

   }   
   
   public boolean remove(E obj) {
       boolean c = false;
       for (int i = 0; i < test.length; i++) {
           if (test[i].equals(obj)) {
               c = true;
               break;
           }
       }
       if (!c) return false;
       
       boolean ret = false;
       int index = 0;
       
       for (int i = 0; i < test.length; i++) {
           if (test[i].equals(obj)) { 
               index = i;
               break;
           }
       }
              
       return (remove(index) != null);
   }
   
   public boolean contains(E obj) {
       for (int i = 0; i < test.length; i++) {
           if (test[i].equals(obj)) {
               return true;
           }
       }
       return false;
   }
   
   public E get(int index) {
       if (index < 0 || index >= test.length) return null;
       return test[index];
   }
   
   public boolean isEmpty() {
       return this.size() == 0;
   }
   
   public E remove(int index) {
       if (index < 0 || index >= test.length) return null;
       if (test.length == 0) return null;
       E[] newArr = (E[]) new Object[test.length - 1];
       E old = null;
       for (int i = 0; i < test.length; i++) {
           if (i < index) newArr[i] = test[i];
           else if (i == index) old = test[i];
           else newArr[i - 1] = test[i];
       }
       test = newArr;
       return old;
           
   }
   
   
   
   public E set(int index, E obj) {
       if (index < 0 || index >= test.length) return null;
       E old = test[index];
       
       test[index] = obj;
       return old;
   }
   
   public int size() {
       return test.length;
   }
}