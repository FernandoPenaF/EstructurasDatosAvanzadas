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
public class NodoAVL <T extends Comparable <T>>{
    private NodoAVL papa, izq, der;
    protected int fe;
    private T elem;
    
    public NodoAVL(T dato) {
        this.papa = this.der = this.izq = null;
        this.elem = dato;
        this.fe = 0;
    }
    
    public NodoAVL(T dato, NodoAVL <T> papa) {
        this(dato);
        this.papa = papa;
        this.fe = 0;
    }

    public NodoAVL getPapa() {
        return papa;
    }

    public void setPapa(NodoAVL papa) {
        this.papa = papa;
    }

    public int getFe() {
        return fe;
    }

    public void setFe(int fe) {
        this.fe = fe;
    }

    public NodoAVL getIzq() {
        return izq;
    }

    public NodoAVL getDer() {
        return der;
    }

    public void setIzq(NodoAVL izq) {
        this.izq = izq;
    }

    public void setDer(NodoAVL der) {
        this.der = der;
    }

    public T getElem() {
        return elem;
    }

    public void setElem(T elem) {
        this.elem = elem;
    }
    
    public int getAltura(){
        if(izq == null && der == null)
            return 0;
        int alturaIzquierda = 0, alturaDerecha = 0;
        if(izq != null)
            alturaIzquierda = izq.getAltura() + 1;
        if(der != null)
            alturaDerecha = der.getAltura() + 1;
        return Math.max(alturaIzquierda, alturaDerecha);
    }
    
    public void cuelga(NodoAVL <T> nodoAVL){
        if(nodoAVL == null)
            this.izq = null;
        else{
            if(nodoAVL.getElem().compareTo(this.getElem()) < 0)
                this.izq = nodoAVL;
            else
                this.der = nodoAVL;
            nodoAVL.setPapa(this);
        }
    }
    
}
