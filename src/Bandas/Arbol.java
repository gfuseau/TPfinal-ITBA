package Bandas;

public class Arbol {
	 NodoArbol raiz;
	 
	 public Arbol(){}
	 public Arbol (NodoArbol raiz){
		 this.raiz=raiz;
	 }
	public NodoArbol getRaiz() {
		return raiz;
	}
	public void setRaiz(NodoArbol raiz) {
		this.raiz = raiz;
	}
	public boolean esVacio(){
		if (this.raiz==null)
			return true;
		else 
			return false;
	}
	public void ingresarNodo(NodoArbol nuevo){
		if (this.esVacio()){
			this.raiz=nuevo;
		}
		else{
			this.raiz.agregarNodo(nuevo);
		}
	}
	//No se si sirve pero por las dudas esta
	public static void preorden(NodoArbol raiz){
		if (raiz!=null){
			System.out.println(raiz.banda.getSolista());
			preorden(raiz.getIzquierdo());
			preorden(raiz.getDerecho());
		}
	}
	//----------------------------------------
	public static void inorden(NodoArbol raiz){
		if (raiz!=null){
			inorden(raiz.getIzquierdo());
			System.out.println(raiz.banda.getSolista());
			inorden(raiz.getDerecho());
		}
	}
}
