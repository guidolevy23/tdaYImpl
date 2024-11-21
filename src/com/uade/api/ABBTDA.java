package com.uade.api;

import com.uade.implDinamica.NodeABB;

public interface ABBTDA {
    //Inicializar estructura
    void inicializarArbol();

    //Me permite obtener el valor del nodo
    int raiz();

    //Obtengo el arbol izquierdo
    ABBTDA hijoIzq();

    //Obtengo el arbol derecho
    ABBTDA hijoDer();

    //Metodo para agregar datos
    void agregar(int x);

    //Metodo para eliminar datos
    void eliminar(int x);

    // Saber si la estructura esta vacia o no
    boolean arbolVacio();

}
