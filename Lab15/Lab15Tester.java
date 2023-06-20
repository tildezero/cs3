import junit.framework.*; 
import java.util.*;

public class Lab15Tester extends TestCase
{
	public void testBracketMatcher()
	{
		String a = BracketMatcher.matchBrackets("( () [] { [] () } )");
		assertEquals("matchBrackets() does not correctly identify balanced brackets", "Balanced", a);
		
		String b = BracketMatcher.matchBrackets("[ [ ]");
		assertEquals("matchBrackets() does not correctly identify not enough closing brackets", "Not enough closing brackets", b);
		
		String bb = BracketMatcher.matchBrackets("[ ] ]");
		assertEquals("matchBrackets() does not correctly identify too many closing brackets", "Too many closing brackets", bb);
		
		String c = BracketMatcher.matchBrackets("[ }");
		assertEquals("matchBrackets() does not correctly identify bracket mismatch", "Bracket mismatch", c);
		
		String d = BracketMatcher.matchBrackets("The (quick) [brown] {{fox()}} jumps [over{}] () the lazy ((dog)).");
		assertEquals("matchBrackets() does not correctly identify balanced brackets with non-bracket characters", "Balanced", d);
		
		String e = BracketMatcher.matchBrackets("( ( { ) }  )");
		assertEquals("matchBrackets() does not correctly identify bracket mismatch when brackets are sandwiched ( { ) }", "Bracket mismatch", e);
		
		String ee = BracketMatcher.matchBrackets("( } { )");
		assertEquals("matchBrackets() does not correctly identify too many closing brackets when brackets are inverted } {", "Bracket mismatch", ee);
		
		String f = BracketMatcher.matchBrackets("(");
		assertEquals("matchBrackets() does not correectly identify not enough closing brackets when only 1 open bracket exists", "Not enough closing brackets", f);
		
		String g = BracketMatcher.matchBrackets("]");
		assertEquals("matchBrackets() does not correctly identify too many closing brackets when only 1 closing bracket exists", "Too many closing brackets", g);
		
		String h = BracketMatcher.matchBrackets("() [] { () {} ] ()");
		assertEquals("matchBrackets() does not correctly identify bracket mismatch when multiple matching brackets exist", "Bracket mismatch", h);
		
		String i = BracketMatcher.matchBrackets("Tom Brady is the GOAT.");
		assertEquals("matchBrackets() does not work correctly when there are no brackets", "Balanced", i);
	}
	
	public void testPalindrome()
	{
		boolean a = Palindrome.isPalindrome("tacocat");
		assertEquals("isPalindrome() does not correctly detect a palindrome", true, a);
		
		boolean b = Palindrome.isPalindrome("Taco cat");
		assertEquals("isPalindrome() does not ignore spaces", true, b);
		
		boolean c = Palindrome.isPalindrome("T,a.c/o% $c?a*t!");
		assertEquals("isPalindrome() does not ignore punctuation", true, c);
		
		boolean d = Palindrome.isPalindrome("Rise to vote, sir");
		assertEquals("isPalindrome() does not work correctly on first example", true, d);
		
		boolean e = Palindrome.isPalindrome("Able was I ere I saw Elba");
		assertEquals("isPalindrome() does not work correctly on second example", true, e);
		
		boolean f = Palindrome.isPalindrome("A man, a plan, a canal - Panama!");
		assertEquals("isPalindrome() does not work correctly on third example", true, f);
		
		boolean g = Palindrome.isPalindrome("A man, a plan, a cat, a ham, a yak, a yam, a hat, a canal, - Panama?");
		assertEquals("isPalindrome() does not work correctly on fourth example", true, g);
		
		boolean h = Palindrome.isPalindrome("A Danish custard? Drat such sin, Ada!");
		assertEquals("isPalindrome() does not work correctly on fifth example", true, h);
		
		boolean i = Palindrome.isPalindrome("One ring to rule them all");
		assertEquals("isPalindrome() does not correctly detect non-palindrom", false, i);
		
		boolean j = Palindrome.isPalindrome("x");
		assertEquals("isPalindrome() does not work correctly on single letter", true, j);
		
		boolean k = Palindrome.isPalindrome("xx");
		assertEquals("isPalindrome() does not work correctly on double letter", true, k);
		
		boolean l = Palindrome.isPalindrome("zx");
		assertEquals("isPalindrome() does not work correctly on two different letters", false, l);
	}
}