public class TicTacToe implements ITicTacToe
{
    //INSTANCE VARIABLES
    private TicTacToePiece[][] board;
    private TicTacToePiece currentPlayer;
    
    //CONSTRUCTORS
    public TicTacToe() 
    {
        board = new TicTacToePiece[3][3];
        currentPlayer = TicTacToePiece.X;
    }
    
    //METHODS
    /*
     *  Return the current player's piece (X or O)
     */
    public TicTacToePiece getCurrentPlayer()
    {
        return currentPlayer;
    }
    
    public void reset() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = null;
            }
        }
        currentPlayer = TicTacToePiece.X;
    }
    
    /*
     *  Change the current player from X to O, or from O to X
     */
    public void nextPlayer()
    {
        if (currentPlayer == TicTacToePiece.X) {
            currentPlayer = TicTacToePiece.O;
        } else {
            currentPlayer = TicTacToePiece.X;
        }
    }
    
    /*
     *  Add the specified piece to the board at the specified row,col and return true
     *  If there is already a piece at that location, do not add the piece and return false
     */
    public boolean addPiece(int row, int col)
    {
        if (board[row][col] != null) return false;
        board[row][col] = getCurrentPlayer();
        return true;
    }
    
    /*
     *  Return the piece that is located at the specified row, col
     *  If there is no piece at that location, return null
     */
    public TicTacToePiece getPiece(int row, int col)
    {
        return board[row][col];
    }
    
    /*
     *  Return true if there is at least 1 empty space left on the board
     *  Return false if all spaces have a piece in them
     */
    public boolean hasEmptySpace()
    {
        for (TicTacToePiece[] l: board) {
            for (TicTacToePiece t: l) {
                if (t == null) return true;
            }
        }
        return false;
    }
    
    /*  Return null if there is no winner
     *  Return the appropriate TicTacToePiece (X or Y) if there is a winner.
     *  Hint: use the helper methods: checkRowsForWinner(), checkColsForWinner(), and checkDiagsForWinner()
     */
    public TicTacToePiece getWinner()
    {
        TicTacToePiece f = checkRowsForWinner();
        if (f != null) return f;
        TicTacToePiece s = checkColsForWinner();
        if (s != null) return s;
        TicTacToePiece t = checkDiagsForWinner();
        if (t != null) return t;
        return null;
    }
    
    /*
     *  Return true if there is a winner or if there are no empty spaces left on the board
     *  Otherwise, return false
     */
    public boolean isGameOver()
    {
        return (getWinner() != null) || (hasEmptySpace() == false);
    }
    
    //HELPER METHODS
    /*
     *  If a, b, and c are all the same TicTacToe piece, then return that piece
     *  Otherwise, return null
     */
    private TicTacToePiece checkForWinner(TicTacToePiece a, TicTacToePiece b, TicTacToePiece c)
    {
        // return ((a != null && b != null && c != null) && (a == b && b == c && a == c)) ? a: null;
        if (a != null && b != null && c != null) {
            if (a == b && b == c && a == c) {
                return a;
            }
        }
        return null;
    }
    
    /*
     *  Use the checkForWinner() helper method to check each of the 3 rows for a winner
     *  Return the first non-null winner that is found (starting from row 0)
     *  If no non-null winners are found, return null
     */
    private TicTacToePiece checkRowsForWinner()
    {
        for (int i = 0; i < board.length; i++) {
            TicTacToePiece cfw = checkForWinner(board[i][0], board[i][1], board[i][2]);
            if (cfw != null) {
                return cfw;
            }
        }
        return null;
    }
    
    /*
     *  Use the checkForWinner() helper method to check each of the 3 columns for a winner
     *  Return the first non-null winner that is found (starting from column 0)
     *  If no non-null winners are found, return null
     */
    private TicTacToePiece checkColsForWinner()
    {
        for (int i = 0; i < board.length; i++) {
            TicTacToePiece cfw = checkForWinner(board[0][i], board[1][i], board[2][i]);
            if (cfw != null) {
                return cfw;
            }
        }
        return null;
    }
    
    /*
     *  Use the checkForWinner() helper method to check both of the diagonals for a winner
     *  Check the top left -> bottom right diagonal first
     *  Check the top right -> bottom left diagonal second
     *  Return the first non-null winner that is found
     *  If no non-null winners are found, return null
     */
    private TicTacToePiece checkDiagsForWinner()
    {
        TicTacToePiece first = checkForWinner(board[0][0], board[1][1], board[2][2]);
        if (first != null) {
            return first;
        }
        TicTacToePiece snd = checkForWinner(board[0][2], board[1][1], board[2][0]);
        if (snd != null) {
            return snd;
        }
        return null;
    }
    
    
}