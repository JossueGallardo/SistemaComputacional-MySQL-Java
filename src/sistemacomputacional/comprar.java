/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package sistemacomputacional;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class comprar extends javax.swing.JPanel {

    /**
     * Creates new form comprar
     */
    public comprar() {
        initComponents();
        cargarCategorias();  
        cargarNombres();     
        cargarMarcas();
        nombreCB.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        cargarPrecio(); // Llama al método para actualizar el precio
    }
});
    }
    
    private void cargarCategorias() {
    try (Connection conexion = ConexionMySQL.conectar()) {
        String sql = "SELECT DISTINCT categoria FROM productos";
        try (PreparedStatement stmt = conexion.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            categoricaCB.removeAllItems(); // Limpiar elementos
            while (rs.next()) {
                categoricaCB.addItem(rs.getString("categoria"));
            }
        }
    } catch (SQLException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Error al cargar categorías: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
}

    private void cargarNombres() {
    try (Connection conexion = ConexionMySQL.conectar()) {
        String sql = "SELECT nombre FROM productos";
        try (PreparedStatement stmt = conexion.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            nombreCB.removeAllItems(); // Limpiar elementos
            while (rs.next()) {
                nombreCB.addItem(rs.getString("nombre"));
            }
        }
    } catch (SQLException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Error al cargar nombres de productos: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
}

    
    private void cargarMarcas() {
    try (Connection conexion = ConexionMySQL.conectar()) {
        String sql = "SELECT DISTINCT marca FROM productos";
        try (PreparedStatement stmt = conexion.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            marcaCB.removeAllItems(); // Limpiar elementos
            while (rs.next()) {
                marcaCB.addItem(rs.getString("marca"));
            }
        }
    } catch (SQLException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Error al cargar marcas: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
}
    
    private void cargarPrecio() {
    String nombreProducto = (String) nombreCB.getSelectedItem(); // Obtiene el producto seleccionado
    if (nombreProducto == null || nombreProducto.isEmpty()) {
        jTextField1.setText(""); // Limpia el campo si no hay selección
        return;
    }

    try (Connection conexion = ConexionMySQL.conectar()) {
        String sql = "SELECT precio FROM productos WHERE nombre = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, nombreProducto); // Asigna el nombre del producto
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    double precio = rs.getDouble("precio");
                    jTextField1.setText(String.valueOf(precio)); // Muestra el precio en el campo de texto
                } else {
                    jTextField1.setText(""); // Limpia el campo si no se encuentra el producto
                }
            }
        }
    } catch (SQLException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Error al cargar el precio: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
}



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblIngresoProductos = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nombreCB = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        categoricaCB = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        stockInicial = new javax.swing.JTextField();
        marcaCB = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIngresoProductos.setFont(new java.awt.Font("Ebrima", 0, 24)); // NOI18N
        lblIngresoProductos.setText("COMPRAR PRODUCTOS");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 255));

        jLabel1.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel1.setText("Nombre");

        jLabel2.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel2.setText("Marca");

        nombreCB.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        nombreCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        nombreCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreCBActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel3.setText("Categoría");

        categoricaCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel4.setText("Precio");

        jTextField1.setEditable(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel5.setText("Cantidad");

        stockInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockInicialActionPerformed(evt);
            }
        });

        marcaCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setBackground(new java.awt.Color(51, 51, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("AÑADIR AL CARRITO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 51, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("IR AL CARRITO");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(35, 35, 35)
                            .addComponent(categoricaCB, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(22, 22, 22)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nombreCB, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(marcaCB, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(stockInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addComponent(lblIngresoProductos))
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoricaCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nombreCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(marcaCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stockInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(58, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(114, 114, 114)
                    .addComponent(lblIngresoProductos)
                    .addGap(33, 33, 33)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(350, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 540));

        jPanel3.setBackground(new java.awt.Color(51, 51, 255));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/collage2.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(49, 49, 49))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(jLabel6)
                .addContainerGap(177, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 340, 540));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nombreCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreCBActionPerformed

    private void stockInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockInicialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stockInicialActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    carrito panelCarrito = new carrito();
    javax.swing.JFrame frame = new javax.swing.JFrame("Carrito");
    frame.setContentPane(panelCarrito);
    frame.setSize(600, 600);
    frame.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
    frame.setVisible(true);
    
      try (Connection conexion = ConexionMySQL.conectar()) {
        String sql = "SELECT p.nombre, c.cantidad, c.precio, (c.cantidad * c.precio) AS total " +
                     "FROM carrito c " +
                     "JOIN productos p ON c.producto_id = p.id";
        {     
        }
    } catch (SQLException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Error al cargar el carrito: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    String categoria = categoricaCB.getSelectedItem().toString();
    String nombre = nombreCB.getSelectedItem().toString();
    String marca = marcaCB.getSelectedItem().toString();
    int cantidad = Integer.parseInt(stockInicial.getText());
    double precio = Double.parseDouble(jTextField1.getText());

    try (Connection conexion = ConexionMySQL.conectar()) {
        String sql = "INSERT INTO carrito (producto_id, cantidad, precio) " +
                     "SELECT id, ?, ? FROM productos WHERE categoria = ? AND nombre = ? AND marca = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, cantidad);
            stmt.setDouble(2, precio);
            stmt.setString(3, categoria);
            stmt.setString(4, nombre);
            stmt.setString(5, marca);

            int filasAfectadas = stmt.executeUpdate();
            if (filasAfectadas > 0) {
                javax.swing.JOptionPane.showMessageDialog(this, "Producto añadido al carrito.", "Éxito", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Error al añadir el producto al carrito.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
    } catch (SQLException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> categoricaCB;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblIngresoProductos;
    private javax.swing.JComboBox<String> marcaCB;
    private javax.swing.JComboBox<String> nombreCB;
    private javax.swing.JTextField stockInicial;
    // End of variables declaration//GEN-END:variables
}
