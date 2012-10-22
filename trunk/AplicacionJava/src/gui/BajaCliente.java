/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import clases.Cliente;
import clases.Poblacion;
import clases.Provincia;
import clases.callespoblaciones;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author carranza
 */
public class BajaCliente extends javax.swing.JFrame {
    
    ResultSet conjuntoResultados=null;
    List<Provincia> listaProvincias = new ArrayList<>();
    List<Poblacion> listaPoblaciones = new ArrayList<>();
    List<callespoblaciones> listaCalles = new ArrayList<>();
    List<Cliente> listaClientes = new ArrayList<>();
    String codigoProvinciaAux;
    String codigoPoblacionAux;
    String codigoCalleAux;
    String pobActual=null;

    /**
     * Creates new form BajaCliente
     */
    public BajaCliente() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ComboPobla = new javax.swing.JComboBox();
        txtMetros = new javax.swing.JTextField();
        ComboProv = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        ComboCalle = new javax.swing.JComboBox();
        txtApellido2 = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        lbPob3 = new javax.swing.JLabel();
        txtPiso = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        lbPob2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        ComboPobla1 = new javax.swing.JComboBox();
        ComboProv1 = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        ComboCalle1 = new javax.swing.JComboBox();
        txtApellido3 = new javax.swing.JTextField();
        txtNombre1 = new javax.swing.JTextField();
        lbPob4 = new javax.swing.JLabel();
        txtPiso1 = new javax.swing.JTextField();
        txtApellido1 = new javax.swing.JTextField();
        btBaja = new javax.swing.JButton();
        lbPob5 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtNumero1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtCodCliente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList();
        jLabel15 = new javax.swing.JLabel();

        ComboPobla.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione" }));

        ComboProv.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione" }));

        jLabel5.setText("Apellido");

        ComboCalle.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione" }));

        lbPob3.setText("Calle");

        jButton2.setText("Aceptar");

        lbPob2.setText("Población");

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setText("Piso");

        jLabel6.setText("Nombre");

        jLabel3.setText("Apellido2");

        jLabel2.setText("Provincia");

        jLabel4.setText("Número");

        jLabel8.setText("Metros");

        setTitle("Baja Cliente");

        ComboPobla1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboPobla1ActionPerformed(evt);
            }
        });

        ComboProv1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboProv1ActionPerformed(evt);
            }
        });

        jLabel9.setText("Apellido");

        ComboCalle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboCalle1ActionPerformed(evt);
            }
        });

        txtApellido3.setEditable(false);

        txtNombre1.setEditable(false);

        lbPob4.setText("Calle");

        txtPiso1.setEditable(false);

        txtApellido1.setEditable(false);

        btBaja.setText("Dar de Baja");

        lbPob5.setText("Población");

        jButton4.setText("Cancelar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel10.setText("Piso");

        jLabel11.setText("Nombre");

        jLabel12.setText("Apellido2");

        jLabel13.setText("Provincia");

        txtNumero1.setEditable(false);

        jLabel14.setText("Número");

        jLabel16.setText("Código Cliente");

        lista.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(lista);

        jLabel15.setText("Selecciona un Cliente de la Lista");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(34, 34, 34)
                        .addComponent(btBaja))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13)
                                            .addComponent(lbPob5)
                                            .addComponent(lbPob4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(ComboPobla1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(ComboProv1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(ComboCalle1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(42, 42, 42)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel14))
                                        .addGap(34, 34, 34)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtApellido1, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNombre1, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtApellido3, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(txtNumero1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtPiso1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel13)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(ComboProv1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ComboPobla1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbPob5))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ComboCalle1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbPob4))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(txtNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtApellido3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel10)
                            .addComponent(txtPiso1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumero1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(btBaja))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void ComboProv1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboProv1ActionPerformed
        rellenaPoblacion();
    }//GEN-LAST:event_ComboProv1ActionPerformed

    private void ComboPobla1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboPobla1ActionPerformed
        rellenaCalle();
    }//GEN-LAST:event_ComboPobla1ActionPerformed

    private void ComboCalle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboCalle1ActionPerformed
        rellenaClientes();
    }//GEN-LAST:event_ComboCalle1ActionPerformed

    
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
            java.util.logging.Logger.getLogger(BajaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BajaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BajaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BajaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BajaCliente().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboCalle;
    private javax.swing.JComboBox ComboCalle1;
    private javax.swing.JComboBox ComboPobla;
    private javax.swing.JComboBox ComboPobla1;
    private javax.swing.JComboBox ComboProv;
    private javax.swing.JComboBox ComboProv1;
    private javax.swing.JButton btBaja;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbPob2;
    private javax.swing.JLabel lbPob3;
    private javax.swing.JLabel lbPob4;
    private javax.swing.JLabel lbPob5;
    private javax.swing.JList lista;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtApellido1;
    private javax.swing.JTextField txtApellido2;
    private javax.swing.JTextField txtApellido3;
    private javax.swing.JTextField txtCodCliente;
    private javax.swing.JTextField txtMetros;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombre1;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtNumero1;
    private javax.swing.JTextField txtPiso;
    private javax.swing.JTextField txtPiso1;
    // End of variables declaration//GEN-END:variables
    
    public void Mostrar(){
        setVisible(true);
        
        setLocationRelativeTo(null);
        
        
              int seleccion = JOptionPane.showOptionDialog(this,"Como desea localizar el cliente?", 
                                                        "Seleccione una opción", JOptionPane.YES_NO_CANCEL_OPTION,
                                                         JOptionPane.QUESTION_MESSAGE,null,new Object[] { "Número ID", "Lista por Zona"},null);
              
                 if (seleccion != -1){
                    if((seleccion + 1)==1)
                    {
                             // PRESIONA ID
                                 ComboProv1.setEnabled(false);
                                 ComboPobla1.setEnabled(false);
                                 ComboCalle1.setEnabled(false);
                    }
                    else
                    {
                    //PRESIONO ZONA
                        txtCodCliente.setEnabled(false);
                        rellenaProvincias();
                    }
                    
                    btBaja.requestFocusInWindow();
                } 
        }
      /**
      * Rellena el combo de Provincias
      */
    public void rellenaProvincias(){
        //Borra el combobox
        ComboProv1.removeAll();
        
        //Hago una consulta que me devuelva todas la provincias con sus códigos y las almaceno en conjuntoResultados
        try {
            conjuntoResultados=Principal.cbd.consultaSelect("SELECT * FROM  `provincias` ");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error en la conexión con la base de datos");
        }
        
         int numeroDeColumnas=0;
         ResultSetMetaData metaDatos = null;
        
         
         try {
            metaDatos = conjuntoResultados.getMetaData();
            numeroDeColumnas = metaDatos.getColumnCount();
            
            //creo el contador para ir pivotando entre las columnas de la tabla
            int cont=0;
            String cod=null;
            String nom=null;
            
            while (conjuntoResultados.next()) {
            for (int i = 1; i <= numeroDeColumnas; i++) {
                
                switch(cont){
                    case 0: cod=conjuntoResultados.getObject(i).toString();
                            cont=1;
                            break;
                    case 1: nom=conjuntoResultados.getObject(i).toString();
                            //creo un objeto provincia, variable
                            Provincia aux = new Provincia(cod,nom); 
                            listaProvincias.add(aux);
                            cont=0;
                            break;
                }
            }
          }
            
            Iterator iterador = listaProvincias.listIterator(); //Le solicito a la lista que me devuelva un iterador con todos los el elementos contenidos en ella
 
            while( iterador.hasNext() ) {
                Provincia pr=(Provincia) iterador.next();
                
                ComboProv1.addItem(pr.getProvincia());
                
                codigoProvinciaAux=extraerCodigoProvinciaSeleccinada();
                
                }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error en la conexión con la base de datos");
        }
    }
    
    /**
     * Extrae el código de la provincia seleccionada segun el indice del combobox 
     */
   public String extraerCodigoProvinciaSeleccinada(){
       
       Provincia pAux = listaProvincias.get(ComboProv1.getSelectedIndex());
       
       return pAux.getCodigoProvincia();
       
   }
   
   /**
    * Extrae el código de la poblacion seleccionada segun el indice del combobox
    */
   public String extraerCodigoPoblacionSeleccinada(){
            Poblacion pAux = listaPoblaciones.get(ComboPobla1.getSelectedIndex());
            pobActual=pAux.getNombrePob();
            return pAux.getCodPoblacion();
   }
   
   /**
    * Extrae el codigo de la calle seleccionada el combo
    * @return 
    */
   public String extraerCodigoCalleSeleccinada(){
       
       callespoblaciones cAux = listaCalles.get(ComboCalle.getSelectedIndex());
       
       return cAux.getIdCalle();
      
   }
   
   /**
    * Metodo encargado de rellenar el combo de poblacion
    */
    public void rellenaPoblacion(){
        
        //Borra el combobox
        ComboPobla1.removeAllItems();
        //Borra la lista de poblaciones
        listaPoblaciones.clear();
        //Extrae el codigo de la provincia seleccionada
        codigoProvinciaAux = extraerCodigoProvinciaSeleccinada();
        
        ResultSet results = null;
    
        //Hago una consulta que me devuelva las poblaciones de la provincia seleccionada
        try {
            results=Principal.cbd.consultaSelect("SELECT CodigoProvincia,CodigoPoblacion,Poblacion FROM poblaciones WHERE CodigoProvincia="+codigoProvinciaAux);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error en la conexión con la base de datos");
        }
        
         //Declaro algunas variables para poder rellenar el combo
        int numeroDeColumnas=0;
        ResultSetMetaData metaDatos = null;
        
         
         try {
            metaDatos = results.getMetaData();
            numeroDeColumnas = metaDatos.getColumnCount();
            
            //Creo el contador para ir pivotando entre las columnas de la tabla
            int cont=0;
            //Variables que almacenan los datos que se añaden al final del bucle
            String codProv=null;
            String codPob=null;
            String nom=null;
            
            while (results.next()) {
            for (int i = 1; i <= numeroDeColumnas; i++) {
                
                switch(cont){
                    case 0: codProv=results.getObject(i).toString();
                            cont=1;
                            break;
                    case 1: codPob=results.getObject(i).toString();
                            cont=2;
                            break;
                    case 2: nom=results.getObject(i).toString();
                            //Creo un objeto poblacion y añado los datos que se han ido recogiendo el switch
                            Poblacion aux = new Poblacion(codProv,codPob,nom); 
                            listaPoblaciones.add(aux);
                            cont=0; //para que vuelva a rellenar desde el primer campo
                            break;
                }
            }
          }
            
         //Le solicito a la lista que me devuelva un iterador con todos los el elementos contenidos en ella
         Iterator iterador = listaPoblaciones.listIterator();
         
         //En caso de no existir ninguna poblacion para la provincia muestro en el combo vacio, sino relleno el combo
         if(listaPoblaciones.isEmpty()){
             ComboPobla1.addItem("--Vacío--");
             
             codigoPoblacionAux=null;
         }
         else
         {
             while( iterador.hasNext() ) {
              Poblacion pr=(Poblacion) iterador.next();
          
               ComboPobla1.addItem(pr.getNombrePob());
                }
             
             codigoPoblacionAux=extraerCodigoPoblacionSeleccinada();
         }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error en la conexión con la base de datos");
        }
        
    }
    
    /**
     * Rellena el combo de la calle
     */
    public void rellenaCalle(){
        String op=null;
        
        try{
        
        //Borra el combobox
        ComboCalle1.removeAllItems();
        //Borra la lista de calles
        listaCalles.clear();
        //Extrae el codigo de la poblacion seleccionada
        codigoPoblacionAux = extraerCodigoPoblacionSeleccinada();
        
        ResultSet results2=null;
        
        
    
        //Hago una consulta que me devuelva las calles de la poblacion seleccionada
        try {
            
            results2=Principal.cbd.consultaSelect("SELECT idCalle,CodPoblacion,Nombre FROM callespoblaciones WHERE CodPoblacion="+codigoPoblacionAux);
         
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error en la conexión con la base de datos");
        }
        
         //Declaro algunas variables para poder rellenar el combo
        int numeroDeColumnas=0;
        ResultSetMetaData metaDatos = null;
        
         
         try {
            metaDatos = results2.getMetaData();
            numeroDeColumnas = metaDatos.getColumnCount();
            
            //Creo el contador para ir pivotando entre las columnas de la tabla
            int cont=0;
            //Variables que almacenan los datos que se añaden al final del bucle
            String idCalle=null;
            String codPob=null;
            String nom=null;
            
            
                while (results2.next()) {
                for (int i = 1; i <= numeroDeColumnas; i++) {
                
                switch(cont){
                    case 0: idCalle=results2.getObject(i).toString();
                            cont=1;
                            break;
                    case 1: codPob=results2.getObject(i).toString();
                            cont=2;
                            break;
                    case 2: nom=results2.getObject(i).toString();
                            //Creo un objeto poblacion y añado los datos que se han ido recogiendo el switch
                            callespoblaciones aux = new callespoblaciones(idCalle,codPob,nom); 
                            listaCalles.add(aux);
                            cont=0; //para que vuelva a rellenar desde el primer campo
                            break;
                }
            }
            
          }
            
         //Le solicito a la lista que me devuelva un iterador con todos los el elementos contenidos en ella
         Iterator iterador = listaCalles.listIterator();
         
         //En caso de no existir ningun objeto para el codigo seleccionado muestro en el combo vacio, sino relleno el combo
         if(listaCalles.isEmpty()){
             ComboCalle1.addItem("--Vacío--");
             
             codigoCalleAux=null;
         }
         else
         {
             while( iterador.hasNext() ) {
              callespoblaciones pr=(callespoblaciones) iterador.next();
                if(pr.getNombre().equals(ComboPobla.getSelectedItem().toString())){
                    ComboCalle1.removeAll();
                    ComboCalle1.addItem("--Vacío--");
                    }
                else{
                    ComboCalle1.addItem(pr.getNombre());
                    op=pr.getNombre();
                }
                }
             
             codigoCalleAux=extraerCodigoCalleSeleccinada();
         }
         
         //Controla problema de duplicidad comboBox
         if(pobActual.equals(op)){
                ComboCalle1.removeAllItems();
                ComboCalle1.addItem("--Vacío--");
        }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error en la conexión con la base de datos");
        }
         //Controla la posibilidad de que se pulse el botón actualizar calles antes de tiempo
        }catch(IndexOutOfBoundsException asd){
            ComboCalle1.addItem("--Vacío--");
        }
    }

    /**
     * Metodo encargado de rellenar la lista de clientes 
     * 
     */
    public void rellenaClientes(){
        
    }
}