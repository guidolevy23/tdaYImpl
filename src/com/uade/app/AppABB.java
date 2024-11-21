package com.uade.app;

import com.uade.api.ABBTDA;
import com.uade.api.ConjuntoTDA;
import com.uade.impl.ConjuntoTDAImpl;
import com.uade.implDinamica.ABBDinamica;
import com.uade.util.OperacionesConjunto;

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
        ABBTDA arbol2 = new ABBDinamica();
        arbol2.inicializarArbol();
        arbol2.agregar(4);
        arbol2.agregar(9);
        arbol2.agregar(5);
        arbol2.agregar(15);
        arbol2.agregar(12);
        arbol2.agregar(17);
        arbol2.agregar(1);

        Scanner sc = new Scanner(System.in);
        int valor = sc.nextInt();
        int elemento = 0;
        ABBTDA subarbol = buscarElemento(arbol, valor);
        if (!subarbol.arbolVacio()){
            elemento = elementoInmediatamenteMenor(arbol, valor, elemento);
        }
        System.out.println(elemento);

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

}
