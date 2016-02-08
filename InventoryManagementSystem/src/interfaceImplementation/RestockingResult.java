package interfaceImplementation;

import interfaceImplementation.Item;

public class RestockingResult {
	
	private Item items;
	public RestockingResult(Item items)
	{
		this.items=items;
	}
	public RestockingResult()
	{
		
	}
	public Item getItems() {
		return items;
	}

}
