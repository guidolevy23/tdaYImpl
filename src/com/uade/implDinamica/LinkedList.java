package com.uade.implDinamica;
import com.uade.api.LinkedListTDA;

public class LinkedList implements LinkedListTDA {
    private Node first;
    private int size;

    @Override
    public void inicializarLinkedList() {
        this.size = 0;
    }

    @Override
    public void add(int value) {
        Node newNode = new Node(value,null);
        if (this.size == 0) {
            this.first = newNode;
        } else{
            Node current = this.first;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        this.size++;
    }

    @Override
    public void insert(int index, int value) {
        if(index <= size && index >= 0){
            if (index == 0){
                this.first = new Node(value,this.first);
                size++;
            } else{
                Node current = this.first;
                int counter = 0;
                while (counter != index){
                    current = current.getNext();
                    counter++;
                }
                Node newNode = new Node(value, current.getNext());
                current.setNext(newNode);
            }
        } else{
            System.out.println("Valor invalido de indice.");
        }
    }

    @Override
    public void remove(int index) {
        if(index <= size && index >= 0) {
            if (index == 0){
                this.first = this.first.getNext();
                this.size--;
            }else{
                Node current = this.first;
                Node previous = null;
                int counter = 0;
                while (counter != index){
                    previous = current;
                    current = current.getNext();
                    counter++;
                }
                previous.setNext(current.getNext());
                this.size--;
            }
        }else{
            System.out.println("Valor invalido de indice.");
        }
    }

    @Override
    public int get(int index) {
        if(index <= size && index >= 0){
            Node current = this.first;
            int counter = 0;
            while (counter != index){
                current = current.getNext();
                counter++;
            }
            return current.getValue();
        }
        return 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
}
