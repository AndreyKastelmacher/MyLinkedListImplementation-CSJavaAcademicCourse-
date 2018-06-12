/* Assignment number:  8.3
 * File Name:          LinkedList.java 
 * Name (First Last):  Andrey Kastelmacher
 * Student ID :        303258537 
 * Email :             Andrey Kastelmacher@post.idc.ac.il
 */  
package linkedList;

/** Represents a linked list of Node objects. */
public class LinkedList<T> {
	// A pointer to this list
	private Node<T> first;
	// Number of elements in this list
	private int size;
	// Last node in the list
	private Node<T> last;

	/**
	 * Constructs an empty list.
	 */
	public LinkedList() {
		// In this implementation every list starts with a dummy node.
		first = new Node<T>(null, null);
		last = first;
		size = 0;
	}

	/**
	 * Returns the size of this list.
	 * @return the list's size
	 */
	public int size() {
		return size;
	}

	/**
	 * Returns the element located at the given index in this list.
	 * @param index - the index of the node to retrieve, between 0 and size
	 * @throws IllegalArgumentException - if index is negative or greater than the list's size
	 * @return the element at the given index
	 */
	public T get(int index) {
		if (index < size && index > -1) {
			ListIterator<T> itr = this.listIterator();
			int i = 0;
			while (i < index) {
				itr.next();
				i++;
			}
			return itr.current.t;
		} else {
			throw new IllegalArgumentException(index + " index is out of bound");
		}
	}

	/**
	 * Inserts the given element at the beginning of this list.
	 * @param t - the value to insert.
	 */
	public void addFirst(T t) {
		Node<T> newNode = new Node<T>(t);
		// Inserts the new node between the dummy and the first node.
		newNode.next = first.next;
		first.next = newNode;
		if (size == 0) {
			last = newNode;
		}
		size++;
	}

	/**
	 * Inserts the given element at the end of this list.
	 * @param t - the value to insert.
	 */
	public void addLast(T t) {
		if (size == 0){
			this.addFirst(t);	
		}
		else{
			Node<T> newNode = new Node<T>(t);
			// Inserts the new node after the last node
			ListIterator<T> lastNode = this.listIterator();
			int i = 0;
			while (i < size - 1) {
				lastNode.next();
				i++;
			}
			lastNode.current.next = newNode;
			last = newNode;
			size++;
		}
	}

	/**
	 * Returns the index of the node containing t
	 * @param t -  the element that we are searching
	 * @return the index of this element, or -1 is the element is not in this list
	 */
	public int indexOf(T t) {
		int i = 0;
		ListIterator<T> itr = this.listIterator();
		while (itr.hasNext()) {
			if (itr.current.t == t) {
				return i;
			} else {
				itr.next();
				i++;
			}
		}
		return -1;
	}

	/**
	 * Removes the first occurance of the given element from this list.
	 * @param t - the element to be removed.
	 * @return true is this list contained the given element, false otherwise.
	 */
	public boolean remove(T t) {
		if (indexOf(t) == -1)
			return false;
		// Creates two pointers that follow each other in lock-step.
		Node<T> prev = first;
		Node<T> node = first.next;
		while (node.t != t) {
			prev = node;
			node = node.next;
		}
		prev.next = node.next;
		node = null;
		if (prev.next == null) {
			last = prev;
		}
		size--;
		return true;
	}

	/**
	 * Inserts the given element at the given position in this list.
	 * @param index - the position where the new element will end up being
	 * @param t - the element to insert
	 */
	public void add(int index, T t) {
		// index must be greater then 0 and smaller then size
		if (index == size){
			this.addLast(t);
		}
		else if (index == 0){
			this.addFirst(t);
		}
		else if (index < size && index > 0) {
			// Creates two pointers that follow each other in lock-step.
			Node<T> prev = first.next;
			Node<T> currNode = first.next.next;
			// i is an iterator for the index
			ListIterator<T> itr = this.listIterator();
			int i = 0;
			while (itr.hasNext() && i < index) {
				prev = itr.current;
				itr.next();
				currNode =  itr.current;
				i++;
			}
			Node<T> newNode = new Node<T>(t);
			prev.next = newNode;
			newNode.next = currNode;
			size++;
		}
	}

	/**
	 * Returns an iterator over this list.
	 * 
	 * @return a ListIterator object anchored at the first element of this list
	 */
	public ListIterator<T> listIterator() {
		// Anchor the iterator at the first real element
		// of this list, skipping the dummy node.
		return new ListIterator<T>(first.next);
	}

	/**
	 * Returns a textual representation of this list.
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		// Skips the dummy node
		Node<T> node = first.next;
		while (node != null) {
			s.append(node.t + "\n");
			node = node.next;
		}
		return s.toString();
	}

	/**
	 * Prints this list.
	 * 
	 */
	public void print() {
		for (ListIterator<T> itr = new ListIterator<T>(first.next); itr.hasNext();) {
			System.out.print(itr.next() + " ");
		}
		System.out.println();
	}
}