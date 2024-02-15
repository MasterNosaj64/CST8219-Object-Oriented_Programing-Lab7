
/*
 * Name:Jason Waid
 * Student ID:040912687
 * Course & Section: CST8132 304
 * Assignment: Lab 7
 * Date: Nov 19th, 2018
 */
import java.util.Random;

/**
 * The account holds the account number and balance information for the client.
 * 
 * @author Jason Waid
 *
 */
public abstract class Account {
	// Holds Account Number
	protected long accountNum;
	// Client Identifier
	protected Client client;
	// Starting account balance
	protected double balance;

	/**
	 * The constructor stores the account information into memory
	 * 
	 * @param client
	 *            the owner of the account
	 * @param balance
	 *            the money in the account
	 */
	public Account(Client client, double balance) {
		// Assigns incoming data to instance
		this.client = client;
		this.balance = balance;
		// Assigns Random Account Number
		this.accountNum = new Random().nextLong();
	}

	/**
	 * Controls the deposits into the account
	 * 
	 * @param amt
	 *            the amount of the deposit
	 */
	// Prompt user for deposit
	public void deposit(double amt) {
		// take deposit add to balance
		balance += amt;
	}

	/**
	 * Controls the withdraws from the account balance, if the withdrawal is larger
	 * than the balance, permission is denied
	 * 
	 * @param amt
	 *            the amount of the withdrawal
	 * @return true is the operation was successful, false if it was not
	 */
	// Prompt User for Withdrawal
	public boolean withdraw(double amt) {
		// if withdraw more than balance return false
		if (amt > balance) {
			return false;
			// if withdraw less than or equal to balance return true
		} else {
			balance -= amt;
			return true;

		}
	}

	/**
	 * Gets the account number of the account
	 * 
	 * @return accountNum is the account number
	 */
	// Gets Account Number
	public long getAccountNum() {
		return accountNum;
	}

	/**
	 * Gets the client info
	 * 
	 * @return client is the client
	 */
	// Method gets name from Client Class
	public Client getClient() {
		return client;
	}

	/**
	 * Gets the balance of the account
	 * 
	 * @return balance the money in the account
	 */
	// Get current balance
	public double getBalance() {
		return balance;
	}

	/**
	 * Gets the name of the client
	 * 
	 * @return first and last name of the client
	 */
	// Get name of client
	public String getName() {
		return client.getName();
	}

	/**
	 * the basis for the monthly process
	 */
	abstract void monthlyProcess();

	/**
	 * Prints the details of this account
	 */
	@Override
	public String toString() {
		return "Name: " + client.getName() + "\nEmail: " + client.getEmail() + "\nPhone Number: " + client.getPhoneNum()
				+ "\nAccount Number: " + getAccountNum() + "\nBalance: " + getBalance();
	}

}
