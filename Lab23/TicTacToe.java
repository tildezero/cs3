import java.util.LinkedList;
import java.util.List;

public class TicTacToe
{
  TicTacToePiece[][] board;
  TicTacToePiece currentPlayer;
  
  public TicTacToe()
  {
    this.board = new TicTacToePiece[3][3];
    this.currentPlayer = TicTacToePiece.X;
  }
  
  public TicTacToe copy()
  {
    TicTacToe copy = new TicTacToe();
    for (int r = 0; r < this.board.length; r++) {
      for (int c = 0; c < this.board[r].length; c++) {
        copy.setPiece(r, c, this.board[r][c]);
      }
    }
    copy.setCurrentPlayer(this.currentPlayer);
    
    return copy;
  }
  
  public TicTacToePiece getCurrentPlayer()
  {
    return this.currentPlayer;
  }
  
  public void setCurrentPlayer(TicTacToePiece piece)
  {
    this.currentPlayer = piece;
  }
  
  public void nextPlayer()
  {
    if (this.currentPlayer == TicTacToePiece.X) {
      this.currentPlayer = TicTacToePiece.O;
    } else {
      this.currentPlayer = TicTacToePiece.X;
    }
  }
  
  public boolean addPiece(int row, int col)
  {
    if (null != getPiece(row, col)) {
      return false;
    }
    if ((row < 0) || (col < 0) || (row >= 3) || (col >= 3)) {
      return false;
    }
    this.board[row][col] = this.currentPlayer;
    return true;
  }
  
  public void setPiece(int row, int col, TicTacToePiece piece)
  {
    this.board[row][col] = piece;
  }
  
  public TicTacToePiece getPiece(int row, int col)
  {
    if ((row < 0) || (col < 0) || (row >= 3) || (col >= 3)) {
      return null;
    }
    return this.board[row][col];
  }
  
  public boolean hasEmptySpace()
  {
    for (int r = 0; r < this.board.length; r++) {
      for (int c = 0; c < this.board[r].length; c++) {
        if (this.board[r][c] == null) {
          return true;
        }
      }
    }
    return false;
  }
  
  public List<Point> getEmptySpaces()
  {
    List<Point> ret = new LinkedList<Point>();
    for (int r = 0; r < this.board.length; r++) {
      for (int c = 0; c < this.board[r].length; c++) {
        if (this.board[r][c] == null) {
          ret.add(new Point(r, c));
        }
      }
    }
    return ret;
  }
  
  public TicTacToePiece getWinner()
  {
    TicTacToePiece ret = null;
    
    ret = checkRowsForWinner();
    if (ret != null) {
      return ret;
    }
    ret = checkColsForWinner();
    if (ret != null) {
      return ret;
    }
    ret = checkDiagsForWinner();
    if (ret != null) {
      return ret;
    }
    return null;
  }
  
  public boolean isGameOver()
  {
    return (!hasEmptySpace()) || (getWinner() != null);
  }
  
  private TicTacToePiece checkForWinner(TicTacToePiece a, TicTacToePiece b, TicTacToePiece c)
  {
    if ((a == b) && (b == c)) {
      return a;
    }
    return null;
  }
  
  private TicTacToePiece checkRowsForWinner()
  {
    TicTacToePiece ret = null;
    for (int r = 0; r < 3; r++)
    {
      ret = checkForWinner(this.board[r][0], this.board[r][1], this.board[r][2]);
      if (ret != null) {
        return ret;
      }
    }
    return ret;
  }
  
  private TicTacToePiece checkColsForWinner()
  {
    TicTacToePiece ret = null;
    for (int c = 0; c < 3; c++)
    {
      ret = checkForWinner(this.board[0][c], this.board[1][c], this.board[2][c]);
      if (ret != null) {
        return ret;
      }
    }
    return ret;
  }
  
  private TicTacToePiece checkDiagsForWinner()
  {
    TicTacToePiece ret = null;
    
    ret = checkForWinner(this.board[0][0], this.board[1][1], this.board[2][2]);
    if (ret != null) {
      return ret;
    }
    ret = checkForWinner(this.board[2][0], this.board[1][1], this.board[0][2]);
    if (ret != null) {
      return ret;
    }
    return ret;
  }
  
  public String toString()
  {
    String ret = "";
    for (int r = 0; r < this.board.length; r++)
    {
      for (int c = 0; c < this.board[r].length; c++) {
        ret = ret + (null == this.board[r][c] ? " " : this.board[r][c]);
      }
      ret = ret + "|";
    }
    ret = ret + "(" + this.currentPlayer + ")";
    
    return ret;
  }
}
