/*
 * Name:Jason Waid
 * Student ID:040912687
 * Course & Section: CST8132 304
 * Assignment: Lab 7
 * Date: Nov 19th, 2018
 */
/**
 * An exception used in GenericArray that handles errors outside of a given
 * array's boundaries
 * 
 * @author Jason Waid
 *
 */
public class CapacityOutOfBoundsException extends RuntimeException {

	CapacityOutOfBoundsException() {
		super();
	}

	CapacityOutOfBoundsException(String s) {
		super(s);
	}

}
