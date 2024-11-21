package com.uade.app;
import com.uade.impl.DiccionarioSimpleTDAImpl;
import com.uade.implDinamica.DiccionarioSimpleDinamica;
import com.uade.api.DiccionarioSimpleTDA;

import java.sql.SQLOutput;

public class AppDiccionarioSimple {
    public static void main(String[] args) {
        AppDiccionarioSimple app = new AppDiccionarioSimple();
        app.execute();
    }
    public void execute(){
        DiccionarioSimpleTDA diccionarioSimpleTDA = new DiccionarioSimpleDinamica();
        diccionarioSimpleTDA.InicializarDiccionario();
        diccionarioSimpleTDA.Agregar(1,2);
        diccionarioSimpleTDA.Agregar(3,4);
        diccionarioSimpleTDA.Agregar(5,6);
        diccionarioSimpleTDA.Agregar(7,8);
        diccionarioSimpleTDA.Claves();
        System.out.println("Numero: " + diccionarioSimpleTDA.Recuperar(4));
        System.out.println("Numero: " + diccionarioSimpleTDA.Recuperar(5));
        diccionarioSimpleTDA.Agregar(1,85);
        System.out.println("Numero: " + diccionarioSimpleTDA.Recuperar(1));
        diccionarioSimpleTDA.Eliminar(1);
        diccionarioSimpleTDA.Claves();
    }
}
