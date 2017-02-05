
/**
 * API of the MaxHeap
 * 
 * @author Miguel Stephane KAKANAKOU
 *
 */
public interface MinHeap<Key extends Comparable<Key>> {

	/**
	 * Insert a new element in the Heap
	 * 
	 * @param v Key to be inserted in the Heap
	 */
	public void insert(Key v);
	
	/**
	 * Delete and return the min element in the Heap
	 * 
	 * @return the min in the Heap
	 * 
	 * @throws java.util.NoSuchElementException if the Heap is empty
	 */
	public Key delMin();
	
	/**
	 * Check if the Heap is empty
	 * 
	 * @return true is the Heap is empty and false if not
	 */
	public boolean isEmpty();
	
	/**
	 * Return the min element in the Heap
	 * 
	 * @return the min Key in the Heap
	 * 
	 * @throws java.util.NoSuchElementException if the Heap is empty
	 */
	public Key min();
	
	/**
	 * @return the size of the Heap
	 */
	public int size();
	
}
