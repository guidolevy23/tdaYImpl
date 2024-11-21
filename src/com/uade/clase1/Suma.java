package com.uade.clase1;

import java.util.Scanner;

public class Suma {
    public static void main(String[] args) {
        Suma suma = new Suma();
        suma.execute();

    }

    public void execute(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el primer numero: ");
        int numero1 = scanner.nextInt();

        System.out.print("Ingrese el segundo numero: ");
        int numero2 = scanner.nextInt();

        sumarNumeros(numero1, numero2);
        scanner.close();
    }

    private void sumarNumeros(int numero1, int numero2) {
        int resultado = numero1 + numero2;
        System.out.println("La suma de " + numero1 + " y de " + numero2 + " es " + resultado);
    }
}
