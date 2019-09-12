package Project_3;

/**
 * A class of bags whose entries are stored in a chain of linked nodes. The bag
 * is never full.
 */

public class LinkedBag<T> implements BagInterface<T> {

	private class Node {
		private T data; // Entry in bag
		private Node next; // Link to next node

		private Node(T dataPortion) {
			this(dataPortion, null);
		} // end constructor

		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		} // end constructor
	} // end Node

	private Node firstNode; // Reference to first node
	private int numberOfEntries;

	// Default constructor
	public LinkedBag() {
		firstNode = null;
		numberOfEntries = 0;

	} // end default constructor

	@Override // gets current size of list
	public int getCurrentSize() {
		return numberOfEntries;
	}

	@Override // checks if list is empty
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}

	@Override // adds an entry to list
	public boolean add(T newEntry) {

		Node newNode = new Node(newEntry);
		newNode.next = firstNode;

		firstNode = newNode;
		numberOfEntries++;
		return true;
	}

	@Override // removes first entry
	public T remove() {
		T result = null;
		if (firstNode != null) {
			result = firstNode.data;
			firstNode = firstNode.next;
			numberOfEntries--;

		}
		return result;
	}

	// Locates a given entry within this bag.
	// Returns a reference to the node containing the entry, if located,
	// or null otherwise.
	private Node getReferenceTo(T anEntry) {

		Node currentNode;

		for (currentNode = firstNode; currentNode != null; currentNode = currentNode.next) {
			if (anEntry == currentNode.data)
				return currentNode;
		} // end while
		return currentNode;
	} // end getReferenceTo

	@Override // removes all instances of an Entry
	public boolean remove(T anEntry) {

		boolean flag = false;
		Node newNode = getReferenceTo(anEntry);
		while (newNode != null) {
			newNode.data = firstNode.data;
			firstNode = firstNode.next;
			newNode = getReferenceTo(anEntry);
			numberOfEntries--;

			flag = true;

		}
		/**************************************************
		 * first code I wrote before we went over it in class,tested properly
		 * wasn't sure if it was efficient enough with using remove()method //
		 * Node nodeN = getReferenceTo(anEntry); 
		 * if (nodeN != null) { //
		 * nodeN.data = firstNode.data; 
		 * firstNode = firstNode.next;
		 * remove(anEntry); 
		 * numberOfEntries--;
		 *  result = true; // }
		 *  return false;
		 *  }
		 **************************************/
		return flag;

	}

	@Override // clears linked bag array
	public void clear() {
		while (!isEmpty())
			remove();

	}

	@Override // gets frequency of an entry
	public int getFrequencyOf(T anEntry) {
		int frequency = 0;
		int count = 0;
		Node currentNode = firstNode;
		while ((count < numberOfEntries) && (currentNode != null)) {
			if (anEntry.equals(currentNode.data)) {
				frequency++;
			}
			count++;
			currentNode = currentNode.next;
		}
		return frequency;

	}

	@Override // checks if a specific entry exists
	public boolean contains(T anEntry) {
		boolean findNode = false;
		Node currentNode = firstNode;
		while (!findNode && (currentNode != null)) {
			if (anEntry.equals(currentNode.data))
				findNode = true;
			else
				currentNode = currentNode.next;
		}
		return findNode;

	}

	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfEntries];
		int index = 0;
		Node currentNode = firstNode;
		while ((index < numberOfEntries) && (currentNode != null)) {
			result[index] = currentNode.data;
			index++;
			currentNode = currentNode.next;
		}
		return result;
	}

}
