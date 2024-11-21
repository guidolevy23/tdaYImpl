package com.uade.impl;

import com.uade.api.ConjuntoTDA;
import com.uade.api.DiccionarioSimpleTDA;

public class DiccionarioSimpleTDAImpl implements DiccionarioSimpleTDA {
    int valores [];
    int claves [];
    ConjuntoTDA conjunto = new ConjuntoTDAImpl();
    int indice;
    @Override
    public void InicializarDiccionario() {
        valores = new int[10];
        indice = 0;
        claves = new int[10];
        conjunto.inicializarConjunto();
    }

    @Override
    public void Agregar(int clave, int valor) {
        if (indice < 9 || conjunto.pertenece(clave)) {
            if (!conjunto.pertenece(clave)) {
                conjunto.agregar(clave);
                valores[indice] = valor;
                claves[indice] = clave;
                indice++;
            } else {
                for (int i = 0; i <= indice; i++) {
                    if (claves[i] == clave) {
                        valores[i] = valor;
                    }
                }
            }
        }else {
            System.out.println("Limite completo de ingresos.");
        }
    }

    @Override
    public void Eliminar(int clave) {
        if (indice > 0) {
            if (conjunto.pertenece(clave)) {
                conjunto.sacar(clave);
                for (int i = 0; i <= indice; i++) {
                    if (claves[i] == clave) {
                        int aux = claves[i];
                        claves[i] = claves[i + 1];
                        claves[i + 1] = aux;
                        int aux2 = valores[i];
                        valores[i] = valores[i + 1];
                        valores[i + 1] = aux2;
                    }
                }
                indice--;
            }
        }else{
            System.out.println("Se encuentra vacio.");
        }
    }

    @Override
    public int Recuperar(int clave) {
        if (indice > 0) {
            if (conjunto.pertenece(clave)) {
                for (int i = 0; i <= indice; i++) {
                    if (claves[i] == clave) {
                        return valores[i];
                    }
                }
            }
        }else{
            System.out.println("Se encuentra vacio.");
        }
        return 0;
    }

    @Override
    public ConjuntoTDA Claves() {
        if(conjunto.conjuntoVacio()){
            System.out.println("No se pueden devolver la claves, conjunto vacio.");
            return null;
        }
        System.out.println("Las claves son: ");
        for (int i = 0; i < indice; i++) {
            System.out.println(claves[i]);
        }
        return conjunto;
    }
}
