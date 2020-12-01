package Bandas;

import java.util.ArrayList;

public class GeneradorDeTablas {
    private ArrayList<ArrayList<String>> tablaList = new ArrayList<ArrayList<String>>();
    private StringBuilder tablaSB = new StringBuilder();
    private String tabla;
    private int filas, columnas;
    private int ancho;
    private boolean incluirTitulos = false;
    private int[] caracteresPorColumna;
    // private String[] stringsPorColumna;
    private String[] titulos;

    public GeneradorDeTablas(int columnas) {
        this.columnas = columnas;
        caracteresPorColumna = new int[columnas];
        titulos = new String[columnas];
    }

    public GeneradorDeTablas(int columnas, boolean incluirTitulos) {
        this(columnas);
        if (incluirTitulos) {
            this.incluirTitulos = true;
        }
    }

    public GeneradorDeTablas(int columnas, String... titulos) {
        this(columnas, true);
        this.titulos = titulos;
    }
    
    public String getTabla() {
        return tabla;
    }

    public boolean getIncluirTitulos() {
        return incluirTitulos;
    }

    public void setIncluirTitulos(boolean incluirTitulos) {
        this.incluirTitulos = incluirTitulos;
    }

    public void anadirFila(Object... fila) {
        ArrayList<String> filaList = new ArrayList<String>(columnas);
        for (int i = 0; i < columnas; i++) {
            filaList.add(i, fila[i].toString());
            actualizarCaracteres(i, fila[i].toString());
        }
        actualizarAncho();
        tablaList.add(filaList);
        filas++;
    }

    public void setTitulos(String... titulos) {
        this.titulos = titulos;
    }

    private void generarTitulos() {
        ArrayList<String> tituloList = new ArrayList<String>();
        for (int i = 0; i < columnas; i++) {
            tituloList.add(0, titulos[i].toString());
            actualizarCaracteres(i, titulos[i].toString());
        }
        actualizarAncho();

        StringBuilder tituloSB = new StringBuilder();
        for (int i = 0; i < columnas; i++) {
            tituloSB.append("%-" + caracteresPorColumna[i] + "s\t");
        }
        tituloSB.append("\n");

        String tituloFormat = tituloSB.toString();
        String titulo = String.format(tituloFormat, (Object[]) titulos);
        //TODO: comente el repeat porque no es compatible con versiones mas viejas de Java
        String barra = "-"; //.repeat(ancho);
        tablaSB.insert(0, barra + "\n");
        tablaSB.insert(0, titulo);
        tablaSB.append(barra + "\n");
        tablaSB.append(titulo + "\n");
    }

    private void actualizarCaracteres(int i, String aComparar) {
        if (caracteresPorColumna[i] < aComparar.length()) {
            caracteresPorColumna[i] = aComparar.length();
        }
    }

    private void actualizarAncho() {
        int anchoNuevo = 0;
        for (int i = 0; i < columnas; i++) {
            anchoNuevo += caracteresPorColumna[i];
        }
        ancho = anchoNuevo;
    }

    private void generarFila(int currentFila) {
        StringBuilder filaSB = new StringBuilder();
        for (int i = 0; i < columnas; i++) {
            filaSB.append("%-" + caracteresPorColumna[i] + "s\t");
        }
        filaSB.append("\n");

        String fila = filaSB.toString();
        tablaSB.append(String.format(fila, tablaList.get(currentFila).toArray()));
    }

    public void generarTabla() {
        for (int i = 0; i < filas; i++) {
            generarFila(i);
        }
        if (incluirTitulos) {
            generarTitulos();
        }
        tabla = tablaSB.toString();
    }

    public void imprimirTabla() {
        generarTabla();
        System.out.println(tabla);        
    }

}