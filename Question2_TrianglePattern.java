/**
 * This class is designed to print inverted right triangle number pattern
 * @author Gaurav Tak
 *
 */
public class Question2_TrianglePattern {
	/**
	 * This method gives the number of spaces in the pattern in each row 
	 * @param row
	 * @param n denotes the max value of pattern and the total number of rows in pattern
	 * @return
	 */
	public String spaces(int row,int n) {
		String space="";
		for(int i=1;i<row;i++){
			space=" "+space;
		}
		return space;
	}
	/**
	 * This method returns the number string for each row specified
	 * @param row
	 * @param n
	 * @return
	 */
	public String numbers(int row,int n) {
		String number="";
		for(int i=0;i<=n-row;i++) {
			number=number+(i+1);
		}
		return number;
	}
	/**
	 * This method prints the triangle pattern
	 * @param n
	 * @return an array of String; each row being an array element
	 */
	public String[] printTriangle(int n) {
		String[] trianglePattern=new String[n];
		for(int i=0;i<n;i++) {
			trianglePattern[i]=spaces(i+1,n)+numbers(i+1,n);
			System.out.println(trianglePattern[i]);
		}
		return trianglePattern;
	}
}
