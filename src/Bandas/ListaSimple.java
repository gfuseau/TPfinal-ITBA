package Bandas;

import java.util.HashMap;
import java.util.Set;

public class ListaSimple {

    private Nodo inicio;

    // CONSTRUCTORES

    public ListaSimple() {
    }

    public ListaSimple(Nodo inicio) {
        this.inicio = inicio;
    }

    // SETTERS

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    // GETTERS

    public Nodo getInicio() {
        return this.inicio;
    }

    // OTROS

    public void add(Banda banda) {
        Nodo n1 = new Nodo(banda);
        if (inicio == null) {
            inicio = n1;
        } else {
            Nodo current = inicio;
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
        return inicio == null;
    }

    private HashMap<String, HashMap<String, Integer>> generosPorBarrio() {
        Nodo current = this.inicio;
        HashMap<String, HashMap<String, Integer>> contador = new HashMap<>();
        // barrio -> genero -> contador
        boolean isBarrioInMap, isGeneroInMap;
        String currentBarrio, currentGenero;
        HashMap<String, Integer> generos;

        if (current != null) {
            while (current.getSiguiente() != null) {

                isBarrioInMap = false;
                isGeneroInMap = false;
                currentBarrio = current.getBanda().getBarrio().trim().toLowerCase();
                currentGenero = current.getBanda().getGenero().trim().toLowerCase();

                for (String barrio : contador.keySet()) {
                    if (currentBarrio.equals(barrio)) {

                        isBarrioInMap = true;
                        generos = contador.get(currentBarrio);

                        for (String genero : generos.keySet()) {
                            if (currentGenero.equals(genero)) {

                                isGeneroInMap = true;
                                generos.replace(currentGenero, generos.get(currentGenero) + 1);
                                break;

                            }
                        }
                    }
                }

                if (!isBarrioInMap) {
                    HashMap<String, Integer> hashMap = new HashMap<>();
                    hashMap.put(currentGenero, 1);
                    contador.put(currentBarrio, hashMap);
                } else if (!isGeneroInMap) {
                    contador.get(currentBarrio).put(currentGenero, 1);
                }

                current = current.getSiguiente();
            }
        }

        return contador;
    }

    public HashMap<String, String> generoPorBarrio() {
        // TODO: si hay varios generos con la misma cantiidad de bandas, solo da el
        // primero. Se podria cambiar para que de todos.
        HashMap<String, HashMap<String, Integer>> contador = generosPorBarrio();
        HashMap<String, String> generoPorBarrio = new HashMap<>();
        Set<String> generos;
        String maxGenero;
        int max, valor;

        for (String barrio : contador.keySet()) {

            generos = contador.get(barrio).keySet();
            max = 0;
            maxGenero = "";

            for (String genero : generos) {
                valor = contador.get(barrio).get(genero);
                if (valor > max) {
                    max = valor;
                    maxGenero = genero;
                }
            }

            generoPorBarrio.put(barrio, maxGenero);
        }

        return generoPorBarrio;
    }

    public void printGeneroPorBarrio() {
        HashMap<String, String> generoPorBarrio = generoPorBarrio();
        String string = "El genero que mas bandas tocan por barrio es:";

        for (String barrio : generoPorBarrio.keySet()) {
            string += "\n- " + barrio + ": " + generoPorBarrio.get(barrio);
        }

        System.out.println(string);
    }

    public Banda getAtPosition(int i){
        int j = 0;
        Nodo current = inicio;
        while (j != i){
            current = current.getSiguiente();
            j++;
        }
        return current.getBanda();
    }

}
