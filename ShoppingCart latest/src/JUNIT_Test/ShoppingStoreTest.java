package JUNIT_Test;
import org.junit.*;

import static org.junit.Assert.assertEquals;

import com.metacube.ShoppingCart.Controller.ShoppingStoreController;
import com.metacube.ShoppingCart.Enumerations.Status;
import com.metacube.ShoppingCart.Facade.FacadeFactory;
import com.metacube.ShoppingCart.Facade.ProductFacade;
import com.metacube.ShoppingCart.TO.CartEntry;

public class ShoppingStoreTest {
    private CartEntry cartEntry;
    private ProductFacade productOperations;
    @Before
    public void setupProduct(){
        productOperations=FacadeFactory.getProductFacadeDaoInstance();
        productOperations.readProductsFromFile();
    }
    @Before
    public void generateCartEntry(){
    cartEntry=new CartEntry();
    cartEntry.setProductId("1003");
    cartEntry.setQuantity(7);
    cartEntry.setEntryNumber(1);
    }
    @Test
    public void addToCartTestSuccess(){
       Status status= ShoppingStoreController.addProductCart(cartEntry);
       assertEquals(Status.SUCCESS_ADDTOCART,status);
    }
    @Test
    public void addToCartFailInvalidCart(){
        Status status=ShoppingStoreController.addProductCart(new CartEntry());
        assertEquals(Status.INVALID_CARTENTRY,status);
    }
    @Test
    public void addToCartTestSuccessSameItemTwice(){
       Status status= ShoppingStoreController.addProductCart(cartEntry);
       status= ShoppingStoreController.addProductCart(cartEntry);
       assertEquals(Status.SUCCESS_ADDTOCART,status);
    }
    @Test
    public void removeFromCartTest(){
        ShoppingStoreController.addProductCart(cartEntry);
        Status status=ShoppingStoreController.removeProductCart(cartEntry);
        assertEquals(Status.SUCCESS_REMOVECART,status); 
    }
    @Test
    public void removeFromCartTestFailure(){
    	cartEntry.setProductId("1006");
        Status status=ShoppingStoreController.removeProductCart(cartEntry);
        assertEquals(Status.FAILURE_REMOVECART,status); 
    }
    @Test
    public void emptyCartDisplayTest(){
        String status=ShoppingStoreController.displayCart();
        assertEquals(Status.CART_EMPTY+"",status);
    }
}