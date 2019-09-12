package Project_2;


//Project 2: ADT Arraybag
public final class ArrayBag<T> implements BagInterface<T> {

	private final T[] bag;
	private int numberOfEntries;
	private static final int DEFAULT_CAPACITY = 25;

	/** Creates an empty bag whose initial capacity is 25. */
	public ArrayBag() {
		this(DEFAULT_CAPACITY);
	} // end default constructor

	/**
	 * Creates an empty bag having a given capacity.
	 * 
	 * @param desiredCapacity
	 *            The integer capacity desired.
	 */
	@SuppressWarnings("unchecked")
	public ArrayBag(int desiredCapacity) {
		bag = (T[]) new Object[desiredCapacity];
		numberOfEntries = 0;
	} // end constructor

	@Override // gets current size of array bag
	public int getCurrentSize() {

		return this.numberOfEntries;
	}

	@Override // Checks if bag is empty
	public boolean isEmpty() {
		if (numberOfEntries == 0) {
			return true;

		}
		return false;
	}

	@Override // adds object to array bag
	public boolean add(T newEntry) {
		if (numberOfEntries == bag.length) {
			return false;
		}
		bag[numberOfEntries] = newEntry;
		this.numberOfEntries++;
		return true;
	}

	@Override // removes object from array bag
	public T remove() {
		T temp = null;

		if (!isEmpty()) {
			temp = bag[numberOfEntries - 1];
			bag[numberOfEntries - 1] = null;
			numberOfEntries--;
		}
		return temp;
	}

	@Override // removes specific object from array bag
	public boolean remove(T anEntry) {
		boolean result = false;
		while (!isEmpty() && contains(anEntry)) {
			for (int i = 0; i < numberOfEntries; i++) {
				if (bag[i].equals(anEntry)) {
					bag[i] = bag[numberOfEntries - 1];
					result = true;
					numberOfEntries--;

				}
			}
		}
		return result;
	}

	@Override // clears bag
	public void clear() {

		numberOfEntries = 0;
	}

	@Override // gets frequency of specific object in bag
	public int getFrequencyOf(T anEntry) {
		int count = 0;
		for (int i = 0; i < numberOfEntries; i++) {
			if (bag[i].equals(anEntry)) {
				count++;
			}
		}
		return count;
	}

	@Override // checks if it contains a specific object in bag
	public boolean contains(T anEntry) {
		for (int i = 0; i < numberOfEntries; i++) {
			if (bag[i].equals(anEntry)) {
				return true;
			}
		}
		return false;
	}

	@Override // retrieve all entries in array to bag
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Object[numberOfEntries];
		for (int i = 0; i < numberOfEntries; i++) {
			temp[i] = bag[i];
		}
		return temp;
	}

}
