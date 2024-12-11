/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package PRINCIPAL;

import Clases.Cola;
import Clases.Ingrediente;
import Clases.NodoIngrediente;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JInternalFrame;



/**
 *
 * @author Danyphantom
 */

public class frmInventarioMostrar extends JInternalFrame {

    private frmInventarioRegistro ventanaRegistro;
    private Cola colaIngredientes;
    
    
    
    
    public frmInventarioMostrar(Cola colaIngredientes) {
        this.colaIngredientes = colaIngredientes;
        initComponents();
        configurarTabla();
        configurarBotones();
        mostrarIngredientesEnTabla(); 
        
        if (colaIngredientes == null || colaIngredientes.estaVacia()) {
            System.out.println("La cola está vacía al mostrar inventario.");
        } else {
            setColaIngredientes(colaIngredientes);
        }
    }
   
    
    private void configurarTabla() {
        DefaultTableModel modelo = new DefaultTableModel(
            new String[]{"ID", "Nombre", "Cantidad", "Precio", "Caducidad", "Categoría"}, 
            0
        );
        jTableInventario.setModel(modelo);

        if (jTableInventario.getModel() == null) {
            System.out.println("Error: No se pudo asignar el modelo a la tabla.");
        } else {
            System.out.println("Modelo de tabla configurado correctamente.");
        }
    }


    private void configurarBotones() {
        jbtRegresar.addActionListener(e -> {
        frmInventarioRegistro ventanaRegistro = new frmInventarioRegistro(colaIngredientes);
        ventanaRegistro.setVisible(true);
        this.dispose();
    });

        jbtBuscar.addActionListener(e -> buscarEnTabla());
    }


    public void setColaIngredientes(Cola cola) {
        DefaultTableModel modelo = (DefaultTableModel) jTableInventario.getModel();

        NodoIngrediente actual = cola.frente; 

        while (actual != null) {
            Ingrediente ingrediente = actual.getValor();  
            boolean encontrado = false;

           
            for (int i = 0; i < modelo.getRowCount(); i++) {
                if (modelo.getValueAt(i, 0).toString().equals(ingrediente.getID())) {
                    int cantidadActual = Integer.parseInt(modelo.getValueAt(i, 2).toString());
                    modelo.setValueAt(cantidadActual + ingrediente.getCantidad(), i, 2); 
                    encontrado = true;
                    break;
                }
            }

            //aqui es para cuadno añadimos un nuevo ingrediente a la tabla
            if (!encontrado) {
                modelo.addRow(new Object[]{
                    ingrediente.getID(),
                    ingrediente.getNombre(),
                    ingrediente.getCantidad(),
                    ingrediente.getPrecio(),
                    ingrediente.getCaducidad(),
                    ingrediente.getCategoria()
                });
            }

           
            actual = actual.getSiguiente();
        }
    }
    
    private int buscarIngrediente(String ID) {
        DefaultTableModel modelo = (DefaultTableModel) jTableInventario.getModel();
        for (int i = 0; i < modelo.getRowCount(); i++) {
            if (modelo.getValueAt(i, 0).toString().equalsIgnoreCase(ID)) {
                return i;
            }
        }
        return -1; 
    }
    
    private void buscarEnTabla() {
        String ID = jtfIngrediente.getText().trim();  
        if (ID.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese el ID del ingrediente.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        
        int fila = buscarIngrediente(ID);
        if (fila != -1) {
            
            String IDIngrediente = jTableInventario.getValueAt(fila, 0).toString();
            String nombreIngrediente = jTableInventario.getValueAt(fila, 1).toString();
            int cantidad = Integer.parseInt(jTableInventario.getValueAt(fila, 2).toString());
            String caducidad = jTableInventario.getValueAt(fila, 3).toString();
            String categoria = jTableInventario.getValueAt(fila, 4).toString();
            jlbCantidadNeta.setText("" + cantidad);
            JOptionPane.showMessageDialog(this,
                "Ingrediente encontrado:\n" +
                "ID: " + IDIngrediente + "\n" +
                "Nombre: " + nombreIngrediente + "\n" +
                "Cantidad: " + cantidad + "\n" +
                "Caducidad: " + caducidad + "\n" +
                "Categoría: " + categoria,
                "Búsqueda Exitosa",
                JOptionPane.INFORMATION_MESSAGE
                    
            );
        } else {
            
            JOptionPane.showMessageDialog(this, "El ingrediente no se encuentra en la lista.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
   
    private void mostrarIngredientesEnTabla() {
        DefaultTableModel modelo = (DefaultTableModel) jTableInventario.getModel();
        modelo.setRowCount(0); // Limpia la tabla antes de llenarla

        if (colaIngredientes == null || colaIngredientes.estaVacia()) {
            System.out.println("La cola está vacía o no está inicializada.");
            return;
        }

        NodoIngrediente actual = colaIngredientes.frente;

        
        while (actual != null) {
            Ingrediente ingrediente = actual.getValor();

            if (ingrediente != null) {
                modelo.addRow(new Object[]{
                    ingrediente.getID(),         
                    ingrediente.getNombre(),    
                    ingrediente.getCantidad(),   
                    ingrediente.getPrecio(),   
                    ingrediente.getCaducidad(),  
                    ingrediente.getCategoria()   
                });
                System.out.println("Agregado a la tabla: " + ingrediente.getNombre());
            }

            actual = actual.getSiguiente(); 
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableInventario = new javax.swing.JTable();
        jlbIngrediente = new javax.swing.JLabel();
        jlbCantidad = new javax.swing.JLabel();
        jtfIngrediente = new javax.swing.JTextField();
        jlbCantidadNeta = new javax.swing.JLabel();
        jbtBuscar = new javax.swing.JButton();
        jbtRegresar = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jTableInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Cantidad", "Caducidad", "Categoria"
            }
        ));
        jScrollPane1.setViewportView(jTableInventario);

        jlbIngrediente.setText("Ingrediente");

        jlbCantidad.setText("Cantidad");

        jlbCantidadNeta.setText("0");

        jbtBuscar.setText("Buscar");
        jbtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtBuscarActionPerformed(evt);
            }
        });

        jbtRegresar.setText("Regresar");
        jbtRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbCantidadNeta, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtfIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(jbtBuscar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 838, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(442, 442, 442)
                        .addComponent(jbtRegresar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbIngrediente)
                    .addComponent(jtfIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtBuscar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbCantidadNeta))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jbtRegresar)
                .addGap(0, 24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtBuscarActionPerformed

    private void jbtRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtRegresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtRegresarActionPerformed

    /**
     * @param args the command line arguments
     */
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableInventario;
    private javax.swing.JButton jbtBuscar;
    private javax.swing.JButton jbtRegresar;
    private javax.swing.JLabel jlbCantidad;
    private javax.swing.JLabel jlbCantidadNeta;
    private javax.swing.JLabel jlbIngrediente;
    private javax.swing.JTextField jtfIngrediente;
    // End of variables declaration//GEN-END:variables
}
