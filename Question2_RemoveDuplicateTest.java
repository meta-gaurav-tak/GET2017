import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
public class Question2_RemoveDuplicateTest {
	@Test
	public void removeDupTestSimple(){
		Question2_RemoveDuplicate removeDupObject=new Question2_RemoveDuplicate();
		int[] input={1,2,3,4,3,9,7,6,2,89,45,1};
		int[] expected={1,2,3,4,9,7,6,89,45};
		int[] output=removeDupObject.removeDuplicate(input);
		assertArrayEquals("Duplicates are Removed",expected,output);
	}
	@Test
	public void removeDupTestAllDuplicate(){
		Question2_RemoveDuplicate removeDupObject=new Question2_RemoveDuplicate();
		int[] input={4,4,4,4};
		int[] expected={4};
		int[] output=removeDupObject.removeDuplicate(input);
		assertArrayEquals("Duplicates are Removed",expected,output);
	}
	@Test
	public void removeDupTestNoDuplicate(){
		Question2_RemoveDuplicate removeDupObject=new Question2_RemoveDuplicate();
		int[] input={1,2,3,4,9,7,6,89,45};
		int[] expected={1,2,3,4,9,7,6,89,45};
		int[] output=removeDupObject.removeDuplicate(input);
		assertArrayEquals("No Duplicates",expected,output);
	}
	@Test
	public void removeDupTestFail(){
		Question2_RemoveDuplicate removeDupObject=new Question2_RemoveDuplicate();
		int[] input={1,2,3,4,3,9,7,6,2,89,45,1};
		int[] expected={1,2,3,4,9,3,7,6,89,45,1};
		int[] output=removeDupObject.removeDuplicate(input);
		assertArrayEquals("Duplicates Removal Failed",expected,output);
	}
}