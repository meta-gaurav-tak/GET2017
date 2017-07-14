import java.util.Arrays;
public class Question3_LongestIncreasingSequence {
 public int[] longestSequence(int input[]){
	 int lis,start,next,lisLength=0,seqLength=0;
	 lis=start=0;
	 next=1;
	 for(int i=1;i<input.length;i++){
		 if(input[i-1]<input[i]){
			 next++;
		 }
		 else{
			 seqLength=next-start;
			 if(seqLength>lisLength){
				 lis=start;
				 lisLength=seqLength;
				 
			 }
			 start=i;
			 next++;
		 }
	 }
	 seqLength=next-start;
	 if(seqLength>lisLength){
		 lis=start;
		 lisLength=seqLength;	 
	 }
	 int lisArray[]=Arrays.copyOfRange(input,lis,lis+lisLength);
	 return lisArray;
 }
}
