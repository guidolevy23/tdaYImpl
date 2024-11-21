package com.uade.app;
import com.uade.api.ColaTDA;
import com.uade.api.PilaTDA;
import com.uade.impl.ColaTDAImpl;
import com.uade.impl.ConjuntoTDAImpl;
import com.uade.impl.PilaTDAImpl;
import com.uade.implDinamica.ConjutoDinamica;
import com.uade.util.OperacionesConjunto;
import com.uade.api.ConjuntoTDA;

public class AppConjunto {
    public static void main(String[] args) {
        AppConjunto app = new AppConjunto();
        app.excecuteC();
    }
    public void excecute (){
        OperacionesConjunto op = new OperacionesConjunto();
        ConjuntoTDA operacion = new ConjuntoTDAImpl();
        ConjuntoTDA conjunto = new ConjuntoTDAImpl();
        ConjuntoTDA conjunto2 = new ConjuntoTDAImpl();
        conjunto2.inicializarConjunto();
        conjunto.inicializarConjunto();
        conjunto.agregar(5);
        conjunto.agregar(6);
        conjunto.agregar(7);
        conjunto.agregar(8);
        conjunto.agregar(4);
        conjunto.agregar(3);
        conjunto.agregar(3);

        conjunto2.agregar(5);
        conjunto2.agregar(6);
        conjunto2.agregar(9);
        conjunto2.agregar(10);
        conjunto2.agregar(8);
        op.mostrarConjunto(conjunto);
        op.mostrarConjunto(conjunto2);
        interseccion(conjunto, conjunto2,operacion);
        op.mostrarConjunto(operacion);
//        System.out.println("El conjunto esta vacio? " + conjunto.conjuntoVacio());
//        conjunto.sacar(8);
//        conjunto.elegir();
//        System.out.println("Pertenece el 10? " + conjunto.pertenece(10));
//        conjunto.agregar(8);
//        conjunto.agregar(9);
//        conjunto.agregar(10);
//        conjunto.agregar(8);
//        conjunto.agregar(9);
//        System.out.println("Pertenece el numero 8? " + conjunto.pertenece(8));
//        System.out.println("El numero elegido al azar: " + conjunto.elegir());
//        System.out.println("El conjunto esta vacio? " + conjunto.conjuntoVacio());
//        conjunto.sacar(8);
//        System.out.println("Pertenece el numero 8? " + conjunto.pertenece(8));
//        conjunto.sacar(7);
//        conjunto.agregar(8);
//        conjunto.sacar(8);
//        System.out.println("Pertenece el numero 8? " + conjunto.pertenece(8));
//        System.out.println("El numero elegido al azar: " + conjunto.elegir());
//        System.out.println("El numero elegido al azar: " + conjunto.elegir());
//        System.out.println("El numero elegido al azar: " + conjunto.elegir());
    }
    public void excecuteB(){
        OperacionesConjunto op = new OperacionesConjunto();
        ConjuntoTDA conjunto = new ConjuntoTDAImpl();
        ConjuntoTDA conjunto2 = new ConjuntoTDAImpl();
        conjunto.inicializarConjunto();
        conjunto2.inicializarConjunto();

        conjunto.agregar(5);
        conjunto.agregar(6);
        conjunto.agregar(7);
        conjunto.agregar(8);
        conjunto.agregar(4);
        conjunto.agregar(3);
        conjunto.agregar(3);

        conjunto2.agregar(5);
        conjunto2.agregar(6);
        conjunto2.agregar(9);
        conjunto2.agregar(10);
        conjunto2.agregar(8);
        cardinalidad(conjunto);
//        ConjuntoTDA diferencia = diferenciaSimetrica2(conjunto, conjunto2);
        conjuntosIguales(conjunto,conjunto2);
//        op.mostrarConjunto(diferencia);
    }
    public void excecuteC(){
        OperacionesConjunto op = new OperacionesConjunto();
        PilaTDA pila = new PilaTDAImpl();
        ColaTDA cola = new ColaTDAImpl();
        pila.inicializarPila();
        cola.inicializarCola();
        pila.apilar(1);
        pila.apilar(7);
        pila.apilar(6);
        pila.apilar(5);
        pila.apilar(4);

        cola.acolar(5);
        cola.acolar(35);
        cola.acolar(4);
        cola.acolar(73);
        cola.acolar(8);
        pilaColaIguales(pila,cola);
//        ConjuntoTDA conjunto = unionPilaCola(pila,cola);
//        op.mostrarConjunto(conjunto);
    }
    private void interseccion(ConjuntoTDA conjunto, ConjuntoTDA conjunto2, ConjuntoTDA interseccion) {
        ConjuntoTDA copia1 = new ConjuntoTDAImpl();
        ConjuntoTDA copia2 = new ConjuntoTDAImpl();
        interseccion.inicializarConjunto();
        copia1.inicializarConjunto();
        copia2.inicializarConjunto();
        while(!conjunto.conjuntoVacio()){
            int numero = conjunto.elegir();
            conjunto.sacar(numero);
            copia1.agregar(numero);
            if(conjunto2.pertenece(numero) && !interseccion.pertenece(numero)){
                interseccion.agregar(numero);
            }
        }
        while(!conjunto2.conjuntoVacio()){
            int numero = conjunto2.elegir();
            conjunto2.sacar(numero);
            copia2.agregar(numero);
            if(copia1.pertenece(numero) && !interseccion.pertenece(numero)){
                interseccion.agregar(numero);
            }
        }

    }
    private void union (ConjuntoTDA conjunto, ConjuntoTDA conjunto2, ConjuntoTDA union) {
        union.inicializarConjunto();
        ConjuntoTDA copia1 = new ConjuntoTDAImpl();
        ConjuntoTDA copia2 = new ConjuntoTDAImpl();
        copia1.inicializarConjunto();
        copia2.inicializarConjunto();
        while(!conjunto.conjuntoVacio()){
            int numero = conjunto.elegir();
            conjunto.sacar(numero);
            copia1.agregar(numero);
            if(!union.pertenece(numero)){
                union.agregar(numero);
            }
        }
        while(!copia1.conjuntoVacio()){
            int numero = copia1.elegir();
            conjunto.agregar(numero);
            copia1.sacar(numero);
        }
        while(!conjunto2.conjuntoVacio()){
            int numero = conjunto2.elegir();
            conjunto2.sacar(numero);
            copia2.agregar(numero);
            if(!union.pertenece(numero)){
                union.agregar(numero);
            }
        }
        while(!copia2.conjuntoVacio()){
            int numero = copia2.elegir();
            conjunto2.agregar(numero);
            copia2.sacar(numero);
        }
    }
    private void diferencia(ConjuntoTDA conjunto, ConjuntoTDA conjunto2 , ConjuntoTDA diferencia) {
        diferencia.inicializarConjunto();
        ConjuntoTDA copia1 = new ConjuntoTDAImpl();
        copia1.inicializarConjunto();
        while (!conjunto.conjuntoVacio()){
            int numero = conjunto.elegir();
            conjunto.sacar(numero);
            copia1.agregar(numero);
            if(!conjunto2.pertenece(numero)){
                diferencia.agregar(numero);
            }
        }
        while(!copia1.conjuntoVacio()){
            int numero = copia1.elegir();
            conjunto.agregar(numero);
            copia1.sacar(numero);
        }
    }
    private ConjuntoTDA diferenciaSimetrica1(ConjuntoTDA conjunto, ConjuntoTDA conjunto2) {
        ConjuntoTDA diferencia = new ConjuntoTDAImpl();
        diferencia.inicializarConjunto();
        while (!conjunto.conjuntoVacio()) {
            int numero = conjunto.elegir();
            conjunto.sacar(numero);
            if (!conjunto2.pertenece(numero)) {
                diferencia.agregar(numero);
            } else{
                conjunto2.sacar(numero);
            }
        }
        while (!conjunto2.conjuntoVacio()) {
            int numero = conjunto2.elegir();
            conjunto2.sacar(numero);
            diferencia.agregar(numero);
        }
        return diferencia;
    }
    private ConjuntoTDA diferenciaSimetrica2(ConjuntoTDA conjunto, ConjuntoTDA conjunto2){
        ConjuntoTDA diferencia1 = new ConjuntoTDAImpl();
        ConjuntoTDA diferencia2 = new ConjuntoTDAImpl();
        ConjuntoTDA diferenciaFinal = new ConjuntoTDAImpl();
        ConjuntoTDA union = new ConjuntoTDAImpl();
        union.inicializarConjunto();
        diferencia1.inicializarConjunto();
        diferencia2.inicializarConjunto();
        diferenciaFinal.inicializarConjunto();
        union(conjunto,conjunto2,union);
        diferencia(union,conjunto2,diferencia1);
        diferencia(union,conjunto, diferencia2);
        union(diferencia1,diferencia2,diferenciaFinal);
        return diferenciaFinal;
    }
    private void conjuntosIguales(ConjuntoTDA conjunto, ConjuntoTDA conjunto2){
        ConjuntoTDA diferencia = new ConjuntoTDAImpl();
        diferencia.inicializarConjunto();
        diferencia(conjunto,conjunto2,diferencia);
        if(diferencia.conjuntoVacio()){
            System.out.println("Conjuntos iguales");
        } else{
            System.out.println("Conjuntos diferentes");
        }
    }
    private void cardinalidad(ConjuntoTDA conjunto){
        ConjuntoTDA copia = new ConjuntoTDAImpl();
        copia.inicializarConjunto();
        int contador = 0;
        while (!conjunto.conjuntoVacio()) {
            int num = conjunto.elegir();
            conjunto.sacar(num);
            copia.agregar(num);
            contador++;
        }
        while(!copia.conjuntoVacio()){
            int num = copia.elegir();
            copia.sacar(num);
            conjunto.agregar(num);
        }
        System.out.println("Tiene: "+contador + " numeros");
    }
    private ConjuntoTDA unionPilaCola(PilaTDA pila, ColaTDA cola){
        ConjuntoTDA conjunto = new ConjuntoTDAImpl();
        conjunto.inicializarConjunto();
        while(!pila.pilaVacia()){
            conjunto.agregar(pila.tope());
            pila.desapilar();
        }
        while(!cola.colaVacia()){
            conjunto.agregar(cola.primero());
            cola.desacolar();
        }
        return conjunto;
    }
    private void pilaColaIguales(PilaTDA pila, ColaTDA cola){
        ConjuntoTDA conjuntoCola = new ConjuntoTDAImpl();
        conjuntoCola.inicializarConjunto();
        ConjuntoTDA conjuntoPila = new ConjuntoTDAImpl();
        conjuntoPila.inicializarConjunto();
        ConjuntoTDA diferencia = new ConjuntoTDAImpl();
        while(!pila.pilaVacia()){
            conjuntoPila.agregar(pila.tope());
            pila.desapilar();
        }
        while(!cola.colaVacia()){
            conjuntoCola.agregar(cola.primero());
            cola.desacolar();
        }
        diferencia(conjuntoPila,conjuntoCola,diferencia);
        if(diferencia.conjuntoVacio()){
            System.out.println("Pila y cola iguales");
        } else{
            System.out.println("Pila y cola diferentes");
        }
    }

}
