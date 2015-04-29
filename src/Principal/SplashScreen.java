/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Principal;

import com.sun.awt.AWTUtilities;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.plaf.basic.BasicProgressBarUI;

/**
 *
 * @author Aarón
 */
public class SplashScreen extends javax.swing.JFrame implements Runnable{
    JLabel args[] = new JLabel[5];
    Thread thread;
    ScreenLogin sLogin = new ScreenLogin();
    /**
     * Creates new form SplashScreen
     */
    public SplashScreen() {
        initComponents();
        invisible();
        setLocationRelativeTo(null);
        thread = new Thread(this);
        thread.start();
        paintProgressBar();
    }
    
    private void invisible(){

            args[0] = icon1;
            args[1] = icon2;
            args[2] = icon3;
            args[3] = icon4;
            args[4] = icon5;
            
            for (int i = 0; i < 5; i++) {
                args[i].setVisible(false);
            }

    } 
    
     private void paintProgressBar(){
       progressBar.setUI(new BasicProgressBarUI());
       progressBar.setOpaque(true);
       progressBar.setBackground(Color.white);
       progressBar.setForeground(new Color(240, 0, 0));
    }

     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        icon1 = new javax.swing.JLabel();
        icon2 = new javax.swing.JLabel();
        icon3 = new javax.swing.JLabel();
        icon4 = new javax.swing.JLabel();
        icon5 = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPanel1KeyTyped(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Control System THC");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        icon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/Icon1.png"))); // NOI18N
        jPanel1.add(icon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        icon2.setBackground(java.awt.Color.red);
        icon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/Icon2.png"))); // NOI18N
        jPanel1.add(icon2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, -1, -1));

        icon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/Icon3.png"))); // NOI18N
        jPanel1.add(icon3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, -1, -1));

        icon4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/Icon4.png"))); // NOI18N
        jPanel1.add(icon4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, -1, -1));

        icon5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/Icon5.png"))); // NOI18N
        jPanel1.add(icon5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, -1, -1));

        progressBar.setBackground(new java.awt.Color(255, 255, 255));
        progressBar.setForeground(java.awt.Color.red);
        progressBar.setPreferredSize(new java.awt.Dimension(146, 8));
        jPanel1.add(progressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 430, 5));

        jLabel3.setText("Copyright ©2015, All Rights Reserved ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyTyped
        
    }//GEN-LAST:event_jPanel1KeyTyped

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
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SplashScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel icon1;
    private javax.swing.JLabel icon2;
    private javax.swing.JLabel icon3;
    private javax.swing.JLabel icon4;
    private javax.swing.JLabel icon5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar progressBar;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        int k = 0,j = 0; 
        for (int i = 0; i < 100; i++) {
            progressBar.setValue(i);
            if(i<75){
                    AWTUtilities.setWindowOpaque(this, true);
                    AWTUtilities.setWindowOpacity(this, (i+25)/100f);
                }
             try {
                if(i > k)
                {
                    args[j].setVisible(true);
                    k = k+20;
                    j++;
                }                 
                thread.sleep(50);
            } catch (Exception e) {
            }
        }
        this.dispose();
        sLogin.run();
    }
}
