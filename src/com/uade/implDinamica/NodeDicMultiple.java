package com.uade.implDinamica;
import com.uade.api.ConjuntoTDA;

public class NodeDicMultiple {
    private int key;
    private ConjuntoTDA value;
    private NodeDicMultiple next;

    public NodeDicMultiple(int key, ConjuntoTDA value, NodeDicMultiple next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
    public int getKey() {
        return key;
    }
    public void setKey(int key) {
        this.key = key;
    }
    public ConjuntoTDA getValue() {
        return value;
    }
    public void setValue(ConjuntoTDA value) {
        this.value = value;
    }
    public NodeDicMultiple getNext() {
        return next;
    }
    public void setNext(NodeDicMultiple next) {
        this.next = next;
    }
}
