package Inventarios;

import Database.Conneccion;
import Principal.ScreenAddUser;
import Ajustes.agregarCategoria;
import Ajustes.agregarMedidas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Inventario extends javax.swing.JFrame {
    
    DefaultTableModel modelo;
    String busq = "nombre";
    
    public Inventario() {
        initComponents();
        //        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        buscar();
        cargartabla("");
        GUARDAR.setVisible(false);
        lista.setVisible(false);
        left.setVisible(false);
        
    }
    
    public void cargartabla(String valor) {
        String[] titulos = {"Clave", "Nombre", "Cantidad", "Stock", "Descripcion", "Marca", "Precio"};
        String[] registro = new String[7];
        String aSQL = "";
        modelo = new DefaultTableModel(null, titulos);
        Conneccion mysql = new Conneccion();
        Connection cn = mysql.conectar();
//        aSQL = "SELECT cveProducto,cveProveedor,nombre,descripcion, marca, precioCompra, medida,categoria FROM Producto "
//                + "WHERE " + busq + " LIKE '%" + valor + "%'";
        aSQL = "SELECT p.cveProducto,p.nombre,p.descripcion,p.marca,p.precioCompra,i.cantidad,i.stockMinimo FROM Inventario i inner join Producto p on i.cveProducto=p.cveProducto "
                + "WHERE " + busq + " LIKE '%" + valor + "%'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(aSQL);
            while (rs.next()) {
                registro[0] = rs.getString("cveProducto");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("cantidad");
                registro[3] = rs.getString("stockMinimo");
                registro[4] = rs.getString("descripcion");
                registro[5] = rs.getString("marca");
                registro[6] = rs.getString("precioCompra");
                
                modelo.addRow(registro);
            }
            tabla.setModel(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void modificar(String clave, String canti, String stock) {
        Conneccion mysql = new Conneccion();
        Connection cn = mysql.conectar();
        String aSQL = "UPDATE Inventario SET "
                + "cveProducto=?, "
                + "cantidad=?, "
                + "stockMinimo=?"
                + "WHERE cveProducto = " + clave;
        String cant = cantidad.getText();
        String stok = minimo.getText();
        try {
            PreparedStatement pst = cn.prepareStatement(aSQL);
            pst.setString(1, clave);
            pst.setString(2, cant);
            pst.setString(3, stok);
            int n = pst.executeUpdate();
            
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Modificacion Correcta");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public void llenarDatos(String canti, String stock) {
        cantidad.setText(canti);
        minimo.setText(stock);
    }
    
    public void buscar() {
        busq = (String) lista.getSelectedItem();
    }

    public void limpiar() {
        cantidad.setText("");
        minimo.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        USER = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        BUSCAR = new javax.swing.JTextField();
        left = new javax.swing.JLabel();
        right = new javax.swing.JLabel();
        lista = new javax.swing.JComboBox();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        cantidad = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        minimo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        MODIFICAR1 = new javax.swing.JButton();
        GUARDAR = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 73, 72));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Inventario");

        USER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cliente.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/THC control.png"))); // NOI18N
        jLabel8.setOpaque(true);

        jPanel2.setBackground(new java.awt.Color(255, 73, 72));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/lupa.png"))); // NOI18N
        jLabel4.setText("Buscar");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, 40));

        BUSCAR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BUSCARKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BUSCARKeyReleased(evt);
            }
        });
        jPanel2.add(BUSCAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 18, 120, 30));

        left.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/left.png"))); // NOI18N
        left.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                leftMouseClicked(evt);
            }
        });
        jPanel2.add(left, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 50, 40));

        right.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/right.png"))); // NOI18N
        right.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rightMouseClicked(evt);
            }
        });
        jPanel2.add(right, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 50, 40));

        lista.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "nombre", "stockMinimo", "cantidad" }));
        lista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaActionPerformed(evt);
            }
        });
        jPanel2.add(lista, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 120, -1));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(USER, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabel7))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jLabel8))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(USER, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(1, 1, 1)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 100));

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

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 660, 270));
        getContentPane().add(cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 120, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cantidad");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, -1, -1));
        getContentPane().add(minimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 120, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Stock Minimo:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, 100, -1));

        MODIFICAR1.setFont(new java.awt.Font("Open Sans", 1, 15)); // NOI18N
        MODIFICAR1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/actualizar.png"))); // NOI18N
        MODIFICAR1.setText("Modificar");
        MODIFICAR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MODIFICAR1ActionPerformed(evt);
            }
        });
        getContentPane().add(MODIFICAR1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 290, 140, 60));

        GUARDAR.setFont(new java.awt.Font("Open Sans", 1, 15)); // NOI18N
        GUARDAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/guardar.png"))); // NOI18N
        GUARDAR.setText("Guardar");
        GUARDAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GUARDARActionPerformed(evt);
            }
        });
        getContentPane().add(GUARDAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 140, 140, 40));

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BUSCARKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BUSCARKeyPressed
        String valor = BUSCAR.getText();
        cargartabla(valor);
    }//GEN-LAST:event_BUSCARKeyPressed

    private void BUSCARKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BUSCARKeyReleased
        String valor = BUSCAR.getText();
        cargartabla(valor);
    }//GEN-LAST:event_BUSCARKeyReleased

    private void leftMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_leftMouseClicked
        right.setVisible(true);
        left.setVisible(false);
        lista.setVisible(false);
    }//GEN-LAST:event_leftMouseClicked

    private void rightMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rightMouseClicked
        right.setVisible(false);
        left.setVisible(true);
        lista.setVisible(true);
    }//GEN-LAST:event_rightMouseClicked

    private void listaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaActionPerformed
        buscar();
    }//GEN-LAST:event_listaActionPerformed

    private void MODIFICAR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MODIFICAR1ActionPerformed
        int fila = tabla.getSelectedRow();
        if (fila >= 0) {
            String cant = tabla.getValueAt(fila, 3).toString();
            String stock = tabla.getValueAt(fila, 2).toString();
            llenarDatos(cant,stock);
            MODIFICAR1.setVisible(false);
            GUARDAR.setVisible(true);
        }
    }//GEN-LAST:event_MODIFICAR1ActionPerformed

    private void GUARDARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GUARDARActionPerformed
        int fila = tabla.getSelectedRow();
        if (fila >= 0) {
            String clave = tabla.getValueAt(fila, 0).toString();
            String nombre = tabla.getValueAt(fila, 1).toString();
            String des = tabla.getValueAt(fila, 2).toString();
            modificar(clave, nombre, des);
            GUARDAR.setVisible(false);
            MODIFICAR1.setVisible(true);
        }
        cargartabla("");
    }//GEN-LAST:event_GUARDARActionPerformed
    public static void main(String args[]) {        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
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
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inventario().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BUSCAR;
    private javax.swing.JButton GUARDAR;
    private javax.swing.JButton MODIFICAR1;
    private javax.swing.JLabel USER;
    private javax.swing.JTextField cantidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel left;
    private javax.swing.JComboBox lista;
    private javax.swing.JTextField minimo;
    private javax.swing.JLabel right;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
