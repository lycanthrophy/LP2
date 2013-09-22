package game;

import java.util.ArrayList;


class Resultado{
    private int horas;
    private int dinero;
    private int costos;
    private int tama;
    ArrayList<Coordenada> cordenadas=new ArrayList<>();
    
    public void copiarCordenadas(Resultado a)
        {
            for (int i=0;i<a.cordenadas.size();i++)
                 this.cordenadas.add(a.cordenadas.get(i));
        }
    
    public void resultado()
        {
            this.horas=0;
            this.dinero=0;
            this.costos=0;
            this.tama=0;
        }
    
    public boolean vacio()
        {
        if (tama==0)
            {
            return true;
            }
        else
            return false;
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
    
    public void incCostos(int a)
        {
            this.costos+=a;
        }
    
    public int getCostos()
        {
            return this.costos;
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
            this.tama++;
            this.cordenadas.add(new Coordenada(i,j,k,artefacto));
        }
}