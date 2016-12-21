/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arboles;

import java.util.Iterator;

/**
 *
 * @author Fernando Peña
 */
public interface BinaryTreeADT <T>{
    public boolean isEmpty();
    public int size();
    public boolean containts(T dato);
    public T find(T dato);
    public String toString();
    public Iterator <T> inOrder();
    public Iterator <T> preOrder();
    public Iterator <T> postOrder();
    public Iterator <T> levelOrder();
}
