public class Palindrome
{
    public static void main(String[] args)
    {
    }
    
    public static boolean isPalindrome(String str)
    {
        // last in first out
        Stack<String> s = new MyStack<String>();
        // first in first out
        Queue<String> q = new MyQueue<String>();
        
        String legal = "abcdefghijklmnopqrstuvwxyz";
        
        for (int i = 0; i < str.length(); i++) {
            String letter = str.substring(i, i + 1);
            String lowerCaseLetter = letter.toLowerCase();
            if (legal.indexOf(lowerCaseLetter) > -1) {
                s.push(lowerCaseLetter);
                q.add(lowerCaseLetter);
            }
        }
        
                
        
        while (q.size() > 0 && s.size() > 0) {
            String qs = q.remove();
            String ss = s.pop();
            if (qs.equals(ss)) {
                continue;
            } else {
                return false;
            }
        }
        
        return true;
    }
}