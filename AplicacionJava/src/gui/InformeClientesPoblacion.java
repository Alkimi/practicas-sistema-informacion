package gui;

import practica2.HiloConsultasClientesPoblacion;
import aplicacionjava.Poblacion;
import aplicacionjava.Provincia;
import aplicacionjava.callespoblaciones;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ProgressMonitor;
import javax.swing.Timer;
import net.sf.jasperreports.engine.JRException;
import practica2.ReporteFactura;

/**
 * Formulario en el que se selecciona un cliente en concreto para generar
 * su correspondiente factura.
 * 
 * @author Enrique José Miguel Calvo, Saúl Carranza Gallardo
 * @version 2.0
 *
 */
public class InformeClientesPoblacion extends javax.swing.JFrame {

    //Declaración de variables
    ResultSet conjuntoResultados = null;
    List<Provincia> listaProvincias = new ArrayList<>();
    List<Poblacion> listaPoblaciones = new ArrayList<>();
    String codigoProvinciaAux;
    String codigoPoblacionAux;
    int opcionSeleccionada = -1;
    String pobActual = null;
    aplicacionjava.Conversion conAux = new aplicacionjava.Conversion();
    String codPob = null;
    static int cp = -1;
    static String pobla = null;
    static String provi = null;

    /**
     * Creates new form NuevaCallePoblacion
     */
    public InformeClientesPoblacion() {
        initComponents();

        setLocationRelativeTo(null);

        rellenaProvincias();

        codigoProvinciaAux = extraerCodigoProvinciaSeleccinada();

        rellenaPoblacion();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lbPob1 = new javax.swing.JLabel();
        ComboProvincia = new javax.swing.JComboBox();
        ComboPoblacion = new javax.swing.JComboBox();
        btCancelar = new javax.swing.JButton();
        btAceptar = new javax.swing.JButton();
        lbCargando = new javax.swing.JLabel();

        setTitle("Informe Clientes por Poblacion");

        jLabel1.setText("Provincia");

        lbPob1.setText("Población");

        ComboProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboProvinciaActionPerformed(evt);
            }
        });

        ComboPoblacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione" }));
        ComboPoblacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboPoblacionActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btAceptar.setText("Generar Facturas");
        btAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(121, Short.MAX_VALUE)
                .addComponent(btCancelar)
                .addGap(18, 18, 18)
                .addComponent(btAceptar)
                .addGap(37, 37, 37))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(lbCargando))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(lbPob1))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ComboProvincia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ComboPoblacion, 0, 184, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ComboProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboPoblacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPob1))
                .addGap(18, 18, 18)
                .addComponent(lbCargando)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar)
                    .addComponent(btAceptar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Cierra el formulario
     *
     * @param evt
     */
    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btCancelarActionPerformed

    /**
     * Llama al metodo de rellenar el combo de poblaciones
     *
     * @param evt
     */
    private void ComboProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboProvinciaActionPerformed
        rellenaPoblacion();
    }//GEN-LAST:event_ComboProvinciaActionPerformed

    /**
     * Llama al metodo que controla cuando se pulsa el boton aceptar
     *
     * @param evt
     */
    private void btAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptarActionPerformed
        try {
            Aceptar();
        } catch (InterruptedException ex) {
            Logger.getLogger(InformeClientesPoblacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btAceptarActionPerformed

    private void ComboPoblacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboPoblacionActionPerformed
    }//GEN-LAST:event_ComboPoblacionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InformeClientesPoblacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformeClientesPoblacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformeClientesPoblacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformeClientesPoblacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformeClientesPoblacion().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboPoblacion;
    private javax.swing.JComboBox ComboProvincia;
    private static javax.swing.JButton btAceptar;
    private static javax.swing.JButton btCancelar;
    private javax.swing.JLabel jLabel1;
    private static javax.swing.JLabel lbCargando;
    private javax.swing.JLabel lbPob1;
    // End of variables declaration//GEN-END:variables

    /**
     * Muestra el formulario en la opcion de introducir calles
     *
     */
    public void Mostrar() {
        setVisible(true);

        opcionSeleccionada = 2;
        btAceptar.requestFocusInWindow();
    }

    /**
     * Rellena el combo de Provincias
     *
     */
    private void rellenaProvincias() {
        //Borra el combobox
        ComboProvincia.removeAllItems();

        //Hago una consulta que me devuelva todas la provincias con sus códigos y las almaceno en conjuntoResultados
        try {
            conjuntoResultados = Principal.cbd.consultaSelect("SELECT * FROM  provincias");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la conexión con la base de datos");
        }

        int numeroDeColumnas = 0;
        ResultSetMetaData metaDatos = null;


        try {
            metaDatos = conjuntoResultados.getMetaData();
            numeroDeColumnas = metaDatos.getColumnCount();

            //creo el contador para ir pivotando entre las columnas de la tabla
            int cont = 0;
            String cod = null;
            String nom = null;

            while (conjuntoResultados.next()) {
                for (int i = 1; i <= numeroDeColumnas; i++) {

                    switch (cont) {
                        case 0:
                            cod = conjuntoResultados.getObject(i).toString();
                            cont = 1;
                            break;
                        case 1:
                            nom = conjuntoResultados.getObject(i).toString();
                            //creo un objeto provincia, variable
                            Provincia aux = new Provincia(cod, nom);
                            listaProvincias.add(aux);
                            cont = 0;
                            break;
                    }
                }
            }
            //Le solicito a la lista que me devuelva un iterador con todos los el elementos contenidos en ella
            Iterator iterador = listaProvincias.listIterator();

            while (iterador.hasNext()) {
                Provincia pr = (Provincia) iterador.next();

                ComboProvincia.addItem(pr.getProvincia());

                codigoProvinciaAux = extraerCodigoProvinciaSeleccinada();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la conexión con la base de datos");
        }
    }

    /**
     * Rellena el combo de Poblacion
     *
     */
    private void rellenaPoblacion() {

        //Borra el combobox
        ComboPoblacion.removeAllItems();
        //Borra la lista de poblaciones
        listaPoblaciones.clear();
        //Extrae el codigo de la provincia seleccionada
        codigoProvinciaAux = extraerCodigoProvinciaSeleccinada();

        //Hago una consulta que me devuelva las poblaciones de la provincia seleccionada
        try {
            conjuntoResultados = Principal.cbd.consultaSelect("SELECT CodigoProvincia,CodigoPoblacion,Poblacion FROM poblaciones WHERE CodigoProvincia=" + codigoProvinciaAux);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la conexión con la base de datos");
        }

        //Declaro algunas variables para poder rellenar el combo
        int numeroDeColumnas = 0;
        ResultSetMetaData metaDatos = null;


        try {
            metaDatos = conjuntoResultados.getMetaData();
            numeroDeColumnas = metaDatos.getColumnCount();

            //Creo el contador para ir pivotando entre las columnas de la tabla
            int cont = 0;
            //Variables que almacenan los datos que se añaden al final del bucle
            String codProv = null;
            String codPob = null;
            String nom = null;

            while (conjuntoResultados.next()) {
                for (int i = 1; i <= numeroDeColumnas; i++) {

                    switch (cont) {
                        case 0:
                            codProv = conjuntoResultados.getObject(i).toString();
                            cont = 1;
                            break;
                        case 1:
                            codPob = conjuntoResultados.getObject(i).toString();
                            cont = 2;
                            break;
                        case 2:
                            nom = conjuntoResultados.getObject(i).toString();
                            //Creo un objeto poblacion y añado los datos que se han ido recogiendo el switch
                            Poblacion aux = new Poblacion(codProv, codPob, nom);
                            listaPoblaciones.add(aux);
                            cont = 0; //para que vuelva a rellenar desde el primer campo
                            break;
                    }
                }
            }

            //Le solicito a la lista que me devuelva un iterador con todos los el elementos contenidos en ella
            Iterator iterador = listaPoblaciones.listIterator();

            //En caso de no existir ninguna poblacion para la provincia muestro en el combo vacio, sino relleno el combo
            if (listaPoblaciones.isEmpty()) {
                ComboPoblacion.addItem("--Vacío--");

                codigoPoblacionAux = null;
            } else {
                while (iterador.hasNext()) {
                    Poblacion pr = (Poblacion) iterador.next();

                    ComboPoblacion.addItem(pr.getNombrePob());
                }

                codigoPoblacionAux = extraerCodigoPoblacionSeleccinada();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la conexión con la base de datos");
        }

    }

    /**
     * Extrae el código de la provincia seleccionada segun el indice del
     * combobox
     *
     */
    private String extraerCodigoProvinciaSeleccinada() {

        Provincia pAux = listaProvincias.get(ComboProvincia.getSelectedIndex());

        return pAux.getCodigoProvincia();

    }
    
   
   /**
    * Extrae el código de la poblacion seleccionada segun el indice del combobox
    * 
    */
   private String extraerCodigoPoblacionSeleccinada(){
       
       Poblacion pAux = listaPoblaciones.get(ComboPoblacion.getSelectedIndex());
       pobActual = pAux.getNombrePob();
       return pAux.getCodPoblacion();
      
   }
   
   /**
    * Método que llama al hilo encargado de la consulta
    * @throws InterruptedException 
    */
    private void Aceptar() throws InterruptedException {

        codPob = this.extraerCodigoPoblacionSeleccinada();
        cp = Integer.parseInt(codPob);
        pobla = ComboPoblacion.getSelectedItem().toString();
        provi = ComboProvincia.getSelectedItem().toString();

        HiloConsultasClientesPoblacion mh = new HiloConsultasClientesPoblacion();

        lbCargando.setText("Generando facturas, espera...");
        btAceptar.setEnabled(false);
        btCancelar.setEnabled(false);

        mh.start();

    }
    
    /**
     * Método encargado de realizar la consulta y mostrar si se realiza correctamente.
     */
    public static void consultas(){  
        try {
            new ReporteFactura(cp, provi, pobla, false);
            JOptionPane.showMessageDialog(null, "Facturas generadas correctamente");
            lbCargando.setText("");
            btAceptar.setEnabled(true);
            btCancelar.setEnabled(true);
        } catch (JRException ex) {
            System.out.print("Error al generar el informe " + ex.getMessage());
        }
    }
}
