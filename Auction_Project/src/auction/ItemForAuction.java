package auction;

public interface ItemForAuction {
	
	public boolean makeABid(double bitAmount, String email);
	public boolean makeABitInEuro(double bidAmountInEuro, String emal);
	public void sell();
	public void sell(double amount);
	public void cancelSale();
	public void showPrice();
	public void showPriceInEuro();
	public void showItemStatus();
	public double getSoldPrice();
	public void showSaleInfo();
}