package Bandas;
import java.util.InputMismatchException;
import java.text.SimpleDateFormat;  
import java.util.Date;
import java.util.Scanner;
import java.io.*;
public class Ejecutable {
	public static Scanner scanner = new Scanner(System.in);
    public static void generarTitulo() {
        // TODO: pongan sus nombres y legajos
        final String titulo = "Trabajo Pr�ctico Final de Estructura de Datos y Programaci�n\n\n"
                + "Integrantes:\n"
                + "\t Gast�n Emanuel Fuseau \t 57433 \n"
                + "\t Ramiro Vozzi \t 57741 \n"
                + "\t Bautista \t xxxxx \n";
        System.out.println(titulo);
    }
    public static void readCSV() {
    	String path = "C:\\Users\\54115\\Documents\\Ramiro\\Programacion\\dataset\\bandas-inscriptas.csv";
    	String line = "";
    	try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			
			while((line = br.readLine())!=null) {
				//habria que usar un contador para no agarrar la primera linea
				String [] values = line.split(";");
				/*Banda banda = Banda(values[0], values[1], values[2], values[3].toDate(), 
						values[4], values[5], values[6], values[7], 
						values[8], values[9], values[10], values[11]);
				System.out.print("Nombre del solista: " + values[0] + "\n");*/
				
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generarTitulo(); generarMenu();
		readCSV();
        int opcion;
        do {
            opcion = pedirInt("Ingrese la opci�n deseada, o ingrese 0 para volver a ver el men�: ");
            switch (opcion) {
                case 0:
                    generarMenu();
                    break;
                case 1:
                    // visualizarBandas();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Por favor ingrese un n�mero entre 1 y 11.");
            }
        } while (opcion != 11);
	}
	public static int pedirInt(String frase) {
        while(true) {
            try {  
                System.out.print(frase);
                int in = scanner.nextInt();
                return in;
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("El n�mero ingresado no es v�lido. Int�ntelo nuevamente.");
                scanner.next();
            }
        }
    }

    public static void generarMenu() {
        final String menu = "Elija una opci�n del siguiente men�:\n"
                + "[1]  Visualizar la cantidad de bandas en un barrio.\n"
                + "[2]  Visualizar porcentaje de bandas inscritas antes del 31/12/2010, en relaci�n con el total.\n"
                + "[3]  Visualizar para cada barrio segun el g�nero musical m�s tocado por las bandas, la personalidad que prevalece seg�n los estudios mostrados anteriormente.\n"
                + "[4]  Visualizar la informaci�n de las bandas almacenadas en el �rbol usando Recorrido InOrden.\n"
                + "[5]  Visualizar la cantidad de Bandas por Barrio: ordenada por cantidad de bandas, usando el Conjunto de barrios y el Map llamado bandas.\n"
                + "[6]  Visualizar la cantidad de Bandas por Barrio: ordenada por barrio alfab�ticamente.\n"
                + "[7]  Crear una estructura a su elecci�n que permita almacenar y mostrar la cantidad de bandas, discos y la cantidad de integrantes por g�nero musical.\n"
                + "[8]  Visualizar el promedio de integrantes por G�nero musical."
                + "[9]  Visualizar las 10 primeras bandas con m�s presencia en las redes sociales.\n"
                + "[10] Mostar en cada barrio cu�l es el g�nero de m�sica que las bandas tocan m�s.\n"
                + "[11] Salir.";
        System.out.println();
        System.out.println("------------------------------------------------------------");
        System.out.println(menu);
        System.out.println("------------------------------------------------------------");
        System.out.println();
    }


}
