/**
 * This class is a access object implementation for Question
 * @author Gaurav Tak
 *
 */
public class Question implements Comparable<Question> {
	
	private String questionNumber;
	private String questionType;
	private String questionStatement;
	private String choices[];

	//getters and setters
	public String getQuestionNumber() {
		return questionNumber;
	}

	public void setQuestionNumber(String questionNumber) {
		this.questionNumber = questionNumber;
	}

	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	public String getQuestionStatement() {
		return questionStatement;
	}
	public void setQuestionStatement(String questionStatement) {
		this.questionStatement = questionStatement;
	}
	public String[] getChoices() {
		return choices;
	}
	public void setChoices(String[] choices) {
		this.choices = choices;
	}
	
	@Override
	public int compareTo(Question ques) {
		return this.questionStatement.compareTo(ques.getQuestionStatement());
	}
}
