package com.uade.implDinamica;
import com.uade.api.ConjuntoTDA;
import com.uade.api.DiccionarioSimpleTDA;

public class DiccionarioSimpleDinamica implements DiccionarioSimpleTDA {
    Node firstNodeClave;
    Node firstNodeValor;
    ConjuntoTDA conjunto = new ConjutoDinamica();
    int size;
    @Override
    public void InicializarDiccionario() {
        conjunto.inicializarConjunto();
        firstNodeClave = null;
        firstNodeValor = null;
        size = 0;
    }

    @Override
    public void Agregar(int clave, int valor) {
        Node nodoClave = new Node(clave,null);
        Node nodoValor = new Node(valor,null);
        if (firstNodeClave == null) {
            firstNodeClave = nodoClave;
            firstNodeValor = nodoValor;
            size++;
            conjunto.agregar(clave);
            return;
        }
        if (firstNodeClave.getNext() == null) {
            if (firstNodeClave.getValue() == clave) {
                firstNodeValor.setValue(valor);
            }else {
                firstNodeClave.setNext(nodoClave);
                firstNodeValor.setNext(nodoValor);
                conjunto.agregar(clave);
                size++;
            }
            return;
        }
        Node currentClave = firstNodeClave.getNext();
        Node currentValor = firstNodeValor.getNext();
        Node previousClave = firstNodeClave;
        Node previousValor = firstNodeValor;

        if(firstNodeClave.getNext() != null && firstNodeClave.getValue() == clave) {
            firstNodeValor.setValue(valor);
            return;
        }
        while (currentClave != null){
            if (currentClave.getValue() == clave) {
                currentValor.setValue(valor);
                return;
            }
            previousClave = currentClave;
            currentClave = currentClave.getNext();
            previousValor = currentValor;
            currentValor = currentValor.getNext();
        }
        previousClave.setNext(nodoClave);
        previousValor.setNext(nodoValor);
        conjunto.agregar(clave);
        size++;
    }

    @Override
    public void Eliminar(int clave) {
        Node nodoClave = new Node(clave,null);

        if (firstNodeClave == null) {
            System.out.println("No se pudo eliminar la clave, diccionario vacio.");
            return;
        }
        if (firstNodeClave.getNext() == null){
            if(firstNodeClave.getValue() == clave){
                firstNodeClave = null;
                firstNodeValor = null;
                conjunto.sacar(clave);
                size--;
            } else{
                System.out.println("No se encontro la clave.");
            }
            return;
        }

        Node currentClave = firstNodeClave.getNext();
        Node currentValor = firstNodeValor.getNext();
        Node previousClave = firstNodeClave;
        Node previousValor = firstNodeValor;
        if(firstNodeClave.getValue() == clave){
            firstNodeClave = firstNodeClave.getNext();
            firstNodeValor = firstNodeValor.getNext();
            conjunto.sacar(clave);
            size--;
            return;
        }
        while (currentClave != null){
            if (currentClave.getValue() == clave) {
                previousClave.setNext(currentClave.getNext());
                previousValor.setNext(currentValor.getNext());
                conjunto.sacar(clave);
                size--;
                return;
            }
            previousClave = currentClave;
            currentClave = currentClave.getNext();
            previousValor = currentValor;
            currentValor = currentValor.getNext();
        }
    }

    @Override
    public int Recuperar(int clave) {
        if (firstNodeClave == null) {
            System.out.println("No se puede recuperar la clave, diccionario vacio.");
            return-1;
        }
        if (firstNodeClave.getNext() == null){
            if (firstNodeClave.getValue() == clave){
                return firstNodeValor.getValue();
            }
            return -1;
        }

        Node currentClave = firstNodeClave.getNext();
        Node currentValor = firstNodeValor.getNext();
        if(firstNodeClave.getValue() == clave){
            return firstNodeValor.getValue();
        }
        while (currentClave != null){
            if (currentClave.getValue() == clave){
                return currentValor.getValue();
            }
            currentClave = currentClave.getNext();
            currentValor = currentValor.getNext();
        }
        return -1;
    }

    @Override
    public ConjuntoTDA Claves() {
        if(firstNodeClave == null){
            System.out.println("No se pude devolver las claves, esta vacio.");
            return null;
        }
        Node currentClave = firstNodeClave;
        System.out.println("Claves:");
        while(currentClave != null){
            System.out.println(currentClave.getValue());
            currentClave = currentClave.getNext();
        }
        return conjunto;
    }
}
