
/*
 * Name:Jason Waid
 * Student ID:040912687
 * Course & Section: CST8132 304
 * Assignment: Lab 7
 * Date: Nov 19th, 2018
 */
import java.util.Random;

/**
 * A child class of the Account Class which implements a annual interest for
 * Savings Accounts
 * 
 * @author Jason Waid
 * @param annualFee
 *            determines the interest the user receives each month
 */
public class SavingsAccount extends Account {
	// Variables declared
	double annualFee;

	/**
	 * The super constructor collects the data provided to the parent class and
	 * determines the annual interest rate the client receives
	 * 
	 * @param client
	 *            is the customer in question (name, email, phone number)
	 * @param balance
	 *            is the balance for the customer in question
	 */
	public SavingsAccount(Client client, double balance) {
		super(client, balance);
		// Annual Fee is calculated
		annualFee = new Random().nextDouble() * 3 + 3;

	}

	/**
	 * An override of monthly process that implements a annual interest at a random
	 * value between %3 and %5
	 */
	// monthlyProcess for Annual Interest
	@Override
	void monthlyProcess() throws ArithmeticException {
		try {
			deposit(balance * ((annualFee / 100) / 12));
		} catch (ArithmeticException ae) {
			System.err.println("Account Number: " + accountNum + "Balance: " + balance + "Annual Fee: " + annualFee);
		}
	}

	/**
	 * Prints the details for the account of the Savings type
	 */
	@Override
	public String toString() {
		return "Name: " + client.getName() + "\nEmail: " + client.getEmail() + "\nPhone Number: " + client.getPhoneNum()
				+ "\nAccount Number: " + getAccountNum() + "\nBalance: " + getBalance() + "\nAnnual Interest Rate: "
				+ annualFee;
	}

}
