
/*
 * Name:Jason Waid
 * Student ID:040912687
 * Course & Section: CST8132 304
 * Assignment: Lab 7
 * Date: Nov 19th, 2018
 */
import java.util.Random;

/**
 * A child class of the Account Class which implements a monthly fee for
 * Chequing Accounts
 * 
 * @author Jason Waid
 * @param monthlyFee
 *            determines the fee the user pays each month
 */
public class ChequingAccount extends Account {
	double monthlyFee;

	/**
	 * The super constructor collects the data provided to the parent class and
	 * determines the monthly fee the client pays
	 * 
	 * @param client
	 *            is the customer in question (name, email, phone number)
	 * @param balance
	 *            is the balance for the customer in question
	 */
	public ChequingAccount(Client client, double balance) {
		super(client, balance);
		monthlyFee = new Random().nextDouble() * 5 + 5;

	}

	/**
	 * An override of monthly process that implements a monthly fee at a random
	 * value between $5 and $10
	 */
	// monthlyProcess for Monthly Fee
	@Override
	void monthlyProcess() throws ArithmeticException {
		try {
			withdraw(monthlyFee);
		} catch (ArithmeticException ae) {
			if (this.getBalance() < this.monthlyFee)
				System.err.println(
						"Account Number: " + accountNum + "Balance: " + balance + "Monthly Fee: " + monthlyFee);
		}

	}

	/**
	 * Prints the details for the account of the Chequing type
	 */
	@Override
	public String toString() {
		return "Name: " + client.getName() + "\nEmail: " + client.getEmail() + "\nPhone Number: " + client.getPhoneNum()
				+ "\nAccount Number: " + getAccountNum() + "\nBalance: " + getBalance() + "\nMonthly Fee: "
				+ monthlyFee;
	}

}