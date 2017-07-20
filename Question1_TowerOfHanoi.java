import java.util.ArrayList;
import java.util.List;
/**
 * This class is designed to solve the tower of hanoi problem
 * @author Gaurav Tak
 *
 */
public class Question1_TowerOfHanoi {
	
	private int totalNumberOfDisk;				// stores the the total no. of disks in the actually called problem
	private List<String> movementList = new ArrayList<String>();
	/**
	 * this method breaks the problem into subproblems and prints the move to be made 
	 * @param source
	 * @param destination
	 * @param auxiliary
	 * @param numOfDisk 
	 * @return the list of movements for disks
	 * @throws IllegalArgumentException
	 */
	List<String> towerOfHanoi(String source, String destination, String auxiliary,int numOfDisk) throws IllegalArgumentException {
		
		if (source==null || destination==null || auxiliary==null || numOfDisk<0 ) {
			
			throw new IllegalArgumentException("One or more argument is inalid or null");
			
		}
		
		if (numOfDisk == 0) {			// no disk 
			
			return movementList;

		}
		
		if (numOfDisk == 1) {			//Base Case
			movementList.add("Move Disk " + (totalNumberOfDisk - numOfDisk + 1)
					+ " from " + source + " to " + destination);
			
			return movementList;
		}

		towerOfHanoi(source, auxiliary, destination, numOfDisk - 1);
		movementList.add("Move Disk " + (totalNumberOfDisk - numOfDisk + 1)
					+ " from " + source + " to " + destination);
		towerOfHanoi(auxiliary, destination, source, numOfDisk - 1);

		return movementList;
	}
	/**
	 * This is a utility function that sets total no. of disk for actual tower of hanoi 
	 * @param source
	 * @param destination
	 * @param auxiliary
	 * @param numOfDisk
	 * @return the final movement's list of strings
	 */
	List<String> towerOfHanoiUtil(String source, String destination,
			String auxiliary, int numOfDisk) {

		totalNumberOfDisk = numOfDisk;
		towerOfHanoi(source, destination, auxiliary, numOfDisk);

		return movementList;
	}

	public static void main(String args[]) {
		Question1_TowerOfHanoi object = new Question1_TowerOfHanoi();
		for (String s : object.towerOfHanoiUtil("A", "B", "C", 3)) {
			System.out.println(s);

		}
	}
}
