/**
 * This class is designed to solve remaider,gcd and largest digit problem using recursion
 * @author Gaurav Tak
 *
 */
public class Question1_Recursion {
	/**
	 * This method finds the remainder of a number dividend by divisor by succesive substracyion method in recursion 
	 * @param x
	 * @param y
	 * @return integer remainder value
	 */
	public int rem(int x,int y) throws ArithmeticException,IllegalArgumentException {
		if(y==0) {
			throw new ArithmeticException("Remaider By Zero Not Possible");
		}
		if(x<0 || y<0) {
			throw new IllegalArgumentException("Please Supply Legal Arguments i.e., Positive Integers");
		}
		if(x>=y) {
			return rem(x-y,y);
		} else {
			return x;
		}
	}
	
	/**
	 * This method finds the gcd of two no. using basic Euclidean Algorithm
	 * @param x
	 * @param y
	 * @return integer greatest common divisor
	 */
	public int gcd(int x,int y) {
		if(y==0){
			return x;
		} else {
			return gcd(y,x%y);
		}
	}
	
	/**
	 * This method finds the largest digit in a number using recursion
	 * @param n
	 * @param max the max digit value upto the current recursive call 
	 * @return
	 */
	public int largestDigit(int n,int max){
		n=Math.abs(n);
		if(n==0){
			return max;
		}
		if(n%10>max) {
			max=n%10;
		}
		return largestDigit(n/10,max);
	}
}

