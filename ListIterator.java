/* Assignment number:  8.4
 * File Name:          ListIterator.java 
 * Name (First Last):  Andrey Kastelmacher
 * Student ID :        303258537 
 * Email :             Andrey Kastelmacher@post.idc.ac.il
 */  
package linkedList;

/** Represents an iterator of a linked list. 
 * An iterator is characterized by the node at which it is currently anchored. 
 */
public class ListIterator<T> {
	// current position in the list
	public Node<T> current;
	
	/** Constructs a list iterator, starting at the given node
	 * @param node  where this listIterator is anchored
	 */
	public ListIterator(Node<T> node) {
		current = node;
	}
	
	/** Checks if this iterator has more nodes to process
	 * @return  true if there are more nodes to process, false otherwise.
	 */
	public boolean hasNext() {
		return (current != null);
	}
				
	/** Returns the next element in the list and advances the cursor position
	 * Should be called only if hasNext() is true.
	 * @return the next element in the list
	 */
	public T next() {
		Node<T> currentNode = current;
		current = current.next;
		return currentNode.t;
	}
}