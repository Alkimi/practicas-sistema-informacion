/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionjava;

/**
 *
 * @author Alkimi
 */
public class AplicacionJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        RellenaClientes rellenaClientes = new RellenaClientes();
          if (!rellenaClientes.hayClientes()){
              System.out.println("NO hay clientes");
              rellenaClientes.creaClientes(20000);
          }
    }
}
