package Productos;

import Database.Conneccion;
import Principal.Principal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Producto extends javax.swing.JFrame {

    DefaultTableModel modelo;
    String nicknam;

    public Producto() {
        initComponents();
//        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        cargartabla("");
    }

    public Producto(String nickname) {
        initComponents();
//        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        cargartabla("");
        this.nicknam = nickname;
        USER.setText(nicknam);
    }

    public void cargartabla(String valor) {
        String[] titulos = {"cveProducto", "Proveedor", "Nombre", "Descripcion", "Marca", "Precio", "Medida", "Categoria"};
        String[] registro = new String[8];
        String aSQL = "";
        modelo = new DefaultTableModel(null, titulos);
        Conneccion mysql = new Conneccion();
        Connection cn = mysql.conectar();
        aSQL = "SELECT cveProducto,cveProveedor,nombre,descripcion, marca, precioCompra, medida,categoria FROM Producto "
                + "WHERE nombre LIKE '%" + valor + "%'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(aSQL);
            while (rs.next()) {
                registro[0] = rs.getString("cveProducto");
                registro[1] = rs.getString("cveProveedor");
                registro[2] = rs.getString("nombre");
                registro[3] = rs.getString("descripcion");
                registro[4] = rs.getString("marca");
                registro[5] = rs.getString("precioCompra");
                registro[6] = rs.getString("medida");
                registro[7] = rs.getString("categoria");

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

        jScrollPane5 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        MODIFICAR = new javax.swing.JButton();
        FINALIZAR1 = new javax.swing.JButton();
        ELIMINAR = new javax.swing.JButton();
        AGREGAR1 = new javax.swing.JButton();
        MODIFICAR1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        USER = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        BUSCAR = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("P R O D U C T O S");
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

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 660, 270));

        MODIFICAR.setFont(new java.awt.Font("Open Sans", 1, 15)); // NOI18N
        MODIFICAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/actualizar.png"))); // NOI18N
        MODIFICAR.setText("Modificar");
        MODIFICAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MODIFICARActionPerformed(evt);
            }
        });
        getContentPane().add(MODIFICAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 230, 140, 60));

        FINALIZAR1.setFont(new java.awt.Font("Open Sans", 1, 15)); // NOI18N
        FINALIZAR1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/finalizar.png"))); // NOI18N
        FINALIZAR1.setText("Finalizar");
        FINALIZAR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FINALIZAR1ActionPerformed(evt);
            }
        });
        getContentPane().add(FINALIZAR1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 370, 140, 50));

        ELIMINAR.setFont(new java.awt.Font("Open Sans", 1, 15)); // NOI18N
        ELIMINAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cancelar.png"))); // NOI18N
        ELIMINAR.setText("Eliminar");
        ELIMINAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ELIMINARActionPerformed(evt);
            }
        });
        getContentPane().add(ELIMINAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 300, 140, 40));

        AGREGAR1.setFont(new java.awt.Font("Open Sans", 1, 15)); // NOI18N
        AGREGAR1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/agregar.png"))); // NOI18N
        AGREGAR1.setText("Agregar");
        AGREGAR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AGREGAR1ActionPerformed(evt);
            }
        });
        getContentPane().add(AGREGAR1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 140, 140, 80));

        MODIFICAR1.setFont(new java.awt.Font("Open Sans", 1, 15)); // NOI18N
        MODIFICAR1.setText("Modificar");
        MODIFICAR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MODIFICAR1ActionPerformed(evt);
            }
        });
        getContentPane().add(MODIFICAR1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 230, 120, 60));

        jPanel4.setBackground(new java.awt.Color(255, 73, 72));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Producto");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, -1, -1));

        USER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cliente.png"))); // NOI18N
        jPanel4.add(USER, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 170, 50));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/THC control.png"))); // NOI18N
        jLabel8.setOpaque(true);
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, -1, 100));

        jPanel2.setBackground(new java.awt.Color(255, 73, 72));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/lupa.png"))); // NOI18N
        jLabel4.setText("Buscar");

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
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BUSCAR, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BUSCAR, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 260, 60));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 100));

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 440));

        jMenu1.setText("Archivo");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/finalizar.png"))); // NOI18N
        jMenuItem1.setText("Salir");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void FINALIZAR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FINALIZAR1ActionPerformed
        Principal view = new Principal(nicknam);
        view.setVisible(true);
        this.setVisible(false);
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
            String prov = tabla.getValueAt(fila, 1).toString();
            String nombre = tabla.getValueAt(fila, 2).toString();
            String descripcion = tabla.getValueAt(fila, 3).toString();
            String marca = tabla.getValueAt(fila, 4).toString();
            String precio = tabla.getValueAt(fila, 5).toString();
            String volumen = tabla.getValueAt(fila, 6).toString();
            String cat = tabla.getValueAt(fila, 7).toString();

            modificarProducto mp = new modificarProducto(clave, prov, nombre, descripcion, marca, precio, volumen, cat);
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
    private javax.swing.JLabel USER;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
