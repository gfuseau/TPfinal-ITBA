package Bandas;

import sun.print.PSStreamPrinterFactory;

public class ListaSimpleCadenas {
    private NodoCadenas inicio;

    // CONSTRUCTORES

    public ListaSimpleCadenas() {
    }

    public ListaSimpleCadenas(NodoCadenas inicio) {
        this.inicio = inicio;
    }

    // SETTERS

    public void setInicio(NodoCadenas inicio) {
        this.inicio = inicio;
    }

    // GETTERS

    public NodoCadenas getInicio() {
        return this.inicio;
    }

    // OTROS

    public void add(String[] cadenas) {
        NodoCadenas n1 = new NodoCadenas(cadenas);
        if (inicio == null) {
            inicio = n1;
        } else {
            NodoCadenas current = inicio;
            while (current.getSiguiente() != null) {
                current = current.getSiguiente();
            }
            current.setSiguiente(n1);
        }

    }

    public int size() {
        int size = 0;
        if (inicio == null) {
            return 0;
        } else {
            NodoCadenas current = inicio;
            while (current.getSiguiente() != null) {
                size += 1;
                current = current.getSiguiente();
            }
            size += 1;
            return size;
        }
    }

    public boolean isEmpty() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    public void print(){
        NodoCadenas current = inicio;
        String string = "[";

        if (current != null){
            while(current.getSiguiente() != null){
                string += "(" + current.getSolista() + ", " + current.getBarrio() + ", " + current.getIntegrantes() + "), ";
                current = current.getSiguiente();
            }
            string += "(" + current.getSolista() + ", " + current.getBarrio() + ", " + current.getIntegrantes() + ")";
        }
        string += "]";

        System.out.println(string);
    }
}
