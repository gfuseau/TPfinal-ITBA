package Bandas;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.text.SimpleDateFormat;  
import java.util.Date;
import java.util.Scanner;
import java.io.*;

public class Ejecutable {

	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		generarTitulo();
		readCSV();
		boolean deseaSalir = false;

        do {
            switch (menu()) {
                case 0:
                    menu();
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
                    deseaSalir = true;
                    print("Saliendo del programa.");
                    break;
                default:
                    print("Por favor ingrese un n�mero entre 1 y 11.");
            }
        } while (!deseaSalir);
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

    public static int menu() {
        print("\n------------------------------------------------------------\n");
        print("Elija una opci�n del siguiente men�:\n"
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
                + "[11] Salir.");
        print("\n------------------------------------------------------------\n");

        return scanner.nextInt();
    }

    public static void generarTitulo() {
        final String titulo = "Trabajo Practico Final de Estructura de Datos y Programacion\n\n"
                + "Integrantes:\n"
                + "\t Gaston Emanuel Fuseau \t 57433 \n"
                + "\t Ramiro Vozzi \t 57741 \n"
                + "\t Bautista Cardenau \t 58040";
        print(titulo);
    }

    public static void readCSV() {
        String path = "./bandas-inscriptas.csv";
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            boolean isHeaders = true;

            while((line = br.readLine())!=null) {
                String [] values = line.split(";");
                if (isHeaders){
                    isHeaders = false;
                } else {
                    //TODO: separar discos o cualquier campo que tenga mas de uno. Posiblemente usar listas para esos campos.
                    Banda banda = new Banda(values[0], values[1], values[2], parseDate(values[3]),
						values[4], values[5], values[6], values[7],
						values[8], values[9], values[10], Integer.parseInt(values[11]));
                }
            }
        } catch (IOException | ParseException e) {
            print(e.getMessage());
        }
	}

    public static void print(Object x){
	    System.out.println(x);
    }

    public static Date parseDate(String date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        return dateFormat.parse(date);
    }


}
