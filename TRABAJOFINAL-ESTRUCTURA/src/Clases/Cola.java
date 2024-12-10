/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Clases;

public class Cola {
    public NodoIngrediente frente;
    private NodoIngrediente fin;
    private int tamaño;

    public Cola() {
        this.frente = null;
        this.fin = null;
        this.tamaño = 0;
    }

    public void agregar(Ingrediente ingrediente) {
        NodoIngrediente nuevoNodo = new NodoIngrediente(ingrediente);
        if (estaVacia()) {
            frente = nuevoNodo;
        } else {
            fin.setSiguiente(nuevoNodo);
        }
        fin = nuevoNodo;
        tamaño++;
    }

   
    
    public Ingrediente quitar() {
        if (estaVacia()) {
            return null;
        }
        Ingrediente valor = frente.getValor();
        frente = frente.getSiguiente();
        if (frente == null) {
            fin = null;
        }
        tamaño--;
        return valor;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void mostrarElementos() {
        NodoIngrediente actual = frente;
        while (actual != null) {
            System.out.println(actual.getValor().toString());
            actual = actual.getSiguiente();
        }
    }
}




