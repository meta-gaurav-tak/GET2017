import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Question1_TowerOfHanoiTest {

	@Test
	public void testForSingleDisk() {

		Question1_TowerOfHanoi object = new Question1_TowerOfHanoi();
		List<String> expected = new ArrayList<String>();

		expected.add("Move Disk 1 from A to B");

		List<String> actual = object.towerOfHanoiUtil("A", "B", "C", 1);
		assertEquals(expected, actual);

	}
	
	@Test
	public void testForNegativeDiskInvalid() {

		Question1_TowerOfHanoi object = new Question1_TowerOfHanoi();
		try {
		object.towerOfHanoiUtil("A", "B", "C",-1);
		}
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testForNull() {

		Question1_TowerOfHanoi object = new Question1_TowerOfHanoi();
		try {
			object.towerOfHanoiUtil("A", null,"C", 1);
		}
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testForZeroDisk() {

		Question1_TowerOfHanoi object = new Question1_TowerOfHanoi();
		List<String> expected = new ArrayList<String>();
		List<String> actual = object.towerOfHanoiUtil("A", "B", "C", 0);
		assertEquals(expected, actual);

	}
	
	@Test
	public void testFor2Disks() {

		Question1_TowerOfHanoi object = new Question1_TowerOfHanoi();
		List<String> expected = new ArrayList<String>();

		expected.add("Move Disk 2 from A to C");
		expected.add("Move Disk 1 from A to B");
		expected.add("Move Disk 2 from C to B");

		List<String> actual = object.towerOfHanoiUtil("A", "B", "C", 2);
		assertEquals(expected, actual);
	}

	@Test
	public void testFor3Disks() {

		Question1_TowerOfHanoi object = new Question1_TowerOfHanoi();
		List<String> expected = new ArrayList<String>();

		expected.add("Move Disk 3 from A to B");
		expected.add("Move Disk 2 from A to C");
		expected.add("Move Disk 3 from B to C");
		expected.add("Move Disk 1 from A to B");
		expected.add("Move Disk 3 from C to A");
		expected.add("Move Disk 2 from C to B");
		expected.add("Move Disk 3 from A to B");

		List<String> actual = object.towerOfHanoiUtil("A", "B", "C", 3);
		assertEquals(expected, actual);

	}

}
