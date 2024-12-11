/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.Serializable;

/**
 *
 * @author Danyphantom
 */

public class NodoIngrediente implements Serializable{
    private Ingrediente valor; 
    private NodoIngrediente siguiente; 
    public NodoIngrediente(Ingrediente valor) {
        this.valor = valor;
        this.siguiente = null;
    }

    public Ingrediente getValor() {
        return valor;
    }

    public void setValor(Ingrediente valor) {
        this.valor = valor;
    }

    public NodoIngrediente getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoIngrediente siguiente) {
        this.siguiente = siguiente;
    }
}

