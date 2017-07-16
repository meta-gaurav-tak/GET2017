import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
/**
 * Test class for Triangle
 * @author Gaurav Tak
 *
 */
public class Question2_TrianglePatternTest {
	@Test
	public void printTriangleTest() {
		Question2_TrianglePattern triangleObject = new Question2_TrianglePattern();
		String[] obtainedTriangle=triangleObject.printTriangle(3);
		String[] expectedTriangle={"123"," 12","  1"};
		assertArrayEquals(expectedTriangle,obtainedTriangle);
	}
	
	@Test
	public void printTriangleTestEmpty() {
		Question2_TrianglePattern triangleObject = new Question2_TrianglePattern();
		String[] obtainedTriangle=triangleObject.printTriangle(0);
		String[] expectedTriangle={};
		assertArrayEquals(expectedTriangle,obtainedTriangle);
	}
	
	@Test
	public void spacesTest(){
		Question2_TrianglePattern triangleObject = new Question2_TrianglePattern();
		String expected=" ";
		String spaceOutput=triangleObject.spaces(2,5); //row_no=2; pyramid_count=5;
		assertEquals(expected,spaceOutput);
	}
	
	@Test
	public void spacesTestFail(){
		Question2_TrianglePattern triangleObject = new Question2_TrianglePattern();
		String expected=" ";
		String spaceOutput=triangleObject.spaces(3,5); //row_no=3; pyramid_count=5;
		assertEquals(expected,spaceOutput);
	}
	@Test
	public void numbersTest(){
		Question2_TrianglePattern triangleObject = new Question2_TrianglePattern();
		String expected="12345";
		String spaceOutput=triangleObject.numbers(2,6); //row_no=2; pyramid_count=6;
		assertEquals(expected,spaceOutput);
	}
	
	@Test
	public void numbersTestFail(){
		Question2_TrianglePattern triangleObject = new Question2_TrianglePattern();
		String expected="1234";
		String spaceOutput=triangleObject.numbers(3,5); //row_no=3; pyramid_count=5;
		assertEquals(expected,spaceOutput);
	}
}