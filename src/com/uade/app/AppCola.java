package com.uade.app;
import com.uade.api.ConjuntoTDA;
import com.uade.impl.ColaTDAImpl;
import com.uade.impl.ConjuntoTDAImpl;
import com.uade.impl.PilaTDAImpl;
import com.uade.implDinamica.ColaDinamica;
import com.uade.util.OperacionesCola;
import com.uade.api.ColaTDA;
import com.uade.api.PilaTDA;
import com.uade.util.OperacionesConjunto;

import java.util.Scanner;

public class AppCola {
    public static void main(String[] args) {
        AppCola appCola = new AppCola();
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el numero de operacion: ");
        int numero = sc.nextInt();
        switch (numero){
            case 1:
                appCola.excecuteA(sc);
                break;
            case 2:
                appCola.excecuteB(sc);
                break;
            case 3:
                appCola.excecuteC(sc);
                break;
            case 4:
                appCola.excecuteD(sc);
                break;
            case 5:
                appCola.excecuteE(sc);
                break;
            case 6:
                appCola.excecuteF(sc);
                break;
        }
    }
    public void excecuteA(Scanner sc){
        ColaTDA cola = new ColaDinamica();
        ColaTDA cola2 = new ColaDinamica();
        OperacionesCola operacionesCola = new OperacionesCola();
        cola.inicializarCola();
        cola2.inicializarCola();

        System.out.println("Ingrese la cantidad de numeros para su cola: ");
        int num = sc.nextInt();
        operacionesCola.llenarCola(cola,num,sc);
        System.out.println("La cola quedo de esta manera: ");
        operacionesCola.mostrarCola(cola);
        pasarCola(cola,cola2);
        System.out.println("La cola 2 fue pasada y quedo asi: ");
        operacionesCola.mostrarCola(cola2);


    }
    public void excecuteB(Scanner sc){
        ColaTDA cola = new ColaDinamica();
        PilaTDA pilaAuxiliar = new PilaTDAImpl();
        OperacionesCola operacionesCola = new OperacionesCola();
        cola.inicializarCola();
        pilaAuxiliar.inicializarPila();
        System.out.println("Ingrese la cantidad de numeros para su cola: ");
        int num = sc.nextInt();
        operacionesCola.llenarCola(cola, num, sc);
        invertirColaConPila(cola, pilaAuxiliar);
        System.out.println("La cola quedo de esta manera: ");
        operacionesCola.mostrarCola(cola);

    }
    public void excecuteC(Scanner sc){
        ColaTDA cola = new ColaDinamica();
        ColaTDA cola2 = new ColaDinamica();
        OperacionesCola operacionesCola = new OperacionesCola();
        cola.inicializarCola();
        cola2.inicializarCola();

        System.out.println("Ingrese la cantidad de numeros para su cola: ");
        int num = sc.nextInt();
        operacionesCola.llenarCola(cola, num, sc);
        System.out.println("Ingrese la cantidad de numeros para su cola: ");
        num = sc.nextInt();
        operacionesCola.llenarCola(cola2, num, sc);
        compararFinalDeColas(cola,cola2);
        operacionesCola.mostrarCola(cola);
        operacionesCola.mostrarCola(cola2);


    }
    public void excecuteD(Scanner sc){
        ColaTDA cola = new ColaDinamica();
        OperacionesCola operacionesCola = new OperacionesCola();
        cola.inicializarCola();

        System.out.println("Ingrese la cantidad de numeros para su cola: ");
        int num = sc.nextInt();
        operacionesCola.llenarCola(cola, num, sc);
        invertirColaSinPila(cola);
        operacionesCola.mostrarCola(cola);


    }
    public void excecuteE(Scanner sc){
        ColaTDA cola = new ColaTDAImpl();
        OperacionesCola operacionesCola = new OperacionesCola();
        cola.inicializarCola();

        System.out.println("Ingrese la cantidad de numeros para su cola: ");
        int num = sc.nextInt();
        operacionesCola.llenarCola(cola, num, sc);
//        chequearCapicua(cola);
        ConjuntoTDA conjunto = conjuntoRepetidos(cola);
        OperacionesConjunto operacionesConjunto = new OperacionesConjunto();
        operacionesConjunto.mostrarConjunto(conjunto);
        eliminarRepetidos(cola);
        operacionesCola.mostrarCola(cola);
        ColaTDA cola2 = dividirColas(cola);
        operacionesCola.mostrarCola(cola);
        operacionesCola.mostrarCola(cola2);
    }
    public void excecuteF(Scanner sc){
        ColaTDA cola = new ColaDinamica();
        ColaTDA cola2 = new ColaDinamica();
        OperacionesCola operacionesCola = new OperacionesCola();
        cola.inicializarCola();
        cola2.inicializarCola();

        System.out.println("Ingrese la cantidad de numeros para su cola: ");
        int num = sc.nextInt();
        operacionesCola.llenarCola(cola, num, sc);
        System.out.println("Ingrese la cantidad de numeros para su cola: ");
        int num2 = sc.nextInt();
        operacionesCola.llenarCola(cola2, num2, sc);
        boolean respuesta = cheqeuarInversas(cola,cola2);
        if (respuesta){
            System.out.println("Es inversa.");
        }
        else {
            System.out.println("No es inversa.");
        }
        operacionesCola.mostrarCola(cola);
        operacionesCola.mostrarCola(cola2);
    }
    private void pasarCola(ColaTDA cola,ColaTDA cola2){
        while(!cola.colaVacia()){
            cola2.acolar(cola.primero());
            cola.desacolar();
        }
    }
    private void invertirColaConPila(ColaTDA cola,PilaTDA pilaAuxiliar){
        while(!cola.colaVacia()){
            pilaAuxiliar.apilar(cola.primero());
            cola.desacolar();
        }
        while(!pilaAuxiliar.pilaVacia()){
            cola.acolar(pilaAuxiliar.tope());
            pilaAuxiliar.desapilar();
        }
    }
    private void invertirColaSinPila(ColaTDA cola){
        if (!cola.colaVacia()) { // Paso 1: Verificar si la cola no está vacía
            int primero = cola.primero(); // Desencolamos el primer elemento
            cola.desacolar(); // Paso 1: Desacolar el primer elemento

            // Paso 2: Llamada recursiva para invertir el resto de la cola
            invertirColaSinPila(cola);

            // Paso 3: Encolar de nuevo el primer elemento al final
            cola.acolar(primero);
        }
    }
    private void compararFinalDeColas(ColaTDA cola, ColaTDA cola2){
        PilaTDA pilaAuxiliar1 = new PilaTDAImpl();
        PilaTDA pilaAuxiliar2 = new PilaTDAImpl();
        pilaAuxiliar1.inicializarPila();
        pilaAuxiliar2.inicializarPila();
        while(!cola.colaVacia()){
            pilaAuxiliar1.apilar(cola.primero());
            cola.desacolar();
        }
        while(!cola2.colaVacia()){
            pilaAuxiliar2.apilar(cola2.primero());
            cola2.desacolar();
        }
        if(pilaAuxiliar1.tope() == pilaAuxiliar2.tope()){
            System.out.println("Comparten el ultimo elemento");
        } else {
            System.out.println("No comparten el ultimo elemento.");
        }
        while(!pilaAuxiliar1.pilaVacia()){
            cola.acolar(pilaAuxiliar1.tope());
            pilaAuxiliar1.desapilar();
        }
        while(!pilaAuxiliar2.pilaVacia()){
            cola2.acolar(pilaAuxiliar2.tope());
            pilaAuxiliar2.desapilar();
        }
        invertirColaSinPila(cola);
        invertirColaSinPila(cola2);
    }
    private void chequearCapicua(ColaTDA cola){
        int contador = 0;
        ColaTDA colaAuxiliar = new ColaDinamica();
        PilaTDA pilaAuxiliar = new PilaTDAImpl();
        PilaTDA pila = new PilaTDAImpl();
        pilaAuxiliar.inicializarPila();
        colaAuxiliar.inicializarCola();
        pila.inicializarPila();

        while(!cola.colaVacia()){
            contador ++;
            colaAuxiliar.acolar(cola.primero());
            cola.desacolar();
        }
        while(!colaAuxiliar.colaVacia()){
            cola.acolar(colaAuxiliar.primero());
            colaAuxiliar.desacolar();
        }

        contador = contador /2;

        for (int i = 0; i < contador; i++) {
            colaAuxiliar.acolar(cola.primero());
            cola.desacolar();
        }

        while(!cola.colaVacia()){
            pilaAuxiliar.apilar(cola.primero());
            cola.desacolar();
        }
        while(!colaAuxiliar.colaVacia() && contador !=0 ){
            if (colaAuxiliar.primero() == pilaAuxiliar.tope()){
                cola.acolar(colaAuxiliar.primero());
                pila.apilar(pilaAuxiliar.tope());
                colaAuxiliar.desacolar();
                pilaAuxiliar.desapilar();
                contador--;
            }

            if ( contador == 0){
                System.out.println("Es capicua");
                break;
            }
            if (colaAuxiliar.primero() != pilaAuxiliar.tope()){
                System.out.println("No es capicua");
                break;
            }
        }
    }
    private boolean cheqeuarInversas(ColaTDA cola , ColaTDA cola2){
        boolean inversa = true;
        invertirColaSinPila(cola2);
        ColaTDA colaaux = new ColaDinamica();
        ColaTDA cola2aux = new ColaDinamica();
        OperacionesCola operacionesCola = new OperacionesCola();
        colaaux.inicializarCola();
        cola2aux.inicializarCola();
        while (!cola.colaVacia() && !cola2.colaVacia()){
            if (cola.primero() == cola2.primero()){
                colaaux.acolar(cola.primero());
                cola.desacolar();
                cola2aux.acolar(cola2.primero());
                cola2.desacolar();
            }
            else {
                inversa = false;
                break;
            }
        }
        while(!cola.colaVacia()){
            colaaux.acolar(cola.primero());
            cola.desacolar();
        }
        while(!cola2.colaVacia()){
            cola2aux.acolar(cola2.primero());
            cola2.desacolar();
        }
        while(!colaaux.colaVacia()){
            cola.acolar(colaaux.primero());
            colaaux.desacolar();
        }
        while(!cola2aux.colaVacia()){
            cola2.acolar(cola2aux.primero());
            cola2aux.desacolar();
        }
        invertirColaSinPila(cola2);
        return inversa;
    }
    private void eliminarRepetidos(ColaTDA cola){
        ColaTDA colaAux = new ColaTDAImpl();
        ConjuntoTDA conjunto = new ConjuntoTDAImpl();
        colaAux.inicializarCola();
        conjunto.inicializarConjunto();
        while(!cola.colaVacia()){
            int numero = cola.primero();
            cola.desacolar();
            if(!conjunto.pertenece(numero)){
                colaAux.acolar(numero);
                conjunto.agregar(numero);
            }
        }
        while(!colaAux.colaVacia()){
            cola.acolar(colaAux.primero());
            colaAux.desacolar();
        }
    }
    private ColaTDA dividirColas(ColaTDA cola){
        ColaTDA colaAux = new ColaTDAImpl();
        colaAux.inicializarCola();
        int contador = 0;
        while(!cola.colaVacia()){
            colaAux.acolar(cola.primero());
            cola.desacolar();
            contador++;
        }
        for(int i = 0; i < contador/2; i++){
            cola.acolar(colaAux.primero());
            colaAux.desacolar();
        }
        return colaAux;

    }
    private ConjuntoTDA conjuntoRepetidos(ColaTDA cola){
        ColaTDA colaAux = new ColaTDAImpl();
        ConjuntoTDA conjunto = new ConjuntoTDAImpl();
        ConjuntoTDA repetidos = new ConjuntoTDAImpl();
        colaAux.inicializarCola();
        conjunto.inicializarConjunto();
        repetidos.inicializarConjunto();
        while (!cola.colaVacia()){
            int numero = cola.primero();
            colaAux.acolar(cola.primero());
            cola.desacolar();
            if(!conjunto.pertenece(numero)) {
                conjunto.agregar(numero);
            }else{
                repetidos.agregar(numero);
            }
        }
        while(!colaAux.colaVacia()){
            cola.acolar(colaAux.primero());
            colaAux.desacolar();
        }
        return repetidos;
    }
}
