public class BracketMatcher
{
    public static void main(String[] args)
    {
        
    }
    
    public static String matchBrackets(String str)
    {
        Stack<String> s = new MyStack<String>();
        
        String left = "{[(";
        String right = "}])";
        
        for (int i = 0; i < str.length(); i++) {
            String letter = str.substring(i, i + 1);
            
            if (left.indexOf(letter) >= 0) {
                s.push(letter);
            }
            
            if (right.indexOf(letter) >= 0) {
                if (s.isEmpty()) {
                    return "Too many closing brackets";
                }
                
                if (!s.pop().equals(left.substring(right.indexOf(letter), right.indexOf(letter) + 1))) {
                    return "Bracket mismatch";
                }
            }
        }
        
        if (!s.isEmpty()) {
            return "Not enough closing brackets";
        }
        
        return "Balanced";
    }
}