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
public interface BinarySearchTreeADT <T> extends BinaryTreeADT<T>{
    public void add(T dato);
    public T remove(T dato);
    public T removeMin();
    public T removeMax();
    public T findMin();
    public T findMax();
}