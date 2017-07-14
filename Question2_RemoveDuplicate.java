import java.util.HashMap;
public class Question2_RemoveDuplicate {
	public int[] removeDuplicate(int[] input){
	    HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	    int mapCount=0; //keeps the no. of key-value pairs i.e., unique elements
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
