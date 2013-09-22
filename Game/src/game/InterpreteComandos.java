package game;
class InterpreteComandos{
    public int verificaComando(String s, int[] inX, int[] inY, int[] inZ, int[] inO, int[] inEg, int[] inEf, int[] inNivel){
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
            case 'i':
                if (s.compareTo("inventario")==0){
                    rValue = 5;
                }
                else{
                    rValue = -1;
                }
                break;    
            case 'e':
                if (s.compareTo("excavar")==0){
                    rValue = 4;
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
        inX[0]=x;
        inY[0]=y;
        inZ[0]=z;
        inEg[0]=eg;
        inEf[0]=ef;
        inO[0]=o;
        inNivel[0]=nivel;
        return rValue;
    }
}