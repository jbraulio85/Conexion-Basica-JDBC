package org.braulioecheverria.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.braulioecheverria.dao.Conexion;
import org.braulioecheverria.model.Persona;

/**
 *
 * @author BraulioEcheverria
 */
public class PersonaController {
    
    private static PersonaController instancia;
    
    private PersonaController(){
        
    }
    
    /**
     *
     * @return retorna instancia singleton de personacontroller
     */
    public static synchronized PersonaController getInstancia(){
        if(instancia == null){
            instancia = new PersonaController();
        }
        return instancia;
    }

    /**
     *
     * @param id parametro que se envia en el procedimiento almacenado buscar
     */
    public void buscarPersona(int id) {
        try {
            PreparedStatement sp = Conexion.getInstance().getConexion().prepareCall("call sp_BuscarPersona(?);");
            sp.setInt(1, id);
            ResultSet resultado = sp.executeQuery();
            while (resultado.next()) {
                Persona persona1 = new Persona();
                persona1.setIdPersona(resultado.getInt(1));
                persona1.setApellido(resultado.getNString(2));
                persona1.setNombre(resultado.getNString(3));
                persona1.setDireccion(resultado.getNString(4));
                persona1.setMunicipio(resultado.getNString(5));
                persona1.setTelefono(resultado.getInt(6));
                System.out.println(persona1.nombres(id));
            }
            resultado.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * imprime resultset de la entidad persona
     */
    public void listarPersonas() {
            try {
            PreparedStatement sp = Conexion.getInstance().getConexion().prepareCall("call sp_ListarPersonas();");
            ResultSet resultado = sp.executeQuery();
            while (resultado.next()) {
                Persona persona1 = new Persona();
                persona1.setIdPersona(resultado.getInt(1));
                persona1.setApellido(resultado.getNString(2));
                persona1.setNombre(resultado.getNString(3));
                persona1.setDireccion(resultado.getNString(4));
                persona1.setMunicipio(resultado.getNString(5));
                persona1.setTelefono(resultado.getInt(6));
                System.out.println(persona1.toString());
            }
            resultado.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     *
     * @param id de la persona a editar
     * @param apellido nuevo apellido a asignar
     * @param nombre nuevo nombre a asignar
     * @param direccion nueva direccion a asignar
     * @param municipio nuevo municipio a asignar
     * @param telefono nuevo telefono a asignar
     */
    public void editarPersona(int id, String apellido, String nombre, String direccion, String municipio, int telefono){
        try {
            PreparedStatement sp = Conexion.getInstance().getConexion().prepareCall("call sp_EditarPersona(?,?,?,?,?,?);");
            sp.setInt(1, id);
            sp.setString(2, apellido);
            sp.setString(3, nombre);
            sp.setString(4, direccion);
            sp.setString(5, municipio);
            sp.setInt(6, telefono);
            sp.execute();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     *
     * @param apellido apellido a agregar db
     * @param nombre nombre a agregar a db
     * @param direccion direccion a agregar a db
     * @param municipio municipio a agregar a db
     * @param telefono telefono a agregar a db
     */
    public void agregarPersona(String apellido, String nombre, String direccion, String municipio, int telefono){
        try {
            PreparedStatement sp = Conexion.getInstance().getConexion().prepareCall("call sp_AgregarPersona(?,?,?,?,?);");
            sp.setString(1, apellido);
            sp.setString(2, nombre);
            sp.setString(3, direccion);
            sp.setString(4, municipio);
            sp.setInt(5, telefono);
            sp.execute();         
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     *
     * @param id id de la persona a aliminar de db
     */
    public void eliminarPersona (int id){
        try {
            PreparedStatement sp = Conexion.getInstance().getConexion().prepareCall("call sp_EliminarPersona(?);");
            sp.setLong(1, id);
            sp.execute();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
