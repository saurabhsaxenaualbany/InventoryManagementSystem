package interfaceImplementation;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * @author saurabh
 * This class implements the IMS interface provided in the question. 
 * 
 * ConcurrentHashMap is used here which implicitly implements multi-threading.
 * This data Structure has a good performance over HashMap where in multi-threading 
 * had to be explicitly implemented. Though that is also a way to implement. 
 */
public class ImsClass implements InventoryManagementSystem{

	private Map<String,Item> product = null;
	public ImsClass()
	{
		this.product= new ConcurrentHashMap<String,Item>();
	}
	public void addItem(Item newItem)
	{
		product.put(newItem.productId, newItem);
	}
	public void getItem(String pid)
	{
		product.get(pid);
	}
	public void viewItem(String pid)
	{
		Item tempProduct = product.get(pid);
		System.out.println("The product: "+pid+" has quantity of : "+tempProduct.level+" located at: "+ tempProduct.location);
	}
	public int checkProductExsist(String pid)
	{
		if(product.containsKey(pid))
			return 1;
		else
			return 0;
		
	}
	public PickingResult pickProduct(String productId, int amountToPick)
	{
		Item tempProduct = product.get(productId);
		int result=-2;
		result=tempProduct.removeAmount(amountToPick);
		switch(result)
		{
		case -1: System.out.println("Please view the product details. Not Enough product available");
					break;
		case 1:	System.out.println("Product Succesfully depleted.");
					break;
		case 0: System.out.println("Warning!! Product quantity dropped below rol");
		}
		PickingResult pickedresult= new PickingResult(tempProduct);
		return pickedresult;
	}
	public RestockingResult restockProduct(String productId, int amountToRestock)
	{
		Item tempProduct= product.get(productId);
		int result=-2;
		result= tempProduct.addAmount(amountToRestock);
		switch(result)
		{
		case -1:	System.out.println("Quantity going higher than maximum quantity level. Please try again!");
					break;
		case 1: 	System.out.println("Product quantity added successfully");
		}
		RestockingResult restockedresult= new RestockingResult(tempProduct);
		return restockedresult;
	}
	
}