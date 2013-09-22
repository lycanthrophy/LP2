package game;

class Coin{ // LANZANDO UNA MONEDA CON DIFERENTES PROBABILIDADES
    private int proba;
    public Coin(int a)
        {   
            if (a>100)
                {
                    a/=100;
                    System.out.println("NO PUEDO EXITIR UNA PROBABILIDAD DE EVENTO MAYOR A 100%");
                    System.out.println("SE TOMO "+a+"% COMO LA PROBABILIDAD DEL EVENTO");
                }
            this.proba=a;
        }
    public Coin()
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