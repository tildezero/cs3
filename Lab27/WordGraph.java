import java.io.File;
import java.util.Scanner;

class WordGraph 
{
	//INSTANCE VARIABLES
	/**
	 *	Keep track of assoociation betweens consecutive words.
	 *	An edge between words (A -> B)means that B came after A
	 *	The weight of hte edge tells you how many times B came after A
	 */
	private WeightedGraph<String> graph;
	
	/**
	 *	Keep track of the lastWord that was added to the graph.
	 *	When adding a new word to the graph, add an edge between
	 *	the lastWord and the new word.
	 */
	private String lastWord;
	
	//CONSTRUCTOR
	public WordGraph()
	{
		//initialize instance varaibles
		
		//TODO: create a weighted graph object
		//graph = new WeightedAdjacencyListGraph<String>();
		
		//lastWord starts as null.
		lastWord = null;
	}
	
	//METHODS
	/**
	 *	"Sanatize" newWord by trimming extra spaces from the endges (use the trim() method)
	 *	Add the specified word to the graph.
	 *	Add an edge between lastWord and the newWord
	 *	Increment the weight between these nodes by 1
	 *	Set lastWord to point to newWord
	 */
	public void addWord(String newWord)
	{
		//TODO: add a word to the graph instance variable
	}

	/**
	 *	Process a string by splitting it on spaces (use the split() method)
	 *	and calling addWord() on each word.
	 */	
	public void processString(String str)
	{
		//TODO: add each word from str to the graph instance variable
	}
	
	/**
	 *	Process a file by reading each line from a file (using nextLine() method)
	 *	and call the processString() method on it.
	 */
	public void processFile(String filename)
	{
		try
		{
			//open the specified file
			File file = new File(filename);
			Scanner in = new Scanner(file);
			
			//loop through each line of the file and process it
			while(in.hasNextLine())
				processString(in.nextLine());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 *	Getter method for the weighted graph instance variable
	 */
	public WeightedGraph<String> getGraph()
	{
		return graph;
	}
	
}
