import java.io.PrintStream;

class AutomatedGUIClient
  extends GuiClient
{
  private AI ai;
  
  public AutomatedGUIClient(AI ai)
  {
    this.ai = ai;
  }
  
  public TicTacToeStage getNewStage()
  {
    return new TicTacToeStage(getGame(), getMyPiece());
  }
  
  public void onYouAre(TicTacToePiece piece)
  {
    super.onYouAre(piece);
    
    makeMove();
  }
  
  public void onAddPiece(int row, int col)
  {
    super.onAddPiece(row, col);
    
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
