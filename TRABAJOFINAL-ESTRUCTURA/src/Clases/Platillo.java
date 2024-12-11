/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Danyphantom
 */
public class Platillo {
    private String nombre;
    private String categoria;
    private double precio;
    private String horarioDisponible;
    private boolean estaEnStock;
    private String rutaImagen;

    public Platillo(String nombre, String categoria, double precio, String horarioDisponible, boolean estaEnStock, String rutaImagen) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.horarioDisponible = horarioDisponible;
        this.estaEnStock = estaEnStock;
        this.rutaImagen = rutaImagen;
        
    }

    public boolean isEstaEnStock() {
        return estaEnStock;
    }

    public void setEstaEnStock(boolean estaEnStock) {
        this.estaEnStock = estaEnStock;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getHorarioDisponible() {
        return horarioDisponible;
    }

    public void setHorarioDisponible(String horarioDisponible) {
        this.horarioDisponible = horarioDisponible;
    }
    
    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }
    
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Categoria: " + categoria + ", Precio: " + precio + ", HorarioDisponible: " + horarioDisponible + ", EstaEnStock: " + estaEnStock +", Imagen: " + rutaImagen;
    }      
}

