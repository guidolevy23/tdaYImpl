package com.uade.impl;

import com.uade.api.ConjuntoTDA;
import com.uade.api.DiccionarioMultipleTDA;

public class DiccionarioMultipleTDAImpl implements DiccionarioMultipleTDA {
    ConjuntoTDA conjunto = new ConjuntoTDAImpl();
    int claves [];
    ConjuntoTDA valores [];
    int indice;

    public void inicializarDiccionario() {
        conjunto.inicializarConjunto();
        claves = new int[10];
        valores = new ConjuntoTDA[10];
        indice = 0;
    }

    @Override
    public void agregar(int clave, int valor) {
        if(indice < 9 || conjunto.pertenece(clave)){
            if(!conjunto.pertenece(clave)){
                claves[indice] = clave;
                conjunto.agregar(clave);
                ConjuntoTDA conjuntoInterno = new ConjuntoTDAImpl();
                conjuntoInterno.inicializarConjunto();
                conjuntoInterno.agregar(valor);
                valores[indice] = conjuntoInterno;
                indice++;
            }else{
                for (int i = 0; i <= indice; i++){
                    if(clave == claves[i]){
                        valores[i].agregar(valor);
                    }
                }
            }
        } else{
            System.out.println("Diccionario lleno");
        }
    }

    @Override
    public void eliminar(int clave) {
        conjunto.sacar(clave);
        for (int i = 0; i <= indice; i++){
            if(clave == claves[i]){
                int aux = claves[i];
                claves[i] = claves[i+1];
                claves[i+1] = aux;
                ConjuntoTDA auxiliar = valores[i];
                valores[i] = valores[i+1];
                valores[i+1] = auxiliar;
            }
        }
        indice--;
    }

    @Override
    public void eliminarValor(int clave, int valor) {
        for (int i = 0; i <= indice; i++){
            if(clave == claves[i]){
                valores[i].sacar(valor);
            }
        }
    }

    @Override
    public ConjuntoTDA recuperar(int clave) {
        for (int i = 0; i <= indice; i++){
            if(clave == claves[i]){
                return valores[i];
            }
        }return null;

    }

    @Override
    public ConjuntoTDA claves() {
        return conjunto;
    }
}
