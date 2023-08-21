package org.braulioecheverria.model;

/**
 *
 * @author Brau
 */
public class Persona {

    private int idPersona;
    private String apellido;
    private String nombre;
    private String direccion;
    private String municipio;
    private int telefono;

    /**
     * constructor vacio
     */
    public Persona() {
    }

    /**
     *
     * @param idPersona id de constructor lleno
     * @param apellido apellido de contructor lleno
     * @param nombre nombre de constructor lleno
     * @param direccion direccion de constructor lleno
     * @param municipio municipio de constructor lleno
     * @param telefono telefono de constructor lleno
     */
    public Persona(int idPersona, String apellido, String nombre, String direccion, String municipio, int telefono) {
        this.idPersona = idPersona;
        this.apellido = apellido;
        this.nombre = nombre;
        this.direccion = direccion;
        this.municipio = municipio;
        this.telefono = telefono;
    }

    /**
     *
     * @return retorno el id del objeto
     */
    public long getIdPersona() {
        return idPersona;
    }

    /**
     *
     * @param idPersona id a asignar al objeto
     */
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    /**
     *
     * @return retorno el apellido del objeto
     */
    public String getApellido() {
        return apellido;
    }

    /**
     *
     * @param apellido apellido a asignar al objeto
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     *
     * @return retorna el nombre del objeto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre nombre a asignar al objeto
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return retorna la direccion del objeto
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     *
     * @param direccion direccion a asignar al objeto
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     *
     * @return retorna el municpio del objeto
     */
    public String getMunicipio() {
        return municipio;
    }

    /**
     *
     * @param municipio municipio a asignar al objeto
     */
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    /**
     *
     * @return retorna el telefono del objeto
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     *
     * @param telefono telefono a asignar al objeto
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     *
     * @return la impreson de todos los atributos del objeto
     */
    @Override
    public String toString() {
        return "{ "+" \n" + 
                    "   ID: " + idPersona  + " \n"+
                    "   Apellido: " + apellido + " \n"+
                    "   Nombre: " + nombre + " \n"+ 
                    "   Direccion: " + direccion +  " \n"+
                    "   Municipio: " + municipio + " \n"+
                    "   Telefono: " + telefono + " \n"+
                    "} ";
    }

    /**
     *
     * @param idPersona recibe el id como parametro del objeto a imprimir
     * @return imprime solo ciertos atributos del objeto
     */
    public String nombres(int idPersona){
        return "{ "+" \n" + 
                    "   Apellido: " + apellido + " \n"+
                    "   Nombre: " + nombre + " \n"+ 
                    "   Telefono: " + telefono + " \n"+
                    "} ";
    }
}
