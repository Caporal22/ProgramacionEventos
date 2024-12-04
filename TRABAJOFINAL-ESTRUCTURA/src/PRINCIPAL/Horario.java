/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PRINCIPAL;

/**
 *
 * @author karol
 */
public class Horario {
    private int id;
    private String horaEntrada;
    private String horaSalida;
    private String horaDescanso;
    private String diaDescanso;

    public Horario(int id, String horaEntrada, String horaSalida, String horaDescanso, String diaDescanso) {
        this.id = id;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.horaDescanso = horaDescanso;
        this.diaDescanso = diaDescanso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getHoraDescanso() {
        return horaDescanso;
    }

    public void setHoraDescanso(String horaDescanso) {
        this.horaDescanso = horaDescanso;
    }

    public String getDiaDescanso() {
        return diaDescanso;
    }

    public void setDiaDescanso(String diaDescanso) {
        this.diaDescanso = diaDescanso;
    }
    
    
    
    
}
