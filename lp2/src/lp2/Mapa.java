/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lp2;
import java.util.*;
import java.io.*;

/**
 *
 * @author Kevin
 */
class Mapa {
    //variables
    private Cubo [][][] distribucion;
    private int civi;
    private int i,j,k,spawningRocas;

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public int getK() {
        return k;
    }
        
    public Mapa(int i,int j,int k,int civi,int rocas)
    {   
        //variables
        this.spawningRocas=rocas;
        this.i=i;
        this.j=j;
        this.k=k;
        this.civi=civi;
        this.distribucion=new Cubo[i][j][k]; 
        int concentracion[][][];
        
        //generar matriz de distribucion de objetos
        concentracion=generaFoco(i,j,k);//Matrix de distribucion de obgetos
        
        //generar matriz de cubos
        for(int z=0;z<i;z++)
            for(int y=0;y<j;y++)
                for(int x=0;x<k;x++)
                    {
                        if (z==0)  //solo sera excavable en la superficie al principio
                            this.distribucion[x][y][z]=new Cubo(concentracion[x][y][z],spawningRocas,civi,true, x, y, z);
                        else
                            this.distribucion[x][y][z]=new Cubo(concentracion[x][y][z],spawningRocas,civi,false, x, y, z);
                    }
    }
        
    private int[][][] generaFoco(int i,int j,int k)
    {
        int b[][][];
        b=new int [i][j][k];
        int x1 = (int) (Math.random() * i);
        int y1 = (int) (Math.random() * j);
        int z1= 1+(int) (Math.random() * (k-2));
        double capa1,capa2;
        capa1=Math.sqrt(3.1);   //ANALIZAR PARA TAMAÑOS MULTIPLES
        capa2=3;           
        b[x1][y1][z1]=10;
        double distancia;
        for(int z=0;z<k;z++)
            {
                for(int y=0;y<j;y++)
                {
                    for(int x=0;x<i;x++)
                    {
                        if (b[x][y][z]<10)
                        {
                            distancia=Math.sqrt(Math.pow((x-x1),2)+Math.pow((y-y1),2)+Math.pow((z-z1),2));
                            if (distancia<capa1)
                                {
                                    b[x][y][z]+=3;
                                    continue;
                                }
                            if (distancia<=capa2)
                                {
                                    b[x][y][z]+=2;
                                }
                        }
                    }
                }
            }
        return b;
    }
    
    public char[][] devolverNivel(int z)
    {
        z=z-1;
        if  ((z>=this.k)||(z<=0))
        {
            //NIVEL VALIDO O SACA UN MENSAJE Y DEVUELVE NULL
            System.out.println("NO ES UN NIVEL VALIDO SOLO EXISTEN  "+this.k+"  Niveles");
            return null;
        }
        char a[][];
        a=new char[this.i][this.j];
        for(int x=0;x<this.i;x++)
            for(int y=0;y<this.j;y++)
            {
                a[x][y]=this.distribucion[x][y][z].sacarEstadoCubo();
            }
        return a;
    }
    
    public boolean asignar(Arqueologo jugador, int x, int y, int z, int o, int eg, int ef, int badi, int broc){
        //variables
        boolean flag = true;
        
        x--;
        y--;
        z--;
        
        //verificar que las coordenadas estén en el rango y que el cubo sea excavable
        if (enRango(x,y,z)||(!distribucion[x][y][z].isExcavable())){
            flag = false;
        }
        else{
            //verificar que se tengan los suficientes miembros disponibles
            int numBroc = jugador.numBroc();
            int numBadi = jugador.numBadi();
            int numO = jugador.numObreros();
            int numEg = jugador.numEg();
            int numEf = jugador.numEf();
            
            if ((numBroc>=broc)&&(numBadi>=badi)&&(numO>=o)&&(numEg>=eg)&&(numEf>=ef)){
                //transferir recursos desde el jugador al cubo
                transferirRecursos(jugador, distribucion[x][y][z], o, eg, ef, badi, broc);
                
                //calcular el tiempo de excavación
                double velocidadTotal = o * Obrero.VELOCIDADBASE + eg * EstudianteGenerales.VELOCIDADBASE + ef * EstudianteFacultad.VELOCIDADBASE;
                distribucion[x][y][z].setTiempo((distribucion[x][y][z].getTiempo())/velocidadTotal);
                
                
                //cambiar el estado del cubo a asignado
                distribucion[x][y][z].setAsignado(true);                
            }
            else{
                flag = false;
            }
            
        }
        
        return flag;
    }
    
    
    
    
    public void transferirRecursos(Arqueologo jugador, Cubo c, int o, int eg, int ef, int badi, int broc){
        //variables
        int l;

        //transferir obrero
        for (l=0;l<o;l++){
            //remover un recurso de arqueologo y agregarlo al cubo
            int m = 0;
            
            while (!(jugador.miembros.get(m) instanceof Obrero)){
                m++;
            }
            
            c.miembros.add(jugador.miembros.get(m));
            jugador.miembros.remove(m);
        }
        
        //transferir estudiante de generales
        for (l=0;l<eg;l++){
            //remover un recurso de arqueologo y agregarlo al cubo
            int m = 0;
            
            while (!(jugador.miembros.get(m) instanceof EstudianteGenerales)){
                m++;
            }
            
            c.miembros.add(jugador.miembros.get(m));
            jugador.miembros.remove(m);
        }
 
        //transferir estudiante de facultad
        for (l=0;l<ef;l++){
            //remover un recurso de arqueologo y agregarlo al cubo
            int m = 0;
            
            while (!(jugador.miembros.get(m) instanceof EstudianteFacultad)){
                m++;
            }
            
            c.miembros.add(jugador.miembros.get(m));
            jugador.miembros.remove(m);
        }
       
        //transferir badilejo
        for (l=0;l<badi;l++){
            //remover un recurso de arqueologo y agregarlo al cubo
            int m = 0;
            
            while (!(jugador.herramientas.get(m) instanceof Badilejo)){
                m++;
            }
            
            c.herramientas.add(jugador.herramientas.get(m));
            jugador.herramientas.remove(m);
        }
        
        //transferir brocha
        for (l=0;l<broc;l++){
            //remover un recurso de arqueologo y agregarlo al cubo
            int m = 0;
            
            while (!(jugador.herramientas.get(m) instanceof Brocha)){
                m++;
            }
            
            c.herramientas.add(jugador.herramientas.get(m));
            jugador.herramientas.remove(m);
        }        
    }
    
    public boolean enRango(int x, int y, int z){
        return((x>0)&&(y>0)&&(z>0)&&(x<i)&&(y<j)&&(z<k));
    }
}
