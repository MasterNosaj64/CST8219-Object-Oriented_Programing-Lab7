/*
 * Name:Jason Waid
 * Student ID:040912687
 * Course & Section: CST8132 304
 * Assignment: Lab 8
 * Date: Nov 19th, 2018
 */

/**
 * This Java class consists of an array that can be modified and manipulated
 * without leaving unused memory allocated
 * 
 * @author Jason Waid
 *
 */
public class GenericArray<T> {

	private int capacity;
	private int size;
	private T[] tArray;

	/**
	 * Constructor initializes the size for the array. The capacity value determines
	 * the number of index's available in the array is the number of objects
	 * inhabiting the array
	 */

	public GenericArray() {
		this(10);
	}

	/**
	 * Constructs the initial number of index's available to the array
	 * 
	 * @param initialCapacity
	 *            is the number of index's initially available to the array
	 * @throws IllegalArgumentException
	 *             is run when the initial capacity is negative or not an integer
	 */
	public GenericArray(int initialCapacity) throws IllegalArgumentException {
		if (initialCapacity < 0)
			throw new IllegalArgumentException();

		size = 0;
		capacity = initialCapacity;
		tArray = (T[]) new Object[initialCapacity];
	}

	/**
	 * a copy constructor creates a temp copy of the array which can then be replace
	 * the original
	 * 
	 * @param ga
	 *            is the term that is assigned to the temp copy of the array
	 * @throws NullPointerException
	 *             will run if the object being inserted into the array is null
	 */
	public GenericArray(GenericArray ga) throws NullPointerException {
		this(ga.capacity);

		if (ga == null)
			throw new NullPointerException();

		this.size = ga.size;

		System.arraycopy(ga.tArray, 0, tArray, 0, size);
	}

	/**
	 * adds the designated object to the end of the array, will increment capacity
	 * of array if it is full
	 * 
	 * @param s
	 *            the object to be added to the array
	 * @throws NullPointerException
	 *             will run if the object being inserted into the array is null
	 */
	public void add(T s) throws NullPointerException {
		try {
			add(size, s);
		} catch (NullPointerException ex) {
			throw ex;
		} catch (IndexOutOfBoundsException ex) {
			// do nothing, this should never occur
		}
	}

	/**
	 * Adds the object at the desired index of the array without overwriting any
	 * information, if the capacity of the array isn't already large enough to allow
	 * this, the capacity will be incremented
	 * 
	 * @param index
	 *            is the desire position in the array
	 * @param s
	 *            the object to be inserted into the array
	 * @throws IndexOutOfBoundsException
	 *             will run when the requested index is larger than the array itself
	 *             or a negative index
	 * @throws NullPointerException
	 *             will run if the object being inserted into the array is null
	 */
	public void add(int index, T s) throws NullPointerException, IndexOutOfBoundsException {
		if (s == null)
			throw new NullPointerException();

		if (index > size)
			throw new IndexOutOfBoundsException();

		if (size == capacity)
			ensureCapacity(capacity + capacity / 2);

		for (int i = size; i > index; i--) {
			tArray[i] = tArray[i - 1];
		}

		tArray[index] = s;

		size++;
	}

	/**
	 * returns the current capacity of the array (the number of index's)
	 * 
	 * @return capacity is the max size possible for the array
	 */
	public int capacity() {
		return capacity;
	}

	/**
	 * clears the array of all objects
	 * 
	 * @param size
	 *            is the number of objects in the array
	 */
	public void clear() {
		for (; size > 0; size--)
			tArray[size - 1] = null;
	}

	/**
	 * Determines if the requested object is already in the array, returns true if
	 * it is
	 * 
	 * @param s
	 *            the object
	 * @return true will be returned if the object being looked for is in the array
	 * @throws NullPointerException
	 *             will run if the object being inserted into the array is null
	 */
	public boolean contains(T s) throws NullPointerException {
		return indexOf(s) > -1;
	}

	/**
	 * Determines if the current array needs to increase in size by comparing the
	 * current capacity to the requested minimum
	 * 
	 * @param minCapacity
	 *            is set by the user
	 * @throws CapacityOutOfBoundsException
	 *             runs if the minimum capacity requested is smaller than the number
	 *             of objects in the array
	 */
	public void ensureCapacity(int minCapacity) throws CapacityOutOfBoundsException {
		if (minCapacity <= size)
			throw new CapacityOutOfBoundsException();

		if (capacity < minCapacity) {
			capacity = minCapacity;
			T[] temp = (T[]) new Object[capacity];
			for (int i = 0; i < size; i++) {
				temp[i] = tArray[i];
			}
			tArray = temp;
		}
	}

	/**
	 * gets the object at the specified index in the array
	 * 
	 * @param index
	 *            the address in the array
	 * @return the object stored in the defined index
	 * @throws IndexOutOfBoundsException
	 *             will run when the requested index is larger than the array itself
	 *             or a negative index
	 */
	public T get(int index) throws IndexOutOfBoundsException {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}

		return tArray[index];
	}

	/**
	 * located the index number of a specified string
	 * 
	 * @param s
	 *            is the string being looked for in the array
	 * @return the index number of the specified string
	 * @throws NullPointerException
	 *             will run if the object being inserted into the array is null
	 */
	public int indexOf(T s) throws NullPointerException {
		if (s == null)
			throw new NullPointerException();

		int found = -1;

		for (int i = 0; i < size; i++) {
			if (s.equals(tArray[i])) {
				found = i;
				break;
			}
		}

		return found;
	}

	/**
	 * determines if the array is empty
	 * 
	 * @return true if the array is empty, false if it is not
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * removed an object from the array at a specified index, shifts all objects in
	 * the array to remove any gaps
	 * 
	 * @param index
	 *            the specified position in the array
	 * @return the removed object from the array
	 * @throws IndexOutOfBoundsException
	 *             will run when the requested index is larger than the array itself
	 *             or a negative index
	 */
	public T remove(int index) throws IndexOutOfBoundsException {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}

		T oldObject = tArray[index];

		for (; index < size; index++) {
			tArray[index] = tArray[index + 1];
		}

		size--;
		return oldObject;
	}

	/**
	 * checks the array for a specified object and removes the first occurrence if
	 * it is found
	 * 
	 * @param s
	 *            the object being looked for in the array
	 * @return true one the object has been removed, false if it was not found
	 * @throws NullPointerException
	 *             will run if the object being inserted into the array is null
	 */
	public boolean remove(T s) throws NullPointerException {
		int index = indexOf(s);
		remove(index);
		return index > -1;
	}

	/**
	 * 
	 * @param index
	 *            is the address in the array
	 * @param s
	 *            is the object to be inserted into the array
	 * @return value of replaced object in the array
	 * @throws IndexOutOfBoundsException
	 *             will run when the requested index is larger than the array itself
	 *             or a negative index
	 * @throws NullPointerException
	 *             will run if the object being inserted into the array is null
	 */
	public T set(int index, T s) throws IndexOutOfBoundsException, NullPointerException {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException();

		if (s == null)
			throw new NullPointerException();

		T oldObject;

		if (index > capacity) {
			ensureCapacity(index + 1);
			oldObject = null;
		} else {
			oldObject = tArray[index];
		}

		if (index >= size) {
			size = index + 1;
		}

		tArray[index] = s;
		return oldObject;
	}

	/**
	 * This method returns the number of object in the given array
	 * 
	 * @param the
	 *            number of objects in the array defined by size
	 * @return Returns number of objects in the Array
	 */
	public int size() {
		return size;
	}

}
