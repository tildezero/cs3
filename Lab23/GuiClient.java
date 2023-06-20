import mayflower.Mayflower;

public abstract class GuiClient
  extends TicTacToeClient
{
  private TicTacToeStage stage;
  
  public TicTacToeStage getStage()
  {
    return this.stage;
  }
  
  public abstract TicTacToeStage getNewStage();
  
  public void onYouAre(TicTacToePiece piece)
  {
    this.stage = getNewStage();
    new Mayflower("TicTacToe", 800, 600, this.stage);
  }
  
  public void onAddPiece(int row, int col)
  {
    this.stage.updatePiece(getGame().getPiece(row, col), row, col);
  }
}
