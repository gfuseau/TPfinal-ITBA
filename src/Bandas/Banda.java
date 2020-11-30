package Bandas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Banda {
    private String solista, genero, estilo, fb, tw, barrio;
    private String[] redes, discos, videoclip, video;
    private int integrantes;
    private Date fecha;
    private int presenciaEnRedes; // para el punto 9.

    static ListaSimple lista = new ListaSimple();
    static Arbol arbol = new Arbol();
    static Set<String> generos = new HashSet<String>();
    static Set<String> barrios = new HashSet<String>();
    static HashMap<String, ListaSimpleCadenas> bandas = new HashMap<>();
    //TODO: tenemos muchos static, hay que ver cuales pueden sacarse
    static int cant = 0;
    static int total = 0;
    static double porcentajeBandas;
    static Date FECHA_A_COMPARAR;

    //TODO: mirar si no se puede hacer sin usar static, mismo para la fecha a comparar
    static {
        try {
            FECHA_A_COMPARAR = Ejecutable.parseDate("31/12/10");
        } catch(ParseException e) {
            e.printStackTrace();
        }
    }

    // CONSTRUCTORES
    
    public Banda() {}

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

    public int getPresenciaEnRedes() {
        return presenciaEnRedes;
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
        total++;
        if (FECHA_A_COMPARAR.compareTo(this.fecha) > 0) {
            cant++;
        }
        porcentajeBandas = (100.0 * cant) / (1.0 * total);
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

    private void agregarABandas(Banda banda) {
        boolean isKeyInMap = false;
        String genero = banda.genero.toLowerCase().trim();
        String[] datos = { banda.solista, banda.barrio, Integer.toString(banda.integrantes) };

        for (String key : bandas.keySet()) {
            if (genero.equals(key)) {
                isKeyInMap = true;
                break;
            }
        }
        if (isKeyInMap) {
            bandas.get(genero).add(datos);
        } else {
            bandas.put(genero, new ListaSimpleCadenas(new NodoCadenas(datos)));
        }
    }

    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        return String.format("%s %s %s %s %s %s %s %s %s %s %s %d", solista, genero, estilo, sdf.format(fecha), fb, tw,
                arrayToString(redes), arrayToString(discos), arrayToString(videoclip), arrayToString(video), barrio,
                integrantes);
    }

    public String toStringNuncaEnBlanco() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        return String.format("%-36s\t%-16s\t%s\t%d", solista, genero, sdf.format(fecha), integrantes);
    }

    private String arrayToString(String[] stringArray) {
        String string = "[";
        for (String s : stringArray) {
            if (s.equals(stringArray[0])) {
                string += s.trim();
            } else {
                string += ", " + s.trim();
            }
        }
        string += "]";

        return string;
    }

    public static void calcularPresenciaEnRedes() {
        int N = 10;
        int presencia = 0;
        List<Banda> listaOrdenadaPorPresencia = new ArrayList<>(total);
        Nodo currentNodo = lista.getInicio();

        while (currentNodo != null) {
            Banda currentBanda = currentNodo.getBanda();
            if (!currentBanda.getFb().equals("")) {
                presencia++;
            }
            if (!currentBanda.getTw().equals("")) {
                presencia++;
            }
            if (!currentBanda.getRedes()[0].equals("")) {
                presencia += currentBanda.getRedes().length;
            }
            currentBanda.presenciaEnRedes = presencia;
            presencia = 0;
            listaOrdenadaPorPresencia.add(currentBanda);
            currentNodo = currentNodo.getSiguiente();
        }

        Collections.sort(listaOrdenadaPorPresencia, Comparator.comparing(Banda::getPresenciaEnRedes));
        int size = listaOrdenadaPorPresencia.size();
        for (int i = size - 1; i > size - 1 - N; i--) {
            String solista = listaOrdenadaPorPresencia.get(i).getSolista();
            int presenciaEnRedes = listaOrdenadaPorPresencia.get(i).getPresenciaEnRedes();
            System.out.printf("[%d]\t%-36s\t%d\n", size - i, solista, presenciaEnRedes);
        }
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.printf("POS\t%-36s\t%s\n", "SOLISTA", "REDES");
    }

}