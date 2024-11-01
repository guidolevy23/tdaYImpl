package com.uade.implDinamica;
import com.uade.api.PilaTDA;


public class PilaDinamica implements PilaTDA {
    private Node first;
    @Override
    public void inicializarPila() {
        first = null;
    }

    @Override
    public void apilar(int x) {
        this.first = new Node(x,this.first);
    }

    @Override
    public void desapilar() {
        if (this.first != null) {
            this.first = this.first.getNext();
        } else{
            System.out.println("Pila Vacia, no se puede desapilar.");
        }
    }

    @Override
    public int tope() {
        if (this.first != null) {
            return this.first.getValue();
        }
        else{
            System.out.println("No se puede mostrar el tope de una pila vacia");
            return 0;
        }
    }

    @Override
    public boolean pilaVacia() {
        return this.first == null;
    }
}
