import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
/**
 * this is a test class of permutations of string class
 * @author Gaurav Tak
 *
 */
public class Question2_TestPermutationsOfString {

	// Object declaration of PermutationsOfString class
		Question2_PermutationsOfString permutaionsObject = new Question2_PermutationsOfString();

		@Test
		public void permutationsOfStringTest1() {
			List<String> permutations = permutaionsObject.generatePermutations("ABC",0,2);
	        List<String> actualPermutations = Arrays.asList ( "ABC", "ACB", "BAC", "BCA",
	        		"CBA", "CAB" );
			// Compares expected and actual permutations of the string.
			assertThat(permutations, is(actualPermutations));
		}
		
		@Test
		public void permutationsOfStringTest2() {
			List<String> permutations = permutaionsObject.generatePermutations("ABCD",0,3);
	        List<String> actualPermutations = Arrays.asList ( "ABCD", "ABDC", "ACBD",
	        		"ACDB", "ADCB", "ADBC", "BACD", "BADC", "BCAD", "BCDA", "BDCA",
	        		"BDAC", "CBAD", "CBDA", "CABD", "CADB", "CDAB", "CDBA", "DBCA", 
	        		"DBAC", "DCBA", "DCAB", "DACB", "DABC" );
			// Compares expected and actual permutations of the string.
			assertThat(permutations, is(actualPermutations));
		}
	
		@Test
		public void permutationsOfStringTest3() {
			List<String> permutations = permutaionsObject.generatePermutations("AAB",0,2);
	        List<String> actualPermutations = Arrays.asList ( "AAB", "ABA", "BAA" );
			// Compares expected and actual permutations of the string.
			assertThat(permutations, is(actualPermutations));
		}
}
