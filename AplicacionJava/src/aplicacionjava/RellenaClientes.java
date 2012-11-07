package aplicacionjava;


import gui.Principal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

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
public class RellenaClientes {
        private  ConexionBD conexionBD=null;
        private  ResultSet consulta=null;
        
    
        /**
         * Constructor de la clase, simplemente realiza la conexion a la base de datos
         */
    public RellenaClientes(UsuarioLogin ul){
        try {
            conexionBD = new ConexionBD(ul.getNombre(), ul.getPassword(), ul.getBaseDeDatos(), ul.getServidor());
        } catch (ClassNotFoundException ex){
            System.out.println("Error al conectar con la base de datos" + ex.getMessage());
            System.exit(500);
        } catch( SQLException ex){
            //System.out.println("Error al conectar con la base de datos" + ex.getMessage());
            //System.exit(1);
            Principal.logueo = false;
        }
    }
    
    /**
     * Realiza la consulta a la base de datos si hay clientes o no introducidos
     * 
     * @return true, si hay clientes, false si no hay clientes 
     */
    public boolean hayClientes(){
        try {
            consulta= conexionBD.consultaSelect("Select * from clientes limit 1");
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
            String cadenaaux;
            String enlace;
            int k;
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

                //preparamos la cadena para los clientes
                cadena="INSERT INTO clientes(Nombre, Apellido, Apellido2, Calle, "
                         +"Numero, Piso, Metros, CodigoPoblacion, CodigoProvincia"
                         +") VALUES "; 

                //podemos hacer unas 120 insercciones en cada insert, asi que dividimos 
                // el total entre 120
                for (int j=0;j<numeroClientes/120;j++){
                    cadenaaux=cadena;
                    enlace="(";
                    for( int i=0;i<120;i++){
                        k=R.nextInt(cantidad_calles);
                        //creamos la cadena de la consulta.
                        cadenaaux=cadenaaux+enlace+"'"+nombres[R.nextInt(cantidad_nombre)]+"', '"+apellidos[R.nextInt(cantidad_apellidos)]+"', '"
                        +apellidos[R.nextInt(cantidad_apellidos)]+"', " +calles[k][0]+", "
                        +R.nextInt(100)+", "+R.nextInt(10)+", "+(R.nextInt(90)+30)+", '"
                        + calles[k][1]+"', "+calles[k][2]+")";
                        if(i==0){
                            enlace=",(";
                        }
                    }
                    
                    conexionBD.consultaUpdate(cadenaaux);
                }
                // realizamos el resto de los clientes que falten
                cadenaaux=cadena;
                enlace="(";
                for (int i=0;i<(numeroClientes%120);i++){
                         k=R.nextInt(cantidad_calles);
                        
                        cadenaaux=cadenaaux+enlace+"'"+nombres[R.nextInt(cantidad_nombre)]+"', '"+apellidos[R.nextInt(cantidad_apellidos)]+"', '"
                        +apellidos[R.nextInt(cantidad_apellidos)]+"', " +calles[k][0]+", "
                        +R.nextInt(100)+", "+R.nextInt(10)+", "+(R.nextInt(90)+30)+", '"
                        + calles[k][1]+"', "+calles[k][2]+")";
                        if(i==0){
                            enlace=",(";
                        }
                    }
                 conexionBD.consultaUpdate(cadenaaux);

                 ////////////creamos las mediciones
                 consulta=conexionBD.consultaSelect("select Codigo from clientes"); 
                 int[] clientes;
                 //creamos un vector de todos los clientes
                 clientes = new int[conexionBD.totalFilas()];
                 int j=0;
                 while (consulta.next()){
                       clientes[j]=consulta.getInt(1);
                       j++;
                 }
                 //prepararmos la inserccion de las mediciones
                 cadena="insert into mediciones(Cliente,FechaHora,KW) values(";
                 
                 //creamos las 5 lecturas del contador
                 for(int i=0;i<clientes.length;i++){

                     cadenaaux=cadena+clientes[i]+", '2012-01-15 12:24:00', "+(R.nextInt(500)+R.nextFloat())+"),(";

                     cadenaaux=cadenaaux+clientes[i]+", '2012-02-15 10:04:00', "+(R.nextInt(500)+R.nextFloat())+"),(";

                     cadenaaux=cadenaaux+clientes[i]+", '2012-03-15-16:50:00', "+(R.nextInt(500)+R.nextFloat())+"),(";
                     
                     cadenaaux=cadenaaux+clientes[i]+", '2012-04-15 11:35:00', "+(R.nextInt(500)+R.nextFloat())+"),(";

                     cadenaaux=cadenaaux+clientes[i]+", '2012-05-15 12:15:00', "+(R.nextInt(500)+R.nextFloat())+");";

                     conexionBD.consultaUpdate(cadenaaux);
                 }
        } catch (SQLException ex) {
            System.out.println("error en la consulta SQL");
            System.exit(1);
        }
        conexionBD.cerrarBaseDatos();    
   }
}
