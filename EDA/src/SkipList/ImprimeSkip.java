/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SkipList;

/**
 *
 * @author Fernando Peña
 */
public class ImprimeSkip<T> {
    private T matriz[][];
    private SkipList lista;
    
    public ImprimeSkip(SkipList actual){
        this.lista = actual;
        this.matriz = (T[][]) new Object[lista.getTotal() + 2][lista.getTotalNiveles()];
        llenado();
        llenadoInicial();
    }
    
    private void llenadoInicial(){
        int k = lista.getTotalNiveles() - 2;
        NodoS <T> actual = lista.getCF(k);
        for (int j = 1; j < lista.getTotalNiveles(); j++) {
            for (int i = 0; i < lista.getTotal() + 1; i++) {
                if(actual != null){
                    T aux = actual.getElemento();
                    while(i < lista.getTotal() + 1 && matriz[i][0] != aux)
                        i++;
                    this.matriz[i][j] = actual.getElemento();
                    actual = actual.getDerecho();
                }
            }
            k--;
            actual = lista.getCF(k);
        }
    }
    
    private void llenado(){
        int k = lista.getTotalNiveles() - 1;
        NodoS <T> actual = lista.getCF(k);
        for (int i = 0; i < lista.getTotal() + 1; i++) {
            if(actual != null){
                this.matriz[i][0] = actual.getElemento();
                actual = actual.getDerecho();
            }
        }
    }
    
    @Override
    public String toString(){
        String resp = "";
        for (int j = matriz[0].length - 1; j >= 0; j--) {
            for (int i = 0; i < matriz.length; i++) {
                T aux = matriz[i][j];
                if(aux == null && i != 0 && i != matriz.length - 1){
                    String cad = matriz[i][0].toString();
                    String rep = "";
                    for (int k = 0; k < cad.length(); k++) {
                        rep += " ";
                    }
                    resp += rep + "  ";
                }
                else
                    resp += aux + ", "; 
            }
            resp = resp.substring(0, resp.length() - 2);
            resp += "\n";
        }
        return resp;
    }
}
