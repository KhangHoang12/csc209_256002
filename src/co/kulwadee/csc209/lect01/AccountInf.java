package co.kulwadee.csc209.lect01;

public class AccountInf implements Comparable<AccountInf> {

	private String name; // instance variable of a class
	private double amount;
	public AccountInf(String name, double amount) {
		this.name = name;
		this.amount = amount;
	}
	// Set the name in the co.kulwadee.csc209.lect01.Account object
	public void setName(String name) {
		this.name = name;
	}
	// Return the co.kulwadee.csc209.lect01.Account name
	public String getName() {
		return name;
	}
	public String toString() {
		return "name: " + name + ", amount: " + amount;
	}	

	@Override
	/**
	 * Compares accounts by amount value.
	 * @param other another AccountInf object
	 * @return a positive integer if other should come before this object.
	 *         Zero if the two are indistinguishable (equal).
	 *         a negative integer otherwise.
	 */
	public int compareTo(AccountInf other) {		
		return Double.compare(amount, other.amount);
	}

}
