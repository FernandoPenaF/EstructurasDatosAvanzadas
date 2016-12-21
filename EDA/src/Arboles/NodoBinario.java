/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arboles;

/**
 *
 * @author Fernando Peña
 */
public class NodoBinario <T extends Comparable <T>> {
    private T elemento;
    private NodoBinario <T> izquierdo, derecho;

    public NodoBinario(T dato){
        this.elemento = dato;
        this.izquierdo = null;
        this.derecho = null;
    }
    
    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public NodoBinario<T> getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoBinario<T> izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoBinario<T> getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoBinario<T> derecho) {
        this.derecho = derecho;
    }
    
    public void cuelga(NodoBinario <T> nodo){
        if(nodo == null)
            this.izquierdo = null;
        else
            if(nodo.getElemento().compareTo(this.elemento) < 0)
                this.izquierdo = nodo;
            else
                this.derecho = nodo;
    }
    
    public int numDescendentes(){
        int cont = 0;
        
        if(izquierdo != null)
            cont = 1 + izquierdo.numDescendentes();
        if(derecho != null)
            cont = 1 + derecho.numDescendentes();
        return cont;
    }
    
    public int getAltura(){
        if(izquierdo == null && derecho == null)
            return 0;
        int alturaIzquierda = 0, alturaDerecha = 0;
        if(izquierdo != null)
            alturaIzquierda = izquierdo.getAltura() + 1;
        if(derecho != null)
            alturaDerecha = derecho.getAltura() + 1;
        return Math.max(alturaIzquierda, alturaDerecha);
    }
}