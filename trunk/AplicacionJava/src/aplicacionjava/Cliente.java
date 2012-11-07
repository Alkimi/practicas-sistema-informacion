package aplicacionjava;

/**
 *
 * Clase auxiliar para manejar la lista de cliente
 * 
 * <br/><br/>Sistemas de Información -  Grado Ingeniería Informática T.I. 
 * Curso 2012/13
 * 
 * @author Enrique José Miguel Calvo, Saúl Carranza Gallardo
 * @version 1.0
 * 
 */
public class Cliente {
    private String codigo;
    private String nombre;
    private String apellido;
    private String apellido2;
    private String calle;
    private String numero;
    private String piso;
    private String metros;

    /**
     * Constructor del cliente recibe por parametro todos los datos del cliente
     * @param codigo
     * @param nombre
     * @param apellido
     * @param apellido2
     * @param calle
     * @param numero
     * @param piso
     * @param metros 
     */
    public Cliente(String codigo, String nombre, String apellido, String apellido2, String calle, String numero, String piso, String metros) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.apellido2 = apellido2;
        this.calle = calle;
        this.numero = numero;
        this.piso = piso;
        this.metros = metros;
    }

    public String getApellido() {
        return apellido;
    }

    public String getApellido2() {
        return apellido2;
    }

    public String getCalle() {
        return calle;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMetros() {
        return metros;
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

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setMetros(String metros) {
        this.metros = metros;
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
