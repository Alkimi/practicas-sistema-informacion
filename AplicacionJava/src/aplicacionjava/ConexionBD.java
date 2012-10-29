package aplicacionjava;

/**
 * Clase general para la conexión a la base de datos
 * 
 * @author Enrique José Miguel Calvo, Saúl Carranza Gallardo
 * @version 1.0
 *
 * Sistemas de Información - Grado Ingeniería Informática T.I. Curso 2012/13
 *
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionBD {
    private String userName;
    private String password;
    private String baseDatos;
    private String servidor;
    private Connection conexion=null;
    public Statement instruccion=null;
    ResultSet conjuntoResultados=null; // resultado de la ultima consulta

   
    
    
    /**
     * Constuctor parametrizado para conectarse a una base de dato en el
     * servidor local es decir LOCALHOST, se le pasa por parametro el usuario,
     * la contraseña y el nombre de la base de datos, puede lanzar excepciones
     *
     * @param Usuario, nombre del usuario con acceso a la base de datos
     * @param Password, contraseña del usuario con acceso a la base de datos
     * @param BaseDatos, nombre de la base de datos,
     * @throws ClassNotFoundException, lanza esta excepcion si no esta el
     * conector jdbc
     * @throws SQLException, lanza esta excepcion si no conecta con la base de
     * datos
     */ 
    
    public ConexionBD(String Usuario, String Password, String BaseDatos) throws ClassNotFoundException, SQLException {
        userName = Usuario;
        password = Password;
        baseDatos = BaseDatos;
        servidor = "localhost";
        inicializa();
    }

    /**
     * Constuctor parametrizado para conectarse a una base de dato en el servidor
     * local es decir LOCALHOST, se le pasa por parametro el usuario, la contraseña
     * la url donde esta el servidor y el nombre de la base de datos, puede lanzar excepciones
     * 
     * @param Usuario, nombre del usuario con acceso a la base de datos
     * @param Password, contraseña del usuario con acceso a la base de datos
     * @param BaseDatos, nombre de la base de datos,
     * @param url, direcion url de donde esta la base de datos
     * @throws ClassNotFoundException, lanza esta excepcion si no esta el conector jdbc
     * @throws SQLException, lanza esta excepcion si no conecta con la base de datos
     */
   public ConexionBD(String Usuario, String Password, String BaseDatos, String url) throws ClassNotFoundException, SQLException{
        userName=Usuario;
        password=Password;
        baseDatos=BaseDatos;
        servidor=url;
        inicializa();
   }
   
   /**
    * Crea la conexion a la base de datos con los parametros adecuados internos del obejeto.
    * 
     * @throws ClassNotFoundException, lanza esta excepcion si no esta el conector jdbc
     * @throws SQLException, lanza esta excepcion si no conecta con la base de datos
    */
   private void inicializa() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver"); 
        conexion = DriverManager.getConnection("jdbc:mysql://"+servidor+"/"+baseDatos, userName , password);
        instruccion = conexion.createStatement();
   }
   
   /**
    * Devuelve una consulta del tipo SELECT formateada  o una excepcion si la 
    * consulta es invalida
    * 
    * @param Cadena, cadena ha de contener el selec de la consulta SQL
    * 
    * @return la consulta formateada
    * @throws SQLException, se produce la excepcion si la consulta no es correcta
    */
   public StringBuilder consultaYmostrar(String Cadena) throws SQLException{
       StringBuilder resultados = new StringBuilder();
       try{
          conjuntoResultados = instruccion.executeQuery (Cadena);


          ResultSetMetaData metaDatos = conjuntoResultados.getMetaData();
          int numeroDeColumnas = metaDatos.getColumnCount();
          for (int i = 1; i <= numeroDeColumnas; i++) {
             resultados.append(metaDatos.getColumnName(i) + "\t");
          }
          resultados.append("\n");
          while (conjuntoResultados.next()) {
            for (int i = 1; i <= numeroDeColumnas; i++) {
                resultados.append(conjuntoResultados.getObject(i) + "\t");
            }
            resultados.append("\n");
          }
       } catch (SQLException ex) {
          throw ex;
       }
       return resultados;
   }
   
   /**
    * Realiza una consulta del tipo SELECT a la base de datos, lanza una expcepcion
    * si la consulta es invalida
    * 
    * @param Cadena, la cadena que contiene la consulta en SQL
    * 
    * @return la consulta realizda en la base de datos en un resulSet
    * @throws SQLException, se produce la excepcion si la consulta no es correcta
    */
   public ResultSet consultaSelect (String Cadena) throws SQLException{
        try {
            conjuntoResultados = instruccion.executeQuery (Cadena);
        } catch (SQLException ex) {
            throw ex;
        }
        return conjuntoResultados;
   }

   /**
    * Realiza una consulta a la base de dato del tipo:
    * DELETE, INSERT, CREATE TABLE, UPDATE, DROP, lanza un expcecion si
    * la consulta es invalida
    * 
    * @param Cadena, la cadena que contiene la consulta en SQL
    * 
    * @return o bien el numero de filas  para declaraciones SQL Data Manipulation Language (DML) 
    * y 0  para las sentencias de SQL que no devuelven nada
    * 
    * @throws SQLException, se produce la excepcion si la consulta no es correcta
    */
   public boolean consultaUpdate(String Cadena) throws SQLException{
       boolean aux;
        try {
            aux= instruccion.execute(Cadena);
        } catch (SQLException ex) {
            throw ex;
        }
        return aux;
     }
   
   /**
    * Devuelve el ResulSet de la ultima consulta realizad a la base de datos
    * 
    * @return El ultimo ResulSet de la consulta SQL  valida ejecutada
    * 
    */
   public ResultSet ultimaConsulta(){
       return conjuntoResultados;
   }
   
   
   /**
    * Cierra la conexion a la base de datos
    */
   public void cerrarBaseDatos(){
        try {
            conexion.close();
        } catch (SQLException ex) {
           
        }
   }
   
   /**
    * Devuelve el numero total de filas de la ultima 
    * consulta valida realizada en SQL
    * 
    * @return El numero de filas
    */
       public int totalFilas() {
        int numFilas = 0;
        try {

            conjuntoResultados.last();
            numFilas = conjuntoResultados.getRow();
            conjuntoResultados.beforeFirst();

        } catch (Exception e) {
        }
        return numFilas;
    }

}
