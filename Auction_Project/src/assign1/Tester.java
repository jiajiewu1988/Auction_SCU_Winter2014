package assign1;

import auction.*;

public class Tester {
	public static void main(String args[]) {
		AuctionItem item1 = new AuctionItem("Carnations = a Painting", 780.00, 500.00);
		
		item1.showItemStatus();
		
		item1.makeABid(300.00, "smith@decor.com");
		item1.showItemStatus();
		
		item1.makeABid(510.00, "smith@decor.com");
		item1.showItemStatus();
		
		item1.makeABid(600.00, "jones@interiors.com");
		item1.showItemStatus();
		
		item1.sell();
		item1.showSaleInfo();
		
		item1.showItemStatus();
		
		item1.sell(item1.getItemPrice());
		
		item1.showItemStatus();
		
		item1.cancelSale();
		
		item1.makeABid(520.00, "jones@interiors.com");
		
		item1.showItemStatus();
		
		item1.sell(item1.getItemPrice(), "clark@museums.com");
		
		item1.showSaleInfo();
		
		item1.showItemStatus();

		//Test the Auction class
		Auction auction1 = new Auction();
		auction1.addAuctionItem(item1);
		auction1.addAuctionItem(new AuctionItem("IPAD1", 100.00, 70.00));
		
		//add at least 3 more AuctionItem instances of your choice
		auction1.addAuctionItem(new AuctionItem("Binke", 10.00, 7.00));
		auction1.addAuctionItem(new AuctionItem("kebing", 200.00, 50.00));
		auction1.addAuctionItem(new AuctionItem("luobing", 80.00, 9.00));
		
		auction1.showAllAuctionItems();
		auction1.showAuctionItemsByStatus("SOLD");
		auction1.showAuctionItemsByStatus("AVAILABLE");
		auction1.showAuctionItemStatus("carnations = a painting");
		auction1.showAuctionItemWithHighestBid();
		
		
	}
}
