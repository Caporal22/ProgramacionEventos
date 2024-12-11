/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Danyphantom
 */
public class ColaPlatillo {
    private NodoPlatillo frente;
    private NodoPlatillo fin;

    public ColaPlatillo() {
        this.frente = null;
        this.fin = null;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public void agregar(Platillo platillo) {
        NodoPlatillo nuevoNodo = new NodoPlatillo(platillo);
        if (estaVacia()) {
            frente = nuevoNodo;
            fin = nuevoNodo;
        } else {
            fin.setSiguiente(nuevoNodo);
            fin = nuevoNodo;
        }
    }

    public void mostrarElementos() {
        if (estaVacia()) {
            System.out.println("La cola está vacía.");
            return;
        }

        NodoPlatillo actual = frente;
        while (actual != null) {
            System.out.println(actual.getPlatillo().toString());
            actual = actual.getSiguiente();
        }
    }

    public Platillo eliminar() {
        if (estaVacia()) {
            System.out.println("La cola está vacía. No se puede eliminar.");
            return null;
        }

        Platillo eliminado = frente.getPlatillo();
        frente = frente.getSiguiente();
        if (frente == null) {
            fin = null;
        }
        return eliminado;
    }
    
     public NodoPlatillo getFrente() {
        return frente;
    }

    public void setFrente(NodoPlatillo nodo) {
        this.frente = nodo;
    }

    public NodoPlatillo getFin() {
        return fin;
    }

    public void setFin(NodoPlatillo nodo) {
        this.fin = nodo;
    }
}







