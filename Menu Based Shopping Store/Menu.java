import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu extends MenuItem {
	
	private Menu parentMenu;		//stores the parent for Menu
	private List<MenuItem> subMenu=new ArrayList<MenuItem>();		
	private Scanner scan;			// scanner object to take input
	public Menu getParentMenu() {
		return parentMenu;
	}

	public void setParentMenu(Menu parentMenu) {
		this.parentMenu = parentMenu;
	}

	public List<MenuItem> getSubMenu() {
		return subMenu;
	}

	public void setSubMenu(List<MenuItem> list) {
		this.subMenu= list;
	}
	
	/**
	 * method is used to take input choice for menu from user 
	 * @return the choice value index(choice-1) in the option list 
	 */
	 int getInput() {
		 	scan= new Scanner(System.in);
			int choice=this.subMenu.size()+1;
			try {
			choice=scan.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("Error : enter valid choice");
				scan.nextLine();
			} 
			return choice-1;
		}
	 
	 /**
	  * this method is designed to get the selected menu item as per input choice 
	  * @param choice the choice input
	  * @return the menu item for selected choice
	  */
	 public MenuItem getSelection(int choice) {
		 
		 if(choice>=subMenu.size() || choice<0)
		  return null;

		 return subMenu.get(choice);
	}
}
