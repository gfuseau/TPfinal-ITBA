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
		leerCSV();
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
                	//ya esta hecho el arbol, habria que ver como lo instanciamos en esta clase ejecutable
                	//arbol.inorden(raiz);
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
                    println("Saliendo del programa.");
                    break;
                default:
                    println("Por favor ingrese un numero entre 1 y 11.");
            }
        } while (!deseaSalir);
	}

	public static int pedirInt(String frase) {
        while(true) {
            try {  
                print(frase);
                int in = scanner.nextInt();
                return in;
            } catch (InputMismatchException | NumberFormatException e) {
                println("El numero ingresado no es valido. Intentelo nuevamente.\n");
                scanner.next();
            }
        }
    }

    public static int menu() {
        println("\n------------------------------------------------------------\n");
        println("Elija una opcion del siguiente menu:\n"
                + "[1]  Visualizar la cantidad de bandas en un barrio.\n"
                + "[2]  Visualizar porcentaje de bandas inscritas antes del 31/12/2010, en relacion con el total.\n"
                + "[3]  Visualizar para cada barrio segun el genero musical mas tocado por las bandas, la personalidad que prevalece segun los estudios mostrados anteriormente.\n"
                + "[4]  Visualizar la informacion de las bandas almacenadas en el arbol usando Recorrido InOrden.\n"
                + "[5]  Visualizar la cantidad de Bandas por Barrio: ordenada por cantidad de bandas, usando el Conjunto de barrios y el Map llamado bandas.\n"
                + "[6]  Visualizar la cantidad de Bandas por Barrio: ordenada por barrio alfabeticamente.\n"
                + "[7]  Crear una estructura a su eleccion que permita almacenar y mostrar la cantidad de bandas, discos y la cantidad de integrantes por genero musical.\n"
                + "[8]  Visualizar el promedio de integrantes por Genero musical."
                + "[9]  Visualizar las 10 primeras bandas con mas presencia en las redes sociales.\n"
                + "[10] Mostar en cada barrio cual es el genero de musica que las bandas tocan mas.\n"
                + "[11] Salir.");
        println("\n------------------------------------------------------------\n");

        return pedirInt("");
    }

    public static void generarTitulo() {
        final String titulo = "Trabajo Practico Final de Estructura de Datos y Programacion\n\n"
                + "Integrantes:\n"
                + "\t Gaston Emanuel Fuseau \t 57433 \n"
                + "\t Ramiro Vozzi \t\t 57741 \n"
                + "\t Bautista Cardenau \t 58040";
        println(titulo);
    }

    public static void leerCSV() {
        String localDir = System.getProperty("user.dir") + File.separator;
        String file = "bandas-inscriptas.csv";
        String path = localDir + file;
        while (true) {
            try {
                procesarCSV(path);
            } catch (IOException e) {
                printf("\nNo se pudo encontrar el archivo \"%s\" en el directorio:\n\t%s\nPor favor coloque el archivo en ese directorio.\n\n",
                        file, localDir);

                // Esto lo hice para que no joda con lo de "evitar que el programa salga en forma abrupta".
                int deseaSalir = pedirInt("Ingrese 1 si ya coloco el archivo. De lo contrario, ingrese cualquier otro numero y el programa finalizara: ");
                if (deseaSalir != 1) {
                    System.exit(0);
                }
            } catch (ParseException e) {
                // Esto significa que hubo un error parseando la fecha de la columna 4 del csv. Con este csv nunca pasaria.
                e.printStackTrace();
            }
        }
    }

    private static void procesarCSV(String path) throws IOException, ParseException {
        String line;
        BufferedReader br = new BufferedReader(new FileReader(path));
        boolean isHeaders = true;

        while ((line = br.readLine()) != null) {
            String[] values = line.split(";");
            if (isHeaders) {
                isHeaders = false;
            } else {
                // TODO: procesar la informacion del csv
                Banda banda = new Banda(values[0], values[1], values[2], parseDate(values[3]), values[4], values[5],
                        values[6].split(","), values[7].split(","), values[8].split(","), values[9].split(","),
                        values[10], Integer.parseInt(values[11]));
            }
        }

        br.close();
    }

    public static void println(Object x) {
        System.out.println(x);
    }

    public static void printf(String format, Object ... args) {
        System.out.printf(format, args);
    }

    public static void print(Object x) {
        System.out.print(x);
    }

    public static Date parseDate(String date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        return dateFormat.parse(date);
    }

}