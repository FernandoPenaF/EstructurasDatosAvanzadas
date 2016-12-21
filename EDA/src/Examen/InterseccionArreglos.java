/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author Fernando Peña
 */
public class InterseccionArreglos<T> {

    public InterseccionArreglos(){
        
    }
    
    public int interseccion(ArrayList<T[]> arreglos, int n){
        HashSet<T> tabla = new HashSet();
        T[] actual;
        
        for (int i = 0; i < arreglos.size(); i++) {
            HashSet<T> intersec = new HashSet();
            actual = arreglos.get(i);
            for (int j = 0; j < n; j++) {
                if(i == 0)
                    tabla.add(actual[j]);
                else if(tabla.contains(actual[j]))
                    intersec.add(actual[j]);
            }
            if(i != 0)
                tabla = intersec;
        }
//        print(tabla.iterator()); //Metodo extra al del examen... Para probar el código
        return tabla.size();
    }
    
    //Metodo extra al del examen... Para probar el código
    private void print(Iterator<T> it){
        String resp = "";
        while(it.hasNext())
            resp += it.next() + ", ";
        if(resp.length() != 0)
            resp = resp.substring(0, resp.length() - 2);
        System.out.println(resp);
    }
    
    public static void main(String[] args) {
        ArrayList<Integer[]> al = new ArrayList<>();
        InterseccionArreglos ap = new InterseccionArreglos();
        Integer[] a = {7, 2, 3, 4, 5, 6};
        Integer[] b = {2, 3, 4, 5, 6, 7};
        Integer[] c = {3, 4, 5, 6, 7, 8};
        Integer[] d = {4, 5, 6, 7, 8, 9};
        Integer[] e = {5, 6, 7, 8, 4, 10};
        Integer[] f = {6, 5, 7, 8, 9, 10};
        al.add(a);
        al.add(b);
        al.add(c);
        al.add(d);
        al.add(e);
        al.add(f);
        System.out.println("Número de elementos en la intersección : " + ap.interseccion(al, 6));
    }
}