public class JavaLinkedList
{
    private MyLinkedList<Integer> list;

    /**
     *  Default Constructor
     *  Create a new MyLinkedList of Integers
     */
    public JavaLinkedList()
    {
        list = new MyLinkedList<Integer>();
    }

    /**
     *  Create a new MyLinkedList of Integers from the array
     */
    public JavaLinkedList(int[] nums)
    {
        list = new MyLinkedList<Integer>();
        for (int n: nums) {
            list.add((Integer)n);
        }
    }

    /**
     *  Return the sum of all the items in the list
     */
    public double getSum(  )
    {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            int n = (int)list.get(i);
            sum += n;
            
            
        }

        return sum;
    }

    /**
     *  Return the mean of all the items in the list
     */
    public double getMean(  )
    {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            int n = (int)list.get(i);
            sum += n;
        }
        
        return (double)sum / (double)list.size();
    }
    
    /**
     *  Return the largest item in the list
     */
    public int getLargest()
    {
        int largest=Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            int n = (int)list.get(i);
            if (n > largest) {
                largest = n;
            }
        }
        return largest;
    }

    /**
     *  Return the smallest item in the list
     */
    public int getSmallest()
    {
        int smallest = smallest=Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            int n = (int)list.get(i);
            if (n < smallest) {
                smallest = n;
            }
        }
        
        return smallest;
    }

    /**
     *  Return a string with this format:
     *  
     *  SUM:: 10.0
     *  MEAN:: 4.65
     *  SMALLEST:: -1.23
     *  LARGEST:: 5.0
     */
    public String toString()
    {
        
        String output= "SUM:: " + getSum() + "\nMEAN:: " + getMean() + "\nSMALLEST:: " + getSmallest() + "\nLARGEST:: " + getLargest();
    
        return output;
    }
}