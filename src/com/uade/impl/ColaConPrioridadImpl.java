package com.uade.impl;
import com.uade.api.ColaPrioridadTDA;

public class ColaConPrioridadImpl implements ColaPrioridadTDA {
    private int elementos[];
    private int prioridades[];
    private int indice;


    @Override
    public void inicializarCola() {
        elementos = new int[100];
        prioridades = new int[100];
        indice = 0;
    }

    @Override
    public void acolarPrioridad(int x, int p) {
        if (indice > 0 && indice < 99) {
            for (int i = indice; i >= 0; i--) {
                if (prioridades[i] < p) {
                    prioridades[i + 1] = prioridades[i];
                    prioridades[i] = p;
                    elementos[i+1] = elementos[i];
                    elementos[i] = x;
                } else {
                    prioridades[i + 1] = p;
                    elementos[i + 1] = x;
                    break;
                }
            }
        } else {
            prioridades[indice] = p;
            elementos[indice] = x;
        }
        indice ++;
    }

    @Override
    public void desacolar() {
        if(indice > 0){
            for (int i = 0; i < indice; i++) {
                elementos[i] = elementos[i + 1];
                prioridades[i] = prioridades[i + 1];
            }
            indice --;
        } else{
            System.out.println("No se puede desacolar, porque esta vacia.");
        }
    }

    @Override
    public int primero() {
        if (indice < elementos.length) {
            return elementos[0];
        }
        return -1;
    }

    @Override
    public boolean colaVacia() {
        return indice == 0;
    }

    @Override
    public int prioridad() {
        if (indice < prioridades.length) {
            return prioridades[0];
        }
        return 0;
    }
}
