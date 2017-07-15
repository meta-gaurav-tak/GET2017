import static org.junit.Assert.assertEquals;
import org.junit.Test;
/**
 * This class is designed to test the correctness of result from ArraySorted class
 * @author Gaurav Tak
 *
 */
public class Question5_ArraySortedTest {
	@Test
	public void testSortOrderAscending() {
		Question5_ArraySorted sortObject=new Question5_ArraySorted();
		int sortFlag=sortObject.sortOrder(new int[]{1,2,3,4,5,6,7,9,9,13});
		assertEquals(1,sortFlag);
	}
	
	@Test
	public void testSortOrderUnsorted() {
		Question5_ArraySorted sortObject=new Question5_ArraySorted();
		int sortFlag=sortObject.sortOrder(new int[]{1,2,4,4,19,6,7,2,9,13});
		assertEquals(0,sortFlag);
	}
	
	@Test
	public void testSortOrderDescending() {
		Question5_ArraySorted sortObject=new Question5_ArraySorted();
		int sortFlag=sortObject.sortOrder(new int[]{9,8,8,3,1});
		assertEquals(2,sortFlag);
	}
	
	@Test
	public void testSortOrderFailed() {
		Question5_ArraySorted sortObject=new Question5_ArraySorted();
		int sortFlag=sortObject.sortOrder(new int[]{9,8,8,3,1});
		assertEquals(0,sortFlag);
	}
}
