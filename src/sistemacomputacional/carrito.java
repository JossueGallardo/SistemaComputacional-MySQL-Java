/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package sistemacomputacional;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class carrito extends javax.swing.JPanel {

    /**
     * Creates new form carrito
     */
    public carrito() {
        initComponents();
        cargarTablaCarrito();
    }

    private void calcularTotal() {
    double total = 0;
    for (int i = 0; i < jTable1.getRowCount(); i++) {
        total += Double.parseDouble(jTable1.getValueAt(i, 3).toString());
    }
    jTextField1.setText(String.valueOf(total));
}
    private void cargarTablaCarrito() {
    try (Connection conexion = ConexionMySQL.conectar()) {
        String sql = "SELECT p.nombre, c.cantidad, c.precio, (c.cantidad * c.precio) AS total " +
                     "FROM carrito c " +
                     "JOIN productos p ON c.producto_id = p.id";
        try (PreparedStatement stmt = conexion.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0); // Limpiar tabla

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("nombre"),
                    rs.getInt("cantidad"),
                    rs.getDouble("precio"),
                    rs.getDouble("total")
                });
            }

            calcularTotal(); // Actualizar el total después de llenar la tabla
        }
    } catch (SQLException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Error al cargar el carrito: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
}




    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cantidad", "Precio", "Total" // Columnas correctas
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false // Ninguna columna editable
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 590, 220));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 350, 160, -1));

        jLabel1.setText("Total a pagar");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 350, -1, -1));

        jButton1.setBackground(new java.awt.Color(255, 153, 153));
        jButton1.setText("ELIMINAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, -1, 30));

        jButton2.setBackground(new java.awt.Color(51, 51, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Finalizar compra");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 430, -1, -1));

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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try (Connection conexion = ConexionMySQL.conectar()) {
        conexion.setAutoCommit(false); // Habilitar transacciones

        // Registrar la compra en el historial
        String insertHistorialSql = "INSERT INTO historial_compras (producto_id, cantidad, precio, total, fecha_compra) " +
                                    "SELECT c.producto_id, c.cantidad, c.precio, (c.cantidad * c.precio), NOW() FROM carrito c";
        try (PreparedStatement stmt = conexion.prepareStatement(insertHistorialSql)) {
            int filasInsertadas = stmt.executeUpdate();
            if (filasInsertadas == 0) {
                conexion.rollback();
                javax.swing.JOptionPane.showMessageDialog(this, "No se pudo registrar el historial de compras.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        // Actualizar el stock de los productos
        String updateStockSql = "UPDATE productos p " +
                                "JOIN carrito c ON p.id = c.producto_id " +
                                "SET p.stock = p.stock - c.cantidad";
        try (PreparedStatement stmt = conexion.prepareStatement(updateStockSql)) {
            stmt.executeUpdate();
        }

        // Limpiar el carrito
        String clearCarritoSql = "DELETE FROM carrito";
        try (PreparedStatement stmt = conexion.prepareStatement(clearCarritoSql)) {
            stmt.executeUpdate();
        }

        conexion.commit(); // Confirmar transacción
        javax.swing.JOptionPane.showMessageDialog(this, "Compra finalizada con éxito.", "Éxito", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        cargarTablaCarrito(); // Recargar la tabla
    } catch (SQLException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Error al finalizar la compra: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    int selectedRow = jTable1.getSelectedRow(); // Obtiene la fila seleccionada

    if (selectedRow == -1) {
        javax.swing.JOptionPane.showMessageDialog(this, "Seleccione un producto para eliminar.", "Advertencia", javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Obtiene los datos necesarios de la fila seleccionada
    String nombreProducto = jTable1.getValueAt(selectedRow, 0).toString();
    int cantidad = Integer.parseInt(jTable1.getValueAt(selectedRow, 1).toString());

    try (Connection conexion = ConexionMySQL.conectar()) {
        // Verifica si el producto existe en el carrito antes de eliminar
        String verifySql = "SELECT COUNT(*) AS total FROM carrito WHERE producto_id = (SELECT id FROM productos WHERE nombre = ?) AND cantidad = ?";
        try (PreparedStatement verifyStmt = conexion.prepareStatement(verifySql)) {
            verifyStmt.setString(1, nombreProducto);
            verifyStmt.setInt(2, cantidad);
            ResultSet rs = verifyStmt.executeQuery();
            if (rs.next() && rs.getInt("total") == 0) {
                javax.swing.JOptionPane.showMessageDialog(this, "El producto no se encuentra en el carrito.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        // Eliminar el producto del carrito
        String sql = "DELETE FROM carrito WHERE producto_id = (SELECT id FROM productos WHERE nombre = ?) AND cantidad = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, nombreProducto);
            stmt.setInt(2, cantidad);
            int filasAfectadas = stmt.executeUpdate();

            if (filasAfectadas > 0) {
                javax.swing.JOptionPane.showMessageDialog(this, "Producto eliminado del carrito.", "Éxito", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                cargarTablaCarrito(); // Recargar la tabla y calcular el total nuevamente
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "No se pudo eliminar el producto.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
    } catch (SQLException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Error al eliminar el producto: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
