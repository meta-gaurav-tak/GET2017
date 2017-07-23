import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * This class is designed to read survey inputs from participants and generate report files
 *  it it our Main class 
 * @author Gaurav Tak
 *
 */
public class Survey {
	private static Scanner scannerObject=new Scanner(System.in);	//define scanner object with system input
	private static int surveyCount=0;		//to store the total number of surveys submitted
	private static int percentageCount[];	//holds a count for each choice in single select
	/**
	 * Read the survey from the participant
	 * @return A concatenated string of responses submitted by the participant for each question
	 */
	public String getSurvey() {				
		surveyCount++;
		ReadQuestion filePath = new ReadQuestion("C:\\Users\\GRV\\workspace\\OOP2\\src\\QuestionDataFile.txt");
		List<Question> questionList=filePath.readQuestionLineByLine();
		/*call 
		 * Collections.sort(questionList)
		 * to sort the questionList on basis of question Statements
		 */
		//Collections.sort(questionList);
		String surveyResponse="";
		for(Question question:questionList) {
			System.out.print(question.getQuestionNumber()+" , ");
			System.out.print(question.getQuestionStatement()+" , ");
			System.out.print(question.getQuestionType()+" , ");
			for(int i=0;i<question.getChoices().length;i++) {
				System.out.print(question.getChoices()[i]+"/");
			}
			System.out.println();
			String answer="";
			if(question.getQuestionType().equals("Single-Select")) {
				answer=scannerObject.nextLine();
				if(!checkChoices(question.getChoices(),answer))  {
					System.out.println("Enter a valid option from the given choices");
					answer=scannerObject.nextLine();
				}
				for(int iterator=0;iterator<question.getChoices().length;iterator++) {
					if(answer.equals(question.getChoices()[iterator])) {
						percentageCount[iterator]++;
						System.out.println("this works fine");
					}
				}
			} else if(question.getQuestionType().equals("Multi-Select")) {
				answer=scannerObject.nextLine();
				if(!checkChoices(question.getChoices(),answer))  {
					System.out.println("Enter a valid option from the given choices");
					answer=scannerObject.nextLine();
				}
			} else if(question.getQuestionType().equals("Text")) {
				answer=scannerObject.nextLine();
			} else if(question.getQuestionType().equals("Number")) {
				answer=scannerObject.nextLine();
			}
			surveyResponse=surveyResponse+","+answer;
		}
		return surveyResponse;
	}
	
	public static void main(String args[]) {
		for(int i=0;i<1;i++) {
			Survey surveyObject=new Survey();
			Survey.writeSurveyResponse(surveyObject,"C:\\Users\\GRV\\workspace\\OOP2\\src\\Survey-Report.txt");
		}
		Survey.writeSingleSelect("C:\\Users\\GRV\\workspace\\OOP2\\src\\Single-Survey-Report.txt");
	}
	
	/**
	 * a method to check if the choice input is valid choice or not
	 * @param options an array of string holding the options
	 * @param answer the input answer
	 * @return	true if choice is valid
	 */
	public static boolean checkChoices(String[] options,String answer) {
		boolean flag=false;
		for(int iterator=0;iterator<options.length;iterator++) {
			if(answer.equals(options[iterator])) {
				flag=true;
				break;
			}
		}
		return flag;
	}
	
	/**
	 * a method to write the survey responses of participants to file 
	 * Report-a
	 * @param surveyObject the object that stores the survey information
	 * @param filePath the file to be written with survey responses received
	 */
	public static void writeSurveyResponse(Survey surveyObject,String filePath) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(
					new File(filePath)));
			bw.write("Participant"+surveyCount+surveyObject.getSurvey());
			bw.close();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	/**
	 * this method is used to write the percentage distribution of single select statement to a file
	 * @param filePath the file destination to write single select report
	 */
	public static void writeSingleSelect(String filePath) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(
					new File(filePath)));
			for(int i=0;i<percentageCount.length;i++) {
				bw.write((i+1)+":"+(percentageCount[i]/surveyCount)*100);		//here choice value should be used instead (i+1)
			}
			bw.close();
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
