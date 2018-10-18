
public class LinkedBag <T> implements BagInterface <T> {
	private Node firstNode;
	private int numberOfElements;
	
	public LinkedBag() {
		firstNode = null;
		numberOfElements = 0;
	}
	
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
	}
	
	public LinkedBag <T> copy(){
		LinkedBag <T> result = new LinkedBag <T> ();
		T[] items = toArray();
		for(int i = 0; i < getCurrentSize(); i++) {
			result.add(items[i]);
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public boolean equals(Object other) {
		T[] items = toArray();
		LinkedBag <T> copied = ((LinkedBag <T>)other).copy();
		 for(int i = 0; i < getCurrentSize(); i++){
			 if ( !(copied.remove(items[i]))) {
				return false;
			 }
		 }
		 
		 return copied.isEmpty();
	}
	
	//returns number of Nodes
	public int getCurrentSize() {
		return numberOfElements;
	}
	
	//returns true if there are no Nodes
	public boolean isEmpty() {
		return (numberOfElements == 0);
	}
	
	//adds a Node to the last Node
	public boolean add(T newEntry) {
		Node newNode = new Node(newEntry);
		newNode.next = firstNode;
		firstNode = newNode;
		numberOfElements ++;
		return true;
	}
	
	//removes one of the elements given in the bag
	//returns true if was able to remove the item
	//otherwise false
	public boolean remove(T anEntry) {
		for(Node curr = firstNode; curr != null; curr = curr.next) {
			if(anEntry.equals(curr.data)) {
				curr.data = firstNode.data;
				firstNode = firstNode.next;
				numberOfElements--;
				return true;
			}
		}
		return false;
	}
	
	//removes last object in bag
	//returns true if can remove an item
	public boolean remove() {
		if(firstNode != null) {
			firstNode = firstNode.next;
			numberOfElements--;
			return true;
		}
		else return false;
	}
	
	//empty bag
	public void clear() {
		for(Node curr = firstNode; curr != null; curr = curr.next) {
			curr.data = null;
		}
		numberOfElements = 0;
	}
	
	//returns true if the bag contains given element
	public boolean contains(T anEntry) {
		for(Node curr = firstNode; curr != null; curr = curr.next) {
			if(anEntry.equals(curr.data)) {
				return true;
			}
		}
		return false;
	}
	
	//returns how many times an item appears in a bag
	public int getFrequencyOf (T anEntry) {
		int counter = 0;
		for(Node curr = firstNode; curr != null; curr = curr.next) {
			if(anEntry.equals(curr.data)) {
				counter++;
			}
		}
		return counter;
	}
	
	//creates bag into an array
	@SuppressWarnings("unchecked")
	public T[] toArray() {
		T[] result = (T[]) new Object[numberOfElements];
		int count = 0;
		for (Node currentNode = firstNode; count < numberOfElements; count++) {
			result[count] = currentNode.data;
			currentNode = currentNode.next;
		}
		return result;
	}

}
