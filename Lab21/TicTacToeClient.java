import mayflower.*;
import mayflower.net.*;
import java.util.Scanner;

public class TicTacToeClient extends Client
{
	private TicTacToeStage stage;
	private TicTacToe game;
	private TicTacToePiece me;

    public TicTacToeClient() 
    {
    	
    	
    	//System.out.print("Port > ");
    	//int port = in.nextInt();
    	int port = 1234;				//default server port
    	
    	System.out.println("Connecting...");
    	connect("10.11.122.56", port);			//connect to the server at the specified ip and port
    }
    
    /*
     *	Messages:
     *		youare [piece]
     *		addpiece [row] [col]
     *		winner disconnect
     *		error [message...]
     */
    public void process(String message)
    {
    	//output the message recieved from the server. This is useful for debugging
    	System.out.println("Message from server: " + message);
    	
    	//split message into an array of Strings separated by space characters
    	//	"addpiece 1 2" would become the array ["addpiece", "1", "2"]
    	String[] parts = message.split(" ");
    	
    	//use the first value in the array as the "command"
    	//use if statements to determine which command to process
    	if("youare".equals(parts[0]))
    	{
    		//TODO:
    		//parts[1] contains "X" or "O", this is your piece
    		//1. Create a TicTacToePiece variable to store your piece
    		me = (parts[1].equals("X")) ? TicTacToePiece.X : TicTacToePiece.O;
    		//2. Create a new TicTacToe game and store it in the game instance variable
    		game = new TicTacToe();
    		//3. Create a new TicTacToeStage and pass it this client, the game, and your piece
    		stage = new TicTacToeStage(this, game, me);
    		//4. create a new Mayflower object with the stage you just created. This will open the GUI and start the game
    		new Mayflower("Tictactoe", 800, 600, stage);
    	}
    	else if("addpiece".equals(parts[0]))
    	{
    		//TODO:
    		//parts[1] contains the row
    		int row = Integer.parseInt(parts[1]);
    		//parts[2] contains the column
    		int col = Integer.parseInt(parts[2]);
    		//1. add a piece to the game at the specified (row, col)
    		game.addPiece(row, col);
    		TicTacToePiece p = game.getCurrentPlayer();
    		//2. tell the game it is the next player's turn
    		game.nextPlayer();
    		//3. tell the stage to update the piece at (row, col) to the correct type (X or O) depending on which piece was just added to (row, col)
    		stage.updatePiece(p, row, col);
    	}
    	else if("error".equals(parts[0]))
    	{
    		//Output the error message sent from the server
    		System.out.println(message);
    	}
    	else if("winner".equals(parts[0]))
    	{
    		//Congratulations, you win becuase you opponent quit!
    		System.out.println("Opponent disconnected. You win!");
    	}
    	
    }
    
	public void onDisconnect(String message)
	{
		System.out.println("Disconnected from server.");
	}
	
	public void onConnect()
	{
		System.out.println("Connected!");
	}
    
    
}