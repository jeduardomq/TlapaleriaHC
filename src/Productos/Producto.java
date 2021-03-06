package Productos;

import Database.Conneccion;
import Principal.Principal;
import Principal.ScreenAddUser;
import Ajustes.agregarCategoria;
import Ajustes.agregarMedidas;
import Inventarios.Inventario;
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
    String busq = "nombre";

    public Producto() {
        initComponents();
//        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        buscar();
        cargartabla("");
        lista.setVisible(false);
        left.setVisible(false);
    }

    public Producto(String nickname) {
        initComponents();
//        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        buscar();
        cargartabla("");
        this.nicknam = nickname;
        USER.setText(nicknam);
        lista.setVisible(false);
        left.setVisible(false);
    }

    public void cargartabla(String valor) {
        String[] titulos = {"cveProducto", "Proveedor", "Nombre", "Descripcion", "Marca", "Precio", "Medida", "Categoria"};
        String[] registro = new String[8];
        String aSQL = "";
        modelo = new DefaultTableModel(null, titulos);
        Conneccion mysql = new Conneccion();
        Connection cn = mysql.conectar();
        aSQL = "SELECT cveProducto,cveProveedor,nombre,descripcion, marca, precioCompra, medida,categoria FROM Producto "
                + "WHERE " + busq + " LIKE '%" + valor + "%'";
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

    public void buscar() {
        busq = (String) lista.getSelectedItem();
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
        left = new javax.swing.JLabel();
        right = new javax.swing.JLabel();
        lista = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

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

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Producto");

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

        lista.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "nombre", "cveProducto", "cveProveedor", "marca", "categoria" }));
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
                .addGap(40, 40, 40)
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

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 100));

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 440));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/archivo.png"))); // NOI18N
        jMenu1.setText("Archivo");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/finalizar.png"))); // NOI18N
        jMenuItem1.setText("Salir");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/usuarios.png"))); // NOI18N
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

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ajustes.png"))); // NOI18N
        jMenu3.setText("Ajustes");

        jMenuItem5.setText("Inventario");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuItem3.setText("Agregar Categoria");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuItem4.setText("Agregar Unidades de Medida");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuBar1.add(jMenu3);

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

    private void listaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaActionPerformed
        buscar();
    }//GEN-LAST:event_listaActionPerformed

    private void rightMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rightMouseClicked
        right.setVisible(false);
        left.setVisible(true);
        lista.setVisible(true);
    }//GEN-LAST:event_rightMouseClicked

    private void leftMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_leftMouseClicked
        right.setVisible(true);
        left.setVisible(false);
        lista.setVisible(false);
    }//GEN-LAST:event_leftMouseClicked

    private void MODIFICAR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MODIFICAR1ActionPerformed
        modificarProducto mp = new modificarProducto();
        mp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MODIFICAR1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        ScreenAddUser su = new ScreenAddUser();
        su.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        Inventario view = new Inventario();
        view.setVisible(true);
        //        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        agregarCategoria view = new agregarCategoria();
        view.setVisible(true);
        //        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        agregarMedidas view = new agregarMedidas();
        view.setVisible(true);
        //        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

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
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel left;
    private javax.swing.JComboBox lista;
    private javax.swing.JLabel right;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
