package Bandas;

import java.util.*;

public class Banda {
	private String solista, genero, estilo, fb, tw, redes, discos, videoclip, video, barrio;
	private int cant;
	private Date fecha;

	// CONSTRUCTORES
	public Banda(String solista, String genero, Date fecha, int cant) {
		this.solista = solista;
		this.genero = genero;
		this.fecha = fecha;
		this.cant = cant;
	}

	public Banda(String solista, String genero, String estilo, Date fecha, String fb, String tw, String redes,
			String discos, String videoclip, String video, String barrio, int cant) {
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
		this.cant = cant;
	}

	// ANALIZADORES
	public String getsolista() {
		return solista;
	}

	public String getgenero() {
		return genero;
	}

	public String getestilo() {
		return estilo;
	}

	public Date getfecha() {
		return fecha;
	}

	public String getfb() {
		return fb;
	}

	public String gettw() {
		return tw;
	}

	public String getredes() {
		return redes;
	}

	public String getdiscos() {
		return discos;
	}

	public String getvideoclip() {
		return videoclip;
	}

	public String getvideo() {
		return video;
	}

	public String getbarrio() {
		return barrio;
	}

	public int getcant() {
		return cant;
	}

	// MODIFICADORES
	public void setsolista(String solista) {
		this.solista = solista;
	}

	public void setgenero(String genero) {
		this.genero = genero;
	}

	public void setestilo(String estilo) {
		this.estilo = estilo;
	}

	public void setfecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setfb(String fb) {
		this.fb = fb;
	}

	public void settw(String tw) {
		this.tw = tw;
	}

	public void setredes(String redes) {
		this.redes = redes;
	}

	public void setdiscos(String discos) {
		this.discos = discos;
	}

	public void setvideoclip(String videoclip) {
		this.videoclip = videoclip;
	}

	public void setvideo(String video) {
		this.video = video;
	}

	public void setbarrio(String barrio) {
		this.barrio = barrio;
	}

	public void setcant(int cant) {
		this.cant = cant;
	}
}
