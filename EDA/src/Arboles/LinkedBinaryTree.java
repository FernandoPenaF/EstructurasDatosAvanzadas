/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arboles;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 *
 * @author Fernando Peña
 */
public class LinkedBinaryTree <T extends Comparable <T>> implements BinaryTreeADT <T>{
    protected int total;
    protected NodoBinario <T> raiz;
    
    public LinkedBinaryTree(){
        this.total = 0;
        this.raiz = null;
    }
    
    public LinkedBinaryTree(T dato){
        this.total = 1;
        this.raiz = new NodoBinario <> (dato);
    }
    
    @Override
    public boolean isEmpty() {
        return total == 0;
    }

    @Override
    public int size() {
        return total;
    }

    @Override
    public boolean containts(T dato) {
        NodoBinario <T> temp = find(raiz, dato);
        return (temp != null);
    }
    
    @Override
    public T find(T dato) {
        NodoBinario <T> temp = find(raiz, dato);
        if(temp != null)
            return temp.getElemento();
        throw new NoSuchElementException("El elemento no se encuentra en el árbol");
    }
    
    private NodoBinario <T> find(NodoBinario <T> actual, T dato){
        NodoBinario <T> temp;
        if(actual == null)
            return null;
        if(actual.getElemento().equals(dato))
            return actual;
        temp = find(actual.getIzquierdo(), dato);
        if(temp == null)
            return find(actual.getDerecho(), dato);
        else
            return temp;
    }

    @Override
    public Iterator<T> inOrder() {
        ArrayList <T> lista = new ArrayList <>();
        inOrder(raiz, lista);
        return lista.iterator();
    }

    private void inOrder(NodoBinario <T> nodo, ArrayList <T> lista){
        if(nodo == null)
            return;
        inOrder(nodo.getIzquierdo(), lista);
        lista.add(nodo.getElemento());
        inOrder(nodo.getDerecho(), lista);
    }
    
    @Override
    public Iterator<T> preOrder() {
        ArrayList <T> lista = new ArrayList <>();
        preOrder(raiz, lista);
        return lista.iterator();
    }
    
    private void preOrder(NodoBinario <T> nodo, ArrayList <T> lista){
        if(nodo == null)
            return;
        lista.add(nodo.getElemento());
        preOrder(nodo.getIzquierdo(), lista);
        preOrder(nodo.getDerecho(), lista);
    }

    @Override
    public Iterator<T> postOrder() {
        ArrayList <T> lista = new ArrayList <>();
        postOrder(raiz, lista);
        return lista.iterator();
    }
    
    private void postOrder(NodoBinario <T> nodo, ArrayList <T> lista){
        if(nodo == null)
            return;
        postOrder(nodo.getIzquierdo(), lista);
        postOrder(nodo.getDerecho(), lista);
        lista.add(nodo.getElemento());
    }

    @Override
    public Iterator<T> levelOrder() {
        ArrayList <T> lista = new ArrayList <>();
        levelOrder(raiz, lista);
        return lista.iterator();
    }
    
    private void levelOrder(NodoBinario<T> actual, ArrayList<T> lista) {
        Queue <NodoBinario <T>> cola = new LinkedList();
        cola.add(actual);
        
        while(!cola.isEmpty()){
            NodoBinario <T> temp = cola.remove();
            lista.add(temp.getElemento());
            if(temp.getIzquierdo() != null)
                cola.add(temp.getIzquierdo());
            if(temp.getDerecho() != null)
                cola.add(temp.getDerecho());
        }
    }
    
    public void imprimeArbol(Iterator <T> it){
        if(it != null){
            String resp = "";
            
            while(it.hasNext())
                resp += it.next() + ", ";
            if(resp.length() != 0)
                resp = resp.substring(0, resp.length() - 2);
            System.out.println(resp);
        }
    }
}