package com.uade.impl;
import com.uade.api.ConjuntoTDA;

import java.util.Random;

public class ConjuntoTDAImpl implements ConjuntoTDA {
    private int paquete[];
    private int indice;
    Random random = new Random();
    @Override
    public void inicializarConjunto() {
        paquete = new int[10];
        indice = 0;
    }

    @Override
    public void agregar(int x) {
        if(indice < 9) {
            boolean flag = false;
            for (int i = 0; i < indice; i++) {
                if (paquete[i] == x) {
                    flag = true;
                }
            }
            if (!flag) {
                paquete[indice] = x;
                indice++;
            }else {
                System.out.println("El elemento ya existe.");
            }
        } else{
            System.out.println("El conjunto esta lleno.");
        }
    }

    @Override
    public int elegir() {
        if(conjuntoVacio()){
            System.out.println("El conjunto esta vacio.");
        } else {
            return paquete[random.nextInt(indice)];
        }
        return 0;
    }

    @Override
    public void sacar(int x) {
        if(indice == 0){
            System.out.println("El conjunto esta vacio.");
        }else{
            boolean flag = false;
            int aux;
            for (int i = 0; i < indice; i++) {
                if (paquete[i] == x) {
                    flag = true;
                    aux = paquete[i];
                    paquete[i] = paquete[i+1];
                    paquete[i+1] = aux;
                }
            }
            if (!flag) {
                System.out.println("El elemento no esta en el conjunto.");
            }else{
//                System.out.println("Numero sacado.");
                paquete[indice] = 0;
                indice--;
            }
        }
    }

    @Override
    public boolean pertenece(int x) {
        for (int i = 0; i < indice; i++) {
            if (paquete[i] == x) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean conjuntoVacio() {
        return indice == 0;
    }
}
