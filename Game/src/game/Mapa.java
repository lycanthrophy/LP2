package game;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Mapa{
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
            this.spawningRocas=rocas;
            this.i=i;
            this.j=j;
            this.k=k;
            this.civi=civi;
            this.distribucion=new Cubo[i][j][k]; 
            ArrayList<Objeto> milistaObjetos;
            int a[][][];
            a=generaFoco(i,j,k);//Matrix de distribucion de obgetos
            milistaObjetos=generarlista(this.civi);
            for(int z=0;z<i;z++)
                for(int y=0;y<j;y++)
                    for(int x=0;x<k;x++)
                        {
                            if (z==0)  //solo sera excavable en la superficie al principio
                                this.distribucion[x][y][z]=new Cubo(a[x][y][z],milistaObjetos,spawningRocas,true);
                            else
                                this.distribucion[x][y][z]=new Cubo(a[x][y][z],milistaObjetos,spawningRocas,false);
                        }
    //          for(int z=0;z<k;z++)
    //            {
    //                for(int y=0;y<j;y++)
    //                {
    //                    for(int x=0;x<i;x++)//PARA VER LAS DISTRIBUCION DE ARTEFACTOS
    //                    {
    //                        System.out.print(" "+this.distribucion[x][y][z].getCantidad()+" ");
    //                    }
    //                    System.out.println();
    //                }
    //                System.out.println("============"+(z+1)+"===============");
    //            } 
        }
    public Resultado escabar()
        {
        boolean flag=true;
        Resultado total=new Resultado();
        Resultado subtotal;
        while(flag)
            {
                for(int z=0;z<this.k;z++)
                    for(int y=0;y<this.j;y++)
                        for(int x=0;x<this.i;x++)
                            {
                                if (this.distribucion[x][y][z].puedoEscabar())
                                {
                                    subtotal=this.distribucion[x][y][z].ataca(x, y, z);
                                    total.incCostos(subtotal.getCostos());
                                    //System.out.println("s");
                                    if (!subtotal.vacio())
                                        {
                                            total.incDinero(subtotal.getDinero());
                                            total.copiarCordenadas(subtotal);
                                            flag=false;
                                            actualiza(x,y,z);
                                        }
                                }    
                            }
                total.incHoras();
            }
        return total;
        }
    
    private ArrayList<Objeto> generarlista(int civilizacion)
        {   
            ArrayList<Objeto> milistaObjetos=new ArrayList<>();
            Objeto artefacto;
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
                            if (civ==civilizacion || 0==civ)
                                {
                                    artefacto=new Objeto(tokens[0],civ,proba);
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
    
    private void actualiza(int x1,int y1,int z1)
        {
            for(int z=0;z<this.k;z++)
                {
                    for(int y=0;y<this.j;y++)
                    {
                        for(int x=0;x<this.i;x++)
                        {
   
                                double distancia=Math.sqrt(Math.pow((x-x1),2)+Math.pow((y-y1),2)+Math.pow((z-z1),2));
                                if (distancia<1.1)
                                    {
                                        this.distribucion[x][y][z].volverEscabable();
                                    }
                        }
                    }
                }
        
        
        }
    
    public void imprimeCuboXYZ(int x,int y,int z)
        {
            this.distribucion[x][y][z].imprime();
        }
    
    public boolean asignar(int x,int y,int z, int obreros, int eeggcc, int facultad)
        {
            
            if ((x>0)&&(y>0)&&(z>0)&&(x<=this.i) && (y<=this.j) && (z<=this.k)){
                x=x-1;
                y=y-1;
                z=z-1;
                
                return this.distribucion[x][y][z].crearEquipo(obreros, eeggcc, facultad);
            }
            else{
                return false;
            }
            
        }
    
    public boolean desasignar(int x, int y, int z)
        {
            if ((x>0)&&(y>0)&&(z>0)&&(x<=this.i) && (y<=this.j) && (z<=this.k)){
                x=x-1;
                y=y-1;
                z=z-1;
                boolean b = this.distribucion[x][y][z].eliminarEquipo();
                return b;
            }
            else{
                return false;
            }
        }
    
    public char[][] devolverNivel(int z)
        {
            z=z-1;
            if  (z>=this.k)
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
                    a[x][y]=this.distribucion[x][y][z].sacarChar();
                    }
            return a;
        }
}