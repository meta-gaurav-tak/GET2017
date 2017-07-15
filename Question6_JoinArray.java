/**
 * This class is designed to merge to sorted arrays into a single sorted array 
 * @author Gaurav Tak
 *
 */
public class Question6_JoinArray {
	/**
	 * 
	 * @param a is the first array
	 * @param asize 
	 * @param b is the second array
	 * @param bsize
	 * @param c is the output array
	 * @return single sorted and merged array
	 */
	public int[] join(int a[],int asize,int b[],int bsize,int c[]){
		c=new int[asize+bsize];			//size of merged array=sum of sizes of both arrays
		int apointer,bpointer,cpointer;	//pointer to index of each arrays current element
		for(apointer=bpointer=cpointer=0;
				apointer<asize && bpointer<bsize && cpointer<c.length;) {
			/*adding smaller element to c*/ 
			if(a[apointer]<=b[bpointer]) {
				c[cpointer]=a[apointer];
				apointer++;
				cpointer++;
			} else {
				c[cpointer]=b[bpointer];
				bpointer++;
				cpointer++;
				}
				
			}
		/*if array a is completely added to c, add remaining elements of a to c*/ 
		if(apointer==asize) {
			for(;bpointer<bsize;bpointer++){
				c[cpointer]=b[bpointer];
				cpointer++;
			}
		} else {		/* if b is completely added to c, add remaining elements of a to c*/
			for(;apointer<asize;apointer++){
				c[cpointer]=a[apointer];
				cpointer++;
			}
		}
		return c;
	}
}
