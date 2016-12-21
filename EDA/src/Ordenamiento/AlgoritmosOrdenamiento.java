/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ordenamiento;

/**
 *
 * @author Fernando Peña
 * @param <T>
 */
public class AlgoritmosOrdenamiento <T extends Comparable<T>>  {

    public AlgoritmosOrdenamiento(){
        
    }
    
    public void imprime(T[] arreglo){
        for (T t : arreglo) {
            System.out.println(t);
        }
    }
    
    private void swap(T[] arre, int pos1, int pos2){
        T temp = arre[pos1];
        arre[pos1] = arre[pos2];
        arre[pos2] = temp;
    }
    
    public void selectionSort(T[] arreglo, int numElementos){
        int minimo;
        
        for (int i = 0; i < numElementos; i++) {
            minimo = i;
            for (int j = i + 1; j < numElementos; j++) {
                if(arreglo[j].compareTo(arreglo[minimo]) < 0)
                    minimo = j;
            }
            swap(arreglo, i, minimo);
        }
    }
    
    public void insertionSort(T[] arreglo, int numElementos){
        for (int i = 1; i < numElementos; i++) {
            T pos = arreglo[i];
            int j = i - 1;
            
            while(j >= 0 && arreglo[j].compareTo(pos) > 0){
                arreglo[j + 1] = arreglo[j];
                j--;
            }
            arreglo[j + 1] = pos;
        }
    }
    
    public void bubbleSort(T[] arreglo, int numElementos){
        for (int i = numElementos - 1; i >= 0; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if(arreglo[j].compareTo(arreglo[j + 1]) > 0)
                    swap(arreglo, j, j + 1);
            }
        }
    }
    
    public void quickSort(T[] arreglo, int numElementos){
        quickSort(arreglo, 0, numElementos - 1);
    }
    
    private void quickSort(T[] arreglo, int limMin, int limMax){
        int pos;
        if(limMax <= limMin)
            return;
        pos = encuentraParticion(arreglo, limMin, limMax);
        quickSort(arreglo, limMin, pos);
        quickSort(arreglo, pos + 1, limMax);
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
    
    /*
    *Estructuras de datos con Java : diseño de estructuras y algoritmos 
    * John Lewis, Joseph Chase ; tr. Vuelapluma.
    */
    public void mergeSort(T[] arreglo, int numElementos){
        if(arreglo.length != 0 || arreglo.length != 1)
            mergeSort(arreglo, 0, numElementos - 1, 0);
    }
    
    private void mergeSort(T[] arreglo, int min, int max, int numComparaciones){
        T[] temp;
        int izq, der;
        
        if(min == max)
            return;
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
    }
}