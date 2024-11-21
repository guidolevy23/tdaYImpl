package com.uade.implDinamica;
import com.uade.api.ColaTDA;



public class ColaDinamica implements ColaTDA{
    private Node first;
    @Override
    public void inicializarCola() {
        this.first = null;
    }

    @Override
    public void acolar(int x) {
        if(this.first == null) {
            this.first = new Node(x,null);
            return;
        }
        Node current = this.first;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(new Node(x,null));

    }

    @Override
    public void desacolar() {
        if (this.first == null) {
            System.out.println("No se puede desacolar, cola vacia.");
            return;
        }
        this.first = this.first.getNext();
    }

    @Override
    public int primero() {
        if (this.first == null) {
            System.out.println("No se puede mostrar el primero, cola vacia.");
            return 0;
        }
        return this.first.getValue();
    }

    @Override
    public boolean colaVacia() {
        return this.first == null;
    }
}
