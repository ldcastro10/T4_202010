package model.data_structures;

public interface IList<T> {

 public int getCant();
 public void vaciar();
 public boolean estaVacia();
 public void AñadirElemento(T info);
 public T Eliminar();
 public T retornarElemento(int p);
 public T eliminarElemento(int p);
 public void AgregarElemento(T info,int p);


}
