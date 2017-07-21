import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
 /**
  * this class is designed to test matrix class functionality
  * @author Gaurav Tak
  *
  */
public class MatrixTest {
	
	@Test
	public void addMatrixTest() {
		Matrix matrixObjectFirst=new Matrix( new int[][]{{1,8,9},{1,4,5},{-3,12,9},{1,3,5} });
		Matrix matrixObjectSecond=new Matrix( new int[][]{{2,8,6},{9,-6,5},{-5,-9,9},{5,6,7} });
		Matrix matrixObjectExpected=new Matrix( new int[][]{{3,16,15},{10,-2,10},{-8,3,18},{6,9,12} });
		Matrix additionMatrix=matrixObjectFirst.addMatrix(matrixObjectSecond);
		for(int rowIndex=0;rowIndex<matrixObjectExpected.getNoOfRow();rowIndex++){
			for(int columnIndex=0;columnIndex<matrixObjectExpected.getNoOfColumn();columnIndex++) {
				assertEquals(matrixObjectExpected.getElement(rowIndex, columnIndex),
						additionMatrix.getElement(rowIndex, columnIndex));
			}
		}
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void addMatrixTestException() {
		Matrix matrixObjectFirst=new Matrix( new int[][]{{1,8},{1,4},{-3,12},{1,3} });
		Matrix matrixObjectSecond=new Matrix( new int[][]{{2,8,6,55},{9,-6,5,9} });
		Matrix additionMatrix=matrixObjectFirst.addMatrix(matrixObjectSecond);
		}
		
	@Test(expected=NullPointerException.class)
	public void addMatrixTestExceptionNull() {
		Matrix matrixObjectFirst=new Matrix( new int[][]{{1,8},{1,4},{-3,12},{1,3} });
		Matrix matrixObjectSecond=null;
		Matrix additionMatrix=matrixObjectFirst.addMatrix(matrixObjectSecond);
		}
		
	
	@Test
	public void multiplicationMatrixTest() {
		Matrix matrixObjectFirst=new Matrix( new int[][]{ {1,2,3},{4,5,6} });
		Matrix matrixObjectSecond=new Matrix( new int[][]{ {1,2},{3,4},{5,6} });
		Matrix matrixObjectExpected=new Matrix( new int[][]{ {22,28},{49,64} });
		Matrix multiplicationMatrix=matrixObjectFirst.multiplication(matrixObjectSecond);
		for(int rowIndex=0;rowIndex<matrixObjectExpected.getNoOfRow();rowIndex++){
			for(int columnIndex=0;columnIndex<matrixObjectExpected.getNoOfColumn();columnIndex++) {
				assertEquals(matrixObjectExpected.getElement(rowIndex, columnIndex),
						multiplicationMatrix.getElement(rowIndex, columnIndex));
			}
		}
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void multiplicationMatrixTestException() {
		Matrix matrixObjectFirst=new Matrix( new int[][]{{1,8},{1,4},{-3,12},{1,3} });
		Matrix matrixObjectSecond=new Matrix( new int[][]{ {2,8},{6,55},{9,-6},{5,9} });
		Matrix multiplicationMatrix=matrixObjectFirst.multiplication(matrixObjectSecond);
		}
	
	@Test(expected=NullPointerException.class)
	public void multiplyMatrixTestExceptionNull() {
		Matrix matrixObjectFirst=new Matrix( new int[][]{{1,8},{1,4},{-3,12},{1,3} });
		Matrix matrixObjectSecond=null;
		Matrix additionMatrix=matrixObjectFirst.multiplication(matrixObjectSecond);
		}
	
	@Test
	public void transposeMatrixTest() {
		int array[][]={{1,8},{1,4},{-3,12},{1,3}};
		Matrix matrixObject=new Matrix(array);
		int[][] transposeExpected=new int[][]{ {1,1,-3,1},{8,4,12,3} };
		int[][] transposeMatrix=matrixObject.transpose();
		assertArrayEquals(transposeExpected,transposeMatrix);
		}
	
	@Test(expected=NullPointerException.class)
	public void transposeMatrixTestNull() {
		int array[][]=null;
		Matrix matrixObject=new Matrix(array);
		int[][] transposeMatrix=matrixObject.transpose();
		}
	
	@Test
	public void showMatrixTest() {
		int array[][]={{1,8},{1,4},{-3,12},{1,3}};
		Matrix matrixObject=new Matrix(array);
		String expected=new String(1+"\t"+8+"\t"+"\n"+1+"\t"+4+"\t"+"\n"+-3+"\t"+12+"\t"+"\n"+1+"\t"+3+"\t"+"\n");
		String actual=matrixObject.show();
		assertEquals(expected,actual);
		}
	
	@Test(expected=NullPointerException.class)
	public void showMatrixTestNull() {
		int array[][]=null;
		Matrix matrixObject=new Matrix(array);
		matrixObject.show();
		}
}
	
