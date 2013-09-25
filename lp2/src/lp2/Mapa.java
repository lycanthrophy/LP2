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
        return true;
    }
       
}
