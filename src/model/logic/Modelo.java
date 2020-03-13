package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import model.Comparendo;
import model.data_structures.ILinkedList;
import model.data_structures.IArregloDinamico;
import model.data_structures.ArregloDinamico;
import model.data_structures.Node;

import model.data_structures.ShellSort;
import model.data_structures.QuickSort;
import model.data_structures.LinkedList;
import model.data_structures.MaxColaCP;
import model.data_structures.MaxHeapCP;
import model.data_structures.IMaxCP;


/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {

	public static final String SHELLSORT = "ShellSort";
	public static final String QUICKSORT = "QuickSort";
	public static final String MERGESORT = "MergeSort";
	public static String PATH = "./data/comparendos_dei_2018.geojson";
	public MaxHeapCP<Comparendo> heap;
	public MaxColaCP<Comparendo> cola;
	public ILinkedList<Comparendo> linkedList1;
	public ILinkedList<Comparendo> linkedList2;
	public IArregloDinamico<Comparendo> arreglo;
	public Comparendo[] lista=null;
	public Modelo()
	{
		
		heap = new MaxHeapCP<Comparendo>(550000);
		cola = new MaxColaCP<Comparendo>(550000);
		linkedList1 = new LinkedList<Comparendo>();
	}
	public void cargarlinkedList() {
		JsonReader reader;
		try {
			reader = new JsonReader(new FileReader(PATH));
			JsonElement elem = JsonParser.parseReader(reader);
			JsonArray e2 = elem.getAsJsonObject().get("features").getAsJsonArray();
		//	arreglo=new ArregloDinamico<Comparendo>(e2.size());
	
			

			SimpleDateFormat parser=new SimpleDateFormat("yyyy/MM/dd");
			int i=0;
			for(JsonElement e: e2) {
				int OBJECTID = e.getAsJsonObject().get("properties").getAsJsonObject().get("OBJECTID").getAsInt();

				String s = e.getAsJsonObject().get("properties").getAsJsonObject().get("FECHA_HORA").getAsString();	
				String FECHA_HORA = s; 

				String MEDIO_DETE = e.getAsJsonObject().get("properties").getAsJsonObject().get("MEDIO_DETE").getAsString();
				String CLASE_VEHI = e.getAsJsonObject().get("properties").getAsJsonObject().get("CLASE_VEHI").getAsString();
				String TIPO_SERVI = e.getAsJsonObject().get("properties").getAsJsonObject().get("TIPO_SERVI").getAsString();
				String INFRACCION = e.getAsJsonObject().get("properties").getAsJsonObject().get("INFRACCION").getAsString();
				String DES_INFRAC = e.getAsJsonObject().get("properties").getAsJsonObject().get("DES_INFRAC").getAsString();	
				String LOCALIDAD = e.getAsJsonObject().get("properties").getAsJsonObject().get("LOCALIDAD").getAsString();

				double longitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
						.get(0).getAsDouble();

				double latitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
						.get(1).getAsDouble();

				
			Comparendo c = new Comparendo(OBJECTID, FECHA_HORA, DES_INFRAC, MEDIO_DETE, CLASE_VEHI, TIPO_SERVI, INFRACCION, LOCALIDAD, longitud, latitud);
			linkedList1.append(c);
			//	heap.agregar(c);
			//	cola.agregar(c);
		//		arreglo.asignar(i, c);
		//		i++;

			}

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
			

	}
	public Long[] leer(int n) {

		Long rta1 = 0L;
		Long rta2 = 0L;
		Long[] pr = new Long[2];
		//	linkedList2 = cargarlinkedList();
		long start = System.currentTimeMillis();
		
		for(int i =0 ; i<n ; i++ )
		{
			heap.agregar(linkedList1.get(i));
		}
		long end = System.currentTimeMillis();
		rta1 = end-start;
		
		long start2 = System.currentTimeMillis();
		for(int i =0 ; i< n ; i++ )
		{	
			cola.agregar(linkedList1.get(i));
		}
		long end2 = System.currentTimeMillis();
		rta2 = end2-start2;
		pr[0]= rta1;
		pr[1]= rta2;


		return pr;
		
	}
	public MaxColaCP<Comparendo> generarMuestraCola(int n)
	{
		MaxColaCP<Comparendo> muestra = new MaxColaCP<Comparendo>(n);
		Comparendo anterior = cola.sacarMax();
		while(muestra.darNumElementos() < n) 
		{
			Comparendo actual = cola.sacarMax();
			if(!anterior.equals(actual)) 
				muestra.agregar(actual);
			anterior = actual;
			actual = cola.sacarMax();
		}
		return muestra;
	}

	public MaxHeapCP<Comparendo> generarMuestraHeap(int n)
	{
		MaxHeapCP<Comparendo> muestra = new MaxHeapCP<Comparendo>(n);
		Comparendo anterior = heap.sacarMax();
		while(muestra.darNumElementos() < n) 
		{
			Comparendo actual = heap.sacarMax();
			if(!anterior.equals(actual)) 
				muestra.agregar(actual);
			anterior = actual;
			actual = cola.sacarMax();
		}
		return muestra;
	}
	public MaxColaCP<Comparendo> Req1(int n, String p)
	{
		String[] s = p.split(",");
		
		int contador1 = 0;
		MaxColaCP<Comparendo> rta2 = new MaxColaCP<Comparendo>(n);
		for(int i=0; i<cola.darNumElementos()&& contador1 >= n; i++)
		{
			Comparendo c =cola.sacarMax();
			for(int i2=0; i<s.length && contador1 >= n; i2++)
			{

				if(c.getClaseVehi().compareTo(s[i])==0)
				{
					contador1 ++;
					rta2.agregar(c);
				}

			}
		}
		return rta2;
	}

	public MaxHeapCP<Comparendo> Req2(int n, String p)
	{
		
		String[] s = p.split(",");
		int contador = 0;
		MaxHeapCP<Comparendo> rta = new MaxHeapCP<Comparendo>(n);
		for(int i=0; i<heap.darNumElementos()&& contador >= n; i++)
		{
			Comparendo c =heap.sacarMax();
			for(int i2=0; i<s.length && contador >= n; i2++)
			{

				if(c.getClaseVehi().compareTo(p)==0)
				{
					contador ++;
					rta.agregar(c);
				}

			}
		}
		return rta;
	}
	
}
	