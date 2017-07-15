import java.util.Arrays;
import java.util.HashMap;
/**
 * This class is designed to generate a FCFS schedule table for given jobs
 * @author Gaurav Tak
 *
 */
public class Question4_FCFS {
	/**
	 * 
	 * @param arrival_time
	 * @param job_size
	 * @return 2-Dimensional integer array corresponding to FCFS table entries
	 */
	public int[][] FCFS(int arrival_time[],int job_size[]) {
		int[][] output=new int[arrival_time.length][5];
		HashMap<Integer,Integer> arrivalTimeMap=new HashMap<Integer,Integer>();
		HashMap<Integer,Integer> jobSizeMap=new HashMap<Integer,Integer>();
		
		for(int i=0;i<arrival_time.length;i++){
			arrivalTimeMap.put(arrival_time[i],i);
			jobSizeMap.put(i,job_size[i]);
		}
		
		Arrays.sort(arrival_time);		//Sort the arrival time array in acending orderof arrival time
		for(int i=0;i<arrival_time.length;i++){
			output[i][0]=i+1;//job no.
			output[i][1]=arrival_time[i];//job arrival time
			/*reorder job_size array according to sorted arrival time*/
			job_size[i]=jobSizeMap.get(arrivalTimeMap.get(arrival_time[i]));
		}
		
		int start=1;
		for(int i=0;i<arrival_time.length;i++) {
			output[i][3]=Math.max(start,arrival_time[i]);//job start time
			output[i][4]=output[i][3]+job_size[i]-1;	//job finish time
			if(output[i][3]==arrival_time[i]) {
				output[i][2]=0; 						//job waiting time arrival post job completion
			}
			else{
				output[i][2]=start-arrival_time[i]; 	//job waiting time
			}
			start+=job_size[i];
		}
		
		int arrangedOutput[][]=new int[arrival_time.length][5]; //final FCFS schedule table
		
		/*Loop to arrange the jobs table according to the original job no.*/
		for(int i=0;i<job_size.length;i++) {
				arrangedOutput[arrivalTimeMap.get(arrival_time[i])]=output[i];
			}
		
		/*Loop to reassign the jobs original job no.*/
		for(int i=0;i<job_size.length;i++) {
				arrangedOutput[i][0]=i+1;
			}
		
		return arrangedOutput;	
	}
}
