/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases1;
import Clases.*;
/**
 *
 * @author karol
 */
public class Ordenes {
    private  String totalCuenta;
    private Usuario usuario;
    private boolean isActiva;
    private int Folio;
     private String motivo;

    
    public Ordenes(String totalCuenta, Usuario usuario, boolean isActiva, int Folio) {
        this.totalCuenta = totalCuenta;
        this.usuario = usuario;
        this.isActiva = isActiva;
        this.Folio = Folio;
         
    }

   

    public String getTotalCuenta() {
        return totalCuenta;
    }

    public void setTotalCuenta(String totalCuenta) {
        this.totalCuenta = totalCuenta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isIsActiva() {
        return isActiva;
    }

    public void setIsActiva(boolean isActiva) {
        this.isActiva = isActiva;
    }

    public int getFolio() {
        return Folio;
    }

    public void setFolio(int Folio) {
        this.Folio = Folio;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    
    
    
    
}
