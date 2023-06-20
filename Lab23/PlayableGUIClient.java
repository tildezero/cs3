public class PlayableGUIClient
  extends GuiClient
{
  public TicTacToeStage getNewStage()
  {
    return new PlayableTicTacToeStage(this, getGame(), getMyPiece());
  }
}
