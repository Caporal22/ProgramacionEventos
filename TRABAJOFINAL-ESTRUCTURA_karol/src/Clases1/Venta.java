/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases1;

public class Venta {
    private String nombreEmpleado;
    private String tipoEmpleado;
    private String turno;
    private String comentarios;
    private Double total;
    private String motivo;

    public Venta(String nombreEmpleado, String tipoEmpleado, String turno, String comentarios, Double total, String motivo) {
        this.nombreEmpleado = nombreEmpleado;
        this.tipoEmpleado = tipoEmpleado;
        this.turno = turno;
        this.comentarios = comentarios;
        this.total = total;
        this.motivo = motivo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public String getTipoEmpleado() {
        return tipoEmpleado;
    }

    public String getTurno() {
        return turno;
    }

    public String getComentarios() {
        return comentarios;
    }

    public Double getTotal() {
        return total;
    }

    public int getFolio() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
