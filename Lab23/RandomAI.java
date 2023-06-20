import java.util.List;

public class RandomAI
  implements AI
{
  private String name;
  
  public RandomAI(String name)
  {
    this.name = name;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public Point getNextMove(TicTacToe game, TicTacToePiece myPiece)
  {
    if (game.isGameOver()) {
      return null;
    }
    List<Point> allMoves = game.getEmptySpaces();
    if (allMoves.size() == 0) {
      return null;
    }
    int r = (int)(Math.random() * allMoves.size());
    return (Point)allMoves.get(r);
  }
}
