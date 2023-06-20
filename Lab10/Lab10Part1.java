public class Lab10Part1
{
    public static void main(String[] args)
    {
        MyArrayList list = new MyArrayList();
        list.add(new Integer(7));
        Object x = list.get(0);
        String s = (String)x;
        System.out.println(s.length());
        // okdums.add("tarun");
        // okdums.add("brandon");
        // okdums.add("alex");
        // okdums.add("rohak");
        // okdums.add("suhas");
        
        // int rn = (int)(Math.random() * okdums.size());
        // String picked = (String) okdums.get(rn);
        // String uc = picked.toUpperCase();
        // System.out.println(uc);
    }
}