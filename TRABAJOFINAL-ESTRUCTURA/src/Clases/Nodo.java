/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.Serializable;

/**
 *
 * @author karol
 */
public class Nodo implements Serializable {
    private Usuario valor; // Almacena el usuario
    private Nodo siguiente; // Referencia al siguiente nodo

    public Nodo(Usuario valor) {
        this.valor = valor;
        this.siguiente = null;
    }

    public Usuario getValor() {
        return valor;
    }

    public void setValor(Usuario valor) {
        this.valor = valor;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
}
