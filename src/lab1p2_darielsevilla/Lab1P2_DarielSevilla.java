/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab1p2_darielsevilla;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Dariel Sevilla
 */
public class Lab1P2_DarielSevilla {

    /**
     * @param args the command line arguments
     */
    static Scanner lea = new Scanner(System.in);
    static SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    
    public static void main(String[] args) throws ParseException {
        int menu = 0;
        
        while (menu != 4) {
            System.out.println("1- Torres de Hanobi");
            System.out.println("2- fechas");
            System.out.println("3- sumatoria");
            System.out.println("4- salida");
            System.out.print("Ingrese opcion:");
            menu = lea.nextInt();
            System.out.println("");
            
            //menu de opciones
            switch(menu){
                case 1:
                    //opcion torres
                    System.out.print("Ingrese numero de discos: ");
                    int disc = lea.nextInt();
                    hanoi(disc, 1, 2, 3);
                    break;
                case 2:
                    
                    System.out.print("Ingrese un string separado por comas:");
                    String test = lea.next();
                    String[] array = test.split(",");
                    int fechas = 0;
                    //test
                    for(int i = 0; i < array.length; i++){
                        //split cada elemento de la fecha
                        if(checkDate(array[i])){
                            Date fecha = formato.parse(array[i]);
                            System.out.println(fecha);
                            fechas++;
                        }
                        
                        
                    }
                    
                    if(fechas == 0){
                        System.out.println("\nNo hay fechas en esta cadena\n");
                    }
                    int numFechas = 0;
                    //chequear todas las posibles fechas
                    
                    break;
                case 3:
                    System.out.print("Ingrese limite de sumatoria: ");
                    int lim = lea.nextInt();
                    double respuesta  = pi(lim, 0, 0);
                    System.out.printf("Respuesta: %f%n", respuesta);
                    break;
                
            }
        }
    }

    public static double pi(int k, int n, double respuesta){
        double pow = Math.pow(-1, n);
        respuesta += pow / (2 * n + 1);
        
        if(k == n){
            return 4 * respuesta; 
        }else{
            
            return pi(k, n+1, respuesta);
            
        }
                
    }
    
    public static void hanoi(int n, int origen, int auxiliar, int destino){
        if(n == 1){
            System.out.printf("mover disco %d de %d a %d%n",n,origen, destino);
            n++;
            
        }else{
           
            
            hanoi(n-1, origen, destino, auxiliar);
            System.out.printf("mover disco %d de %d a %d%n", n, origen, destino);
            hanoi(n-1, auxiliar, origen, destino);
        }
        

    }
    
    public static boolean checkDate(String date){
        try{
            formato.parse(date);    
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
