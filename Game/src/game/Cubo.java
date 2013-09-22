package game;

import java.util.ArrayList;

class Cubo{
    private char tipoCubo;
    private int cantidad;
    private int avance;
    private boolean asignado;
    private boolean excavable;
    private Equipo miequipo;
    private Objeto[] objetos; //=new ArrayList<Objeto>();
    
    public boolean isExcavable(){
        return excavable;
    }
    
    public void setExcavable(boolean excavable){
        this.excavable = excavable;
    }
    
    public boolean getAsignado(){
        return this.asignado;
    }
    
    public void volverEscabable(){
        this.excavable=true;
    }
    
    public boolean puedoEscabar(){
    if (this.miequipo!=null)
        return true;
    else
        return false;
    }
    
    public Cubo(int concentracion,ArrayList<Objeto> milistaObjetos,int spawningRocas,boolean excavable)
        {
            this.cantidad=0;
            this.miequipo=null;
            this.asignado = false;
            Coin moneda;
            moneda=new Coin(spawningRocas);
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
    
    public int getavance(){
        return this.avance;
    }
    
    public int getCantidad(){
        return this.cantidad;
    }
    
    private Objeto sacarAlgo(ArrayList<Objeto> milistaObjetos, int concetracion)
        {
            boolean interrup=false;
            Objeto miobjeto;
            Coin moneda;
            int probabilidad;
            int i=0;
            int civi;
            moneda=new Coin();
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
            if (miobjeto.getcivi()!=0) this.cantidad++;
            return miobjeto;
        }
    
    public void imprime(){
        for(int i=0;i<objetos.length;i++)
                objetos[i].imprime();
    }
    
    public char sacarChar()
        {
            if (this.avance>0)
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
                if (this.cantidad>0)
                    return '-';
                else
                    return ' ';
                }
        }
    public boolean crearEquipo(int obreros,int eeggcc,int facultad){
        if(this.excavable){
            this.miequipo=new Equipo(obreros,eeggcc,facultad);
            this.asignado = true;
        }
        return this.excavable;
    }
    
    public boolean eliminarEquipo(){
        if(this.excavable){
            this.miequipo=null;
            this.asignado=false;
        }
        return this.excavable;
    }
    
    public Resultado ataca (int x,int y,int z){
        Resultado subtotal;
        subtotal=new Resultado();
        int danio=this.miequipo.ataque();
        int costo=this.miequipo.costo();
        subtotal.incCostos(costo);
        this.avance-=danio;
        if (this.avance<=0){
            for(int i=0;i<this.objetos.length;i++){
                if (this.miequipo.prob_imprudencia()){
                    this.objetos[i].romper();
                }
                subtotal.incDinero(this.objetos[i].getValor());
                subtotal.addCordenada(x, y, z, this.objetos[i]);
            }
        }
        return subtotal;
    }
}