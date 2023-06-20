import java.awt.Color;
import mayflower.Stage;
import mayflower.Text;

public class TicTacToeStage
  extends Stage
{
  private TicTacToe game;
  private Text currentPlayer;
  private Text winner;
  private TicTacToePiece myPiece;
  private PieceActor[][] pieces;
  
  public TicTacToeStage(TicTacToe game, TicTacToePiece piece)
  {
    this.myPiece = piece;
    this.game = game;
    
    setBackground("img/background.png");
    
    Text title = new Text("Tic Tac Toe", Color.WHITE);
    addActor(title, 0, 0);
    
    this.currentPlayer = new Text("Loading...", Color.WHITE);
    addActor(this.currentPlayer, 0, 30);
    
    this.winner = new Text("", Color.WHITE);
    addActor(this.winner, 0, 60);
    
    this.pieces = new PieceActor[3][3];
    int w = 105;
    int h = 105;
    for (int r = 0; r < 3; r++) {
      for (int c = 0; c < 3; c++)
      {
        PieceActor pa = new PieceActor(this, r, c);
        addActor(pa, c * w + 150, r * h + 150);
        this.pieces[r][c] = pa;
      }
    }
  }
  
  public void update()
  {
    if (this.game.isGameOver())
    {
      this.currentPlayer.setText("Game Over!");
      
      TicTacToePiece win = this.game.getWinner();
      if (win == null) {
        this.winner.setText("Tie Game!");
      } else if (win == this.myPiece) {
        this.winner.setText("You Win!");
      } else {
        this.winner.setText("You lose...");
      }
    }
    else
    {
      TicTacToePiece curr = this.game.getCurrentPlayer();
      if (curr == this.myPiece) {
        this.currentPlayer.setText("It is your turn");
      } else {
        this.currentPlayer.setText("Waiting for opponent...");
      }
    }
  }
  
  public void updatePiece(TicTacToePiece piece, int row, int col)
  {
    PieceActor pa = this.pieces[row][col];
    pa.setPiece(piece);
  }
  
  public void click(int row, int col) {}
}
