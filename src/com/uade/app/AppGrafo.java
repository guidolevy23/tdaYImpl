package com.uade.app;

import com.uade.api.ConjuntoTDA;
import com.uade.api.GrafoTDA;
import com.uade.impl.ConjuntoTDAImpl;
import com.uade.impl.GrafoTDAImpl;
import com.uade.util.OperacionesConjunto;

public class AppGrafo {
    public static void main(String[] args) {
        GrafoTDA grafo = new GrafoTDAImpl();
        grafo.inicializarGrafo();

        // Agregar vértices
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        grafo.agregarVertice(5);
        grafo.agregarVertice(6);

        // Agregar aristas con pesos
        grafo.agregarArista(1, 2, 10);
        grafo.agregarArista(1, 3, 5);
        grafo.agregarArista(2, 5, 8);
        grafo.agregarArista(3, 5, 7);
        grafo.agregarArista(3, 6, 3);

        AppGrafo appGrafo = new AppGrafo();
        OperacionesConjunto operacionesConjunto = new OperacionesConjunto();
        ConjuntoTDA conjunto = appGrafo.conjuntoVerticesAdyacentesDobles(grafo,1);
        operacionesConjunto.mostrarConjunto(conjunto);
        appGrafo.mayorPesoArista(grafo,1);
        conjunto = appGrafo.verticesAislados(grafo);
        operacionesConjunto.mostrarConjunto(conjunto);
        conjunto = appGrafo.verticesPuente(grafo,1,6);
        operacionesConjunto.mostrarConjunto(conjunto);
        appGrafo.gradoVertice(grafo,2);
    }
    public ConjuntoTDA conjuntoVerticesAdyacentesDobles(GrafoTDA grafo, int v) {
        ConjuntoTDA conjuntoVerticesDobles = new ConjuntoTDAImpl();
        conjuntoVerticesDobles.inicializarConjunto();
        ConjuntoTDA conjuntoVertices = grafo.vertices();
        if(!conjuntoVertices.conjuntoVacio() && conjuntoVertices.pertenece(v)) {
            while(!conjuntoVertices.conjuntoVacio()){
                int x = conjuntoVertices.elegir();
                conjuntoVertices.sacar(x);

                if(grafo.existeArista(v, x)){
                    ConjuntoTDA subVertices = grafo.vertices();
                    while(!subVertices.conjuntoVacio()){
                        int w = subVertices.elegir();
                        subVertices.sacar(w);
                        if(grafo.existeArista(x, w)){
                            conjuntoVerticesDobles.agregar(w);
                        }
                    }
                }
            }
        }
        return conjuntoVerticesDobles;
    }
    public void mayorPesoArista (GrafoTDA grafo, int v){
        ConjuntoTDA conjuntoVertices = grafo.vertices();
        int peso = -1;
        if(!conjuntoVertices.conjuntoVacio() && conjuntoVertices.pertenece(v)) {
            while (!conjuntoVertices.conjuntoVacio()) {
                int x = conjuntoVertices.elegir();
                conjuntoVertices.sacar(x);
                if(grafo.existeArista(v, x)){
                    if( peso < grafo.pesoArista(v, x)){
                        peso = grafo.pesoArista(v, x);
                    }
                }
            }
            System.out.println("El peso mayor: " + peso);
            return;
        }
        System.out.println("No se encontro el vertice.");
    }
    public ConjuntoTDA predecesores(GrafoTDA grafo, int v) {
        ConjuntoTDA conjuntoPredecesores = new ConjuntoTDAImpl();
        conjuntoPredecesores.inicializarConjunto();
        ConjuntoTDA conjuntoVertices = grafo.vertices();
        if(!conjuntoVertices.conjuntoVacio() && conjuntoVertices.pertenece(v)) {
            while (!conjuntoVertices.conjuntoVacio()) {
                int x = conjuntoVertices.elegir();
                conjuntoVertices.sacar(x);
                if (grafo.existeArista(x, v)) {
                    conjuntoPredecesores.agregar(x);
                }
            }
        }
        return conjuntoPredecesores;
    }
    public ConjuntoTDA verticesAislados(GrafoTDA grafo) {
        ConjuntoTDA conjuntoVertices = grafo.vertices();
        ConjuntoTDA conjuntoAislados = new ConjuntoTDAImpl();
        conjuntoAislados.inicializarConjunto();
        while(!conjuntoVertices.conjuntoVacio()) {
            int x = conjuntoVertices.elegir();
            conjuntoVertices.sacar(x);

            ConjuntoTDA subVertices = grafo.vertices();

            while(!subVertices.conjuntoVacio()){
                int w = subVertices.elegir();
                if(grafo.existeArista(x, w) || grafo.existeArista(w, x)){
                    break;
                }
                subVertices.sacar(w);
            }
            if(subVertices.conjuntoVacio()){
                conjuntoAislados.agregar(x);
            }

        }
        return conjuntoAislados;
    }
    public ConjuntoTDA verticesPuente(GrafoTDA grafo, int v1, int v2) {
        ConjuntoTDA conjuntoPuente = new ConjuntoTDAImpl();
        conjuntoPuente.inicializarConjunto();
        ConjuntoTDA conjuntoVertices = grafo.vertices();
        if(conjuntoVertices.pertenece(v1) && conjuntoVertices.pertenece(v2) && v1 != v2){
            while(!conjuntoVertices.conjuntoVacio()) {
                int x = conjuntoVertices.elegir();
                conjuntoVertices.sacar(x);
                if (grafo.existeArista(v1, x) && grafo.existeArista(x,v2)) {
                    conjuntoPuente.agregar(x);
                }
            }
        }
        return conjuntoPuente;
    }
    public void gradoVertice(GrafoTDA grafo, int v) {
        ConjuntoTDA conjuntoVertices = grafo.vertices();
        int entradas = 0;
        int salidas = 0;
        if(conjuntoVertices.pertenece(v)){
            while(!conjuntoVertices.conjuntoVacio()) {
                int x = conjuntoVertices.elegir();
                conjuntoVertices.sacar(x);
                if (grafo.existeArista(x, v)) {
                    entradas++;
                }
                if (grafo.existeArista(v, x)) {
                    salidas++;
                }
            }
            System.out.println("El grado es:" + (salidas - entradas));
        }
    }
}
