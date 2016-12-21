/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SkipList;

import java.util.NoSuchElementException;

/**
 *
 * @author Fernando Peña
 */
public class SkipList<T extends Comparable <T>> {
    private NodoS <T> cabeza;
    private NodoS <T> cola;
    private int total;
    private int totalNiveles;
    
    public SkipList(){
        this.total = 0;
        this.cabeza = new NodoS <>();
        this.cola = new NodoS <>();
        this.cabeza.agregaDerecha(cola);
        this.totalNiveles = 1;
    }
    
    public SkipList(T elemento){
        this.total = 1;
        this.cabeza = new NodoS <>();
        this.cola = new NodoS <>();
        this.cabeza.agregaDerecha(cola);
        NodoS <T> nodo = new NodoS(elemento);
        this.cabeza.agregaDerecha(nodo);
        this.totalNiveles = 1;
    }

    public int getTotal() {
        return total;
    }

    public int getTotalNiveles() {
        return totalNiveles;
    }
    
    public boolean isEmpty(){
        return total == 0;
    }
    
    public NodoS<T> getCF(int i){
        NodoS <T> actual = cabeza;
        int cont = 0;
        while(cont < i && actual.getAbajo() != null){
            actual = actual.getAbajo();
            cont++;
        }
        return actual;
    }
    
    private boolean volado(){
        return Math.random() <= 0.5;
    }
    
    public T busca(T elemento){
        if(!isEmpty()){
            NodoS <T> resp = busca(this.cabeza.getDerecho(), elemento);
            if(resp != null && resp.getElemento().equals(elemento))
                return resp.getElemento();
            else
                return null;
        }else
            throw new NoSuchElementException("SkipList vacía");
    }
    
    private NodoS <T> busca(NodoS <T> actual, T elemento){
        T comparar = actual.getElemento();
        if(actual == null)
            return null;
        
        if(actual.getElemento() == null){
            if(actual.getAbajo() != null){
                actual = actual.getIzquierdo();
                actual = actual.getAbajo();
                return busca(actual.getDerecho(), elemento);
            }
            else
                return actual.getIzquierdo();  
        }
        else
            if(comparar.equals(elemento)){
                while(actual.getAbajo() != null)
                    actual = actual.getAbajo();
                return actual;
            }
            else
                if(comparar.compareTo(elemento) > 0)
                    if(actual.getAbajo() ==  null)
                        return actual.getIzquierdo();
                    else
                        if(actual.getIzquierdo().getElemento() != null)
                            return busca(actual.getIzquierdo().getAbajo(), elemento);
                        else
                            return busca(actual.getIzquierdo().getAbajo().getDerecho(), elemento);
                else
                    return busca(actual.getDerecho(), elemento);
    }
    
    public void agrega(T elemento){
        if(elemento != null){
            NodoS <T> agregar = new NodoS<>(elemento);
            
            if(isEmpty())
                this.cabeza.agregaDerecha(agregar);
            else{
                NodoS <T> resp = busca(this.cabeza.getDerecho(), elemento);
                boolean b = volado();
                int cont = totalNiveles - 1;
                
                resp.agregaDerecha(agregar);
                
                resp = resp.getDerecho();
                while(cont < Math.log(total) && b){
                    NodoS <T> actual = resp;
                    NodoS <T> levelN = new NodoS <> (elemento);
                    while(actual.getDerecho() != null && actual.getArriba() == null)
                        actual = actual.getDerecho();
                    if(actual.getElemento() == null && actual.getArriba() == null)
                        agregaNivel();
                    actual = actual.getArriba();
                    actual.agregaIzquierda(levelN);
                    resp.setArriba(levelN);
                    levelN.setAbajo(resp);
                    resp = levelN;
                    cont++;
                    b = volado();
                }
            }
            this.total++;
        }
    }
    
    public T elimina(T elemento){
        NodoS <T> aEliminar = busca(this.cabeza.getDerecho(), elemento);
        if(aEliminar.getElemento() == elemento){
            T resp = aEliminar.getElemento();
            aEliminar.colapsa();
            if(this.cabeza.getDerecho() == this.cola)
                quitaNivel();
            this.total--;
            return resp;
        }
        else
            return null;
    }
    
    public T eliminaMaximo(){
        if(!isEmpty()){
            NodoS<T> actual = this.cola;
            T resp;
            
            while(actual.getAbajo() != null)
                actual = actual.getAbajo();
            actual = actual.getIzquierdo();
            resp = actual.getElemento();
            actual.colapsa();
            if(this.cabeza.getDerecho() == this.cola)
                quitaNivel();
            this.total--;
            return resp;
        }
        else
            return null;
    }
    
    public T eliminaMinimo(){
        if(!isEmpty()){
            NodoS <T> actual = this.cabeza;
            T resp;
            
            while(actual.getAbajo() != null)
                actual = actual.getAbajo();
            actual = actual.getDerecho();
            resp = actual.getElemento();
            actual.colapsa();
            if(this.cabeza.getDerecho() == this.cola)
                quitaNivel();
            this.total--;
            return resp;        
        }
        else
            return null;
    }
    
    public void eliminaAlto(int n){
        if(!isEmpty()){
            int cont = 0;
            while(cont < n){
                NodoS <T> actual = cabeza.getDerecho();
                if(actual.getElemento() != null)
                    elimina(actual.getElemento());
                cont++;
            }
        }
    }
    
    public void reEstructura(){
        colapsaListaInicial();
        int cont = totalNiveles + 1;
        NodoS <T> actual, abajo;
        
        while(cont < Math.log(total)){
            int num;
            agregaNivel();
            actual = this.cabeza;
            abajo = actual.getAbajo().getDerecho();
            num = 0;
            while(abajo.getDerecho() != null){
                if(num % 2 == 0){
                    NodoS <T> levelN = new NodoS <>(abajo.getElemento());
                    actual.agregaDerecha(levelN);
                    abajo.setArriba(levelN);
                    levelN.setAbajo(abajo);
                    actual = levelN;
                }
                abajo = abajo.getDerecho();
                num++;
            }
            cont++;
        }
    }
    
    private void agregaNivel(){
        NodoS <T> nuevaCabeza = new NodoS <>();
        NodoS <T> nuevaCola = new NodoS <>();
        
        nuevaCabeza.agregaDerecha(nuevaCola);
        cabeza.setArriba(nuevaCabeza);
        nuevaCabeza.setAbajo(cabeza);
        cola.setArriba(nuevaCola);
        nuevaCola.setAbajo(cola);
        this.cabeza = nuevaCabeza;
        this.cola = nuevaCola;
        this.totalNiveles++;
    }
    
    private void quitaNivel(){
        if(cabeza.getAbajo() != null){
            NodoS <T> nuevaCabeza = cabeza.getAbajo();
            NodoS <T> nuevaCola = cola.getAbajo();
            cabeza.setAbajo(null);
            nuevaCabeza.setArriba(null);
            cola.setAbajo(null);
            nuevaCola.setArriba(null);
            this.cabeza = nuevaCabeza;
            this.cola = nuevaCola;
            this.totalNiveles--;
        }
    }
    
    private void colapsaListaInicial(){
        NodoS <T> actual;
        while(this.totalNiveles > 1)
            quitaNivel();
        actual = this.cabeza.getDerecho();
        while(actual != null && actual.getElemento() != null){
            actual.quitaArriba();
            actual = actual.getDerecho();
        }
    }
    
    @Override
    public String toString(){
        ImprimeSkip lista = new ImprimeSkip(this);
        return lista.toString();
    }
}
