import java.util.Scanner;

import SocialNetwork.Connection;
import SocialNetwork.Entity;
/**
 * Action interface child class to add connection between entities
 * @author Gaurav Tak
 *
 */

public class AddConnection implements Action {
	@Override
	public void performAction() {
	    if(MainMenu.currentUser==null) {
            System.out.println("Login First to add connections ");
            return;
        }
		System.out.println("Enter the userName of the person you want to add [Case Sensitive] s");
		String connectionUserName=new Scanner(System.in).next();
		
		if(Entity.getEntityMap().containsKey(connectionUserName)){
		    /*call createConnetion with current login user and entered user*/
		Connection.createConnection(Entity.getEntityMap().get(MainMenu.currentUser.getUserName()),
				Entity.getEntityMap().get(connectionUserName));
		} else {
			System.out.println("Unsuccessful: enter a valid username for connection");
		}
	}
	
}
