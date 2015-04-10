package Ajustes;

import Database.Conneccion;
import Principal.Principal;
import Principal.ScreenAddUser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class agregarCategoria extends javax.swing.JFrame {
    
    DefaultTableModel modelo;
    
    public agregarCategoria() {
        initComponents();
        //        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        cargartabla("");
        GUARDAR.setVisible(false);
    }
    
    public void cargartabla(String valor) {
        String[] titulos = {"Clave", "Categoria", "Descripcion"};
        String[] registro = new String[3];
        String aSQL = "";
        modelo = new DefaultTableModel(null, titulos);
        Conneccion mysql = new Conneccion();
        Connection cn = mysql.conectar();
        aSQL = "SELECT cveCategoria,nombreCategoria,descripcion FROM Categoria ";
//                + "WHERE nombreCategoria LIKE '%" + valor + "%'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(aSQL);
            while (rs.next()) {
                registro[0] = rs.getString("cveCategoria");
                registro[1] = rs.getString("nombreCategoria");
                registro[2] = rs.getString("descripcion");
                
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
        String aSQL = "DELETE FROM Categoria WHERE cveCategoria ='" + clave + "'";
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
    
    public void insert() {
        Conneccion mysql = new Conneccion();
        Connection cn = mysql.conectar();
        String clav = null;
        String nom = catt.getText();
        String desc = descripcion.getText();
        
        String aSQL = "INSERT INTO Categoria (cveCategoria,nombreCategoria,descripcion)"
                + "VALUES( ?, ?, ?)";
        try {
            PreparedStatement pst = cn.prepareStatement(aSQL);
            pst.setString(1, clav);
            pst.setString(2, nom);
            pst.setString(3, desc);
            
            int n = pst.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Los datos se guardaron Correctamente");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void modificar(String cat, String nom, String desc) {
        Conneccion mysql = new Conneccion();
        Connection cn = mysql.conectar();
        String aSQL = "UPDATE Categoria SET "
                + "cveCategoria=?, "
                + "nombreCategoria=?, "
                + "descripcion=?"
                + "WHERE cveCategoria = " + cat;
        String nombres = catt.getText();
        String descripcions = descripcion.getText();
        try {
            PreparedStatement pst = cn.prepareStatement(aSQL);
            pst.setString(1, cat);
            pst.setString(2, nombres);
            pst.setString(3, descripcions);
            int n = pst.executeUpdate();
            
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Modificacion Correcta");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public void llenarDatos(String clave, String cat, String desc) {
        catt.setText(cat);
        descripcion.setText(desc);
    }

    public void limpiar() {
        catt.setText("");
        descripcion.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        Calle = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        catt = new javax.swing.JTextField();
        descripcion = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        AGREGAR1 = new javax.swing.JButton();
        GUARDAR = new javax.swing.JButton();
        ELIMINAR = new javax.swing.JButton();
        FINALIZAR1 = new javax.swing.JButton();
        MODIFICAR1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Categorias");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 73, 72));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Categoria");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(405, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, -1));

        Calle.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Calle.setForeground(new java.awt.Color(255, 255, 255));
        Calle.setText("Descripcion:");
        jPanel1.add(Calle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 138, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Categoria:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));
        jPanel1.add(catt, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 98, 260, -1));

        descripcion.setColumns(20);
        descripcion.setRows(5);
        jPanel1.add(descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 136, 260, -1));

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

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 350, 210));

        AGREGAR1.setFont(new java.awt.Font("Open Sans", 1, 15)); // NOI18N
        AGREGAR1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/agregar.png"))); // NOI18N
        AGREGAR1.setText("Agregar");
        AGREGAR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AGREGAR1ActionPerformed(evt);
            }
        });
        jPanel1.add(AGREGAR1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, 140, 80));

        GUARDAR.setFont(new java.awt.Font("Open Sans", 1, 15)); // NOI18N
        GUARDAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/guardar.png"))); // NOI18N
        GUARDAR.setText("Guardar");
        GUARDAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GUARDARActionPerformed(evt);
            }
        });
        jPanel1.add(GUARDAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 140, 40));

        ELIMINAR.setFont(new java.awt.Font("Open Sans", 1, 15)); // NOI18N
        ELIMINAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cancelar.png"))); // NOI18N
        ELIMINAR.setText("Eliminar");
        ELIMINAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ELIMINARActionPerformed(evt);
            }
        });
        jPanel1.add(ELIMINAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, 140, 40));

        FINALIZAR1.setFont(new java.awt.Font("Open Sans", 1, 15)); // NOI18N
        FINALIZAR1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/finalizar.png"))); // NOI18N
        FINALIZAR1.setText("Finalizar");
        FINALIZAR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FINALIZAR1ActionPerformed(evt);
            }
        });
        jPanel1.add(FINALIZAR1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 390, 140, 50));

        MODIFICAR1.setFont(new java.awt.Font("Open Sans", 1, 15)); // NOI18N
        MODIFICAR1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/actualizar.png"))); // NOI18N
        MODIFICAR1.setText("Modificar");
        MODIFICAR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MODIFICAR1ActionPerformed(evt);
            }
        });
        jPanel1.add(MODIFICAR1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, 140, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 481));

        jMenu1.setText("Archivo");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/finalizar.png"))); // NOI18N
        jMenuItem1.setText("Salir");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Usuarios");

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cliente.png"))); // NOI18N
        jMenuItem2.setText("Crear Usuario");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AGREGAR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AGREGAR1ActionPerformed
        insert();
        cargartabla("");
    }//GEN-LAST:event_AGREGAR1ActionPerformed

    private void GUARDARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GUARDARActionPerformed
        int fila = tabla.getSelectedRow();
        if (fila >= 0) {
            String clave = tabla.getValueAt(fila, 0).toString();
            String nombre = tabla.getValueAt(fila, 1).toString();
            String des = tabla.getValueAt(fila, 2).toString();
            modificar(clave, nombre, des);
            limpiar();
            GUARDAR.setVisible(false);
            MODIFICAR1.setVisible(true);
        }
        cargartabla("");
    }//GEN-LAST:event_GUARDARActionPerformed

    private void ELIMINARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ELIMINARActionPerformed
        int reply = JOptionPane.showConfirmDialog(this, "¿Desea Eliminar la Categoria? ", "ELIMINAR", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            //            JOptionPane.showMessageDialog(this,"NO TIENES EL PODER");
            int fila = tabla.getSelectedRow();
            if (fila >= 0) {
                String clave = tabla.getValueAt(fila, 0).toString();
                eliminar(clave);
            }
        }
    }//GEN-LAST:event_ELIMINARActionPerformed

    private void FINALIZAR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FINALIZAR1ActionPerformed
//        Principal view = new Principal("nicknam");
//        view.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_FINALIZAR1ActionPerformed

    private void MODIFICAR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MODIFICAR1ActionPerformed
        int fila = tabla.getSelectedRow();
        if (fila >= 0) {
            String clave = tabla.getValueAt(fila, 0).toString();
            String categoria = tabla.getValueAt(fila, 1).toString();
            String desc = tabla.getValueAt(fila, 2).toString();
            llenarDatos(clave, categoria, desc);
            MODIFICAR1.setVisible(false);
            GUARDAR.setVisible(true);
        }
    }//GEN-LAST:event_MODIFICAR1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        ScreenAddUser su = new ScreenAddUser();
        su.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(agregarCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(agregarCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(agregarCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(agregarCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new agregarCategoria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AGREGAR1;
    private javax.swing.JLabel Calle;
    private javax.swing.JButton ELIMINAR;
    private javax.swing.JButton FINALIZAR1;
    private javax.swing.JButton GUARDAR;
    private javax.swing.JButton MODIFICAR1;
    private javax.swing.JTextField catt;
    private javax.swing.JTextArea descripcion;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
