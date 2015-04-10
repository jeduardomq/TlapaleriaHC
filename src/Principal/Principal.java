package Principal;

import Ajustes.agregarCategoria;
import Ajustes.agregarMedidas;
import Clientes.Cliente;
import Inventarios.Inventario;
import Productos.Producto;
import Proveedores.Proveedor;
import Ventas.seleccionVenta;
import javax.swing.JOptionPane;

public class Principal extends javax.swing.JFrame {

    String nicknam, tip;

    public Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public Principal(String nickname) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.nicknam = nickname;
//        this.tip=tipo;
        USER.setText(nicknam);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        PROVEEDORES = new javax.swing.JButton();
        CLIENTES = new javax.swing.JButton();
        PRODUCTOS = new javax.swing.JButton();
        VENTAS = new javax.swing.JButton();
        EDITAR = new javax.swing.JButton();
        SALIR = new javax.swing.JButton();
        USER = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
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
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(51, 51, 255));
        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("B I E N V E N I D O");
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 420, 100));

        PROVEEDORES.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/proveedor.png"))); // NOI18N
        PROVEEDORES.setText("Proveedores");
        PROVEEDORES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PROVEEDORESActionPerformed(evt);
            }
        });
        getContentPane().add(PROVEEDORES, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, 150, 60));

        CLIENTES.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cliente.png"))); // NOI18N
        CLIENTES.setText("Clientes");
        CLIENTES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CLIENTESActionPerformed(evt);
            }
        });
        getContentPane().add(CLIENTES, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 150, 49));

        PRODUCTOS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/producto.png"))); // NOI18N
        PRODUCTOS.setText("Productos");
        PRODUCTOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRODUCTOSActionPerformed(evt);
            }
        });
        getContentPane().add(PRODUCTOS, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 150, 53));

        VENTAS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/venta.png"))); // NOI18N
        VENTAS.setText("Ventas");
        VENTAS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VENTASActionPerformed(evt);
            }
        });
        getContentPane().add(VENTAS, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, 150, 47));

        EDITAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/editar.png"))); // NOI18N
        EDITAR.setText("Editar perfil");
        EDITAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EDITARActionPerformed(evt);
            }
        });
        getContentPane().add(EDITAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 150, 60));

        SALIR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/finalizar.png"))); // NOI18N
        SALIR.setText("Salir");
        SALIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SALIRActionPerformed(evt);
            }
        });
        getContentPane().add(SALIR, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 150, 50));

        USER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cliente.png"))); // NOI18N
        getContentPane().add(USER, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 170, 50));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/THC control.png"))); // NOI18N
        jLabel5.setOpaque(true);
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 180, 100));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Screen.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("L O G O");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 100, -1));

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

    private void PRODUCTOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRODUCTOSActionPerformed
        Producto view = new Producto(nicknam);
        view.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_PRODUCTOSActionPerformed

    private void CLIENTESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CLIENTESActionPerformed
        Cliente view = new Cliente(nicknam);
        view.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_CLIENTESActionPerformed

    private void PROVEEDORESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PROVEEDORESActionPerformed
        Proveedor view = new Proveedor(nicknam);
        view.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_PROVEEDORESActionPerformed

    private void VENTASActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VENTASActionPerformed
        seleccionVenta view = new seleccionVenta();
        view.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_VENTASActionPerformed

    private void SALIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SALIRActionPerformed
        int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION);
        if (JOptionPane.YES_NO_OPTION == resp) {
            System.exit(0);
        } else {
            System.out.println("CANCELAR");
        }
    }//GEN-LAST:event_SALIRActionPerformed

    private void EDITARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EDITARActionPerformed
        ScreenAddUser su = new ScreenAddUser(nicknam);
        su.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_EDITARActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        ScreenAddUser su = new ScreenAddUser();
        su.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        Inventario view = new Inventario();
        view.setVisible(true);
        //        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CLIENTES;
    private javax.swing.JButton EDITAR;
    private javax.swing.JButton PRODUCTOS;
    private javax.swing.JButton PROVEEDORES;
    private javax.swing.JButton SALIR;
    private javax.swing.JLabel USER;
    private javax.swing.JButton VENTAS;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    // End of variables declaration//GEN-END:variables
}
