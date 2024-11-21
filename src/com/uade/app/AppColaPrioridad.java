package com.uade.app;

import java.sql.SQLOutput;
import java.util.Scanner;

import com.uade.impl.DiccionarioSimpleTDAImpl;
import com.uade.implDinamica.DiccionarioSimpleDinamica;
import com.uade.api.DiccionarioSimpleTDA;
import com.uade.impl.ColaConPrioridadImpl;
import com.uade.implDinamica.ColaPrioridadesDinamica;
import com.uade.util.OperacionesColaPrioridad;
import com.uade.api.ColaPrioridadTDA;

public class AppColaPrioridad {
    public static void main(String[] args) {
        AppColaPrioridad appColaPrioridad = new AppColaPrioridad();
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el numero de operacion: ");
        int numero = sc.nextInt();
        switch (numero) {
            case 1:
                appColaPrioridad.excecute(sc);
                break;
            case 2:
                appColaPrioridad.excecuteB(sc);
                break;
        }
    }
    public void excecute(Scanner sc){
        ColaPrioridadTDA colaPrioridad = new ColaConPrioridadImpl();
        ColaPrioridadTDA colaPrioridad2 = new ColaConPrioridadImpl();
        ColaPrioridadTDA nuevaCola = new ColaConPrioridadImpl();
        OperacionesColaPrioridad operacionesColaPrioridad = new OperacionesColaPrioridad();
        colaPrioridad.inicializarCola();
        colaPrioridad2.inicializarCola();
        nuevaCola.inicializarCola();
        colaPrioridad.acolarPrioridad(4,5);
        colaPrioridad.acolarPrioridad(1,9);
        colaPrioridad.acolarPrioridad(7,2);
        colaPrioridad.acolarPrioridad(4,7);
        colaPrioridad.acolarPrioridad(2,8);
        colaPrioridad.acolarPrioridad(9,1);
        colaPrioridad.acolarPrioridad(6,6);
        operacionesColaPrioridad.mostrarCola(colaPrioridad);
        colaPrioridad2.acolarPrioridad(1,2);
        colaPrioridad2.acolarPrioridad(2,5);
        colaPrioridad2.acolarPrioridad(3,8);
        colaPrioridad2.acolarPrioridad(5,6);
        operacionesColaPrioridad.mostrarCola(colaPrioridad2);
        compararColas(colaPrioridad,colaPrioridad2);
        unirColas(colaPrioridad, colaPrioridad2, nuevaCola);
        operacionesColaPrioridad.mostrarCola(nuevaCola);
    }
    public void excecuteB(Scanner sc){
        ColaPrioridadTDA colaPrioridad = new ColaConPrioridadImpl();
        OperacionesColaPrioridad operacionesColaPrioridad = new OperacionesColaPrioridad();
        colaPrioridad.inicializarCola();
        colaPrioridad.acolarPrioridad(4,5);
        colaPrioridad.acolarPrioridad(1,9);
        colaPrioridad.acolarPrioridad(7,2);
        colaPrioridad.acolarPrioridad(4,7);
        colaPrioridad.acolarPrioridad(2,8);
        colaPrioridad.acolarPrioridad(9,0);
        colaPrioridad.acolarPrioridad(6,6);
        operacionesColaPrioridad.mostrarCola(colaPrioridad);
        generarDiccionario(colaPrioridad);
    }

    public void unirColas(ColaPrioridadTDA cola, ColaPrioridadTDA cola2 , ColaPrioridadTDA nuevaCola){
        int prioridad = Math.max(cola.prioridad(), cola2.prioridad());
        while(!cola.colaVacia() || !cola2.colaVacia()){
            if(cola.prioridad() == prioridad){
                int ingresar = cola.primero();
                int prioridadIngresar = cola.prioridad();
                nuevaCola.acolarPrioridad(ingresar, prioridadIngresar);
                cola.desacolar();
            }
            if(cola2.prioridad() == prioridad){
                int ingresar = cola2.primero();
                int prioridadIngresar = cola2.prioridad();
                nuevaCola.acolarPrioridad(ingresar, prioridadIngresar);
                cola2.desacolar();
            }
            prioridad --;
        }

    }
    public void compararColas(ColaPrioridadTDA cola, ColaPrioridadTDA cola2){
        ColaPrioridadTDA colaAuxiliar1 = new ColaConPrioridadImpl();
        ColaPrioridadTDA colaAuxiliar2 = new ColaConPrioridadImpl();
        colaAuxiliar1.inicializarCola();
        colaAuxiliar2.inicializarCola();
        while(!cola.colaVacia() && !cola2.colaVacia()){
            if(cola.prioridad() == cola2.prioridad() && cola.primero() == cola2.primero()){
                colaAuxiliar1.acolarPrioridad(cola.primero(),cola.prioridad());
                colaAuxiliar2.acolarPrioridad(cola2.primero(),cola2.prioridad());
                cola.desacolar();
                cola2.desacolar();
            } else{
                while(!colaAuxiliar1.colaVacia()){
                    cola.acolarPrioridad(colaAuxiliar1.primero(),colaAuxiliar1.prioridad());
                    cola2.acolarPrioridad(colaAuxiliar2.primero(),colaAuxiliar2.prioridad());
                    colaAuxiliar1.desacolar();
                    colaAuxiliar2.desacolar();
                }
                System.out.println("Colas no identicas.");
                return;
            }
        }
        System.out.println("Colas identicas.");
        while(!colaAuxiliar1.colaVacia()){
            cola.acolarPrioridad(colaAuxiliar1.primero(),colaAuxiliar1.prioridad());
            cola2.acolarPrioridad(colaAuxiliar2.primero(),colaAuxiliar2.prioridad());
            colaAuxiliar1.desacolar();
            colaAuxiliar2.desacolar();
        }
    }
    public void generarDiccionario(ColaPrioridadTDA cola){
        DiccionarioSimpleTDA diccionario = new DiccionarioSimpleDinamica();
        diccionario.InicializarDiccionario();
        while (!cola.colaVacia()){
            int prioridad = cola.prioridad();
            int valor = cola.primero();
            diccionario.Agregar(valor, prioridad);
            cola.desacolar();
        }
        diccionario.Claves();
        System.out.println(diccionario.Recuperar(4));

    }
}
