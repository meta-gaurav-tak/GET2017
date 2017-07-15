import java.util.HashMap;
/**
 * This class is designed to remove Duplicate elements from an array
 * @author Gaurav Tak
 *
 */
public class Question2_RemoveDuplicate {
	/**
	 * 
	 * @param input
	 * @return integer array that is free from duplicates
	 */
	public int[] removeDuplicate(int[] input) {
	    HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	    int mapCount=0;		//no. of key-value pairs i.e., unique elements
	    
	    for(int i = 0; i <input.length; i++){
	    	if(!map.containsValue(input[i])){
	    		map.put(mapCount,input[i]);
	    		mapCount++;
	    	}
	    }
	    
	    int[] duplicateLessArray= new int[mapCount];
	    for (int i=0;i<mapCount;i++) {
	        duplicateLessArray[i] = map.get(i);
	    }
	    
	    return duplicateLessArray;
	}
}
