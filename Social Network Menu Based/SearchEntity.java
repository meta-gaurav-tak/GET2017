import java.util.List;
import java.util.Scanner;

import SocialNetwork.Entity;
/**
 * class that adds searching by name functionality to our application
 * @author Gaurav Tak
 *
 */

public class SearchEntity implements Action {

	@Override
	public void performAction() {
		System.out.println("Enter name to search");
		List<Entity> searchResults=Entity.searchByName(new Scanner(System.in).nextLine());
		for(Entity e:searchResults) {
			System.out.println(e.showSummary());
		}
	}	
}
