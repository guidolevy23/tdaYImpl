package com.uade.implDinamica;
import com.uade.api.ColaPrioridadTDA;

public class ColaPrioridadesDinamica implements ColaPrioridadTDA {
    Node firstPrioridad;
    Node firstValor;
    @Override
    public void inicializarCola() {
        this.firstPrioridad = null;
        this.firstValor = null;
    }

    @Override
    public void acolarPrioridad(int x, int p) {
        Node nodo = new Node(p,null);
        Node nodoValor = new Node(x,null);

        if (this.firstPrioridad == null) {// 0
            this.firstPrioridad = nodo;
            this.firstValor = nodoValor;
            return;
        }
        if (this.firstPrioridad.getNext() == null){ //1
            if(this.firstPrioridad.getValue() < p){
                nodo.setNext(this.firstPrioridad);
                this.firstPrioridad = nodo;
                nodoValor.setNext(this.firstValor);
                this.firstValor = nodoValor;
                return;
            }
            this.firstPrioridad.setNext(nodo);
            this.firstValor.setNext(nodoValor);
            return;
        }

        Node currentPrioridad = this.firstPrioridad.getNext();
        Node previousPrioridad = this.firstPrioridad;
        Node currentValor = this.firstValor.getNext();
        Node previousValor = this.firstValor;

        if (this.firstPrioridad.getValue() < p) {
            this.firstPrioridad = nodo;
            this.firstValor = nodoValor;
            return;
        }

        while (currentPrioridad.getNext() != null) {
            if(currentPrioridad.getValue() < p){
                previousPrioridad.setNext(nodo);
                nodo.setNext(currentPrioridad);
                previousValor.setNext(nodoValor);
                nodoValor.setNext(currentValor);
                return;
            }
            previousPrioridad = currentPrioridad;
            currentPrioridad = currentPrioridad.getNext();
            previousValor = currentValor;
            currentValor = currentValor.getNext();
        }
        if (currentPrioridad.getValue() < p){
            previousPrioridad.setNext(nodo);
            nodo.setNext(currentPrioridad);
            previousValor.setNext(nodoValor);
            nodoValor.setNext(currentValor);
        }else{
            currentPrioridad.setNext(nodo);
            currentValor.setNext(nodoValor);
        }
    }

    @Override
    public void desacolar() {
        if (this.firstPrioridad != null) {
            this.firstPrioridad = this.firstPrioridad.getNext();
            this.firstValor = this.firstValor.getNext();
            return;
        }
        System.out.println("No se puede desacoalar una cola vacia.");
    }

    @Override
    public int primero() {
        if (this.firstPrioridad != null) {
            return this.firstValor.getValue();
        }
        System.out.println("No se puede mostrar el primer valor de una cola vacia.");
        return 0;
    }

    @Override
    public boolean colaVacia() {
        return firstPrioridad == null;
    }

    @Override
    public int prioridad() {
        if (this.firstPrioridad != null) {
            return this.firstPrioridad.getValue();
        }
        System.out.println("No hay prioridades porque esta vacia");
        return 0;
    }
}
