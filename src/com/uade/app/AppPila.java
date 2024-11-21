package com.uade.app;

import com.uade.api.ColaTDA;
import com.uade.impl.ColaTDAImpl;
import com.uade.impl.ConjuntoTDAImpl;
import com.uade.impl.PilaTDAImpl;
import com.uade.implDinamica.PilaDinamica;
import com.uade.util.OperacionesConjunto;
import com.uade.util.OperacionesPila;
import com.uade.api.PilaTDA;
import com.uade.api.ConjuntoTDA;

import java.util.Scanner;

public class AppPila {
    public static void main(String[] args) {
        AppPila app = new AppPila();
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el numero de operacion: ");
        int numero = sc.nextInt();
        switch (numero){
            case 1:
                app.excecuteA(sc);
                break;
            case 2:
                app.excecuteB(sc);
                break;
            case 3:
                app.excecuteD(sc);
                break;
            case 4:
                app.excecuteE(sc);
                break;
            case 5:
                app.excecuteF(sc);
                break;
        }
    }
    public void excecuteA (Scanner sc){
        // para crear una pila se usa el tipo TDA y se hace new de la implementacion
        PilaTDA pila1 = new PilaTDAImpl();
        PilaTDA pila2 = new PilaTDAImpl();
        pila1.inicializarPila();
        pila2.inicializarPila();

        OperacionesPila op = new OperacionesPila();
        op.llenarPila(sc, pila1);
        op.mostrarPila(pila1);
        pasarPila( pila1, pila2 );
        op.mostrarPila(pila2);
//        capicua(pila2);
//        dividirPilas(pila2,pila1);
//        op.mostrarPila(pila2);
//        op.mostrarPila(pila1);
        ConjuntoTDA repetidos = conjuntoRepetidos(pila2);
        OperacionesConjunto opConj = new OperacionesConjunto();
        opConj.mostrarConjunto(repetidos);
}
    public void excecuteB(Scanner sc){

        PilaTDA pila1 = new PilaDinamica();
        PilaTDA auxiliar = new PilaDinamica();
        PilaTDA pila2 = new PilaDinamica();
        pila1.inicializarPila();
        pila2.inicializarPila();
        auxiliar.inicializarPila();

        OperacionesPila op = new OperacionesPila();
        op.llenarPila(sc, pila1);
        copiarPila(pila1, pila2, auxiliar);
        op.mostrarPila(pila2);
        eliminarRepetidos(pila2);
        op.mostrarPila(pila2);

    }
    public void excecuteD(Scanner sc){

        PilaTDA pila = new PilaDinamica();
        PilaTDA auxiliar = new PilaDinamica();
        pila.inicializarPila();
        auxiliar.inicializarPila();

        OperacionesPila op = new OperacionesPila();
        op.llenarPila(sc, pila);
        int cantidadElementos = contarElementos(pila, auxiliar);
        System.out.println("Son:" + cantidadElementos + " elementos");


    }
    public void excecuteE(Scanner sc){

        PilaTDA pila = new PilaDinamica();
        PilaTDA auxiliar = new PilaDinamica();
        pila.inicializarPila();
        auxiliar.inicializarPila();

        OperacionesPila op = new OperacionesPila();
        op.llenarPila(sc, pila);
        int sumaElementos = sumarElementos(pila, auxiliar);
        System.out.println("La suma da:" + sumaElementos);


    }
    public void excecuteF(Scanner sc){

        PilaTDA pila = new PilaDinamica();
        PilaTDA auxiliar = new PilaDinamica();
        pila.inicializarPila();
        auxiliar.inicializarPila();
        float promedio = 0;
        OperacionesPila op = new OperacionesPila();
        op.llenarPila(sc, pila);
        int sumaElementos = sumarElementos(pila, auxiliar);
        int cantElementos = contarElementos(pila, auxiliar);
        if (cantElementos !=0){
            promedio = (float) sumaElementos / cantElementos;
        }
        System.out.println("El promedio es: " + promedio);


    }
    private void eliminarRepetidos(PilaTDA pila){
        PilaTDA pilaAux = new PilaTDAImpl();
        ConjuntoTDA conjunto = new ConjuntoTDAImpl();
        conjunto.inicializarConjunto();
        pilaAux.inicializarPila();
        pasarPila(pila, pilaAux);
        while(!pilaAux.pilaVacia()){
            int num = pilaAux.tope();
            pilaAux.desapilar();
            if(!conjunto.pertenece(num)){
                conjunto.agregar(num);
                pila.apilar(num);
            }
        }

    }
    private void pasarPila( PilaTDA pila1, PilaTDA pila2 ) {
        while(!pila1.pilaVacia()){
            int numero = pila1.tope();
            pila1.desapilar();
            pila2.apilar(numero);
        }
        System.out.println("Pila 1 vaciada y cargada la pila 2.");
    }
    private void copiarPila( PilaTDA pila1, PilaTDA pila2 , PilaTDA auxiliar ) {
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
    private int contarElementos(PilaTDA pila,  PilaTDA auxiliar) {
        int contador = 0;
        while(!pila.pilaVacia()){
            int numero = pila.tope();
            pila.desapilar();
            auxiliar.apilar(numero);
            contador++;
        }
        while(!auxiliar.pilaVacia()){
            int numero = auxiliar.tope();
            auxiliar.desapilar();
            pila.apilar(numero);
        }
        return contador;
    }
    private int sumarElementos(PilaTDA pila,  PilaTDA auxiliar) {
        int suma = 0;
        while(!pila.pilaVacia()){
            int numero = pila.tope();
            suma = suma + numero;
            pila.desapilar();
            auxiliar.apilar(numero);
        }
        while(!auxiliar.pilaVacia()){
            int numero = auxiliar.tope();
            auxiliar.desapilar();
            pila.apilar(numero);
        }
        return suma;
    }
    private void capicua(PilaTDA pila) {
        PilaTDA pilaAux = new PilaTDAImpl();
        ColaTDA cola = new ColaTDAImpl();
        ColaTDA colaAux = new ColaTDAImpl();
        cola.inicializarCola();
        colaAux.inicializarCola();
        pilaAux.inicializarPila();
        int elementos = contarElementos(pila, pilaAux);
        elementos = elementos / 2;
        for (int i = 0; i < elementos; i++) {
            cola.acolar(pila.tope());
            pila.desapilar();
        }
        while(!pila.pilaVacia()){
            pilaAux.apilar(pila.tope());
            pila.desapilar();
        }

        while(!cola.colaVacia() && elementos !=0 ){
            if (cola.primero() == pilaAux.tope()){
                colaAux.acolar(cola.primero());
                pila.apilar(pilaAux.tope());
                cola.desacolar();
                pilaAux.desapilar();
                elementos--;
            }

            if ( elementos == 0){
                System.out.println("Es capicua");
                break;
            }
            if (cola.primero() != pilaAux.tope()){
                System.out.println("No es capicua");
                break;
            }
        }
    }
    private void dividirPilas(PilaTDA pila, PilaTDA pila2) {
        PilaTDA auxiliar = new PilaTDAImpl();
        auxiliar.inicializarPila();
        int num = contarElementos(pila, auxiliar);
        num = num / 2;
        for (int i = 0; i < num; i++) {
            auxiliar.apilar(pila.tope());
            pila.desapilar();
        }
        for (int i = 0; i < num; i++) {
            pila2.apilar(auxiliar.tope());
            auxiliar.desapilar();
        }
    }
    private ConjuntoTDA conjuntoRepetidos(PilaTDA pila){
        PilaTDA pilaAux = new PilaTDAImpl();
        ConjuntoTDA conjunto = new ConjuntoTDAImpl();
        ConjuntoTDA repetidos = new ConjuntoTDAImpl();
        conjunto.inicializarConjunto();
        repetidos.inicializarConjunto();
        pilaAux.inicializarPila();
        while(!pila.pilaVacia()){
            int num = pila.tope();
            pilaAux.apilar(num);
            pila.desapilar();
            if(!conjunto.pertenece(num)){
                conjunto.agregar(num);
            } else{
                repetidos.agregar(num);
            }
        }
        while(!pilaAux.pilaVacia()){
            pila.apilar(pilaAux.tope());
            pilaAux.desapilar();
        }
        return repetidos;
    }
}
