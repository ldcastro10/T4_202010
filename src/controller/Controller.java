package controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import model.Comparendo;
import model.data_structures.ILinkedList;
import model.data_structures.LinkedList;
import model.data_structures.MaxColaCP;
import model.data_structures.MaxHeapCP;
import model.data_structures.Node;
import model.data_structures.IArregloDinamico;
import model.data_structures.ArregloDinamico;
import model.logic.Modelo;
import view.View;
import java.text.SimpleDateFormat;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;

	/* Instancia de la Vista*/
	private View view;

	private ArregloDinamico<Comparendo> consulta;
	private LinkedList<Comparendo> consulta4;
	public MaxColaCP<Comparendo> consulta2;
	public MaxHeapCP<Comparendo> consulta3;
	public Long[] pr2 = new Long[2];
	/**
	 * 
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();


	}

	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String dato = "";
		String respuesta = "";
		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
			case 1:
				modelo = new Modelo();
				modelo.cargarlinkedList();
				int tam5 = lector.nextInt();
				pr2 = modelo.leer(tam5);
				view.printMessage("Tiempo de carga HEAP (seg): " + (pr2[0])/1000.0 + "\n");
				view.printMessage("Datos cargados: " + modelo.heap.darNumElementos() + "\n");
				view.printMessage("Tiempo de carga COLA (seg): " + (pr2[1])/1000.0 + "\n");
				view.printMessage("Datos cargados: " + modelo.cola.darNumElementos() + "\n");

				break;
			case 2: 
				int tam = lector.nextInt();
				modelo.generarMuestraHeap(tam);
				System.out.println("Se generó una muestra de tamano " +tam);
				break;
			case 3:
				int tam2 = lector.nextInt();
				modelo.generarMuestraCola(tam2);
				System.out.println("Se generó una muestra de tamano " +tam2);
				break;

			case 4:

				
		
				System.out.println("numero" );
				int n3 = lector.nextInt();
				System.out.println("cadena con los tipos de vehiculos" );
				String p31 = lector.next();
				MaxHeapCP<Comparendo> rta = modelo.Req2(n3, p31);
				for(int i = 0; i <n3 ; i++)
				{
					System.out.println(rta.sacarMax());
				}
				break;
			case 5:
				System.out.println("numero" );
				int n33 = lector.nextInt();
				System.out.println("cadena con los tipos de vehiculos" );
				String p33 = lector.next();
				MaxColaCP<Comparendo> rta2 = modelo.Req1(n33, p33);
				for(int i = 0; i <n33 ; i++)
				{
					System.out.println(rta2.sacarMax());
				}
				break;
			}
		}
	}
}