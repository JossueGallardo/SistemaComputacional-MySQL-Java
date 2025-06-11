/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package sistemacomputacional;

import java.sql.*;

public class crear extends javax.swing.JPanel {

    /**
     * Creates new form crear
     */
    public crear() {
        initComponents();
    }

    // Método para agregar filas a la tabla
    private void agregarProductoATabla(String nombre, String marca, String categoria, String precio, String stock) {
    javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTable1.getModel();
    model.addRow(new Object[]{nombre, marca, categoria, precio, stock});
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nombreProducto = new javax.swing.JTextField();
        marcaCB = new javax.swing.JComboBox<>();
        guardarProducto = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        stockInicial = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        categoriaCB = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(450, 540));
        setRequestFocusEnabled(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(234, 234, 234));

        lblIngresoProductos.setFont(new java.awt.Font("Ebrima", 0, 24)); // NOI18N
        lblIngresoProductos.setText("INGRESO DE PRODUCTOS");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 255));

        jLabel1.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel1.setText("Nombre");

        jLabel2.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel2.setText("Marca");

        jLabel3.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel3.setText("Categoría");

        jLabel4.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel4.setText("Precio");

        nombreProducto.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        nombreProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreProductoActionPerformed(evt);
            }
        });

        marcaCB.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        marcaCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HP", "Dell", "Apple", "Lenovo", "ASUS", "Acer", "Samsung", "Toshiba", "Nvidia", "Intel", "Ryzen", " " }));
        marcaCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marcaCBActionPerformed(evt);
            }
        });

        guardarProducto.setBackground(new java.awt.Color(51, 51, 255));
        guardarProducto.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        guardarProducto.setForeground(new java.awt.Color(255, 255, 255));
        guardarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar-el-archivo (2).png"))); // NOI18N
        guardarProducto.setText("GUARDAR");
        guardarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarProductoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel5.setText("Stock Inicial");

        stockInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockInicialActionPerformed(evt);
            }
        });

        categoriaCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laptops", "Desktops", "Monitores", "Impresoras", "Accesorios", "Almacenamiento", "Software", "Smartphones", "Graficas", "Procesadores " }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lblIngresoProductos))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(categoriaCB, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(marcaCB, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(guardarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(stockInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(15, 15, 15))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblIngresoProductos)
                .addGap(33, 33, 33)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(marcaCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(categoriaCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(stockInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(guardarProducto)
                .addContainerGap(122, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 530));

        jPanel3.setBackground(new java.awt.Color(51, 51, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][] {}, // Sin datos iniciales
            new String[] { // Encabezados de las columnas
                "Nombre", "Marca", "Categoría", "Precio", "Stock"
            }
        ) {
            boolean[] canEdit = new boolean[] {
                false, false, false, false, false // Todas las columnas no son editables
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex]; // Configuración para desactivar edición
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(109, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 310, 530));

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

    private void nombreProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreProductoActionPerformed

    private void marcaCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marcaCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_marcaCBActionPerformed

    private void stockInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockInicialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stockInicialActionPerformed

    private void guardarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarProductoActionPerformed
    String nombre = nombreProducto.getText();
    String marca = (String) marcaCB.getSelectedItem();
    String categoria = (String) categoriaCB.getSelectedItem();
    String precio = jTextField1.getText();
    String stock = stockInicial.getText();

    // Validar campos
    if (nombre.isEmpty() || marca.isEmpty() || categoria.isEmpty() || precio.isEmpty() || stock.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        return;
    }

    try (Connection conexion = ConexionMySQL.conectar()) {
        String sql = "INSERT INTO productos (nombre, marca, categoria, precio, stock) VALUES (?, ?, ?, ?, ?)";
        try (java.sql.PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setString(2, marca);
            stmt.setString(3, categoria);
            stmt.setDouble(4, Double.parseDouble(precio));
            stmt.setInt(5, Integer.parseInt(stock));
            int filasInsertadas = stmt.executeUpdate();
            if (filasInsertadas > 0) {
                javax.swing.JOptionPane.showMessageDialog(this, "Producto guardado correctamente.", "Éxito", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                // Agregar el producto a la tabla
                agregarProductoATabla(nombre, marca, categoria, precio, stock);
                limpiarCampos();
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "No se pudo guardar el producto.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
    } catch (SQLException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Error al guardar el producto: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    } catch (NumberFormatException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "El precio y el stock deben ser valores numéricos.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
}

// Método para limpiar campos después de guardar
private void limpiarCampos() {
    nombreProducto.setText("");
    categoriaCB.setSelectedIndex(0);
    marcaCB.setSelectedIndex(0);
    jTextField1.setText("");
    stockInicial.setText("");    

    
    }//GEN-LAST:event_guardarProductoActionPerformed

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
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> categoriaCB;
    private javax.swing.JButton guardarProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblIngresoProductos;
    private javax.swing.JComboBox<String> marcaCB;
    private javax.swing.JTextField nombreProducto;
    private javax.swing.JTextField stockInicial;
    // End of variables declaration//GEN-END:variables
}
