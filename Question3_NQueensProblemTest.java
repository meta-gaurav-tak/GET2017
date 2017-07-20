import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertArrayEquals;
public class Question3_NQueensProblemTest {
	
	@Test
	public void board4x4PositiveCase() {
		Question3_NQueensProblem object = new Question3_NQueensProblem();

		int board[][] = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
				{ 0, 0, 0, 0 } };

		boolean actual = object.nQueen(board, 0,board.length);
		assertTrue(actual);				// Check if solution for N Queens Problem exists or not.

		int expected[][] = { { 0, 1, 0, 0 }, { 0, 0, 0, 1 }, { 1, 0, 0, 0 },
				{ 0, 0, 1, 0 } };
		assertArrayEquals(expected, board);
		System.out.println("Board for dimension "+board.length);
		// Print board where 1 denotes location of Queen.
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	@Test
	public void board3x3InvalidCase() {
		Question3_NQueensProblem object = new Question3_NQueensProblem();

		int board[][] = { { 0, 0, 0}, { 0, 0, 0 }, { 0, 0, 0 } };
		try {
		object.nQueen(board, 0,board.length);			// throws Exception
		}
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void boardUndefinedNullException() {
		Question3_NQueensProblem object = new Question3_NQueensProblem();

		int board[][] =null;
		try {
		object.nQueen(board, 0,0);			// throws Exception
		}
		catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void board8x8PositiveCase() {
		Question3_NQueensProblem object = new Question3_NQueensProblem();

		int board[][] = { { 0, 0, 0, 0, 0, 0, 0, 0}, { 0, 0, 0, 0, 0, 0, 0, 0}, { 0, 0, 0, 0, 0, 0, 0, 0},
				{ 0, 0, 0, 0, 0, 0, 0, 0},{ 0, 0, 0, 0, 0, 0, 0, 0},{ 0, 0, 0, 0, 0, 0, 0, 0},
				{ 0, 0, 0, 0, 0, 0, 0, 0},{ 0, 0, 0, 0, 0, 0, 0, 0} };

		boolean actual = object.nQueen(board, 0,board.length);		//Check if solution for N Queens Problem exists or not.
		assertTrue(actual);
		int expected[][] = { { 1, 0, 0, 0, 0, 0, 0, 0}, { 0, 0, 0, 0, 1, 0, 0, 0}, { 0, 0, 0, 0, 0, 0, 0, 1},
				{ 0, 0, 0, 0, 0, 1, 0, 0} , { 0, 0, 1, 0, 0, 0, 0, 0} , { 0, 0, 0, 0, 0, 0, 1, 0}, 
				{ 0, 1, 0, 0, 0, 0, 0, 0} , { 0, 0, 0, 1, 0, 0, 0, 0} };
		assertArrayEquals(expected, board);
		System.out.println("Board for dimension "+board.length);
		//Print board where 1 denotes location of Queen.
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
