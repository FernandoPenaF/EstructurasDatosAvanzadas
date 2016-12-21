/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursion;

/**
 *
 * @author Fernando Peña
 */
public class Nodo <T>{
    private T elemento;
    private Nodo <T> siguiente;
    
    public Nodo (T dato){
        this.elemento = dato;
        this.siguiente = null;
    }
    
    public Nodo(){
        this.elemento = null;
        this.siguiente = null;
    }

    public T getElemento() {
        return elemento;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    @Override
    public String toString() {
        return "Nodo{" + "elemento=" + elemento + ", siguiente=" + siguiente + '}';
    }
}
