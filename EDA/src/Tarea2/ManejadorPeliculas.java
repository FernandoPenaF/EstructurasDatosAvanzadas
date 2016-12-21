/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

/**
 *
 * @author Fernando Peña
 */
public class ManejadorPeliculas{
    private Pelicula[] peliculas;
    private int total;
    
    public ManejadorPeliculas(){
        this.peliculas = new Pelicula[18000];
        this.total = 0;
    }

    public int getTotal() {
        return total;
    }

    public Pelicula[] getPeliculas() {
        return peliculas;
    }
    
    public void altaPelicula(Pelicula peli){
        if(peli != null){
            if(total == peliculas.length)
                expandCapacity(peliculas.length * 2);
            peliculas[total] = peli;
            total++;
        }
    }
    
    private void expandCapacity(int capacity){
        Pelicula[] temp = new Pelicula [capacity];
        System.arraycopy(peliculas, 0, temp, 0, total);
        peliculas = temp;
    }
    
    public void lecturaInicial(String nomArchivo) throws FileNotFoundException, IOException{
        if(nomArchivo != null){
            String cadena;
            FileReader f = new FileReader(nomArchivo + ".txt");
            BufferedReader b = new BufferedReader(f);
            
            while((cadena = b.readLine())!= null) {
                alta(cadena);
            }
            b.close();
        }
    }
    
    private void alta(String cadena){
        StringTokenizer st = new StringTokenizer(cadena, ",");
        int id = Integer.valueOf(st.nextToken());
        int año = Integer.valueOf(st.nextToken());
        String nombre = "";
        while(st.hasMoreTokens())
            nombre += st.nextToken() + ",";
        if(nombre.charAt(nombre.length() - 1) == ',')
            nombre = nombre.substring(0, nombre.length() - 1);
        altaPelicula(new Pelicula(id, año, nombre));
    }
    
    public void invierte(){
        ArrayList <Pelicula> array = new ArrayList();
        for (int i = total - 1; i >= 0; i--) {
            array.add(peliculas[i]);
        }
        for (int i = 0; i < total; i++) {
            peliculas[i] = array.get(i);
        }
    }
    
    public void aleatorio(){
        Random random = new Random();
        for (int i = 0; i < total; i++) {
            int pos = random.nextInt(total);
            Pelicula temp = peliculas[i];
            peliculas[i] = peliculas[pos];
            peliculas[pos] = temp;
        }
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < total; i++) {
            sb.append(peliculas[i].toString()).append("\n");
        }
        return sb.toString();
    }
}