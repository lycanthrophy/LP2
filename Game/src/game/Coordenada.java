package game;
class Coordenada{
    private int i,j,k;
    private Objeto miobjeto;
    
    public Coordenada(int i,int j,int k,Objeto artefacto){
        this.i=i;
        this.j=j;
        this.k=k;
        this.miobjeto=new Objeto(artefacto);
    }
    
    public Coordenada(Coordenada a){
        this.i=a.i;
        this.j=a.j;
        this.k=a.k;
        this.miobjeto=new Objeto(a.miobjeto);
    }
    
    public String getNombreObjeto(){
        return miobjeto.getnombre();
    }
    
    public int getValorObjeto(){
        return miobjeto.getValor();
    }
    
    public void imprimeCor(){
        System.out.println("==========================");
        System.out.println("X: "+this.i+" Y: "+this.j+" Z: "+this.k);
        miobjeto.imprime();
    }
    
    public boolean estaRoto(){
        return miobjeto.esta_roto();
    }
}