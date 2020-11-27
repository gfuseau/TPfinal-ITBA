package Bandas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejecutable {

    public static Scanner scanner = new Scanner(System.in);
    public static void generarTitulo() {
        // TODO: pongan sus nombres y legajos
        final String titulo = "Trabajo Práctico Final de Estructura de Datos y Programación\n\n"
                + "Integrantes:\n"
                + "\t Gastón Emanuel Fuseau \t 57433 \n"
                + "\t Ramiro \t xxxxx \n"
                + "\t Bautista \t xxxxx \n";
        System.out.println(titulo);
    }

    public static void main(String[] args) {
        generarTitulo(); generarMenu();

        int opcion;
        do {
            opcion = pedirInt("Ingrese la opción deseada, o ingrese 0 para volver a ver el menú: ");
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
                    System.out.println("Por favor ingrese un número entre 1 y 11.");
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
                System.out.println("El número ingresado no es válido. Inténtelo nuevamente.");
                scanner.next();
            }
        }
    }

    public static void generarMenu() {
        final String menu = "Elija una opción del siguiente menú:\n"
                + "[1]  Visualizar la cantidad de bandas en un barrio.\n"
                + "[2]  Visualizar porcentaje de bandas inscritas antes del 31/12/2010, en relación con el total.\n"
                + "[3]  Visualizar para cada barrio segun el género musical más tocado por las bandas, la personalidad que prevalece según los estudios mostrados anteriormente.\n"
                + "[4]  Visualizar la información de las bandas almacenadas en el árbol usando Recorrido InOrden.\n"
                + "[5]  Visualizar la cantidad de Bandas por Barrio: ordenada por cantidad de bandas, usando el Conjunto de barrios y el Map llamado bandas.\n"
                + "[6]  Visualizar la cantidad de Bandas por Barrio: ordenada por barrio alfabéticamente.\n"
                + "[7]  Crear una estructura a su elección que permita almacenar y mostrar la cantidad de bandas, discos y la cantidad de integrantes por género musical.\n"
                + "[8]  Visualizar el promedio de integrantes por Género musical."
                + "[9]  Visualizar las 10 primeras bandas con más presencia en las redes sociales.\n"
                + "[10] Mostar en cada barrio cuál es el género de música que las bandas tocan más.\n"
                + "[11] Salir.";
        System.out.println();
        System.out.println("------------------------------------------------------------");
        System.out.println(menu);
        System.out.println("------------------------------------------------------------");
        System.out.println();
    }

}
