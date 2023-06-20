public class MinMaxNode
{
  private TicTacToe game;
  private Point move;
  private int score;
  
  public MinMaxNode(TicTacToe game, Point move)
  {
    this.game = game;
    this.move = move;
    this.score = 0;
  }
  
  public int getScore()
  {
    return this.score;
  }
  
  public void setScore(int score)
  {
    this.score = score;
  }
  
  public TicTacToe getGame()
  {
    return this.game;
  }
  
  public Point getMove()
  {
    return this.move;
  }
  
  public String toString()
  {
    return "(" + this.move + ", " + this.score + ")";
  }
}
