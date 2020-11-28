package Bandas;

public class ListaSimple {
	private Nodo inicio;

    //CONSTRUCTORES

    public ListaSimple(){}

    public ListaSimple(Nodo inicio){
        this.inicio = inicio;
    }

    //SETTERS

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    //GETTERS

    public Nodo getInicio(){
        return this.inicio;
    }

    //OTROS

    public void add(Banda banda){
        Nodo n1 = new Nodo(banda);
        if (inicio == null){
            inicio = n1;
        } else {
            Nodo current = inicio;
            while (current.getSiguiente() != null){
                current = current.getSiguiente();
            }
            current.setSiguiente(n1);
        }

    }

    public int size(){
        int size = 0;
        if (inicio == null) {
            return 0;
        } else {
            Nodo current = inicio;
            while (current.getSiguiente() != null) {
                size += 1;
                current = current.getSiguiente();
            }
            size += 1;
            return size;
        }
    }

    public boolean isEmpty() {
        if (inicio == null){
            return true;
        } else {
            return false;
        }
    }

}
