import java.io.PrintStream;
import mayflower.net.Client;

public class PlayableTicTacToeStage
  extends TicTacToeStage
{
  private Client client;
  
  public PlayableTicTacToeStage(TicTacToeClient client, TicTacToe game, TicTacToePiece piece)
  {
    super(game, piece);
    this.client = client;
  }
  
  public void click(int row, int col)
  {
    String request = "play " + row + " " + col;
    System.out.println("Requesting: " + request);
    this.client.send(request);
  }
}
