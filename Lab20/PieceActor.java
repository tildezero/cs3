import mayflower.*;

public class PieceActor extends Actor
{
    //INSTANCE VARIABLES
    
    TicTacToe game;
    int row;
    int col;
    //CONSTRUCTOR
    public PieceActor(TicTacToe gamee, int roww, int coll) 
    {
        //Initialize instance variables here
        game = gamee;
        row = roww;
        col = coll;
        //Set this Actor's image. Blank pieces should display the empty.png image!
        setPicture("img/empty.png");
    }
    
    //METHODS
    /*
     *  Checks if this piece is clicked using the isClicked() method
     *  If it is clicked then:
     *      1. Check if the game is over. No pieces can be played if the game is over.
     *      1. Check if this is an empty piece. Pieces cannot be played on top of other pieces.
     *      2. Make this PieceActor display the current player's piece.
     *      3. Tell the game to put the current player's piece in the correct row,col using the addPiece() method.
     *      3. Tell the game it is the next player's turn using the nextPlayer() method.
     */
    public void update()
    {
        if (isClicked() && !game.isGameOver() && (game.getPiece(row, col) == null)) {
            if (game.getCurrentPlayer() == TicTacToePiece.X) { setPicture("img/x.png"); }
            else if (game.getCurrentPlayer() == TicTacToePiece.O) { setPicture("img/o.png"); }
            else { setPicture("img/empty.png"); }
            game.addPiece(row, col);
            game.nextPlayer();
        }
        
        if (game.isGameOver()) { setPicture("img/empty.png"); }
    }
}