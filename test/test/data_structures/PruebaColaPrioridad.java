package test.data_structures;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import model.Comparendo;
import model.data_structures.LinkedList;
import model.data_structures.MaxColaCP;
import model.data_structures.MaxHeapCP;

public class PruebaColaPrioridad
{
	public static String PATH = "./data/comparendos_dei_2018.geojson";
	private MaxHeapCP<Comparendo> heap;
	private MaxColaCP<Comparendo> cola;
	
	@Before
	public void setup()
	{	
		heap = new MaxHeapCP<Comparendo>(10);
		cola = new MaxColaCP<Comparendo>(10);	
	}
	@Test
	public void testAgregarHeap()
	{
		try {
			cargarHeap();
		}
		catch (Exception e)
		{fail("No debe generar excepción");}
	}
	@Test
	public void testAgregarCola()
	{
		try {cargarCola();}
		catch (Exception e)
		{fail("No debe generar excepción");}
	}
	@Test

	
	private void cargarCola()
	{

			JsonReader reader;
			try {
				reader = new JsonReader(new FileReader(PATH));
				JsonElement elem = JsonParser.parseReader(reader);
				JsonArray e2 = elem.getAsJsonObject().get("features").getAsJsonArray();
			//	arreglo=new ArregloDinamico<Comparendo>(e2.size());
		
				cola = new MaxColaCP<Comparendo>(550000);

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
				cola.agregar(c);
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
	private void cargarHeap()
	{

			JsonReader reader;
			try {
				reader = new JsonReader(new FileReader(PATH));
				JsonElement elem = JsonParser.parseReader(reader);
				JsonArray e2 = elem.getAsJsonObject().get("features").getAsJsonArray();
			//	arreglo=new ArregloDinamico<Comparendo>(e2.size());
		
				heap = new MaxHeapCP<Comparendo>(550000);

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
				heap.agregar(c);
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