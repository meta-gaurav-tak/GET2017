/**
 * This class is designed to convert a given binary no to equivalent octal value
 * @author Gaurav Tak
 *
 */
public class Question1_BinToOct {
	/**
	 * 
	 * @param n is assumed a sequence of bits
	 * @return octal value for binary n
	 */
	public int convertBinaryToOctal(int n) {
		int triad=0; //holds group of consecutive three bits
		String octalValue="";
		while(n>0) {
			triad=n%1000;
			octalValue=getOctalEquivalent(triad)+octalValue;
			n=n/1000;
		}
		return Integer.parseInt(octalValue);
	}
	/**
	 * 
	 * @param bin holds three-bit group
	 * @return octal equivalent for a three-bit group
	 */
	private int getOctalEquivalent(int bin) {
		int oct=0;
		switch(bin){
		case 0:
			oct=0;
			break;
		case 1:
			oct=1;
			break;
		case 10:
			oct=2;
			break;
		case 11:
			oct=3;
			break;
		case 100:
			oct=4;
			break;
		case 101:
			oct=5;
			break;
		case 110:
			oct=6;
			break;
		case 111:
			oct=7;
			break;
		default:
			break;
		}
		return oct;
	}
}
