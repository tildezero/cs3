import java.io.PrintStream;

public class SteppableGUIClient
  extends GuiClient
{
  private AI ai;
  private DoSomethingButton button;
  
  public SteppableGUIClient(AI ai)
  {
    this.ai = ai;
    this.button = new DoSomethingButton(this);
  }
  
  public TicTacToeStage getNewStage()
  {
    return new TicTacToeStage(getGame(), getMyPiece());
  }
  
  public void onYouAre(TicTacToePiece piece)
  {
    super.onYouAre(piece);
    
    getStage().addActor(this.button, 300, 500);
  }
  
  public void onWinner(String winner)
  {
    super.onWinner(winner);
    
    getStage().removeActor(this.button);
  }
  
  public void click()
  {
    makeMove();
  }
  
  private void makeMove()
  {
    TicTacToe game = getGame();
    TicTacToePiece piece = getMyPiece();
    if (game.getCurrentPlayer() == piece)
    {
      Point move = this.ai.getNextMove(game, piece);
      if (null == move)
      {
        System.out.println("No moves to make...");
        return;
      }
      String request = "play " + move.getRow() + " " + move.getCol();
      send(request);
    }
  }
}
