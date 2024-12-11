/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Danyphantom
 */
public class Almacen {
 private Ingrediente[] inventarioIngredientes;
    private Platillo[] platillos;

    public Almacen(int capacidad) {
        inventarioIngredientes = new Ingrediente[capacidad];
        platillos = new Platillo[capacidad];
    }

    public void agregarIngrediente(Ingrediente ingrediente) {
        for (int i = 0; i < inventarioIngredientes.length; i++) {
            if (inventarioIngredientes[i] == null) {
                inventarioIngredientes[i] = ingrediente;
                break;
            }
        }
    }

    public void agregarPlatillo(Platillo platillo) {
        for (int i = 0; i < platillos.length; i++) {
            if (platillos[i] == null) {
                platillos[i] = platillo;
                break;
            }
        }
    }

    public Ingrediente[] getInventarioIngredientes() {
        return inventarioIngredientes;
    }

    public Platillo[] getPlatillos() {
        return platillos;
    }

    // Método para guardar los datos en un archivo
    public void guardarDatos() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("almacen.dat"))) {
            out.writeObject(inventarioIngredientes);
            out.writeObject(platillos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para cargar los datos desde un archivo
    public void cargarDatos() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("almacen.dat"))) {
            inventarioIngredientes = (Ingrediente[]) in.readObject();
            platillos = (Platillo[]) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }   
}
