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
public class ListaRecursiva <T>{
    private Nodo <T> cabeza;
    
    public ListaRecursiva(){
        this.cabeza = new Nodo <T>();
    }
    
    public boolean estaVacia(){
        return cabeza.getSiguiente() == null;
    }
    
    public void imprime(){
        System.out.println(imprime(cabeza.getSiguiente(), ""));
    }
    
    private String imprime(Nodo<T> nodo, String resp){
        if(nodo == null)
            return resp;
        else{
            resp += nodo.getElemento() + ", ";
            return imprime(nodo.getSiguiente(), resp);
        }
    }
    
    public void insertar(T dato){
        Nodo <T> nuevo = new Nodo(dato);
        nuevo.setSiguiente(cabeza.getSiguiente());
        cabeza.setSiguiente(nuevo);
    }
    
    public int getTotal(){
        return cuenta(cabeza.getSiguiente());
    }
    
    private int cuenta(Nodo <T> nodo){
        if(nodo == null)
            return 0;
        else
            return 1 + cuenta(nodo.getSiguiente());
    }
    
    public void invierte(){
        invierte(cabeza.getSiguiente());
    }
    
    private Nodo <T> invierte(Nodo <T> actual){
        if(actual == null)
            return cabeza.getSiguiente();
        else{
            T valor = actual.getElemento();
            Nodo <T> temp = invierte(actual.getSiguiente());
            temp.setElemento(valor);
            return temp.getSiguiente();
        }
    }
    
    public boolean esPalindromo(){
        return esPalindromo(cabeza.getSiguiente()) == null;
    }
    
    private Nodo <T> esPalindromo(Nodo <T> actual){
        if(actual == null)
            return cabeza.getSiguiente();
        else{
            Nodo <T> temp = esPalindromo(actual.getSiguiente());
            if(temp.getElemento().equals(actual.getElemento()))
                return temp.getSiguiente();
            else
                return temp;
        }
    }
}