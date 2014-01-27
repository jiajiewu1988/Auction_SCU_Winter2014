package auction;

/**
 * 
 */

import java.util.Date;

public class SaleItem {
	
	private String itemName;
	private Money price;
	private String status;
	private Date dateSold;
	
	/**
	 * Creates the data member
	 * @param itemName Name of the item
	 * @param price price of the Item
	 */
	public SaleItem(String itemName, double price) {
		this.itemName = itemName;
		this.price = new Money(price);
		status = "AVAILABLE";
	}
	
	/**
	 * Returns the value of amount in dollars
	 * @return the value of amount
	 */
	public double getPrice() {
		return price.getAmount();
	}
	
	/**
	 * 
	 */
	public void sell() {
		status = "SOLD";
	}
	
	/**
	 * Display the itemName, price, status, and dateSold
	 */
	public void showItemStatus() {
		System.out.println("itemName is " + itemName);
		System.out.println("price is " + price.getAmount());
		System.out.println("status is " + status);
		if (status.equals("SOLD")) {
			System.out.println("date sold is " + dateSold);
		}
	}

	
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDateSold() {
		return dateSold;
	}

	public void setDateSold(Date dateSold) {
		this.dateSold = dateSold;
	}

	public void setPrice(Money price) {
		this.price = price;
	}
}
