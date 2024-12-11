/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author karol
 */
public class ListaEnlazada {
     private Nodo cabeza; 

    public ListaEnlazada() {
        this.cabeza = null;
    }

    public Nodo getCabeza() {
        return cabeza;
    }

    
    public void agregar(Usuario usuario) {
    System.out.println("Agregando usuario: " + usuario.getUsuario());
    Nodo nuevoNodo = new Nodo(usuario);
    if (cabeza == null) {
        cabeza = nuevoNodo; 
    } else {
        Nodo actual = cabeza;
        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente(); 
        }
        actual.setSiguiente(nuevoNodo); 
    }
     System.out.println("Usuario agregado: " + usuario.getUsuario());

}

    
    public Usuario buscar(String usuario) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.getValor().getUsuario().equals(usuario)) {
                return actual.getValor(); 
            }
            actual = actual.getSiguiente();
        }
        return null; 
    }
    public void eliminar(String usuario) {
        if (cabeza == null) {
            return ; 
        }

        if (cabeza.getValor().getUsuario().equals(usuario)) {
            cabeza = cabeza.getSiguiente();
            return ; 
        }

        Nodo actual = cabeza;
        while (actual.getSiguiente() != null) {
            if (actual.getSiguiente().getValor().getUsuario().equals(usuario)) {
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                return ; 
            }
            actual = actual.getSiguiente();
        }
        
    }
    
    public boolean estaVacia() {
        return cabeza == null;
    }
    
}
