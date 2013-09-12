package game;
/**
 * @author kref
 *         Kevin Baba
 *         Rodrigo Maldonado
 *         Daniel Carbajal
 */
import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.StringTokenizer;
import game.test.testClass;

//public class game{
//
//}

public class Game {
    
//    class game(){
//    
//    }

    public static void main(String[] args) throws IOException {
        //reader
        Scanner in = new Scanner(System.in);
        //printer
        OutputStream outputStream = System.out;
        PrintWriter out = new PrintWriter(outputStream);
        //variables
        int option;
        //begin
        
        out.println("Bienvenido (:");
        out.println("Si desea iniciar el juego presione 1, si desea terminar presione 0");
        option = in.nextInt();
        if(option==2){
            
        }
        //close output
        out.close();
    }

}

