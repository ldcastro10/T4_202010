package model.data_structures;

public interface ILinkedList<T> extends Iterable<T> {
	
	//retorna el tamaño de la lista
	public int getSize();
	
	public boolean isEmpty();
	
	//retorna el primer elemento de la lista
	public T getFirst();
	
	//retorna el último elemento de la lista
	public T getLast();
	
	//agrega un elemento al inicio de la lista
	public void prepend(T object);
	
	//agrega un elemento al final de la lista
	public void append(T object);
	
	//remueve el primer elemento
	public void removeFirst();
	
	//remueve el ultimo elemento
	public void removeLast();
	
	//intercambia 2 elementos de lugar según su índice
	public void swap(int swap1 ,int swap2);
	
	//agrega un elemento después del elemento con el índice especifico.
	public void addAfter(T add, int Index);
	
	public T get(int pIndex);
}
