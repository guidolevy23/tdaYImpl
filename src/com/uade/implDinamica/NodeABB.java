package com.uade.implDinamica;

import com.uade.api.ABBTDA;

public class NodeABB {
    int value;
    NodeABB izq;
    NodeABB der;

    public NodeABB(int value, NodeABB izq,  NodeABB der) {
        this.value = value;
        this.izq = izq;
        this.der = der;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public NodeABB getIzq() {
        return izq;
    }

    public void setIzq(NodeABB izq) {
        this.izq = izq;
    }

    public NodeABB getDer() {
        return der;
    }

    public void setDer(NodeABB der) {
        this.der = der;
    }
}
