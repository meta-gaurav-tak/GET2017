import java.util.Arrays;
/**
 * This class is designed to Search an element in an array using recursive search approaches
 * @author Gaurav Tak
 *
 */
public class Question2_RecursiveSearch {
	/**
	 * This method is a linear search implementation using recursion
	 * @param input
	 * @param currentIndex
	 * @param elementToSearch
	 * @return index where the search element is found
	 */
	public int linearSearch(int input[],int currentIndex,int elementToSearch) {
		if (currentIndex<input.length) {											//check for current index overflow
			if(input[currentIndex]==elementToSearch) {
				return currentIndex;												//base case
			} else {
				return (linearSearch(input,currentIndex+1,elementToSearch));		//recursive call
			}
		} else {
			return -1;																//returns -1 if not found or array is empty		
		}
	}
	
	/**
	 * This method is a binary search implementation using recursion
	 * @param input
	 * @param startIndex gives the index of the subproblem's first element in the actual array 
	 * @param elementToSearch
	 * @return index where the element to be searched is found
	 */
	public int binarySearch(int input[],int startIndex,int elementToSearch) {
		if(input.length<=0) {
			return -1;						//return -1 if not found in any subproblem
		}
		int mid=input.length/2;				//mid denotes the middle index of current array in consideration
		if(input[mid]==elementToSearch) {
			return startIndex+mid;
		} else if(input[mid]>elementToSearch) {
			return binarySearch(Arrays.copyOfRange(input,0,mid),0,elementToSearch);
		} else {
			return binarySearch(Arrays.copyOfRange(input,mid+1,input.length),mid+1,elementToSearch);
		}
	}
}
