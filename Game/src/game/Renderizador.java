package game;

class Renderizador{
    public void verNivel(Mapa mimapa, int nivel){
        char a[][];
        int i, j;
        a = mimapa.devolverNivel(nivel);
        
        System.out.println("Nivel "+nivel+":");
        System.out.print(" "); 
        for(int x=0;x<mimapa.getI();x++) 
            System.out.print(" " + x + " "); 
        System.out.println(); 
        for (j=0; j<mimapa.getJ(); j++){
            for (i=0;i<mimapa.getI();i++){
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }   
}