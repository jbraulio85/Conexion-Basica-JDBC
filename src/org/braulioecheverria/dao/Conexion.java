package org.braulioecheverria.dao;

import java.sql.*;

/**
 *
 * @author Brau
 */
public class Conexion {
    private Connection conexion;
    private static Conexion instancia;

    private Conexion (){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/mydb?useSSL=false","root","root");
        }catch(ClassNotFoundException | SQLException | 
                InstantiationException | IllegalAccessException e){
        }
    }
    
    /**
     *
     * @return retorna la instancia singleton de la calse Conexion
     */
    public static Conexion getInstance(){
        if(instancia == null){
            instancia = new Conexion();
        }
        return instancia;
    }
    
    /**
     *
     * @return retorna la conexion
     */
    public Connection getConexion() {
        return conexion;
    }

    /**
     *
     * @param conexion conexion a ser asignada al objeto
     */
    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
    
}
