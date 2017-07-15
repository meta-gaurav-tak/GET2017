import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
/**
 * This class is designed to test JoinArray class functionality
 * @author Gaurav Tak
 * 
 */
public class Question6_JoinArrayTest {
	@Test
	public void joinTestSimple() {
	Question6_JoinArray mergeArray=new Question6_JoinArray();
	int a[]={1,5,8,9};
	int b[]={2,4,10,12};
	int expected[]={1,2,4,5,8,9,10,12};
	int c[]=null;;
	int merged[]=mergeArray.join(a, a.length, b, b.length, c);
	assertArrayEquals(expected,merged);
	}
	
	@Test
	public void joinTestEmptyArray() {
	Question6_JoinArray mergeArray=new Question6_JoinArray();
	int a[]={};
	int b[]={2,4,10,12};
	int expected[]={2,4,10,12};
	int c[]=null;;
	int merged[]=mergeArray.join(a, a.length, b, b.length, c);
	assertArrayEquals(expected,merged);
	}
	
	@Test
	public void joinTestMergeArrayFailed() {
	Question6_JoinArray mergeArray=new Question6_JoinArray();
	int a[]={1,5,8};
	int b[]={2,4,10,12};
	int expected[]={1,5,8,2,4,10,12};
	int c[]=null;;
	int merged[]=mergeArray.join(a, a.length, b, b.length, c);
	assertArrayEquals(expected,merged);
	}
}
