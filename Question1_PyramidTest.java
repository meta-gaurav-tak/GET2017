import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
/**
 * Test class for Pyramid
 * @author Gaurav Tak
 *
 */
public class Question1_PyramidTest {
	@Test
	public void printPyramidTestException() {
		Question1_Pyramid pyramidObject = new Question1_Pyramid();
		try{
			String[] obtainedPyramid=pyramidObject.printPyramid(0);
			String[] expectedPyramid={};
			assertArrayEquals(expectedPyramid,obtainedPyramid);
		}
		catch(NullPointerException e){
			e.getMessage();
		}
	}
	
	@Test
	public void printPyramidTest() {
		Question1_Pyramid pyramidObject = new Question1_Pyramid();
		try{
			String[] obtainedPyramid=pyramidObject.printPyramid(3);
			String[] expectedPyramid={"  1"," 121","12321"," 121","  1"};
			assertArrayEquals(expectedPyramid,obtainedPyramid);
		}
		catch(NullPointerException e){
			e.getMessage();
		}
	}
	
	@Test
	public void spacesTest(){
		Question1_Pyramid pyramidObject = new Question1_Pyramid();
		String expected="   ";
		String spaceOutput=pyramidObject.spaces(2,5); //row_no=2; pyramid_count=5;
		assertEquals(expected,spaceOutput);
	}
	
	@Test
	public void spacesTestFail(){
		Question1_Pyramid pyramidObject = new Question1_Pyramid();
		String expected="     ";
		String spaceOutput=pyramidObject.spaces(2,5); //row_no=3; pyramid_count=5;
		assertNotEquals(expected,spaceOutput);
	}
	@Test
	public void numbersTest(){
		Question1_Pyramid pyramidObject = new Question1_Pyramid();
		String expected="12345654321";
		String spaceOutput=pyramidObject.numbers(6,6); //row_no=6; pyramid_count=6;
		assertEquals(expected,spaceOutput);
	}
	
	@Test
	public void numbersTestFail(){
		Question1_Pyramid pyramidObject = new Question1_Pyramid();
		String expected="123451234";
		String spaceOutput=pyramidObject.numbers(5,6); //row_no=5; pyramid_count=6;
		assertNotEquals(expected,spaceOutput);
	}	
}
