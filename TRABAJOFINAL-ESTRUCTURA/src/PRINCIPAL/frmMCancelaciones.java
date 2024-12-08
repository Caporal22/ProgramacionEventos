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
 * @author preci
 */
public class frmMCancelaciones extends javax.swing.JInternalFrame {
    //private ListaEnlazada _________
     private DefaultTableModel modelo;
    /**
    /**
     * Creates new form frmMCancelaciones
     */
    public frmMCancelaciones() {
        initComponents();
        //acceso a la lista enlazada
        this.modelo = new DefaultTableModel();
        TablaCancelaciones.setModel(modelo);
        cargarDatos();
    }
    
    
    
    private void cargarDatos(){
        
        modelo.setRowCount(0);
        modelo.addColumn("Nombre");
        modelo.addColumn("Fecha");
        modelo.addColumn("Total");
        modelo.addColumn("Motivo");
        modelo.addColumn("No.Folio");
        
        
        //Nodo actual = __________.getCabeza();

//        while (actual != null) {
//            Usuario usuario = actual.getValor();
//            Horario horario = usuario.getHorario();
//            String turno = horario != null ? horario.getTurno() : "No definido"; // Manejo de null
//            String diaDescanso = horario != null ? horario.getDiaDescanso() : "No definido"; // Manejo de null
//            modelo.addRow(new Object[]{
//                usuario.getNombre(),
//                usuario.getTipo(),
//                turno,
//                diaDescanso,
//                usuario.getContraseña(),
//                "Comentario" 
//
//            });
//
//            actual = actual.getSiguiente();
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
        TablaCancelaciones = new javax.swing.JTable();
        jlbTitulo = new javax.swing.JLabel();
        jlbDescanso = new javax.swing.JTextField();
        jbnRegresar = new javax.swing.JButton();
        jlbBusqueda1 = new javax.swing.JLabel();
        jbnBuscar1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TablaCancelaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TablaCancelaciones);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 790, 350));

        jlbTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jlbTitulo.setText("Cancelaciones");
        getContentPane().add(jlbTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, -1, -1));

        jlbDescanso.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jlbDescanso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jlbDescansoActionPerformed(evt);
            }
        });
        getContentPane().add(jlbDescanso, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 110, -1));

        jbnRegresar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbnRegresar.setText("Regresar");
        jbnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbnRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(jbnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 450, 110, 30));

        jlbBusqueda1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlbBusqueda1.setText("No. Folio");
        getContentPane().add(jlbBusqueda1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        jbnBuscar1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbnBuscar1.setText("Buscar");
        jbnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbnBuscar1ActionPerformed(evt);
            }
        });
        getContentPane().add(jbnBuscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 110, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jlbDescansoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jlbDescansoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jlbDescansoActionPerformed

    private void jbnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbnRegresarActionPerformed
       
    }//GEN-LAST:event_jbnRegresarActionPerformed

    private void jbnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbnBuscar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbnBuscar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaCancelaciones;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbnBuscar1;
    private javax.swing.JButton jbnRegresar;
    private javax.swing.JLabel jlbBusqueda1;
    private javax.swing.JTextField jlbDescanso;
    private javax.swing.JLabel jlbTitulo;
    // End of variables declaration//GEN-END:variables
}
