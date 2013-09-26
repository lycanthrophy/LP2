package lp2;
import java.util.*;
import java.io.*;
//Rodrigo 's  test
/**
 *
 * @author
 */
//MAIN CLASS====================================================================
public class Juego {
    //constantes
    static final int LIMITEGANAR = 100;
        
    //variables globales de la clase
    static Arqueologo jugador;
    static boolean fl;
    static Scanner in;
    
    static Mapa mimapa;
    
    private static int leeOpcion(){
        int option;
        System.out.println("Si desea iniciar el juego presione 1, si desea terminar presione 0");
        option = in.nextInt();
        in.nextLine();
        
        return option;
    }
    
    private static void pideDatosIniciales(){
        //datos personales
        System.out.println("***");
        System.out.println("Ingrese su nombre y presione enter:");
        jugador.setNombre(in.nextLine());
        System.out.println("***");
        System.out.println("Bienvenid@ " + jugador.getNombre() + " ! Recuerde que cuenta con S/.12000 para financiar su excavación y 100 horas");

        //datos del equipo
        int o, eg, ef;
        System.out.println("***");
        System.out.println("Ingrese el número de obreros con los que le gustaría trabajar y presione enter (costo de obrero por hora: S/. 30):");
        o = in.nextInt();
        System.out.println("Ingrese el número de alumnos de EEGGCC con los que le gustaría trabajar y presione enter (costo de alumno de EEGGCC por hora: S/. 50):");
        eg = in.nextInt();
        System.out.println("Ingrese el número de alumnos de facultad con los que le gustaría trabajar y presione enter (costo de alumno de facultad por hora: S/. 80):");
        ef = in.nextInt();
        in.nextLine();
        
        Obrero auxO;
        for (int i = 0; i<o;i++){
            auxO = new Obrero();
            jugador.addMiembro(auxO);
        }
 
        EstudianteGenerales auxEg;
        for (int i = 0; i<eg;i++){
            auxEg = new EstudianteGenerales();
            jugador.addMiembro(auxEg);
        }
        
        EstudianteFacultad auxEf;
        for (int i = 0; i<ef;i++){
            auxEf = new EstudianteFacultad();
            jugador.addMiembro(auxEf);
        }        
        
        //datos de las herramientas
        int badi, broc;
        System.out.println("***");
        System.out.println("Ingrese el número de badilejos con los que le gustaría trabajar (costo por badilejo: S/. 400):");
        badi = in.nextInt();
        System.out.println("Ingrese el número de brochas con los que le gustaría trabajar (costo por brocha: S/. 100):");
        broc = in.nextInt();
        in.nextLine();
        
        Badilejo auxBadi;
        for (int i = 0; i<badi;i++){
            auxBadi = new Badilejo();
            jugador.addHerramienta(auxBadi);
            jugador.setPlata(jugador.getPlata()-auxBadi.costo);
        }

        Brocha auxBroc;
        for (int i = 0; i<broc;i++){
            auxBroc = new Brocha();
            jugador.addHerramienta(auxBroc);
            jugador.setPlata(jugador.getPlata()-auxBroc.costo);
        }
        
        //datos de la civilizacion
        while(true){
            System.out.println("***");
            System.out.println("Ingrese el número de la civilización que desea visitar y presione enter:");
            System.out.println("1 Civilizacion A");
            System.out.println("2 Civilizacion B");
            jugador.setCivi(in.nextInt());
            in.nextLine();
            if ((jugador.getCivi() != 1)&&(jugador.getCivi() !=2)){
                System.out.println("Numero ingresado inválido");
            }
            else{
                System.out.println("***");
                break;
            }
        }        
    }
    
    
    private static void mensajeFin(){
        if (jugador.getTiempo()<=0){
            System.out.println("Se ha terminado el tiempo!");
        }
        else if(jugador.getPlata() <=0){
            System.out.println("Se le ha acabado el dinero!");
        }
        System.out.println("=======================");
        System.out.println("La partida ha terminado");
        System.out.println("***");
        System.out.println("PUNTAJE TOTAL: "+jugador.getPuntos());

        if (jugador.getPuntos() > LIMITEGANAR){
            System.out.println("FELICIDADES!! SU PUNTUACIÓN ES SUFICIENTE PARA DESCUBRIR LA CIVILIZACION");
        }
        else{
            System.out.println("LO SENTIMOS, NO HA ALCANZADO LA PUNTUACIÓN SUFICIENTE PARA DESCUBRIR LA CIVILIZACION");
        }
        System.out.println("======================");        
    }
    
    private static void cmdSalir(){
        //ejecuta salir
        int option;
        System.out.println("***SALIR***");
        System.out.println("¿Seguro que desea salir del mapa actual? Presione 0 para salir, caso contrario presione 1");
        option=in.nextInt();
        in.nextLine();
        if(option==0){
            fl=false;
        }        
    }
    
     private static void cmdAsignar(ArrayList<Integer> parametros){
        //ejecuta asignar
        System.out.println("***ASIGNAR***");
        
        //preparar variables
        boolean b;
        b = mimapa.asignar(jugador, parametros.get(0), parametros.get(1), parametros.get(2), parametros.get(3), parametros.get(4), parametros.get(5), parametros.get(6), parametros.get(7));
        if (b){
            System.out.println("Asignacion exitosa");
        }
        else{
            System.out.println("No se pudo asignar el equipo al cubo especificado");
        }
        System.out.println("***"); 
    }
    
    private static void cmdDesasignar(ArrayList<Integer> parametros){
        //ejecuta desasignar
//        System.out.println("***DESASIGNAR***");
//        boolean b;
//        //b = mimapa.desasignar(parametros.get(0), parametros.get(1), parametros.get(2));
//        if (b){
//            System.out.println("Desasignacion exitosa");
//        }
//        else{
//            System.out.println("No se pudo asignar el equipo al cubo especificado");
//        }                            
//        System.out.println("***");        
    }
    
    private static void cmdVerNivel(ArrayList<Integer> parametros){
        //ejecuta verNivel
        Renderizador ren = new Renderizador();
        System.out.println("***VER NIVEL***");
        ren.verNivel(mimapa, parametros.get(0));
        System.out.println("***");        
    }
    
    private static void cmdExcavar(){
        //ejecuta excavar
        System.out.println("***EXCAVAR***");

        System.out.println("***");      
    }
    
    private static void cmdAyuda() throws IOException{
   //Manejo del archivo de ayuda
    FileReader EscritorAyuda = new FileReader("Ayuda.txt");
    while(EscritorAyuda.ready()){
        System.out.print((char)EscritorAyuda.read());
    }
    EscritorAyuda.close(); 
    }
	
    private static void mensajeInicio() throws IOException{
    //Manejo del archivo de Introduccion
    FileReader EscritorIntro = new FileReader("Introduccion.txt");
    while(EscritorIntro.ready()){
        System.out.print((char)EscritorIntro.read());
    }
    EscritorIntro.close();
    }
    
    private static void cmdError(){
        System.out.println("***ERROR***");
        System.out.println("Comando errado");
        System.out.println("***");        
    }
    
    public static void main(String args[]) throws IOException 
    {
        //Imprimir pantalla de inicio
        mensajeInicio();
        cmdAyuda();
        
        //variables locales e inicialización
        int retVal;
        int opcion;  
 
        in = new Scanner(System.in);
        jugador = new Arqueologo();
        
        //welcome
        System.out.println("Bienvenido a Super Mario Jones!");
        
        //
        while(true){
            opcion = leeOpcion();
                    
            if(opcion==1){
                //inicializar variables
                jugador.inicializar();
                fl = true;
                
                //pedir datos del usuario
                pideDatosIniciales();
                             
                //crear mapa
                mimapa= new Mapa(10,10,10,jugador.getCivi(),10);
                
                //renderizar el nivel más alto
                Renderizador ren=new Renderizador();
                ren.verNivel(mimapa, 1);
                System.out.println("***");
                
                //generar el interprete y las variables para almacenar los comandos ingresados
                InterpreteComandos interp = new InterpreteComandos();
                
                //crear el arraylist de parametros
                ArrayList<Integer> parametros = new ArrayList<>();
                
                //bucle principal
                while ((jugador.getTiempo() > 0) && (jugador.getPlata() >0) && fl){
                    //usuario ingresa un comando
                    System.out.println("Ingrese un comando:");
                    String comando;
                    comando = in.nextLine();
                    comando = comando.trim();
                    //correr el comando
                    retVal = interp.verificaComando(comando, parametros); 
                    
                    //ejecutar la alternativa
                    System.out.println("retVal " + retVal); 
                    switch(retVal){
                        case 0:
                            //salir
                            cmdSalir();
                            break;
                        case 1:
                            //asignar
                            cmdAsignar(parametros);
                            break;
                        case 2:
                            //desasignar
                            cmdDesasignar(parametros);
                            break;
                        case 3:
                            //vernivel
                            cmdVerNivel(parametros);
                            break;
                        case 4:
                            //excavar
                            cmdExcavar();
                            break;
                        case 5:
                            //ayuda
                            cmdAyuda();
                            break;
                        default:
                            cmdError();
                            break;
                                              
                    }
                }
                mensajeFin();
            }
            else if (opcion==0){
                System.out.println("¿Seguro que desea salir del juego? Presione 0 para salir, caso contrario presione 1");
                opcion = in.nextInt();
                if (opcion == 0){
                    break;
                }
                else{
                    System.out.println("***");
                }               
            }
            else{
                System.out.println("Opción no válida");
                System.out.println("***");
            }
        }
        in.close();
    }//FIN MAIN
}
