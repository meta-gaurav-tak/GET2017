/**
 * This class is designed to check Sort Order of array
 * @author Gaurav Tak
 */
public class Question5_ArraySorted {
	/**
	 * This method checks the sorting order for a given array
	 * @param input
	 * @return flag value for sorting order - 0:unsorted,1:ascending,2:descending 
	 */
	public int sortOrder(int[] input) {
		int i=1;
		int flag=0;
		if(input[i-1]<=input[i]) {
			flag=1;
			for(i=2;i<input.length;i++) {
				if(input[i-1]>input[i]) {
					flag=0;
					break;
				}
			}
		} else {
			flag=2;
			for(i=2;i<input.length;i++) {
				if(input[i-1]<input[i]) {
					flag=0;
					break;
				}
			}
		}
		return flag;
	}
}
