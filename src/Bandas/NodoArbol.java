package Bandas;

public class NodoArbol {
	Banda banda;
	 NodoArbol derecho;
	 NodoArbol izquierdo;
	 
	 public NodoArbol(){}
	 public NodoArbol(Banda banda){
		 this.banda=banda;
		 this.derecho=null;
		 this.izquierdo=null;
	 }
	 // ANALIZADORES
	public Banda getBanda() {
		return banda;
	}
	public NodoArbol getDerecho() {
		return derecho;
	}
	public NodoArbol getIzquierdo() {
		return izquierdo;
	}
	//MODIFICADORES
	public void setBanda(Banda banda) {
		this.banda = banda;
	}

	public void setDerecho(NodoArbol derecho) {
		this.derecho = derecho;
	}

	public void setIzquierdo(NodoArbol izquierdo) {
		this.izquierdo = izquierdo;
	}

	public void agregarNodo(NodoArbol nuevo){
		if(this.banda.getSolista().compareTo(nuevo.banda.getSolista())>0){
			if(this.izquierdo==null){
				this.setIzquierdo(nuevo);
			}
			else{
				this.getIzquierdo().agregarNodo(nuevo);
			}
		}
		else{
			if(this.banda.getSolista().compareTo(nuevo.banda.getSolista())<0){
				if(this.derecho==null){
					this.setDerecho(nuevo);
				}
				else{
					this.getDerecho().agregarNodo(nuevo);
				}
			}
			
		}
	}
}
