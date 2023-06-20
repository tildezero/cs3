public abstract interface AI
{
  public abstract String getName();
  
  public abstract Point getNextMove(TicTacToe paramTicTacToe, TicTacToePiece paramTicTacToePiece);
}
