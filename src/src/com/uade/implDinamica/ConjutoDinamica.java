package com.uade.implDinamica;
import com.uade.api.ConjuntoTDA;

import java.util.Random;

public class ConjutoDinamica implements ConjuntoTDA {
    Node firstNode;
    int count;
    Random random = new Random();
    @Override
    public void inicializarConjunto() {
        firstNode = null;
        count = 0;
    }

    @Override
    public void agregar(int x) {
        Node nodo = new Node(x,null);
        if (firstNode == null) { //0
            firstNode = nodo;
            count++;
            return;
        }
        if (firstNode.getNext() == null && firstNode.getValue() != x){ //1
            firstNode.setNext(nodo);
            count++;
            return;
        }else{
            System.out.println("Valor repetido en el conjunto");
        }


        Node current = firstNode;
        while(current.getNext()!=null){
            if(x == current.getValue()){
                System.out.println("Valor repetido en el conjunto");
                return;
            }
            current = current.getNext();
        }
        if(x == current.getValue()){
            System.out.println("Valor repetido en el conjunto");
            return;
        }
        current.setNext(nodo);
        count++;
    }

    @Override
    public int elegir() {
        Node current = firstNode;
        if (count > 0 && firstNode != null) {
            int num = random.nextInt(count);
            for (int i = 1; i <= num; i++) {
                current = current.getNext();
            }
            return current.getValue();
        }
        System.out.println("Conjunto vacio, no se puede elegir.");
        return -1;
    }

    @Override
    public void sacar(int x) {
        if (firstNode == null || firstNode.getNext() == null && firstNode.getValue() != x) return;

        if ( firstNode.getNext() == null && firstNode.getValue() == x) {
                firstNode = null;
                count--;
                return;
        }

        if (firstNode.getValue() == x){
            firstNode = firstNode.getNext();
            count--;
            return;
        }

        Node current = firstNode.getNext();
        Node previous = firstNode;
        while (current != null) {
            if (current.getValue() == x) {
                previous.setNext(current.getNext());
                count--;
                return;
            }
            previous = current;
            current = current.getNext();
        }
    }

    @Override
    public boolean pertenece(int x) {
        if(firstNode == null ) return false;

        if(firstNode.getNext() == null && firstNode.getValue() != x) return false;

        Node current = firstNode.getNext();
        while (current != null) {
            if (current.getValue() == x) return true;
            current = current.getNext();
        }
        return false;
    }

    @Override
    public boolean conjuntoVacio() { return firstNode == null;}

}
