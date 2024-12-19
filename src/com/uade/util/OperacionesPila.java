package com.uade.util;
import com.uade.impl.PilaTDAImpl;
import com.uade.api.PilaTDA;
import com.uade.implDinamica.PilaDinamica;

import java.util.Scanner;

public class OperacionesPila {
    public void mostrarPila(PilaTDA pila){
        PilaTDA pilaAuxiliar = new PilaDinamica();
        pilaAuxiliar.inicializarPila();

        System.out.println("Contenido de la pila: ");
        while(!pila.pilaVacia()){
            int numero = pila.tope();
            pila.desapilar();
            pilaAuxiliar.apilar(numero);
        }
        while(!pilaAuxiliar.pilaVacia()){
            int numero = pilaAuxiliar.tope();
            System.out.println(numero);
            pilaAuxiliar.desapilar();
            pila.apilar(numero);
        }
    }

    public void llenarPila(Scanner scanner, PilaTDA pila) {
        System.out.println("Ingrese la cantidad de numeros para su pila: ");
        int cantidad = scanner.nextInt();
        for (int i = 0; i < cantidad; i++) {
            System.out.println("Ingrese un numero para la pila: ");
            pila.apilar(scanner.nextInt());
        }
        System.out.println("Pila cargada correctamente.");
    }

    public void copiarPila( PilaTDA pila1, PilaTDA pila2 ) {
        PilaTDA auxiliar = new PilaTDAImpl();
        auxiliar.inicializarPila();
        while(!pila1.pilaVacia()){
            int numero = pila1.tope();
            pila1.desapilar();
            auxiliar.apilar(numero);
        }
        while(!auxiliar.pilaVacia()){
            int numero = auxiliar.tope();
            auxiliar.desapilar();
            pila2.apilar(numero);
        }
        System.out.println("Pila 2 copiada.");

    }
}
