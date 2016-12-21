/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea2;

/**
 *
 * @author Fernando Peña
 * @param <T>
 */
public class AlgoritmosOrdenamiento <T extends Comparable<T>> {

    public AlgoritmosOrdenamiento() {
    }
    
    public String imprime(T[] arreglo){
        String resp = "";
        for (T t : arreglo) {
            resp += t + ", ";
        }
        return resp;
    }
    
    private void swap(T[] arre, int pos1, int pos2){
        T temp = arre[pos1];
        arre[pos1] = arre[pos2];
        arre[pos2] = temp;
    }
    
    public int selectionSort(T[] arreglo, int numElementos){
        int minimo, comparaciones = 0;
        
        for (int i = 0; i < numElementos; i++) {
            minimo = i;
            for (int j = i + 1; j < numElementos; j++) {
                if(arreglo[j].compareTo(arreglo[minimo]) < 0)
                    minimo = j;
                comparaciones++;
            }
            swap(arreglo, i, minimo);
        }
        return comparaciones;
    }
    
    public int insertionSort(T[] arreglo, int numElementos){
        int comparaciones = 0;
        for (int i = 1; i < numElementos; i++) {
            T pos = arreglo[i];
            int j = i - 1;
            
            while(j >= 0 && arreglo[j].compareTo(pos) > 0){
                arreglo[j + 1] = arreglo[j];
                j--;
                comparaciones++;
            }
            if(!(j >= 0))
                comparaciones++;
            arreglo[j + 1] = pos;
        }
        return comparaciones;
    }
    
    public int bubbleSort(T[] arreglo, int numElementos){
        int comparaciones = 0;
        for (int i = numElementos - 1; i >= 0; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if(arreglo[j].compareTo(arreglo[j + 1]) > 0)
                    swap(arreglo, j, j + 1);
                comparaciones++;
            }
        }
        return comparaciones;
    }
    
    public int quickSort(T[] arreglo, int numElementos){
        return quickSort(arreglo, 0, numElementos - 1, 0);
    }
    
    private int quickSort(T[] arreglo, int limMin, int limMax, int comparaciones){
        int pos;
        if(limMax <= limMin)
            return comparaciones;
        pos = encuentraParticion(arreglo, limMin, limMax);
        quickSort(arreglo, limMin, pos, comparaciones);
        quickSort(arreglo, pos + 1, limMax, comparaciones);
        return comparaciones;
    }
    
    private int encuentraParticion(T[] arreglo, int limMin, int limMax){
        while(limMin < limMax){
            if(arreglo[limMin + 1].compareTo(arreglo[limMin]) < 0){
                swap(arreglo, limMin, limMin + 1);
                limMin++;
            }
            else{
                swap(arreglo, limMax, limMin + 1);
                limMax--;
            }
        }
        return limMin;
    }
    
    public int mergeSort(T[] arreglo, int numElementos){
        if(arreglo.length != 0 || arreglo.length != 1)
            return mergeSort(arreglo, 0, numElementos - 1, 0);
        return 0;
    }
    
    private int mergeSort(T[] arreglo, int min, int max, int numComparaciones){
        T[] temp;
        int izq, der;
        
        if(min == max)
            return numComparaciones;
        int tamaño = max - min + 1;
        int pivote = (min + max) / 2;
        temp = (T[]) new Comparable[tamaño];
        
        mergeSort(arreglo, min, pivote, 0);
        mergeSort(arreglo, pivote + 1, max, 0);
        for (int i = 0; i < tamaño; i++) {
            temp[i] = arreglo[min + i];
        }
        izq = pivote - min + 1;
        der = 0;
        for (int i = 0; i < tamaño; i++) {
            if(izq <= max - min)
                if(der <= pivote - min){
                    if(temp[der].compareTo(temp[izq]) > 0)
                        arreglo[i + min] = temp[izq++];
                    else
                        arreglo[i + min] = temp[der++];
                    numComparaciones++;
                }
                else
                    arreglo[i + min] = temp[izq++];
            else
                arreglo[i + min] = temp[der++];
        }
        return numComparaciones;
    }
    
    public int gnomeSort(T[] arreglo, int numElementos){
        int numComparaciones = 0;
        int i = 1;
        while(i < numElementos){
            if(arreglo[i - 1].compareTo(arreglo[i]) < 0)
                i++;
            else{
                T temp = arreglo[i];
                arreglo[i] = arreglo[i - 1];
                arreglo[i - 1] = temp;
                i--;
            }
            if(i == 0)
                i = 1;
            numComparaciones++;
        }
        return numComparaciones;
    }
    
    public int shellSort(T[] arreglo, int numElementos){
        int numComparaciones = 0;
        boolean cambio;
        
        for (int cont = numElementos / 2; cont != 0; cont /= 2) {
            cambio = true;
            while(cambio){
                cambio = false;
                for (int i = cont; i < numElementos; i++) {
                    if(arreglo[i -  cont].compareTo(arreglo[i]) > 0){
                        swap(arreglo,i, i - cont);
                        cambio = true;
                    }
                    numComparaciones++;
                }
            }
        }
        return numComparaciones;
    }
}
