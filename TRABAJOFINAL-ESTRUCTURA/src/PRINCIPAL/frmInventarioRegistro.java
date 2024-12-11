/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package PRINCIPAL;

import Clases.Cola;
import Clases.Ingrediente;
import Clases.NodoIngrediente;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Danyphantom
 */
public class frmInventarioRegistro extends JInternalFrame {
    
    private frmInventarioRegistro inventarioRegistro; 
    private Cola colaIngredientes;
    private final double PRECIO_CHILE = 10.0;
    private final double PRECIO_AGUA = 5.0;
    private final double PRECIO_AZUCAR = 8.0;
    private final double PRECIO_SAL = 6.0;
    private final double PRECIO_ROMERO = 12.0;
    private final double PRECIO_PIMIENTA = 15.0;

    public frmInventarioRegistro(Cola colaIngredientes) {
        this.colaIngredientes = colaIngredientes;
        initComponents();
        configurarBotones();
        configurarTabla();
    }

    
    private void agregarIngrediente(String nombre, int cantidad, double precio) {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.addRow(new Object[]{nombre, cantidad, precio});  
    }

    private void configurarBotones() {
        jtbAddUno.addActionListener(e -> agregarIngrediente("chile", (int) jspUno.getValue(), calcularPrecio("chile", (int) jspUno.getValue())));
        jtbAddDos.addActionListener(e -> agregarIngrediente("agua", (int) jspDos.getValue(), calcularPrecio("agua", (int) jspDos.getValue())));
        jtbAddTres.addActionListener(e -> agregarIngrediente("azucar", (int) jspTres.getValue(), calcularPrecio("azucar", (int) jspTres.getValue())));
        jtbAddCuatro.addActionListener(e -> agregarIngrediente("sal", (int) jspCuatro.getValue(), calcularPrecio("sal", (int) jspCuatro.getValue())));
        jtbAddCinco.addActionListener(e -> agregarIngrediente("romero", (int) jspCinco.getValue(), calcularPrecio("romero", (int) jspCinco.getValue())));
        jtbAddSeis.addActionListener(e -> agregarIngrediente("pimienta", (int) jspSeis.getValue(), calcularPrecio("pimienta", (int) jspSeis.getValue())));
        jbtEliminar.addActionListener(e -> eliminarIngrediente());

        jbtRegresar.addActionListener(e -> {
            this.setVisible(false);
            this.dispose();
        });
        
        jbtAñadirInventario.addActionListener(e -> agregarATablaYCola());
        jbtBuscar.addActionListener(e -> buscarEnTabla());
    }

    private double calcularPrecio(String nombre, int cantidad) {
        switch (nombre.toLowerCase()) {
            case "chile":
                return cantidad * PRECIO_CHILE;
            case "agua":
                return cantidad * PRECIO_AGUA;
            case "azucar":
                return cantidad * PRECIO_AZUCAR;
            case "sal":
                return cantidad * PRECIO_SAL;
            case "romero":
                return cantidad * PRECIO_ROMERO;
            case "pimienta":
                return cantidad * PRECIO_PIMIENTA;
            default:
                return 0.0;
        }
    }

    private int buscarIngrediente(String nombre) {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        for (int i = 0; i < modelo.getRowCount(); i++) {
            if (modelo.getValueAt(i, 0).toString().equalsIgnoreCase(nombre)) {
                return i;
            }
        }
        return -1; 
    }

    private void buscarEnTabla() {
        String nombre = jtfBusqueda.getText().trim();
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese el nombre del ingrediente.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int fila = buscarIngrediente(nombre);
        if (fila != -1) {
            String nombreIngrediente = jTable1.getValueAt(fila, 0).toString(); 
            int cantidad = Integer.parseInt(jTable1.getValueAt(fila, 1).toString()); 
            double precio = Double.parseDouble(jTable1.getValueAt(fila, 2).toString()); 

           
            jblCantidadNeta.setText("" + cantidad);  
            jlbPrecioNeto.setText("" + String.format("%.2f", precio)); 

            
            System.out.println("Ingrediente encontrado: ");
            System.out.println("Nombre: " + nombreIngrediente);
            System.out.println("Cantidad: " + cantidad);
            System.out.println("Precio: " + String.format("%.2f", precio));

            JOptionPane.showMessageDialog(this, "Ingrediente encontrado: " + nombreIngrediente, "Búsqueda Exitosa", JOptionPane.INFORMATION_MESSAGE);
        } else {
            
            JOptionPane.showMessageDialog(this, "El ingrediente no se encuentra en la lista.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarIngrediente() {
        String nombre = jtfBusqueda.getText().trim();
        int fila = buscarIngrediente(nombre);
        if (fila != -1) {
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            modelo.removeRow(fila);
            JOptionPane.showMessageDialog(this, "Ingrediente eliminado correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "El ingrediente no se encuentra en la lista.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void configurarTabla() {
        DefaultTableModel modelo = new DefaultTableModel(new String[]{"Nombre", "Cantidad", "Precio"}, 0);
        jTable1.setModel(modelo);
    }

    private void agregarATablaYCola() {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();

        if (modelo.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "La tabla está vacía. Agregue ingredientes primero.");
            return;
        }

        for (int i = 0; i < modelo.getRowCount(); i++) {
            String nombre = modelo.getValueAt(i, 0).toString();
            int cantidad = Integer.parseInt(modelo.getValueAt(i, 1).toString());
            double precio = Double.parseDouble(modelo.getValueAt(i, 2).toString());

            String ID = "A" + nombre.substring(0, 3).toUpperCase() + (int) (Math.random() * 1000);
            String caducidad = "30 días"; 
            String categoria = "General"; 
            Ingrediente nuevoIngrediente = new Ingrediente(ID, nombre, cantidad, precio, caducidad, categoria);
 
            NodoIngrediente actual = colaIngredientes.frente;
            boolean encontrado = false;

            while (actual != null) {
                Ingrediente existente = actual.getValor();
                if (existente.getNombre().equalsIgnoreCase(nombre)) {
                    existente.setCantidad(existente.getCantidad() + cantidad);
                    encontrado = true;
                    break;
                }
                actual = actual.getSiguiente();
            }
            

            if (!encontrado) {
                colaIngredientes.agregar(nuevoIngrediente);
            }
            
        }

        JOptionPane.showMessageDialog(this, "Ingredientes añadidos correctamente al inventario.");
        for (NodoIngrediente actual = colaIngredientes.frente; actual != null; actual = actual.getSiguiente()) {
            System.out.println("Ingrediente en cola: " + actual.getValor().getNombre());
        }
        
        frmInventarioMostrar inventarioMostrar = new frmInventarioMostrar(colaIngredientes);
        inventarioMostrar.setVisible(true);
        this.dispose(); 
    }

        private void mostrarInventario() {
            frmInventarioMostrar inventarioMostrar = new frmInventarioMostrar(colaIngredientes);
            inventarioMostrar.setColaIngredientes(colaIngredientes); 
            inventarioMostrar.setVisible(true);
            this.setVisible(false); 
     }
   
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner3 = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        jplFondo = new javax.swing.JPanel();
        scpTable = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jbtBuscar = new javax.swing.JButton();
        jtfBusqueda = new javax.swing.JTextField();
        jbtEliminar = new javax.swing.JButton();
        jbtRegresar = new javax.swing.JButton();
        jblCantidadNeta = new javax.swing.JLabel();
        jlbPrecioNeto = new javax.swing.JLabel();
        jlbCantidad = new javax.swing.JLabel();
        jlbPrecio = new javax.swing.JLabel();
        jbtAñadirInventario = new javax.swing.JButton();
        scpIngredientes = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jspTres = new javax.swing.JSpinner();
        jtbAddCinco = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jtbAddDos = new javax.swing.JButton();
        jspDos = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jspCinco = new javax.swing.JSpinner();
        jspUno = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        jtbAddUno = new javax.swing.JButton();
        jtbAddSeis = new javax.swing.JButton();
        jtbAddCuatro = new javax.swing.JButton();
        jspSeis = new javax.swing.JSpinner();
        jspCuatro = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jtbAddTres = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/2.png"))); // NOI18N

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jplFondo.setBackground(new java.awt.Color(153, 255, 153));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Cantidad", "Precio"
            }
        ));
        scpTable.setViewportView(jTable1);

        jbtBuscar.setText("Buscar");

        jtfBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfBusquedaActionPerformed(evt);
            }
        });

        jbtEliminar.setText("Eliminar");

        jbtRegresar.setText("Regresar");

        jblCantidadNeta.setText("0");

        jlbPrecioNeto.setText("0.");

        jlbCantidad.setText("Cantidad");

        jlbPrecio.setText("Precio");

        jbtAñadirInventario.setText("Añadir ");
        jbtAñadirInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAñadirInventarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jplFondoLayout = new javax.swing.GroupLayout(jplFondo);
        jplFondo.setLayout(jplFondoLayout);
        jplFondoLayout.setHorizontalGroup(
            jplFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplFondoLayout.createSequentialGroup()
                .addGroup(jplFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jplFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jplFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jplFondoLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jbtBuscar))
                            .addGroup(jplFondoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scpTable, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jplFondoLayout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(jlbCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jblCantidadNeta, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jplFondoLayout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(jlbPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlbPrecioNeto, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jplFondoLayout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtfBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(68, 68, 68)))
                    .addGroup(jplFondoLayout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(jplFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtAñadirInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jplFondoLayout.createSequentialGroup()
                                .addComponent(jbtEliminar)
                                .addGap(68, 68, 68)
                                .addComponent(jbtRegresar)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jplFondoLayout.setVerticalGroup(
            jplFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scpTable, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jplFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtBuscar))
                .addGap(28, 28, 28)
                .addGroup(jplFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbCantidad)
                    .addComponent(jblCantidadNeta))
                .addGap(18, 18, 18)
                .addGroup(jplFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbPrecio)
                    .addComponent(jlbPrecioNeto))
                .addGap(34, 34, 34)
                .addGroup(jplFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtEliminar)
                    .addComponent(jbtRegresar))
                .addGap(36, 36, 36)
                .addComponent(jbtAñadirInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        scpIngredientes.setBackground(new java.awt.Color(255, 255, 51));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/2.png"))); // NOI18N

        jtbAddCinco.setText("Add");
        jtbAddCinco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbAddCincoActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/2.png"))); // NOI18N

        jtbAddDos.setText("Add");
        jtbAddDos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbAddDosActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/2.png"))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/2.png"))); // NOI18N

        jtbAddUno.setText("Add");
        jtbAddUno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbAddUnoActionPerformed(evt);
            }
        });

        jtbAddSeis.setText("Add");
        jtbAddSeis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbAddSeisActionPerformed(evt);
            }
        });

        jtbAddCuatro.setText("Add");
        jtbAddCuatro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbAddCuatroActionPerformed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/2.png"))); // NOI18N

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/2.png"))); // NOI18N

        jtbAddTres.setText("Add");
        jtbAddTres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbAddTresActionPerformed(evt);
            }
        });

        jLabel1.setText("Chile");

        jLabel2.setText("Agua");

        jLabel3.setText("Azucar");

        jLabel11.setText("Pimienta");

        jLabel12.setText("Sal");

        jLabel13.setText("Romero");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jspUno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jspDos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jtbAddTres, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jspCinco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jtbAddCinco, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jspSeis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)))
                        .addComponent(jtbAddSeis, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtbAddDos, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jspTres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(164, 164, 164)
                                .addComponent(jspCuatro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jtbAddCuatro, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jLabel6)
                                .addGap(42, 42, 42))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)))
                .addContainerGap(88, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(144, 144, 144))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(122, 122, 122))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(98, 98, 98)
                    .addComponent(jtbAddUno, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(319, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(301, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(135, 135, 135)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtbAddDos)
                            .addComponent(jspDos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jspUno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jspTres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtbAddCuatro)
                    .addComponent(jspCuatro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtbAddTres))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jspCinco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtbAddSeis)
                    .addComponent(jspSeis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtbAddCinco))
                .addGap(96, 96, 96))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(119, 119, 119)
                    .addComponent(jtbAddUno)
                    .addContainerGap(431, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(178, 178, 178)
                    .addComponent(jLabel12)
                    .addContainerGap(379, Short.MAX_VALUE)))
        );

        scpIngredientes.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scpIngredientes, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jplFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jplFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(scpIngredientes, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtbAddCincoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbAddCincoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbAddCincoActionPerformed

    private void jtbAddDosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbAddDosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbAddDosActionPerformed

    private void jtbAddUnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbAddUnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbAddUnoActionPerformed

    private void jtbAddSeisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbAddSeisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbAddSeisActionPerformed

    private void jtbAddCuatroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbAddCuatroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbAddCuatroActionPerformed

    private void jtbAddTresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbAddTresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbAddTresActionPerformed

    private void jtfBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfBusquedaActionPerformed

    private void jbtAñadirInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAñadirInventarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtAñadirInventarioActionPerformed

    /**
     * @param args the command line arguments
     */
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jblCantidadNeta;
    private javax.swing.JButton jbtAñadirInventario;
    private javax.swing.JButton jbtBuscar;
    private javax.swing.JButton jbtEliminar;
    private javax.swing.JButton jbtRegresar;
    private javax.swing.JLabel jlbCantidad;
    private javax.swing.JLabel jlbPrecio;
    private javax.swing.JLabel jlbPrecioNeto;
    private javax.swing.JPanel jplFondo;
    private javax.swing.JSpinner jspCinco;
    private javax.swing.JSpinner jspCuatro;
    private javax.swing.JSpinner jspDos;
    private javax.swing.JSpinner jspSeis;
    private javax.swing.JSpinner jspTres;
    private javax.swing.JSpinner jspUno;
    private javax.swing.JButton jtbAddCinco;
    private javax.swing.JButton jtbAddCuatro;
    private javax.swing.JButton jtbAddDos;
    private javax.swing.JButton jtbAddSeis;
    private javax.swing.JButton jtbAddTres;
    private javax.swing.JButton jtbAddUno;
    private javax.swing.JTextField jtfBusqueda;
    private javax.swing.JScrollPane scpIngredientes;
    private javax.swing.JScrollPane scpTable;
    // End of variables declaration//GEN-END:variables
}
