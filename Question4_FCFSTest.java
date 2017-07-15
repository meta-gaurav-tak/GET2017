import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
/**
 * This class is designed to test the FCFS class generated schedule table for correctness 
 * @author Gaurav Tak
 *
 */
public class Question4_FCFSTest {
	@Test
	public void testFCFS_TableUnsortedArrival() {
		Question4_FCFS fcfsObject=new Question4_FCFS();
		int[] arrival_time={25,1,5,9};
		int[] job_size={5,12,7,2};
		int[][] expected={{1,25,0,25,29},{2,1,0,1,12},{3,5,8,13,19},{4,9,11,20,21}};
		int[][] output=fcfsObject.FCFS(arrival_time,job_size);
		isArrayEqual(expected,output);
	}
	
	@Test
	public void testFCFS_TableSortedArrival(){
		Question4_FCFS fcfsObject=new Question4_FCFS();
		int[] arrival_time={1,5,9,25};
		int[] job_size={12,7,2,5};
		int[][] expected={{1,1,0,1,12},{2,5,8,13,19},{3,9,11,20,21},{4,25,0,25,29}};
		int[][] output=fcfsObject.FCFS(arrival_time,job_size);
		isArrayEqual(expected,output);
	}
	
	@Test
	public void testFCFS_TableFailed(){
		Question4_FCFS fcfsObject=new Question4_FCFS();
		int[] arrival_time={1,5,9,25};
		int[] job_size={12,7,2,5};
		int[][] expected={{1,1,0,1,12},{2,5,8,13,19},{3,25,0,25,29},{4,9,11,20,21},};
		int[][] output=fcfsObject.FCFS(arrival_time,job_size);
		isArrayEqual(expected,output);
	}
	
	public void isArrayEqual(int expected[][],int output[][]){
		assertArrayEquals(expected,output);
	}
}
