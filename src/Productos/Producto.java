/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Productos;

import Database.Conneccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SWO
 */
public class Producto extends javax.swing.JFrame {

    DefaultTableModel modelo;

    /**
     * Creates new form Principal
     */
    public Producto() {
        initComponents();
//        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        cargartabla("");

    }

    public void cargartabla(String valor) {
        String[] titulos = {"Clave", "Nombre", "Marca", "Precio", "Unidad de Medida", "SKUProv", "Descripcion"};
        String[] registro = new String[7];
        String aSQL = "";
        modelo = new DefaultTableModel(null, titulos);
        Conneccion mysql = new Conneccion();
        Connection cn = mysql.conectar();
        aSQL = "SELECT cveProducto, nombre, marca, precio, volMedida, SKUProveedor, descripcion FROM Producto "
                + "WHERE nombre LIKE '%" + valor + "%'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(aSQL);
            while (rs.next()) {
                registro[0] = rs.getString("cveProducto");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("marca");
                registro[3] = rs.getString("precio");
                registro[4] = rs.getString("volMedida");
                registro[5] = rs.getString("SKUProveedor");
                registro[6] = rs.getString("descripcion");

                modelo.addRow(registro);
            }
            tabla.setModel(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void eliminar(String clave) {
        Conneccion mysql = new Conneccion();
        Connection cn = mysql.conectar();
        String aSQL = "DELETE FROM Producto WHERE cveProducto='" + clave + "'";
        try {
            PreparedStatement pstm = cn.prepareStatement(aSQL);
            pstm.executeUpdate();
            pstm.close();
            JOptionPane.showMessageDialog(this, "Eliminacion Exitosa", "Eliminacion", 1);
            cargartabla("");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        BUSCAR = new javax.swing.JTextField();
        MODIFICAR = new javax.swing.JButton();
        FINALIZAR1 = new javax.swing.JButton();
        ELIMINAR = new javax.swing.JButton();
        AGREGAR1 = new javax.swing.JButton();
        MODIFICAR1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("P R O D U C T O S");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("P R O D U C T O S");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 30));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(tabla);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 660, 270));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("L O G O");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 90, 70));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Open Sans", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(45, 45, 45));
        jLabel3.setText("Buscar:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 60, 30));

        BUSCAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUSCARActionPerformed(evt);
            }
        });
        BUSCAR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BUSCARKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BUSCARKeyReleased(evt);
            }
        });
        jPanel2.add(BUSCAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 270, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, 390, 50));

        MODIFICAR.setFont(new java.awt.Font("Open Sans", 0, 15)); // NOI18N
        MODIFICAR.setText("Modificar");
        MODIFICAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MODIFICARActionPerformed(evt);
            }
        });
        getContentPane().add(MODIFICAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 230, 110, 60));

        FINALIZAR1.setFont(new java.awt.Font("Open Sans", 0, 15)); // NOI18N
        FINALIZAR1.setText("Finalizar");
        FINALIZAR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FINALIZAR1ActionPerformed(evt);
            }
        });
        getContentPane().add(FINALIZAR1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 370, 110, 50));

        ELIMINAR.setFont(new java.awt.Font("Open Sans", 0, 15)); // NOI18N
        ELIMINAR.setText("Eliminar");
        ELIMINAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ELIMINARActionPerformed(evt);
            }
        });
        getContentPane().add(ELIMINAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 300, 110, 40));

        AGREGAR1.setFont(new java.awt.Font("Open Sans", 0, 15)); // NOI18N
        AGREGAR1.setText("Agregar");
        AGREGAR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AGREGAR1ActionPerformed(evt);
            }
        });
        getContentPane().add(AGREGAR1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 140, 110, 80));

        MODIFICAR1.setFont(new java.awt.Font("Open Sans", 0, 15)); // NOI18N
        MODIFICAR1.setText("Modificar");
        MODIFICAR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MODIFICAR1ActionPerformed(evt);
            }
        });
        getContentPane().add(MODIFICAR1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 230, 110, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FINALIZARActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }


    private void BUSCARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUSCARActionPerformed

    }//GEN-LAST:event_BUSCARActionPerformed

    private void BUSCARKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BUSCARKeyPressed
        String valor = BUSCAR.getText();
        cargartabla(valor);
    }//GEN-LAST:event_BUSCARKeyPressed

    private void BUSCARKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BUSCARKeyReleased
        String valor = BUSCAR.getText();
        cargartabla(valor);
    }//GEN-LAST:event_BUSCARKeyReleased

    private void FINALIZAR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FINALIZAR1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FINALIZAR1ActionPerformed

    private void AGREGAR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AGREGAR1ActionPerformed
        agregarProducto mp = new agregarProducto();
        mp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_AGREGAR1ActionPerformed

    private void MODIFICAR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MODIFICAR1ActionPerformed
        modificarProducto mp = new modificarProducto();
        mp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MODIFICAR1ActionPerformed

    private void MODIFICARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MODIFICARActionPerformed

        int fila = tabla.getSelectedRow();
        if (fila >= 0) {
            String clave = tabla.getValueAt(fila, 0).toString();
            String nombre= tabla.getValueAt(fila, 1).toString();
            String marca = tabla.getValueAt(fila, 2).toString();
            String precio = tabla.getValueAt(fila, 3).toString();
            String volumen = tabla.getValueAt(fila,4).toString();
            String sku = tabla.getValueAt(fila, 5).toString();
            String descripcion = tabla.getValueAt(fila, 6).toString();
            modificarProducto mp = new modificarProducto(clave,nombre, marca, precio, volumen, sku, descripcion);
            mp.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_MODIFICARActionPerformed

    private void ELIMINARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ELIMINARActionPerformed
        int reply = JOptionPane.showConfirmDialog(this, "¿Desea Eliminar el Producto? ", "ELIMINAR", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
//            JOptionPane.showMessageDialog(this,"NO TIENES EL PODER");
            int fila = tabla.getSelectedRow();
            if (fila >= 0) {
                String clave = tabla.getValueAt(fila, 0).toString();
                eliminar(clave);

            }
        }
    }//GEN-LAST:event_ELIMINARActionPerformed

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
            java.util.logging.Logger.getLogger(Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Producto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AGREGAR1;
    private javax.swing.JTextField BUSCAR;
    private javax.swing.JButton ELIMINAR;
    private javax.swing.JButton FINALIZAR1;
    private javax.swing.JButton MODIFICAR;
    private javax.swing.JButton MODIFICAR1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
