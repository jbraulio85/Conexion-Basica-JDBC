package org.braulioecheverria.view;
import java.util.InputMismatchException;
import org.braulioecheverria.utils.Lector;
import java.util.Scanner;
import org.braulioecheverria.controller.PersonaController;

/**
 *
 * @author Brau
 */
public class PersonaView {
    private static PersonaView instancia;
    private Scanner leer = Lector.getInstancia();
    private  PersonaController pc = PersonaController.getInstancia();
    private String nombre, apellido, direccion, municipio;
    private int id, telefono;
    
    private PersonaView(){
        
    }
    
    /**
     *
     * @return la instancia singleton del objeto PersonaView
     */
    public static PersonaView getInstancia(){
        if(instancia == null){
            instancia = new PersonaView();
        }
        return instancia;
    }
    
    /**
     * metodo para buscar persona
     */
    public void buscar(){
        boolean validInput = false;
        while(!validInput){
            try{
                System.out.println("Ingresa el id de la persona a buscar: ");
                id = leer.nextInt();
                validInput = true;
            }catch(InputMismatchException e){
                System.out.println("Error: Ingreso una letra en lugar de un número");
                leer.nextLine();
            }
        }
        
        pc.buscarPersona(id);
    }
    
    /**
     * metodo para listar toda las personas
     */
    public void listar(){
        pc.listarPersonas();
    }
    
    /**
     * metodo para editar persona
     */
    public void editar(){
        boolean validInput = false;
        while(!validInput){
            try{
                System.out.println("Ingrese el id: ");
                id = leer.nextInt();
                validInput = true;
            }catch(InputMismatchException e){
                System.out.println("Error: Ingreso una letra en lugar de un número");
                leer.nextLine();
            }
        }
        System.out.println("Ingrese el apellido: ");
        apellido = leer.next();
        System.out.println("Ingrese el nombre: ");
        nombre = leer.next();
        System.out.println("Ingrese dirección: ");
        direccion = leer.next();
        System.out.println("Ingrese municipio: ");
        municipio = leer.next();
        validInput = false;
        while(!validInput){
            try{
                System.out.println("Ingrese No. de teléfono: ");
                telefono = leer.nextInt();
                validInput = true;
            }catch(InputMismatchException e){
                System.out.println("Error: Ingreso una letra en lugar de un número");
                leer.nextLine();
            }
        }
        pc.editarPersona(id, apellido, nombre, direccion, municipio, telefono);
        System.out.println("Datos actualizados exitosamente!!!");
    }
    
    /**
     * metodo para agregar persona
     */
    public void agregar(){
        boolean validInput = false;
        System.out.println("Ingrese el apellido: ");
        apellido = leer.next();
        System.out.println("Ingrese el nombre: ");
        nombre = leer.next();
        System.out.println("Ingrese dirección: ");
        direccion = leer.next();
        System.out.println("Ingrese municipio: ");
        municipio = leer.next();
        while(!validInput){
            try{
                System.out.println("Ingrese No. de teléfono: ");
                 telefono = leer.nextInt();
                 validInput = true;
            }catch(InputMismatchException e){
                System.out.println("Error: Ingreso una letra en lugar de un número");
                leer.nextLine();
            }
        }
        pc.agregarPersona(apellido, nombre, direccion, municipio, telefono);
        System.out.println("Datos agregados exitosamente!!!");
    }
    
    /**
     * metodo para eliminar persona
     */
    public void eliminar(){
        boolean validInput = false;
        while(!validInput){
            try{
                System.out.println("Ingresa el id de la persona a buscar: ");
                 id = leer.nextInt();
                 validInput = true;
            }catch(InputMismatchException e){
                System.out.println("Error: Ingreso una letra en lugar de un número");
                leer.nextLine();
            }
        }
        pc.eliminarPersona(id);
        System.out.println("Registro eliminado exitosamente!!!");
    }
    
}
