import static org.junit.Assert.assertEquals;
import org.junit.Test;
/**
 * this is a test class for the recursive search class
 * @author Gaurav Tak
 *
 */
public class Question2_RecursiveSearchTest {
	@Test
	public void linearSearchTestNotFound(){
		Question2_RecursiveSearch object=new Question2_RecursiveSearch();
		int input[]= {2,5,8,9,10,77,55};
		int foundIndex=object.linearSearch(input,0,88);
		assertEquals(-1,foundIndex);
	}
	
	@Test
	public void linearSearchTestEmpty(){
		Question2_RecursiveSearch object=new Question2_RecursiveSearch();
		int input[]= {};
		int foundIndex=object.linearSearch(input,0,88);
		assertEquals(-1,foundIndex);
	}
	
	@Test
	public void linearSearchTest(){
		Question2_RecursiveSearch object=new Question2_RecursiveSearch();
		int input[]= {2,5,8,9,10,77,55,11};
		int foundIndex=object.linearSearch(input,0,77);
		assertEquals(5,foundIndex);
	}
	
	@Test
	public void binarySearchTestNotFound(){
		Question2_RecursiveSearch object=new Question2_RecursiveSearch();
		int input[]= {2,5,8,9,10,77,55};
		int foundIndex=object.binarySearch(input,0,88);
		assertEquals(-1,foundIndex);
	}
	
	@Test
	public void binarySearchTestRightSubProblem(){
		Question2_RecursiveSearch object=new Question2_RecursiveSearch();
		int input[]= {2,5,8,9,10,77,55};
		int foundIndex=object.binarySearch(input,0,77);
		assertEquals(5,foundIndex);
	}
	
	@Test
	public void binarySearchTestLeftSubProblem(){
		Question2_RecursiveSearch object=new Question2_RecursiveSearch();
		int input[]= {2,5,8,9,10,77,55};
		int foundIndex=object.binarySearch(input,0,5);
		assertEquals(1,foundIndex);
	}
	
	@Test
	public void binarySearchTestEmpty(){
		Question2_RecursiveSearch object=new Question2_RecursiveSearch();
		int input[]= {};
		int foundIndex=object.binarySearch(input,0,77);
		assertEquals(-1,foundIndex);
	}
}
