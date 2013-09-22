package game;

class Equipo implements Features {
    private int numObreros;
    private int numEeggcc;
    private int numFacultad;
    
    public Equipo(int a, int b ,int c){
        this.numObreros=a;
        this.numEeggcc=b;
        this.numFacultad=c;
    }
    
    public int ataque(){
        int     str=this.numObreros*Features.str_obrero+
                    this.numEeggcc*Features.str_eeggcc+
                    this.numFacultad*Features.str_facultad;
        int     dex=this.numObreros*Features.dex_obrero+
                    this.numEeggcc*Features.dex_eeggcc+
                    this.numFacultad*Features.dex_facultad;
        double  inte=this.numObreros*Features.int_obrero+
                     this.numEeggcc*Features.int_eeggcc+
                     this.numFacultad*Features.int_facultad;
        Coin moneda;
        moneda=new Coin(dex);
        if (moneda.lanzar())
            return (int)(str*inte); //critical
        else
            return str;
    }
    
    public int costo(){
        //costo por hora
        return   Features.costo_eeggcc*this.numEeggcc
                +Features.costo_facultad*this.numFacultad
                +Features.costo_obrero*this.numObreros;
    }

    public boolean prob_imprudencia(){
        int  pro= Features.wis_eeggcc*this.numEeggcc
                 +Features.wis_facultad*this.numFacultad
                 +Features.wis_obrero*this.numObreros;
        if (pro>0){
            Coin moneda;
            moneda=new Coin(pro);
            return moneda.lanzar();
        }
        else
            return false; //antes era true
    }
}