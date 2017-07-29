import java.util.Scanner;

import SocialNetwork.Entity;
import SocialNetwork.Organisation;
import SocialNetwork.Person;
import SocialNetwork.SocialNetwork;
/**
 * Action interface child class to perform Login action
 * @author Gaurav Tak
 *
 */
public class Login implements Action {
	Scanner sc=new Scanner(System.in);
	
	@Override
	public void performAction() {
		boolean flag=false;
		if(MainMenu.currentUser!=null){
			System.out.println("Please Logout first");
			return;
		}
		System.out.println("Enter your userName");
		String userName=sc.next();
		if(flag=Entity.getEntityMap().containsKey(userName)) {
		
		if((Entity.getEntityMap()).get(userName) instanceof Person) {
			MainMenu.currentUser=(Person)Entity.getEntityMap().get(userName);
		} else {
			MainMenu.currentUser=(Organisation)Entity.getEntityMap().get(userName);
		}
		}
		
		/**logic 2*/
		
		/*for(Entity p:Person.getListOfPerson()) {
			if(userName.equals(p.getUserName())) {
				flag=true;
				MainMenu.currentUser=(Person)p;
			}
		}
		for(Entity p:Organisation.getListOfOrganisation()) {
			if(userName.equals(p.getUserName())) {
				flag=true;
				MainMenu.currentUser=(Organisation)p;
			}
		}*/
		
		if(flag) {
			System.out.println("Login Successful ");
		} else {
			System.out.println("Login Unsuccessful: enter valid username");
		}
	}
	
}
