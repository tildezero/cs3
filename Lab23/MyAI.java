import java.io.PrintStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyAI
implements AI
{
    public String getName()
    {
        return "MinMaxTree";
    }

    //Return the best move myPiece can make using a MinMaxTree
    public Point getNextMove(TicTacToe game, TicTacToePiece myPiece)
    {
        //if game is over, reutrn null
        if (game.isGameOver()) return null;

        //Generate a MinMax tree using the TicTacToe game parameter
        TNode<MinMaxNode> mmt = generateMinMaxTree(game, null);
        //Score the MinMax tree
        scoreMinMaxTree(mmt, myPiece);

        //Create a list of MinMaxNodes from the children of the root of the MinMax tree you just generated
        List<MinMaxNode> lstmxn = mmt.getChildrenData();
        //if the root node has no children, return null
        if (mmt.getChildren().size() == 0) return null;

        //Determine what the best (highest) score is among all of the MinMax nodes in the list your just created
        int best = Integer.MIN_VALUE;
        for (MinMaxNode m: lstmxn) {
            if (m.getScore() > best) {
                best = m.getScore();
            }
        }

        //Create a list to hold all of the moves (Point objects) that are rated with the best score
        List<Point> lstp = new LinkedList<Point>();
        //loop through all of the children of the root of hte MinMax tree and add the Point from the ones with the "best score" to the list of Points you just created
        for (MinMaxNode mxn2 : mmt.getChildrenData()) {
            if (mxn2.getScore() == best) {
                lstp.add(mxn2.getMove());
            }
        }

        //return a random point from the list of Points
        return lstp.get((int) (Math.random() * lstp.size() )) ;
    }

    //Generate a MinMaxTree consisting of a root node containing game, and children nodes 
    //containing all possible moves the current player can make
    private TNode<MinMaxNode> generateMinMaxTree(TicTacToe game, Point move)
    {
        //make a copy of game (so you can modify the copy without changing game)
        TicTacToe gameCopy = game.copy();
        //if move is not null
        if (move != null) {
            //  apply move to the copy (addPiece and nextPlayer)
            gameCopy.addPiece(move.getRow(), move.getCol());
            gameCopy.nextPlayer();
        }

        //Make a MinMaxNode with the copy and move
        MinMaxNode mxn = new MinMaxNode(gameCopy, move);
        //Make a TNode with the MinMaxNode you just created
        TNode<MinMaxNode> tnmxn = new TNode<MinMaxNode>(mxn);

        //recursively call generateMinMaxTree for each legal move that the new current player can make on copy (every empty space is a legal move)
        for (Point p: gameCopy.getEmptySpaces()) {
            TNode<MinMaxNode> tnmxn2 = generateMinMaxTree(gameCopy, p);

            //  add the TNode returned by the recursive generateMinMaxTree calls as a child to the TNode you created above
            tnmxn.addChild(tnmxn2);
        }
        //return the TNode you created above
        return tnmxn;
    }

    //Generate a score for every node in the MinMaxTree (from the point of view of player)
    private void scoreMinMaxTree(TNode<MinMaxNode> root, TicTacToePiece player)
    {
        //get the MinMaxNode out of the root node
        MinMaxNode mxn = root.getData();
        //get the game out of the MinMaxNode
        TicTacToe game = mxn.getGame();

        //if the game is over
        if (game.isGameOver()) {
            //  use the setScore method to score the MinMaxNode based on who one the gmae

            //      if player is the winner ->  10 points
            if (game.getWinner() == player) {
                mxn.setScore(10);
                //      if the game is tied ->      0 points
            } else if (game.getWinner() == null) {
                mxn.setScore(0);
            } else {
                mxn.setScore(-10);
            }
            //      if player is the loser ->   -10 points
        }

        //if the game is not over
        if (!game.isGameOver()) {
        //  recursively call scoreMinMaxTree on all of the root node's children
        for (TNode<MinMaxNode> child: root.getChildren()) {
            scoreMinMaxTree(child, player);
        }
        //  determine the lowest and highest scores among all of the root node's children
        int mx = Integer.MIN_VALUE;
        int mn = Integer.MAX_VALUE;
        for (TNode<MinMaxNode> c: root.getChildren()) {
            if (c.getData().getScore() > mx) {
                mx = c.getData().getScore();
            }
            if (c.getData().getScore() < mn) {
                mn = c.getData().getScore();
            }
        }
        //  if it is player's turn
        if (game.getCurrentPlayer() == player) {
            mxn.setScore(mx);
        } else {
            mxn.setScore(mn);
        }
        //      set this MinMaxNode's score to the highest score
        //  if it is NOT player's turn
        //      set this MinMaxNode's score to the lowest score
       }
    }

}
