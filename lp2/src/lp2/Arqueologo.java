/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lp2;
import java.util.ArrayList;

/**
 *
 * @author Kevin
 */
class Arqueologo {
    //constantes
    static final int PLATAINICIAL = 12000;
    static final int TIEMPOINICIAL = 100;
    static final int PUNTOSINICIAL = 0;
    
    //variables
    private String nombre;
    private double plata;
    private double tiempo;
    private int puntos;
    private int civi;
    private ArrayList<Cubo> listaExcavacion;
    private ArrayList<MiembroEquipo> listaMiembro;
    private ArrayList<Herramienta> listaHerramienta;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPlata() {
        return plata;
    }

    public void setPlata(double plata) {
        this.plata = plata;
    }

    public double getTiempo() {
        return tiempo;
    }

    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getCivi() {
        return civi;
    }

    public void setCivi(int civi) {
        this.civi = civi;
    }

    Arqueologo(){
        listaExcavacion = new ArrayList<>();
        listaMiembro = new ArrayList<>();
        listaHerramienta = new ArrayList<>();
    }
    
    public void addMiembro(MiembroEquipo m){
        listaMiembro.add(m);
    }
    
    public void addHerramienta(Herramienta h){
        listaHerramienta.add(h);
    }
    
    public void addCubo(Cubo c){
        listaExcavacion.add(c);
    }
    
    public void inicializar(){
        plata = PLATAINICIAL;
        tiempo = TIEMPOINICIAL;
        puntos = PUNTOSINICIAL;
    }
}
