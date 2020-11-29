package Bandas;

public class Arbol {
	private NodoArbol raiz;

	public Arbol() {
	}

	public Arbol(NodoArbol raiz) {
		this.raiz = raiz;
	}

	public NodoArbol getRaiz() {
		return raiz;
	}

	public void setRaiz(NodoArbol raiz) {
		this.raiz = raiz;
	}

	public boolean esVacio() {
		if (this.raiz == null)
			return true;
		else
			return false;
	}

	public void ingresarNodo(NodoArbol nuevo) {
		if (this.esVacio()) {
			this.raiz = nuevo;
		} else {
			this.raiz.agregarNodo(nuevo);
		}
	}

	private void preorden(NodoArbol nodo) {
		if (nodo != null) {
			System.out.println(nodo.banda.getSolista());
			preorden(nodo.getIzquierdo());
			preorden(nodo.getDerecho());
		}
	}

	// ----------------------------------------
	private void inorden(NodoArbol nodo) {
		if (nodo != null) {
			inorden(nodo.getIzquierdo());
			System.out.println(nodo.banda.getSolista());
			inorden(nodo.getDerecho());
		}
	}

	private void postorden(NodoArbol nodo) {
		if (nodo != null) {
			postorden(nodo.getIzquierdo());
			postorden(nodo.getDerecho());
			System.out.println(nodo.banda.getSolista());
		}
	}

	public void preorden() {
		preorden(raiz);
	}

	public void inorden() {
		inorden(raiz);
	}

	public void postorden() {
		postorden(raiz);
	}

	private int altura(NodoArbol nodo) {
		if (nodo == null) {
			return 0;
		}
		return Math.max(altura(nodo.getIzquierdo()), altura(nodo.getDerecho())) + 1;
	}

	public int altura() {
		return altura(raiz);
	}
}
