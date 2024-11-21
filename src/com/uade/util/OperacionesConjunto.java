package com.uade.util;
import com.uade.impl.ConjuntoTDAImpl;
import com.uade.api.ConjuntoTDA;

public class OperacionesConjunto {
    public void mostrarConjunto(ConjuntoTDA conjunto){
        if(conjunto!=null) {
            ConjuntoTDA auxiliar = new ConjuntoTDAImpl();
            auxiliar.inicializarConjunto();
            System.out.println("Conjunto:");
            while (!conjunto.conjuntoVacio()) {
                int numero = conjunto.elegir();
                conjunto.sacar(numero);
                auxiliar.agregar(numero);
                System.out.println(numero);
            }
            while (!auxiliar.conjuntoVacio()) {
                int numero = auxiliar.elegir();
                auxiliar.sacar(numero);
                conjunto.agregar(numero);
            }
            System.out.println("---------------------------");
        } else{
            System.out.println("No se puede imprimir ese conjunto");
        }
    }
}
