/**
 * NQueensProblem class solves the N Queens problem i.e. the problem of placing
 * N chess queens on an N × N Board so that no two queens can attack each other.
 * 
 * @author Gaurav Tak
 *
 */
public class Question3_NQueensProblem {
	
	/**
	 * Checks whether position board[row][column] is not under attack by any
	 * other queen.
	 *
	 * @param board 2 D array representing board
	 * @param row the row index of the current position in consideration
	 * @param column column index of the current position in consideration
	 * @return True if position board[row][column] is safe and false if it is not.
	 */
	boolean checkSafe(int[][] board, int row, int column) {

		// Check whether no queen is present in the same column.
		for (int rowIndex = 0; rowIndex < row; rowIndex++) {
			//If Queen is already present then it is unsafe.
			if (board[rowIndex][column] == 1)
				return false;
		}

		// Check whether no queen is present at Top-Left diagonal.
		for (int rowIndex = row, columnIndex = column; rowIndex >= 0
				&& columnIndex >= 0; rowIndex--, columnIndex--) {

			if (board[rowIndex][columnIndex] == 1)
				return false;
			
		}

		// Check whether no queen is present at Top-right diagonal.
		for (int rowIndex = row, columnIndex = column; rowIndex >= 0
				&& columnIndex < board.length; rowIndex--, columnIndex++) {

			if (board[rowIndex][columnIndex] == 1)
				return false;
		}

		/* Since position board[row][column] is not under attack by any queen,it
		 is safe position.*/
		return true;
	}

	/**
	 * Checks whether a solution exist of N Queens problem or not.
	 * 
	 * @param board -2 D array representing board
	 * @param startRow gives the current row number to place the queen
	 * @param dimensionOfMatrix  gives the size of board
	 * @return true if solution exists for N Queens problem otherwise false.
	 * 
	 */
	boolean nQueen(int[][] board, int startRow, int dimensionOfMatrix) throws IllegalArgumentException,NullPointerException {
		
		/* Check if board is defined or not*/
		if(board==null) {
			throw new NullPointerException("board is undefined; received null in board");
		}
		/*
		 * Generate an exception for a matrix of size<3 
		 * N-queens problem can be solved only for n>=4
		 */
		if(dimensionOfMatrix==2 || dimensionOfMatrix==3 || dimensionOfMatrix<=0 || startRow<0) {
			throw new IllegalArgumentException("illegal value for matrix dimension; solution does not exist");
		}
		/*
		 * Base condition: If all Queens have been placed and thus solution exists.
		 */
		if (startRow >= dimensionOfMatrix)
			return true;

		// Finding position for placing Queen in the startRow.
		for (int i = 0; i < dimensionOfMatrix; i++) {

			// Checks if it is safe to place Queen at board[startRow][i].
			if (checkSafe(board, startRow, i) == true) {

				// If it is safe,place the queen.
				board[startRow][i] = 1;

				// Recursive call to place rest of the queens.
				if (nQueen(board, startRow + 1, dimensionOfMatrix) == true)
					return true;

				/* Backtracking : If placing the Queen at board[start][row] does
				 not give a solution.*/
				board[startRow][i] = 0;

			}
		}

		// If no solution exists for given Queens problem.
		return false;
	}
}
