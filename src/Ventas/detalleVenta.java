package Ventas;

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

public class detalleVenta extends javax.swing.JFrame {

    DefaultTableModel modelo;
    String nicknam;
    String clave;

    public detalleVenta() {
        initComponents();
        this.setLocationRelativeTo(null);
        cargartabla("");
    }

    public detalleVenta(String nickname,String clav) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.clave=clav;
        cargartabla(clav);
        this.nicknam = nickname;    
        USER.setText(nicknam);
    }

    public void cargartabla(String valor) {
        String[] titulos = {"Cantidad", "Clave producto","Nombre","Descripcion","Precio"};
        String[] registro = new String[5];
        modelo = new DefaultTableModel(null, titulos);
        Conneccion mysql = new Conneccion();
        Connection cn = mysql.conectar();
        String aSQL = "SELECT c.nombre,c.apellidos,nickname,fecha,hora,subtotal,total,cantidad,p.cveProducto,p.nombre,p.descripcion,p.descripcion,Precio "
                + "FROM venta v inner join detventas d on v.cveVenta=d.cveVenta "
                + "inner join producto p on p.cveProducto=d.cveProducto "
                + "inner join cliente c on c.cveCliente=v.cveCliente "
                + "WHERE d.cveVenta="+clave;

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(aSQL);
            while (rs.next()) {
                cliente.setText(rs.getString("c.nombre")+" "+rs.getString("c.apellidos"));
                vendedor.setText(rs.getString("nickname"));
                fecha.setText(rs.getString("fecha"));
                hora.setText(rs.getString("hora"));
                subtotal.setText(rs.getString("subtotal"));
                total.setText(rs.getString("total"));
                registro[0] = rs.getString("cantidad");
                registro[1] = rs.getString("p.cveProducto");
                registro[2] = rs.getString("p.nombre");
                registro[3] = rs.getString("p.descripcion");
                registro[4] = rs.getString("precio");

                modelo.addRow(registro);
            }
            tabla.setModel(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane5 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        FINALIZAR1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        USER = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Calle = new javax.swing.JLabel();
        Calle1 = new javax.swing.JLabel();
        Calle4 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cliente = new javax.swing.JTextField();
        fecha = new javax.swing.JTextField();
        hora = new javax.swing.JTextField();
        total = new javax.swing.JTextField();
        subtotal = new javax.swing.JTextField();
        vendedor = new javax.swing.JTextField();
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
        setTitle("V E N T A S");
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

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 650, 270));

        FINALIZAR1.setFont(new java.awt.Font("Open Sans", 1, 15)); // NOI18N
        FINALIZAR1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/finalizar.png"))); // NOI18N
        FINALIZAR1.setText("Finalizar");
        FINALIZAR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FINALIZAR1ActionPerformed(evt);
            }
        });
        getContentPane().add(FINALIZAR1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 370, 140, 50));

        jPanel4.setBackground(new java.awt.Color(255, 73, 72));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Detalle de venta");

        USER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cliente.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/THC control.png"))); // NOI18N
        jLabel8.setOpaque(true);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(USER, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(490, 490, 490))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(196, 196, 196)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(jLabel8))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(USER, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel7)
            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 100));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cliente:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fecha:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        Calle.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Calle.setForeground(new java.awt.Color(255, 255, 255));
        Calle.setText("Hora:");
        jPanel1.add(Calle, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        Calle1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Calle1.setForeground(new java.awt.Color(255, 255, 255));
        Calle1.setText("Subtotal:");
        jPanel1.add(Calle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        Calle4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Calle4.setForeground(new java.awt.Color(255, 255, 255));
        Calle4.setText("Total:");
        jPanel1.add(Calle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Vendedor");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        cliente.setEditable(false);
        jPanel1.add(cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 148, -1));

        fecha.setEditable(false);
        jPanel1.add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 148, -1));

        hora.setEditable(false);
        jPanel1.add(hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 148, -1));

        total.setEditable(false);
        jPanel1.add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 148, -1));

        subtotal.setEditable(false);
        jPanel1.add(subtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 148, -1));

        vendedor.setEditable(false);
        jPanel1.add(vendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 148, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 130, 240, 230));

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 440));

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
            java.util.logging.Logger.getLogger(detalleVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(detalleVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(detalleVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(detalleVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new detalleVenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Calle;
    private javax.swing.JLabel Calle1;
    private javax.swing.JLabel Calle4;
    private javax.swing.JButton FINALIZAR1;
    private javax.swing.JLabel USER;
    private javax.swing.JTextField cliente;
    private javax.swing.JTextField fecha;
    private javax.swing.JTextField hora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField subtotal;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField total;
    private javax.swing.JTextField vendedor;
    // End of variables declaration//GEN-END:variables
}
