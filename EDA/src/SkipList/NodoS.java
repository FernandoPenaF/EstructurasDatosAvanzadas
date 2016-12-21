/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SkipList;

import java.util.Objects;

/**
 *
 * @author Fernando Peña
 */
public class NodoS <T>{
    private T elemento;
    private NodoS izquierdo;
    private NodoS derecho;
    private NodoS arriba;
    private NodoS abajo;

    public NodoS() {
        this.elemento = null;
        this.izquierdo = null;
        this.derecho = null;
        this.arriba = null;
        this.abajo = null;
    }

    public NodoS(T elemento) {
        this.elemento = elemento;
        this.izquierdo = null;
        this.derecho = null;
        this.arriba = null;
        this.abajo = null;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public NodoS getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoS izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoS getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoS derecho) {
        this.derecho = derecho;
    }

    public NodoS getArriba() {
        return arriba;
    }

    public void setArriba(NodoS arriba) {
        this.arriba = arriba;
    }

    public NodoS getAbajo() {
        return abajo;
    }

    public void setAbajo(NodoS abajo) {
        this.abajo = abajo;
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
        final NodoS<?> other = (NodoS<?>) obj;
        if (!Objects.equals(this.elemento, other.elemento)) {
            return false;
        }
        return true;
    }
    
    public void agregaDerecha(NodoS <T> agregar){
        NodoS <T> izq = this.getDerecho();
        
        this.setDerecho(agregar);
        agregar.setIzquierdo(this);
        agregar.setDerecho(izq);
        if(izq != null)
            izq.setIzquierdo(agregar);
    }
    
    public void agregaIzquierda(NodoS <T> agregar){
        NodoS <T> der = this.getIzquierdo();
        
        this.setIzquierdo(agregar);
        agregar.setDerecho(this);
        agregar.setIzquierdo(der);
        if(der != null)
            der.setDerecho(agregar);
    }
    
    public void colapsa(){
        colapsa(this);
    }
    
    private void colapsa(NodoS <T> actual){
        if(actual != null){
            if(actual.getIzquierdo() != null)
                actual.getIzquierdo().setDerecho(actual.getDerecho());
            if(actual.getDerecho() != null)
                actual.getDerecho().setIzquierdo(actual.getIzquierdo());
            actual.setIzquierdo(null);
            actual.setDerecho(null);
            colapsa(actual.getArriba());
        }
    }
    
    public void quitaArriba(){
        if(this.getArriba() != null){
            this.getArriba().setAbajo(null);
            this.setAbajo(null);
        }
    }
}
