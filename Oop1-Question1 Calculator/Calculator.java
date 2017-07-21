/**
 * This class is designed to execute the actual calculator functionality
 * @author Gaurav Tak
 *
 */
public class Calculator {
	private double operandFirst;
	private double operandSecond;
	private char operator;
	
	//setter methods
	public void setOperandFirst() {	
	}
	
	public void setOperandSecond() {	
	}
	
	public void setOperator() {	
	}
	
	//getter methods
	public double getOperandFirst() {	
	}
	
	public double getOperandSecond() {	
	}
	
	public double getOperator() {	
	}
	
	public void extractInput() {
		//extracts operands and operators from button inputs 
	}
	
	/**
	 * Calls execute of operatuion class
	 * @return the calculated output
	 */
	public double calculate() {
		//method that calls operation with passing operands;
	}
	
	/**
	 * generate an expression string from operand and operators
	 * @return the string of the expression in consideration
	 */
	public String generateExpession() {
		//generate an expression string from operand and operators
	}
	
	/**
	 * Method to call the display utility to print
	 * @param expression the string expression to be sent to display
	 * @param display gives the display object to which the string is to be sent
	 */
	public void sendToDisplay(String expression,Display display) {
		//logic to send an output string to display
	}
}
