/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proveedores;

import Clientes.*;
import Database.Conneccion;
import Principal.Principal;
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
public class Proveedor extends javax.swing.JFrame {

    DefaultTableModel modelo;
    String nicknam;

    public Proveedor() {
        initComponents();
//        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        cargartabla("");
    }
//cveProveedor,nombre,apellidos,calle,numero,ciudad,estado,RFC,numCelular,numTelefono,codigoPostal,email

    public Proveedor(String nickname) {
                        initComponents();
//        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        cargartabla("");
        this.nicknam = nickname;
        USER.setText(nicknam);
    }


    public void cargartabla(String valor) {
        String[] titulos = {"cveProveedor","nombre","apellidos","calle","numero","ciudad","estado","RFC","numCelular","numTelefono","codigoPostal","email"};
        String[] registro = new String[13];
        String aSQL = "";
        modelo = new DefaultTableModel(null, titulos);
        Conneccion mysql = new Conneccion();
        Connection cn = mysql.conectar();
        aSQL = "SELECT cveProveedor,nombre,apellidos,calle,numero,ciudad,estado,RFC,numCelular,numTelefono,codigoPostal,email FROM Proveedor "
                + "WHERE nombre LIKE '%" + valor + "%'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(aSQL);
            while (rs.next()) {
                registro[0] = rs.getString("cveProveedor");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apellidos");
                registro[3] = rs.getString("calle");
                registro[4] = rs.getString("numero");
                registro[5] = rs.getString("ciudad");
                registro[6] = rs.getString("estado");
                registro[7] = rs.getString("RFC");
                registro[8] = rs.getString("numCelular");
                registro[9] = rs.getString("numTelefono");
                registro[10] = rs.getString("codigoPostal");
                registro[11] = rs.getString("email");

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
        String aSQL = "DELETE FROM Proveedor WHERE cveProveedor='" + clave + "'";
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

        jScrollPane5 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        AGREGAR = new javax.swing.JButton();
        MODIFICAR = new javax.swing.JButton();
        FINALIZAR = new javax.swing.JButton();
        ELIMINAR = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        BUSCAR = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        USER = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 660, 280));

        AGREGAR.setFont(new java.awt.Font("Open Sans", 0, 16)); // NOI18N
        AGREGAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/agregar.png"))); // NOI18N
        AGREGAR.setText("Agregar");
        AGREGAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AGREGARActionPerformed(evt);
            }
        });

        MODIFICAR.setFont(new java.awt.Font("Open Sans", 0, 16)); // NOI18N
        MODIFICAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/actualizar.png"))); // NOI18N
        MODIFICAR.setText("Modificar");
        MODIFICAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MODIFICARActionPerformed(evt);
            }
        });

        FINALIZAR.setFont(new java.awt.Font("Open Sans", 0, 16)); // NOI18N
        FINALIZAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/finalizar.png"))); // NOI18N
        FINALIZAR.setText("Finalizar");
        FINALIZAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FINALIZARActionPerformed(evt);
            }
        });

        ELIMINAR.setFont(new java.awt.Font("Open Sans", 0, 16)); // NOI18N
        ELIMINAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cancelar.png"))); // NOI18N
        ELIMINAR.setText("Eliminar");
        ELIMINAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ELIMINARActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FINALIZAR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AGREGAR, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MODIFICAR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ELIMINAR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AGREGAR, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MODIFICAR, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ELIMINAR)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(FINALIZAR)
                .addGap(20, 20, 20))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 140, -1, 280));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Open Sans", 0, 16)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/lupa.png"))); // NOI18N
        jLabel3.setText("Buscar");

        BUSCAR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BUSCARKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BUSCARKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(BUSCAR, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BUSCAR, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, 390, 50));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("C L I E N T E S");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 840, -1));

        USER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cliente.png"))); // NOI18N
        jPanel3.add(USER, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 50));

        jLabel7.setBackground(new java.awt.Color(204, 204, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/THC control.png"))); // NOI18N
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 170, 120));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 130));

        jMenu1.setText("Archivo");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/finalizar.png"))); // NOI18N
        jMenuItem1.setText("Salir");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AGREGARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AGREGARActionPerformed
        agregarProveedor mp = new agregarProveedor();
        mp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_AGREGARActionPerformed

    private void MODIFICARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MODIFICARActionPerformed
        int fila = tabla.getSelectedRow();
        if (fila >= 0) {
            String clave = tabla.getValueAt(fila, 0).toString();
            String nombre = tabla.getValueAt(fila, 1).toString();
            String apellido = tabla.getValueAt(fila, 2).toString();
            String calle = tabla.getValueAt(fila, 3).toString();
            String numero = tabla.getValueAt(fila, 4).toString();
            String ciudad = tabla.getValueAt(fila, 5).toString();
            String estado = tabla.getValueAt(fila, 6).toString();
            String rfc = tabla.getValueAt(fila, 7).toString();
            String ncasa = tabla.getValueAt(fila, 8).toString();
            String ncel = tabla.getValueAt(fila, 9).toString();
            String codigo = tabla.getValueAt(fila, 10).toString();
            String email = tabla.getValueAt(fila, 11).toString();

            modificarProveedor mp = new modificarProveedor(clave, nombre, apellido, calle, numero, ciudad, estado, rfc, ncasa, ncel, codigo, email);
            mp.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_MODIFICARActionPerformed

    private void ELIMINARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ELIMINARActionPerformed
        int reply = JOptionPane.showConfirmDialog(this, "¿Desea Eliminar el Proveedor? ", "ELIMINAR", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
//            JOptionPane.showMessageDialog(this,"NO TIENES EL PODER");
            int fila = tabla.getSelectedRow();
            if (fila >= 0) {
                String clave = tabla.getValueAt(fila, 0).toString();
                eliminar(clave);
            }
        }
    }//GEN-LAST:event_ELIMINARActionPerformed

    private void FINALIZARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FINALIZARActionPerformed
        Principal view = new Principal(nicknam);
        view.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_FINALIZARActionPerformed

    private void BUSCARKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BUSCARKeyPressed
        String valor = BUSCAR.getText();
        cargartabla(valor);
    }//GEN-LAST:event_BUSCARKeyPressed

    private void BUSCARKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BUSCARKeyReleased
        String valor = BUSCAR.getText();
        cargartabla(valor);
    }//GEN-LAST:event_BUSCARKeyReleased

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
            java.util.logging.Logger.getLogger(Proveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Proveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Proveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Proveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Proveedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AGREGAR;
    private javax.swing.JTextField BUSCAR;
    private javax.swing.JButton ELIMINAR;
    private javax.swing.JButton FINALIZAR;
    private javax.swing.JButton MODIFICAR;
    private javax.swing.JLabel USER;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
