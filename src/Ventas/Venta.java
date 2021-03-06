package Ventas;

import Database.Conneccion;
import Principal.Principal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Venta extends javax.swing.JFrame {

    DefaultTableModel modelo;
    String nicknam;
    String busq = "nombre";
    int canti;
    int nVenta;
    float porcentaje = 0;

    public Venta() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        cveVenta();
        nVenta = Integer.parseInt(VENTA.getText());
        cargartabla("");
        carritoCompras(nVenta, "", "");
        lista.setVisible(false);
        left.setVisible(false);
        totales();
        tabla2.getColumnModel().getColumn(0).setMaxWidth(0);
//        AGREGAR.setText("Agregar");
    }

    public Venta(String nickname) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        cveVenta();
        nVenta = Integer.parseInt(VENTA.getText());
        cargartabla("");
        carritoCompras(nVenta, "", "");
        this.nicknam = nickname;
        USER.setText(nicknam);
        lista.setVisible(false);
        left.setVisible(false);
        totales();
        tabla2.getColumnModel().getColumn(0).setMaxWidth(0);
//        AGREGAR.setText("Agregar");
    }

    public void cargartabla(String valor) {
        String[] titulos = {"cveProducto", "Proveedor", "Nombre", "Descripcion", "Marca", "Medida", "Categoria", "Precio", "Total"};
        String[] registro = new String[9];
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
                registro[5] = rs.getString("medida");
                registro[6] = rs.getString("categoria");
                registro[7] = rs.getString("precioCompra");
                String descr = (String) descrip.getSelectedItem();
                descuentos(descr);
                registro[8] = "" + porcentaje;
                modelo.addRow(registro);
            }
            tabla.setModel(modelo);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void buscar() {
        busq = (String) lista.getSelectedItem();
    }

    public void carritoCompras(int valor, String clave, String precio) {
        String[] titulos = {"vent", "Cantidad", "cveProducto", "Nombre", "Descripcion", "Marca", "Precio Unitario", "Precio Total"};
        String[] registro = new String[8];
        modelo = new DefaultTableModel(null, titulos);
        Conneccion mysql = new Conneccion();
        Connection cn = mysql.conectar();

        String aSQL = "Select d.cveDetventa,p.cveProducto,nombre,descripcion, marca, precio, medida,categoria,cantidad "
                + "From Producto p inner join detventas d on p.cveProducto=d.cveProducto "
                + "Where d.cveVenta=" + VENTA.getText();
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(aSQL);
            while (rs.next()) {

                registro[0] = rs.getString("cveDetventa");
                registro[1] = rs.getString("cantidad");
                registro[2] = rs.getString("cveProducto");
                registro[3] = rs.getString("nombre");
                registro[4] = rs.getString("descripcion");
                registro[5] = rs.getString("marca");
                registro[6] = rs.getString("precio");
                float precio1 = rs.getInt("precio");
                float precio2 = rs.getInt("cantidad");
                float total = precio1 * precio2;
                registro[7] = "" + total;//PRECIO TOTAL
                modelo.addRow(registro);
            }
            tabla2.setModel(modelo);
            tabla2.getColumnModel().getColumn(0).setMaxWidth(0);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            tabla2.getColumnModel().getColumn(0).setMaxWidth(0);
        }
    }

    public void cveVenta() {
        Conneccion mysql = new Conneccion();
        Connection cn = mysql.conectar();
//        String aSQL = "SELECT cveVenta FROM Venta ";
        String aSQL = "SELECT MAX(cveVenta) FROM Venta";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(aSQL);
            while (rs.next()) {
                VENTA.setText(rs.getString("MAX(cveVenta)"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void insertDetVenta(String cveVenta, String cveProducto, String canti, String precio) {
        int fila = tabla.getSelectedRow();
        if (fila >= 0) {
            canti = Cantidad.getText();
            Conneccion mysql = new Conneccion();
            Connection cn = mysql.conectar();
            precio = tabla.getValueAt(fila, 8).toString();
            String aSQL = "INSERT INTO detventas (cveVenta,cveProducto,cantidad,precio)"
                    + "VALUES( ?, ?, ?,?)";
            try {
                PreparedStatement pst = cn.prepareStatement(aSQL);
                pst.setString(1, cveVenta);
                pst.setString(2, cveProducto);
                pst.setString(3, canti);
                pst.setString(4, precio);

                int n = pst.executeUpdate();
                if (n > 0) {
//                JOptionPane.showMessageDialog(null, "Los datos se guardaron Correctamente");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    public void numVenta() {
        Conneccion mysql = new Conneccion();
        Connection cn = mysql.conectar();
        String aSQL = "SELECT cveVenta FROM Venta ";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(aSQL);
            while (rs.next()) {
                VENTA.setText(rs.getString("cveVenta"));
//                categoria.addItem(rs.getString("nombreCategoria"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void borrarVenta(String clave) {
        int fila = tabla2.getSelectedRow();
        if (fila >= 0) {
            clave = tabla2.getValueAt(fila, 0).toString();
            Conneccion mysql = new Conneccion();
            Connection cn = mysql.conectar();
            String aSQL = "DELETE FROM detventas WHERE cveDetventa = '" + clave + "'";
            //DELETE FROM detventas WHERE `cveVenta` = 1 AND `cveProducto` = 1234 AND cantidad = 1 AND precio = 300.00;
            try {
                PreparedStatement pstm = cn.prepareStatement(aSQL);
                pstm.executeUpdate();
                pstm.close();
                JOptionPane.showMessageDialog(this, "Eliminacion Exitosa", "Eliminacion", 1);
                cargartabla("");
                carritoCompras(nVenta, "", "");
                tabla2.getColumnModel().getColumn(0).setMaxWidth(0);
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    public void totales() {
        Conneccion mysql = new Conneccion();
        Connection cn = mysql.conectar();
        String aSQL = "SELECT sum(precio) FROM detVentas WHERE cveVenta=" + VENTA.getText();
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(aSQL);
            while (rs.next()) {
                float sub = rs.getFloat("sum(precio)");
                SUBTOTAL.setText("" + sub);
                float t = (float) (sub * 0.16);
                float tt = t + sub;
                TOTAL.setText("" + tt);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void descuentos(String desc) {
        Conneccion mysql = new Conneccion();
        Connection cn = mysql.conectar();
        //String aSQL = "SELECT cveProducto,porcentaje,idPrecio,descripcion FROM detprecio WHERE descripcion='" + desc + "'";
        String aSQL = "Select dv.cveVenta, p.nombre,p.cveProducto,precio,dp.descripcion,dp.porcentaje "
                + "From detventas dv inner join producto p on dv.cveProducto=dv.cveProducto "
                + "inner join detprecio dp on p.cveProducto=dp.cveProducto "
                + "WHERE dp.descripcion='" + desc + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(aSQL);
            while (rs.next()) {
//                descrip.addItem(rs.getString("porcentaje"));
//                System.out.print("  " + rs.getString("nombre") + " ");
//                System.out.print("  " + rs.getInt("precio") + " ");
//                System.out.print("  " + rs.getInt("dp.porcentaje") + " ");
                float preci = rs.getFloat("precio");
                float porce = rs.getFloat("dp.porcentaje");
                float t1 = porce / 100;
                float t2 = t1 * preci;
                float total = t2 + preci;
                porcentaje = (float) total;
//                System.out.println("Total = " + total);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void cancelarCompra() {
        int cventa = nVenta;
        Conneccion mysql = new Conneccion();
        Connection cn = mysql.conectar();
        String aSQL = "DELETE FROM Venta WHERE cveVenta = '" + cventa + "'";
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

    public void finalizarCompra() {
        int clave = nVenta;
        String sub = SUBTOTAL.getText();
        String tot = TOTAL.getText();

        Conneccion mysql = new Conneccion();
        Connection cn = mysql.conectar();
        String aSQL = "UPDATE Venta SET "
                + "subtotal=?, "
                + "total=? "
                + "WHERE cveVenta = '" + clave + "'";

        try {
            PreparedStatement pst = cn.prepareStatement(aSQL);
            pst.setString(1, sub);
            pst.setString(2, tot);

            int n = pst.executeUpdate();

            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Modificacion Correcta");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void modificarVenta() {

        int fila = tabla2.getSelectedRow();
        if (fila >= 0) {
            try {
                int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad", "1"));

                String clave = tabla2.getValueAt(fila, 0).toString();
                String cventas = VENTA.getText();
                String cproducto = tabla2.getValueAt(fila, 2).toString();
                String precio = tabla2.getValueAt(fila, 7).toString();

                Conneccion mysql = new Conneccion();
                Connection cn = mysql.conectar();
                String aSQL = "UPDATE detventas "
                        + "SET cveDetVenta = ?,"
                        + "cveVenta = ?,"
                        + "cveProducto = ?,"
                        + "cantidad = ?,"
                        + "precio = ? "
                        + "WHERE cveDetVenta = " + clave;
                try {
                    PreparedStatement pst = cn.prepareStatement(aSQL);
                    pst.setString(1, clave);
                    pst.setString(2, cventas);
                    pst.setString(3, cproducto);
                    pst.setInt(4, cantidad);
                    pst.setString(5, precio);

                    int n = pst.executeUpdate();

                    if (n > 0) {
//                    JOptionPane.showMessageDialog(null, "Modificacion Correcta");
                        carritoCompras(nVenta, "", "");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Solo se permiten numeros");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un Producto");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FINALIZAR = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        VENTA = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        AGREGAR = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Cantidad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tabla2 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        CANCELAR = new javax.swing.JButton();
        MODIFICAR = new javax.swing.JButton();
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
        Calle4 = new javax.swing.JLabel();
        TOTAL = new javax.swing.JTextField();
        descrip = new javax.swing.JComboBox();
        FINALIZAR1 = new javax.swing.JButton();
        SUBTOTAL = new javax.swing.JTextField();
        Calle5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ventas");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        FINALIZAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cancelar.png"))); // NOI18N
        FINALIZAR.setText("Cancelar Compra");
        FINALIZAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FINALIZARActionPerformed(evt);
            }
        });
        getContentPane().add(FINALIZAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, -1, -1));

        jPanel7.setBackground(new java.awt.Color(102, 102, 102));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        VENTA.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        VENTA.setForeground(new java.awt.Color(255, 255, 255));
        jPanel7.add(VENTA, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 100, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Venta");
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 200, 40));

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel3.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 11, 622, 138));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        AGREGAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/agregar.png"))); // NOI18N
        AGREGAR.setText("Agregar");
        AGREGAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AGREGARActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cantidad");

        Cantidad.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        Cantidad.setText("1");
        Cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CantidadActionPerformed(evt);
            }
        });
        Cantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CantidadKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(AGREGAR))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1)
                        .addGap(8, 8, 8)
                        .addComponent(Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(AGREGAR))
        );

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(659, 11, 200, 138));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 870, 160));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("C A R R I T O  D E  V E N T A S");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 640, 30));

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane7.setViewportView(tabla2);

        jPanel5.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 11, 617, 158));

        jPanel6.setBackground(new java.awt.Color(102, 102, 102));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CANCELAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cancelar.png"))); // NOI18N
        CANCELAR.setText("Cancelar");
        CANCELAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CANCELARActionPerformed(evt);
            }
        });
        jPanel6.add(CANCELAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        MODIFICAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/actualizar.png"))); // NOI18N
        MODIFICAR.setText("Modificar");
        MODIFICAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MODIFICARActionPerformed(evt);
            }
        });
        jPanel6.add(MODIFICAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(662, 11, 200, 158));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 870, 180));

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
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

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 100));

        Calle4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Calle4.setForeground(new java.awt.Color(255, 255, 255));
        Calle4.setText("Total:");
        getContentPane().add(Calle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 570, -1, -1));

        TOTAL.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TOTAL.setText("0");
        getContentPane().add(TOTAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 570, 70, -1));

        descrip.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Precio a Mayoreo", "Precio a Publico en General", "Precio a Publico en General con descuento", "Precio a Menudeo", "Precio a Especial" }));
        descrip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descripActionPerformed(evt);
            }
        });
        getContentPane().add(descrip, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 290, -1));

        FINALIZAR1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/finalizar.png"))); // NOI18N
        FINALIZAR1.setText("Finalizar Compra");
        FINALIZAR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FINALIZAR1ActionPerformed(evt);
            }
        });
        getContentPane().add(FINALIZAR1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 560, -1, -1));

        SUBTOTAL.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        SUBTOTAL.setText("0");
        getContentPane().add(SUBTOTAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 540, 70, -1));

        Calle5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Calle5.setForeground(new java.awt.Color(255, 255, 255));
        Calle5.setText("subTotal:");
        getContentPane().add(Calle5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 540, -1, -1));

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 630));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/archivo.png"))); // NOI18N
        jMenu1.setText("Archivo");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/finalizar.png"))); // NOI18N
        jMenuItem1.setText("Salir");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AGREGARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AGREGARActionPerformed
        int fila = tabla.getSelectedRow();
        if (fila >= 0) {
            String cveVenta = VENTA.getText();
            String cveProducto = tabla.getValueAt(fila, 0).toString();
            String precio = tabla.getValueAt(fila, 8).toString();
            Cantidad.setEditable(true);
            String cantidad = Cantidad.getText();
            insertDetVenta(cveVenta, cveProducto, cantidad, precio);
            cargartabla("");
            carritoCompras(nVenta, "", "");
            totales();
        }
//        AGREGAR.setText("Agregar");
    }//GEN-LAST:event_AGREGARActionPerformed

    private void FINALIZARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FINALIZARActionPerformed
        cancelarCompra();
        Principal view = new Principal();
        view.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_FINALIZARActionPerformed

    private void CANCELARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CANCELARActionPerformed
//        int reply = JOptionPane.showConfirmDialog(this, "¿Desea Eliminar el Producto? ", "ELIMINAR", JOptionPane.YES_NO_OPTION);
//        if (reply == JOptionPane.YES_OPTION) {
//            JOptionPane.showMessageDialog(this,"NO TIENES EL PODER");
        int fila = tabla2.getSelectedRow();
        if (fila >= 0) {
            String clave = tabla2.getValueAt(fila, 0).toString();
            borrarVenta(clave);
            cargartabla("");
            carritoCompras(nVenta, "", "");
            totales();
//            }
        }
    }//GEN-LAST:event_CANCELARActionPerformed

    private void MODIFICARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MODIFICARActionPerformed
        modificarVenta();
    }//GEN-LAST:event_MODIFICARActionPerformed

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

    private void descripActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descripActionPerformed
        String descr = (String) descrip.getSelectedItem();
        descuentos(descr);
        String valor = BUSCAR.getText();
        cargartabla(valor);
    }//GEN-LAST:event_descripActionPerformed

    private void FINALIZAR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FINALIZAR1ActionPerformed
        finalizarCompra();

        Principal view = new Principal(nicknam);
        view.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_FINALIZAR1ActionPerformed

    private void CantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CantidadActionPerformed

    }//GEN-LAST:event_CantidadActionPerformed

    private void CantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CantidadKeyTyped
                char x = evt.getKeyChar();
        if (x > '0' && x > '9') {
            evt.consume();
        }
        if (Cantidad.getText().length() == 5) {
            evt.consume();
        }
    }//GEN-LAST:event_CantidadKeyTyped

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
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Venta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AGREGAR;
    private javax.swing.JTextField BUSCAR;
    private javax.swing.JButton CANCELAR;
    private javax.swing.JLabel Calle4;
    private javax.swing.JLabel Calle5;
    private javax.swing.JTextField Cantidad;
    private javax.swing.JButton FINALIZAR;
    private javax.swing.JButton FINALIZAR1;
    private javax.swing.JButton MODIFICAR;
    private javax.swing.JTextField SUBTOTAL;
    private javax.swing.JTextField TOTAL;
    private javax.swing.JLabel USER;
    private javax.swing.JLabel VENTA;
    private javax.swing.JComboBox descrip;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel left;
    private javax.swing.JComboBox lista;
    private javax.swing.JLabel right;
    private javax.swing.JTable tabla;
    private javax.swing.JTable tabla2;
    // End of variables declaration//GEN-END:variables
}
