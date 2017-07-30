import SocialNetwork.Entity;
import SocialNetwork.Organisation;
import SocialNetwork.Person;
/**
 * To print the summary of all the entities of Social Network application
 * @author Gaurav Tak
 *
 */

public class SummaryAll implements Action {

	@Override
	public void performAction() {
		for(Entity p:Person.getListOfPerson()) {
			System.out.println(p.showSummary());
		}
		for(Entity p:Organisation.getListOfOrganisation()) {
			System.out.println(p.showSummary());
		}
	}
	
}
