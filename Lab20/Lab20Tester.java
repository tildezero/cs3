import junit.framework.*; 
import java.util.*;

public class Lab20Tester extends TestCase
{
	public void testGetCurrentPlayer()
	{
		ITicTacToe ttt = new TicTacToe();

		TicTacToePiece curr = ttt.getCurrentPlayer();
		assertEquals("The first player should be X", TicTacToePiece.X, curr);

		ttt.nextPlayer();
		curr = ttt.getCurrentPlayer();
		assertEquals("nextPlayer should change the current player to O", TicTacToePiece.O, curr);

		ttt.nextPlayer();
		curr = ttt.getCurrentPlayer();
		assertEquals("calling nextPlayer twice should change the current player to X", TicTacToePiece.X, curr);
	}

	public void testEmptyBoard()
	{
		ITicTacToe ttt = new TicTacToe();	

		for(int r=0; r<3; r++)
			for(int c = 0; c < 3; c++)
				assertEquals("All spots on board should begin null, even ("+r+", "+c+")", null, ttt.getPiece(r, c));

	}

	public void testAddPiece()
	{
		ITicTacToe ttt = new TicTacToe();

		ttt.addPiece(0, 0);
		TicTacToePiece piece = ttt.getPiece(0, 0);

		assertEquals("Calling getPiece(0, 0) after setPiece(0, 0) should not return null", "TicTacToePiece", (piece==TicTacToePiece.X || piece==TicTacToePiece.O) ? "TicTacToePiece" : null);
		assertEquals("The first piece being placed should be X", TicTacToePiece.X, piece);

		ttt.addPiece(1, 0);
		piece = ttt.getPiece(1, 0);

		assertEquals("Calling getPiece(1, 0) after setPiece(1, 0) should not return null", "TicTacToePiece", (piece==TicTacToePiece.X || piece==TicTacToePiece.O) ? "TicTacToePiece" : null);
		assertEquals("The second piece being placed should be X", TicTacToePiece.X, piece);

		ttt.nextPlayer();
		ttt.addPiece(2, 2);
		piece = ttt.getPiece(2, 2);

		assertEquals("Calling getPiece(2, 2) after setPiece(2, 2) should not return null", "TicTacToePiece", (piece==TicTacToePiece.X || piece==TicTacToePiece.O) ? "TicTacToePiece" : null);
		assertEquals("The third piece being placed should be O", TicTacToePiece.O, piece);
	}

	public void testHasEmptySpace()
	{
		ITicTacToe ttt = new TicTacToe();

		int piecesAdded = 0;
		for(int r = 0; r < 3; r++)
			for(int c = 0; c < 3; c++)
			{
				assertEquals(piecesAdded + " pieces added. hasEmptySpace should return true if less than 9 pieces have been added ()", true, ttt.hasEmptySpace());
				piecesAdded++;
				ttt.addPiece(r, c);
				ttt.nextPlayer();
			}

		assertEquals("hasEmptySpace should return false when there is a piece in all 9 spaces", false, ttt.hasEmptySpace());		
	}
	

	public void testIsGameOverFullBoard()
	{
		ITicTacToe ttt = new TicTacToe();

		for(int r = 0; r < 3; r++)
		{

			if(r == 2)
				ttt.nextPlayer();
			for(int c = 0; c < 3; c++)
			{
				assertEquals("Game should not be over when there are empty board spaces", false, ttt.isGameOver());
				ttt.addPiece(r, c);
				ttt.nextPlayer();
			}
		}

		assertEquals("Game should be over when all board spaces have a piece in them", true, ttt.isGameOver());

		assertEquals("If game is over but nobody wins, getWinner should return null", null, ttt.getWinner());
	}


	public void testForWinnerRow()
	{
		ITicTacToe ttt = new TicTacToe();

		assertEquals("Nobody should win on an empty board", null, ttt.getWinner());

		for(int r = 0; r < 3; r++)
		{
			ttt = new TicTacToe();

			ttt.addPiece(r, 0);
			assertEquals("Nobody should win on a board with 1 piece", null, ttt.getWinner());
			ttt.addPiece(r, 1);
			assertEquals("Nobody should win on a board with 2 pieces", null, ttt.getWinner());
			ttt.addPiece(r, 2);
			assertEquals("X should win with three pieces in row "+ r, TicTacToePiece.X, ttt.getWinner());
		}

		ttt = new TicTacToe();

		ttt.addPiece(2, 0);
		assertEquals("Nobody should win on a board with 1 piece", null, ttt.getWinner());
		ttt.addPiece(2, 1);
		assertEquals("Nobody should win on a board with 2 pieces", null, ttt.getWinner());
		ttt.nextPlayer();
		ttt.addPiece(2, 2);
		assertEquals("X should not win when O blocks", null, ttt.getWinner());
	}

	public void testForWinnerColumn()
	{
		ITicTacToe ttt = new TicTacToe();

		assertEquals("Nobody should win on an empty board", null, ttt.getWinner());

		for(int c = 0; c < 3; c++)
		{
			ttt = new TicTacToe();

			ttt.addPiece(0, c);
			assertEquals("Nobody should win on a board with 1 piece", null, ttt.getWinner());
			ttt.addPiece(1, c);
			assertEquals("Nobody should win on a board with 2 pieces", null, ttt.getWinner());
			ttt.addPiece(2, c);
			assertEquals("X should win with three pieces in col "+ c, TicTacToePiece.X, ttt.getWinner());
		}

		ttt = new TicTacToe();

		ttt.addPiece(0, 2);
		assertEquals("Nobody should win on a board with 1 piece", null, ttt.getWinner());
		ttt.addPiece(1, 2);
		assertEquals("Nobody should win on a board with 2 pieces", null, ttt.getWinner());
		ttt.nextPlayer();
		ttt.addPiece(2, 2);
		assertEquals("X should not win when O blocks", null, ttt.getWinner());
	}

	public void testForWinnerDiag()
	{
		ITicTacToe ttt = new TicTacToe();

		assertEquals("Nobody should win on an empty board", null, ttt.getWinner());

		ttt.addPiece(0, 0);
		assertEquals("Nobody should win on a board with 1 piece", null, ttt.getWinner());
		ttt.addPiece(1, 1);
		assertEquals("Nobody should win on a board with 2 pieces", null, ttt.getWinner());
		ttt.addPiece(2, 2);
		assertEquals("X should win with three pieces in diag top-left to bottom-right", TicTacToePiece.X, ttt.getWinner());

		ttt = new TicTacToe();

		ttt.addPiece(0, 2);
		assertEquals("Nobody should win on a board with 1 piece", null, ttt.getWinner());
		ttt.addPiece(1, 1);
		assertEquals("Nobody should win on a board with 2 pieces", null, ttt.getWinner());
		ttt.addPiece(2, 0);
		assertEquals("X should win with three pieces in diag top-right to bottom-left", TicTacToePiece.X, ttt.getWinner());
	}
}