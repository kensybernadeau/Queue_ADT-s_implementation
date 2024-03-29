

public class LLQueue<E> implements Queue<E>
{
	private SNode<E> front, rear; 
	private int size; 
	
	public LLQueue() {
		front = rear = null; 
		size = 0; 
	}
	
	public E dequeue() {
		if (isEmpty())
			return null; 
		E etr = front.getElement(); 
	// ADD MISSING CODE
		SNode<E>ntf = front.getNext();
		front.clean();
		
		front= ntf;
		size--;

		return etr;
	}

	public void enqueue(E e) {
		SNode<E> nn = new SNode<E>(e); 
		if (size == 0)
			front = nn; 
		else 
			rear.setNext(nn); 		
	     	rear = nn; 
		size++; 
	}

	public E first()  {
		if (isEmpty())
			return null; 
		return front.getElement();
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	// just for testing and grading....
    public void showReverse() { 
	    if (size == 0)
		   System.out.println("Queue is empty."); 
		else
		   recSR(front);
    } 
    private void recSR(SNode<E> f) { 
		if (f != null) { 
		   recSR(f.getNext()); 
		   System.out.println(f.getElement()); 
	     } 
    } 


}
