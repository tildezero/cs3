import junit.framework.*; 
import java.util.*;

public class Lab18Tester extends TestCase
{
	String text1 = "One ring to rule them all, one ring to find them, one ring to bring them all and in the darkness bind them.";
	
	public void testOneRing()
	{
		WordCount wc = new WordCount(text1);

		assertEquals("incorrect count for word that appears multiple times", 3, wc.getWordCount("ring"));			
		assertEquals("incorrect count for word that appears once", 1, wc.getWordCount("bind"));			
		assertEquals("incorrect count for word that appears multiple times including first word", 3, wc.getWordCount("one"));
		assertEquals("incorrect count for word that appears multiple times including last word", 4, wc.getWordCount("them"));
		assertEquals("empty string should not be counted", 0, wc.getWordCount(""));
		assertEquals("spaces should not be counted", 0, wc.getWordCount(" "));
		assertEquals("a word that doesn't exist should return 0", 0, wc.getWordCount("bilbo"));
		assertEquals("", 13, wc.countDistinctWords());
		
		Set<String> dwords = wc.getDistinctWords();
		
		assertNotNull("getDistrinctWords should never return null", dwords);
		assertEquals("Incorrect number of elements in getDistinctWords set", 13, dwords.size());
		assertEquals("getDistinctWords() set missing word", true, dwords.contains("one"));
		assertEquals("getDistinctWords() set missing word", true, dwords.contains("ring"));
		assertEquals("getDistinctWords() set missing word", true, dwords.contains("to"));
		assertEquals("getDistinctWords() set missing word", true, dwords.contains("rule"));
		assertEquals("getDistinctWords() set missing word", true, dwords.contains("them"));
		assertEquals("getDistinctWords() set missing word", true, dwords.contains("all"));
		assertEquals("getDistinctWords() set missing word", true, dwords.contains("find"));
		assertEquals("getDistinctWords() set missing word", true, dwords.contains("bring"));
		assertEquals("getDistinctWords() set missing word", true, dwords.contains("and"));
		assertEquals("getDistinctWords() set missing word", true, dwords.contains("in"));
		assertEquals("getDistinctWords() set missing word", true, dwords.contains("the"));
		assertEquals("getDistinctWords() set missing word", true, dwords.contains("darkness"));
		assertEquals("getDistinctWords() set missing word", true, dwords.contains("bind"));
	}
	
	public void testEmpty()
	{
		WordCount wc = new WordCount("");

		assertEquals("incorrect count when document was empty", 0, wc.getWordCount("ring"));			
		assertEquals("empty string should not be counted", 0, wc.getWordCount(""));
		assertEquals("spaces should not be counted", 0, wc.getWordCount(" "));
		assertEquals("", 0, wc.countDistinctWords());
		
		Set<String> dwords = wc.getDistinctWords();
		
		assertNotNull("getDistrinctWords should never return null", dwords);
		assertEquals("Incorrect number of elements in getDistinctWords set", 0, dwords.size());
	}

}