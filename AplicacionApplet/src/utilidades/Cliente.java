package utilidades;

/**
 *
 * Clase auxiliar para manejar la lista de cliente
 * 
 * @author Enrique José Miguel Calvo, Saúl Carranza Gallardo
 * @version 1.0
 * 
 * Sistemas de Información -  Grado Ingeniería Informática T.I. 
 * Curso 2012/13
 * 
 */
public class Cliente {
    private String codigo;
    private String nombre;
    private String apellido;
    private String apellido2;
    private String numero;
    private String piso;

    /**
     * Constructor general
     * @param codigo
     * @param nombre
     * @param apellido
     * @param apellido2
     * @param numero
     * @param piso 
     */
    public Cliente(String codigo, String nombre, String apellido, String apellido2, String numero, String piso) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.apellido2 = apellido2;
        this.numero = numero;
        this.piso = piso;
    }

    public String getApellido() {
        return apellido;
    }

    public String getApellido2() {
        return apellido2;
    }


    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumero() {
        return numero;
    }

    public String getPiso() {
        return piso;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }
    
    
}
