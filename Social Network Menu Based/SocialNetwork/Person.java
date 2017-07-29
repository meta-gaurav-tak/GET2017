package SocialNetwork;

import java.util.List;

public class Person extends Entity {
	private String dob;
	private String Gender;
	private String currentLocation;
	private String school;
	private String occupation;
	private String interests;
	private String phoneNumber;
	private static List<Entity> listOfPerson;
	
	public Person() {
        super();
    }

	public static List<Entity> getListOfPerson() {
		return listOfPerson;
	}
	public static void setListOfPerson(List<Entity> listOfPerson) {
		Person.listOfPerson = listOfPerson;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getInterests() {
		return interests;
	}
	public void setInterests(String interests) {
		this.interests = interests;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}
	
	/**
     * Method that checks if a entity corresponding to username and email provided already exists 
     * @param userName the inputted value for username to be checked
     * @param userEmail the inputted value for email to be checked
     * @return boolean true if the username or email is already taken
     */
	public static boolean checkAlreadyExist(String userName,String userEmail) {
		boolean flag=false;
		for(Entity p:getListOfPerson()) {
			if((p.getUserName().equalsIgnoreCase(userName) || p.getEmail().equalsIgnoreCase(userEmail))) {
				flag=true;
				break;
			}	
		}
		return flag;
	}
	
	/**
     * This method generates a Person object from String array of field values
     * the Person takes 11 data member values
     * @param organisationDetails the array of string holding the field values
     * @return the generated Person object
     */
	public static Person createPerson(String[] personDetails) {
		Person person=new Person();
		person.setEntityType(personDetails[0]);
		person.setNameOfEntity(personDetails[3]);
		person.setUserName(personDetails[1]);
		person.setEmail(personDetails[2]);
		person.setDob(personDetails[4]);
		person.setGender(personDetails[5]);
		person.setCurrentLocation(personDetails[6]);
		person.setSchool(personDetails[7]);
		person.setOccupation(personDetails[8]);
		person.setInterests(personDetails[9]);
		person.setPhoneNumber(personDetails[10]);
		
		return person;
	}
	
	/**
     * Overriden method of Entity
     * to return the summary string for a Person
     */
	@Override
	public String showSummary() {
		String summary="Summary for "+getNameOfEntity()+": SocialNetwork@"+getUserName()+" \n";
		summary+=getNameOfEntity()+" is a "+getOccupation()+".\nBorn on "+getDob()+".\nLives in "
		        +getCurrentLocation()+".\nHas interest in "+getInterests()+".\n";
		return summary;
	}
	
}
