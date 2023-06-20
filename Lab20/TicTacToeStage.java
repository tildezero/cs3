import mayflower.*;
import java.awt.Color;

//Find the Mayflower documentation here: http://mrmaycs.com/mayflower/

public class TicTacToeStage extends Stage
{
    //INSTANCE VARIABLES
    private TicTacToe game;
    private Text go, w, t;
    private PlayAgainActor paa;
    
    //CONSTRUCTOR
    public TicTacToeStage() 
    {
        setBackground("img/background.png");
        
        game = new TicTacToe();
        
        paa = new PlayAgainActor(game);
        
        //Add a label to the top of the screen that displays the name of the game
        Text title = new Text("Tic Tac Toe", Color.WHITE);
        addActor(title, 0, 0);
        
        go = new Text("Game Over!", Color.WHITE);
        w = new Text("", Color.WHITE);
        t = new Text("", Color.WHITE);
        
        addActor(w, 600, 200);
        addActor(t, 600, 300);
        
        
        
        //TODO: Add a "blank" PieceActor to each of the 9 spots of the TicTacToe board
        //      Each PieceActor needs a reference to the TicTacToe object
        int xc = 150;
        int yc = 150;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Actor p = new PieceActor(game, i, j);
                addActor(p, xc, yc);
                xc += 105;
                
            }
            yc += 105;
            xc = 150;
        }
    }
    
    //METHODS
    /*
     *  Check if the game is over
     *      If the game is over, display the text "Game Over!" on the screen
     *      If there is a winner, display the text "X wins!" or "O wins!" on the screen
     *      If there is not a winner, display the text "Tie Game!" on the screen
     *  If the game is NOT over
     *      Display the current player's turn on the screen: "It is X's turn" or "It is O's turn"
     */
    public void update()
    {
        if (game.isGameOver()) {
            addActor(go, 600, 300);
            go.setText("Game over!");
            t.setText(" ");
            if (game.getWinner() == TicTacToePiece.X) w.setText("X Wins!");
            else if (game.getWinner() == TicTacToePiece.O) w.setText("O wins!");
            else w.setText("Tie Game!");
            addActor(paa, 600, 450);
            
        } else {
            w.setText("  ");
            go.setText(" ");
            if (game.getCurrentPlayer() == TicTacToePiece.X) t.setText("It is X's turn");
            else t.setText("It is O's turn");
        }
    }
}