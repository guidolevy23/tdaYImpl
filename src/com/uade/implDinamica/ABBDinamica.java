package com.uade.implDinamica;

import com.uade.api.ABBTDA;

public class ABBDinamica implements ABBTDA {
    NodeABB raiz;

    @Override
    public void inicializarArbol() {
        raiz = null;
    }

    @Override
    public int raiz() {
        if (raiz == null) {
            throw new IllegalStateException("Arbol vacio.");
        }
        return raiz.getValue();
    }

    @Override
    public ABBTDA hijoIzq() {
        if (raiz == null || raiz.getIzq() == null) {
            ABBTDA subArbolIzq = new ABBDinamica();
            subArbolIzq.inicializarArbol();
            return subArbolIzq;
        }
        ABBTDA subArolIzq = new ABBDinamica();
        subArolIzq.inicializarArbol();
        ((ABBDinamica)subArolIzq).raiz = raiz.getIzq();
        return subArolIzq;
    }

    @Override
    public ABBTDA hijoDer() {
        if (raiz == null || raiz.getDer() == null) {
            ABBTDA subArbolDer = new ABBDinamica();
            subArbolDer.inicializarArbol();
            return subArbolDer;
        }
        ABBTDA subArolDer = new ABBDinamica();
        subArolDer.inicializarArbol();
        ((ABBDinamica)subArolDer).raiz = raiz.getDer();
        return subArolDer;
    }

    @Override
    public void agregar(int x) {
        if (raiz == null) {
            NodeABB nodo = new NodeABB(x, null, null);
            raiz = nodo;
            return;
        }
        NodeABB current = raiz;
        while(true){
            if (x < current.getValue()) {
                if (current.getIzq() == null) {
                    NodeABB nodo = new NodeABB(x,null,null);
                    current.setIzq(nodo);
                    return;
                }
                current = current.getIzq();
            } else if (x > current.getValue() ) {
                if(current.getDer() == null){
                    NodeABB nodo = new NodeABB(x,null,null);
                    current.setDer(nodo);
                    return;
                }
                current = current.getDer();
            } else{
                System.out.println("El valor ya existe en el arbol");
                return;
            }
        }
    }

    @Override
    public void eliminar(int x) {
        if (raiz == null) {
            throw new IllegalStateException("Arbol vacio.");
        }
        NodeABB current = raiz;
        NodeABB previous = null;
        // primero hago una busqueda
        while (current != null && current.getValue() != x) {
            previous = current;
            if (x < current.getValue()) {
                current = current.getIzq();
            } else {
                current = current.getDer();
            }
        }

        if (current == null) {
            System.out.println("El valor no está en el árbol.");
            return;
        }
        // si lo encuentra ya voy a tener el valor de current el nodo que necesito.

        if (current.getIzq() == null && current.getDer() == null) {
            if(previous == null){ //me fijo si el arbol solo tiene un valor y lo elimino.
                raiz = null;
            } else if(previous.getIzq() == current){
                previous.setIzq(null);
            } else{
                previous.setDer(null);
            }
            return;
        }

        //si tiene un solo hijo como ya damos por hecho arriba que es una hoja porque tiene ambos nulos, aca unicamente entra si el caso es de que por lo menos tiene un solo hijo.
        if(current.getIzq() == null || current.getDer() == null){
            // pregunto si tengo algo a la izquierda sino hago derecha.
            NodeABB hijo = (current.getIzq() != null) ? current.getIzq() : current.getDer();
            if(previous == null){
                raiz = hijo;
            } else if (previous.getIzq() == current) {
                previous.setIzq(hijo);
            } else{
                previous.setDer(hijo);
            }
            return;

        }
        // nodo con dos hijos
            // encuentro el menor del sub arbol derecho
        NodeABB sucessorParent = current;
        NodeABB sucessor = current.getDer();
        while(sucessor.getIzq() != null){
            sucessorParent = sucessor;
            sucessor = sucessorParent.getIzq();
        }
        // reeplazo el valor del nodo actual (el current) con el valor del sucesor
        current.setValue(sucessor.getValue());

        // elimino el sucesor
        if(sucessorParent.getIzq() == sucessor){
            sucessorParent.setIzq(sucessor.getDer());
        }else{
            sucessorParent.setDer(sucessor.getDer());
        }
    }

    @Override
    public boolean arbolVacio() {
        return raiz == null;
    }
}
