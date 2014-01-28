package auction;

/**
 * 
 *
 */

import java.util.ArrayList;
import java.util.Iterator;

public class Auction {

	//Data Members
	private ArrayList<ItemForAuction> auctionList;
	
	/**
	 * Create the auctionList
	 */
	public Auction() {
		auctionList = new ArrayList<ItemForAuction>();
	}
	
	/**
	 * Creates and AuctionItem instance with the given parameters and adds it to auctionList
	 * @param itemName item name
	 * @param price item price
	 * @param minbid minimum bid amount
	 */
	public void addAuctionItem(String itemName, double price, double minbid) {
		auctionList.add(new AuctionItem(itemName, price, minbid));
	}
	
	/**
	 * Adds the item to the auctionList
	 * @param item
	 */
	public void addAuctionItem(ItemForAuction item) {
		auctionList.add(item);
	}
	
	/**
	 * Shows the itemName, price and currentBid information of each item in the auctionList
	 */
	public void showAllAuctionItems() {
		Iterator<ItemForAuction> itr = auctionList.iterator();
		while (itr.hasNext()) {
			ItemForAuction item = itr.next();
			System.out.println("Item Name: " + item.getItemName());
			System.out.println("Item Price: " + item.getItemPrice());
			item.getCurrentBid().showBidStatus();
			System.out.println();
		}
	}
	
	/**
	 * Shows the list of items that are available or sold, based on the parameter value
	 */
	public void showAuctionItemsByStatus(String status) {
		Iterator<ItemForAuction> itr = auctionList.iterator();
		System.out.println(status + " items");
		while (itr.hasNext()) {
			ItemForAuction item = itr.next();
			if (status.equalsIgnoreCase(item.getStatus())) {
				System.out.println("Item Name: " + item.getItemName());
				System.out.println("Item Price: " + item.getItemPrice());
				item.getCurrentBid().showBidStatus();
				System.out.println();
			}
		}
	}
	
	public void showAuctionItemStatus(String itemName) {
		Iterator<ItemForAuction> itr = auctionList.iterator();
		boolean found = false;
		while (itr.hasNext()) {
			ItemForAuction item = itr.next();
			if (item.getItemName().equalsIgnoreCase(itemName)) {
				System.out.println("Item name: " + itemName);
				System.out.println("Bid Status: " + item.getStatus());
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("Item " + itemName + " does not exist in auctionList");
		}
	}
	
	public void showAuctionItemWithHighestBid() {
		Iterator<ItemForAuction> itr = auctionList.iterator();
		ItemForAuction highestBidItem = null;
		while (itr.hasNext()) {
			ItemForAuction item = itr.next();
			if (highestBidItem == null) {
				highestBidItem = item;
			} else {
				if (item.getCurrentBid().getBidAmount() != null) {
					if (highestBidItem.getCurrentBid().getBidAmount().getAmount() < item.getCurrentBid().getBidAmount().getAmount()) {
						highestBidItem = item;
					}
				}
			}
		}
		highestBidItem.showSaleInfo();
	}
}
