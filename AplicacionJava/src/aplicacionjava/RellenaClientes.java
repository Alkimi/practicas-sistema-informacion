package aplicacionjava;


import Utilidades.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;

/**
 * Esta clase esta destinada a la creaccion de los clientes en la base de datos
 * 
 * @author Enrique Miguel y Salul Carranza
 * @version 1.0
 */
public class RellenaClientes {
        private  ConexionBD conexionBD=null;
        private  ResultSet consulta=null;
        
    
        /**
         * Constructor de la clase, simplemente realiza la conexion a la base de datos
         */
    public RellenaClientes(){
        try {
           conexionBD = new ConexionBD("root","toor","consumoelectrico");

           //
           conexionBD.consultaUpdate("drop table clientes2");
           conexionBD.consultaUpdate("create table clientes2 like clientes");
           conexionBD.consultaUpdate("drop table  mediciones2");
           conexionBD.consultaUpdate("create table mediciones2 like mediciones");
           //
           
        } catch (ClassNotFoundException ex){
            System.out.println("Error al conectar con la base de datos 1");
            System.exit(500);
        } catch( SQLException ex){
            System.out.println("Error al conectar con la base de datos 2");
            System.exit(1);
        }
    }
    
    /**
     * Realiza la consulta a la base de datos si hay clientes o no introducidos
     * 
     * @return true, si hay clientes, false si no hay clientes 
     */
    public boolean hayClientes(){
        try {
            consulta= conexionBD.consultaSelect("Select * from clientes2 limit 1");
        } catch (SQLException ex){
            System.out.println("Error en la base de datos");
            System.exit(2);
        }
        return (conexionBD.totalFilas()>0);
    }
    
    /**
     * Crea aleatoriamente el numero de clientes pasado por parametro en la base 
     * de datos con los datos de 3  provicias aleatorias (reduce a galicia que al
     * principio solo hay datos de galicia) y de esa tres provincias aleatorias 
     * elige 9 ciudades y las calles de dichas ciudades.
     * 
     */
    public void creaClientes(int numeroClientes){
            String cadena;
            int x,y,z,k;
            Random R = new Random();
            try {
                //cogemos los nombres y los pasamos a un vector auxiliar
                consulta=conexionBD.consultaSelect("Select Nombre from tnombre");
                // creamos un array de tantos nombres como filas haya
                String[] nombres = new String[conexionBD.totalFilas()];
                // control por si hay nombres incorrectos cosas del utf-8
                 int cantidad_nombre=0;
                 //recorremos la consulta 
                 while (consulta.next()){
                     cadena = consulta.getString(1);
                     //si no esta vacio lo agrega e incrementa el contador
                     if (!cadena.equals("")){
                        nombres[cantidad_nombre]=cadena;
                        cantidad_nombre++;
                     }
                 }
                 // cogemos los apellidos y los pasamos a un vector auxiliar
                 consulta=conexionBD.consultaSelect("Select Apellido from tapellidos");
                 // creamos un array de tantos apellidos como filas haya
                 String[] apellidos = new String[conexionBD.totalFilas()];
                 // control por si hay apellidos incorrectos cosas del utf-8
                 int cantidad_apellidos=0;
                 //recorremos la consulta
                 while (consulta.next()){
                     cadena = consulta.getString(1);
                     //si no esta vacio lo agrega e incrementa el contador
                     if (!cadena.equals("")){
                        apellidos[cantidad_apellidos]=cadena;
                        cantidad_apellidos++;
                     }
                 }
                
                 //crea la consulta para conseguir las 9 ciudades aleatorias de las 3 provicncias aleatorias
                 // y lo guarda en una tabla auxiliar que luego borraremos
                 cadena="create table t1 SELECT CodigoPoblacion, t1.CodigoProvincia FROM "
                         + "poblaciones AS t2 join (SELECT CodigoProvincia FROM provincias where "
                         + "(CodigoProvincia=15 or CodigoProvincia=27 or CodigoProvincia=32 or CodigoProvincia=36) "
                         + "order by rand() LIMIT 3 ) as t1 on t2.CodigoProvincia=t1.CodigoProvincia order by rand() limit 9";
                 // realizamos la consulta, es del tipo update ya que vamos a crear una tabla
                 conexionBD.consultaUpdate(cadena);
                 
                 // crea una consulta con las calles de todas las ciudades selecionadas
                 cadena="SELECT t3.idCalle, t3.CodPoblacion, t4.CodigoProvincia"
                          +" FROM callespoblaciones AS t3 right JOIN t1 as t4 ON t3.CodPoblacion = t4.CodigoPoblacion;";
                  
                 // realizamos la consulta
                 consulta=conexionBD.consultaSelect(cadena);   
                 
                 // cogemos los datos de las calles y lo metemos en un vector auxiliar
                 String[][] calles;
                 calles = new String[conexionBD.totalFilas()][3];
                 // creamos la matriz de objejos para su inicializacion
                 for (int i=0;i<calles.length;i++){
                       for (int j=0;j<calles[i].length;j++){
                           calles[i][j]=new String();
                       }
                 }
                 //contador de calles
                 int cantidad_calles=0;
                 //rellenamos el vector auxiliar de calles con los datos de la consulta
                 while (consulta.next()){
                         calles[cantidad_calles][0]=consulta.getString(1);
                         calles[cantidad_calles][1]=consulta.getString(2);
                         calles[cantidad_calles][2]=consulta.getString(3);
                        cantidad_calles++;
                 }
                 
                 
                 
                 //borramos la tabla temporal
                conexionBD.consultaUpdate("drop table t1");

              // /* // forma 1 y 3
                 cadena="INSERT INTO clientes2(Nombre, Apellido, Apellido2, Calle, "
                         +"Numero, Piso, Metros, CodigoPoblacion, CodigoProvincia"
                         +") VALUES("; 
             //   */ 
                 /* // forma 2
                 
                   cadena="INSERT INTO clientes2(Nombre, Apellido, Apellido2, Calle, "
                         +"Numero, Piso, Metros, CodigoPoblacion, CodigoProvincia"
                         +") VALUES(?,?,?,?,?,?,?,?,?)";
                
                 
               */
               /* // forma 2
                   PreparedStatement pstmt = conexionBD.prepareStatement(cadena);
             */

        
                       for (int i = 0;i<numeroClientes;i++) {
                     
                        x=R.nextInt(cantidad_nombre);
                        y=R.nextInt(cantidad_apellidos);
                        z=R.nextInt(cantidad_apellidos);
                        k=R.nextInt(cantidad_calles);
                        
                    /* //forma 2 
                       pstmt.setString(1, nombres[x]);
                        pstmt.setString(2, apellidos[y]);
                        pstmt.setString(3, apellidos[z]);
                        pstmt.setInt(4, Integer.parseInt(calles[k][0]));
                        pstmt.setInt(5, R.nextInt(150));
                        pstmt.setInt(6, R.nextInt(10));
                        pstmt.setInt(7, R.nextInt(120)+30);
                        pstmt.setString(8, calles[k][1]);
                        pstmt.setInt(9, Integer.parseInt(calles[k][2]));
                        
                        pstmt.addBatch();
                      if ((i+1) % 1000 == 0) {
                            pstmt.executeBatch(); //se ejecuta cada 1000 consultas para no saturar el conector
                        }    */
                        
                        if (i%50==0){
                            System.out.println("inserccion: "+ i);
                        }

                 /*    //forma 1   
                     conexionBD.consultaUpdate(cadena+"'"+nombres[x]+"', '"+apellidos[y]+"', '"+apellidos[z]+"', "
                             +calles[k][0]+", "+R.nextInt(150)+", "+R.nextInt(10)+", "
                             +String.valueOf( R.nextInt(120)+30)+", '" + calles[k][1]+"', "+calles[k][2]+");" );
                 */    
                    /* //forma 2
                      pstmt.addBatch(cadena+"'"+nombres[x]+"', '"+apellidos[y]+"', '"+apellidos[z]+"', "
                             +calles[k][0]+", "+R.nextInt(150)+", "+R.nextInt(10)+", "
                             +String.valueOf( R.nextInt(120)+30)+", '" + calles[k][1]+"', "+calles[k][2]+");" );
                  */
                     
                 //    /* // forma 3
                      conexionBD.preparaUpdate(cadena+"'"+nombres[x]+"', '"+apellidos[y]+"', '"+apellidos[z]+"', "
                             +calles[k][0]+", "+R.nextInt(150)+", "+R.nextInt(10)+", "
                             +String.valueOf( R.nextInt(120)+30)+", '" + calles[k][1]+"', "+calles[k][2]+");" );
               //      */
              }

                 /* // forma 2
                   pstmt.executeBatch();
                   pstmt.close();
                */
            //  /* // forma 3
                conexionBD.realizaUpdare();// falla al insertar pero inserta la mayoria      

            //   */
              } catch (SQLException ex) {
                System.out.println("error en la consulta SQL");
               // System.exit(2);
            }           
             try {
                 ////////////creamos las mediciones
                 // cogemos los identificadores de clientes
                 // realizamos la consulta
                 consulta=conexionBD.consultaSelect("select Codigo from clientes2"); 
                 int[] clientes;
                 clientes = new int[conexionBD.totalFilas()];
                 cadena="insert into mediciones2(Cliete,FechaHora,KW) values(";
                 float kw;
                 Timestamp tiempo = new Timestamp(0);
                 for(int i=0;i<clientes.length;i++){
                   
                     tiempo.setTime(new Date(2012,1,15,12,24).getTime());
                     kw = R.nextInt(500)+R.nextFloat();
                     conexionBD.preparaUpdate(cadena+clientes[i]+", "+tiempo.toString()+", "+String.valueOf(kw)+");");
                     
                     tiempo.setTime(new Date(2012,2,15,10,4).getTime());
                     kw = R.nextInt(500)+R.nextFloat();
                     conexionBD.preparaUpdate(cadena+clientes[i]+", "+tiempo.toString()+", "+String.valueOf(kw)+")");
                    
                     tiempo.setTime(new Date(2012,3,15,16,50).getTime());
                     kw = R.nextInt(500)+R.nextFloat();
                     conexionBD.preparaUpdate(cadena+clientes[i]+", "+tiempo.toString()+", "+String.valueOf(kw)+")");
                    
                     tiempo.setTime(new Date(2012,4,15,11,35).getTime());
                     kw = R.nextInt(500)+R.nextFloat();
                     conexionBD.preparaUpdate(cadena+clientes[i]+", "+tiempo.toString()+", "+String.valueOf(kw)+")");
                     
                     tiempo.setTime(new Date(2012,5,15,12,15).getTime());
                     kw = R.nextInt(500)+R.nextFloat();
                     conexionBD.preparaUpdate(cadena+clientes[i]+", "+tiempo.toString()+", "+String.valueOf(kw)+")");
                     
                      if (i%50==0){
                            System.out.println("inserccion: "+ i);
                        }
                 }
                 conexionBD.realizaUpdare();
                

            conexionBD.cerrarBaseDatos();
        } catch (SQLException ex) {
            System.out.println("error en la consulta SQL");
               // System.exit(2);
        }
   }
}
