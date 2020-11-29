package Bandas;

public class NodoCadenas {

    private String solista, barrio;
    private int integrantes;
    private NodoCadenas siguiente;

    // Constructores

    public NodoCadenas() {
    }

    public NodoCadenas(String[] cadenas) {
        this.solista = cadenas[0];
        this.barrio = cadenas[1];
        this.integrantes = Integer.parseInt(cadenas[2]);
        this.siguiente = null;
    }

    // Setters


    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public void setSolista(String solista) {
        this.solista = solista;
    }

    public void setIntegrantes(int integrantes) {
        this.integrantes = integrantes;
    }

    public void setSiguiente(NodoCadenas siguiente) {
        this.siguiente = siguiente;
    }

    // Getters

    public int getIntegrantes() {
        return integrantes;
    }

    public String getBarrio() {
        return barrio;
    }

    public String getSolista() {
        return solista;
    }

    public NodoCadenas getSiguiente() {
        return siguiente;
    }

}
