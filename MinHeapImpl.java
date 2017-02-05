import java.util.NoSuchElementException;

public class MinHeapImpl<Key extends Comparable<Key>> implements MinHeap<Key> {

	private Key[] a; //an array that contains the Heap elements
	private int N;  //the size of the Heap
	
	public MinHeapImpl(){
		N = 0;
		a = (Key[]) new Comparable[10];
	}
	
	public MinHeapImpl(Key[] keys){
		N = keys.length;
		a = (Key[]) new Comparable[2*N];
		for(int i=0; i<N; i++){
			a[i+1] = keys[i];
		}
		heapify();
	}
	
	@Override
	public void insert(Key v) {
		//check the size
		if(N == a.length-1){
			resize(2*a.length);
		}
		a[++N] = v;
		swim(N);
	}

	@Override
	public Key delMin() {
		if(N == 0){
			throw new NoSuchElementException("The Heap is empty");
		}
		Key min = a[1];
		exchKeys(1, N--);
		sink(1);
		a[N+1] = null;
		
		//check the size
		if(N <= a.length/4){
			resize(a.length/2);
		}
		return min;
	}

	@Override
	public boolean isEmpty() {
		if(N == 0) return true;
		return false;
	}

	@Override
	public Key min() {
		if(N == 0){
			throw new NoSuchElementException("The Heap is empty");
		}
		return a[1];
	}

	@Override
	public int size() {
		return N;
	}
	
	private void heapify(){
		for(int k=N/2; k>=1; k--){
			sink(k);
		}
	}
	
	private void resize(int newSize){
		Key[] aCopy = (Key[]) new Comparable[newSize];
		for(int i=1; i<=N; i++){
			aCopy[i] = a[i];
		}
		a = aCopy;
		aCopy = null;
	}
	
	private void sink(int k){
		int j;
		while(k<=N/2){
			j = 2*k;
			if((j+1<=N) && isLess(j+1, j)) j++;
			if(isLess(k, j)) break;
			exchKeys(k, j);
			k = j;
		}
	}
	
	private void swim(int k){
		while((k>1) && isLess(k, k/2)){
			exchKeys(k, k/2);
			k = k/2;
		}
	}
	
	/**
	 * 
	 * @param k
	 * @param j
	 * @return true if the key at the indice k is less than the key at indice j
	 */
	private boolean isLess(int k, int j){
		int compareValue = a[k].compareTo(a[j]);
		if(compareValue < 0) return true;
		return false;
	}
	
	private void exchKeys(int i, int j){
		Key k = a[i];
		a[i] = a[j];
		a[j] = k;
	}

}
