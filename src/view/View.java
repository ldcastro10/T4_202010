package view;

import model.logic.Modelo;

public class View 
{
	    /**
	     * Metodo constructor
	     */
	    public View()
	    {
	    	
	    }
	    
		public void printMenu()
		{
			System.out.println("1. Cargar Datos CON HEAP Y COLA");
			System.out.println("2. Generar muestra en MaxHeapCP");
			System.out.println("3. Generar muestra en MaxColaCP");
			System.out.println("4. Req2");
			System.out.println("5. Req1");

		}

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
		
		public void printModelo(Modelo modelo)
		{
			// TODO implementar
		}
}
