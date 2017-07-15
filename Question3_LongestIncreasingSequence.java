import java.util.Arrays;
/**
 * This class is designed to find longest increasing sequence in an array
 * @author Gaurav Tak
 *
 */
public class Question3_LongestIncreasingSequence {
	/**
	 * This method finds the longest increasing sequence
	 * @param input
	 * @return Longest Incresing Sequence as integer array
	 */
	public int[] longestSequence(int input[]) {
		 int lis,start,next,lisLength=0,seqLength=0;
		 lis=0;		//index of the longest increasing sequence
		 start=0;	//the index of start of current increasing sequence
		 next=1;	//the index of next element of current element
		 for(int i=1;i<input.length;i++){
			 if(input[i-1]<input[i]){
				 next++;
			 }
			 else{
				 seqLength=next-start; 		//current increasing sequence length
				 if(seqLength>lisLength){
					 lis=start;				//longest increasing sequence length
					 lisLength=seqLength;	 
				 }
				 start=i;
				 next++;
			 }
		 }
		 /*check if the LIS exists at end of array*/
		 seqLength=next-start;
		 if(seqLength>lisLength){
			 lis=start;
			 lisLength=seqLength;	 
		 }
		 int lisArray[]=Arrays.copyOfRange(input,lis,lis+lisLength);
		 return lisArray;
	}
}
