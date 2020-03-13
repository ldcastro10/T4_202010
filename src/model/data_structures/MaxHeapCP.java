package model.data_structures;
/**
 *Cola de prioridad implementada a partir de un Heap de nodos comparables
 * @param <Key> Genérico comparable
 */
@SuppressWarnings("unchecked")
public class MaxHeapCP<Key extends Comparable<Key>> implements IMaxCP<Key>{

	private Key[] cp;
	private int N = 0;

	public MaxHeapCP(int tamanio)
	{
		cp = (Key[]) new Comparable[tamanio];	
	}

	public int darNumElementos() 
	{
		return N;	
	}
	public void agregar(Key elem) 
	{	
		if ( N+1 >= cp.length) //Verifica que la cola de prioridad tenga espacio. Si no lo tiene la amplia
			resize(N*2);
		cp[++N]= elem;
		swim(N); 		
	}
	public Key sacarMax()
	{
		Key max = cp[1];
		exch(1, N--);
		cp[N+1]=null;
		sink (1);
		return max;		
	}
	public Key darMax()
	{
		return cp[1];	
	}



	private void swim(int n)
	{
		while (n > 1 && less(n/2, n))
		{	
			exch(n,n/2);
			n = n/2;  
		}
	}
	private void sink (int n)
	{
		while(n*2 <= N)
		{	
			int j = n*2;
			if(j < N && less(j, j+1)) j++;
			if(!less(n,j)) break;
			exch(n,j);
			n = j;	
		}		
	}
	private boolean less(int i, int j)
	{
		return cp[i].compareTo(cp[j]) < 1;	
	}
	private void exch(int i, int j)
	{ 
		Key temp = cp[i];
		cp[i] = cp[j];
		cp[j] = temp;
	}
	
	private void resize(int size)
	{
		
		Key[] nueva = (Key[]) new Comparable[size];
		for (int i = 0; i < N; i++)
			nueva[i] = cp[i];
		cp = nueva;
	}
}
