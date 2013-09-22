package game;

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
            String estado;
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
    
    public int getValor()
        {
            return this.valor;
        }
}