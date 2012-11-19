package gui;

import practica2.HiloConsultasClientesPoblacion;
import practica2.HiloConsultasProvincias;
import aplicacionjava.Provincia;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import practica2.ReporteCiudades;

   
 /**
 * Formulario para seleccionar la provincia de la que se quiere hacer un informe.
 *
 * <br/><br/>Sistemas de Información <br/> Practica 2<br/> Grado Ingeniería
 * Informática T.I. <br/> Curso 2012/13
 *
 * @author Enrique José Miguel Calvo, Saúl Carranza Gallardo
 * @version 2.0
 *
 */
public class InformeProvincias extends javax.swing.JFrame {
    //Declaración de variables

    ResultSet conjuntoResultados = null;
    List<Provincia> listaProvincias = new ArrayList<>();
    String codigoProvinciaAux;
    int opcionSeleccionada = -1;
    String pobActual = null;
    aplicacionjava.Conversion conAux = new aplicacionjava.Conversion();
    static String provincia;
    static int codProvincia;

    /**
     * Creates new form NuevaCallePoblacion
     */
    public InformeProvincias() {
        initComponents();

        setLocationRelativeTo(null);

        rellenaProvincias();

        codigoProvinciaAux = extraerCodigoProvinciaSeleccinada();

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
        ComboProvincia = new javax.swing.JComboBox();
        btCancelar = new javax.swing.JButton();
        btAceptar = new javax.swing.JButton();
        lbCargando = new javax.swing.JLabel();

        setTitle("Informe Provincia");

        jLabel1.setText("Provincia");

        ComboProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboProvinciaActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btAceptar.setText("Generar Informe");
        btAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel1)
                        .addGap(46, 46, 46)
                        .addComponent(ComboProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbCargando)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btAceptar)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ComboProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(lbCargando)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar)
                    .addComponent(btAceptar))
                .addGap(29, 29, 29))
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
    }//GEN-LAST:event_ComboProvinciaActionPerformed

    /**
     * Llama al metodo que controla cuando se pulsa el boton aceptar
     *
     * @param evt
     */
    private void btAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptarActionPerformed
        Aceptar();
    }//GEN-LAST:event_btAceptarActionPerformed

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
            java.util.logging.Logger.getLogger(InformeProvincias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformeProvincias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformeProvincias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformeProvincias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformeProvincias().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboProvincia;
    private static javax.swing.JButton btAceptar;
    private static javax.swing.JButton btCancelar;
    private javax.swing.JLabel jLabel1;
    private static javax.swing.JLabel lbCargando;
    // End of variables declaration//GEN-END:variables

    /**
     * Muestra el formulario en la opcion de introducir poblacion
     *
     */
    public void Mostrar() {
        setVisible(true);

        opcionSeleccionada = 1;
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
    * Extrae el código de la provincia seleccionada segun el indice del combobox 
    * 
    */
   private String extraerCodigoProvinciaSeleccinada(){
       
       Provincia pAux = listaProvincias.get(ComboProvincia.getSelectedIndex());
       
       return pAux.getCodigoProvincia();
       
   }
   
  
   
   /**
    * Metodo al que se llama cuando se pulsa el botón generar informes.
    * Llama al hilo que se encarga de lanzar la consulta
    * 
    */
   private void Aceptar(){
        
       provincia = ComboProvincia.getSelectedItem().toString();
       codProvincia = Integer.parseInt(extraerCodigoProvinciaSeleccinada());
 
            lbCargando.setText("Generando informes...");
            btAceptar.setEnabled(false);
            btCancelar.setEnabled(false);
       
       HiloConsultasProvincias mh = new HiloConsultasProvincias();

        mh.start();
    }

   /**
    * Realiza la consulta y muestra si la generación del informe ha sido correcto
    */
   public static void consultas(){
       try {
            new ReporteCiudades(codProvincia, provincia);
            JOptionPane.showMessageDialog(null, "Informes generados correctamente");
            lbCargando.setText("");
            btAceptar.setEnabled(true);
            btCancelar.setEnabled(true);
        } catch (JRException ex) {
            Logger.getLogger(InformeProvincias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

    
