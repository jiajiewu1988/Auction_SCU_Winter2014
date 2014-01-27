package auction;

/**
 * 
 */

import java.util.Date;

public class AuctionItem extends SaleItem implements ItemForAuction {
	
	
	public AuctionItem(String itemName, double price, double minbid) {
		super(itemName, price);
		
	}
	
	public AuctionItem(String itemName, double price) {
		super(itemName, price);
	}

	@Override
	public boolean makeABid(double bitAmount, String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean makeABitInEuro(double bidAmountInEuro, String emal) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void sell(double amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelSale() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showPrice() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showPriceInEuro() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getSoldPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void showSaleInfo() {
		// TODO Auto-generated method stub
		
	}
	
	class AuctionBid {
		private Money bidAmount;
		private Money MINBID;
		private String bidderEmail;
		private Date bidDate;
		
		public AuctionBid(double amount) {
			MINBID = new Money(amount);
		}
		
		public void showBidStatus() {
			System.out.println("bid amount is " + bidAmount);
			System.out.println("minbid is " + MINBID);
			System.out.println("bidderEmail is " + bidderEmail);
			
			//Show Bid Date
		}
		
		public void clear() {
			MINBID.setAmount(0.0);
			bidAmount = null;
			bidderEmail = null;
			bidDate = null;
		}
	}
}
