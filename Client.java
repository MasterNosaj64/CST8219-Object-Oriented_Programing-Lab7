/*
 * Name:Jason Waid
 * Student ID:040912687
 * Course & Section: CST8132 304
 * Assignment: Lab 7
 * Date: Nov 19th, 2018
 */
/**
 * The embodiment of the client holds all of the client data such as name, phone
 * number and email.
 * 
 * @author Jason Waid
 *
 */
public class Client {
	// Variables Declared
	private String firstName;
	private String lastName;
	private long phoneNum;
	private String email;

	/**
	 * Constructor stores the client data into memory
	 * 
	 * @param firstName
	 *            is the first name of the client
	 * @param lastName
	 *            is the last name of the client
	 * @param phoneNum
	 *            is the phone number of the client
	 * @param email
	 *            is the email of the client
	 */
	public Client(String firstName, String lastName, long phoneNum, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNum = phoneNum;
		this.email = email;
	}

	/**
	 * Method combines the first and last name objects with a space in between
	 * 
	 * @return first name and last name
	 */
	// Get first & last name of Client
	public String getName() {
		// Returns First & Last Name with Space between
		return firstName + " " + lastName;
	}

	/**
	 * Collects the phone number of the client
	 * 
	 * @return phoneNum of the client
	 */
	// Get Phone Number of Client
	public long getPhoneNum() {
		return phoneNum;
	}

	/**
	 * Collects the email of the client
	 * 
	 * @return email of the client
	 */
	// Get Email of Client
	public String getEmail() {
		return email;
	}

}
