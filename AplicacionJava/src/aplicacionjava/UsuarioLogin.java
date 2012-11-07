/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionjava;

/**
 * Clase auxiliar para el manejo del login
 * 
 * <br/><br/>Sistemas de Información -  Grado Ingeniería Informática T.I. 
 * Curso 2012/13
 * 
 * @author Enrique José Miguel Calvo, Saúl Carranza Gallardo
 * @version 1.0
 * 
 */
public class UsuarioLogin {
    private String nombre;
    private String password;
    private String baseDeDatos;
    private String servidor;

    /**
     * Constuctoro por defecto
     */ 
    public UsuarioLogin() {
    }
    
    /**
     * Constructor sobrecargado que crea los datos de conexion , recibe por paremetro los datos de la conexion
     * @param nombre
     * @param password
     * @param baseDeDatos
     * @param servidor 
     */
    public UsuarioLogin(String nombre, String password, String baseDeDatos, String servidor) {
        this.nombre = nombre;
        this.password = password;
        this.baseDeDatos = baseDeDatos;
        this.servidor = servidor;
    }

    public String getBaseDeDatos() {
        return baseDeDatos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }

    public String getServidor() {
        return servidor;
    }

    public void setBaseDeDatos(String baseDeDatos) {
        this.baseDeDatos = baseDeDatos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }
    
    
}
