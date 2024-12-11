/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases1;

/**
 *
 * @author karol
 */
public class Cola <T>{
    private Nodo<T> frente;
    private Nodo<T> fondo;

    public Cola() {
        this.frente = null;
        this.fondo = null;
    }

    public void encolar(T valor) {
        Nodo<T> nuevoNodo = new Nodo<>(valor);
        if (fondo != null) {
            fondo.setSiguiente(nuevoNodo);
        }
        fondo = nuevoNodo;
        if (frente == null) {
            frente = fondo;
        }
    }

    public T desencolar() {
        if (frente == null) {
            throw new IllegalStateException("La cola está vacía");
        }
        T valor = frente.getValor();
        frente = frente.getSiguiente();
        if (frente == null) {
            fondo = null;
        }
        return valor;
    }

    public boolean estaVacia() {
        return frente == null;
    }   
}
