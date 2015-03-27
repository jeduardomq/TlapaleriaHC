/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Productos;

import Database.Conneccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author SWO
 */
public class modificarProducto extends javax.swing.JFrame {

    String clave, nombre, marca, precio, volumen, sku, descripcion;

    //nombre, marca,precio, volumen, sku,descripcion,,clave
    public modificarProducto(String clav, String nombr, String marc, String preci, String volume, String sk, String descripcio) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.clave = clav;
        this.nombre = nombr;
        this.marca = marc;
        this.precio = preci;
        this.volumen = volume;
        this.sku = sk;
        this.descripcion = descripcio;
        llenarDatos();
    }

    public modificarProducto() {
        initComponents();
        this.setLocationRelativeTo(null);
        llenarDatos();
    }

    public void llenarDatos() {

        Cla.setText(clave);
        Nom.setText(nombre);
        Mar.setText(marca);
        Pre.setText(precio);
        Vol.setSelectedItem(volumen);
        Sku.setText(sku);
        Des.setText(descripcion);
    }

    public void modificar(String clave) {
        Conneccion mysql = new Conneccion();
        Connection cn = mysql.conectar();
        String aSQL = "UPDATE producto "
                + "SET cveProducto = ?,"
                + "nombre = ?,"
                + "marca = ?,"
                + "precio = ?,"
                + "volMedida = ?,"
                + "SKUProveedor = ?,"
                + "descripcion = ?"
                + "WHERE cveProducto = " + clave;

        String nom = Nom.getText();
        String mar = Mar.getText();
        String pre = Pre.getText();
        String vol = (String) Vol.getSelectedItem();
        String skup = Sku.getText();
        String des = Des.getText();

        try {
            PreparedStatement pst = cn.prepareStatement(aSQL);
            pst.setString(1, clave);
            pst.setString(2, nom);
            pst.setString(3, mar);
            pst.setString(4, pre);
            pst.setString(5, vol);
            pst.setString(6, skup);
            pst.setString(7, des);

            int n = pst.executeUpdate();

            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Modificacion Correcta");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Nom = new javax.swing.JTextField();
        Mar = new javax.swing.JTextField();
        Pre = new javax.swing.JTextField();
        Vol = new javax.swing.JComboBox();
        Sku = new javax.swing.JTextField();
        Des = new javax.swing.JTextField();
        Cla = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Nombre");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 14, -1, -1));

        jLabel3.setText("Marca");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 52, -1, -1));

        jLabel4.setText("Precio");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel5.setText("Volumen de medida");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 128, -1, -1));

        jLabel6.setText("SKUProveedor");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 166, -1, -1));

        jLabel7.setText("Descripción");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 204, -1, -1));

        jLabel8.setText("Clave");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 242, -1, -1));
        jPanel1.add(Nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 11, 135, -1));
        jPanel1.add(Mar, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 49, 135, -1));
        jPanel1.add(Pre, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 87, 135, -1));

        Vol.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Litros", "Metros", "Kilos" }));
        jPanel1.add(Vol, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 125, 126, -1));
        jPanel1.add(Sku, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 163, 126, -1));
        jPanel1.add(Des, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 201, 135, -1));

        Cla.setEnabled(false);
        jPanel1.add(Cla, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 239, 135, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Modificar Producto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(66, 66, 66))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int reply = JOptionPane.showConfirmDialog(this, "¿Desea cancelar? ", "CANCELAR", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            Producto p = new Producto();
            p.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String clave = Cla.getText();
        modificar(clave);
        Producto p = new Producto();
        p.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(modificarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(modificarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(modificarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(modificarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new modificarProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Cla;
    private javax.swing.JTextField Des;
    private javax.swing.JTextField Mar;
    private javax.swing.JTextField Nom;
    private javax.swing.JTextField Pre;
    private javax.swing.JTextField Sku;
    private javax.swing.JComboBox Vol;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
