package com.uade.implDinamica;
import com.uade.api.ConjuntoTDA;
import com.uade.api.DiccionarioMultipleTDA;

public class DiccionarioMultipleDinamica implements DiccionarioMultipleTDA {
    private NodeDicMultiple first;
    ConjuntoTDA conjuntoClaves;

    @Override
    public void inicializarDiccionario() {
        first = null;
        conjuntoClaves = new ConjutoDinamica();
    }

    @Override
    public void agregar(int clave, int valor) {
        if (first == null) {
            ConjuntoTDA conjunto = new ConjutoDinamica();
            conjunto.agregar(valor);
            conjuntoClaves.agregar(clave);
            first = new NodeDicMultiple(clave,conjunto,null);
            return;
        }
        if(first.getNext() == null) {
            if (first.getKey() == clave){
                first.getValue().agregar(valor);
            }
            else {
                ConjuntoTDA conjunto = new ConjutoDinamica();
                conjunto.agregar(valor);
                conjuntoClaves.agregar(clave);
                first.setNext(new NodeDicMultiple(clave,conjunto,null));
            }
            return;
        }
        if (first.getKey() == clave){
            first.getValue().agregar(valor);
            return;
        }
        NodeDicMultiple current = first.getNext();
        NodeDicMultiple previous = first;
        while (current != null){
            if (current.getKey() == clave){
                current.getValue().agregar(valor);
                return;
            }
            previous = current;
            current = current.getNext();

        }
        ConjuntoTDA conjunto = new ConjutoDinamica();
        conjunto.inicializarConjunto();
        conjunto.agregar(valor);
        previous.setNext(new NodeDicMultiple(clave,conjunto,null));
        conjuntoClaves.agregar(clave);
    }

    @Override
    public void eliminar(int clave) {
        if (first == null) {
            System.out.println("No se puede eliminar esa clave porque el diccionario esta vacio.");
            return;
        }
        if (first.getNext() == null) {
            if (first.getKey() == clave){
                first = null;
                conjuntoClaves.sacar(clave);
            }
            System.out.println("Clave erronea.");
            return;
        }

        if (first.getKey() == clave){
            first = first.getNext();
            conjuntoClaves.sacar(clave);
        }
        NodeDicMultiple current = first.getNext();
        NodeDicMultiple previous = first;
        while (current != null){
            if (current.getKey() == clave){
                previous.setNext(current.getNext());
                conjuntoClaves.sacar(clave);
                return;
            }
            previous = current;
            current = current.getNext();
        }
    }

    @Override
    public void eliminarValor(int clave, int valor) {
        if (first == null) {
            System.out.println("No se puede eliminar esa clave porque el diccionario esta vacio.");
            return;
        }

        if (first.getNext() == null) {
            if (first.getKey() == clave && first.getValue().pertenece(valor)){
                first.getValue().sacar(valor);
                return;
            }
            System.out.println("Clave y/o valor no encontrados.");
            return;
        }

        if (first.getKey() == clave && first.getValue().pertenece(valor)){
            first.getValue().sacar(valor);
            return;
        }
        NodeDicMultiple current = first.getNext();
        while (current != null){
            if (current.getKey() == clave && current.getValue().pertenece(valor)){
                current.getValue().sacar(valor);
                return;
            }
            current = current.getNext();
        }
    }

    @Override
    public ConjuntoTDA recuperar(int clave) {
        if (first == null) {
            return null;
        }
        if (first.getNext() == null) {
            if (first.getKey() == clave){
                return first.getValue();
            }
            return null;
        }
        if (first.getKey() == clave){
            return first.getValue();
        }
        NodeDicMultiple current = first.getNext();
        while (current != null){
            if (current.getKey() == clave){
                return current.getValue();
            }
            current = current.getNext();
        }
        return null;
    }

    @Override
    public ConjuntoTDA claves() {
        return conjuntoClaves;
    }
}
