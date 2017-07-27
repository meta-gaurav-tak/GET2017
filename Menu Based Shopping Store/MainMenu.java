import java.util.Iterator;
import java.util.List;
/**
 * this class defines the main menu for the menu and defines basic methods
 * @author Gaurav Tak
 *
 */
public class MainMenu {

	public static Menu createMenu() {
		
		Menu mainMenu=new Menu();			//a main menu object
		mainMenu.setDisplayName("Main Menu");
		
		MenuItem menuItemProduct=new ActionableMenuItem(new DisplayProductList());		// menu item that is action-able and displays product list 
		List<MenuItem> subMenu=mainMenu.getSubMenu();
		menuItemProduct.setDisplayName("1. Display Product List");
		subMenu.add(menuItemProduct);
		
		
		MenuItem menuItemPromo=new Menu();
		menuItemPromo.setDisplayName("2. Display Promotion List");
		subMenu.add(menuItemPromo);
		
		/*Creating submenu for Promo menu*/
		List<MenuItem> subPromoMenu=((Menu) menuItemPromo).getSubMenu();
		
		MenuItem menuItemOrderPromo=new ActionableMenuItem(new DisplayOrderPromoList());	// menu item that is action-able and displays OrderPromotion list
		menuItemOrderPromo.setDisplayName("1. Display Product Promotion List");
		subPromoMenu.add(menuItemOrderPromo);
		
		MenuItem menuItemProductPromo=new ActionableMenuItem(new DisplayProductPromoList());// menu item that is action-able and displays productPromotion list
		menuItemProductPromo.setDisplayName("2. Display Promotion List");
		subPromoMenu.add(menuItemProductPromo);
		/*End Of Promo Submenu*/
		
		
		MenuItem menuItemOrder=new ActionableMenuItem(new GiveOrder());						// menu item that is action-able and takes order from user
		menuItemOrder.setDisplayName("3. Order");
		subMenu.add(menuItemOrder);
		
		MenuItem menuItemExit=new ActionableMenuItem(new Exit());							// menu item that is action-able and exits program
		menuItemExit.setDisplayName("4. Exit");
		subMenu.add(menuItemExit);
		
		return mainMenu;	
	}
	
	/* to display a menu passed as argument*/
	public static void display(Menu menu){													
		
		Iterator<MenuItem> itr=menu.getSubMenu().iterator();
		System.out.println("###########  MENU  ############");
		
		while(itr.hasNext()){
			System.out.println(itr.next().getDisplayName());
		}
		
	}
	
	/* a method to display menu and perfornm actions on actionable menu  */
	public static void displayAndPerformAction(Menu menu){					
		display(menu);
		int choice=menu.getInput();
		MenuItem menuItem= menu.getSelection(choice);
		
		if(menuItem==null){
			
		displayAndPerformAction(menu);
		
		} else if(menuItem instanceof ActionableMenuItem){

		((ActionableMenuItem)menuItem).triggerAction();

		} else{
			
		displayAndPerformAction((Menu)menuItem);
		
		}	
	}
	
	/*Main function for initial call*/
	public static void main(String args[]) {
		
		Menu mainMenu=MainMenu.createMenu();
		
		while(true){						//display menu repetitively until exit is choosen
		MainMenu.displayAndPerformAction(mainMenu);
		}
		
	}
}
