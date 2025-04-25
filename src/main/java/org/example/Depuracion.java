package org.example;

import java.util.Scanner;

public class Depuracion {

    public int pedirNumero() {
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        int numero = 0;
        do {
            try {
                flag = true;
                numero = sc.nextInt();
            } catch (Exception e) {
                sc.nextLine();
                numero = 0;
                System.out.println("ERROR");
                System.out.println("Introduzca un numero");
                flag = false;
            }
        } while (!flag);
        return numero;
    }
    public float pedirNumeroFloat() {
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        float numero = 0;
        do {
            try {
                flag = true;
                numero = sc.nextFloat();
            } catch (Exception e) {
                sc.nextLine();
                numero = 0;
                System.out.println("ERROR");
                System.out.println("Introduzca un numero");
                flag = false;
            }
        } while (!flag);
        return numero;
    }
}
