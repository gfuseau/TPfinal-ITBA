package Bandas;

import java.util.Date;

public class Banda {
	private String solista, genero, estilo, fb, tw, barrio;
	private String[] redes, discos, videoclip, video;
	private int integrantes;
	private Date fecha;

	static ListaSimple lista = new ListaSimple();
	Arbol arbol = new Arbol();
	
	// CONSTRUCTORES

	public Banda() {
	}

	public Banda(String solista, String genero, Date fecha, int integrantes) {
		this.solista = solista;
		this.genero = genero;
		this.fecha = fecha;
		this.integrantes = integrantes;
		lista.add(this);
		NodoArbol nodo = new NodoArbol(this);
		arbol.ingresarNodo(nodo);
	}

	public Banda(String solista, String genero, String estilo, Date fecha, String fb, String tw, String[] redes,
			String[] discos, String[] videoclip, String[] video, String barrio, int integrantes) {
		this.solista = solista;
		this.genero = genero;
		this.estilo = estilo;
		this.fecha = fecha;
		this.fb = fb;
		this.tw = tw;
		// aca en redes hay algunos que tienen mas de 1 esta separados los link por una
		// coma
		this.redes = redes;
		// lo mismo para discos
		this.discos = discos;
		// videoclip tambien
		this.videoclip = videoclip;
		// video tambien
		this.video = video;
		this.barrio = barrio;
		this.integrantes = integrantes;
		lista.add(this);
		NodoArbol nodo = new NodoArbol(this);
		arbol.ingresarNodo(nodo);
	}

	// ANALIZADORES
	public String getSolista() {
		return solista;
	}

	public String getGenero() {
		return genero;
	}

	public String getEstilo() {
		return estilo;
	}

	public Date getFecha() {
		return fecha;
	}

	public String getFb() {
		return fb;
	}

	public String getTw() {
		return tw;
	}

	public String[] getRedes() {
		return redes;
	}

	public String[] getDiscos() {
		return discos;
	}

	public String[] getVideoclip() {
		return videoclip;
	}

	public String[] getVideo() {
		return video;
	}

	public String getBarrio() {
		return barrio;
	}

	public int getIntegrantes() {
		return integrantes;
	}

	public ListaSimple getLista() {
		return lista;
	}

	// MODIFICADORES
	public void setSolista(String solista) {
		this.solista = solista;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setFb(String fb) {
		this.fb = fb;
	}

	public void setTw(String tw) {
		this.tw = tw;
	}

	public void setRedes(String[] redes) {
		this.redes = redes;
	}

	public void setDiscos(String[] discos) {
		this.discos = discos;
	}

	public void setVideoclip(String[] videoclip) {
		this.videoclip = videoclip;
	}

	public void setVideo(String[] video) {
		this.video = video;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public void setIntegrantes(int integrantes) {
		this.integrantes = integrantes;
	}

}