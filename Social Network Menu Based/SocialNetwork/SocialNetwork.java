package SocialNetwork;

import java.util.ArrayList;
import java.util.List;

public class SocialNetwork {
	/**
	 * This method reads information from user file line by line
	 * generates entity objects corresponding to each line and adds them to list
	 */
	public static void readInformationFromFile() {
		ReadFile fileReader=new ReadFile();
		List<String> entityListString=fileReader.readLineByLine(".\\src\\userList.txt"); //read userdata file
		List<Entity> personList=new ArrayList<Entity>();
		List<Entity> organisationList=new ArrayList<Entity>();
		
		Person.setListOfPerson(personList);
		Organisation.setListOfOrganisation(organisationList);
		
		for(String entity:entityListString) {         //Tokenizing the string on basis of semicolon
			String[] tokenized=entity.split(";");
			
			if(tokenized[0].equals("Person")) {      //checking the type of entity and generating objects accordingly
				if(!Person.checkAlreadyExist(tokenized[1],tokenized[2])){          //check for already existing entry
					Person.getListOfPerson().add(Person.createPerson(tokenized));
				} else {
					System.out.println("Username : "+tokenized[1]+" and Email : "+tokenized[2]+" already exist");
				}
			} else if(tokenized[0].equals("Organisation")) {                       //check for already existing entry
				if(!Organisation.checkAlreadyExist(tokenized[1],tokenized[2])){
					Organisation.getListOfOrganisation().add(Organisation.createOrganisation(tokenized));
				} else {
					System.out.println("Username : "+tokenized[1]+" and Email : "+tokenized[2]+" already exist");
				}
			}
		}
	}
	
	/**
	 * this method is used to display the social network as a two way connection between nodes
	 */
	public static void showSocialNetwork() {
	    System.out.println("The social network connections that exist are: ");
		for(Connection connection:Graph.getConnectedEntities()) {     //iteratiing over connected nodes
			System.out.println(connection.getConnectionNode1().getUserName()+
					" <----> "+connection.getConnectionNode2().getUserName());
		}
	}
	
	/*
	 * 
	 */
	
}
