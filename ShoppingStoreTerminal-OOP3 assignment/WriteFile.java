import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * A class to write String to a file
 * @author Gaurav Tak
 *
 */
public class WriteFile {
	
	/*a method to write a string to a file*/
	
	public static void write(String stringToWrite,String destinationFile) {
		int fileCounter=0;
		try {
			clearRecord(destinationFile);
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File(destinationFile), true));
			bw.write(stringToWrite);
			bw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Billing File Not Found or UnAccesible:Printing to a different File: New"+(fileCounter++)+destinationFile);
			WriteFile.write(stringToWrite,"New"+(fileCounter++)+destinationFile);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void clearRecord(String destinationFile) {
		PrintWriter writer;
		try {
			writer = new PrintWriter(destinationFile);
			writer.print("");
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Billing File Not Found or UnAccesible:Print to a different File");
		}
	}
}
