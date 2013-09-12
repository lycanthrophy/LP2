package game;
/**
 * @author keyvhinng Espinoza
 *         Kevin Baba
 *         Rodrigo Maldonado
 *         Daniel Carbajal
 */
import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.StringTokenizer;
import game.test.testClass;

class Juego{
    
}

public class Game {
    
    public static void main(String[] args) throws IOException {
        //reader
        Scanner in = new Scanner(System.in);
        //printer
        PrintStream out = System.out;
        //variables
        String nombPlayer;
        int option,  sitArq, exit;
        //begin
        exit = 0;
        out.println("======Mario Jones========");
        out.println("Bienvenido(:");
        out.println("Por favor inserte su nombre");
        nombPlayer = in.next();
        out.println(nombPlayer + ", preparate para una gran aventura !");
        out.println("Si desea iniciar el juego presione 1, si desea salir presione 2");
        option = in.nextInt();
        while(option!=1 && option!=2){
            out.println("Opcion incorrecta, por favor presiona 1 o 2");
            option = in.nextInt();
        }
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

