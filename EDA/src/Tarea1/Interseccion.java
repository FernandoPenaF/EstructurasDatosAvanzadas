/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Fernando Peña
 * @author Fabián Orduña
 */
public class Interseccion {
    
    public static <T> int interseccion(ArrayList <T []> array){
        if(array.isEmpty())
            return 0;
        else
            if(array.size() == 1)
                return array.get(0).length;
            else{
                ArrayList <T> inter = new ArrayList();
                T [] prim = array.get(0);
                inter.addAll(Arrays.asList(prim));
                return interseccion(array, inter, 1);
            }   
    }
    
    private static <T> int interseccion(ArrayList <T []> array, ArrayList <T> inter, int cont){
        if(inter.isEmpty())
            return 0;
        if(array.size() == cont)
            return inter.size();
        else{
            T [] temp = array.get(cont);
            ArrayList <T> nuevaInterseccion = checaInterseccion(temp, inter);
            return interseccion(array, nuevaInterseccion, cont + 1);
        }
    }
    
    private static <T> ArrayList <T> checaInterseccion(T[] arreglo, ArrayList <T> interseccion){
        ArrayList <T> nuevaInterseccion = new ArrayList();
        
        for (T dato : arreglo)
            if(interseccion.contains(dato))
                nuevaInterseccion.add(dato);
        return nuevaInterseccion;
    }
    
    public static <T> int cuantosIntersectan(ArrayList <T[]> arreglos){
        if(arreglos.isEmpty())
            return 0;
        if(arreglos.size() == 1)
            return arreglos.get(0).length;
        else{
            ArrayList<T> x = new ArrayList();
            T [] arre = arreglos.get(0);
            x.addAll(Arrays.asList(arre));
            return cuantosIntersectan(arreglos, 1, x, arreglos.get(1));
        }
    }

    
    private static <T> int cuantosIntersectan(ArrayList <T []> arreglos, int ultimo, ArrayList <T> interseccion,T[] act){
        if(interseccion.isEmpty())
            return 0;
        else{
            ArrayList <T> nuevo = new ArrayList();
            for (int i = 0; i < interseccion.size(); i++) {
                int checa = 0;
                while(checa < act.length){
                    if(act[checa].equals(interseccion.get(i))){
                        nuevo.add(interseccion.get(i));
                        checa = act.length;
                    }
                    checa++;
                }
            }
            if(ultimo + 1 < arreglos.size())
                return cuantosIntersectan(arreglos, ultimo + 1, nuevo, arreglos.get(ultimo + 1));
            else
                return nuevo.size();
        }
    }
}