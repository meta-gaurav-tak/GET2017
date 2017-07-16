/**
 * This class is used to generate a numbers pyramid using modular approach
 * @author Gaurav Tak
 *
 */
public class Question1_Pyramid {
	/**
	 * 
	 * @param row
	 * @param n
	 * @return the space String for current row
	 */
	public String spaces(int row,int n) {
		String space="";
		for(int i=0;i<Math.abs(n-row);i++){
			space=" "+space;
		}
		return space;
	}
	
	public String numbers(int row,int n) {
		String number="";
		for(int i=0,k=1;i<(2*n-1)-(2*Math.abs(n-row));i++) {
			number=number+(i<((2*n-1)-(2*Math.abs(n-row)))/2?k++:k--);
		}
		return number;
	}
	public String[] printPyramid(int n) {
		String[] pyramidPattern=new String[2*n-1];
		for(int i=0;i<2*n-1;i++) {
			pyramidPattern[i]=spaces(i+1,n)+numbers(i+1,n);
			System.out.println(pyramidPattern[i]);
		}
		return pyramidPattern;
	}
}
