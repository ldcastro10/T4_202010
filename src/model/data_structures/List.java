package model.data_structures;

public class List<T> {
 Node<T> primero;
 Node<T> ultimo;
 int cant;
 
 public List()
 {
	 this.cant=0;
 }
 public int getCant()
 {
	 return cant;
 }
 public void vaciar()
 {
	 cant=0;
	 primero = ultimo =null;
 }
 public boolean estaVacia()
 {
	 return(cant==0);
 }
 public void AñadirElemento(T info)
 {
	 primero=new Node<T>(info);
	 if(estaVacia())
	 {
		 ultimo = primero;
	 }
	 cant++;
 }
 public T Eliminar()
 {
	 if(estaVacia())
	 {
		 return null;
	 }
	 T info = primero.darInfo();
	 primero = primero.darSiguiente();
	 cant--;
	 if(estaVacia())
	 {
		 vaciar();
	 }
	 
	 return info;
	 
	 
 }
 /*Tomado de: https://www.youtube.com/watch?v=I9PrYl3Xoo4*/
 public T retornarElemento(int p)
 {
	 T dato=null;
	 if(p>cant && p<1 || estaVacia())
	 {
		 return dato;
	 }
	 else if(p==1)
	 {
		 return primero;
		 
	 }
	 else if(p==cant)
	 {
		 return ultimo;
	 }
	 else
	 {
		 Node<T> actual =primero;
		 int c=1;
		 while (actual!=null && c!=(p-1))
		 {
			 actual=actual.darSiguiente();
			 c++;
			 
		 }
		 dato=actual.darInfo();
	 }
	 return dato;
 }
 /*Tomado de: https://www.youtube.com/watch?v=I9PrYl3Xoo4*/
 public T eliminarElemento(int p)
 {
	 T dato=null;
	 if(p>cant && p<1 || estaVacia())
	 {
		 return dato;
	 }
	 else if(p==1)
	 {
		 return eliminarPrimero();
		 
	 }
	 else if(p==cant)
	 {
		 return eliminarAlFinal();
	 }
	 else
	 {
		 Node<T> actual =primero;
		 Node<T> actual =primero;
		 int c=1;
		 while (actual!=null && c!=(p-1))
		 {
			 anterior= actual;
			 actual=actual.darSiguiente();
			 c++;
			 
		 }
		 dato=actual.darInfo();
		 anterior.darSiguiente(actual.darSiguiente());
		 cant--;
	 }
	 return dato;
 }
 /*Tomado de: https://www.youtube.com/watch?v=I9PrYl3Xoo4*/
 public void AgregarElemento(T info,int p)
 {
	
	 if(p>cant && p<1 || estaVacia())
	 {
		 return ;
	 }
	 else if(p==1)
	 {
     insertarInicio(info);		 
	 }
	 else if(p==cant)
	 {
		insertarFinal(info);
	 }
	 else
	 {
		 Node<T> actual =primero;
		 Node<T> anterior =null;
		 int c=1;
		 while (actual!=null && c!=(p-1))
		 {
			 anterior= actual;
			 actual=actual.darSiguiente();
			 c++;
			 
		 }
		 Node<T>node= new Node<T>(info.actual);
		 anterior.darSiguiente(node)
		 cant++;
	 }
	 return dato;
 }
 /*Tomado de: https://www.youtube.com/watch?v=I9PrYl3Xoo4*/
}
