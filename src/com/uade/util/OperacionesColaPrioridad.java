package com.uade.util;

import com.uade.impl.ColaConPrioridadImpl;
import com.uade.implDinamica.ColaPrioridadesDinamica;
import com.uade.api.ColaPrioridadTDA;
import java.util.Scanner;

public class OperacionesColaPrioridad {
    public void mostrarCola(ColaPrioridadTDA cola) {
        String mostrar = "Cola: ";
        ColaPrioridadTDA auxiliar = new ColaPrioridadesDinamica();
        auxiliar.inicializarCola();
        while(!cola.colaVacia()){
            int prioridad = cola.prioridad();
            int primero = cola.primero();
            auxiliar.acolarPrioridad(primero,prioridad);
            cola.desacolar();
            if (primero != -1){
                mostrar = mostrar + primero + " ";
            }
        }
        while(!auxiliar.colaVacia()){
            int prioridad = auxiliar.prioridad();
            int primero = auxiliar.primero();
            cola.acolarPrioridad(primero,prioridad);
            auxiliar.desacolar();
        }
        System.out.println(mostrar);
    }
}
