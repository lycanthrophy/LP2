package game;
import java.util.*;
import java.io.*;
/**
 *
 * @author Keyvhinng Espinoza
 *         Kevin Baba
 *         Rodrigo Maldonado
 *         Daniel Carbajal
 */        

//MAIN CLASS
//====================================================================
public class Game {
    public static void main(String args[]) 
    {
        //Menu Principal
        //Impresion del titulo de juego
        System.out.println("\t\t\t_____");
        System.out.println("\t\t      /      \\");
        System.out.println("\t\t_____/ _____ _\\___");
        System.out.println("\t\t     |     ^   ^\\");
        System.out.println("\t\t    [      |_____|");   

        
        System.out.println("  _________ \t      \\   /_______\\      _____               .__        ");
        System.out.println(" /   _____/__ ________   ___________    /     \\ _____ _______|__| ____  ");
        System.out.println(" \\_____  \\|  |  \\____ \\_/ __ \\_  __ \\  /  \\ /  \\\\__  \\\\_  __ \\  |/  _ \\ ");
        System.out.println(" /        \\  |  /  |_> >  ___/|  | \\/ /    Y    \\/ __ \\|  | \\/  (  <_> )");
        System.out.println("/_______  /____/|   __/ \\___  >__|    \\____|__  (____  /__|  |__|\\____/ ");
        System.out.println("        \\/      |__|        \\/                \\/     \\/                 ");
        System.out.println("     ____.                            ");
        System.out.println("    |    | ____   ____   ____   ______");
        System.out.println("    |    |/  _ \\ /    \\_/ __ \\ /  ___/");
        System.out.println("/\\__|    (  <_> )   |  \\  ___/ \\___ \\ ");
        System.out.println("\\________|\\____/|___|  /\\___  >____  >");
        System.out.println("                     \\/     \\/     \\/ ");
        
        //reader
        Scanner in = new Scanner(System.in);
        
        //constantes
        final int PLATAINICIAL = 12000;
        final int HORASINICIAL = 10000;
        final int PUNTOSINICIAL = 0;
        final int LIMITEGANAR = 100;
        
        //variables e inicializacion
        int option;
        String nombre;
        int plata, horas, puntos, civi;
        int obreros, facultad, generales;
        ArrayList<Coordenada> inventario;
        inventario = new ArrayList<>();
        boolean fl = false;
        
        //welcome
        System.out.println("Bienvenido a Super Mario Jones! Presione enter para continua...");
        in.nextLine();
        
        while(true){             //BUCLE PRINCIPAL DEL JUEGO
            System.out.println("Si desea iniciar el juego presione 1, si desea terminar presione 0");
            option = in.nextInt();
            in.nextLine();
            if(option==1){
                //pedir datos del usuario
                System.out.println("***");
                System.out.println("Ingrese su nombre y presione enter:");
                nombre = in.nextLine();
                System.out.println("***");
                System.out.println("Bienvenid@ " + nombre + " ! Recuerde que cuenta con S/." + PLATAINICIAL + " para financiar tu excavación y " + HORASINICIAL +" horas");
                
                //pedir datos del equipo
                System.out.println("***");
                System.out.println("Ingrese el número de obreros con los que le gustaría trabajar y presione enter:");
                obreros = in.nextInt();
                System.out.println("Ingrese el número de alumnos de EEGGCC con los que le gustaría trabajar y presione enter:");
                generales = in.nextInt();
                System.out.println("Ingrese el número de alumnos de facultad con los que le gustaría trabajar y presione enter:");
                facultad = in.nextInt();
                
                //pedir datos de la civilización
                while(true){
                    System.out.println("***");
                    System.out.println("Ingrese el número de la civilización que desea visitar y presione enter:");
                    System.out.println("1 Civilizacion A");
                    System.out.println("2 Civilizacion B");
                    civi = in.nextInt();
                    if ((civi != 1)&&(civi !=2)){
                        System.out.println("Numero ingresado inválido");
                    }
                    else{
                        System.out.println("***");
                        break;
                    }
                }
        
                 //inicializar variables
                plata = PLATAINICIAL;
                horas = HORASINICIAL;
                puntos = PUNTOSINICIAL;
                inventario.clear();
                               
                //crear mapa
                Mapa mimapa= new Mapa(10,10,10,civi,10);
                
                //renderizar el nivel más alto
                Renderizador ren=new Renderizador();
                ren.verNivel(mimapa, 1);
                System.out.println("***");
                
                //generar el interprete y las variables para almacenar los comandos ingresados
                InterpreteComandos interp = new InterpreteComandos();
                int [] inX = {-1};
                int [] inY = {-1};
                int [] inZ = {-1};
                int [] inO = {-1};
                int [] inEg = {-1};
                int [] inEf = {-1};
                int [] inNivel = {-1};
                int retVal;
                in.nextLine();//limpiar buffer
                
                while ((horas > 0) && (plata >0)){
                //usuario ingresa un comando
                    System.out.println("Ingrese un comando:");
                    String comando;
                    comando = in.nextLine();
                    //usar clase InterpreteComandos
                    retVal = interp.verificaComando(comando, inX, inY, inZ, inO, inEg, inEf, inNivel);

                    switch (retVal){
                        case 0:
                            //ejecuta salir
                            System.out.println("***SALIR***");
                            System.out.println("¿Seguro que desea salir del mapa actual? Presione 0 para salir, caso contrario presione 1");
                            option=in.nextByte();
                            in.nextLine();
                            if(option==0){
                                fl=true;
                            }
                            break;
                        case 1:
                            //ejecuta verNivel
                            System.out.println("***VER NIVEL***");
                            ren.verNivel(mimapa, inNivel[0]);
                            System.out.println("***");
                            break;
                        case 2:
                            //ejecuta asignar
                            System.out.println("***ASIGNAR***");
                            boolean b;
                            b = mimapa.asignar(inX[0], inY[0], inZ[0], inO[0], inEg[0], inEf[0]);
                            if (b){
                                System.out.println("Asignacion exitosa");
                            }
                            else{
                                System.out.println("No se pudo asignar el equipo al cubo especificado");
                            }
                            System.out.println("***");
                            break;
                        case 3:
                            //ejecuta desasignar
                            System.out.println("***DESASIGNAR***");
                            b = mimapa.desasignar(inX[0], inY[0], inZ[0]);
                            if (b){
                                System.out.println("Desasignacion exitosa");
                            }
                            else{
                                System.out.println("No se pudo asignar el equipo al cubo especificado");
                            }                            
                            System.out.println("***");
                            break;
                        case 4:
                            //ejecuta excavar
                            System.out.println("***EXCAVAR***");
                            Resultado res;
                            res = mimapa.escabar();
                            horas = horas - res.getHoras();
                            plata = plata - res.getCostos();
                            if (res.getDinero()>0){
                                System.out.println("FELICIDADES! HA ENCONTRADO LOS SIGUIENTES ARTEFACTOS:");
                                puntos = puntos + res.getDinero();
                                for (int a = 0; a<res.cordenadas.size();a++){
                                    inventario.add(res.cordenadas.get(a));
                                    System.out.println("-"+res.cordenadas.get(a).getNombreObjeto()+" (Valor: "+res.cordenadas.get(a).getValorObjeto()+")");
                                }                                
                            }

                            System.out.println("***");
                            break;
                        case 5:
                            System.out.println("***INVENTARIO***");
                            System.out.println("CANTIDAD DE ARTEFACTOS RECOLECTADOS: " + inventario.size());
                            for (int a =0; a<inventario.size();a++){
                                String estado;
                                if (inventario.get(a).estaRoto()) estado="Dañado";
                                else estado="Intacto";
                                System.out.println("-"+inventario.get(a).getNombreObjeto()+" (Valor: "+inventario.get(a).getValorObjeto()+", Estado: " + estado+")");
                            }
                            System.out.println("***");
                            break;
                        default:
                            System.out.println("***ERROR***");
                            System.out.println("Comando errado");
                            System.out.println("***");
                            break;                
                    }
                    if(fl==true) break;
                }
                if (horas<=0){
                    System.out.println("Se ha terminado el tiempo!");
                }
                else if(plata <=0){
                    System.out.println("Se le ha acabado el dinero!");
                }
                System.out.println("=======================");
                System.out.println("La partida ha terminado");
                System.out.println("***");
                System.out.println("PUNTAJE TOTAL: "+puntos);
                System.out.println("CANTIDAD DE ARTEFACTOS RECOLECTADOS: " + inventario.size());
                for (int a =0; a<inventario.size();a++){
                    System.out.println("-"+inventario.get(a).getNombreObjeto()+" (Valor: "+inventario.get(a).getValorObjeto()+")");
                }

                if (puntos > LIMITEGANAR){
                    System.out.println("FELICIDADES!! SU PUNTUACIÓN ES SUFICIENTE PARA DESCUBRIR LA CIVILIZACION");
                }
                else{
                    System.out.println("LO SENTIMOS, NO HA ALCANZADO LA PUNTUACIÓN SUFICIENTE PARA DESCUBRIR LA CIVILIZACION");
                }
                System.out.println("======================");
            }
            else if (option!=0){
                System.out.println("Opción no válida");
                System.out.println("***");
            }
            else{
                System.out.println("¿Seguro que desea salir del juego? Presione 0 para salir, caso contrario presione 1");
                option = in.nextInt();
                if (option == 0){
                    break;
                }
                else{
                    System.out.println("***");
                }
            }
        }
        
    }  
}