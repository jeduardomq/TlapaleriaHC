/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Database.connectionMySQL;
import java.awt.Color;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Aarón
 */
public class AdministratorMenu extends javax.swing.JFrame implements Runnable {

    Thread h1;
    connectionMySQL conect;

    public connectionMySQL getConect() {
        return conect;
    }

    public void setConect(connectionMySQL conect) {
        this.conect = conect;
    }

    ImageIcon addUser = new ImageIcon(getClass().getResource("/Images/Icons/Users/AddUser.png"));
    ImageIcon addUser2 = new ImageIcon(getClass().getResource("/Images/Icons/Users/AddUser2.png"));

    ImageIcon EditUser = new ImageIcon(getClass().getResource("/Images/Icons/Users/EditUser.png"));
    ImageIcon EditUser2 = new ImageIcon(getClass().getResource("/Images/Icons/Users/EditUser2.png"));

    ImageIcon QueryUser = new ImageIcon(getClass().getResource("/Images/Icons/Users/QueryUser.png"));
    ImageIcon QueryUser2 = new ImageIcon(getClass().getResource("/Images/Icons/Users/QueryUser2.png"));

    ImageIcon bita = new ImageIcon(getClass().getResource("/Images/Icons/Users/bita.png"));
    ImageIcon bita2 = new ImageIcon(getClass().getResource("/Images/Icons/Users/bita2.png"));

    ImageIcon newSale = new ImageIcon(getClass().getResource("/Images/Icons/Users/newSale.png"));
    ImageIcon newSale2 = new ImageIcon(getClass().getResource("/Images/Icons/Users/newSale2.png"));

    ImageIcon SalesToday = new ImageIcon(getClass().getResource("/Images/Icons/Users/SalesToday.png"));
    ImageIcon SalesToday2 = new ImageIcon(getClass().getResource("/Images/Icons/Users/SalesToday2.png"));

    ImageIcon SalesMonth = new ImageIcon(getClass().getResource("/Images/Icons/Users/SalesMonth.png"));
    ImageIcon SalesMonth2 = new ImageIcon(getClass().getResource("/Images/Icons/Users/SalesMonth2.png"));

    ImageIcon SalesSearch = new ImageIcon(getClass().getResource("/Images/Icons/Users/SearchSales.png"));
    ImageIcon SalesSearch2 = new ImageIcon(getClass().getResource("/Images/Icons/Users/SearchSales2.png"));

    ImageIcon AddClient = new ImageIcon(getClass().getResource("/Images/Icons/Users/AddClient.png"));
    ImageIcon AddClient2 = new ImageIcon(getClass().getResource("/Images/Icons/Users/AddClient2.png"));

    ImageIcon EditClient = new ImageIcon(getClass().getResource("/Images/Icons/Users/EditClient.png"));
    ImageIcon EditClient2 = new ImageIcon(getClass().getResource("/Images/Icons/Users/EditClient2.png"));

    ImageIcon QueryClient = new ImageIcon(getClass().getResource("/Images/Icons/Users/QueryClient.png"));
    ImageIcon QueryClient2 = new ImageIcon(getClass().getResource("/Images/Icons/Users/QueryClient2.png"));

    ImageIcon SalesReport = new ImageIcon(getClass().getResource("/Images/Icons/Users/ReportSale.png"));
    ImageIcon SalesReport2 = new ImageIcon(getClass().getResource("/Images/Icons/Users/ReportSale2.png"));

    ImageIcon ClientReport = new ImageIcon(getClass().getResource("/Images/Icons/Users/ClientReport.png"));
    ImageIcon ClientReport2 = new ImageIcon(getClass().getResource("/Images/Icons/Users/ClientReport2.png"));

    /**
     * Creates new form ScreenAddUser
     */
    public AdministratorMenu() {
        initComponents();
        h1 = new Thread(this);
        h1.start();
        this.setExtendedState(MAXIMIZED_BOTH);
    }

    public void calcula() {
        Calendar c1 = GregorianCalendar.getInstance();
        dateBox.setText(c1.getTime().toLocaleString());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        CloseButton = new javax.swing.JLabel();
        dateBox = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        newSaleButton = new javax.swing.JLabel();
        salesTodayButton = new javax.swing.JLabel();
        salesMonthButton = new javax.swing.JLabel();
        SalesSearchButton = new javax.swing.JLabel();
        SalesReportButton = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        AddClientButton = new javax.swing.JLabel();
        EditClientButton = new javax.swing.JLabel();
        QueryClientButton = new javax.swing.JLabel();
        ClientReportButton = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        bitButton = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        addUserButton = new javax.swing.JLabel();
        editUserButton = new javax.swing.JLabel();
        queryUserButton = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jPanel2.setBackground(new java.awt.Color(237, 27, 35));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Menu Administrador");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("THC ControlSystem");

        CloseButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CloseButton.setForeground(new java.awt.Color(204, 204, 204));
        CloseButton.setText("Cerrar");
        CloseButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CloseButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CloseButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CloseButtonMouseExited(evt);
            }
        });

        dateBox.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        dateBox.setForeground(new java.awt.Color(255, 255, 255));
        dateBox.setText("Fecha");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(CloseButton))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dateBox)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(dateBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CloseButton)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gestion de Productos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 92, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gestion de Ventas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        newSaleButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        newSaleButton.setForeground(new java.awt.Color(255, 255, 255));
        newSaleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/Users/newSale.png"))); // NOI18N
        newSaleButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                newSaleButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                newSaleButtonMouseExited(evt);
            }
        });

        salesTodayButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/Users/SalesToday.png"))); // NOI18N
        salesTodayButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                salesTodayButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                salesTodayButtonMouseExited(evt);
            }
        });

        salesMonthButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/Users/SalesMonth.png"))); // NOI18N
        salesMonthButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                salesMonthButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                salesMonthButtonMouseExited(evt);
            }
        });

        SalesSearchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/Users/SearchSales.png"))); // NOI18N
        SalesSearchButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SalesSearchButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SalesSearchButtonMouseExited(evt);
            }
        });

        SalesReportButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/Users/ReportSale.png"))); // NOI18N
        SalesReportButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SalesReportButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SalesReportButtonMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(newSaleButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(salesTodayButton)
                .addGap(18, 18, 18)
                .addComponent(salesMonthButton)
                .addGap(18, 18, 18)
                .addComponent(SalesSearchButton)
                .addGap(18, 18, 18)
                .addComponent(SalesReportButton))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SalesReportButton)
                    .addComponent(SalesSearchButton)
                    .addComponent(salesMonthButton)
                    .addComponent(newSaleButton)
                    .addComponent(salesTodayButton))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gestion de Clientes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        AddClientButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/Users/AddClient.png"))); // NOI18N
        AddClientButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddClientButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AddClientButtonMouseExited(evt);
            }
        });

        EditClientButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/Users/EditClient.png"))); // NOI18N
        EditClientButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EditClientButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EditClientButtonMouseExited(evt);
            }
        });

        QueryClientButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/Users/QueryClient.png"))); // NOI18N
        QueryClientButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                QueryClientButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                QueryClientButtonMouseExited(evt);
            }
        });

        ClientReportButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/Users/ClientReport.png"))); // NOI18N
        ClientReportButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ClientReportButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ClientReportButtonMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AddClientButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(EditClientButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(QueryClientButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ClientReportButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EditClientButton)
                            .addComponent(AddClientButton)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ClientReportButton)
                            .addComponent(QueryClientButton))
                        .addGap(0, 5, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gestion de Compras", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gestion de Proveedores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bitacora", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        bitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/Users/bita.png"))); // NOI18N
        bitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bitButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bitButtonMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bitButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bitButton)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(51, 51, 51));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gestion de Usuarios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        addUserButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/Users/AddUser.png"))); // NOI18N
        addUserButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addUserButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addUserButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addUserButtonMouseExited(evt);
            }
        });

        editUserButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/Users/EditUser.png"))); // NOI18N
        editUserButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editUserButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editUserButtonMouseExited(evt);
            }
        });

        queryUserButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/Users/QueryUser.png"))); // NOI18N
        queryUserButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                queryUserButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                queryUserButtonMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(queryUserButton))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addUserButton)
                    .addComponent(editUserButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addUserButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editUserButton)
                .addGap(18, 18, 18)
                .addComponent(queryUserButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addUserButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addUserButtonMouseEntered
        addUserButton.setIcon(addUser2);
    }//GEN-LAST:event_addUserButtonMouseEntered

    private void addUserButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addUserButtonMouseExited
        addUserButton.setIcon(addUser);
    }//GEN-LAST:event_addUserButtonMouseExited

    private void editUserButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editUserButtonMouseEntered
        editUserButton.setIcon(EditUser2);
    }//GEN-LAST:event_editUserButtonMouseEntered

    private void editUserButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editUserButtonMouseExited
        editUserButton.setIcon(EditUser);
    }//GEN-LAST:event_editUserButtonMouseExited

    private void queryUserButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_queryUserButtonMouseEntered
        queryUserButton.setIcon(QueryUser2);
    }//GEN-LAST:event_queryUserButtonMouseEntered

    private void queryUserButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_queryUserButtonMouseExited
        queryUserButton.setIcon(QueryUser);
    }//GEN-LAST:event_queryUserButtonMouseExited

    private void bitButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bitButtonMouseEntered
        bitButton.setIcon(bita2);
    }//GEN-LAST:event_bitButtonMouseEntered

    private void bitButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bitButtonMouseExited
        bitButton.setIcon(bita);
    }//GEN-LAST:event_bitButtonMouseExited

    private void newSaleButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newSaleButtonMouseEntered
        newSaleButton.setIcon(newSale2);
    }//GEN-LAST:event_newSaleButtonMouseEntered

    private void newSaleButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newSaleButtonMouseExited
        newSaleButton.setIcon(newSale);
    }//GEN-LAST:event_newSaleButtonMouseExited

    private void salesTodayButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesTodayButtonMouseEntered
        salesTodayButton.setIcon(SalesToday2);
    }//GEN-LAST:event_salesTodayButtonMouseEntered

    private void salesTodayButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesTodayButtonMouseExited
        salesTodayButton.setIcon(SalesToday);
    }//GEN-LAST:event_salesTodayButtonMouseExited

    private void CloseButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseButtonMouseEntered
        CloseButton.setForeground(Color.WHITE);
    }//GEN-LAST:event_CloseButtonMouseEntered

    private void CloseButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseButtonMouseExited
        CloseButton.setForeground(new Color(240, 240, 240));
    }//GEN-LAST:event_CloseButtonMouseExited

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int n = JOptionPane.showConfirmDialog(null, "Al cerrar se cerrara tambien su sesion. ¿Desea continuar?");
        System.out.println(n);
        if (n == 0) {
            this.dispose();
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void CloseButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseButtonMouseClicked

    }//GEN-LAST:event_CloseButtonMouseClicked

    private void addUserButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addUserButtonMouseClicked
//        ScreenAddUser sAddUser = new ScreenAddUser();
//        sAddUser.setConect(this.getConect());
//        sAddUser.show();
    }//GEN-LAST:event_addUserButtonMouseClicked

    private void salesMonthButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesMonthButtonMouseEntered
        salesMonthButton.setIcon(SalesMonth2);
    }//GEN-LAST:event_salesMonthButtonMouseEntered

    private void salesMonthButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesMonthButtonMouseExited
        salesMonthButton.setIcon(SalesMonth);
    }//GEN-LAST:event_salesMonthButtonMouseExited

    private void SalesSearchButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalesSearchButtonMouseEntered
        SalesSearchButton.setIcon(SalesSearch2);
    }//GEN-LAST:event_SalesSearchButtonMouseEntered

    private void SalesSearchButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalesSearchButtonMouseExited
        SalesSearchButton.setIcon(SalesSearch);
    }//GEN-LAST:event_SalesSearchButtonMouseExited

    private void AddClientButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddClientButtonMouseEntered
        AddClientButton.setIcon(AddClient2);
    }//GEN-LAST:event_AddClientButtonMouseEntered

    private void AddClientButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddClientButtonMouseExited
        AddClientButton.setIcon(AddClient);
    }//GEN-LAST:event_AddClientButtonMouseExited

    private void EditClientButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditClientButtonMouseEntered
        EditClientButton.setIcon(EditClient2);
    }//GEN-LAST:event_EditClientButtonMouseEntered

    private void EditClientButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditClientButtonMouseExited
        EditClientButton.setIcon(EditClient);
    }//GEN-LAST:event_EditClientButtonMouseExited

    private void QueryClientButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_QueryClientButtonMouseEntered
        QueryClientButton.setIcon(QueryClient2);
    }//GEN-LAST:event_QueryClientButtonMouseEntered

    private void QueryClientButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_QueryClientButtonMouseExited
        QueryClientButton.setIcon(QueryClient);
    }//GEN-LAST:event_QueryClientButtonMouseExited

    private void SalesReportButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalesReportButtonMouseEntered
        SalesReportButton.setIcon(SalesReport2);
    }//GEN-LAST:event_SalesReportButtonMouseEntered

    private void SalesReportButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalesReportButtonMouseExited
        SalesReportButton.setIcon(SalesReport);
    }//GEN-LAST:event_SalesReportButtonMouseExited

    private void ClientReportButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClientReportButtonMouseExited
        ClientReportButton.setIcon(ClientReport);
    }//GEN-LAST:event_ClientReportButtonMouseExited

    private void ClientReportButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClientReportButtonMouseEntered
        ClientReportButton.setIcon(ClientReport2);
    }//GEN-LAST:event_ClientReportButtonMouseEntered

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
            java.util.logging.Logger.getLogger(AdministratorMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdministratorMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdministratorMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdministratorMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdministratorMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AddClientButton;
    private javax.swing.JLabel ClientReportButton;
    private javax.swing.JLabel CloseButton;
    private javax.swing.JLabel EditClientButton;
    private javax.swing.JLabel QueryClientButton;
    private javax.swing.JLabel SalesReportButton;
    private javax.swing.JLabel SalesSearchButton;
    private javax.swing.JLabel addUserButton;
    private javax.swing.JLabel bitButton;
    private javax.swing.JLabel dateBox;
    private javax.swing.JLabel editUserButton;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel newSaleButton;
    private javax.swing.JLabel queryUserButton;
    private javax.swing.JLabel salesMonthButton;
    private javax.swing.JLabel salesTodayButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        Thread ct = Thread.currentThread();
        while (ct == h1) {
            calcula();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}
