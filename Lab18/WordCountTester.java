public class WordCountTester
{
	public static void main(String[] args)
	{
		//Write code to test your WordCount class here
		WordCount counter = new WordCount("gettysburg.txt");

		int countAnd = counter.getWordCount("AND");
		System.out.println("getWordCount(\"AND\") should return 6,  actually returned: " + countAnd);
		
		int numDistinctWords = counter.countDistinctWords();
		System.out.println("countDistinctWords should return 138, actually returned: " + numDistinctWords);
	}
}