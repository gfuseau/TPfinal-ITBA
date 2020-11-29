package Bandas;

import java.text.ParseException;
import java.util.HashMap;
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

        HashMap<String, String[]> musicaPersonalidad = iniciarMusicaPersonalidad();

        boolean deseaSalir = false;

        do {
            switch (menu()) {
                case 1:
                    visualizarBandas();
                    presionarEnter();
                    break;
                case 2:
                    /*
                    2. Visualizar porcentaje de bandas inscritas antes del 31/12/2010, en relación con el total.
                     */
                    presionarEnter();
                    break;
                case 3:
                    /*
                    3. Visualizar para cada barrio según el genero musical mas tocado por las bandas, la
                    personalidad que prevalece según los estudios mostrados anteriormente.
                     */
                    personalidadPorBarrio(musicaPersonalidad);
                    presionarEnter();
                    break;
                case 4:
                    /*
                    4. Visualizar la información de las bandas almacenadas en el árbol usando Recorrido InOrden.
                     */
                    // TODO: aca no se si me pide solo el solista, o toda la info de cada banda. Si
                    // pide toda la banda, hay que corregir el metodo toString() de Banda y meterlo
                    // en inorden.
                    //UPDATE: el metodo toString de la banda ya lo arregle, faltaria solo ponerle un formato que diga que es cada valor impreso
                    Banda.arbol.inorden();
                    presionarEnter();
                    break;
                case 5:
                    /*
                    5. Visualizar la cantidad de Bandas por Barrio: ordenada por cantidad de bandas, usando el
                    Conjunto de barrios y el Map llamado bandas.
                     */

                    presionarEnter();
                    break;
                case 6:
                    /*
                    6. Visualizar la cantidad de Bandas por Barrio: ordenada por barrio alfabéticamente.
                     */

                    presionarEnter();
                    break;
                case 7:
                    /*
                    7. Crear una estructura a su elección que permita almacenar y mostrar la cantidad de bandas,
                    discos y la cantidad de integrantes por género musical.
                     */
                    presionarEnter();
                    break;
                case 8:
                    /*
                    8. Visualizar el Promedio de integrantes por Género musical.
                     */
                    presionarEnter();
                    break;
                case 9:
                    /*
                    9. Visualizar las 10 primeras bandas con mas presencia en las redes sociales.
                     */
                    presionarEnter();
                    break;
                case 10:
                    /*
                    10. Mostar en cada barrio cual es el género de música que las bandas tocan más.
                     */
                    Banda.lista.printGeneroPorBarrio();
                    presionarEnter();
                    break;
                case 11:
                    deseaSalir = true;
                    print("Saliendo del programa.\n");
                    break;
                default:
                    print("Por favor ingrese un numero entre 1 y 11.");
            }
        } while (!deseaSalir);
	}

	public static int pedirInt(String frase) {
        while(true) {
            try {  
                print(frase);
                int in = scanner.nextInt();
                scanner.nextLine();
                return in;
            } catch (InputMismatchException | NumberFormatException e) {
                print("El numero ingresado no es valido. Intentelo nuevamente.\n");
                scanner.next();
            }
        }
    }

    public static String pedirString(String frase) {
        print(frase);
        String string = scanner.nextLine();
        return string;
    }

    public static int menu() {
        print("\n------------------------------------------------------------\n");
        print("Elija una opcion del siguiente menu:\n"
                + "[1]  Visualizar la cantidad de bandas en un barrio.\n"
                + "[2]  Visualizar porcentaje de bandas inscritas antes del 31/12/2010, en relacion con el total.\n"
                + "[3]  Visualizar para cada barrio segun el genero musical mas tocado por las bandas, la personalidad que prevalece segun los estudios mostrados anteriormente.\n"
                + "[4]  Visualizar la informacion de las bandas almacenadas en el arbol usando Recorrido InOrden.\n"
                + "[5]  Visualizar la cantidad de Bandas por Barrio: ordenada por cantidad de bandas, usando el Conjunto de barrios y el Map llamado bandas.\n"
                + "[6]  Visualizar la cantidad de Bandas por Barrio: ordenada por barrio alfabeticamente.\n"
                + "[7]  Crear una estructura a su eleccion que permita almacenar y mostrar la cantidad de bandas, discos y la cantidad de integrantes por genero musical.\n"
                + "[8]  Visualizar el promedio de integrantes por Genero musical."
                + "[9]  Visualizar las 10 primeras bandas con mas presencia en las redes sociales.\n"
                + "[10] Mostrar en cada barrio cual es el genero de musica que las bandas tocan mas.\n"
                + "[11] Salir.");
        print("\n------------------------------------------------------------");

        return pedirInt("");
    }

    public static void generarTitulo() {
        final String titulo = "Trabajo Practico Final de Estructura de Datos y Programacion\n\n"
                + "Integrantes:\n"
                + "\t Gaston Emanuel Fuseau \t 57433 \n"
                + "\t Ramiro Vozzi \t\t 57741 \n"
                + "\t Bautista Cardenau \t 58040";
        print(titulo);
    }

    public static void leerCSV() {
        String localDir = System.getProperty("user.dir") + File.separator;
        String file = "bandas-inscriptas.csv";
        String path = localDir + file;
        while (true) {
            try {
                procesarCSV(path);
                break;
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
                break;
            }
        }
    }

    public static void procesarCSV(String path) throws IOException, ParseException {
        String line;
        BufferedReader br = new BufferedReader(new FileReader(path));
        boolean isHeaders = true;

        while ((line = br.readLine()) != null) {
            String[] values = line.split(";");
            if (isHeaders) {
                isHeaders = false;
            } else {
                new Banda(values[0], values[1], values[2], parseDate(values[3]), values[4], values[5],
                        values[6].split(","), values[7].split(","), values[8].split(","), values[9].split(","),
                        values[10], Integer.parseInt(values[11]));
            }
        }

        //print(Banda.lista.getInicio().getBanda().toString()); SI QUIEREN  VER COMO QUEDO EL TOSTRING DE BANDA CORRAN EL PROGRAMA CON ESTA LINEA

        br.close();
    }

    public static void visualizarBandas() {
        String barrio = pedirString("Ingrese un barrio para visualizar su cantidad de bandas: ").toUpperCase().trim();
        if (!Banda.barrios.contains(barrio)) {
            printf("El barrio ingresado %s no existe.\n", barrio);
            return;
        }
        int n = Banda.contarBandasPorBarrio(barrio);
        printf("En el barrio de %s hay %d bandas.\n", barrio, n);
    }

    public static void presionarEnter() { 
           print("\nPresione ENTER para continuar...\n");
           try {
               scanner.nextLine();
           }  
           catch(Exception e)
           {}  
    }

    public static void printf(String format, Object ... args) {
        System.out.printf(format, args);
    }

    public static void print(Object x) {
        System.out.println(x);
    }

    public static Date parseDate(String date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        return dateFormat.parse(date);
    }

    public static HashMap<String, String[]> iniciarMusicaPersonalidad(){
        HashMap<String, String[]> musicaPersonalidad = new HashMap<>();
        musicaPersonalidad.put("blues", new String[] {"Alta autoestima", "Creativos", "Amables", "Extrovertidos"});
        musicaPersonalidad.put("jazz", new String[] {"Alta autoestima", "Creativos", "Amables", "Extrovertidos"});
        musicaPersonalidad.put("soul", new String[] {"Alta autoestima", "Creativos", "Amables", "Extrovertidos"});
        musicaPersonalidad.put("rap", new String[] {"Alta autoestima", "Creativos", "Amables", "Extrovertidos"});
        musicaPersonalidad.put("opera", new String[] {"Alta autoestima", "Creativos", "Amables", "Extrovertidos"});
        musicaPersonalidad.put("clasica", new String[] {"Alta autoestima", "Creativos", "Amables", "Introvertidos"});
        musicaPersonalidad.put("country", new String[] {"Trabajadores", "Extrovertidos"});
        musicaPersonalidad.put("reggae", new String[] {"Alta autoestima", "Creativos", "Amables", "Extrovertidos", "Vagos"});
        musicaPersonalidad.put("dance", new String[] {"Creativos", "Poco amables", "Extrovertidos"});
        musicaPersonalidad.put("indie", new String[] {"Baja autoestima", "Creativos", "Poco amables", "Poco trabajadores"});
        musicaPersonalidad.put("rock", new String[] {"Baja autoestima", "Creativos", "Amables", "Poco trabajadores", "Introvertidos"});
        musicaPersonalidad.put("metal", new String[] {"Baja autoestima", "Creativos", "Amables", "Poco trabajadores", "Introvertidos"});
        return musicaPersonalidad;
    }

    public static void personalidadPorBarrio(HashMap<String, String[]> musicaPersonalidad){
        HashMap<String, String> generoPorBarrio = Banda.lista.generoPorBarrio();
        String genero;
        String string = "La personalidad que prevalece en cada barrio es:";

        for(String barrio : generoPorBarrio.keySet()){
            genero = generoPorBarrio.get(barrio);
            for(String key : musicaPersonalidad.keySet()){
                if (genero.contains(key)){
                    string += "\n- " + barrio + " (" + genero + "): " + arrayToString(musicaPersonalidad.get(key));
                }
            }
        }

        print(string);
    }

    public static String arrayToString(String[] array){
        String s = "";

        for (int i = 0; i < array.length; i++){
            if (i == 0){
                s += array[i];
            } else {
                s += ", " + array[i];
            }
        }

        return s;

    }

}