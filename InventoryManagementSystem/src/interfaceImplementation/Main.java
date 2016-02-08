package interfaceImplementation;

import java.util.Scanner;

public class Main {
	/**
	 * Main class from where the execution begins.
	 */
	private static ImsClass product = new ImsClass();
	public static void main(String args[])
	{
		instantiate(product);
		int choice=0;
		while (choice != 5) {
			Scanner in = new Scanner(System.in);
			System.out.println("Please pick an option");
			System.out.println("1 = Picking out an item");
			System.out.println("2 = Restocking out an item");
			System.out.println("3 = Add a Product");
			System.out.println("4 = View an item");
			System.out.println("5 = Exit system");
			choice = Integer.parseInt(in.nextLine());
			executor(choice, in);
	}
}
	/**
	 * This function implements the funcnalities of the all the choices the user can enter.
	 * @param choice Choice value entered by the user
	 * @param sc 
	 */
	public static void executor(int choice, Scanner sc)
	{
		String productId="";int result=-2, quantity=0;
		switch(choice)
		{
		case 1:	
				PickingResult pr= new PickingResult();
				System.out.println("Please Enter the productId: ");
				productId=sc.nextLine();
				productId="abc123";
				result= product.checkProductExsist(productId);
				if(result==1)
				{
					product.viewItem(productId);
					System.out.println("\nPlease Enter the quantity needed: ");
					quantity=sc.nextInt();
					pr=product.pickProduct(productId, quantity);
					product.viewItem(productId);
				}
				else
					System.out.println("Invalid ProductId");
				break;
		case 2: 
				RestockingResult rs= new RestockingResult();
				System.out.println("Please Enter the productId: ");
				productId=sc.nextLine();
				result= product.checkProductExsist(productId);
				if(result==1)
				{
					System.out.println("Please Enter the amount to be restocked");
					quantity= sc.nextInt();
					rs=product.restockProduct(productId, quantity);
				}
				else
					System.out.println("Invalid ProductId");
				break;
		case 3:
				String newProductId;int location=-1, level=-1, highestLevel=-1,rol=-1;
				System.out.println("Please enter the productId: ");
				newProductId=sc.next();
				result=product.checkProductExsist(newProductId);
				if(result==1)
				{
					System.out.println("Please enter the quantity to restock: ");
					quantity=sc.nextInt();
					rs=product.restockProduct(newProductId, quantity);
					break;
				}
				System.out.println("Enter the location of the product");
				location=sc.nextInt();
				System.out.println("Enter the current level of the product");
				level=sc.nextInt();
				System.out.println("Enter the highest level of this item and rol consecutively");
				highestLevel=sc.nextInt();
				rol=sc.nextInt();
				if(highestLevel<rol || highestLevel<level)
				{
					System.out.println("The current quantity of the product cannot be higher than the max quantity of the same.");
					break;
				}
				Item newItem= new Item(newProductId,location,level,highestLevel,rol);
				product.addItem(newItem);
				break;
		case 4:
				System.out.println("Please Enter the productId:");
				productId=sc.nextLine();
				product.viewItem(productId);
				break;
		case 5:
					System.out.println("Thank you!");
		}
	}
	/**
	 * To get a kick start 3 objects are instantiated here. 
	 * @param product Object of the class ImsClass
	 */
	public static void instantiate(ImsClass product)
	{
		
		String newProductId;int location=-1, level=-1, highestLevel=-1,rol=-1;
		
		newProductId="abc123";location=10;level=50;highestLevel=100;rol=30;
		Item newItem= new Item(newProductId,location,level,highestLevel,rol);
		product.addItem(newItem);
		
		newProductId="abc456";location=20;level=80;highestLevel=200;rol=80;
		Item newitem=new Item(newProductId,location,level,highestLevel,rol);
		product.addItem(newitem);
		
		newProductId="abc789";location=30;level=10;highestLevel=30;rol=22;
		Item prod=new Item(newProductId,location,level,highestLevel,rol);
		product.addItem(prod);
		
	}

}
