package com.uade.clase1;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        fibonacci.excecute();

    }
    public void excecute(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero: ");
        int numero = sc.nextInt();
        calculadorFibonacci(numero);
        sc.close();

    }
    private void calculadorFibonacci(int numero){
        int suma = 1;
        int muestra2 = 1;
        int anterior = 1;
        for (int i = 1; i <= numero; i++) {
            System.out.print(muestra2 + " ");
            muestra2 = suma + anterior;
            anterior = suma;
            suma = muestra2;
        }
    }

}
