package interfaceImplementation;

import interfaceImplementation.Item;

public class PickingResult {

	private Item items;
	
	public PickingResult(Item item)
	{
		this.items=item;
	}
	public PickingResult()
	{
		
	}
	public Item getItems() {
		return items;
	}

}
