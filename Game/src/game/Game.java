package game;
/**
 * @author keyvhinng Espinoza
 *         Kevin Baba
 *         Rodrigo Maldonado
 *         Daniel Carbajal
 */
import java.io.*;
import java.util.*;
import java.util.StringTokenizer;
import game.test.testClass;

interface ATAQUE{
    public static final int str_obrero=10;
    public static final int str_eeggcc=2;
    public static final int str_facultad=2;
    public static final int dex_obrero=1;
    public static final int dex_eeggcc=18;
    public static final int dex_facultad=2;
    public static final double int_obrero=1.05;
    public static final double int_eeggcc=1.2;
    public static final double int_facultad=1.7;
    public static final int wis_obrero=10;
    public static final int wis_eeggcc=-2;
    public static final int wis_facultad=-5;
    public static final int costo_obrero=5;
    public static final int costo_eeggcc=12;
    public static final int costo_facultad=20;
}

interface Validacion{
    
}

//Kref: NOTA: Reducir el tamnaho de codigo para Interprete
class InterpreteComandos{
    public int verificaComando(String s, Integer inX, Integer inY, Integer inZ, Integer inO, Integer inEg, Integer inEf, Integer inNivel){
        char a;
        boolean error;
        int rValue;
        int nivel=0;
        int x=0, y=0, z=0;
        int eg=0, ef=0, o=0;
        int delim2;
        Integer n;
        String aux="";
        a = s.charAt(0);
        
        error = false;
        rValue = -1;
        
        s= s.toLowerCase();
        switch(a){
            case 's':
                if (s.compareTo("salir")==0){
                    rValue = 0;
                }
                else{
                    rValue = -1;
                }
                break;
            case 'a':
                if (s.length()>7){
                    aux = s.substring(0, 7);
                }
                else{
                    error = true;
                }
                if ((!error)&&(aux.compareTo("asignar")==0)){
                    int k;
                    k = s.indexOf('x');
                    if ((k != -1) && (!error) && (k+2<s.length())&&(s.charAt(k+2)=='<')){
                        aux = s.substring(k+2);
                        delim2 = aux.indexOf('>');
                        
                        if(delim2 != -1){
                            n = new Integer(aux.substring(1,delim2));
                            x = n.intValue(); 
                        }
                        else{
                            error = true;
                        }                      
                    }
                    else{
                        error = true;
                    }
                    k = s.indexOf('y');
                    if ((k != -1) && (!error) && (k+2<s.length())&&(s.charAt(k+2)=='<')){
                        aux = s.substring(k+2);
                        delim2 = aux.indexOf('>');
                        
                        if(delim2 != -1){
                            n = new Integer(aux.substring(1,delim2));
                            y = n.intValue(); 
                        }
                        else{
                            error = true;
                        }                      
                    }
                    else{
                        error = true;
                    }
                    k = s.indexOf('z');
                    if ((k != -1) && (!error) && (k+2<s.length())&&(s.charAt(k+2)=='<')){
                        aux = s.substring(k+2);
                        delim2 = aux.indexOf('>');
                        
                        if(delim2 != -1){
                            n = new Integer(aux.substring(1,delim2));
                            z = n.intValue(); 
                        }
                        else{
                            error = true;
                        }                      
                    }
                    else{
                        error = true;
                    }
                    k = s.indexOf('o');
                    if ((k != -1) && (!error) && (k+2<s.length())&&(s.charAt(k+2)=='<')){
                        aux = s.substring(k+2);
                        delim2 = aux.indexOf('>');
                        
                        if(delim2 != -1){
                            n = new Integer(aux.substring(1,delim2));
                            o = n.intValue(); 
                        }
                        else{
                            error = true;
                        }                      
                    }
                    else{
                        error = true;
                    }
                    k = s.indexOf('g', 7);
                    if ((k != -1) && (!error) && (k+2<s.length())&&(s.charAt(k+2)=='<')){
                        aux = s.substring(k+2);
                        delim2 = aux.indexOf('>');
                        
                        if(delim2 != -1){
                            n = new Integer(aux.substring(1,delim2));
                            eg = n.intValue(); 
                        }
                        else{
                            error = true;
                        }                      
                    }
                    else{
                        error = true;
                    }
                    k = s.indexOf('f');
                    if ((k != -1) && (!error) && (k+2<s.length())&&(s.charAt(k+2)=='<')){
                        aux = s.substring(k+2);
                        delim2 = aux.indexOf('>');
                        
                        if(delim2 != -1){
                            n = new Integer(aux.substring(1,delim2));
                            ef = n.intValue(); 
                        }
                        else{
                            error = true;
                        }                      
                    }
                    else{
                        error = true;
                    }                   
                                     
                }
                if (!error){
                    rValue = 2;
                }
                else{
                    rValue = -1;
                } 
                break;
            case 'd':
                if (s.length()>10){
                    aux = s.substring(0, 10);
                }
                else{
                    error = true;
                }
                if (aux.compareTo("desasignar")==0){
                    int k;
                    k = s.indexOf('x');
                    if ((k != -1) && (!error) && (k+2<s.length())&&(s.charAt(k+2)=='<')){
                        aux = s.substring(k+2);
                        delim2 = aux.indexOf('>');
                        
                        if(delim2 != -1){
                            n = new Integer(aux.substring(1,delim2));
                            x = n.intValue(); 
                        }
                        else{
                            error = true;
                        }                      
                    }
                    else{
                        error = true;
                    }
                    k = s.indexOf('y');
                    if ((k != -1) && (!error) && (k+2<s.length())&&(s.charAt(k+2)=='<')){
                        aux = s.substring(k+2);
                        delim2 = aux.indexOf('>');
                        
                        if(delim2 != -1){
                            n = new Integer(aux.substring(1,delim2));
                            y = n.intValue(); 
                        }
                        else{
                            error = true;
                        }                      
                    }
                    else{
                        error = true;
                    }
                    k = s.indexOf('z');
                    if ((k != -1) && (!error) && (k+2<s.length())&&(s.charAt(k+2)=='<')){
                        aux = s.substring(k+2);
                        delim2 = aux.indexOf('>');
                        
                        if(delim2 != -1){
                            n = new Integer(aux.substring(1,delim2));
                            z = n.intValue(); 
                        }
                        else{
                            error = true;
                        }                      
                    }
                    else{
                        error = true;
                    }
                    if (!error){
                        rValue = 3;
                    }
                    else{
                        rValue = -1;
                    }
                }
                break;
            case 'v':
                aux = s.substring(0,8);
                if (aux.compareTo("vernivel")==0){
                    if ((s.length()>11)&&(s.charAt(9)=='<')&&(s.charAt(s.length()-1)=='>')){
                        aux = s.substring(10,s.length()-1);
                        n = new Integer(aux);
                        nivel = n.intValue();
                        rValue = 1;
                    }
                    else{
                        rValue = -1;
                    }
                }
                break;
            default:
                System.out.println("El comando ingresado no es válido, por favor intente nuevamente");
        }
        
        //asignar valores a parametros por referencia
        inX=x;
        inY=y;
        inZ=z;
        inEg=eg;
        inEf=ef;
        inO=o;
        inNivel=nivel;
        
        System.out.println("x:" +x + " y:"+y +" z:"+z + " eg:"+eg +" ef:"+ef + " o:"+o+" nivel:"+nivel +" rvalue:"+rValue);
        return rValue;
    }
}

//==============================================================================

class Renderizador{
    public void verNivel(Mapa mimapa, int nivel){
        char a[][];
        int i, j;
        a = mimapa.devolverNivel(nivel);

        for (j=0; j<mimapa.getJ(); j++){
            for (i=0;i<mimapa.getI();i++){
                System.out.print(a[i][j]);
            }
            System.out.println();
        }     
    }   
}

//==============================================================================

class equipo implements ATAQUE {
    private int numObreros;
    private int numEeggcc;
    private int numFacultad;
    public equipo(int a, int b ,int c){
        this.numObreros=a;
        this.numEeggcc=b;
        this.numFacultad=c;
    }
    public int ataque()
        {
            int     str=this.numObreros*ATAQUE.str_obrero+
                        this.numEeggcc*ATAQUE.str_eeggcc+
                        this.numFacultad*ATAQUE.str_facultad;
            int     dex=this.numObreros*ATAQUE.dex_obrero+
                        this.numEeggcc*ATAQUE.dex_eeggcc+
                        this.numFacultad*ATAQUE.dex_facultad;
            double  inte=this.numObreros*ATAQUE.int_obrero+
                         this.numEeggcc*ATAQUE.int_eeggcc+
                         this.numFacultad*ATAQUE.int_facultad;
        coin moneda;
        moneda=new coin(dex);
        if (moneda.lanzar())
            return (int)(str*inte);
        else
            return str;
        }
    public int costo()
        {
        return   ATAQUE.costo_eeggcc*this.numEeggcc
                +ATAQUE.costo_facultad*this.numFacultad
                +ATAQUE.costo_obrero*this.numObreros;
        }

    public boolean rompen()
        {
        int  pro= ATAQUE.wis_eeggcc*this.numEeggcc
                 +ATAQUE.wis_facultad*this.numFacultad
                 +ATAQUE.wis_obrero*this.numObreros;
        if (pro>0)
            {
                coin moneda;
                moneda=new coin(pro);
                return moneda.lanzar();
            }
        else
                return false; //ante era TRUE
        }
}

//==============================================================================

class Mapa{
    private cubo [][][] distribucion;
    private int civi;
    int i,j,k,spawningRocas;

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
            this.distribucion=new cubo[i][j][k]; 
            ArrayList<Objeto> milistaObjetos;
            int a[][][];
            a=generaFoco(i,j,k);//Matrix de distribucion de obgetos
            milistaObjetos=generarlista(this.civi);
            for(int z=0;z<i;z++)
                for(int y=0;y<j;y++)
                    for(int x=0;x<k;x++)
                        {
                            if (z==0)
                                this.distribucion[x][y][z]=new cubo(a[x][y][z],milistaObjetos,spawningRocas,true);
                            else
                                this.distribucion[x][y][z]=new cubo(a[x][y][z],milistaObjetos,spawningRocas,false);
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


    //        for(int z=0;z<k;z++)
    //            {
    //                for(int y=0;y<j;y++)
    //                {
    //                    for(int x=0;x<i;x++)
    //                    {
    //                        System.out.print(" "+b[x][y][z]+" ");
    //                    }
    //                    System.out.println();
    //                }
    //                System.out.println("============"+(z+1)+"===============");
    //            }
    //
    //        System.out.println("FOCO :: "+x1+" "+y1+" "+z1);
            return b;
        }
    public void imprimeCuboXYZ(int x,int y,int z)
        {
            this.distribucion[x][y][z].imprime();
        }
    public boolean asignar(int x,int y,int z,int obreros,int eeggcc,int facultad)
        {
            return this.distribucion[x][y][z].crearEquipo(obreros, eeggcc, facultad);
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
//==============================================================================

class cubo{
    private char tipoCubo;
    private int cantidad;
    private int avance;
    private boolean excavable;
    private equipo miequipo;
    private Objeto[] objetos; //=new ArrayList<Objeto>();
    public cubo(int concentracion,ArrayList<Objeto> milistaObjetos,int spawningRocas,boolean excavable)
        {
            this.cantidad=0;
            this.miequipo=null;
            coin moneda;
            moneda=new coin(spawningRocas);
            this.excavable=excavable;
            if (moneda.lanzar())
                {
                    tipoCubo='R';// ES ROCA
                    this.avance=300;  //VIDA
                }
            else
                {
                    tipoCubo='.';//ES TIERRA
                    this.avance=100;  //VIDA;
                }
            Objeto miobjeto;
            int cantArtef;
            if(concentracion<10)
                cantArtef=1+(int) (Math.random() * (concentracion*2));
            else
                cantArtef=5+(int) (Math.random() * (concentracion*2));//FOCO
            objetos=new Objeto[cantArtef];
            for(int i=0;i<cantArtef;i++)
                {
                    miobjeto=sacarAlgo(milistaObjetos,concentracion);
                    objetos[i]=miobjeto;
                    if (0<miobjeto.getcivi())
                        {
                            this.cantidad++;
                        }
                }

        }
    public int getavance()
        {
        return this.avance;
        }
    public int getCantidad()
        {
        return this.cantidad;
        }
    private Objeto sacarAlgo(ArrayList<Objeto> milistaObjetos, int concetracion)
        {
            boolean interrup=false;
            Objeto miobjeto;
            coin moneda;
            int probabilidad;
            int i=0;
            int civi;
            moneda=new coin();
            while(!interrup)
                {
                            i=(int)(Math.random()*(milistaObjetos.size()-1));
                            probabilidad=milistaObjetos.get(i).getrareza();
                            civi=milistaObjetos.get(i).getcivi();
                            if (concetracion!=0 && civi==0)
                                {
                                    probabilidad/=concetracion;
                                }
                            moneda.setproba(probabilidad);
                            interrup=moneda.lanzar();
                }
            miobjeto=new Objeto(milistaObjetos.get(i));
            return miobjeto;
        }
    public void imprime()
        {
            for(int i=0;i<objetos.length;i++)
                    objetos[i].imprime();
        }
    public char sacarChar()
        {
            if (this.avance>0)
                {
                if(this.excavable)
                    return this.tipoCubo;
                else    
                    return '.';
                }
            else
                {
                if (this.cantidad>0)
                    return '-';
                else
                    return ' ';
                }
        }
    public boolean crearEquipo(int obreros,int eeggcc,int facultad)
        {
            if(this.excavable)
                this.miequipo=new equipo(obreros,eeggcc,facultad);
            return this.excavable;
        }
    public void eliminarEquipo(int obreros,int eeggcc,int facultad)
        {
            this.miequipo=null;
        }
}
//==============================================================================

class Objeto{
    private String nombre;
    private int civi;
    private int rareza;
    private boolean estaRoto;
    private int valor;
    public Objeto(String nombre,int civi,int rareza)
        {

            this.nombre=nombre;
            this.civi=civi;
            this.rareza=rareza;
            this.estaRoto=false;
            if (civi!=0)
                this.valor=3000/rareza;  // QUE TANTO VALE
            else
                this.valor=1;
        }
    public Objeto(Objeto a)
        {
            this.nombre=a.nombre;
            this.civi=a.civi;
            this.rareza=a.rareza;
            this.estaRoto=a.estaRoto;
            this.valor=a.valor;
        }
    public void imprime()
        {
            String name=null;
            if (civi==0) name="BASURA!::";
            if (civi==1) name="Artefacto Paracas::";
            String estado=null;
            if (this.estaRoto) estado="Dañado";
            else estado="Intacto";
            System.out.print(name+" ");
            System.out.print(this.nombre+"  \t");
            System.out.print("|Rareza:: "+rareza+"%");
            System.out.println("| Valor:: "+valor+"$"+"| Estado:: "+estado);
        }
    public int getrareza()
        {
            return this.rareza;
        }
    public String getnombre()
        {
            return this.nombre;
        }
    public int getcivi()
        {
            return this.civi;
        }
    public boolean esta_roto()
        {
        return this.estaRoto;
        }
    public void romper()
        {
            this.estaRoto=true;
            this.valor/=3;   //SE ENCIENDE EL FLAG DE ROTO Y SE DISMINUYE EL PRECIO
        }
}

//CLASE MONEDA==================================================================
class coin{ // LANZANDO UNA MONEDA CON DIFERENTES PROBABILIDADES
    private int proba;
    public coin(int a)
        {   
            if (a>100)
                {
                    a/=100;
                    System.out.println("NO PUEDO EXITIR UNA PROBABILIDAD DE EVENTO MAYOR A 100%");
                    System.out.println("SE TOMO "+a+"% COMO LA PROBABILIDAD DEL EVENTO");
                }
            this.proba=a;
        }
    public coin()
        {
            this.proba=50;
        }
    public void setproba(int a)
        {
            if (a>100)
                {
                    a/=100;
                    System.out.println("NO PUEDO EXITIR UNA PROBABILIDAD DE EVENTO MAYOR A 100%");
                    System.out.println("SE TOMO " +a+"% COMO LA PROBABILIDAD DEL EVENTO");
                }
            this.proba=a;
        }
    public int getproba()
        {
            return this.proba;
        }
    public Boolean lanzar()
        {
        int x = (int) (Math.random() * 100);  
        if (x<this.proba)
            return true;
        else
            return false;
        }
}
//==============================================================================
class resultado{
    int horas;
    int dinero;
    ArrayList<cordenada> cordenadas;
    void resultado()
        {
            this.cordenadas=new ArrayList<>();
            this.horas=0;
            this.dinero=0;
        }
    public int getDinero()
        {
            return this.dinero;
        }
    public int getHoras()
        {
            return this.horas;
        }
    public void incHoras()
        {
            this.horas++;
        }
    public void incDinero(int dineroGanado)
        {
            this.dinero+=dineroGanado;
        }
    public void imprimeObjetos()
        {
            for(int x=0;x<this.cordenadas.size();x++)
                {
                    this.cordenadas.get(x).imprimeCor();
                }
        }
    public void addCordenada(int i,int j, int k,Objeto artefacto)
        {
            cordenada punto;
            punto=new cordenada(i,j,k,artefacto);
            cordenadas.add(punto);

        }
}
//=========================================================================
class cordenada{
    private int i,j,k;
    private Objeto miobjeto;
    public cordenada(int i,int j,int k,Objeto artefacto)
        {
        this.i=i;
        this.j=j;
        this.k=k;
        this.miobjeto=new Objeto(artefacto);
        }
    void imprimeCor()
        {
            System.out.println("==========================");
            System.out.println("X: "+this.i+" X: "+this.j+" Z: "+this.k);
            miobjeto.imprime();
        }
}


//====================================================================

public class Game {
    
    public static void main(String[] args) throws IOException {
        //reader
        Scanner in = new Scanner(System.in);
        //printer
        PrintStream out = System.out;
        //variables
        String nombPlayer;
        String s;
        int option,  sitArq, exit;
        boolean valid;
        //begin
        exit = 0;
        out.println("====== Mario Jones ========");
        out.println("Bienvenido(:");
        out.println("Por favor inserte su nombre");
        nombPlayer = in.next();
        out.println(nombPlayer + ", preparate para una gran aventura !");
        out.println("Inserte la opcion que desea");
        out.println("[1] = Jugar");
        out.println("[2] = Salir");
        valid = false;
        do{
            try{
                s = in.next();
                option = Integer.parseInt(s);
            }catch(NumberFormatException e){
                option = -1;
            }
            if(option==1 || option==2){
                valid = true;
            }else{
                //out.println("S = " + s);
                out.println("Opcion incorrecta, por favor presiona 1 o 2");
                
            }
        }while(!valid);
        if(option==1){
            //begin game

            out.println("Deseas jugar en el sitio arquelogico 1 o 2 ?");
            sitArq = in.nextInt();
            //check
            while(sitArq!=1 && sitArq!=2){
                out.println("Sitio incorrecto ):");
                sitArq = in.nextInt();
            }
            
        }else{
            out.println("Gracias por jugar");
        }
    }

}

