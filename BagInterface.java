
public interface BagInterface <T>{
	public int getCurrentSize();
	public boolean isEmpty();
	public boolean add(T newEntry);
	public boolean remove(T anEntry);
	public boolean remove();
	public void clear();
	public boolean contains(T anEntry);
	public int getFrequencyOf (T anEntry);
	public T[] toArray();
	
}