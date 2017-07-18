import static org.junit.Assert.assertEquals;
import org.junit.Test;
/**
 * This is a test class for Recursion problems remainder, gcd and largest digit
 * @author Gaurav Tak
 *
 */
public class Question1_RecursionTest {

	@Test
	public void remainderByUnity() {
		Question1_Recursion remainderObject = new Question1_Recursion();
		int actual = remainderObject.rem(2, 1);
		assertEquals(0, actual);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void remainderByNegative() {
		Question1_Recursion remainderObject = new Question1_Recursion();
		int actual = remainderObject.rem(2,-1);
		assertEquals(0, actual);
	}
	
	@Test(expected=ArithmeticException.class)
	public void remainderByZero() {
		Question1_Recursion remainderObject = new Question1_Recursion();
		int actual = remainderObject.rem(2, 0);
		assertEquals(0, actual);
	}
	
	@Test
	public void remainderTestCase() {
		Question1_Recursion remainderObject = new Question1_Recursion();
		int actual = remainderObject.rem(100,3);
		assertEquals(1, actual);
	}
	
	@Test
	public void gcdWithOneTest() {
		Question1_Recursion object = new Question1_Recursion();
		int actual = object.gcd(2, 1);
		assertEquals(1, actual);
	}
	
	@Test
	public void gcdWithNegativeNumberTest() {
		Question1_Recursion gcdObject = new Question1_Recursion();
		int actual = gcdObject.gcd(-2, -4);
		assertEquals(-2, actual);
	}
	
	@Test
	public void gcdWithGreaterTest() {
		Question1_Recursion gcdObject = new Question1_Recursion();
		int actual = gcdObject.gcd(12, 18);
		assertEquals(6, actual);
	}
	
	@Test
	public void gcdWithSmallerTest() {
		Question1_Recursion gcdObject = new Question1_Recursion();
		int actual = gcdObject.gcd(100, 3);
		assertEquals(1, actual);
	}
	
	@Test
	public void gcdWithSelfCase() {
		Question1_Recursion gcdObject = new Question1_Recursion();
		int actual = gcdObject.gcd(3, 3);
		assertEquals(3, actual);
	}
	
	@Test
	public void largestDigitSingleTest() {
		Question1_Recursion largestDigitObject = new Question1_Recursion();
		int actual = largestDigitObject.largestDigit(2,0);
		assertEquals(2, actual);
	}
	
	@Test
	public void largestDigitNegativeNumberTest() {
		Question1_Recursion largestDigitObject = new Question1_Recursion();
		int actual = largestDigitObject.largestDigit(-105,0);
		assertEquals(5, actual);
	}
	
	@Test
	public void largestDigitAllDifferrentTest() {
		Question1_Recursion largestDigitObject = new Question1_Recursion();
		int actual = largestDigitObject.largestDigit(1257369,0);
		assertEquals(9, actual);
	}
	
	@Test
	public void largestDigitAllSameTest() {
		Question1_Recursion largestDigitObject = new Question1_Recursion();
		int actual = largestDigitObject.largestDigit(4444,0);
		assertEquals(4, actual);
	}
}
