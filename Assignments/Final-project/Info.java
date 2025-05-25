public class Info
{
	private String chipsQuantity;
	private String drinksQuantity;
	private int totalPrice;
	
	public Info(String chipsQuantity, String drinksQuantity)
	{
		this.chipsQuantity = chipsQuantity;
		this.drinksQuantity = drinksQuantity;
	}
	
	public String getChipsQuantity(){return chipsQuantity;}
	public String getDrinksQuantity(){return drinksQuantity;}
	
	public int getTotalPrice()
	{
		if(chipsQuantity == null)
		{
			chipsQuantity = "0";
		}
		else if(drinksQuantity == null)
		{
			drinksQuantity = "0";
		}
		
		totalPrice = (Integer.parseInt(chipsQuantity)*10) + (Integer.parseInt(drinksQuantity)*25);
		
		return totalPrice;
	}
}