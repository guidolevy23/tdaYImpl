package com.uade.clase1;

import java.util.Scanner;

public class Prueba {
    public static void main(String[] args) {
        Prueba p = new Prueba();
        p.execute();
    }
    public void execute(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero");
        int num = sc.nextInt();
        System.out.println("Ingrese un numero");
        int num2 = sc.nextInt();
        int suma = sumar(num,num2);
        System.out.println(suma);
        sc.close();

    }
    private int sumar(int numeroA , int numeroB){
        int suma = numeroA + numeroB;
        return suma;
    }
}
