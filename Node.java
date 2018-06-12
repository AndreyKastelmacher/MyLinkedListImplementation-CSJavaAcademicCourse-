/* Assignment number:  8.2
 * File Name:          Node.java 
 * Name (First Last):  Andrey Kastelmacher
 * Student ID :        303258537 
 * Email :             Andrey Kastelmacher@post.idc.ac.il
 */  
package linkedList;

/** Represents a node in a linked list. 
 * A node is characterized by a value (T) and a pointer to another node. 
 * @author intro2cs@IDC staff
 */
public class Node<T> {
    T t;       	// package-private visibility
    Node<T> next;    // package-private visibility
    
    /** Constructs a node with the given data.
     * The new node will point to the given node (next).
     */
    public Node(T t, Node<T> next) {
        this.t = t;
        this.next = next;
    }
        
    /** Constructs a node with the given data.
     * The new node will point to null.
     */
    public Node(T t) {
        this(t, null);
    }
    
    /** Returns the data of this node, as a string.
     */
    public String toString() {
        return "" + t;
    }
}
