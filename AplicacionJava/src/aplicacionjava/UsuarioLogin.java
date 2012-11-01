/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionjava;

/**
 * Clase auxiliar para el manejo del login
 * 
 * @author Enrique Miguel y Salul Carranza
 * @version 1.0
 */
public class UsuarioLogin {
    private String nombre;
    private String password;
    private String baseDeDatos;
    private String servidor;

    public UsuarioLogin() {
    }
    

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
