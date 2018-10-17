
public interface Queue<E> {
	int size(); 
	boolean isEmpty(); 
	E first(); 
	E dequeue(); 
	void enqueue(E e); 
}
