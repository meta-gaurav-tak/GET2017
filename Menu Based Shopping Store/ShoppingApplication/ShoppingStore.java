package ShoppingApplication;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
/**
 * This class executes the billing terminal of shopping store
 * @author Gaurav Tak
 *
 */
public class ShoppingStore {
	public static String takeOrder() {
		ReadFile fileReader=new ReadFile();
		List<Product> productList=new ArrayList<Product>();
		List<ProductPromo> productPromoList=new ArrayList<ProductPromo>();
		List<OrderPromo> orderPromoList=new ArrayList<OrderPromo>();
		
		/*read productList file Line by Line and generate product Object for each line*/
		
		List<String> productListString=fileReader.readLineByLine(".\\src\\ProductList.csv");
		for(String product:productListString) {
			productList.add(ProductDaoImpl.generateProductObject(product));
		}
		
		/*generate a map to associate the product with productId*/
		
		Map<String,Product> productMap=new HashMap<String,Product>();
		for(Product product:productList) {
			productMap.put(product.getProductId(),product);
		}
	
		/*read producPromotionList file Line by Line and generate ProductPromo Object for each line*/
		
		List<String> productPromotionString=fileReader.readLineByLine(".\\src\\ProductPromo.csv");
		for(String promotion:productPromotionString) {
			productPromoList.add(ProductPromo.generatePromoObject(promotion));
		
		}
		
	
		/*read orderPromotionList file Line by Line and generate orderPromo Object for each line*/
		
		List<String> orderPromotionString=fileReader.readLineByLine(".\\src\\OrderPromo.csv");
		for(String promotion:orderPromotionString) {
			orderPromoList.add(OrderPromo.generatePromoObject(promotion));
		}
	
		/*to take order entries*/
		
		Scanner scannerObject=new Scanner(System.in);
		int numberOfProducts=-1;
		while(true) {											//loop until valid input
			System.out.print("Enter number of products you want to buy : ");
			try {
				numberOfProducts=scannerObject.nextInt();	
				if(numberOfProducts<=0) {					// handles case for an invalid number of product
					System.out.println("Enter positive number of products");
				} else {
					break;
				}
			} catch(InputMismatchException e) {
				System.out.println("Input mismatch:Enter a numeric value only ");
				scannerObject.next();  							// to avoid infinite loop; without this statement runs infinte
			}
		}								
		
		
		/*creating Order Entry Objects with each iteration for an order*/
		
		OrderEntry[] order=new OrderEntry[numberOfProducts];
		String productId;
		int orderQuantity;
		for(int iterate=0;iterate<numberOfProducts;iterate++) {
			System.out.print("Enter the product id for Product to be bought : ");
			productId=scannerObject.next();
			while(!productMap.containsKey(productId)) {					// handles case for an invalid product id
				System.out.println("Enter a valid product id");
				productId=scannerObject.next();
			}
			
			while(true){                                                //loop until valid input
				System.out.print("Enter the quantity for product : ");
				try {
					orderQuantity=scannerObject.nextInt();
					if(orderQuantity<=0) {									//handles case for an invalid quantity
						System.out.println("Enter a valid quantity");
					} else {
						break;
					}
				} catch(InputMismatchException e) {
					System.out.println("Input mismatch:Enter a numeric value only ");
					scannerObject.next();								//to avoid infinite loop
				}
			}										
			order[iterate]=new OrderEntry(productId,orderQuantity);
		}
		
		return "Order processed Succesfully";
	}	
}
		
		

