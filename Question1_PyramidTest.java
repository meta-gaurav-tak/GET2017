import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
/**
 * Test class for Pyramid
 * @author Gaurav Tak
 *
 */
public class Question1_PyramidTest {
	@Test
	public void printPyramidTest() {
		Question1_Pyramid pyramidObject = new Question1_Pyramid();
		String[] obtainedPyramid=pyramidObject.printPyramid(3);
		String[] expectedPyramid={"  1"," 121","12321"," 121","  1"};
		assertArrayEquals(expectedPyramid,obtainedPyramid);
	}
}
