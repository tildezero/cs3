import java.io.PrintStream;
import mayflower.Actor;

public class PieceActor
  extends Actor
{
  int row;
  int col;
  TicTacToeStage stage;
  
  public PieceActor(TicTacToeStage stage, int row, int col)
  {
    this.row = row;
    this.col = col;
    this.stage = stage;
    
    setPicture("img/empty.png");
  }
  
  public void update()
  {
    if (isClicked()) {
      this.stage.click(this.row, this.col);
    }
  }
  
  public void setPiece(TicTacToePiece piece)
  {
    System.out.println("Setting piece " + this.row + ", " + this.col + " to " + piece);
    if (piece == TicTacToePiece.X) {
      setPicture("img/X.png");
    } else if (piece == TicTacToePiece.O) {
      setPicture("img/O.png");
    } else {
      setPicture("img/empty.png");
    }
  }
}
