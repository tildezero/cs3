// owo uwu owo uwu ara ara ufu ufu

public class MyArrayList implements MyList {
   private Object[] data;
   public MyArrayList() {
       data = new Object[0];
   }
   
   public boolean add(Object obj) {
       Object[] newArr = new Object[data.length + 1];
       for (int i = 0; i < data.length; i++) {
           newArr[i] = data[i];
       
      }
      newArr[newArr.length-1] = obj;
      data = newArr;
      return true;
   }
   
   public void add(int index, Object obj) {
       int indexToAdd = index;
       if (index < 0) indexToAdd = 0;
       if (index > data.length) indexToAdd = data.length;
       Object[] newArr = new Object[data.length + 1];
       
       for (int i = 0; i < newArr.length; i++) {
           if (i < index) newArr[i] = data[i];
           if (i == index) newArr[i] = obj;
           if (i > index) newArr[i] = data[i-1];
       }
       data = newArr;

   }   
   
   public boolean remove(Object obj) {
       boolean c = false;
       for (int i = 0; i < data.length; i++) {
           if (data[i].equals(obj)) {
               c = true;
               break;
           }
       }
       if (!c) return false;
       
       boolean ret = false;
       int index = 0;
       
       for (int i = 0; i < data.length; i++) {
           if (data[i].equals(obj)) { 
               index = i;
               break;
           }
       }
              
       return (remove(index) != null);
   }
   
   public boolean contains(Object obj) {
       for (int i = 0; i < data.length; i++) {
           if (data[i].equals(obj)) {
               return true;
           }
       }
       return false;
   }
   
   public Object get(int index) {
       if (index < 0 || index >= data.length) return null;
       return data[index];
   }
   
   public boolean isEmpty() {
       return this.size() == 0;
   }
   
   public Object remove(int index) {
       if (index < 0 || index >= data.length) return null;
       if (data.length == 0) return null;
       Object[] newArr = new Object[data.length - 1];
       Object old = null;
       for (int i = 0; i < data.length; i++) {
           if (i < index) newArr[i] = data[i];
           else if (i == index) old = data[i];
           else newArr[i - 1] = data[i];
       }
       data = newArr;
       return old;
           
   }
   
   
   
   public Object set(int index, Object obj) {
       if (index < 0 || index >= data.length) return null;
       Object old = data[index];
       
       data[index] = obj;
       return old;
   }
   
   public int size() {
       return data.length;
   }
}
