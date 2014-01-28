package auction;

/**
 * Define a Money Object
 *
 */

public class Money {
	
	private String currencyUnits;
	private double amount;
	
	public Money(double amount) {
		this.amount = amount;
		currencyUnits = "Dollar";
	}

	public Money(String unit, double amount) {
		currencyUnits = unit;
		this.amount = amount;
	}
	
	/**
	 * Get the amount of the Money object
	 * @return amount of Money
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * Set the amount of Money
	 * @param amount the amount of money gonna be set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	/**
	 * Get the amount in Euro
	 * @return the amount in Euro
	 */
	public double getAmountInEuro() {
		return (double) 0.7 * amount;
	}
	
	/**
	 * Set the amount of money in euro
	 * @param amount
	 */
	public void setAmountInEuro(double amount) {
		this.amount = 0.7 * amount;
	}
	
	/**
	 * Print information of money object
	 */
	public void showMoney() {
		System.out.println("Money amount is " + amount);
		System.out.println("Currency Unit is " + currencyUnits);
	}
}
