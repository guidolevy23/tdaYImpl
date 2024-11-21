package com.uade.clase1;

import java.util.Scanner;

public class Temperatura {
    public static void main(String[] args) {
        Temperatura t = new Temperatura();
        t.execute();
    }
    public void execute(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite una temperatura en Celsius: ");
        double temperatura = sc.nextInt();
        temperatura = cambiarTemperatura(temperatura);
        System.out.println("La temperatura en Farenheit es" + temperatura);
        sc.close();
    }
    private double cambiarTemperatura(double temperatura){
        temperatura = (temperatura * 1.8) + 32;
        return temperatura;
    }
}
