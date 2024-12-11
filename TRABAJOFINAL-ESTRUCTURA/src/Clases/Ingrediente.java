package Clases;

import java.io.Serializable;

public class Ingrediente implements Serializable {
    private String nombre;
    private int cantidad;
    private double precio;
    private String categoria;
    private String ID;
    private String caducidad;

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(String caducidad) {
        this.caducidad = caducidad;
    }

    public Ingrediente(String ID, String nombre, int cantidad, double precio, String caducidad, String categoria) {
        this.ID = ID; // Asigna el ID correctamente
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.caducidad = caducidad;
        this.categoria = categoria;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    @Override
    public String toString() {
        return "ID: " + ID + ", Nombre: " + nombre + ", Cantidad: " + cantidad + ", Precio: " + precio + ", Caducidad: " + caducidad + ", Categoría: " + categoria;
    }
    
}
