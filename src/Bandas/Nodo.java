package Bandas;

public class Nodo {

    private Banda banda;
    private Nodo siguiente;

    //Constructores

    public Nodo(){}

    public Nodo(Banda banda){
        this.banda = banda;
        this.siguiente = null;
    }

    //Setters

    public void setBanda(Banda banda) {
        this.banda = banda;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    //Getters

    public Banda getBanda() {
        return banda;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

}
