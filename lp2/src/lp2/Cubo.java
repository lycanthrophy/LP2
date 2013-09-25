/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lp2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Kevin
 */
class Cubo implements Dibujable{
    //variables
    private char tipoCubo;//es roca o es tierra
    private int tiempo;//cuanto tiempo tardará el cubo en terminar
    private int dificultad;//'vida' del cubo
    private boolean asignado;//el cubo ha sido asignado
    private boolean excavable;//el cubo es excavable
    private PiezaArqueologica pieza;//el cubo contiene una pieza
    private ArrayList<Herramienta> herramientas;//almacena las herramientas asignadas al cubo
    private ArrayList<MiembroEquipo> miembros;//almacena los miembros de equipo asignados al cubo
    private int x;
    private int y;
    private int z;
    
    //constructor
    public Cubo(int concentracion,int spawningRocas,int civi, boolean excavable, int x, int y, int z)
    {
        //inicializar atributos
        this.asignado = false;
        this.x = x;
        this.y = y;
        this.z = z;
        this.excavable=excavable;
        this.tiempo = -1;
        
        //extraer todas las piezas arqueologicas del archivo
        ArrayList<PiezaArqueologica> miListaPiezas;
        miListaPiezas = generarLista(civi);
        
        //asignar alguna pieza al cubo
        pieza = sacarAlgo(miListaPiezas, concentracion);
        
        //determinar el tipo de cubo
        Coin moneda;
        moneda=new Coin(spawningRocas);
        
        if (moneda.lanzar())
        {
            tipoCubo='R';// ES ROCA
            this.dificultad=100;  //VIDA
            this.excavable=false;
        }
        else
        {
            tipoCubo='.';//ES TIERRA
            this.dificultad=20;  //VIDA;
        }
        
        herramientas = new ArrayList<>();
        miembros = new ArrayList<>();
              
    }
    
    //extraer lista de items del archivo
    private ArrayList<PiezaArqueologica> generarLista(int civilizacion)
    {   
        ArrayList<PiezaArqueologica> milistaObjetos=new ArrayList<>();
        PiezaArqueologica artefacto;
        try
            {
                FileInputStream fstream = new FileInputStream("items.txt");
                DataInputStream entrada = new DataInputStream(fstream);
                BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));
                String strLinea;
                while ((strLinea = buffer.readLine()) != null)   
                    {
                        String delimt="_";
                        String []tokens= strLinea.split(delimt);
                        int civ = Integer.parseInt(tokens[1]);
                        int proba= Integer.parseInt(tokens[2]);
                        int valor=Integer.parseInt(tokens[3]);
                        if (civ==civilizacion || 0==civ)
                            {
                                artefacto=new PiezaArqueologica(tokens[0],civ,proba,valor);
                                //artefacto.imprime();
                                milistaObjetos.add(artefacto);
                            }
                    }
                entrada.close();
            }
        catch (Exception e)
            {
                System.err.println("Ocurrio un error: " + e.getMessage());
            }
        return milistaObjetos;
    }    
    
    //clase anidada
    class PiezaArqueologica{
        //atributos
        private String nombre;
        private int civi;
        private int rareza;
        private int valor;

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getCivi() {
            return civi;
        }

        public void setCivi(int civi) {
            this.civi = civi;
        }

        public int getRareza() {
            return rareza;
        }

        public void setRareza(int rareza) {
            this.rareza = rareza;
        }

        public int getValor() {
            return valor;
        }

        public void setValor(int valor) {
            this.valor = valor;
        }

        public boolean isEstaRoto() {
            return estaRoto;
        }

        public void setEstaRoto(boolean estaRoto) {
            this.estaRoto = estaRoto;
        }
        private boolean estaRoto;

        public PiezaArqueologica(String nombre, int civi, int rareza, int valor) {
            this.nombre = nombre;
            this.civi = civi;
            this.rareza = rareza;
            this.valor = valor;
            this.estaRoto = false;
        }       
    }
    
    //seleccionar una pieza para ponerla en el cubo
    private PiezaArqueologica sacarAlgo(ArrayList<PiezaArqueologica> miListaObjetos, int concetracion)
    {
        boolean interrup=false;
        Coin moneda;
        int probabilidad;
        int i=0;
        int civi;
        moneda=new Coin();
        while(!interrup)
            {
                        i=(int)(Math.random()*(miListaObjetos.size()-1));
                        probabilidad=miListaObjetos.get(i).getRareza();
                        civi=miListaObjetos.get(i).getCivi();
                        if (concetracion!=0 && civi==0)
                            {
                                probabilidad/=concetracion;
                            }
                        moneda.setproba(probabilidad);
                        interrup=moneda.lanzar();
            }
        return miListaObjetos.get(i);
    }
    
    public char sacarEstadoCubo()
    {
        if (this.dificultad>0)
            {
            if(this.excavable)
                if(this.asignado){
                    return '*';
                }
                else{
                    return this.tipoCubo;
                }
            else    
                return '.';
            }
        else
            {
            if (this.pieza.getCivi()>0)
                return '-';
            else
                return ' ';
            }
    }
    
    public void imprime(){
        
    }
}
