package Principal;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.plaf.basic.BasicProgressBarUI;

/**
 *
 * @author Aarón
 */
public class SplashScreen extends javax.swing.JFrame implements Runnable {

    JLabel args[] = new JLabel[5];
    Thread thread;

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

    private void invisible() {
        args[0] = icon1;
        args[1] = icon2;
        args[2] = icon3;
        args[3] = icon4;
        args[4] = icon5;
        for (int i = 0; i < 5; i++) {
            args[i].setVisible(false);
        }
    }

    private void paintProgressBar() {
        progressBar.setUI(new BasicProgressBarUI());
        progressBar.setOpaque(true);
        progressBar.setBackground(Color.white);
        progressBar.setForeground(new Color(240, 0, 0));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        icon5 = new javax.swing.JLabel();
        icon1 = new javax.swing.JLabel();
        icon2 = new javax.swing.JLabel();
        icon3 = new javax.swing.JLabel();
        icon4 = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        icon5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/Icon5.png"))); // NOI18N
        getContentPane().add(icon5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 210, -1, -1));

        icon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/Icon1.png"))); // NOI18N
        getContentPane().add(icon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, -1, -1));

        icon2.setBackground(java.awt.Color.red);
        icon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/Icon2.png"))); // NOI18N
        getContentPane().add(icon2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, -1, -1));

        icon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/Icon3.png"))); // NOI18N
        getContentPane().add(icon3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, -1, -1));

        icon4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/Icon4.png"))); // NOI18N
        getContentPane().add(icon4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, -1, -1));

        progressBar.setBackground(new java.awt.Color(255, 255, 255));
        progressBar.setForeground(java.awt.Color.red);
        progressBar.setPreferredSize(new java.awt.Dimension(146, 8));
        getContentPane().add(progressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 292, 430, 5));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SplashScreen.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JProgressBar progressBar;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        int k = 0, j = 0;
        for (int i = 0; i < 100; i++) {
            progressBar.setValue(i);
            try {
                if (i > k) {
                    args[j].setVisible(true);
                    k = k + 20;
                    j++;
                }
                Thread.sleep(100);
            } catch (Exception e) {
            }
        }
//        this.dispose();
        this.setVisible(false);
        ScreenLogin log=new ScreenLogin();
        log.setVisible(true);
    }
}