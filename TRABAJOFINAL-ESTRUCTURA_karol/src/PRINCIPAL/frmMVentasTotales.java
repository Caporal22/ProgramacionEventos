/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package PRINCIPAL;
import Clases1.Cola;
import Clases1.DatosCompartidos;
import Clases1.Ordenes;
import Clases1.Venta;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Clases.*;
/**
 *
 * @author preci
 */
public class frmMVentasTotales extends javax.swing.JInternalFrame {
        private DefaultTableModel modelo;
        public static String nombreMesero; 
         public static String horarioMesero;
         
    /**
     * Creates new form frmMVentasTotales
     */
    public frmMVentasTotales() {
        initComponents();
        configurarTabla();
        cargarDatos();
         
    }
    
    
    private void cargarDatos() {
    modelo.setRowCount(0); // Limpiar la tabla

    try {
        Cola<Venta> tempCola = new Cola<>();

        while (!DatosCompartidos.ventasTotales.estaVacia()) {
            Venta venta = DatosCompartidos.ventasTotales.desencolar(); // Desencolar la venta actual

            // Obtener datos del empleado y la venta
            
            

            // Agregar los datos a la tabla
            modelo.addRow(new Object[]{
                frmInicio.nombreMesero,  // Nombre del empleado
                frmInicio.horarioMesero,           // Turno del empleado
                venta.getFolio(), // Número de folio
                venta.getMotivo() // Comentarios de la venta
            });

            tempCola.encolar(venta); // Guardar la venta en la cola temporal
        }

        // Restaurar los datos en la cola original
        while (!tempCola.estaVacia()) {
            DatosCompartidos.ventasTotales.encolar(tempCola.desencolar());
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al procesar una venta: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
}

    
    private void configurarTabla() {
        // Configurar las columnas de la tabla
        modelo = new DefaultTableModel();
        modelo.addColumn("Nombre del Empleado");
        modelo.addColumn("Turno");
        modelo.addColumn("Folio");
        modelo.addColumn("Comentarios");
        TablaVentas.setModel(modelo);
    }
    
   

private void buscarPorFolio(String folioStr) {
    if (folioStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, ingresa un folio.");
        return;
    }

    try {
        int folio = Integer.parseInt(folioStr);
        boolean encontrado = false;

        DefaultTableModel modelo = (DefaultTableModel) TablaVentas.getModel(); // Reemplaza jtTablaVentas con el nombre de tu tabla
        modelo.setRowCount(0); // Limpiar la tabla antes de mostrar los resultados

        Cola<Venta> tempCola = new Cola<>();

        // Iterar sobre la cola para buscar el folio
        while (!DatosCompartidos.ventasTotales.estaVacia()) {
            Venta venta = DatosCompartidos.ventasTotales.desencolar();

            if (venta.getFolio() == folio) {
                // Si se encuentra el folio, agregar la venta a la tabla
                modelo.addRow(new Object[]{
                    venta.getNombreEmpleado(),
                    venta.getTipoEmpleado(),
                    venta.getTurno(),
                    venta.getFolio(),
                    venta.getComentarios()
                });
                encontrado = true;
            }

            // Almacenar la venta en la cola temporal para restaurar los datos más tarde
            tempCola.encolar(venta);
        }

        // Restaurar los datos originales en la cola
        while (!tempCola.estaVacia()) {
            DatosCompartidos.ventasTotales.encolar(tempCola.desencolar());
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(this, "No se encontró ninguna venta con el folio ingresado.");
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Por favor, ingresa un número válido para el folio.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}


   

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaVentas = new javax.swing.JTable();
        jlbTitulo = new javax.swing.JLabel();
        jlbFolio = new javax.swing.JTextField();
        jbnRegresar = new javax.swing.JButton();
        jlbBusqueda1 = new javax.swing.JLabel();
        jbncerrar = new javax.swing.JButton();

        jbnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbnBuscar.setText("Buscar");
        jbnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbnBuscarActionPerformed(evt);
            }
        });

        TablaVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TablaVentas);

        jlbTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jlbTitulo.setText("Ventas Totales");

        jlbFolio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jlbFolio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jlbFolioActionPerformed(evt);
            }
        });

        jbnRegresar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbnRegresar.setText("Regresar");
        jbnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbnRegresarActionPerformed(evt);
            }
        });

        jlbBusqueda1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlbBusqueda1.setText("No. Folio");

        jbncerrar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbncerrar.setText("Cerras sesion");
        jbncerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbncerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jlbBusqueda1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(276, Short.MAX_VALUE)
                .addComponent(jbncerrar)
                .addGap(112, 112, 112)
                .addComponent(jbnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(270, 270, 270))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jlbFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jbnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(10, 10, 10)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(350, 350, 350)
                            .addComponent(jlbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jlbBusqueda1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 339, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbncerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 4, Short.MAX_VALUE)
                    .addComponent(jlbTitulo)
                    .addGap(8, 8, 8)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addComponent(jlbFolio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(9, 9, 9)
                            .addComponent(jbnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 71, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbnBuscarActionPerformed
                buscarPorFolio(jlbFolio.getText().trim());

    }//GEN-LAST:event_jbnBuscarActionPerformed

    private void jlbFolioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jlbFolioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jlbFolioActionPerformed

    private void jbnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbnRegresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbnRegresarActionPerformed

    private void jbncerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbncerrarActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "¿Desea cerrar la sesión?", "Cerrar Sesión", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0); // Cerrar el sistema
        }
    }//GEN-LAST:event_jbncerrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaVentas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbnBuscar;
    private javax.swing.JButton jbnRegresar;
    private javax.swing.JButton jbncerrar;
    private javax.swing.JLabel jlbBusqueda1;
    private javax.swing.JTextField jlbFolio;
    private javax.swing.JLabel jlbTitulo;
    // End of variables declaration//GEN-END:variables
}