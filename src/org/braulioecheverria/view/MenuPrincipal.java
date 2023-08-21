package org.braulioecheverria.view;
import java.util.InputMismatchException;
import java.util.Scanner;
import org.braulioecheverria.utils.Lector;
/**
 *
 * @author Brau
 */
public class MenuPrincipal {
    int op = 0;
    Scanner leer = Lector.getInstancia();
    PersonaView ps = PersonaView.getInstancia();
    
    private static MenuPrincipal instancia;
    
    private MenuPrincipal(){    
                   
    }
    
    /**
     *
     * @return retorna la istancia singleton del objeto MenuPrincipal
     */
    public static MenuPrincipal getInstance(){
        if(instancia == null){
            instancia = new MenuPrincipal();
        }
        return instancia;
    }
    
    /**
     * menu de arranque del programa
     */
    public void arranque(){
        try{
            boolean  input = false;
            while(!input){
                     System.out.println("Bienvenido al administrador de personas " + "\n" +
                    "Selecciona la opción que deseas realizar: " +  "\n" +
                    "   1. Listar personas." + "\n" +
                    "   2. Buscar persona. " + "\n" +
                    "   3. Agregar persona. " + "\n" +
                    "   4. Actualizar persona.  " + "\n" +
                    "   5. Eliminar Persona. " + "\n" +
                    "   6. Salir");
                    op = leer.nextInt();
                    switch(op){
                        case 1:
                            ps.listar();
                            break;
                        case 2:
                            ps.buscar();
                            break;
                        case 3:
                            ps.agregar();
                            break;
                        case 4:
                            ps.editar();
                            break;
                        case 5:
                            ps.eliminar();
                            break;
                        case 6:
                            input = true;
                    }
        }
    }catch(InputMismatchException e){
                    System.out.println("Ingresaste un caracter inválido, por favor ingresa un número válido");
                    leer.nextLine();
    }
}
    
}