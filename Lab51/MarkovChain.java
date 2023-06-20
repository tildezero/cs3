import java.util.List;
import java.util.LinkedList;
import java.util.Map;

public class MarkovChain 
{
	//INSTANCE VARIABLES
	/**
	 *	This holds all of the word relationships
	 */
	private WordGraph wg;
	
	/**
	 *	This remembers the lastWord that this Markov Chain generated
	 */
	private String lastWord;

	//CONSTRUCTOR
    public MarkovChain() 
    {
    	//initialize instance variables
    	wg = new WordGraph();
    	lastWord = null;
    }
    
    //METHODS
    /**
     *	Add word relationships from the specified file
     */
    public void train(String filename)
    {
    	//TODO: add data from filename to the WordGraph
    }
    
    /**
     *	Get a list of words that follow lastWord.
	 *	words with more *weight* will appear more times in the list.
	 *  if lastWord is null, then return the words that are neighbors of [START]
     */
    public List<String> getNextWords()
    {
    	//TODO: return List<String> of words that are neighbors of lastWord, weighted appropriatly
    	
    	return null;
    }
    
    /**
     *	Get a word that follows lastWord
     *	Use a weighted random number to pick the next word from the list of all of lastWord's neighbors in wordGraph
     *	If lastWord is null or [END], this should generate a word that *starts* a sentence
     *	Remember the word that is about to be returned in the appropriate instance variable
     */
    public String getNextWord()
    {
    	//TODO: return random word with an edge from lastWord
    	
    	return "not implemented yet.";
    }
    
    /**
     *	Generate a sentence using the data in the wordGraph. 
     */
    public String generateSentence()
    {
    	//TODO: generate a sentence from [START] to [END]
    	
    	return "not implemented yet.";
    }
    
    
}