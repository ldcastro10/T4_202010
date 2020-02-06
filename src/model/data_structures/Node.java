package model.data_structures;

public class Node<T> 
	{
		T info;
		Node<T>siguiente;
		
		public Node(T info, Node<T> siguiente)
		{
			this.info =info;
			this.siguiente = siguiente;
			
		}

		 public T darInfo( )
		    {
		        return info;
		    }
		 public void setInfo( )
		    {
		        this.info = info;
		    }
		 public Node<T> darSiguiente( )
		    {
		        return siguiente;
		    }
		 public void cambiarSiguiente( Node<T> objeto )
		    {
		        this.siguiente = objeto;
		    }
		   public void desconectarSiguiente( )
		    {
		        siguiente = siguiente.siguiente;
		    }
		   public void insertarDespues( Node<T> objeto )
		    {
			   objeto.siguiente = siguiente;
		        siguiente = objeto;
		    }
	}

