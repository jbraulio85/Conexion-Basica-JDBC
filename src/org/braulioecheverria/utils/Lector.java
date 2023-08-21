package org.braulioecheverria.utils;
import java.util.Scanner;

/**
 *
 * @author Brau
 */
public class Lector {
    private static Scanner instancia;
    
    private Lector(){
        
    }
    
    /**
     *
     * @return retorna la instancia singleton del objeto Lector
     */
    public static synchronized Scanner getInstancia(){
        if(instancia == null){
            instancia = new Scanner(System.in);
        }
        return instancia;
    }
    
}
