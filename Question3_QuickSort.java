/**
 * this class is designed to sort an array using recursive QuickSort 
 * @author Gaurav Tak
 *
 */
public class Question3_QuickSort {
	private int[] arrayToSort;				//holds the input array which will be sorted
	
	/**
	 * setter method for input
	 * @param input
	 */
	public void setInputArray(int input[]) {
		this.arrayToSort=input;
	}
	
	/**
	 * getter method for input
	 * @return
	 */
	public int[] getInputArray() {
		return this.arrayToSort;
	}
	
	/**
	 * This method performs rearrangemnt of pivot element to its actual location in the sorted order 
	 * @param startIndex
	 * @param endIndex
	 * @return the index location of pivot in sorted order
	 */
	public int sortPartition(int startIndex,int endIndex) {
		int pivotIndex=startIndex;
		int leftIndexer=startIndex+1;
		int rightIndexer=endIndex;
		while(leftIndexer<rightIndexer)	{
			/*loop while find any element smaller than pivot is found*/
			while(arrayToSort[rightIndexer]>arrayToSort[pivotIndex] && rightIndexer>leftIndexer) {
				rightIndexer--;
			}
			/*loop while find any element greater than pivot is found*/
			while(arrayToSort[leftIndexer]<arrayToSort[pivotIndex] && rightIndexer>leftIndexer) {
				leftIndexer++;
			}
			/*swapping the right and left pointer elements*/
			if(rightIndexer>leftIndexer) {
				int temp=arrayToSort[leftIndexer];
				arrayToSort[leftIndexer]=arrayToSort[rightIndexer];
				arrayToSort[rightIndexer]=temp;
			}
		}
		/*Swapping to shift pivot to its correct location in sorted order*/
		if(arrayToSort[rightIndexer]<arrayToSort[pivotIndex]) {
			int temp=arrayToSort[rightIndexer];
			arrayToSort[rightIndexer]=arrayToSort[pivotIndex];
			arrayToSort[pivotIndex]=temp;
			pivotIndex=rightIndexer;
		}
		return pivotIndex;
	}
	/**
	 * This method is the divide and conquer approach of quicksort i.e.. recursive quicksort logic
	 * @param startIndex
	 * @param endIndex
	 */
	public void quickSort(int startIndex,int endIndex) {
		int pivotIndex;
		if(startIndex>=endIndex) {
			return;
		} else {
			pivotIndex=sortPartition(startIndex,endIndex);
			quickSort(startIndex,pivotIndex-1);	// Recursively call quick sort with left part of the partitioned array
			quickSort(pivotIndex+1,endIndex);	// Recursively call quick sort with right part of the partitioned array
		}
	}
}
