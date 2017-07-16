import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
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
}