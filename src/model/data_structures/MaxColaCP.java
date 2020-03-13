package model.data_structures;

/**
 * Cola de prioridad implementada a partir de una cola con nodos comparables
 * @param <Key> Generico comparable
 */
@SuppressWarnings("unchecked")
public class MaxColaCP<Key extends Comparable<Key>> implements IMaxCP<Key>{


	private int N = 0;
	private Key[] cp;


	public MaxColaCP(int nInicial)
	{	
		cp = (Key[]) new Comparable[nInicial];	
	}

	public void agregar(Key elem)  //Agrega los elementos manteniendo el orden de la cola
	{
		if (cp == null) 
			System.out.println("La cola de prioridad no esta inicializada");
		else
		{
			if ( N+1 > cp.length) //Verifica que la cola de prioridad tenga espacio. Si no lo tiene la amplia
				resize(N*2);
			 int i = N-1;
		        while (i >= 0 && less(elem, cp[i])) {
		            cp[i+1] = cp[i];
		            i--;
		        }
		        cp[i+1] = elem;
		        N++;
		}
	}


	public Key sacarMax() 
	{	
		if (cp == null)
			System.out.println("La cola de prioridad no está inicializada");
		else
		{
			Key temp = cp[N-1];
			for (int i = N-2; i > 0; i--)
				cp[i] = cp[i+1];
			if(N != 0) N--;
			return temp;
		}
		return null;
	}
	public int darNumElementos() 
	{	return N;	}
	public Key darMax() 
	{	return cp[N];	}
	public boolean vacia() 
	{ 	return N == 0;	}


	private void resize(int size)
	{

		Key[] nueva = (Key[]) new Comparable[size];
		for (int i = 0; i < N; i++)
			nueva[i] = cp[i];
		cp = nueva;
	}
	
	private boolean less(Key i, Key j)
	{
		return i.compareTo(j) < 1;	
	}
}
