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
		for(int i=0;i<absolute(n-row);i++){
			space=" "+space;
		}
		return space;
	}
	
	/**
	 * 
	 * @param row
	 * @param n
	 * @return the numbers pattern string for row
	 */
	public String numbers(int row,int n) {
		String number="";
		for(int i=0,k=1;i<(2*n-1)-(2*absolute(n-row));i++) {
			number=number+(i<((2*n-1)-(2*absolute(n-row)))/2?k++:k--);
		}
		return number;
	}
	
	/**
	 * This method prints the pyramid pattern
	 * @param n
	 * @return pyramid pattern string
	 * @throws NullPointerException
	 */
	public String[] printPyramid(int n) throws NullPointerException {
		if(n<1) {
			System.out.println("Invalid entry for pattern count");
			throw new NullPointerException();
		}
		String[] pyramidPattern=new String[2*n-1];
		for(int i=0;i<2*n-1;i++) {
			pyramidPattern[i]=spaces(i+1,n)+numbers(i+1,n);
			System.out.println(pyramidPattern[i]);
		}
		return pyramidPattern;
	}
	
	/**
	 * This method gives absolute value for n
	 * @param n
	 * @return
	 */
	private int absolute(int n){
		return n<0?(-1*n):n;
	}
}
