package com.uade;
import com.uade.api.ConjuntoTDA;
import com.uade.api.DiccionarioMultipleTDA;
import com.uade.implDinamica.DiccionarioMultipleDinamica;
import com.uade.util.OperacionesConjunto;

public class Main {
    public static void main(String[] args){
        Main main = new Main();
        DiccionarioMultipleTDA dic1 = new DiccionarioMultipleDinamica();
        DiccionarioMultipleTDA dic2 = new DiccionarioMultipleDinamica();
        DiccionarioMultipleTDA dicUnion = new DiccionarioMultipleDinamica();
        dic1.inicializarDiccionario();
        dic2.inicializarDiccionario();
        dicUnion.inicializarDiccionario();
        dic1.agregar(1,30);
        dic1.agregar(2,4);
        dic1.agregar(3,58);
        dic1.agregar(4,2);
        dic1.agregar(5,1);
        dic1.agregar(6,96);
        dic2.agregar(1,31);
        dic2.agregar(2,45);
        dic2.agregar(3,59);
        dic2.agregar(4,4);
        dic2.agregar(5,2);
        dic2.agregar(6,74);
        OperacionesConjunto op = new OperacionesConjunto();
        op.mostrarConjunto(dic1.claves());
        op.mostrarConjunto(dic2.claves());
        main.juntarDiccionarios(dic1,dic2,dicUnion);
        op.mostrarConjunto(dicUnion.claves());



    }
    public void juntarDiccionarios(DiccionarioMultipleTDA dic1, DiccionarioMultipleTDA dic2, DiccionarioMultipleTDA dicUnion ){
        ConjuntoTDA claves = dic1.claves();

        while(!claves.conjuntoVacio()){
            int clave = claves.elegir();
            claves.sacar(clave);
            ConjuntoTDA valores = dic1.recuperar(clave);
            while(!valores.conjuntoVacio()){
                int valor = valores.elegir();
                valores.sacar(valor);
                dicUnion.agregar(clave,valor);
            }
        }
        claves = dic2.claves();
        while(!claves.conjuntoVacio()){
            int clave = claves.elegir();
            claves.sacar(clave);
            ConjuntoTDA valores = dic2.recuperar(clave);
            while(!valores.conjuntoVacio()){
                int valor = valores.elegir();
                valores.sacar(valor);
                dicUnion.agregar(clave,valor);
            }
        }
    }
}
