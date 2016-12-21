/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea2;

import java.io.IOException;

/**
 *
 * @author Fernando Peña
 */
public class PruebasOrdenamiento {
    private Pelicula[] peliculas;
    private int total;
    
    public PruebasOrdenamiento(ManejadorPeliculas un){
        this.peliculas = un.getPeliculas();
        this.total = un.getTotal();
    }

    public void setPeliculas(Pelicula[] peliculas) {
        this.peliculas = peliculas;
    }

    public int getTotal() {
        return total;
    }
    
    public int [] ordena(String metodo, int numElementos){
        long tiempoInicio, totalTiempo;
        int comparaciones;
        AlgoritmosOrdenamiento un = new AlgoritmosOrdenamiento();
        
        switch(metodo){
            case "ss" :
                tiempoInicio = System.currentTimeMillis();
                comparaciones = un.selectionSort(peliculas, numElementos);
                totalTiempo = System.currentTimeMillis() - tiempoInicio;
                break;
            case "is" :
                tiempoInicio = System.currentTimeMillis();
                comparaciones = un.insertionSort(peliculas, numElementos);
                totalTiempo = System.currentTimeMillis() - tiempoInicio;
                break;
            case "bs" :
                tiempoInicio = System.currentTimeMillis();
                comparaciones = un.bubbleSort(peliculas, numElementos);
                totalTiempo = System.currentTimeMillis() - tiempoInicio;
                break;
            case "qs" :
                tiempoInicio = System.currentTimeMillis();
                comparaciones = un.quickSort(peliculas, numElementos);
                totalTiempo = System.currentTimeMillis() - tiempoInicio;
                break;
            case "ms" :
                tiempoInicio = System.currentTimeMillis();
                comparaciones = un.mergeSort(peliculas, numElementos);
                totalTiempo = System.currentTimeMillis() - tiempoInicio;
                break;
            case "gs" :
                tiempoInicio = System.currentTimeMillis();
                comparaciones = un.gnomeSort(peliculas, numElementos);
                totalTiempo = System.currentTimeMillis() - tiempoInicio;
                break;
            case "shs" :
                tiempoInicio = System.currentTimeMillis();
                comparaciones = un.shellSort(peliculas, numElementos);
                totalTiempo = System.currentTimeMillis() - tiempoInicio;
                break;
            default :
                tiempoInicio = 0;
                comparaciones = 0;
                totalTiempo = 0;
                break;
        }
        System.out.println("El número total de elementos ordenados fue de " + numElementos);
        System.out.println("El tiempo total de ejecución con " + metodo + " es de " + totalTiempo + " miliseg");
        System.out.println("El numéro total de comparaciones es de " + comparaciones);  
        return new int[]{comparaciones, (int) totalTiempo};
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < total; i++) {
            sb.append(peliculas[i].toString()).append("\n");
        }
        return sb.toString();
    }
    
    public static void main(String[] args) throws IOException {
        ManejadorPeliculas pelis = new ManejadorPeliculas();
        pelis.lecturaInicial("movie_titles2");
        pelis.invierte();
//        pelis.aleatorio();
        PruebasOrdenamiento ord = new PruebasOrdenamiento(pelis);
        
//        System.out.println(ord.toString());
        
        String algoritmo = "is";
        
        ord.ordena(algoritmo, 100);
        ord.setPeliculas(pelis.getPeliculas());
        System.out.println("");
        
        ord.ordena(algoritmo, 500);
        ord.setPeliculas(pelis.getPeliculas());
        System.out.println("");
        
        ord.ordena(algoritmo, 1000);
        ord.setPeliculas(pelis.getPeliculas());
        System.out.println("");
        
        ord.ordena(algoritmo, 5250);
        ord.setPeliculas(pelis.getPeliculas());
        System.out.println("");
        
        ord.ordena(algoritmo, 7750);
        ord.setPeliculas(pelis.getPeliculas());
        System.out.println("");
        
        ord.ordena(algoritmo, 10500);
        ord.setPeliculas(pelis.getPeliculas());
        System.out.println("");
        
        ord.ordena(algoritmo, 14350);
        ord.setPeliculas(pelis.getPeliculas());
        System.out.println("");
        
        ord.ordena(algoritmo, 15000);
        ord.setPeliculas(pelis.getPeliculas());
        System.out.println("");
        
        ord.ordena(algoritmo, 16750);
        ord.setPeliculas(pelis.getPeliculas());
        System.out.println("");
        
        ord.ordena(algoritmo, ord.getTotal());
        System.out.println("");
        
        System.out.println("\nPruebas terminadas\n");
        System.out.println(ord.toString());
    } 
}
