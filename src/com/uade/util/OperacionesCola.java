package com.uade.util;
import com.uade.impl.ColaTDAImpl;
import com.uade.api.ColaTDA;

import java.util.Scanner;

public class OperacionesCola {
    public void mostrarCola(ColaTDA cola){
        String mostrar = "";
        ColaTDA auxiliar = new ColaTDAImpl();
        auxiliar.inicializarCola();

        while(!cola.colaVacia()){
            int primero = cola.primero();
            mostrar = mostrar + primero + " ";
            cola.desacolar();
            auxiliar.acolar(primero);
        }
        while(!auxiliar.colaVacia()){
            int primero = auxiliar.primero();
            auxiliar.desacolar();
            cola.acolar(primero);
        }
        System.out.println(mostrar);

    }

    public void llenarCola(ColaTDA cola, int num, Scanner sc){
        for (int i = 0; i < num; i++){
            System.out.println("Ingrese un numero: ");
            cola.acolar(sc.nextInt());
        }

    }
}
