package interfaceImplementation;

public class Item {
	
	public String productId="";
	public int location=-1, level=-1, highestLevel=-1,rol=-1;

	public Item(String productId, int location, int level, int highestLevel, int rol)
	{
		this.productId=productId;
		this.location=location;
		this.level=level;
		this.highestLevel=highestLevel;
		this.rol=rol;
	}
	public int removeAmount(int amount)
	{
		if((level-amount)<=0)
			return -1;
		if((level-amount)<=rol)
		{
			level-=amount;
			return 0;
		}
		level-=amount;
		return 1;
	}
	public int addAmount(int amount)
	{
		if((level+amount)>highestLevel)
		{
			return -1;
		}
		level+=amount;
		return 1;
	}
	
}
