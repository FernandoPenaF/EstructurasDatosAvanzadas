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
public class LinkedBinarySearchTree <T extends Comparable<T>> extends LinkedBinaryTree<T> implements BinarySearchTreeADT<T>{

    public LinkedBinarySearchTree() {
        super();
    }
    
    public LinkedBinarySearchTree(T dato) {
        super(dato);
    }
    
    @Override
    public void add(T dato) {
        if(this.total == 0)
            this.raiz = new NodoBinario <>(dato);
        else
            add(this.raiz, dato);
        this.total++;
    }
    
    private NodoBinario <T> add(NodoBinario <T> actual, T dato){
        if(actual == null)
            return new NodoBinario <>(dato);
        if(dato.compareTo(actual.getElemento()) < 0)
            actual.setIzquierdo(add(actual.getIzquierdo(), dato));
        else
            actual.setDerecho(add(actual.getDerecho(), dato));
        return actual;
    }
    
    @Override
    public T remove(T dato) {
        T resp = null;
        if(!isEmpty()){
            if(raiz.getElemento().equals(dato)){
               T sucesor = sucesorInOrden(raiz);
                if(sucesor != null)
                   raiz.setElemento(sucesor);
                else
                    raiz = raiz.getIzquierdo();
                total--;
            }
            else {
                NodoBinario <T> actual,anterior;
                actual = raiz;
                anterior = actual;
                while(actual != null && !actual.getElemento().equals(dato)){
                    if(dato.compareTo(actual.getElemento()) < 0){
                       anterior = actual;
                       actual = actual.getIzquierdo();
                    }
                    else
                       if(dato.compareTo(actual.getElemento()) > 0){
                           anterior = actual;
                           actual = actual.getDerecho();
                       } 
                }
                if(actual != null && actual.getElemento().equals(dato)){
                    T sucesor = sucesorInOrden(actual);
                    if(sucesor != null)
                        actual.setElemento(sucesor);
                    else{
                        if(actual == anterior.getIzquierdo())
                            anterior.setIzquierdo(null);
                        else
                            anterior.setDerecho(null);
                    }
                    total--;
                }
           }
        }
        return resp;
    }
    
    private T sucesorInOrden(NodoBinario <T> nodo){
        T res = null; 
        if(nodo.getDerecho() != null){
            NodoBinario actual = nodo.getDerecho(); 
            NodoBinario anterior = nodo;
            while(actual.getIzquierdo()!=null){
                anterior = actual;
                actual = actual.getIzquierdo();
            }
            if(actual.getDerecho()!=null){
                if(actual == anterior){
                    res = (T)actual.getElemento();
                    anterior.setDerecho(actual.getDerecho());
                }
                else {
                    res = (T)actual.getElemento();
                    if(anterior != nodo)
                    anterior.setIzquierdo(actual.getDerecho());
                    else
                        anterior.setDerecho(actual.getDerecho());
                }
            }
            else {
                res = (T)actual.getElemento();
                if(anterior != nodo)
                    anterior.setIzquierdo(actual.getDerecho());
                else
                    anterior.setDerecho(actual.getDerecho());
            }     
        }
        return res;
    }
    
    @Override
    public T removeMin() {
        T temp = null;
        if(!isEmpty()){
            NodoBinario <T> actual = this.raiz;
            NodoBinario <T> papa = actual;
            while(actual.getIzquierdo() != null){
                papa = actual;
                actual = actual.getIzquierdo();
            }
            temp = actual.getElemento();
            if(actual == this.raiz){
                this.raiz = this.raiz.getDerecho();
            }
            else
                papa.setIzquierdo(actual.getDerecho());
            this.total--;
        }
        return temp;
    }

    @Override
    public T removeMax() {
        T res = null;
        if(!isEmpty()){
            NodoBinario <T> actual = this.raiz;
            NodoBinario <T> papa = actual;
            while(actual.getDerecho() != null){
                papa = actual;
                actual = actual.getDerecho();
            }
            res = actual.getElemento();
            if(actual == this.raiz){
                this.raiz = this.raiz.getIzquierdo();
            }
            else
                papa.setDerecho(actual.getIzquierdo());
            this.total--;
        }
        return res;
    }

    @Override
    public T findMin() {
        NodoBinario <T> actual = this.raiz;
        if(actual == null)
            throw new RuntimeException("Árbol vacio");
        while(actual.getIzquierdo() != null)
            actual = actual.getIzquierdo();
        return actual.getElemento();
    }
    
    @Override
    public T findMax() {
        NodoBinario <T> actual = this.raiz;
        if(actual == null)
            throw new RuntimeException("Árbol vacio");
        while(actual.getDerecho() != null)
            actual = actual.getDerecho();
        return actual.getElemento();
    }
    
}
