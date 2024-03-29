package aplicacionapplet;


import utilidades.Poblacion;
import utilidades.Cliente;
import utilidades.Provincia;
import utilidades.callespoblaciones;
import java.net.URL;
import java.net.*;
import java.io.*;
import java.sql.ResultSet;
import java.util.*;
import javax.swing.JOptionPane;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.DefaultListModel;
/**
 *
 * Applet para la inserción de mediciones de consumo de clientes
 * 
 * <br/><br/>Sistemas de Información -  Grado Ingeniería Informática T.I. -
 * Curso 2012/13
 * 
 * @author Enrique José Miguel Calvo, Saúl Carranza Gallardo
 * @version 1.0
 */
public class Practica_1 extends javax.swing.JApplet {

    ResultSet conjuntoResultados = null;
    List<Provincia> listaProvincias = new ArrayList<>();
    List<Poblacion> listaPoblaciones = new ArrayList<>();
    List<callespoblaciones> listaCalles = new ArrayList<>();
    List<Cliente> listaClientes = new ArrayList<>();
    String codigoProvinciaAux;
    String codigoPoblacionAux;
    String codigoCalleAux;
    String codigoCliAux=null;

    /**
     * Inicializa el applet
     */
    public void init() {
        try {
            java.awt.EventQueue.invokeAndWait(new Runnable() {
                public void run() {
                    initComponents();
                }
            });
            this.setSize(750, 630);
            peticionGet("true", 1);
            panelTexto.setVisible(false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * This method is called from within the init() method to initialize the
     * form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombre3 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboProvincias = new javax.swing.JComboBox();
        comboPoblaciones = new javax.swing.JComboBox();
        comboCalle = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtConsumo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        panelTexto = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtApellido2 = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtPiso = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("INGRESAR MEDICIONES");

        jLabel1.setText("Provincias");

        jLabel3.setText("Poblaciones");

        jLabel4.setText("Calle");

        comboProvincias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboProvinciasActionPerformed(evt);
            }
        });

        comboPoblaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPoblacionesActionPerformed(evt);
            }
        });

        jLabel5.setText("Selecciona Cliente");

        lista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lista);

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 0));
        jLabel6.setText("Introduzca Medición:");

        jLabel7.setText("Introduzca Fecha (AAAA-MM-DD):");

        jLabel8.setText("KiloWatios Consumidos:");

        jButton1.setText("Insertar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel9.setText("Nombre");

        txtNombre.setEditable(false);

        txtApellido.setEditable(false);

        jLabel10.setText("Apellido");

        jLabel11.setText("Apellido 2");

        txtApellido2.setEditable(false);

        txtNumero.setEditable(false);

        jLabel12.setText("Piso");

        txtPiso.setEditable(false);

        jLabel13.setText("Numero");

        javax.swing.GroupLayout panelTextoLayout = new javax.swing.GroupLayout(panelTexto);
        panelTexto.setLayout(panelTextoLayout);
        panelTextoLayout.setHorizontalGroup(
            panelTextoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTextoLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(panelTextoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTextoLayout.createSequentialGroup()
                        .addGroup(panelTextoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGroup(panelTextoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelTextoLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTextoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTextoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTextoLayout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtPiso, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelTextoLayout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addGap(25, 25, 25)
                            .addComponent(txtApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        panelTextoLayout.setVerticalGroup(
            panelTextoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTextoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTextoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelTextoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelTextoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelTextoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtPiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jButton5.setBackground(new java.awt.Color(0, 0, 255));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("?");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(111, 111, 111)
                                        .addComponent(jButton2))
                                    .addComponent(comboProvincias, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(comboPoblaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(558, 558, 558)
                                .addComponent(jButton1)
                                .addGap(28, 28, 28))
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtFecha)
                                            .addComponent(txtConsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 247, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addComponent(jButton5))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(comboProvincias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(comboPoblaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(comboCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5))
                    .addComponent(panelTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtConsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(35, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        insertar();
        txtConsumo.setText("");
        txtFecha.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void comboProvinciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboProvinciasActionPerformed
        peticionGet("true", 2);        
    }//GEN-LAST:event_comboProvinciasActionPerformed

    private void comboPoblacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPoblacionesActionPerformed
        peticionGet("true", 3);
    }//GEN-LAST:event_comboPoblacionesActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        panelTexto.setVisible(false);
        borraTexto();
        
        peticionGet("true", 4);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void listaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaMouseClicked
        if(!listaClientes.isEmpty()){
            codigoCliAux=extraeCodigoCliente();
            panelTexto.setVisible(true);
            rellenaTexto();
        }        
    }//GEN-LAST:event_listaMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Ayuda ay = new Ayuda();
        ay.mostrar();
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * Metodo encargado de la comunicación con el servlet, 
     * @param mensaje mensaje a enviar
     * @param opt metodo de operacion
     * @return la cadena obtenida dle servlet
     */
    private String peticionGet(String mensaje, int opt) {
        URL miurl = null;
        String cadenaaux = null;
        String cadenaretorno = "";
        String peticion = null;

        try {
            String host = this.getCodeBase().getHost();
            switch (opt) {
                case 0:
                    //peticion = "http://158.49.92.68:8080/AplicacionWeb/Practica1?PeticionInicio=" + URLEncoder.encode(mensaje);
                    peticion = "http://localhost:8080/AplicacionWeb/Practica1?PeticionInicio=" + URLEncoder.encode(mensaje);
                    break;
                case 1:
                    //peticion = "http://158.49.92.68:8080/AplicacionWeb/Practica1?PeticionInicio=" + URLEncoder.encode(mensaje);
                    peticion = "http://localhost:8080/AplicacionWeb/Practica1?PeticionInicio=" + URLEncoder.encode(mensaje);
                    break;
                case 2:
                    codigoProvinciaAux=extraerCodigoProvinciaSeleccinada();
                    //peticion = "http://158.49.92.68:8080/AplicacionWeb/Practica1?PeticionCiudad="+ codigoProvinciaAux;
                    peticion = "http://localhost:8080/AplicacionWeb/Practica1?PeticionCiudad="+ codigoProvinciaAux;
                    break;
                case 3:
                    codigoPoblacionAux=extraerCodigoPoblacionSeleccinada();
                    //peticion = "http://158.49.92.68:8080/AplicacionWeb/Practica1?PeticionCalle="+ codigoPoblacionAux;
                    peticion = "http://localhost:8080/AplicacionWeb/Practica1?PeticionCalle="+ codigoPoblacionAux;
                    break;
                case 4:
                    codigoCalleAux=extraerCodigoCalleSeleccinada();
                    //peticion = "http://158.49.92.68:8080/AplicacionWeb/Practica1?PeticionCliente="+ codigoCalleAux;
                    peticion = "http://localhost:8080/AplicacionWeb/Practica1?PeticionCliente="+ codigoCalleAux;
                    break;
            }

            miurl = new URL(getCodeBase(), peticion);
            InputStream buffer = miurl.openStream();
            BufferedReader bufferreader = new BufferedReader(new InputStreamReader(buffer, "UTF8"));

            while ((cadenaaux = bufferreader.readLine()) != null) {
                cadenaretorno += cadenaaux;
            }
            
            switch(opt){
                case 1:
                    rellenaProvincias(cadenaretorno);
                    break;
                case 2:
                    rellenaPoblaciones(cadenaretorno);
                    break;
                case 3:
                    rellenaCalles(cadenaretorno);
                    break;
                case 4:
                    lista.removeAll();
                    rellenaClientes(cadenaretorno);
                    break;
            }

            buffer.close();
        } catch (Exception e) {
            return "Error al generar url " + e.getMessage();
        }

        return cadenaretorno;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboCalle;
    private javax.swing.JComboBox comboPoblaciones;
    private javax.swing.JComboBox comboProvincias;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lista;
    private javax.swing.JPanel panelTexto;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtApellido2;
    private javax.swing.JTextField txtConsumo;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombre3;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtPiso;
    // End of variables declaration//GEN-END:variables

    /**
     * Rellena el combo de Provincias
     * @param cad la cadena contiene la respuesta del servlet
     */
    private void rellenaProvincias(String cad) {
        //Borra el combobox
        comboProvincias.removeAll();

        String[] split = cad.split(";");
      
        for (int x = 0; x <= split.length-1; x++) {
            String aux = split[x];
            
            String[] split2 = aux.split("-");
            
            String cod = split2[0];
            String nom = split2[1];
            Provincia auxProv = new Provincia(cod, nom);
            listaProvincias.add(auxProv);
        }

        Iterator iterador = listaProvincias.listIterator(); //Le solicito a la lista que me devuelva un iterador con todos los elementos contenidos en ella

        while (iterador.hasNext()) {
            Provincia pr = (Provincia) iterador.next();

            comboProvincias.addItem(pr.getProvincia());
        }
        

    }

    /**
     * Extrae el código de la provincia seleccionada segun el indice del
     * combobox
     */
    private String extraerCodigoProvinciaSeleccinada() {

        Provincia pAux = listaProvincias.get(comboProvincias.getSelectedIndex());

        return pAux.getCodigoProvincia();

    }
    
   /**
     * Extrae el código de la población seleccionada segun el indice del
     * combobox
     */
    private String extraerCodigoPoblacionSeleccinada() {

        Poblacion pAux = listaPoblaciones.get(comboPoblaciones.getSelectedIndex());

        return pAux.getCodPoblacion();

    }

    /**
     * Extrae el código de la calle seleccionada segun el indice del
     * combobox
     */
    private String extraerCodigoCalleSeleccinada() {

        callespoblaciones pAux = listaCalles.get(comboCalle.getSelectedIndex());

        return pAux.getIdCalle();

    }
    
    
    /**
     * Rellena el combo de Poblaciones
     * @param cad la cadena contiene la respuesta del servlet
     */
    private void rellenaPoblaciones(String cad) {
        //Borra el combobox
        comboPoblaciones.removeAllItems();
        listaPoblaciones.clear();

        String[] split = cad.split(";");
            for (int x = 0; x <= split.length - 1; x++) {
                String aux = split[x];

                String[] split2 = aux.split("-");

                String cod = split2[0];
                String nom = split2[1];
                Poblacion auxPob = new Poblacion(cod, nom);
                listaPoblaciones.add(auxPob);
            }
            //Le solicito a la lista que me devuelva un iterador con todos los elementos contenidos en ella
            Iterator iterador = listaPoblaciones.listIterator(); 
           
        while (iterador.hasNext()) {
            Poblacion pr = (Poblacion) iterador.next();

            comboPoblaciones.addItem(pr.getNombrePob());
        }

    }
    
    /**
     * Rellena el combo de Calles
     * @param cad la cadena contiene la respuesta del servlet 
     */
    private void rellenaCalles(String cad) {
        //Borra el combobox
        comboCalle.removeAllItems();
        listaCalles.clear();

        String[] split = cad.split(";");

        

            for (int x = 0; x <= split.length - 1; x++) {
                String aux = split[x];

                String[] split2 = aux.split("-");

                String cod = split2[0];
                String nom = split2[1];
                callespoblaciones auxCall = new callespoblaciones(cod, nom);
                listaCalles.add(auxCall);
            }
            
        //Le solicito a la lista que me devuelva un iterador con todos los elementos contenidos en ella
        Iterator iterador = listaCalles.listIterator(); 
           
        while (iterador.hasNext()) {
            callespoblaciones pr = (callespoblaciones) iterador.next();

            comboCalle.addItem(pr.getNombre());
        }

    }
    
    /**
     * Rellana la lista de clientes
     * @param cad la cadena contiene la respuesta del servlet 
     */
     private void rellenaClientes(String cad){
         
         DefaultListModel listaAux = new DefaultListModel();
         
         //Limpia la jlist
         listaAux.clear();

         lista.setModel(listaAux);
         
         String[] split = cad.split(";");

         for (int x = 0; x <= split.length - 1; x++) {
             String aux = split[x];

             String[] split2 = aux.split("-");

             String cod = split2[0];
             String nom = split2[1];
             String apell1 = split2[2];
             String apell2 = split2[3];
             String num = split2[4];
             String piso = split2[5];
             Cliente auxCli = new Cliente(cod, nom, apell1, apell2, num, piso);
             listaClientes.add(auxCli);
         }
         
         //Le solicito a la lista que me devuelva un iterador con todos los el elementos contenidos en ella
         Iterator iterador = listaClientes.listIterator();
         
         while (iterador.hasNext()) {
             Cliente cli = (Cliente) iterador.next();
             listaAux.addElement("Cod: " + cli.getCodigo() + ", --> " + cli.getNombre() + ", " + cli.getApellido() + " " + cli.getApellido2()
                     + " ,Piso: " + cli.getPiso() + " Nº: " + cli.getNumero());
         }
         
         lista.setModel(listaAux);
     }
     
     /**
      * Extra el codigo del cliente a través del indice del combo seleccionado
      * @return identificador de cliente
      */
     private String extraeCodigoCliente(){
         try{
             return listaClientes.get(lista.getSelectedIndex()).getCodigo();
         }catch (ArrayIndexOutOfBoundsException asd) {
             return "";
         }
     }
     
     /**
      * Metodo encargado de insertar las mediciones a través del Servlet
      */
     private void insertar(){
         boolean error=false;
         String fecha;
         
         if(codigoCliAux==null){
             JOptionPane.showMessageDialog(null, "Debe seleccionar un cliente");
         }else{
             if(txtFecha.getText().equals("") || txtConsumo.getText().equals("")){
                   JOptionPane.showMessageDialog(null, "Debe introducir una fecha y un consumo");
             }else{
                    if (!isFechaValida(txtFecha.getText())){
                        error=true;
                    }
                    try{
                        float aux=Float.parseFloat(txtConsumo.getText());
                    }catch (NumberFormatException ex){
                        error=true;
                    }
                    if (!error){
                        // conseguimos la hora actual formateada
                        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
                        //si estamos aqui es que la fecha es correcta asi que se suma a la hora
                        fecha= txtFecha.getText()+" "+ formatter.format(new Date());
                        //realizamos la consulta
                        peticionGet2(codigoCliAux,fecha, txtConsumo.getText());
                        
                    }else{
                         JOptionPane.showMessageDialog(null, "El forma de la fecha o la medicion no tienen el formato correcto");
                    }
             }
         }
     }
     
     /**
      * Genera la petición para realizar la llamada al servlet
      * @param codCliente codigo del cliente
      * @param fecha fecha de la medición
      * @param kw consumo total de la medición
      */
     private void peticionGet2(String codCliente, String fecha ,String kw) {
        URL miurl = null;
        String cadenaaux = null;
        String peticion = null;

        try {
            String host = this.getCodeBase().getHost();

            peticion = "http://localhost:8080/AplicacionWeb/Practica1?InsertaMedicion=true&"
                    +"Cliente="+codCliente+"&Fecha="+URLEncoder.encode(fecha)+"&KW="+kw;

            miurl = new URL(getCodeBase(), peticion);
            InputStream buffer = miurl.openStream();
            BufferedReader bufferreader = new BufferedReader(new InputStreamReader(buffer));

            while ((cadenaaux = bufferreader.readLine()) != null) {
                if(cadenaaux.equals("Insercion realizada")){
                    JOptionPane.showMessageDialog(null, "Inserción realizada");
                }
            }

            buffer.close();
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "error --> " + e.getMessage());
        }
    }
     
     /**
      * Metodo encargado si la fecha es válida
      * @param fecha cadena a evaluar si es una fecha correcta
      * @return true si la cadena es correcta
      */
     private static boolean isFechaValida(String fecha) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            formatoFecha.setLenient(false);// para que de error en el formato sino traga con casi todo
            formatoFecha.parse(fecha);
        } catch (ParseException e) {
                return false;
        }
        return true;
     }
     
     /**
      * Rellena las cajas de texto con los datos del cliente seleccionado
      */
     private void rellenaTexto(){
         Cliente aux = listaClientes.get(lista.getSelectedIndex());
         
         txtNombre.setText(aux.getNombre());
         txtApellido.setText(aux.getApellido());
         txtApellido2.setText(aux.getApellido2());
         txtNumero.setText(aux.getNumero());
         txtPiso.setText(aux.getPiso());
         SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
         txtFecha.setText(formatoFecha.format(new Date()));
         
     }
     
     /**
      * Borra las cajas de texto de los datos del cliente
      */
      private void borraTexto(){
         txtNombre.setText("");
         txtApellido.setText("");
         txtApellido2.setText("");
         txtNumero.setText("");
         txtPiso.setText("");
         txtFecha.setText("");
         
     }
}
