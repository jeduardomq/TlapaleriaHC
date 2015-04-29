/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proveedores;

import Database.Conneccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author SWO
 */
public class modificarProveedor extends javax.swing.JFrame {

    String clave, nombre, apellido, calle, numero, ciudad, estado, rfc, ncasa, ncel, codigo, email;

    public modificarProveedor(String clav, String nombr, String apellid, String call, String numer, String ciuda, String estad, String rf, String ncas, String nce, String codig, String emai) {
        initComponents();
        this.setLocationRelativeTo(null);

        this.clave = clav;
        this.nombre = nombr;
        this.apellido = apellid;
        this.calle = call;
        this.numero = numer;
        this.ciudad = ciuda;
        this.estado = estad;
        this.rfc = rf;
        this.ncasa = ncas;
        this.ncel = nce;
        this.codigo = codig;
        this.email = emai;
        llenarDatos();
    }
public void modificar(String clave) {
        Conneccion mysql = new Conneccion();
        Connection cn = mysql.conectar();
        String aSQL = "UPDATE Proveedor "
                + "SET cveProveedor = ?,"
                + "nombre = ?,"
                + "apellidos = ?,"
                + "calle = ?,"
                + "numero = ?,"
                + "ciudad = ?,"
                + "estado = ?,"
                + "RFC = ?,"
                + "numCelular = ?,"
                + "numTelefono = ?,"
                + "codigoPostal = ?,"
                + "email = ?"
                + "WHERE cveProveedor = " + clave;

        String clav = Clav.getText();
        String nom = Nom.getText();
        String ape = Ape.getText();
        String call = Cal.getText();
        String num = Num.getText();
        String ciud = Ciu.getText();
        String est = Est.getText();
        String rfc = Rfc.getText();
        String casa = Ncas.getText();
        String cel = Nce.getText();
        String codi = Cod.getText();
        String mail = Ema.getText();

        try {
            PreparedStatement pst = cn.prepareStatement(aSQL);
            pst.setString(1, clav);
            pst.setString(2, nom);
            pst.setString(3, ape);
            pst.setString(4, call);
            pst.setString(5, num);
            pst.setString(6, ciud);
            pst.setString(7, est);
            pst.setString(8, rfc);
            pst.setString(9, casa);
            pst.setString(10, cel);
            pst.setString(11, codi);
            pst.setString(12, mail);
            

            int n = pst.executeUpdate();

            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Modificacion Correcta");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    //clave, nombre, nombre,apellido,calle,numero,ciudad,estado,rfc,ncasa,ncel,codigo,email

    public modificarProveedor() {
        initComponents();
        this.setLocationRelativeTo(null);
        llenarDatos();
    }

    public void llenarDatos() {
        Clav.setText(clave);
        Nom.setText(nombre);
        Ape.setText(apellido);
        Cal.setText(calle);
        Num.setText(numero);
        Ciu.setText(ciudad);
        Est.setText(estado);
        Rfc.setText(rfc);
        Ncas.setText(ncasa);
        Nce.setText(ncel);
        Cod.setText(codigo);
        Ema.setText(email);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        MODIFICAR = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        Nom = new javax.swing.JTextField();
        Ape = new javax.swing.JTextField();
        Cal = new javax.swing.JTextField();
        Num = new javax.swing.JTextField();
        Ciu = new javax.swing.JTextField();
        Est = new javax.swing.JTextField();
        Rfc = new javax.swing.JTextField();
        Nce = new javax.swing.JTextField();
        Ncas = new javax.swing.JTextField();
        Cod = new javax.swing.JTextField();
        Ema = new javax.swing.JTextField();
        Clav = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Modificar Proveedor");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MODIFICAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/actualizar.png"))); // NOI18N
        MODIFICAR.setText("Modificar");
        MODIFICAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MODIFICARActionPerformed(evt);
            }
        });
        jPanel2.add(MODIFICAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cancelar.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 8, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 340, 60));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Nombre");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 13, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Apellido");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 43, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Calle");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 73, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Numero");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 103, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Ciudad");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 133, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Estado");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 163, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("RFC");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 193, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Numero de Celular");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 223, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Numero Telefonico");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Codigo Postal");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 283, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Email");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 313, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Calve");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 342, -1, -1));

        Nom.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(Nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 219, -1));

        Ape.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(Ape, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 219, -1));

        Cal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(Cal, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 219, -1));

        Num.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Num.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumActionPerformed(evt);
            }
        });
        jPanel1.add(Num, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 219, -1));

        Ciu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(Ciu, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 219, -1));

        Est.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(Est, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 220, -1));

        Rfc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(Rfc, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 220, -1));

        Nce.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(Nce, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 220, -1));

        Ncas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(Ncas, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 220, -1));

        Cod.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(Cod, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 220, -1));

        Ema.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(Ema, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 220, -1));

        Clav.setEditable(false);
        Clav.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Clav.setEnabled(false);
        jPanel1.add(Clav, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 339, 220, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 380, 380));

        jPanel5.setBackground(new java.awt.Color(255, 73, 72));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Modificar Proveedor");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(159, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addContainerGap())
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, -1));

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 410, 530));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/archivo.png"))); // NOI18N
        jMenu1.setText("Archivo");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/finalizar.png"))); // NOI18N
        jMenuItem1.setText("Salir");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int reply = JOptionPane.showConfirmDialog(this, "¿Desea cancelar? ", "CANCELAR", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            Proveedor p = new Proveedor();
            p.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void MODIFICARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MODIFICARActionPerformed
        String clave = Clav.getText();
        modificar(clave);
        Proveedor p = new Proveedor();
        p.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MODIFICARActionPerformed

    private void NumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NumActionPerformed

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
            java.util.logging.Logger.getLogger(modificarProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(modificarProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(modificarProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(modificarProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new modificarProveedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Ape;
    private javax.swing.JTextField Cal;
    private javax.swing.JTextField Ciu;
    private javax.swing.JTextField Clav;
    private javax.swing.JTextField Cod;
    private javax.swing.JTextField Ema;
    private javax.swing.JTextField Est;
    private javax.swing.JButton MODIFICAR;
    private javax.swing.JTextField Ncas;
    private javax.swing.JTextField Nce;
    private javax.swing.JTextField Nom;
    private javax.swing.JTextField Num;
    private javax.swing.JTextField Rfc;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}
