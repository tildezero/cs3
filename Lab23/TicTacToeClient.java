import java.io.PrintStream;
import mayflower.net.Client;

public class TicTacToeClient
  extends Client
{
  private TicTacToe game;
  private TicTacToePiece myPiece;
  
  public TicTacToe getGame()
  {
    return this.game;
  }
  
  public TicTacToePiece getMyPiece()
  {
    return this.myPiece;
  }
  
  public void process(String message)
  {
    System.out.println("Message from server: " + message);
    
    String[] parts = message.split(" ");
    if ("youare".equals(parts[0]))
    {
      TicTacToePiece piece = "X".equals(parts[1]) ? TicTacToePiece.X : TicTacToePiece.O;
      this.myPiece = piece;
      
      this.game = new TicTacToe();
      
      onYouAre(piece);
    }
    else if ("addpiece".equals(parts[0]))
    {
      int row = Integer.parseInt(parts[1]);
      int col = Integer.parseInt(parts[2]);
      
      this.game.addPiece(row, col);
      this.game.nextPlayer();
      
      onAddPiece(row, col);
    }
    else if ("error".equals(parts[0]))
    {
      parts = message.split(" ", 2);
      String msg = "";
      if (parts.length > 0) {
        msg = parts[1];
      }
      onError(msg);
    }
    else if ("winner".equals(parts[0]))
    {
      parts = message.split(" ", 2);
      String msg = "";
      if (parts.length > 0) {
        msg = parts[1];
      }
      onWinner(msg);
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
  
  public void onYouAre(TicTacToePiece piece) {}
  
  public void onAddPiece(int row, int col) {}
  
  public void onWinner(String message) {}
  
  public void onError(String error) {}
}
