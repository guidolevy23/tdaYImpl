package com.uade.app;
import com.uade.api.DiccionarioSimpleTDA;
import com.uade.impl.ConjuntoTDAImpl;
import com.uade.impl.DiccionarioMultipleTDAImpl;
import com.uade.implDinamica.DiccionarioMultipleDinamica;
import com.uade.util.OperacionesConjunto;
import com.uade.api.DiccionarioMultipleTDA;
import com.uade.api.ConjuntoTDA;

public class AppDiccionarioMultiple {
    public static void main(String[] args) {
        AppDiccionarioMultiple appDiccionarioMultiple = new AppDiccionarioMultiple();
        appDiccionarioMultiple.excecuteB();
    }
    public void execute(){
        DiccionarioMultipleTDA diccionarioMultipleTDA = new DiccionarioMultipleDinamica();
        OperacionesConjunto operacionesConjunto = new OperacionesConjunto();
        diccionarioMultipleTDA.inicializarDiccionario();
        diccionarioMultipleTDA.agregar(1,2);
        diccionarioMultipleTDA.agregar(3,4);
        diccionarioMultipleTDA.agregar(3,6);
        diccionarioMultipleTDA.agregar(1,8);
        diccionarioMultipleTDA.agregar(3,9);
//        ConjuntoTDA conjuntoTDA = diccionarioMultipleTDA.recuperar(3);
//        operacionesConjunto.mostrarConjunto(conjuntoTDA);
        ConjuntoTDA conjuntoTDA = diccionarioMultipleTDA.recuperar(1);
        operacionesConjunto.mostrarConjunto(conjuntoTDA);
        diccionarioMultipleTDA.eliminarValor(1,2);
        conjuntoTDA = diccionarioMultipleTDA.recuperar(1);
        operacionesConjunto.mostrarConjunto(conjuntoTDA);
        conjuntoTDA = diccionarioMultipleTDA.recuperar(3);
        operacionesConjunto.mostrarConjunto(conjuntoTDA);
        conjuntoTDA = diccionarioMultipleTDA.claves();
        operacionesConjunto.mostrarConjunto(conjuntoTDA);
    }
    public void excecuteB(){
        OperacionesConjunto operacionesConjunto = new OperacionesConjunto();
        DiccionarioMultipleTDA diccionarioMultiple = new DiccionarioMultipleTDAImpl();
        DiccionarioMultipleTDA diccionarioMultiple2 = new DiccionarioMultipleTDAImpl();
        diccionarioMultiple.inicializarDiccionario();
        diccionarioMultiple2.inicializarDiccionario();
        diccionarioMultiple.agregar(1,2);
        diccionarioMultiple.agregar(3,4);
        diccionarioMultiple.agregar(3,6);
        diccionarioMultiple.agregar(1,8);
        diccionarioMultiple.agregar(3,9);

        diccionarioMultiple2.agregar(5,8);
        diccionarioMultiple2.agregar(4,9);
        diccionarioMultiple2.agregar(5,9);
        diccionarioMultiple2.agregar(6,9);
        diccionarioMultiple2.agregar(7,9);
        diccionarioMultiple2.agregar(3,9);
        DiccionarioMultipleTDA diccionarioUnido = unirDiccionariosValoresIguales(diccionarioMultiple,diccionarioMultiple2);
        operacionesConjunto.mostrarConjunto(diccionarioUnido.claves());
        operacionesConjunto.mostrarConjunto(diccionarioUnido.recuperar(3));
    }
    private DiccionarioMultipleTDA unirDiccionarios(DiccionarioMultipleTDA diccionario, DiccionarioMultipleTDA diccionario2){
        DiccionarioMultipleTDA union = new DiccionarioMultipleTDAImpl();
        union.inicializarDiccionario();
        ConjuntoTDA conjuntoClaves = diccionario.claves();
        ConjuntoTDA conjuntoClaves2 = diccionario2.claves();
        while (!conjuntoClaves.conjuntoVacio()){
            int num = conjuntoClaves.elegir();
            ConjuntoTDA valores = diccionario.recuperar(num);
            while(!valores.conjuntoVacio()){
                int valor = valores.elegir();
                valores.sacar(valor);
                union.agregar(num, valor);
            }
            diccionario.eliminar(num);
        }
        while (!conjuntoClaves2.conjuntoVacio()){
            int num = conjuntoClaves2.elegir();
            ConjuntoTDA valores2 = diccionario2.recuperar(num);
            while(!valores2.conjuntoVacio()){
                int valor = valores2.elegir();
                valores2.sacar(valor);
                union.agregar(num, valor);
            }
            diccionario2.eliminar(num);
        }
        return union;
    }
    private DiccionarioMultipleTDA unirDiccionariosClavesIguales(DiccionarioMultipleTDA diccionario, DiccionarioMultipleTDA diccionario2){
        DiccionarioMultipleTDA union = new DiccionarioMultipleTDAImpl();
        union.inicializarDiccionario();
        ConjuntoTDA conjuntoClaves = diccionario.claves();
        ConjuntoTDA conjuntoClaves2 = diccionario2.claves();
        while (!conjuntoClaves.conjuntoVacio()){
            int clave = conjuntoClaves.elegir();
            if(conjuntoClaves2.pertenece(clave)){
                ConjuntoTDA valores = diccionario.recuperar(clave);
                while(!valores.conjuntoVacio()){
                    int valor = valores.elegir();
                    valores.sacar(valor);
                    union.agregar(clave, valor);
                }
            }
            diccionario.eliminar(clave);
        }
        while (!conjuntoClaves2.conjuntoVacio()){
            int num = conjuntoClaves2.elegir();
            if(union.claves().pertenece(num)){
                ConjuntoTDA valores = diccionario2.recuperar(num);
                while(!valores.conjuntoVacio()){
                    int valor = valores.elegir();
                    valores.sacar(valor);
                    union.agregar(num, valor);
                }
            }
            diccionario2.eliminar(num);
        }
        return union;
    }
    private DiccionarioMultipleTDA unirDiccionariosValoresIguales(DiccionarioMultipleTDA diccionario, DiccionarioMultipleTDA diccionario2){
        DiccionarioMultipleTDA union = new DiccionarioMultipleTDAImpl();
        union.inicializarDiccionario();
        ConjuntoTDA conjuntoClaves = diccionario.claves();
        ConjuntoTDA conjuntoClaves2 = diccionario2.claves();
        while (!conjuntoClaves.conjuntoVacio()){
            int clave = conjuntoClaves.elegir();
            if(conjuntoClaves2.pertenece(clave)){
                ConjuntoTDA valores2 = diccionario2.recuperar(clave);
                ConjuntoTDA valores = diccionario.recuperar(clave);
                while(!valores.conjuntoVacio()){
                    int valor = diccionario.recuperar(clave).elegir();
                    valores.sacar(valor);
                    if(valores2.pertenece(valor)){
                        union.agregar(clave,valor);
                    }
                }
            }
            diccionario.eliminar(clave);
        }
        while (!conjuntoClaves2.conjuntoVacio()) {
            int clave = conjuntoClaves2.elegir();
            if (union.claves().pertenece(clave)) {
                ConjuntoTDA valores = union.recuperar(clave);
                ConjuntoTDA valores2 = diccionario2.recuperar(clave);
                while (!valores2.conjuntoVacio()) {
                    int valor = diccionario2.recuperar(clave).elegir();
                    valores2.sacar(valor);
                    if(valores.pertenece(valor)){
                        union.agregar(clave,valor);
                    }
                }
            }
            diccionario2.eliminar(clave);
        }
        return union;
    }
    private DiccionarioMultipleTDA diccionarioSimpleConMultiple(DiccionarioMultipleTDA diccionarioMultiple, DiccionarioSimpleTDA diccionarioSimple, int clave){
        return diccionarioMultiple;
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
