/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Productos;

import Database.Conneccion;
import Principal.ScreenAddUser;
import Principal.agregarCategoria;
import Principal.agregarMedidas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author SWO
 */
public class modificarProducto extends javax.swing.JFrame {

    String clave, prov, nombre, descripci, marcaa, precioo, volumen, cat;
    String nicknam="";

    //nombre, marca,precio, volumen, sku,descripcio,,clave
    public modificarProducto(String clav, String pro, String nombr, String descripcio, String marc, String preci, String volume, String ca) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.clave = clav;
        this.prov = pro;
        this.nombre = nombr;
        this.descripci = descripcio;
        this.marcaa = marc;
        this.precioo = preci;
        this.volumen = volume;
        this.cat = ca;
        categoria();
        unidadMed();
        llenarDatos();
        precioC1.setEnabled(false);
        precioC2.setEnabled(false);
        precioC3.setEnabled(false);
        precioC4.setEnabled(false);
        precioC5.setEnabled(false);
        
        porcentajes1(clav, "1");
        porcentajes2(clav, "2");
        porcentajes3(clav, "3");
        porcentajes4(clav, "4");
        porcentajes5(clav, "5");
    }

    public modificarProducto() {
        initComponents();
        this.setLocationRelativeTo(null);
        categoria();
        unidadMed();
        llenarDatos();
        precioC1.setEnabled(false);
        precioC2.setEnabled(false);
        precioC3.setEnabled(false);
        precioC4.setEnabled(false);
        precioC5.setEnabled(false);
        porcentajes1("", "");
        porcentajes2("", "");
        porcentajes3("", "");
        porcentajes4("", "");
        porcentajes5("", "");
    }

    public void porcentajes1(String clav, String id) {
        Conneccion mysql = new Conneccion();
        Connection cn = mysql.conectar();
        String aSQL = "SELECT cveProducto, porcentaje,idPrecio FROM detprecio "
                + "WHERE cveProducto = '" + clav + "' && idPrecio='" + id + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(aSQL);
            while (rs.next()) {
                precioC1.setText(rs.getString("porcentaje"));
            }
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void porcentajes2(String clav, String id) {
        Conneccion mysql = new Conneccion();
        Connection cn = mysql.conectar();
                String aSQL = "SELECT cveProducto, porcentaje,idPrecio FROM detprecio "
                + "WHERE cveProducto = '" + clav + "' && idPrecio='" + id + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(aSQL);
            while (rs.next()) {
                precioC2.setText(rs.getString("porcentaje"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void porcentajes3(String clav, String id) {
        Conneccion mysql = new Conneccion();
        Connection cn = mysql.conectar();
        String aSQL = "SELECT cveProducto, porcentaje,idPrecio FROM detprecio "
                + "WHERE cveProducto = '" + clav + "' && idPrecio='" + id + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(aSQL);
            while (rs.next()) {
                precioC3.setText(rs.getString("porcentaje"));
            }
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void porcentajes4(String clav, String id) {
        Conneccion mysql = new Conneccion();
        Connection cn = mysql.conectar();
        String aSQL = "SELECT cveProducto, porcentaje,idPrecio FROM detprecio "
                + "WHERE cveProducto = '" + clav + "' && idPrecio='" + id + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(aSQL);
            while (rs.next()) {
                precioC4.setText(rs.getString("porcentaje"));
            }
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void porcentajes5(String clav, String id) {
        Conneccion mysql = new Conneccion();
        Connection cn = mysql.conectar();
        String aSQL = "SELECT cveProducto, porcentaje,idPrecio FROM detprecio "
                + "WHERE cveProducto = '" + clav + "' && idPrecio='" + id + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(aSQL);
            while (rs.next()) {
                precioC5.setText(rs.getString("porcentaje"));
            }
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void llenarDatos() {
        Cla.setText(clave);
        nom.setText(nombre);
        descripcion.setText(descripci);
        mar.setText(marcaa);
        precio.setText(precioo);
        volmedida.setSelectedItem(volumen);
        categoria.setSelectedItem(cat);
        Sku.setText(prov);
    }

    public void modificar(String clave) {
        Conneccion mysql = new Conneccion();
        Connection cn = mysql.conectar();
        String aSQL = "UPDATE producto SET "
                + "cveProducto=?,"
                + "cveProveedor=?,"
                + "nombre=?,"
                + "descripcion=?, "
                + "marca=?, "
                + "precioCompra=?, "
                + "medida=?,"
                + "categoria=?"
                + "WHERE cveProducto = '" + clave+"'";
        String claves = Cla.getText();
        String skus = Sku.getText();
        String nombres = nom.getText();
        String descripcions = descripcion.getText();
        String mars = mar.getText();
        String precios = precio.getText();
        String volmedidas = (String) volmedida.getSelectedItem();
        String categorias = (String) categoria.getSelectedItem();

        try {
            PreparedStatement pst = cn.prepareStatement(aSQL);
            pst.setString(1, claves);
            pst.setString(2, skus);
            pst.setString(3, nombres);
            pst.setString(4, descripcions);
            pst.setString(5, mars);
            pst.setString(6, precios);
            pst.setString(7, volmedidas);
            pst.setString(8, categorias);

            int n = pst.executeUpdate();

            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Modificacion Correcta");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void modificarPorcentaje(String clave, String porcentaje, String id, String descripcion) {
        Conneccion mysql = new Conneccion();
        Connection cn = mysql.conectar();
        String aSQL = "UPDATE detprecio SET "
                + "cveProducto=?, "
                + "porcentaje=?, "
                + "idPrecio=?, "
                + "descripcion=? "
                + "WHERE cveProducto = '" + clave+"' && idPrecio = '" + id+"'";
        try {
            PreparedStatement pst = cn.prepareStatement(aSQL);
            pst.setString(1, clave);
            pst.setString(2, porcentaje);
            pst.setString(3, id);
            pst.setString(4, descripcion);

            int n = pst.executeUpdate();

            if (n > 0) {
//                JOptionPane.showMessageDialog(null, "Modificacion Correcta");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void categoria() {
        Conneccion mysql = new Conneccion();
        Connection cn = mysql.conectar();
        String aSQL = "SELECT nombreCategoria FROM Categoria ";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(aSQL);
            while (rs.next()) {
                categoria.addItem(rs.getString("nombreCategoria"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void unidadMed() {
        Conneccion mysql = new Conneccion();
        Connection cn = mysql.conectar();
        String aSQL = "SELECT tipoMedida FROM medidaproducto ";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(aSQL);
            while (rs.next()) {
                volmedida.addItem(rs.getString("tipoMedida"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void checks() {
        if (precio1.isSelected() == true) {
            precioC1.setEnabled(true);
        } else {
            precioC1.setEnabled(false);
        }
        if (precio2.isSelected() == true) {
            precioC2.setEnabled(true);
        } else {
            precioC2.setEnabled(false);
        }
        if (precio3.isSelected() == true) {
            precioC3.setEnabled(true);
        } else {
            precioC3.setEnabled(false);
        }
        if (precio4.isSelected() == true) {
            precioC4.setEnabled(true);
        } else {
            precioC4.setEnabled(false);
        }
        if (precio5.isSelected() == true) {
            precioC5.setEnabled(true);
        } else {
            precioC5.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Cla = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        mar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        descripcion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        volmedida = new javax.swing.JComboBox();
        precio = new javax.swing.JTextField();
        categoria = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Sku = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        nom = new javax.swing.JTextField();
        precio1 = new javax.swing.JCheckBox();
        precio2 = new javax.swing.JCheckBox();
        precio3 = new javax.swing.JCheckBox();
        precio4 = new javax.swing.JCheckBox();
        precio5 = new javax.swing.JCheckBox();
        precioC1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        precioC2 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        precioC3 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        precioC4 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        precioC5 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        MODIFICAR = new javax.swing.JButton();
        CANCELAR = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Modificar Producto");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        Cla.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Cla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClaActionPerformed(evt);
            }
        });
        Cla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ClaKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Clave:");

        mar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marActionPerformed(evt);
            }
        });
        mar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                marKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Marca:");

        descripcion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        descripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descripcionActionPerformed(evt);
            }
        });
        descripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                descripcionKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Descripción:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Precio:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Unidad de medida:");

        volmedida.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        volmedida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volmedidaActionPerformed(evt);
            }
        });

        precio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        precio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precioActionPerformed(evt);
            }
        });

        categoria.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoriaActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Categoria:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("SKUProveedor:");

        Sku.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Sku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SkuActionPerformed(evt);
            }
        });
        Sku.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SkuKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Nombre:");

        nom.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomActionPerformed(evt);
            }
        });
        nom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nomKeyTyped(evt);
            }
        });

        precio1.setForeground(new java.awt.Color(255, 255, 255));
        precio1.setText("Mayoreo");
        precio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precio1ActionPerformed(evt);
            }
        });

        precio2.setForeground(new java.awt.Color(255, 255, 255));
        precio2.setText("Publico General");
        precio2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precio2ActionPerformed(evt);
            }
        });

        precio3.setForeground(new java.awt.Color(255, 255, 255));
        precio3.setText("Descuento");
        precio3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precio3ActionPerformed(evt);
            }
        });

        precio4.setForeground(new java.awt.Color(255, 255, 255));
        precio4.setText("Menudeo");
        precio4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precio4ActionPerformed(evt);
            }
        });

        precio5.setForeground(new java.awt.Color(255, 255, 255));
        precio5.setText("Especial");
        precio5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precio5ActionPerformed(evt);
            }
        });

        precioC1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        precioC1.setText("0");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("%");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("%");

        precioC2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        precioC2.setText("0");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("%");

        precioC3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        precioC3.setText("0");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("%");

        precioC4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        precioC4.setText("0");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("%");

        precioC5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        precioC5.setText("0");

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MODIFICAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/actualizar.png"))); // NOI18N
        MODIFICAR.setText("Modificar");
        MODIFICAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MODIFICARActionPerformed(evt);
            }
        });
        jPanel2.add(MODIFICAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        CANCELAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cancelar.png"))); // NOI18N
        CANCELAR.setText("Cancelar");
        CANCELAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CANCELARActionPerformed(evt);
            }
        });
        jPanel2.add(CANCELAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Cla, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mar, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(volmedida, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Sku, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(precio1)
                .addGap(10, 10, 10)
                .addComponent(precio2)
                .addGap(10, 10, 10)
                .addComponent(precio3)
                .addGap(10, 10, 10)
                .addComponent(precio4)
                .addGap(10, 10, 10)
                .addComponent(precio5))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(precioC1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(precioC2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel2)
                .addGap(21, 21, 21)
                .addComponent(precioC3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel12)
                .addGap(20, 20, 20)
                .addComponent(precioC4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(precioC5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel14))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volmedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Sku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(precio1)
                    .addComponent(precio2)
                    .addComponent(precio3)
                    .addComponent(precio4)
                    .addComponent(precio5))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(precioC1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(precioC2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(precioC3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(precioC4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(precioC5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 480, 530));

        jPanel3.setBackground(new java.awt.Color(255, 73, 72));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Modificar Producto");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(243, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addContainerGap())
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 60));

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

    private void CANCELARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CANCELARActionPerformed
        int reply = JOptionPane.showConfirmDialog(this, "¿Desea cancelar? ", "CANCELAR", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            Producto p = new Producto();
            p.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_CANCELARActionPerformed

    private void MODIFICARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MODIFICARActionPerformed
        String cla = Cla.getText();
        modificar(cla);
        String precio1 = precioC1.getText();
        String precio2 = precioC2.getText();
        String precio3 = precioC3.getText();
        String precio4 = precioC4.getText();
        String precio5 = precioC5.getText();
        String descrip1 = "Precio a Mayoreo";
        String descrip2 = "Precio a Publico en General";
        String descrip3 = "Precio a Publico en General con descuento";
        String descrip4 = "Precio a Menudeo";
        String descrip5 = "Precio a Especial";

        modificarPorcentaje(cla, precio1, "1", descrip1);
        modificarPorcentaje(cla, precio2, "2", descrip2);
        modificarPorcentaje(cla, precio3, "3", descrip3);
        modificarPorcentaje(cla, precio4, "4", descrip4);
        modificarPorcentaje(cla, precio5, "5", descrip5);

        Producto p = new Producto();
        p.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MODIFICARActionPerformed

    private void ClaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClaActionPerformed
        Cla.transferFocus();
    }//GEN-LAST:event_ClaActionPerformed

    private void ClaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ClaKeyTyped
        char x = evt.getKeyChar();

        if (x > '0' && x > '9') {
            evt.consume();
        }

        if (Cla.getText().length() == 11) {
            evt.consume();
        }
    }//GEN-LAST:event_ClaKeyTyped

    private void marActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marActionPerformed
        mar.transferFocus();
    }//GEN-LAST:event_marActionPerformed

    private void marKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_marKeyTyped
        if (mar.getText().length() == 18) {
            evt.consume();
        }
    }//GEN-LAST:event_marKeyTyped

    private void descripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descripcionActionPerformed
        descripcion.transferFocus();
    }//GEN-LAST:event_descripcionActionPerformed

    private void descripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descripcionKeyTyped
        if (descripcion.getText().length() == 35) {
            evt.consume();
        }
    }//GEN-LAST:event_descripcionKeyTyped

    private void volmedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volmedidaActionPerformed
        volmedida.transferFocus();
    }//GEN-LAST:event_volmedidaActionPerformed

    private void precioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precioActionPerformed
        precio.transferFocus();
    }//GEN-LAST:event_precioActionPerformed

    private void categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoriaActionPerformed

    private void SkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SkuActionPerformed
        Sku.transferFocus();
    }//GEN-LAST:event_SkuActionPerformed

    private void SkuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SkuKeyTyped
        if (Sku.getText().length() == 18) {
            evt.consume();
        }
    }//GEN-LAST:event_SkuKeyTyped

    private void nomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomActionPerformed

    private void nomKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_nomKeyTyped

    private void precio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precio1ActionPerformed
        checks();
    }//GEN-LAST:event_precio1ActionPerformed

    private void precio2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precio2ActionPerformed
        checks();
    }//GEN-LAST:event_precio2ActionPerformed

    private void precio3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precio3ActionPerformed
        checks();
    }//GEN-LAST:event_precio3ActionPerformed

    private void precio4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precio4ActionPerformed
        checks();
    }//GEN-LAST:event_precio4ActionPerformed

    private void precio5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precio5ActionPerformed
        checks();
    }//GEN-LAST:event_precio5ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        ScreenAddUser su = new ScreenAddUser();
        su.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        agregarCategoria view=new agregarCategoria();
        view.setVisible(true);
        //        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        agregarMedidas view=new agregarMedidas();
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
            java.util.logging.Logger.getLogger(modificarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(modificarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(modificarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(modificarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new modificarProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CANCELAR;
    private javax.swing.JTextField Cla;
    private javax.swing.JButton MODIFICAR;
    private javax.swing.JTextField Sku;
    private javax.swing.JComboBox categoria;
    private javax.swing.JTextField descripcion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField mar;
    private javax.swing.JTextField nom;
    private javax.swing.JTextField precio;
    private javax.swing.JCheckBox precio1;
    private javax.swing.JCheckBox precio2;
    private javax.swing.JCheckBox precio3;
    private javax.swing.JCheckBox precio4;
    private javax.swing.JCheckBox precio5;
    private javax.swing.JTextField precioC1;
    private javax.swing.JTextField precioC2;
    private javax.swing.JTextField precioC3;
    private javax.swing.JTextField precioC4;
    private javax.swing.JTextField precioC5;
    private javax.swing.JComboBox volmedida;
    // End of variables declaration//GEN-END:variables
}
