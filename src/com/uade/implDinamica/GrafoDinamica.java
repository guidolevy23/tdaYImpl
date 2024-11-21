package com.uade.implDinamica;

import com.uade.api.ConjuntoTDA;
import com.uade.api.GrafoTDA;
import com.uade.impl.ConjuntoTDAImpl;

public class GrafoDinamica implements GrafoTDA {
    // voy a crear una clase para las aristas y una clase para los vertices
    private class NodoAdyacente{
        int verticeDestino; //donde va  aapuntar mi arista
        int peso;
        NodoAdyacente siguiente;

        NodoAdyacente(int verticeDestino, int peso) {
            this.verticeDestino = verticeDestino;
            this.peso = peso;
            this.siguiente = null;
        }
    }

    private class NodoVertice{
        int vertice;
        NodoAdyacente adyacentes;
        NodoVertice siguiente;

        NodoVertice(int vertice) {
            this.vertice = vertice;
            this.adyacentes = null;
            this.siguiente = null;
        }
    }

    private NodoVertice vertices;


    @Override
    public void inicializarGrafo() {
        vertices = null;
    }

    @Override
    public void agregarVertice(int v) {
        //chequeo primero que no este, si ya esta hago return, sino creo un nuevo nodo con vertice V y lo pongo al principio y pongo que el siguiente al nuevo sea toca la lista de vertices. y pongo al nuevo como primero.
        NodoVertice actual = vertices;
        while (actual != null) {
            if(vertices.vertice == v){
                return;
            }
            actual = actual.siguiente;
        }
        NodoVertice nuevo = new NodoVertice(v);
        nuevo.siguiente = vertices;
        vertices = nuevo;
    }

    @Override
    public void eliminarVertice(int v) {
        NodoVertice previo = null;
        NodoVertice actual = vertices;
        while (actual != null && actual.vertice != v) {
            previo = actual;
            actual = actual.siguiente;
        }
        if(actual != null ){
            if (previo != null) {
                previo.siguiente = actual.siguiente;
            }else{
                vertices = actual.siguiente;
            }
            // ACA elimino las aristas que estan asociadas a ese vertice.

            //
        }
    }

    @Override
    public ConjuntoTDA vertices() {
        ConjuntoTDA conjunto = new ConjuntoTDAImpl();
        conjunto.inicializarConjunto();

        NodoVertice actual = vertices;
        while (actual != null) {
            conjunto.agregar(actual.vertice);
            actual = actual.siguiente;
        }
        return conjunto;
    }

    @Override
    public void agregarArista(int v1, int v2, int peso) {
        //chequeo que ambos vertices exista. y en caso de que existan los dos creo el nodoadyacente pasandole el destino y el peso. Al nuevoNodoAdyacente le digo que le sigan todos los adyasentes del orginen y le digo que la lista de adyacentes sea el nuevo nodo.//
        NodoVertice origen = vertices;
        NodoVertice destino = vertices;
        while (origen != null && origen.vertice != v1) {
            origen = origen.siguiente;
        }
        while(destino != null && destino.vertice != v2) {
            destino = destino.siguiente;
        }
        if(origen != null && destino != null){
            NodoAdyacente nuevoAdyacente = new NodoAdyacente(v2, peso);
            nuevoAdyacente.siguiente = origen.adyacentes;
            origen.adyacentes = nuevoAdyacente;
        }
    }

    @Override
    public void eliminarArista(int v1, int v2) {
        NodoVertice origen = vertices; // solo necesito al origen y despues chequear en sus adyacentes

        while (origen != null && origen.vertice != v1) {
            origen = origen.siguiente;
        }

        if(origen != null){
            NodoAdyacente anterior = null;
            NodoAdyacente actual = origen.adyacentes;
            while (actual != null && actual.verticeDestino != v2) {
                anterior = actual;
                actual = actual.siguiente;
            }
            if(actual != null){
                if(anterior != null){
                    anterior.siguiente = actual.siguiente;
                } else{
                    origen.adyacentes = actual.siguiente;
                }
            }
        }
    }

    @Override
    public boolean existeArista(int v1, int v2) {
        NodoVertice origen = vertices;
        while (origen != null && origen.vertice != v1) {
            origen = origen.siguiente;
        }
        if(origen != null){
            NodoAdyacente actual = origen.adyacentes;
            while (actual != null) {
                if (actual.verticeDestino == v2) {
                    return true;
                }
                actual = actual.siguiente;
            }
        }
        return false;
    }

    @Override
    public int pesoArista(int v1, int v2) {
        NodoVertice origen = vertices;
        while (origen != null && origen.vertice != v1) {
            origen = origen.siguiente;
        }
        if(origen != null){
            NodoAdyacente actual = origen.adyacentes;
            while (actual != null) {
                if (actual.verticeDestino == v2) {
                    return actual.peso;
                }
                actual = actual.siguiente;
            }
        }
        return -1;
    }
}
