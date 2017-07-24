import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/**
 * This class is defined to read questions from a file and display them
 * @author Gaurav Tak
 *
 */
public class ReadQuestion {
	
	private String fileSource;		//to store file source path for question file
	
	public ReadQuestion(String fileSource) {
		this.fileSource = fileSource;
	}
	
	//getters and setters
	public String getFileSource() {
		return fileSource;
	}

	public void setFileSource(String fileSource) {
		this.fileSource = fileSource;
	}
	/**
	 * this method reads the question file line by line and generates the question object instance
	 * @return a list of questions object
	 */
	public List<Question> readQuestionLineByLine() {
		List<Question> questions= new ArrayList<Question>();
		try {
			File file = new File(fileSource);
			if(file.exists()){
				FileInputStream fileReader = new FileInputStream(file);
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileReader));
				String line="";
				while ((line = bufferedReader.readLine()) != null) {
					questions.add(generateQuestion(line));
				}
				bufferedReader.close();
				fileReader.close();
			}
		}
		catch(IOException e) {
			e.getMessage();
		}
		return questions;
	}
	
	/**
	 * Parses each line into a proper formatted question
	 * @param line the single line string
	 * @return a question object corresponding to the line
	 */
	public Question generateQuestion(String line) {
		StringTokenizer questionParts=new StringTokenizer(line,",");
		String[] questionArguments=new String[questionParts.countTokens()];
		int argumentIndex=0;
		while(questionParts.hasMoreTokens()) {
			questionArguments[argumentIndex]=questionParts.nextToken();
			argumentIndex++;
		}
		Question question = new Question();
		question.setQuestionNumber(questionArguments[0]);
		question.setQuestionStatement(questionArguments[1]);
		question.setQuestionType(questionArguments[2]);
		if(questionArguments.length>3) {
			StringTokenizer choicesTokenizer = new StringTokenizer(questionArguments[3],"/");
			String[] choiceOptions=new String[choicesTokenizer.countTokens()];
			int choiceArgumentIndex=0;
			while(choicesTokenizer.hasMoreTokens()) {
				choiceOptions[choiceArgumentIndex] = choicesTokenizer.nextToken();
				choiceArgumentIndex++;
			}
			question.setChoices(choiceOptions);
		}
		return question;
	}
}
