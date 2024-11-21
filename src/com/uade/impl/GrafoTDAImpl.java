package com.uade.impl;

import com.uade.api.ConjuntoTDA;
import com.uade.api.GrafoTDA;

public class GrafoTDAImpl implements GrafoTDA {
    private int [][] matrizAdyacencia;
    private int [] vertices;
    private int cantVertices;

    @Override
    public void inicializarGrafo() {
        matrizAdyacencia = new int[100][100];
        vertices = new int[100];
        cantVertices = 0;
    }

    @Override
    public void agregarVertice(int v) {
        if(cantVertices >= 99){
            System.out.println("No se pueden crear vertices. Lleno.");
            return;
        }
        for (int i = 0; i < cantVertices; i++) {
            if (vertices[i] == v) return;
        }
        vertices[cantVertices] = v;
        cantVertices++;
    }

    @Override
    public void eliminarVertice(int v) {
        int indice = -1; // lo preparo por si no lo encuentra
        for (int i = 0; i < cantVertices; i++) {
            if (vertices[i] == v) indice = i;
        }
        if (indice != -1 && cantVertices < 100) {
            for(int i = 0; i < cantVertices; i++){
                matrizAdyacencia[indice][i] = 0;
                matrizAdyacencia[i][indice] = 0;
            }
            for (int i = indice; i < cantVertices; i++) {
                vertices[i] = vertices[i + 1];
            }
            cantVertices--;
            return;
        }
        System.out.println("No existe.");
    }

    @Override
    public ConjuntoTDA vertices() {
        ConjuntoTDA conjuntoVertices = new ConjuntoTDAImpl();
        conjuntoVertices.inicializarConjunto();
        for (int i = 0; i < cantVertices; i++) {
            conjuntoVertices.agregar(vertices[i]);
        }
        return conjuntoVertices;
    }

    @Override
    public void agregarArista(int v1, int v2, int peso) {
        int f = -1;
        int c = -1;
        for (int i = 0; i < cantVertices; i++) {
            if (vertices[i] == v1) f = i;
            if (vertices[i] == v2) c = i;
        }
        if(f != -1 && c != -1){
            matrizAdyacencia[f][c] = peso;
        }
    }

    @Override
    public void eliminarArista(int v1, int v2) {
        int f = -1;
        int c = -1;
        for (int i = 0; i < cantVertices; i++) {
            if (vertices[i] == v1) f = i;
            if (vertices[i] == v2) c = i;
        }
        if(f != -1 && c != -1){
            matrizAdyacencia[f][c] = 0;
        }
    }

    @Override
    public boolean existeArista(int v1, int v2) {
        int f = -1;
        int c = -1;
        for (int i = 0; i < cantVertices; i++) {
            if (vertices[i] == v1) f = i;
            if (vertices[i] == v2) c = i;
        }
        if(f != -1 && c != -1) return matrizAdyacencia[f][c] != 0;

        return false;
    }

    @Override
    public int pesoArista(int v1, int v2) {
        int f = -1;
        int c = -1;
        for (int i = 0; i < cantVertices; i++) {
            if (vertices[i] == v1) f = i;
            if (vertices[i] == v2) c = i;
        }
        if(f != -1 && c != -1) return matrizAdyacencia[f][c];
        System.out.println("Uno o ambos vértices no existen.");
        return -1;
    }
}
