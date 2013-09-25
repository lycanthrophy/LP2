/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lp2;
import java.util.*;
import java.io.*;

/**
 *
 * @author Kevin
 */
class InterpreteComandos{
    
    private boolean esEntero(String s){
        try{
            Integer.parseInt(s);
        }catch(NumberFormatException e){
            return false;
        }
        return true;    
    }
    
     private int obtenerParametros(String s, ArrayList<Integer> parametros){
        String cadAux;
        int delim1, delim2;
        
        while (s.compareTo("")!=0){
            delim1=s.indexOf('<');
            delim2=s.indexOf('>');
            if ((delim1 < delim2)&&(delim1!= -1)&&(delim2!=-1)){
                cadAux = s.substring(delim1+1, delim2);
                cadAux = cadAux.trim();
                if (esEntero(cadAux)){
                    parametros.add(Integer.parseInt(cadAux));
                    s = s.substring(delim2+1);
                }
                else{
                    s = "";
                }
                
            }
            else{
                s = "";
            }
        }
        return parametros.size();
    }   
    
    public int verificaComando(String s, ArrayList<Integer> parametros){
        //variables
        int rValue, indice;
        boolean conParametros = false;
        String comando;
        indice = s.indexOf(' ');
        parametros.clear();
        
        //cambiar la cadena a minusculas
        s = s.toLowerCase();
        
        //limpiar el arreglo
        parametros.clear();
        
        //sacar la primera palabra del comando
        if (indice == -1){
            comando = s;
        }
        else {
            comando = s.substring(0, indice);
            conParametros = true;
        }
        
        //ver si el comando existe
        if (comando.compareTo("salir")==0){
            if (conParametros){
                rValue = -1;
            }
            else{             
                rValue = 0;
            }
        }
        else if (comando.compareTo("asignar")==0){
             if (conParametros){
                comando = s.substring(indice);
                if (obtenerParametros(comando,parametros)==8){
                    rValue = 1;
                }
                else{
                    return -1;
                }
            }
            else{
                rValue = -1;
            }           
        }
        else if (comando.compareTo("desasignar")==0){
            if (conParametros){
                comando = s.substring(indice);
                if (obtenerParametros(comando,parametros)==3){
                    rValue = 2;
                }
                else{
                    return -1;
                }
            }
            else{
                rValue = 1;
            }            
        }
        else if (comando.compareTo("vernivel")==0){
             if (conParametros){
                 comando = s.substring(indice);
                if (obtenerParametros(comando,parametros)==1){
                    rValue = 3;
                }
                else{
                    return -1;
                }
            }
            else{
                rValue = 1;
            }           
        }
        else if (comando.compareTo("excavar")==0){
            if (conParametros){
                rValue = -1;
            }
            else{
                rValue = 4;
            }            
        }
        else if (comando.compareTo("ayuda")==0){
            if (conParametros){
                rValue = -1;
            }
            else{
                rValue = 5;
            }            
        }
        else{
            rValue = -1;
        }
        return rValue;
    }         
          
}
