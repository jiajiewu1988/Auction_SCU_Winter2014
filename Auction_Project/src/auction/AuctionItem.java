package auction;

/**
 * 
 */

import java.util.Date;

public class AuctionItem extends SaleItem implements ItemForAuction {
	
	//Data Members
	private AuctionBid currentBid;
	private Money soldPrice;
	private String buyerInfo;
	
	/**
	 * Constructor to initialize all data members.
	 * @param itemName name of item
	 * @param price price of item
	 * @param minbid initialize currentBid with the parameter minbid
	 */
	public AuctionItem(String itemName, double price, double minbid) {
		super(itemName, price);
		currentBid = new AuctionBid(minbid);
		currentBid.setBidAmount(null);
		currentBid.setBidderEmail(null);
		currentBid.setBidDate(null);
	}
	
	public AuctionItem(String itemName, double price) {
		super(itemName, price);
	}

	@Override
	public boolean makeABid(double bidAmount, String email) {
		if (currentBid.getBidAmount() == null) {
			currentBid.setBidAmount(new Money(0));
		}
		
		if (bidAmount >= currentBid.getMINBID().getAmount() && bidAmount > currentBid.getBidAmount().getAmount()) {
			currentBid.getBidAmount().setAmount(bidAmount);
			currentBid.setBidderEmail(email);
			currentBid.setBidDate(new Date());
			return true;
		}
		
		return false;
	}

	@Override
	public boolean makeABitInEuro(double bidAmountInEuro, String email) {
		if (currentBid.getBidAmount() == null) {
			currentBid.setBidAmount(new Money(0));
		}
		
		double currentBidAmountInEuro = currentBid.getBidAmount().getAmountInEuro();
		double currentMINBIDInEuro = currentBid.getMINBID().getAmountInEuro();
		if (bidAmountInEuro >= currentMINBIDInEuro && bidAmountInEuro > currentBidAmountInEuro) {
			currentBid.getBidAmount().setAmount(bidAmountInEuro);
			currentBid.setBidderEmail(email);
			currentBid.setBidDate(new Date());
			return true;
		}
		
		return false;
	}

	@Override
	public void sell(double amount) {
		if (this.getStatus().equalsIgnoreCase("SOLD")) {
			System.out.println("The Item: " + this.getItemName() + "is not available");
			System.out.println("Sold Price: " + this.getSoldPrice());
		} else {
			this.setStatus("SOLD");
			this.soldPrice.setAmount(currentBid.getBidAmount().getAmount());
			try {
				buyerInfo = currentBid.getBidderEmail();
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.setDateSold(new Date());
			System.out.println("Item is sold at $" + currentBid.getBidAmount().getAmount());
		}
	}
	
	public void sell(double amount, String buyerEmail) {
		if (this.getStatus().equalsIgnoreCase("SOLD")) {
			System.out.println("The Item: " + this.getItemName() + "is not available");
		} else {
			this.setStatus("SOLD");
			this.soldPrice.setAmount(currentBid.getBidAmount().getAmount());
			buyerInfo = buyerEmail;
			this.setDateSold(new Date());
		}
	}

	@Override
	public void cancelSale() {
		currentBid.clear();
		soldPrice = null;
		buyerInfo = null;
	}

	@Override
	public void showPrice() {
		System.out.println("Price is " + getPrice());
	}

	@Override
	public void showPriceInEuro() {
		System.out.println("Price in Euro is " + 0.7 * getPrice());
	}

	@Override
	public double getSoldPrice() {
		// TODO Auto-generated method stub
		return soldPrice.getAmount();
	}

	@Override
	public String getStatus() {
		return this.getStatus();
	}
	
	@Override
	public String getItemName() {
		return this.getItemName();
	}
	
	public AuctionBid getCurrentBid() {
		return currentBid;
	}
	
	
	@Override
	public void showSaleInfo() {
		showItemStatus();
		System.out.println("Buyer Info is " + buyerInfo);
		
	}
	
	public void showItemStatus() {
		super.showItemStatus();
		currentBid.showBidStatus();
	}
	
	public String getBuyerInfo() {
		return buyerInfo;
	}
	
	/**
	 * Inner class AuctionBid
	 *
	 */
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
			if (bidDate == null) {
				System.out.println("No current bids");
			} else {
				System.out.println("Bid Date is " + bidDate);
			}
		}
		
		public void clear() {
			MINBID.setAmount(0.0);
			bidAmount = null;
			bidderEmail = null;
			bidDate = null;
		}

		public Money getBidAmount() {
			return bidAmount;
		}

		public void setBidAmount(Money bidAmount) {
			this.bidAmount = bidAmount;
		}

		public Money getMINBID() {
			return MINBID;
		}

		public void setMINBID(Money mINBID) {
			MINBID = mINBID;
		}

		public String getBidderEmail() {
			return bidderEmail;
		}

		public void setBidderEmail(String bidderEmail) {
			this.bidderEmail = bidderEmail;
		}

		public Date getBidDate() {
			return bidDate;
		}

		public void setBidDate(Date bidDate) {
			this.bidDate = bidDate;
		}
	}
}
