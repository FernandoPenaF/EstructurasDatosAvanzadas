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
public class EjerciciosRecursivos {
    
    public static void permutaciones(String cad){
        permutaciones(cad, "");
    }
    
    private static void permutaciones(String cad, String resp){
        if(cad.length() == 0){
            System.out.println(resp);
            return;
        }
        for (int i = 0; i < cad.length(); i++) {
            String c = cad.substring(i, i + 1);
            String resto = cad.substring(0, i) + cad.substring(i + 1);
            permutaciones(resto, resp + c);
        }
    }
    
    public static int operacionesMinimas(String s1, String s2){
        return operacionesMinimas(s1, s2, 0, Math.max(s1.length(), s2.length()));
    }
    
    private static int operacionesMinimas(String s1, String s2, int cont, int max) {
        int val1, val2, val3;
        if(s1.compareTo(s2) == 0)
            return cont;
        if(s1.length() == 0 || s2.length() == 0)
            return cont + s1.length() + s2.length();
        if(cont > max)
            return max;
        if(s1.charAt(0) == s2.charAt(0)) //Caracteres iguales
            return operacionesMinimas(s1.substring(1), s2.substring(1), cont, max);
        val1 = operacionesMinimas(s1.substring(1), s2.substring(1), cont + 1, max); //Sustituir
        val2 = operacionesMinimas(s1.substring(1), s2, cont + 1, max); //Eliminar
        val3 = operacionesMinimas(s1, s2.substring(1), cont + 1, max); //Añadir
        return Math.min(val1, Math.min(val2, val3)); 
    }
}
