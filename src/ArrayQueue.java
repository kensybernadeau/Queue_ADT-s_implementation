
public class ArrayQueue<E> implements Queue<E> {
	private final static int INITCAP = 4; 
	private E[] elements; 
	private int first, size; 
	public ArrayQueue() { 
		elements = (E[]) new Object[INITCAP]; 
		first = 0; 
		size = 0; 
	}
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E first() {
		if (isEmpty()) return null; 
		return elements[first]; 
	}

	public E dequeue() {
		if (isEmpty()) return null;
		E etr = elements[first]; 
		
           elements[first]=null;
           first=(first+1)%elements.length;
		   size--;

		// Check if number of available positions in the array exceed 3/4
		// of its total length. If so, and if the current capacity is not
		// less than 2*INITCAP, shrink the internal array to 1/2 of its
		// current length (the capacity of the queue). 
           if (elements.length >= 2*INITCAP && size < elements.length/4);
           changeCapacity(elements.length/2); 
		return etr;
	}
	public void enqueue(E e) {
		if (size == elements.length)   // check capacity, double it if needed
			changeCapacity(2*size); 
	}

	private void changeCapacity(int change) { 
		// PRE: newCapacity >= size
		int newCapacity = elements.length + change; 
		E[] newElement = (E[]) new Object[newCapacity]; 
		for (int i=0; i<size; i++) { 
			newElement[i] = elements[i]; 
			elements[i] = null; 
		} 
		elements = newElement; 
	}
	

}