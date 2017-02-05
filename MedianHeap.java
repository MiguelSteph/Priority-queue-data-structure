
public interface MedianHeap<Key extends Comparable<Key>> {

	/**
	 * Insert a new element in the Heap
	 * 
	 * @param v Key to be inserted in the Heap
	 */
	public void insert(Key v);
	
	/**
	 * Delete and return the median element in the Heap
	 * If there is two medians, it will return the maximum value of the two medians
	 * and delete all the two medians from the heap
	 * 
	 * @return the median in the Heap
	 * 
	 * @throws java.util.NoSuchElementException if the Heap is empty
	 */
	public Key delMedian();
	
	/**
	 * Check if the Heap is empty
	 * 
	 * @return true is the Heap is empty and false if not
	 */
	public boolean isEmpty();
	
	
	/**
	 * Return the median element in the Heap
	 * If there is two medians, it will return the average of the two medians
	 * 
	 * @return the median Key in the Heap
	 * 
	 * @throws java.util.NoSuchElementException if the Heap is empty
	 */
	public Key median();
	
	
	/**
	 * @return the size of the Heap
	 */
	public int size();
	
}
