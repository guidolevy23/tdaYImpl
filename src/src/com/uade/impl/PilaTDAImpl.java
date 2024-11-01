package com.uade.impl;
import com.uade.api.PilaTDA;

public class PilaTDAImpl implements PilaTDA {
    /*Creo una variable que va a ser la misma que vaya cargando de valores*/
    private int paquete[] ;
    /*Creo una variable que va a ser el indice de mi arreglo el cual se va a ir moviendo a lo largo que se agreguen o se borren elementos */
    int indice;

    @Override
    public void inicializarPila() {
        /* Inicializo ambas variables con valores*/
        paquete = new int[100];
        indice = -1;
    }

    @Override
    public void apilar(int x) {
        /* Aca me fijo que no sobre pase el limite de agregados, por ende en el caso de que no este completa, lo que va a hacer es */
        if (indice < 99) {
            indice++;
            paquete[indice] = x;
        }

    }

    @Override
    public void desapilar() {
        /*Aca comparo que la lista tenga por lo menos 1 valor para permitir desapilar*/
        if (indice >= 0){
            /*Aca basicamente bajo el indice del tope, por  que? porque la proxima vez que ponga apilar, el numero que se apile va a pisar el anterior*/
            indice--;

        }
    }

    @Override
    public int tope() {
        /*Si aca hay algo en los indices devuelvo el valor */
        if (indice >= 0){
            /*Devuelvo el valor del paquete[indice] donde estoy parado*/
            return paquete[indice];
        }
        return 0;
    }

    @Override
    public boolean pilaVacia() {
        return indice <= -1;
    }
}
