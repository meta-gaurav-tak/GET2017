import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
/**
 * This class is designed to test the quicksort class functionality and correctness
 * @author Gaurav Tak
 *
 */
public class Question3_QuickSortTest {
	@Test
	public void SortArray(){
		Question3_QuickSort quickSortObject = new Question3_QuickSort();
		quickSortObject.setInputArray(new int[]{5,2,8,9,10,77,55,11});
		int[] arrayExpected = new int[]{2,5,8,9,10,11,55,77};
		quickSortObject.quickSort(0,quickSortObject.getInputArray().length-1);
		assertArrayEquals(arrayExpected,quickSortObject.getInputArray());
	}
	
	@Test
	public void SortEmptyArray(){
		Question3_QuickSort quickSortObject = new Question3_QuickSort();
		quickSortObject.setInputArray(new int[]{});
		int[] arrayExpected = new int[]{};
		quickSortObject.quickSort(0,quickSortObject.getInputArray().length-1);
		assertArrayEquals(arrayExpected,quickSortObject.getInputArray());
	}
	
	@Test
	public void SortDescendingArray(){
		Question3_QuickSort quickSortObject = new Question3_QuickSort();
		quickSortObject.setInputArray(new int[]{7,6,5,4,3,2,1});
		int[] arrayExpected = new int[]{1,2,3,4,5,6,7};
		quickSortObject.quickSort(0,quickSortObject.getInputArray().length-1);
		assertArrayEquals(arrayExpected,quickSortObject.getInputArray());
	}
	
	@Test
	public void SortAlreadyAscendingArray(){
		Question3_QuickSort quickSortObject = new Question3_QuickSort();
		quickSortObject.setInputArray(new int[]{1,2,3,4,5});
		int[] arrayExpected = new int[]{1,2,3,4,5};
		quickSortObject.quickSort(0,quickSortObject.getInputArray().length-1);
		assertArrayEquals(arrayExpected,quickSortObject.getInputArray());
	}
}