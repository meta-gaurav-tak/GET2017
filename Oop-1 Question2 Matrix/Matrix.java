/**
 * This class is designed to work on matrices
 * @author Gaurav Tak
 *
 */
public class Matrix {
	private int[][] matrixElement;
	private int noOfRow;
	private int noOfColumn;

	public int getNoOfRow() {
		return noOfRow;
	}

	public int getNoOfColumn() {
		return noOfColumn;
	}
	
	public Matrix() {
		//do nothing
	}
	
	public Matrix(int row, int column) {
		noOfRow = row;
		noOfColumn = column;
		matrixElement = new int[noOfRow][noOfColumn];
	}
	
	public Matrix(int[][] input) {
		noOfRow = input.length;
		noOfColumn = input[0].length;
		matrixElement = new int[noOfRow][noOfColumn];
		setMatrix(input);
	}
	
	//getters and setters
	
	public void setMatrix(int[][] elements) {
		if (noOfRow == elements.length || noOfColumn == elements[0].length)
			for (int rowIndex = 0; rowIndex < noOfRow; rowIndex++) {
				for (int columnIndex = 0; columnIndex < noOfColumn; columnIndex++) {
					matrixElement[rowIndex][columnIndex] = elements[rowIndex][columnIndex];
				}
			}
	}

	public void setElement(int row, int column, int value) {
		matrixElement[row][column] = value;
	}
	
	public int getElement(int row,int col) {
		return matrixElement[row][col];
	}
	
	/**
	 * to find transpose of a matrix
	 * @return the tranposed 2d-array for the matrix
	 * @throws NullPointerException
	 */
	public int[][] transpose() throws NullPointerException {
		if(matrixElement==null) {
			throw new NullPointerException();
		}
		int[][] tranposeMatrix = new int[noOfColumn][noOfRow];
		for (int rowIndex = 0; rowIndex < noOfColumn; rowIndex++) {
			for (int columnIndex = 0; columnIndex < noOfRow; columnIndex++) {
				tranposeMatrix[rowIndex][columnIndex] = matrixElement[columnIndex][rowIndex];
			}
		}
		return tranposeMatrix;
	}
	
	/**
	 *  method to show the matrix elements
	 * @return a string of matrix elements separated by tabs and newline 
	 */
	public String show() {
		if(matrixElement==null) {
			throw new NullPointerException();
		}
		String matrix = "";
		
		for (int rowIndex = 0; rowIndex < noOfRow; rowIndex++) {
			
			for (int columnIndex = 0; columnIndex < noOfColumn; columnIndex++) {
				matrix = matrix + matrixElement[rowIndex][columnIndex] + "\t";
			}
			
			matrix = matrix + "\n";
			
		}
		return matrix;
	}
	
	/**
	 * This method is designed to multiply two matrices
	 * @param multiplierMatrix the matrix to be multiplied with calling matrix
	 * @return the multiplication matrix of the passed matrices
	 * @throws IllegalArgumentException
	 * @throws NullPointerException
	 */
	public Matrix multiplication(Matrix multiplierMatrix)
			throws IllegalArgumentException, NullPointerException {
		Matrix multiplicationMatrix;
		int sum;
		if(multiplierMatrix==null) {
			
			throw new NullPointerException();
			
		}
		
		if (noOfColumn == multiplierMatrix.getNoOfRow()) {

			multiplicationMatrix = new Matrix(noOfRow,
					multiplierMatrix.getNoOfColumn());

			for (int rowIndex = 0; rowIndex < getNoOfRow(); rowIndex++) {

				for (int columnIndex = 0; columnIndex < multiplierMatrix.getNoOfColumn(); columnIndex++) {

					sum = 0;
					for (int internalIndex = 0; internalIndex < getNoOfColumn(); internalIndex++) {

						sum = sum
								+ (this.matrixElement[rowIndex][internalIndex] 
										* multiplierMatrix.getElement(internalIndex,columnIndex));

					}

					multiplicationMatrix.setElement(rowIndex, columnIndex, sum);

				}

			}

		} else {
			throw new IllegalArgumentException("Dimensions of matrix not suitable for multiplication");
		}
		return multiplicationMatrix;
	}
	
	/**
	 * This method is designed to add two matrices
	 * @param addendMatrix the matrix to be added with the calling matrix
	 * @return the addition matrix of the passed matrices
	 * @throws IllegalArgumentException
	 * @throws NullPointerException
	 */
	public Matrix addMatrix(Matrix addendMatrix) throws IllegalArgumentException,NullPointerException {
		Matrix additionMatrix;
		int sum;
		
		if(addendMatrix==null) {
			
			throw new NullPointerException();
			
		}

		if (noOfRow == addendMatrix.getNoOfRow() && noOfColumn==addendMatrix.getNoOfColumn()) {

			additionMatrix = new Matrix(noOfRow,noOfColumn);

			for (int rowIndex = 0; rowIndex < addendMatrix.getNoOfRow(); rowIndex++) {

				for (int columnIndex = 0; columnIndex < addendMatrix
						.getNoOfColumn(); columnIndex++) {

					sum = 0;
					sum=this.matrixElement[rowIndex][columnIndex]+addendMatrix.getElement(rowIndex,columnIndex);
					additionMatrix.setElement(rowIndex, columnIndex, sum);

				}
				
			}

		} else {
			
			throw new IllegalArgumentException("Dimensions of matrix not suitable for addition");
		
		}
		
		return additionMatrix;
	}
}