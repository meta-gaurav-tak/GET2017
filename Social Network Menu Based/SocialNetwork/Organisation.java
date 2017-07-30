package SocialNetwork;

import java.util.List;


public class Organisation extends Entity{
	private String dateOfFoundation;       
	private String Founder;                
	private String headquarterLocation;
	private String workDomain;
	private String areaOfConcern;
	private String primaryPhoneNumber;
	
	private static List<Entity> listOfOrganisation;
	
	public Organisation() {
        super();
    }
	
	public static List<Entity> getListOfOrganisation() {
		return listOfOrganisation;
	}
	public static void setListOfOrganisation(List<Entity> listOfOrganisation) {
		Organisation.listOfOrganisation = listOfOrganisation;
	}
	public String getDateOfFoundation() {
		return dateOfFoundation;
	}
	public void setDateOfFoundation(String dateOfFoundation) {
		this.dateOfFoundation = dateOfFoundation;
	}
	public String getFounder() {
		return Founder;
	}
	public void setFounder(String founder) {
		Founder = founder;
	}
	public String getHeadquarterLocation() {
		return headquarterLocation;
	}
	public void setHeadquarterLocation(String headquarterLocation) {
		this.headquarterLocation = headquarterLocation;
	}
	public String getWorkDomain() {
		return workDomain;
	}
	public void setWorkDomain(String workDomain) {
		this.workDomain = workDomain;
	}
	public String getAreaOfConcern() {
		return areaOfConcern;
	}
	public void setAreaOfConcern(String areaOfConcern) {
		this.areaOfConcern = areaOfConcern;
	}
	public String getPrimaryPhoneNumber() {
		return primaryPhoneNumber;
	}
	public void setPrimaryPhoneNumber(String primaryPhoneNumber) {
		this.primaryPhoneNumber = primaryPhoneNumber;
	}
	/**
	 * Method that checks if a entity correspong to username and email provided already exists 
	 * @param userName the inputted value for username to be checked
	 * @param userEmail the inputted value for uemail to be checked
	 * @return boolean true if the username or email is already taken
	 */
	public static boolean checkAlreadyExist(String userName,String userEmail) {
		boolean flag=false;
		for(Entity p:getListOfOrganisation()) {
			if((p.getUserName().equalsIgnoreCase(userName) || p.getEmail().equalsIgnoreCase(userEmail))) {
				flag=true;
				break;
			}	
		}
		return flag;
	}
	
	/**
	 * This method generates a Organisation object from String array of field values
	 * the organisation takes 10 data member values
	 * @param organisationDetails the array of string holding the field values
	 * @return the generated Organisation object
	 */
	public static Organisation createOrganisation(String[] organisationDetails) {
		//System.out.println(organisationDetails.length);
		Organisation organisation = new Organisation();
		 {
		organisation.setEntityType(organisationDetails[0]);
		organisation.setUserName(organisationDetails[1]);
		organisation.setEmail(organisationDetails[2]);
		organisation.setNameOfEntity(organisationDetails[3]);
		organisation.setDateOfFoundation(organisationDetails[4]);
		organisation.setFounder(organisationDetails[5]);
		organisation.setHeadquarterLocation(organisationDetails[6]);
		organisation.setWorkDomain(organisationDetails[7]);
		organisation.setAreaOfConcern(organisationDetails[8]);
		organisation.setPrimaryPhoneNumber(organisationDetails[9]);
		}
		return organisation;
	}
	
	/**
	 * Overriden method of Entity
	 * to return the summary string for an organization
	 */
	@Override
	public String showSummary() {
		String summary;
		summary="Summary for "+getNameOfEntity()+":SocialNetwork@"+getUserName()+" \n";
		summary+=getNameOfEntity()+" works on "+getWorkDomain()+".\nWas founded on "
		        +getDateOfFoundation()+" by "+getFounder()+
				".\nIts concern lies over  "+getAreaOfConcern()
				+".\nIt is headquartered at "+getHeadquarterLocation()+".\n";
		return summary;
	}
}
