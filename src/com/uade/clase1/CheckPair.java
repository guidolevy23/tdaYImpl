package com.uade.clase1;

/**
 * Comentario en bloque
 */

import java.util.Scanner;

//Clase llamada CheckPair la cual es publica, osea pueden acceder todos
public class CheckPair {
    //void es tipo metodo el cual se llama main y en este caso esta creando una nueva instancia de CheckPair que se la llama poniendo CheckPair cp y new CheckPair
    public static void main(String[] args) {
        CheckPair cp = new CheckPair();
        // con cp es la nueva instancia la cual tiene un metodo excecute
        cp.execute();
    }
    // metodo publico nuevo execute
    public void execute(){
        //esta es la manera de escuchar de la consola. System.in es la consola
        Scanner scanner = new Scanner(System.in);

        //le mostramos un mensaje para que el usuario lo lea y entienda lo que tiene que hacer
        System.out.println("Escriba un numero: ");
        //aca lo que hago es guardar en una variable number que es del tipo int, lo que scanner hace es leer y que guarde ahi el proximo int
        int number = scanner.nextInt();

        // llamo a la funcion checkNumber pasandole un numero
        checkNumber(number);

        // para cerrar la escucha del scanner
        scanner.close();
    }
    // metodo privado checkNumber que recibe un numero int el cual chequea con un if si es par o impar y lo imprime con system.out.println
    private void checkNumber(int number){
        if(number % 2 == 0){
            System.out.println("El numero " + number + " es par");
        } else {
            System.out.println("El numero " + number + " es impar");
        }
    }
}
