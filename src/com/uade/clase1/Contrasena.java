package com.uade.clase1;

import java.util.Scanner;

public class Contrasena {
    public static void main(String[] args) {
        Contrasena contra = new Contrasena();
        contra.excecute();
    }
    public void excecute() {
        String primera;
        String segunda;
        primera = pedirClave("Escriba la contresenia: ");
        segunda = pedirClave("Reescriba la contresenia: ");
        checkEquality(primera, segunda);
    }
    private String pedirClave(String mensaje) {
        Scanner sc = new Scanner(System.in);
        System.out.println(mensaje);
        return sc.next();
    }
    private void checkEquality(String primera, String segunda) {
        if (primera.equals(segunda)) {
            System.out.println("Contrasenias iguales");
        }
        else {
            System.out.println("Contrasenias no iguales");
        }
    }




}
