import java.util.Arrays;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class MedianHeapImpl<Key extends Comparable<Key>> implements MedianHeap<Key> {

	private PriorityQueue<Key> pqLeftHalf;
	private PriorityQueue<Key> pqRightHalf;

	public MedianHeapImpl() {
		pqLeftHalf = new PriorityQueue<>(Collections.reverseOrder());
		pqRightHalf = new PriorityQueue<>();
	}

	public MedianHeapImpl(Key[] keys) {
		Arrays.sort(keys);
		int len = keys.length;
		for (int i = 0; i < len / 2; i++)
			pqLeftHalf.add(keys[i]);
		for (int i = len / 2; i < len; i++)
			pqRightHalf.add(keys[i]);
	}

	@Override
	public void insert(Key v) {
		Key leftMax = pqLeftHalf.peek();
		if((leftMax != null) && (less(v, leftMax)))
			pqLeftHalf.add(v);
		else
			pqRightHalf.add(v);
		equilibreHeaps();
	}

	@Override
	public Key delMedian() {
		int leftSize = pqLeftHalf.size();
		int rightSize = pqRightHalf.size();
		if(leftSize+rightSize == 0)
			throw new NoSuchElementException("The Heap is empty");
		
		if(leftSize > rightSize)
			return pqLeftHalf.poll();
		return pqRightHalf.poll();
	}

	@Override
	public boolean isEmpty() {
		int leftSize = pqLeftHalf.size();
		int rightSize = pqRightHalf.size();
		if(leftSize+rightSize == 0)
			return true;
		return false;
	}

	@Override
	public Key median() {
		int leftSize = pqLeftHalf.size();
		int rightSize = pqRightHalf.size();
		if(leftSize+rightSize == 0)
			throw new NoSuchElementException("The Heap is empty");
		
		if(leftSize > rightSize)
			return pqLeftHalf.peek();
		return pqRightHalf.peek();
	}

	@Override
	public int size() {
		return pqLeftHalf.size() + pqRightHalf.size();
	}

	private void equilibreHeaps(){
		int leftSize = pqLeftHalf.size();
		int rightSize = pqRightHalf.size();
		if(leftSize > rightSize+1){
			Key leftMax = pqLeftHalf.poll();
			pqRightHalf.add(leftMax);
		}else if(rightSize > leftSize+1){
			Key rightMin = pqRightHalf.poll();
			pqLeftHalf.add(rightMin);
		}
	}

	private boolean less(Key a, Key b) {
		if (a.compareTo(b) < 0)
			return true;
		return false;
	}
	
}
