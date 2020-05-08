package util6;

interface Collection{
	boolean add(Object o);
	boolean addAll(Object[] arr);
	void clear();
	boolean contains(Object o);
	boolean containsAll(Object[] arr);
	boolean isEmpty();
	boolean remove(Object o);
	boolean removeAll(Object[] arr);
	boolean retainAll(Object[] arr);
	int size();
	Object[] toArray();
}
