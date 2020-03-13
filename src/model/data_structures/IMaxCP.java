package model.data_structures;

public interface IMaxCP<T> {

	public int darNumElementos();
	public void agregar(T elem);
	public T sacarMax();
	public T darMax();
}
