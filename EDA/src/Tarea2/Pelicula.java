/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea2;

import java.util.Objects;

/**
 *
 * @author Fernando Peña
 */
public class Pelicula implements Comparable{
    private int id;
    private int año;
    private String nombre;
    
    public Pelicula(int id, int año, String nombre){
        this.id = id;
        this.año = año;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public int getAño() {
        return año;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pelicula other = (Pelicula) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }
    
    public int compareTo(Object obj){
        Pelicula un = (Pelicula) obj;
        return nombre.compareTo(un.getNombre());
    }

    @Override
    public String toString() {
        return "Pelicula{" + "id=" + id + ", a\u00f1o=" + año + ", nombre=" + nombre + '}';
    }

}