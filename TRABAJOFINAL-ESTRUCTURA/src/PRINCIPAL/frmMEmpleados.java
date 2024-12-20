/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package PRINCIPAL;
import Clases.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author karol
 */
public class frmMEmpleados extends javax.swing.JInternalFrame {
    private ListaEnlazada listaUsuarios;
    private DefaultTableModel modelo;
    /**
     * Creates new form frmMEmpleados
     */
    public frmMEmpleados(ListaEnlazada listaUsuarios) {
        initComponents();
        this.listaUsuarios = listaUsuarios;
        this.modelo = new DefaultTableModel();
        TablaEmpleados.setModel(modelo);
        cargarDatos();
               
    }

    private void cargarDatos(){
        
        modelo.setRowCount(0);
        modelo.addColumn("Nombre");
        modelo.addColumn("Tipo de empleado");
        modelo.addColumn("Turno");
        modelo.addColumn("Día de descanso");
        modelo.addColumn("Contraseña");
        modelo.addColumn("Comentario");
        
        Nodo actual = listaUsuarios.getCabeza();

        while (actual != null) {
            Usuario usuario = actual.getValor();
            Horario horario = usuario.getHorario();
            String turno = horario != null ? horario.getTurno() : "No definido"; // Manejo de null
            String diaDescanso = horario != null ? horario.getDiaDescanso() : "No definido"; // Manejo de null
            modelo.addRow(new Object[]{
                usuario.getNombre(),
                usuario.getTipo(),
                turno,
                diaDescanso,
                usuario.getContraseña(),
                "Comentario" 

            });

            actual = actual.getSiguiente();

        }

    }
    
    private void filtrarPorTipo() {

       String tipoSeleccionado = (String) jcbTipo.getSelectedItem();
    modelo.setRowCount(0); 

    Nodo actual = listaUsuarios.getCabeza();

    while (actual != null) {
        Usuario usuario = actual.getValor();
        Horario horario = usuario.getHorario();
        String turno = horario != null ? horario.getTurno() : "No definido"; 
        String diaDescanso = horario != null ? horario.getDiaDescanso() : "No definido"; 
        // Filtra según el tipod de empleados seleccionado
        if (tipoSeleccionado.equals("Todos") || usuario.getTipo().equals(tipoSeleccionado)) {
            modelo.addRow(new Object[]{
                usuario.getNombre(),
                usuario.getTipo(),
                turno,
                diaDescanso,
                usuario.getContraseña(),
                "Comentario" 
            });
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

        jbnActualizar = new javax.swing.JButton();
        jbnEliminar = new javax.swing.JButton();
        jlbBusqueda = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaEmpleados = new javax.swing.JTable();
        jcbTipo = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jbnActualizar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jbnActualizar.setText("Actualizar");
        jbnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbnActualizarActionPerformed(evt);
            }
        });

        jbnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jbnEliminar.setText("Eliminar");
        jbnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbnEliminarActionPerformed(evt);
            }
        });

        jlbBusqueda.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlbBusqueda.setText("Busqueda");

        TablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TablaEmpleados);

        jcbTipo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jcbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mesero", "Cocinero", "Bartender" }));
        jcbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTipoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jbnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(jlbBusqueda)
                        .addGap(106, 106, 106)
                        .addComponent(jcbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(162, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbBusqueda)
                    .addComponent(jcbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbnActualizarActionPerformed
       int filaSeleccionada = TablaEmpleados.getSelectedRow();

        if (filaSeleccionada != -1) {
            String nombre = (String) modelo.getValueAt(filaSeleccionada, 0);
            String tipo = (String) modelo.getValueAt(filaSeleccionada, 1);
            String turno = (String) modelo.getValueAt(filaSeleccionada, 2);
            String diaDescanso = (String) modelo.getValueAt(filaSeleccionada, 3);
            String contraseña = (String) modelo.getValueAt(filaSeleccionada, 4);
            String comentario = (String) modelo.getValueAt(filaSeleccionada, 5);
            JOptionPane.showMessageDialog(this, "Actualizar datos de: " + nombre);
        } else {

            JOptionPane.showMessageDialog(this, "Seleccione un empleado para actualizar.");
        }
    }//GEN-LAST:event_jbnActualizarActionPerformed

    private void jbnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbnEliminarActionPerformed
    int filaSeleccionada = TablaEmpleados.getSelectedRow();

        if (filaSeleccionada != -1) {
            String nombre = (String) modelo.getValueAt(filaSeleccionada, 0);
            int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea eliminar a " + nombre + "?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                listaUsuarios.eliminar(nombre); 
                modelo.removeRow(filaSeleccionada);
                JOptionPane.showMessageDialog(this, "Empleado eliminado correctamente.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un empleado para eliminar.");
        }
    }//GEN-LAST:event_jbnEliminarActionPerformed

    private void jcbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTipoActionPerformed
        filtrarPorTipo();
    }//GEN-LAST:event_jcbTipoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaEmpleados;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbnActualizar;
    private javax.swing.JButton jbnEliminar;
    private javax.swing.JComboBox<String> jcbTipo;
    private javax.swing.JLabel jlbBusqueda;
    // End of variables declaration//GEN-END:variables
}
