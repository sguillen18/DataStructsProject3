


public class LinkedQueue <T> implements QueueInterface <T> {
	
	private Node firstNode;
	private Node lastNode;
	private int numOfElements;
	
	//defines Nodes
	private class Node {
		T data;
		Node next;
		
		public Node(T data, Node nextNode) {
			this.data = data;
			next = nextNode;
		}
		
		public Node(T newData) {
			this(newData, null);
		}
		
		public T getData() {
			return data;
		}
		
		/*public void setData(T newData) {
			data = newData;
		}*/
		
		public Node getNext() {
			return next;
		}
		
		public void setNext(Node newNext) {
			next = newNext;
		}
	}
	
	public LinkedQueue() {
		firstNode = null;
		lastNode = null;
		numOfElements = 0;
	}

	public void enqueue(T newEntry) {
		Node newNode = new Node(newEntry);
		numOfElements++;
		if(isEmpty()) {
			firstNode = newNode;
		}
		
		else {
			lastNode.setNext(newNode);
		}
		lastNode = newNode;
	}
	
	public T dequeue() {
		if(isEmpty()) {
			throw new EmptyQueueException();
		}
		numOfElements--;
		T front =  firstNode.getData();
		firstNode = firstNode.getNext();
		if(firstNode == null) {
			lastNode = null;
		}
		return front;
	}
	
	public T getFront() {
		return null;
	}
	
	public boolean isEmpty() {
		return firstNode == null;
	}
	
	public void clear() {
		firstNode = null;
		lastNode = null;
		numOfElements = 0;
	}
	
	public LinkedQueue <T> copy(){
		LinkedQueue <T> copy = new LinkedQueue <T> ();
		T[] items = toArray();
		for(int i = 0; i < numOfElements; i++) {
			copy.enqueue(items[i]);
		}
		return copy;
	}
	
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numOfElements];
		Node curr = firstNode;
		int i = 0;
		while(curr != lastNode) {
			result[i] = curr.getData();
			curr = curr.getNext();
		}
		
		return result;
		
	}
	
	public int getSize() {
		return numOfElements;
	}
}
