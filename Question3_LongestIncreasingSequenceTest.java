import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
public class Question3_LongestIncreasingSequenceTest {
	@Test
	public void lisTestAllIncreasing(){
		Question3_LongestIncreasingSequence lisObject=new Question3_LongestIncreasingSequence();
		int[] input={1,2,3,4,5,6};
		int[] expected={1,2,3,4,5,6};
		int[] lis=lisObject.longestSequence(input);
		assertArrayEquals("Lis Is the array itself",expected,lis);
	}
	@Test
	public void lisTestAtEnd(){
		Question3_LongestIncreasingSequence lisObject=new Question3_LongestIncreasingSequence();
		int[] input={4,5,1,2,3,4,5,6};
		int[] expected={1,2,3,4,5,6};
		int[] lis=lisObject.longestSequence(input);
		assertArrayEquals("Lis is at the end",expected,lis);
	}
	@Test
	public void lisTestAtBegin(){
		Question3_LongestIncreasingSequence lisObject=new Question3_LongestIncreasingSequence();
		int[] input={1,2,3,4,5,6,0,2,4};
		int[] expected={1,2,3,4,5,6};
		int[] lis=lisObject.longestSequence(input);
		assertArrayEquals("Lis at the beginning",expected,lis);
	}
	@Test
	public void lisTestEqualLis(){
		Question3_LongestIncreasingSequence lisObject=new Question3_LongestIncreasingSequence();
		int[] input={1,2,3,4,5,6,1,4,6,9,11,13};
		int[] expected={1,2,3,4,5,6};
		int[] lis=lisObject.longestSequence(input);
		assertArrayEquals("gives the first LIS",expected,lis);
	}
	@Test
	public void lisTestFailCase(){
		Question3_LongestIncreasingSequence lisObject=new Question3_LongestIncreasingSequence();
		int[] input={1,2,3,4,5,6,9,11,4,3,5,7};
		int[] expected={3,5,7};
		int[] lis=lisObject.longestSequence(input);
		assertArrayEquals("Lis Is the array itself",expected,lis);
	}
}
