import java.util.ArrayList;
import java.util.List;

/**
 * Finds all the possible permutations of a string.
 * 
 * @author Gaurav Tak
 */
public class Question2_PermutationsOfString {
	/*
	 * Global list of string type is defined so as to fix the changes
	 * done in the list.
	 */
	List<String> possiblePermutations = new ArrayList<String>();

	/**
	 *
	 * @param inputString      the string to be permuted.
	 * @param startIndex       index value of first character.
	 * @param endIIndex        index value of last character.
	 * @return ArrayList<String> containing all the possible permutations of the input string.
	 */
	List<String> generatePermutations(String inputString, int startIndex, int endIIndex) {
		if (startIndex == endIIndex) {
			if (!possiblePermutations.contains(inputString)) {
				possiblePermutations.add(inputString);
			}
		} 
		else {
			for (int iterateIndex = startIndex; iterateIndex <= endIIndex; iterateIndex++) {
				inputString = swap(inputString, iterateIndex, startIndex);
				generatePermutations(inputString, startIndex + 1, endIIndex);
				inputString = swap(inputString,  startIndex, iterateIndex);		//backtrack step
			}
		}
		return possiblePermutations;
	}
	
	/**
	 * @param inputString    the string to be permuted.
	 * @param firstIndex     index value of first character.
	 * @param secondIndex    index value of second character.
	 * @return String after swapping the desired characters.
	 */
	public String swap(String inputString, int firstIndex, int secondIndex) {
		char[] characterArray = inputString.toCharArray();
		char temp = characterArray[firstIndex];
		characterArray[firstIndex] = characterArray[secondIndex];
		characterArray[secondIndex] = temp;
		return String.valueOf(characterArray);
	}
}
