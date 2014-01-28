package auction;

public interface ItemForAuction {
	
	public boolean makeABid(double bidAmount, String email);
	public boolean makeABitInEuro(double bidAmountInEuro, String email);
	public void sell();
	public void sell(double amount);
	public void cancelSale();
	public void showPrice();
	public void showPriceInEuro();
	public void showItemStatus();
	public double getSoldPrice();
	public void showSaleInfo();
	public String getStatus();
}
