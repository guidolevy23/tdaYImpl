package com.uade.app;

import com.uade.Main;
import com.uade.api.ABBTDA;
import com.uade.api.ConjuntoTDA;
import com.uade.api.PilaTDA;
import com.uade.impl.ConjuntoTDAImpl;
import com.uade.impl.PilaTDAImpl;
import com.uade.implDinamica.ABBDinamica;
import com.uade.util.OperacionesConjunto;
import com.uade.util.OperacionesPila;

import java.util.Scanner;

public class AppABB {
    public static void main(String[] args) {
        AppABB app = new AppABB();
        app.excecute();
    }

    public void excecute() {
        ABBTDA arbol = new ABBDinamica();
        arbol.inicializarArbol();

        arbol.agregar(4);
        arbol.agregar(9);
        arbol.agregar(5);
        arbol.agregar(15);
        arbol.agregar(12);
        arbol.agregar(17);
        arbol.agregar(1);
        arbol.agregar(6);

        ABBTDA arbol2 = new ABBDinamica();
        arbol2.inicializarArbol();
        arbol2.agregar(4);
        arbol2.agregar(9);
        arbol2.agregar(5);
        arbol2.agregar(15);
        arbol2.agregar(12);
        arbol2.agregar(17);
        arbol2.agregar(1);

//        Scanner sc = new Scanner(System.in);
//        int valor = sc.nextInt();
//        int elemento = 0;
//        ABBTDA subarbol = buscarElemento(arbol, valor);
//        if (!subarbol.arbolVacio()){
//            elemento = elementoInmediatamenteMenor(arbol, valor, elemento);
//        }
//        System.out.println(elemento);
         /*
                   4
              1         9
                    5      15
                  6     12   17
        /
         */
        int[] cant = productoPorNivel(arbol, 1);
        System.out.println(cant[0]);
        System.out.println(cant[1]);

    }

    private ABBTDA buscarElemento(ABBTDA arbol, int elemento) {
        ABBTDA current = arbol;
        while (!current.arbolVacio()) {
            if (elemento == current.raiz()) {
                System.out.println("Elemento encontrado en el arbol.");
                return current;
            } else if (elemento > current.raiz()) {
                current = current.hijoDer();
            } else {
                current = current.hijoIzq();
            }
        }
        System.out.println("Elemento no encontrado en el arbol.");
        return current;
    }

    private void determinarSiEsHoja(ABBTDA arbol, int elemento) {
        ABBTDA subarbol = buscarElemento(arbol, elemento);
        if (subarbol.hijoIzq().arbolVacio() && subarbol.hijoDer().arbolVacio()) {
            System.out.println("Es una hoja.");
            return;
        }
        System.out.println("No es una hoja.");

    }

    private void profundidad(ABBTDA arbol, int elemento) {
        ABBTDA current = arbol;
        int contador = 1;
        ABBTDA subarbol = buscarElemento(arbol, elemento);
        if (!subarbol.arbolVacio()) {
            while (current.raiz() != elemento) {
                if (elemento > current.raiz()) {
                    current = current.hijoDer();
                } else {
                    current = current.hijoIzq();
                }
                contador++;
            }
            System.out.println("La profundidad es: " + contador);
        }
    }

    private void menorElemento(ABBTDA arbol) {
        ABBTDA current = arbol;
        while (!current.hijoIzq().arbolVacio()) {
            current = current.hijoIzq();
        }
        System.out.println("El menor valor es: " + current.raiz());
    }

    private int cantElementos(ABBTDA arbol) {
        if (arbol.arbolVacio()) {
            return 0; // Si está vacío, no hay elementos
        }
        // Suma 1 (por la raíz) más el conteo de los subárboles izquierdo y derecho
        return 1 + cantElementos(arbol.hijoIzq()) + cantElementos(arbol.hijoDer());
    }

    private int sumarElementos(ABBTDA arbol) {
        if (arbol.arbolVacio()) {
            return 0;
        }
        return arbol.raiz() + sumarElementos(arbol.hijoIzq()) + sumarElementos(arbol.hijoDer());
    }

    private int cantHojas(ABBTDA arbol) {
        if (arbol.arbolVacio()) {
            return 0; // Si está vacío, no hay elementos
        }
        if (arbol.hijoIzq().arbolVacio() && arbol.hijoDer().arbolVacio()) {
            return 1 + cantHojas(arbol.hijoIzq()) + cantHojas(arbol.hijoDer());
        }
        // Suma 1 (por la raíz) más el conteo de los subárboles izquierdo y derecho
        return cantHojas(arbol.hijoIzq()) + cantHojas(arbol.hijoDer());
    }

    private int alturaArbol(ABBTDA arbol, int elemento) {
        ABBTDA subarbol = buscarElemento(arbol, elemento);
        int altura = calculoAltura(subarbol);
        return altura;
    }

    private int calculoAltura(ABBTDA arbol) {
        if (arbol.arbolVacio()) {
            return 0;
        }
        int alturaIzq = calculoAltura(arbol.hijoIzq());
        int alturaDer = calculoAltura(arbol.hijoDer());
        return 1 + Math.max(alturaIzq, alturaDer);
    }

    private boolean arbolesMismaForma(ABBTDA arbol, ABBTDA arbol2) {
        if (arbol.arbolVacio() && arbol2.arbolVacio()) {
            return true;
        }
        if (arbol.arbolVacio() || arbol2.arbolVacio()) {
            return false;
        }
        return arbolesMismaForma(arbol.hijoIzq(), arbol2.hijoIzq()) && arbolesMismaForma(arbol.hijoDer(), arbol2.hijoDer());
    }

    private boolean arbolesIguales(ABBTDA arbol1, ABBTDA arbol2) {
        if (arbol1.raiz() == arbol2.raiz()) {
            return true;
        }
        if (arbol1.raiz() != arbol2.raiz()) {
            return false;
        }
        return arbolesIguales(arbol1.hijoIzq(), arbol2.hijoIzq()) && arbolesIguales(arbol1.hijoDer(), arbol2.hijoDer());
    }

    private int cantPorNivel(ABBTDA arbol, int nivel) {
        if (arbol.arbolVacio()) {
            return 0;
        }
        if (nivel == 0) {
            return 1;
        }
        return cantPorNivel(arbol.hijoIzq(), nivel - 1) + cantPorNivel(arbol.hijoDer(), nivel - 1);
    }

    private void mostrarInOrder(ABBTDA arbol) {
        if (arbol.arbolVacio()) {
            return;
        }
        // Recorrer el subárbol izquierdo
        mostrarInOrder(arbol.hijoIzq());

        // Procesar la raíz (imprimir el valor)
        System.out.print(arbol.raiz() + " ");

        mostrarInOrder(arbol.hijoDer());
    }

    private void mostrarPostOrder(ABBTDA arbol){
        if (arbol.arbolVacio()) {
            return;
        }
        mostrarPostOrder(arbol.hijoIzq());
        mostrarPostOrder(arbol.hijoDer());
        System.out.println(arbol.raiz() + " ");
    }

    private void mostrarPreOrder(ABBTDA arbol) {
        if (arbol.arbolVacio()) {
            return;
        }
        System.out.println(arbol.raiz() + " ");
        mostrarPreOrder(arbol.hijoIzq());
        mostrarPreOrder(arbol.hijoDer());
    }

    private void crearConjunto(ABBTDA arbol, ConjuntoTDA conjunto, int valor) {
        if (arbol.arbolVacio()) {
            return;
        }
        if (valor < arbol.raiz()){
            conjunto.agregar(arbol.raiz());
        }
        // Recorrer el subárbol izquierdo
        crearConjunto(arbol.hijoIzq(), conjunto, valor);

        // Procesar la raíz (imprimir el valor)

        crearConjunto(arbol.hijoDer(), conjunto, valor);
    }

    private int elementoInmediatamenteMenor(ABBTDA arbol, int valor, int elemento ){
        if (arbol.arbolVacio()) {
            return elemento ;
        }
        if (arbol.raiz() < valor && arbol.raiz() > elemento ) {
            elemento = arbol.raiz();
        }
        // Recorrer el subárbol izquierdo
        elemento = elementoInmediatamenteMenor(arbol.hijoIzq(), valor, elemento);


        elemento = elementoInmediatamenteMenor(arbol.hijoDer(), valor, elemento);

        return elemento;

    }

    private int contarElementosInternosSinRaiz(ABBTDA arbol){
        return contarElementosInternos(arbol) - 1;

    }

    private int contarElementosInternos(ABBTDA arbol){
        // aca me fijo que el arbol que estoy chequeando es vacio, osea es null la raiz, o que no tenga hijos osea sea una hoja. y devuelve 0 porque no suma si son hojas.
        if(arbol.arbolVacio() || (arbol.hijoDer().arbolVacio() && arbol.hijoIzq().arbolVacio())){
            return 0;
        }

        // aca voy a llegar lo mas a la izquierda abajo posible y de ahi voy a empezar a subir chequeando todos
        int contadorIzquierda = contarElementosInternos(arbol.hijoIzq());
        int contadorDerecha =  contarElementosInternos(arbol.hijoDer());

        if(!arbol.hijoIzq().arbolVacio() || !arbol.hijoDer().arbolVacio()){
            //aca en caso de que por lo menos tenga un hijo, a mi ya me consta para sumar 1 a ambos contadores.
            return contadorIzquierda + contadorDerecha + 1;
        } else{
            return contadorIzquierda + contadorDerecha;
        }
    }

    private boolean prefijoDelOtro(ABBTDA arbolPrefijo , ABBTDA arbol){
        //Si llego a que el arbol del prefijo esta vacio significa, que todo lo anterior es igual
        if(arbolPrefijo.arbolVacio()){
            return true;
        }
        // si el arbol con el que comparo, esta vacio significa que el prefijo es mayor, no puede ser.
        if(arbol.arbolVacio()){
            return false;
        }
        // y si uno de los valores es distinto ya no sera prefijo.
        if (arbolPrefijo.raiz() != arbol.raiz()){
            return false;
        }

        //chequeo ambos lados, el derecho y el izquierdo
        boolean prefijoIzq = prefijoDelOtro( arbolPrefijo.hijoIzq(), arbol.hijoIzq());
        boolean prefijoDer = prefijoDelOtro(arbolPrefijo.hijoDer(), arbol.hijoDer());

        //devuelvo la logica de si ambos son true es porque es todo true.
        return prefijoDer && prefijoIzq;

    }

    private int cantNodosPorNivel(ABBTDA arbol, int desde, int hasta){
    //previo a hacer recursividad tengoq que validar que le desde y el hasta sean validos.
        if(desde > hasta || desde <= 0 || hasta <= 0 || arbol.arbolVacio()){
            return 0;
        }
        return cantNodosRecursivo(arbol, 1, desde, hasta);
    }

    private int cantNodosRecursivo(ABBTDA arbol, int nivelActual, int desde, int hasta){
/*
                4
              1    9
                  5  15
                    12 17
        1 - 3
         */
        if(arbol.arbolVacio()){
            return 0;
        }
        int contador = 0;

        if(desde <= nivelActual && nivelActual <= hasta ){
            contador++;
        }

        contador += cantNodosRecursivo(arbol.hijoIzq(),nivelActual + 1,desde, hasta);
        contador += cantNodosRecursivo(arbol.hijoDer(),nivelActual + 1, desde, hasta);

        return contador;
    }

    private boolean existenDosNaturalesQueSumanN(ABBTDA arbol, int n){
        // para esto puedo crearun conjunto donde guarde todos los valores del arbol para poder recorrerlo mucho mas facil que un arbol para hacer calculos y demas.
        ConjuntoTDA conjunto = new ConjuntoTDAImpl();
        conjunto.inicializarConjunto();

        recorrerRecursivamente(arbol, conjunto);

        while(!conjunto.conjuntoVacio()){
            int numero = conjunto.elegir();
            if(conjunto.pertenece(n - numero)){
                return true;
            }
            conjunto.sacar(numero);
        }
        return false;



    }

    private void recorrerRecursivamente(ABBTDA arbol, ConjuntoTDA conjunto){
        if(arbol.arbolVacio()){
            return ;
        }
        conjunto.agregar(arbol.raiz());

        recorrerRecursivamente(arbol.hijoIzq(), conjunto);
        recorrerRecursivamente(arbol.hijoDer(), conjunto);
    }

    private int nivelMasNodos(ABBTDA arbol, int hasta){
        if(arbol.arbolVacio()){
            return 0;
        }

        int [] contador = new int[hasta];
        nivelMasNodosRecursivo(arbol, 1, hasta, contador);
        int nivelMaximo = Integer.MIN_VALUE;
        int maximo = Integer.MIN_VALUE;
        for(int i = 0; i < hasta; i++){
            if (contador[i] > maximo){
                maximo = contador[i];
                nivelMaximo = i + 1;

            }
        }
        return nivelMaximo;
    }

    private void nivelMasNodosRecursivo(ABBTDA arbol, int nivel, int hasta, int[] contador ){
         /*
                4
              1    9
               3  5  15
                    12 17
        /
         */
        if(nivel > hasta || arbol.arbolVacio()){
            return;
        }

        contador[nivel - 1]++;

        nivelMasNodosRecursivo(arbol.hijoDer(),nivel + 1, hasta , contador );
        nivelMasNodosRecursivo(arbol.hijoIzq(),nivel + 1, hasta, contador );

    }

    private PilaTDA pilaRamaMasLarga(ABBTDA arbol){
        PilaTDA pila = new PilaTDAImpl();
        pila.inicializarPila();

        if (arbol.arbolVacio()) return pila;

        obtenerRamaMasLarga(arbol, pila);

        return pila;

    }
    private int obtenerRamaMasLarga(ABBTDA arbol, PilaTDA pila){
        if (arbol.arbolVacio()){
            return 0 ;
        }
        pila.apilar(arbol.raiz());

        PilaTDA pilaIzq = new PilaTDAImpl();
        pilaIzq.inicializarPila();

        PilaTDA pilaDer  = new PilaTDAImpl();
        pilaDer.inicializarPila();

        int longitudIzq = obtenerRamaMasLarga(arbol.hijoIzq(),pilaIzq);
        int longitudDer = obtenerRamaMasLarga(arbol.hijoDer(),pilaIzq);

        OperacionesPila operacionesPila = new OperacionesPila();

        if(longitudIzq> longitudDer){
            operacionesPila.copiarPila(pilaIzq, pila);
        } else{
            operacionesPila.copiarPila(pilaDer,pila);
        }
        return Math.max(longitudIzq, longitudDer) + 1;

    }

    private int sumaRestaPorNivel(ABBTDA arbol, int nivel ){
        if(arbol.arbolVacio()){
            return 0;
        }
        int sumaYResta = 0;

        sumaYResta = nivel % 2 == 0 ? arbol.raiz() : -arbol.raiz();

        sumaYResta += sumaRestaPorNivel(arbol.hijoIzq(), nivel + 1);
        sumaYResta += sumaRestaPorNivel(arbol.hijoDer(), nivel + 1);

        return sumaYResta;


    }

    private int[] productoPorNivel(ABBTDA arbol, int nivel){
        if(arbol.arbolVacio()){
            return new int []{1,1};
        }
        int [] contador = new int[] {1,1};

        if(nivel % 2 == 0){
            contador[0] *= arbol.raiz();
        } else{
            contador[1] *= arbol.raiz();
        }
        contador[0] *= productoPorNivel(arbol.hijoIzq(), nivel + 1)[0];
        contador[0] *= productoPorNivel(arbol.hijoDer(), nivel + 1)[0];
        contador[1] *= productoPorNivel(arbol.hijoDer(), nivel + 1)[1];
        contador[1] *= productoPorNivel(arbol.hijoIzq(), nivel + 1)[1];

        return contador;
    }

    private void crearArbolPostOrder(int[] numeros, ABBTDA arbol){
        for(int i = numeros.length - 1; i>=0; i--){
            arbol.agregar(numeros[i]);
        }
    }

}

