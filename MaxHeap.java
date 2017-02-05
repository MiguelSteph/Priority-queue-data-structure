
/**
 * API of the MaxHeap
 * 
 * @author Miguel Stephane KAKANAKOU
 *
 */
public interface MaxHeap<Key extends Comparable<Key>> {
	
	/**
	 * Insert a new element in the Heap
	 * 
	 * @param v Key to be inserted in the Heap
	 */
	public void insert(Key v);
	
	/**
	 * Delete and return the max element in the Heap
	 * 
	 * @return the max in the Heap
	 * 
	 * @throws java.util.NoSuchElementException if the Heap is empty
	 */
	public Key delMax();
	
	/**
	 * Check if the Heap is empty
	 * 
	 * @return true is the Heap is empty and false if not
	 */
	public boolean isEmpty();
	
	
	/**
	 * Return the max element in the Heap
	 * 
	 * @return the max Key in the Heap
	 * 
	 * @throws java.util.NoSuchElementException if the Heap is empty
	 */
	public Key max();
	
	
	/**
	 * @return the size of the Heap
	 */
	public int size();
	
}
