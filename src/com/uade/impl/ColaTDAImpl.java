package com.uade.impl;
import com.uade.api.ColaTDA;

public class ColaTDAImpl implements ColaTDA {
    private int [] elementos;
    private int indice;

    @Override
    public void inicializarCola() {
        elementos = new int[100];
        indice = 0;
    }

    @Override
    public void acolar(int x) {
        if (indice < 99) {
            elementos[indice] = x;
            indice++;
        }
    }

    @Override
    public void desacolar() {
        if(indice != 0){
            for (int i = 0; i < indice; i++) {
                elementos[i] = elementos[i + 1];
            }
            indice --;
        } else {
            System.out.println("No se puede desacolar, porque esta vacia.");
        }
    }

    @Override
    public int primero() {
        if (indice != 0) {
            return elementos[0];
        }else {
            System.out.println("No se puede mostrar el primero, porque esta vacia.");
            return -1;
        }
    }

    @Override
    public boolean colaVacia() {
        return indice == 0;
    }
}
