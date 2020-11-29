package Bandas;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class Banda {
	private String solista, genero, estilo, fb, tw, barrio;
	private String[] redes, discos, videoclip, video;
	private int integrantes;
	private Date fecha;

	static ListaSimple lista = new ListaSimple();
	static Arbol arbol = new Arbol();
	static Set<String> generos = new HashSet<String>();
	static Set<String> barrios = new HashSet<String>();
	static HashMap<String, ListaSimpleCadenas> bandas = new HashMap<>();

	/*
	Crear un Map llamado bandas que tenga como clave el género de música tocado por las
bandas y como valor el nombre del solista de cada banda, barrio y la cantidad de
integrantes
	 */

	// CONSTRUCTORES

	public Banda() {
		//TODO: aca habria que actualizar los estaticos tambien. Tenemos un problema si creamos la banda con este constructor porque nunca estaria en ninguna lista
		//no cambie nada todavia porque por ahi para actualizar los estaticos necesitamos ciertos datos, hay que ver como lo resolvemos
	}

	public Banda(String solista, String genero, Date fecha, int integrantes) {
		this.solista = solista;
		this.genero = genero;
		this.fecha = fecha;
		this.integrantes = integrantes;
		actualizarEstaticos();
	}

	public Banda(String solista, String genero, String estilo, Date fecha, String fb, String tw, String[] redes,
			String[] discos, String[] videoclip, String[] video, String barrio, int integrantes) {
		this.solista = solista;
		this.genero = genero;
		this.estilo = estilo;
		this.fecha = fecha;
		this.fb = fb;
		this.tw = tw;
		this.redes = redes;
		this.discos = discos;
		this.videoclip = videoclip;
		this.video = video;
		this.barrio = barrio;
		this.integrantes = integrantes;
		actualizarEstaticos();
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

	// Otros metodos
	private void actualizarEstaticos() {
		lista.add(this);
		arbol.ingresarNodo(new NodoArbol(this));
		generos.add(this.genero);
		barrios.add(this.barrio);
		agregarABandas(this);
	}

	public static int contarBandasPorBarrio(String barrio) {
		int n = 0;
		Nodo currentNodo = lista.getInicio();
		while (currentNodo != null) {
			if (barrio.equals(currentNodo.getBanda().getBarrio())) {
				n++;
			}
			currentNodo = currentNodo.getSiguiente();
		}
		return n;
	}

	private void agregarABandas(Banda banda){
		boolean isKeyInMap = false;
		String genero = banda.genero.toLowerCase().trim();
		String[] datos = {banda.solista, banda.barrio, Integer.toString(banda.integrantes)};

		for (String key : bandas.keySet()){
			if (genero.equals(key)) {
				isKeyInMap = true;
				break;
			}
		}
		if (isKeyInMap){
			bandas.get(genero).add(datos);
		} else {
			bandas.put(genero, new ListaSimpleCadenas(new NodoCadenas(datos)));
		}
	}

	//TODO: Con esto se imprimiria toda la tabla en lugar de solo el solista, para el punto 4. Falta corregir la impresion de las matrices
	//UPDATE: arregle la impresion de las matrices, no mire que pide el punto 4 pero cuando se imprime estaria bueno dar un poco mas de informacion
	//sobre que esta imprimiendo
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		return String.format("%s %s %s %s %s %s %s %s %s %s %s %d", solista, genero, estilo, sdf.format(fecha), fb, tw,
				arrayToString(redes), arrayToString(discos), arrayToString(videoclip), arrayToString(video), barrio, integrantes);
	}

	private String arrayToString(String[] stringArray){
		String string = "[";
		for (String s : stringArray){
			if (s.equals(stringArray[0])){
				string += s.trim();
			} else {
				string += ", " + s.trim();
			}
		}
		string += "]";

		return string;
	}

}